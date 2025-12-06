extends CharacterBody2D

const SPEED = 400.0
const JUMP_VELOCITY = -550.0
const GRAVITY = 1400.0

@onready var sprite = $AnimatedSprite2D
@onready var collision_shape = $CollisionShape2D
var is_hurt = false

var default_collider_x: float

func _ready():
	default_collider_x = collision_shape.position.x

func _physics_process(delta):
	if not is_on_floor():
		velocity.y += GRAVITY * delta

	if GameManager.is_game_over:
		collision_shape.set_deferred("disabled", true)
		velocity.x = move_toward(velocity.x, 0, SPEED)
		sprite.play("hurt")
		move_and_slide()
		return

	if Input.is_action_just_pressed("up") and is_on_floor() and not is_hurt:
		velocity.y = JUMP_VELOCITY

	var direction = Input.get_axis("left", "right")
	
	if direction and not is_hurt:
		velocity.x = direction * SPEED
		
		var target_offset_x = 0.0
		var should_flip = false
		
		if direction < 0:
			should_flip = true
			target_offset_x = -default_collider_x
		elif direction > 0:
			should_flip = false
			target_offset_x = default_collider_x
			
		if collision_shape.position.x != target_offset_x:
			var move_vec = Vector2(target_offset_x - collision_shape.position.x, 0)
			if not test_move(global_transform, move_vec):
				sprite.flip_h = should_flip
				collision_shape.position.x = target_offset_x
			
	elif not is_hurt:
		velocity.x = move_toward(velocity.x, 0, SPEED)

	_update_animations(direction)
	move_and_slide()
	_check_enemy_collision()

func _update_animations(direction):
	if is_hurt:
		sprite.play("hurt")
		sprite.modulate = Color(1, 0, 0, 0.7)
		return

	sprite.modulate = Color(1, 1, 1, 1)

	if not is_on_floor():
		sprite.play("jump")
		sprite.speed_scale = 1.0 
	elif direction != 0:
		sprite.play("run")
		sprite.speed_scale = abs(velocity.x) / SPEED 
	else:
		sprite.play("idle")
		sprite.speed_scale = 1.0

func bounce():
	velocity.y = JUMP_VELOCITY * 0.8

func _check_enemy_collision():
	if is_hurt: return
	
	for i in get_slide_collision_count():
		var collision = get_slide_collision(i)
		var collider = collision.get_collider()
		
		if collider.is_in_group("enemies"):
			if velocity.y > 0 and global_position.y < collider.global_position.y - 10:
				return 
			
			hurt()

func hurt():
	is_hurt = true
	GameManager.add_time(-5.0)
	
	velocity.y = -300
	velocity.x = -200 if sprite.flip_h else 200 
	
	await get_tree().create_timer(0.5).timeout
	is_hurt = false

extends CharacterBody2D

@export var speed = 100.0
@export var gravity = 980.0
@export var time_bonus_scene: PackedScene

var direction = -1
var is_dying = false

@onready var floor_detector = $RayCast2D
@onready var sprite = $AnimatedSprite2D
@onready var weak_spot = $WeakSpot
@onready var collision_shape = $CollisionShape2D
@onready var weak_spot_shape = $WeakSpot/CollisionShape2D

var default_raycast_x: float
var default_collision_x: float
var default_weakspot_x: float

func _ready():
	default_raycast_x = abs(floor_detector.position.x)
	default_collision_x = abs(collision_shape.position.x)
	default_weakspot_x = abs(weak_spot_shape.position.x)
	
	if direction == -1:
		sprite.flip_h = true
		sprite.offset.x = -17
		floor_detector.position.x = -default_raycast_x
		collision_shape.position.x = -default_collision_x
		weak_spot_shape.position.x = -default_weakspot_x
	else:
		sprite.flip_h = false
		sprite.offset.x = 0
		floor_detector.position.x = default_raycast_x
		collision_shape.position.x = default_collision_x
		weak_spot_shape.position.x = default_weakspot_x

func _physics_process(delta):
	if is_dying:
		velocity.x = 0
		velocity.y += gravity * delta
		move_and_slide()
		return

	if not is_on_floor():
		velocity.y += gravity * delta
	
	velocity.x = speed * direction
	
	move_and_slide()
	
	if is_on_wall():
		flip_direction()
	
	if is_on_floor() and not floor_detector.is_colliding():
		flip_direction()
		
	if velocity.x != 0:
		sprite.play("walk")
	
	if not is_dying:
		_check_player_collision()

func flip_direction():
	direction *= -1
	
	if direction > 0:
		sprite.flip_h = false
		sprite.offset.x = 0
		floor_detector.position.x = default_raycast_x
		collision_shape.position.x = default_collision_x
		weak_spot_shape.position.x = default_weakspot_x
	else:
		sprite.flip_h = true
		sprite.offset.x = -17
		floor_detector.position.x = -default_raycast_x
		collision_shape.position.x = -default_collision_x
		weak_spot_shape.position.x = -default_weakspot_x

func die():
	if is_dying: return
	is_dying = true
	
	speed = 0
	collision_shape.set_deferred("disabled", true)
	weak_spot.queue_free()
	
	sprite.play("die")
	
	if time_bonus_scene:
		call_deferred("spawn_bonus")
	
	await get_tree().create_timer(0.5).timeout
	queue_free()

func spawn_bonus():
	var bonus = time_bonus_scene.instantiate()
	bonus.global_position = global_position
	get_parent().add_child(bonus)

func _on_weak_spot_body_entered(body):
	if body.name == "Player":
		collision_shape.set_deferred("disabled", true)
		body.bounce()
		die()

func _check_player_collision():
	for i in get_slide_collision_count():
		var collision = get_slide_collision(i)
		var collider = collision.get_collider()
		
		if collider.name == "Player":
			if collider.has_method("hurt"):
				collider.hurt()

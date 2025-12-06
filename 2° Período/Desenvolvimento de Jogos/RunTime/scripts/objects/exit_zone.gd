extends Area2D

@onready var sprite = $AnimatedSprite2D
var is_triggered = false

func _ready():
	body_entered.connect(_on_body_entered)
	sprite.play("idle")

func _on_body_entered(body):
	if body.name == "Player" and not is_triggered:
		is_triggered = true
		sprite.play("open")
		await sprite.animation_finished
		GameManager.win()

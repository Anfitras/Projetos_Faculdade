extends Area2D

@export var time_amount = 5.0
@onready var sprite = $AnimatedSprite2D

func _ready():
	body_entered.connect(_on_body_entered)
	
	sprite.play("default")

func _on_body_entered(body):
	if body.name == "Player":
		GameManager.add_time(time_amount)
		queue_free()

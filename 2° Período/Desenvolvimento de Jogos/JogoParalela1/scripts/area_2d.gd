extends Area2D


# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta: float) -> void:
	pass
	
func _on_body_entered(body: Node2D) -> void:
	var scene = get_tree().current_scene
	
	if scene.name == "cena_01" and body.name == "player1":
		print("Player 1 venceu!")
		get_tree().reload_current_scene()
		
	elif scene.name == "cena_01" and body.name == "player2":
		print("Player 2 venceu!")
		get_tree().reload_current_scene()

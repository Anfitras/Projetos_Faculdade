extends CanvasLayer

func _on_btn_retry_pressed():
	GameManager.reset_stats()
	get_tree().paused = false 
	queue_free()
	get_tree().reload_current_scene()

func _on_btn_menu_pressed():
	GameManager.reset_stats()
	get_tree().paused = false 
	queue_free()
	get_tree().change_scene_to_file("res://scenes/ui/main_menu.tscn")

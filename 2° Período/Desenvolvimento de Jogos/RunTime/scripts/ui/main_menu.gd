extends Control

@onready var help_panel = $HelpPanel

func _ready():
	Input.set_mouse_mode(Input.MOUSE_MODE_VISIBLE)
	help_panel.visible = false

func _on_btn_play_pressed():
	GameManager.reset_stats()
	get_tree().change_scene_to_file("res://scenes/levels/level_01.tscn")

func _on_btn_quit_pressed():
	get_tree().quit()

func _on_btn_help_pressed():
	help_panel.visible = true

func _on_btn_close_help_pressed():
	help_panel.visible = false

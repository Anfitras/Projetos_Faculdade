extends Node

var time_left = 40.0
var max_time = 60.0
var is_game_over = false

var victory_screen_scene = preload("res://scenes/ui/victory_screen.tscn")
var game_over_screen_scene = preload("res://scenes/ui/game_over_screen.tscn")

func _process(delta):
	if is_game_over: return

	time_left -= delta
	
	if time_left <= 0:
		die()

func add_time(amount):
	if is_game_over or amount == null: return
	time_left += amount
	if time_left > max_time:
		time_left = max_time

func die():
	if is_game_over: return
	is_game_over = true
	
	var game_over_instance = game_over_screen_scene.instantiate()
	get_tree().root.add_child(game_over_instance)

func win():
	if is_game_over: return
	is_game_over = true
	
	get_tree().paused = true 
	
	var victory_instance = victory_screen_scene.instantiate()
	get_tree().root.add_child(victory_instance)

func reset_stats():
	time_left = 30.0
	is_game_over = false

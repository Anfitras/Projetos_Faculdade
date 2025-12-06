extends Label

func _process(_delta):
	text = "TEMPO: " + str("%0.1f" % GameManager.time_left)

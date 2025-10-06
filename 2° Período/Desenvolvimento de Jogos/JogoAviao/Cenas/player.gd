extends CharacterBody2D
# Variáveis para a suavização do movimento do avião
@export var maxSpeed: float = 300.0
@export var acceleration: float = 2000.0
@export var friction: float = 1200.0
# Variáveis para o movimento do avião
var currentvelocity: Vector2 = Vector2.ZERO
var inputVector: Vector2 = Vector2.ZERO

func _physics_process(delta: float) -> void:
	## Capiturando os inputs do movimento do avião
	inputVector = Input.get_vector("moveLeft", "moveRight", "moveUp", "moveDown")
	## Verificar se o usuário pressionou algo
	#if inputVector != Vector2.ZERO:
		#currentvelocity = currentvelocity.move_toward(inputVector * maxSpeed, acceleration * delta)
	#else:
		#currentvelocity = currentvelocity.move_toward(Vector2.ZERO, friction * delta)
	#
	#velocity = currentvelocity
	movePlane(delta)
	
	move_and_slide()

func movePlane(delta):
	# Verificar se o usuário pressionou algo
	if inputVector != Vector2.ZERO:
		currentvelocity = currentvelocity.move_toward(inputVector * maxSpeed, acceleration * delta)
	else:
		currentvelocity = currentvelocity.move_toward(Vector2.ZERO, friction * delta)
	
	velocity = currentvelocity

class Atendimento {
  #nome;
  #cpf;
  #data;
  #hora;
  #idade;
  #ordemChegada;

  constructor(nome, cpf, data, hora, idade, ordemChegada = 0) {
    this.#nome = nome;
    this.#cpf = cpf;
    this.#data = data;
    this.#hora = hora;
    this.#idade = idade;
    this.#ordemChegada = ordemChegada;
  }

  get nome() {
    return this.#nome;
  }

  get cpf() {
    return this.#cpf;
  }

  get data() {
    return this.#data;
  }

  get hora() {
    return this.#hora;
  }

  get idade() {
    return this.#idade;
  }

  get ordemChegada() {
    return this.#ordemChegada;
  }

  set nome(nome) {
    this.#nome = nome;
  }
  set cpf(cpf) {
    this.#cpf = cpf_;
  }
  set data(data) {
    this.#data = data;
  }
  set hora(hora) {
    this.#hora = hora;
  }
  set idade(idade) {
    this.#idade = idade;
  }
  set ordemChegada(ordemChegada) {
    this.#ordemChegada = ordemChegada;
  }

  toString() {
    return `${this.#nome} | ${this.#cpf} | ${this.#data} | ${this.#hora} | ${this.#idade}`;
  }
}

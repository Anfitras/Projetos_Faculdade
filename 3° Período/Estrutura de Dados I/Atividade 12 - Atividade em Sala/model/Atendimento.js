class Atendimento {
  #nome;
  #cpf;
  #data;
  #hora;
  #idade;

  constructor(nome, cpf, data, hora, idade) {
    this.#nome = nome;
    this.#cpf = cpf;
    this.#data = data;
    this.#hora = hora;
    this.#idade = idade;
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

  toString() {
    return `${this.#nome} | ${this.#cpf} | ${this.#data} | ${this.#hora} | ${this.#idade}`;
  }
}

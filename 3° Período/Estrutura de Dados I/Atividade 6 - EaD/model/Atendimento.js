class Atendimento {
  #nome;
  #cpf;
  #data;
  #hora;

  constructor(nome, cpf) {
    const agora = new Date();
    this.#nome = nome;
    this.#cpf = cpf;
    this.#data = agora.toLocaleDateString("pt-BR");
    this.#hora = agora.toLocaleTimeString("pt-BR");
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
}

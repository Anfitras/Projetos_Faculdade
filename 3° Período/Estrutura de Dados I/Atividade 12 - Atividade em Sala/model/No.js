class No {
  #dado;
  #proximo;

  constructor(nDado) {
    this.#dado = nDado;
    this.#proximo = null;
  }

  get dado() {
    return this.#dado;
  }

  get proximo() {
    return this.#proximo;
  }

  set dado(nDado) {
    this.#dado = nDado;
  }

  set proximo(nProximo) {
    this.#proximo = nProximo;
  }

  toString() {
    return this.#dado.toString();
  }
}

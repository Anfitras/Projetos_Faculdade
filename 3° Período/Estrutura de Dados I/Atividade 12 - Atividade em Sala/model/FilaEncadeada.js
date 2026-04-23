class FilaEncadeada {
  #inicio;
  #fim;
  #qtd;

  constructor() {
    this.#inicio = null;
    this.#fim = null;
    this.#qtd = 0;
  }

  isEmpty() {
    return this.#inicio === null;
  }

  enqueue(novoElemento) {
    const novoNo = new No(novoElemento);

    if (this.isEmpty()) {
      this.#inicio = novoNo;
    } else {
      this.#fim.proximo = novoNo;
    }

    this.#fim = novoNo;
    this.#qtd++;

    console.log(`Adicionado:${novoElemento}`);
    console.log(`Quantidade:${this.#qtd}`);

    return true;
  }

  dequeue() {
    if (!this.isEmpty()) {
      let removido = this.#inicio.dado;

      this.#inicio = this.#inicio.proximo;
      this.#qtd--;

      console.log(`Removido: ${removido}`);
      console.log(`Quantidade: ${this.#qtd}`);

      return removido;
    }
    return null;
  }

  toString() {
    let resultado = "";
    let aux = this.#inicio;

    while (aux !== null) {
      resultado += aux.dado + " | ";
      aux = aux.proximo;
    }

    return resultado;
  }

  [Symbol.iterator]() {
    let aux = this.#inicio;

    return {
      next() {
        if (aux !== null) {
          const value = aux.dado;
          aux = aux.proximo;
          return { value, done: false };
        } else {
          return { done: true };
        }
      },
    };
  }
}

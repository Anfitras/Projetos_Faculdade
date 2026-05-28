class Fila {
  #inicio;
  #fim;
  #qnt;
  #elementos;

  constructor(tamanho = 10) {
    this.#fim = -1;
    this.#inicio = 0;
    this.#qnt = 0;
    this.#elementos = new Array(tamanho);
  }

  isFull() {
    return this.#qnt === this.#elementos.length;
  }

  isEmpty() {
    return this.#qnt === 0;
  }

  enqueue(valor) {
    if (this.isFull()) {
      return false;
    }

    this.#fim = (this.#fim + 1) % this.#elementos.length;
    this.#elementos[this.#fim] = valor;
    this.#qnt++;
    return true;
  }

  dequeue() {
    if (this.isEmpty()) {
      return null;
    }

    const valor = this.#elementos[this.#inicio];
    this.#elementos[this.#inicio] = undefined;
    this.#inicio = (this.#inicio + 1) % this.#elementos.length;
    this.#qnt--;
    return valor;
  }
}

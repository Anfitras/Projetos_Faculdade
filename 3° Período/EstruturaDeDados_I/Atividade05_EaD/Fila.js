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

  enqueue(elemento) {
    if (!this.isFull()) {
      if (this.#fim === this.#elementos.length - 1) {
        this.#fim = 0;
      } else {
        this.#fim++;
      }
      this.#elementos[this.#fim] = elemento;
      this.#qnt++;
      console.log(
        `enqueue: início=${this.#inicio}, fim=${this.#fim}, qnt=${this.#qnt}`,
      );
      return true;
    }
    return false;
  }

  dequeue() {
    if (this.isEmpty()) return null;
    let removido = this.#elementos[this.#inicio];
    this.#elementos[this.#inicio] = undefined;

    if (this.#inicio === this.#elementos.length - 1) {
      this.#inicio = 0;
    } else {
      this.#inicio++;
    }

    this.#qnt--;
    console.log(`Removido: ${removido}`);
    console.log(
      `dequeue: início=${this.#inicio}, fim=${this.#fim}, qnt=${this.#qnt}`,
    );
    return removido;
  }

  first() {
    if (!this.isEmpty()) {
      return this.#elementos[this.#inicio];
    }
    return null;
  }

  last() {
    if (!this.isEmpty()) {
      return this.#elementos[this.#fim];
    }
    return null;
  }

  toString() {
    let resultado = "";
    for (let i = 0; i < this.#qnt; i++) {
      let indice = this.#inicio + i;
      if (indice >= this.#elementos.length) {
        indice = indice - this.#elementos.length;
      }
      resultado += `${this.#elementos[indice]} | `;
    }
    return resultado;
  }
}

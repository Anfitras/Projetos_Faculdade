class LinkedList {
  #head;
  #tail;
  #qtd;

  constructor() {
    this.#head = null;
    this.#tail = null;
    this.#qtd = 0;
  }

  isEmpty() {
    return this.#head === null;
  }

  get length() {
    return this.#qtd;
  }

  addFirst(novoDado) {
    const novoNo = new No(novoDado);

    if (this.isEmpty()) this.#tail = novoNo;
    else {
      novoNo.proximo = this.#head;
      this.#head.anterior = novoNo;
    }

    this.#head = novoNo;
    this.#qtd++;
    return true;
  }

  addLast(novoDado) {
    const novoNo = new No(novoDado);

    if (this.isEmpty()) this.#head = novoNo;
    else {
      novoNo.anterior = this.#tail;
      this.#tail.proximo = novoNo;
    }

    this.#tail = novoNo;
    this.#qtd++;
    return true;
  }

  addAtIndex(novoDado, posicao) {
    if (this.isEmpty() || posicao <= 0) return this.addFirst(novoDado);
    if (posicao >= this.#qtd) return this.addLast(novoDado);

    const novoNo = new No(novoDado);
    let aux = this.#head; // aux sai do inicio
    let posAtual = 0;

    while (posAtual < posicao - 1) {
      aux = aux.proximo;
      posAtual++;
    }

    novoNo.anterior = aux;
    novoNo.proximo = aux.proximo;
    aux.proximo = novoNo;
    novoNo.proximo.anterior = novoNo;
    this.#qtd++;

    return true;
  }

  removeFirst() {
    if (this.isEmpty()) return null;

    const dadoRemovido = this.#head.dado;
    this.#head = this.#head.proximo;

    if (this.#head === null) this.#tail = null;
    else this.#head.anterior = null;

    this.#qtd--;
    return dadoRemovido;
  }

  removeAtIndex(posicao) {
    if (this.isEmpty() || posicao < 0 || posicao >= this.#qtd) {
      return null;
    }

    if (posicao === 0) {
      return this.removeFirst();
    }

    let aux = this.#head;
    let posAtual = 0;

    while (posAtual < posicao) {
      aux = aux.proximo;
      posAtual++;
    }

    const dadoRemovido = aux.dado;

    if (aux === this.#tail) {
      this.#tail = aux.anterior;
      this.#tail.proximo = null;
    } else {
      aux.anterior.proximo = aux.proximo;
      aux.proximo.anterior = aux.anterior;
    }

    this.#qtd--;
    return dadoRemovido;
  }

  getFirst() {
    if (this.isEmpty()) {
      return null;
    }

    return this.#head.dado;
  }

  getLast() {
    if (this.isEmpty()) {
      return null;
    }

    return this.#tail.dado;
  }

  [Symbol.iterator]() {
    let noAtual = this.#head;
    return {
      next: function () {
        if (noAtual !== null) {
          let valor = noAtual.dado;
          noAtual = noAtual.proximo;
          return { value: valor, done: false };
        } else {
          return { done: true };
        }
      },
    };
  }

  toString() {
    let noAtual = this.#head;
    let retorno = "";

    while (noAtual != null) {
      retorno += " | " + noAtual.dado;
      noAtual = noAtual.proximo;
    }

    return retorno;
  }
}

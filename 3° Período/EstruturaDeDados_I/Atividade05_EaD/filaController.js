const minhaFila = new Fila(5);

function adicionarElemento() {
  const novoElemento = document.getElementById("txtnovoNome");

  if (minhaFila.enqueue(novoElemento.value)) {
    novoElemento.value = "";
    novoElemento.focus();
    mostrarFila();
  } else {
    alert("Fila Cheia!");
  }
}

function removerElemento() {
  const elementoRemovido = minhaFila.dequeue();

  if (elementoRemovido !== null) {
    alert("Elemento removido: " + elementoRemovido);
    mostrarFila();
  } else {
    alert("Fila Vazia!");
  }
}

function mostrarFila() {
  const listaFila = document.getElementById("listFila");
  listaFila.innerHTML = "";

  const itens = minhaFila
    .toString()
    .split(" | ")
    .filter((item) => item.trim() !== "");

  for (const item of itens) {
    const li = document.createElement("li");
    li.textContent = item;
    listaFila.appendChild(li);
  }
}

const minhaFila = new Fila(5);

function adicionarElemento() {
  const campoNome = document.getElementById("txtnovoNome");
  const campoCpf = document.getElementById("txtCpf");
  const nome = campoNome.value.trim();
  const cpf = campoCpf.value.trim();

  if (nome === "" || cpf === "") {
    alert("Informe nome e CPF.");
    return;
  }

  if (!/^[A-Za-zÀ-ÖØ-öø-ÿ ]+$/.test(nome)) {
    alert("O nome deve conter apenas letras.");
    campoNome.focus();
    return;
  }

  if (!/^\d+$/.test(cpf)) {
    alert("O CPF deve conter apenas numeros.");
    campoCpf.focus();
    return;
  }

  if (cpf.length !== 11) {
    alert("O CPF deve ter exatamente 11 caracteres.");
    campoCpf.focus();
    return;
  }

  const atendimento = new Atendimento(nome, cpf);
  if (minhaFila.enqueue(atendimento)) {
    mostrarFila(); // mostrar a fila
    campoNome.value = "";
    campoCpf.value = "";
    campoNome.focus();
  } else {
    alert("Fila cheia!");
  }
}

function mostrarFila() {
  const filaElemento = document.getElementById("listFila");
  const filaCardBody = document.getElementById("filaCardBody");
  filaElemento.innerHTML = "";

  if (minhaFila.isEmpty()) {
    filaCardBody.classList.add("d-none");
    return;
  }

  filaCardBody.classList.remove("d-none");

  for (let item of minhaFila) {
    const linha = document.createElement("tr");
    linha.innerHTML = `
      <td>${item.nome}</td>
      <td>${item.cpf}</td>
      <td>${item.data}</td>
      <td>${item.hora}</td>
    `;
    filaElemento.appendChild(linha);
  }
}

function removerElemento() {
  let removido = minhaFila.dequeue();
  if (removido === null) alert("Fila vazia");
  else {
    alert(
      `Atendido: ${removido.nome} | ${removido.cpf} | ${removido.data} | ${removido.hora}`,
    );
    mostrarFila();
  }
}

function buscarElemento() {
  const busca = document.getElementById("txtnovoNome");
  const termo = busca.value.trim();
  let encontrado = false;
  for (let item of minhaFila) {
    if (termo === item.nome || termo === item.cpf) {
      alert("Encontrado na fila");
      encontrado = true;
      break;
    }
  }
  if (!encontrado) alert("Pessoa não está na fila");
} // fim funcao busca

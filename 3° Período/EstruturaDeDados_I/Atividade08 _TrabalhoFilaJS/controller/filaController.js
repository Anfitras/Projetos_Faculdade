const minhaFila = new Fila(5);

function adicionarElemento() {
  const nome = document.getElementById("txtnovoNome");
  const cpf = document.getElementById("txtnovoCPF");
  const data = obterDataAtual();
  const hora = obterHoraAtual();
  const novoAtendimento = new Atendimento(nome.value, cpf.value, data, hora);
  if (minhaFila.enqueue(novoAtendimento)) {
    mostrarFila();
    nome.value = "";
    cpf.value = "";
    nome.focus();
  } else {
    alert("Fila cheia!");
  }
}

function mostrarFila() {
  const filaElemento = document.getElementById("listFila");
  filaElemento.innerHTML = "";
  for (let item of minhaFila) {
    const listItem = document.createElement("li");
    listItem.textContent = item;
    filaElemento.appendChild(listItem);
  }
}

function removerElemento() {
  let removido = minhaFila.dequeue();

  if (removido === null) {
    alert("Fila vazia");
  } else {
    localStorage.setItem("ultimoAtendido", removido.nome);

    const horaAtendimento = obterHoraAtual();
    const tempoEspera = calcularDiferencaHoras(removido.hora, horaAtendimento);

    const mensagemDiv = document.getElementById("mensagem-remocao");
    mensagemDiv.textContent = `Chamando para ser atendido(a): ${removido.nome}, chegou às ${removido.hora} está sendo atendido às ${horaAtendimento}. Tempo de espera: ${tempoEspera}`;

    mostrarFila();
  }
}

function buscarElemento() {
  const busca = document.getElementById("txtnovoCPF");
  let encontrado = false;
  let posicao = 1;
  for (let atendimento of minhaFila) {
    if (busca.value === atendimento.cpf) {
      alert("CPF encontrado na fila! Posição: " + posicao);
      encontrado = true;
      break;
    }
    posicao++;
  }
  if (!encontrado) alert("Pessoa não está na fila");
}

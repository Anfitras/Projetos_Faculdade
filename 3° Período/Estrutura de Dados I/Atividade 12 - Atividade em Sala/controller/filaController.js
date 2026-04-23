const minhaFila = new FilaEncadeada();
const minhaFilaPrioritaria = new FilaEncadeada();
let qtdNormalDesdeUltimaPrioritaria = 0;
let proximaOrdemChegada = 1;

function adicionarElemento() {
  const nome = document.getElementById("txtnovoNome");
  const cpf = document.getElementById("txtnovoCPF");
  const dataNascimento = document.getElementById("txtnovaData");
  const idade = calcularIdade(dataNascimento.value);
  const data = obterDataAtual();
  const hora = obterHoraAtual();
  const novoAtendimento = new Atendimento(
    nome.value,
    cpf.value,
    data,
    hora,
    idade,
    proximaOrdemChegada++,
  );

  if (idade >= 60) {
    minhaFilaPrioritaria.enqueue(novoAtendimento);
    mostrarFila();
    nome.value = "";
    cpf.value = "";
    dataNascimento.value = "";
    nome.focus();
  } else {
    minhaFila.enqueue(novoAtendimento);
    mostrarFila();
    nome.value = "";
    cpf.value = "";
    dataNascimento.value = "";
    nome.focus();
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

  const filaPrioritariaElemento = document.getElementById("listFilaPrioridade");
  filaPrioritariaElemento.innerHTML = "";
  for (let item of minhaFilaPrioritaria) {
    const listItem = document.createElement("li");
    listItem.textContent = item;
    filaPrioritariaElemento.appendChild(listItem);
  }
}

function removerElemento() {
  let removido = null;
  const filaNormalVazia = minhaFila.isEmpty();
  const filaPrioritariaVazia = minhaFilaPrioritaria.isEmpty();

  if (filaNormalVazia && filaPrioritariaVazia) {
    qtdNormalDesdeUltimaPrioritaria = 0;
    alert("Filas vazias");
    return;
  }

  if (!filaNormalVazia && !filaPrioritariaVazia) {
    const deveAtenderPrioritaria = qtdNormalDesdeUltimaPrioritaria >= 3;
    const proximoNormal = minhaFila.peek();
    const proximoPrioritario = minhaFilaPrioritaria.peek();

    if (deveAtenderPrioritaria) {
      removido = minhaFilaPrioritaria.dequeue();
      qtdNormalDesdeUltimaPrioritaria = 0;
    } else if (proximoPrioritario.ordemChegada < proximoNormal.ordemChegada) {
      removido = minhaFilaPrioritaria.dequeue();
      qtdNormalDesdeUltimaPrioritaria = 0;
    } else {
      removido = minhaFila.dequeue();
      qtdNormalDesdeUltimaPrioritaria++;
    }
  } else if (!filaNormalVazia) {
    removido = minhaFila.dequeue();
    qtdNormalDesdeUltimaPrioritaria = 0;
  } else {
    removido = minhaFilaPrioritaria.dequeue();
    qtdNormalDesdeUltimaPrioritaria = 0;
  }

  localStorage.setItem("ultimoAtendido", removido.nome);

  const horaAtendimento = obterHoraAtual();
  const tempoEspera = calcularDiferencaHoras(removido.hora, horaAtendimento);

  const mensagemDiv = document.getElementById("mensagem-remocao");
  mensagemDiv.textContent = `Chamando para ser atendido(a): ${removido.nome}, chegou às ${removido.hora} está sendo atendido às ${horaAtendimento}. Tempo de espera: ${tempoEspera}`;

  mostrarFila();
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
  for (let atendimento of minhaFilaPrioritaria) {
    if (busca.value === atendimento.cpf) {
      alert("CPF encontrado na fila! Posição: " + posicao);
      encontrado = true;
      break;
    }
    posicao++;
  }
  if (!encontrado) alert("Pessoa não está na fila");
}

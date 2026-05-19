const minhaLista = new LinkedList();
let indiceSelecionado = null;
//---------------------------------------------------------------------------------------------
function limpaInputs() {
  document.getElementById("txtnovaTarefa").value = "";
  document.getElementById("txtnovaPrioridade").value = "";
  document.getElementById("txtIndice").value = "";
  document.getElementById("txtnovaTarefa").focus();
}
//--------------------------------------------------------------------------------------------
function leiaDadosTarefa() {
  const descricao = document.getElementById("txtnovaTarefa").value.trim();
  const prioridade = document.getElementById("txtnovaPrioridade").value.trim();
  if (descricao === "" || prioridade === "") {
    alert("Preencha os campos de descrição e prioridade!");
    return null;
  }
  return new Tarefa(descricao, prioridade, obterDataAtual(), obterHoraAtual());
}
//--------------------------------------------------------------------------------------------
function adicionarElementoPorPrioridade() {
  const novaTarefa = leiaDadosTarefa();
  if (!novaTarefa) return;
  if (novaTarefa.prioridade >= minhaLista.getLast().prioridade) {
    minhaLista.addLast(novaTarefa);
  } else if (novaTarefa.prioridade < minhaLista.getFirst().prioridade) {
    minhaLista.addFirst(novaTarefa);
  }

  let pos = 0;
  for (const tarefa of minhaLista) {
    if (novaTarefa.prioridade >= tarefa.prioridade) {
      pos++;
    }
  }

  minhaLista.addAtIndex(novaTarefa, pos);

  atualizarLista();
  limpaInputs();
}
//--------------------------------------------------------------------------------------------
function removerElementoInicio() {
  if (minhaLista.isEmpty()) {
    alert("Lista de Tarefas Vazia");
  } else {
    const tarefaRealizada = minhaLista.removeFirst();
    const horaConclusao = obterHoraAtual();
    const tempoConclusao = calcularDiferencaHoras(
      tarefaRealizada.hora,
      horaConclusao,
    );
    const dataConclusao = obterDataAtual();
    const diferencaDias = calcularDiferencaDias(
      tarefaRealizada.data,
      dataConclusao,
    );
    mostrarMensagemRemocaoInicio(
      tarefaRealizada,
      tempoConclusao,
      diferencaDias,
    );
    indiceSelecionado = null;
    atualizarLista();
  }
}
//--------------------------------------------------------------------------------------------
function selecionarTarefa(indice) {
  indiceSelecionado = indice;
  atualizarLista();
}
//--------------------------------------------------------------------------------------------
function removerElementoEspecifico() {
  if (indiceSelecionado === null) {
    alert(
      "Por favor, clique em uma tarefa na lista para selecioná-la antes de remover.",
    );
    return;
  }

  const tarefaRealizada = minhaLista.removeAtIndex(indiceSelecionado);

  mostrarMensagemRemocao(tarefaRealizada);
  indiceSelecionado = null;
  atualizarLista();
}
//--------------------------------------------------------------------------------------------
function mostrarMensagemRemocaoInicio(
  tarefaRealizada,
  tempoConclusao,
  diferencaDias,
) {
  const mensagem = document.getElementById("mensagem-remocao");
  mensagem.innerHTML =
    "Tarefa realizada: " +
    tarefaRealizada.descricao +
    ". Tempo até conclusão - Dias: " +
    diferencaDias +
    " - Hora: " +
    tempoConclusao;
  mensagem.style.display = "block";
}
//--------------------------------------------------------------------------------------------
function mostrarMensagemRemocao(tarefaRealizada) {
  const mensagem = document.getElementById("mensagem-remocao");
  mensagem.innerHTML = "Tarefa realizada: " + tarefaRealizada.descricao;
  mensagem.style.display = "block";
}
//--------------------------------------------------------------------------------------------
function tarefaMaisAntiga() {
  if (minhaLista.isEmpty()) {
    return alert("Lista de Tarefas Vazia");
  }
  let tarefaAntiga = minhaLista.getFirst();
  for (const tarefa of minhaLista) {
    if (
      isMenor(tarefa.data, tarefa.hora, tarefaAntiga.data, tarefaAntiga.hora)
    ) {
      tarefaAntiga = tarefa;
    }
  }
  alert("Tarefa mais antiga: " + tarefaAntiga.toString());
}
//--------------------------------------------------------------------------------------------
function atualizarLista() {
  const listaTarefas = document.getElementById("list_listadeTarefas");
  const lblTarefas = document.getElementById("lblmostraTarefas");

  listaTarefas.innerHTML = "";

  if (!minhaLista.isEmpty()) {
    lblTarefas.innerHTML = "Lista de Tarefas";

    let index = 0;

    for (const tarefa of minhaLista) {
      const novaLinha = document.createElement("li");
      novaLinha.innerHTML = tarefa.toString();
      novaLinha.style.cursor = "pointer";

      if (index === indiceSelecionado) {
        novaLinha.style.fontWeight = "bold";
      }

      let indiceAtual = index;

      novaLinha.onclick = function () {
        selecionarTarefa(indiceAtual);
      };

      listaTarefas.appendChild(novaLinha);
      index++;
    }
  } else {
    lblTarefas.innerHTML = "Lista de Tarefas Vazia";
  }
}

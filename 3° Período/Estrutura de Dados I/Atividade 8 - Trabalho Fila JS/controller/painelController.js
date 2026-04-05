function atualizarUltimoAtendimento() {
  const ultimo = localStorage.getItem("ultimoAtendido");

  document.getElementById("ultimoAtendimento").textContent = ultimo;
}

atualizarUltimoAtendimento();
setInterval(atualizarUltimoAtendimento, 1000);

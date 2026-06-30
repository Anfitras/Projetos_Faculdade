(function () {
  const usuarioLogado = localStorage.getItem("usuarioLogado");

  if (!usuarioLogado) {
    window.location.href = "login.html";
    return;
  }

  const usuario = JSON.parse(usuarioLogado);
  const paginaAtual = window.location.pathname.split("/").pop();

  if (usuario.perfil === "OPERADOR_CAIXA") {
    if (paginaAtual !== "caixa.html" && paginaAtual !== "") {
      window.location.href = "caixa.html";
    }
  }

  document.addEventListener("DOMContentLoaded", () => {
    const nav = document.querySelector("nav ul");
    if (nav) {
      const botaoSair = document.createElement("li");
      botaoSair.innerHTML = '<a href="#" id="btnSair">Sair</a>';
      nav.appendChild(botaoSair);

      document.getElementById("btnSair").addEventListener("click", (e) => {
        e.preventDefault();
        localStorage.removeItem("usuarioLogado");
        window.location.href = "login.html";
      });

      if (usuario.perfil === "OPERADOR_CAIXA") {
        const links = nav.querySelectorAll("li a");
        links.forEach((link) => {
          if (
            link.getAttribute("href") !== "caixa.html" &&
            link.id !== "btnSair"
          ) {
            link.parentElement.style.display = "none";
          }
        });
      }
    }
  });
})();

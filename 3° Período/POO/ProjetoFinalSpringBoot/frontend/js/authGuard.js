(function () {
  const usuarioLogado = localStorage.getItem("usuarioLogado");

  if (!usuarioLogado) {
    window.location.href = "login.html";
    return;
  }

  const usuario = JSON.parse(usuarioLogado);
  const paginaAtual = window.location.pathname.split("/").pop();
  const perfil = usuario.perfil;

  const paginasPermitidas = {
    ADMIN: null,
    GERENTE: ["index.html", ""],
    OPERADOR_CAIXA: ["caixa.html", ""],
  };

  const paginasDoPerfil = paginasPermitidas[perfil];

  if (paginasDoPerfil && !paginasDoPerfil.includes(paginaAtual)) {
    window.location.href =
      perfil === "OPERADOR_CAIXA" ? "caixa.html" : "index.html";
    return;
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

      if (perfil === "OPERADOR_CAIXA" || perfil === "GERENTE") {
        const links = nav.querySelectorAll("li a");
        links.forEach((link) => {
          const href = link.getAttribute("href");
          const linkPermitido =
            perfil === "OPERADOR_CAIXA"
              ? href === "caixa.html"
              : href === "index.html";

          if (!linkPermitido && link.id !== "btnSair") {
            link.parentElement.style.display = "none";
          }
        });
      }
    }
  });
})();

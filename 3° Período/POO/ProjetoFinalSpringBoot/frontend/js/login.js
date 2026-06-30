document.getElementById("formLogin").addEventListener("submit", async (e) => {
  e.preventDefault();

  const username = document.getElementById("username").value;
  const senha = document.getElementById("senha").value;

  try {
    const response = await fetch("http://localhost:8080/api/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, senha }),
    });

    if (response.ok) {
      const usuario = await response.json();
      localStorage.setItem("usuarioLogado", JSON.stringify(usuario));

      if (usuario.perfil === "OPERADOR_CAIXA") {
        window.location.href = "caixa.html";
      } else {
        window.location.href = "index.html";
      }
    } else {
      const erro = await response.text();
      alert(erro);
    }
  } catch (error) {
    console.error(error);
    alert("Erro ao conectar com o servidor.");
  }
});

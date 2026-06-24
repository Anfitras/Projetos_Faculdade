const API_URL_CLIENTES = "http://localhost:8080/api/clientes";
let idEdicaoCliente = null;

async function carregarClientes() {
  try {
    const response = await fetch(API_URL_CLIENTES);
    const clientes = await response.json();
    const tbody = document.querySelector("#tabelaClientes tbody");
    tbody.innerHTML = "";

    clientes.forEach((cliente) => {
      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>${cliente.id}</td>
        <td>${cliente.nome}</td>
        <td>${cliente.cpf}</td>
        <td>${cliente.telefone || "-"}</td>
        <td style="display: flex; gap: 8px;">
          <button onclick="prepararEdicaoCliente(${cliente.id})" class="btn btn-small btn-warning">Editar</button>
          <button onclick="deletarCliente(${cliente.id})" class="btn btn-small btn-danger">Excluir</button>
        </td>
      `;
      tbody.appendChild(tr);
    });
  } catch (error) {
    console.error(error);
  }
}

window.prepararEdicaoCliente = async function (id) {
  try {
    const response = await fetch(`${API_URL_CLIENTES}/${id}`);
    const cliente = await response.json();

    document.getElementById("nomeCliente").value = cliente.nome;
    document.getElementById("cpfCliente").value = cliente.cpf;
    document.getElementById("telefoneCliente").value = cliente.telefone;
    document.getElementById("emailCliente").value = cliente.email;

    idEdicaoCliente = cliente.id;

    const btnSubmit = document.querySelector(
      "#formCliente button[type='submit']",
    );
    btnSubmit.textContent = "Atualizar Cliente";
    btnSubmit.classList.replace("btn-primary", "btn-warning");
  } catch (error) {
    console.error(error);
  }
};

document
  .getElementById("formCliente")
  ?.addEventListener("submit", async (e) => {
    e.preventDefault();

    const cliente = {
      nome: document.getElementById("nomeCliente").value,
      cpf: document.getElementById("cpfCliente").value,
      telefone: document.getElementById("telefoneCliente").value,
      email: document.getElementById("emailCliente").value,
    };

    const metodo = idEdicaoCliente ? "PUT" : "POST";
    const url = idEdicaoCliente
      ? `${API_URL_CLIENTES}/${idEdicaoCliente}`
      : API_URL_CLIENTES;

    try {
      const response = await fetch(url, {
        method: metodo,
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(cliente),
      });

      if (response.ok) {
        resetarFormularioCliente();
        carregarClientes();
      } else {
        const msg = await response.text();
        alert("Erro: " + msg);
      }
    } catch (error) {
      console.error(error);
    }
  });

function resetarFormularioCliente() {
  document.getElementById("formCliente").reset();
  idEdicaoCliente = null;
  const btnSubmit = document.querySelector(
    "#formCliente button[type='submit']",
  );
  btnSubmit.textContent = "Salvar Cliente";
  btnSubmit.classList.replace("btn-warning", "btn-primary");
}

async function deletarCliente(id) {
  if (!confirm("Tem certeza que deseja excluir este cliente?")) return;
  try {
    const response = await fetch(`${API_URL_CLIENTES}/${id}`, {
      method: "DELETE",
    });
    if (response.ok) {
      carregarClientes();
    }
  } catch (error) {
    console.error(error);
  }
}

carregarClientes();

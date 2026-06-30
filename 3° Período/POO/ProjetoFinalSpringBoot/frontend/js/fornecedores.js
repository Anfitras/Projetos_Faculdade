const API_URL_FORNECEDORES = "http://localhost:8080/api/fornecedores";
let idEdicaoFornecedor = null;

async function carregarFornecedores() {
  try {
    const response = await fetch(API_URL_FORNECEDORES);
    const fornecedores = await response.json();
    const tbody = document.querySelector("#tabelaFornecedores tbody");
    tbody.innerHTML = "";

    fornecedores.forEach((fornecedor) => {
      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>${fornecedor.id}</td>
        <td>${fornecedor.nome}</td>
        <td>${fornecedor.cnpj}</td>
        <td>${fornecedor.telefone || "-"}</td>
        <td style="display: flex; gap: 8px;">
          <button onclick="prepararEdicaoFornecedor(${fornecedor.id})" class="btn btn-small btn-warning">Editar</button>
          <button onclick="deletarFornecedor(${fornecedor.id})" class="btn btn-small btn-danger">Excluir</button>
        </td>
      `;
      tbody.appendChild(tr);
    });
  } catch (error) {
    console.error(error);
  }
}

window.prepararEdicaoFornecedor = async function (id) {
  try {
    const response = await fetch(`${API_URL_FORNECEDORES}/${id}`);
    const fornecedor = await response.json();

    document.getElementById("nomeFornecedor").value = fornecedor.nome;
    document.getElementById("cnpjFornecedor").value = fornecedor.cnpj;
    document.getElementById("telefoneFornecedor").value = fornecedor.telefone;
    document.getElementById("emailFornecedor").value = fornecedor.email;
    document.getElementById("enderecoFornecedor").value = fornecedor.endereco;

    idEdicaoFornecedor = fornecedor.id;

    const btnSubmit = document.querySelector(
      "#formFornecedor button[type='submit']",
    );
    btnSubmit.textContent = "Atualizar Fornecedor";
    btnSubmit.classList.replace("btn-primary", "btn-warning");
  } catch (error) {
    console.error(error);
  }
};

document
  .getElementById("formFornecedor")
  ?.addEventListener("submit", async (e) => {
    e.preventDefault();

    const fornecedor = {
      nome: document.getElementById("nomeFornecedor").value,
      cnpj: document.getElementById("cnpjFornecedor").value,
      telefone: document.getElementById("telefoneFornecedor").value,
      email: document.getElementById("emailFornecedor").value,
      endereco: document.getElementById("enderecoFornecedor").value,
    };

    const metodo = idEdicaoFornecedor ? "PUT" : "POST";
    const url = idEdicaoFornecedor
      ? `${API_URL_FORNECEDORES}/${idEdicaoFornecedor}`
      : API_URL_FORNECEDORES;

    try {
      const response = await fetch(url, {
        method: metodo,
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(fornecedor),
      });

      if (response.ok) {
        resetarFormularioFornecedor();
        carregarFornecedores();
      }
    } catch (error) {
      console.error(error);
    }
  });

function resetarFormularioFornecedor() {
  document.getElementById("formFornecedor").reset();
  idEdicaoFornecedor = null;
  const btnSubmit = document.querySelector(
    "#formFornecedor button[type='submit']",
  );
  btnSubmit.textContent = "Salvar Fornecedor";
  btnSubmit.classList.replace("btn-warning", "btn-primary");
}

async function deletarFornecedor(id) {
  if (!confirm("Tem certeza que deseja excluir este fornecedor?")) return;
  try {
    const response = await fetch(`${API_URL_FORNECEDORES}/${id}`, {
      method: "DELETE",
    });
    if (response.ok) {
      carregarFornecedores();
    }
  } catch (error) {
    console.error(error);
  }
}

carregarFornecedores();

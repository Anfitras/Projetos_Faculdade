const API_URL_PRODUTOS = "http://localhost:8080/api/produtos";
const API_URL_FORNECEDORES = "http://localhost:8080/api/fornecedores";
let idEdicaoProduto = null;

async function carregarFornecedores() {
  try {
    const response = await fetch(API_URL_FORNECEDORES);
    const fornecedores = await response.json();
    const select = document.getElementById("fornecedorSelect");

    select.innerHTML = '<option value="">Selecione um fornecedor</option>';

    fornecedores.forEach((f) => {
      const option = document.createElement("option");
      option.value = f.id;
      option.textContent = f.nome;
      select.appendChild(option);
    });
  } catch (error) {
    console.error(error);
  }
}

async function carregarProdutos() {
  try {
    const response = await fetch(API_URL_PRODUTOS);
    const produtos = await response.json();
    const tbody = document.querySelector("#tabelaProdutos tbody");
    tbody.innerHTML = "";

    produtos.forEach((produto) => {
      const tr = document.createElement("tr");
      const nomeFornecedor = produto.fornecedor
        ? produto.fornecedor.nome
        : "Sem fornecedor";

      tr.innerHTML = `
                <td>${produto.id}</td>
                <td>${produto.nome}</td>
                <td>${produto.categoria}</td>
                <td>R$ ${produto.precoCusto}</td>
                <td>R$ ${produto.precoVenda}</td>
                <td>${produto.estoqueAtual}</td>
                <td>${nomeFornecedor}</td>
                <td class="actions-cell">
                    <button onclick="prepararEdicaoProduto(${produto.id})" class="btn-warning">Editar</button>
                    <button onclick="deletarProduto(${produto.id})" class="btn-danger">Excluir</button>
                </td>
            `;
      tbody.appendChild(tr);
    });
  } catch (error) {
    console.error(error);
  }
}

window.prepararEdicaoProduto = async function (id) {
  try {
    const response = await fetch(`${API_URL_PRODUTOS}/${id}`);
    const produto = await response.json();

    document.getElementById("nomeProduto").value = produto.nome;
    document.getElementById("categoriaProduto").value = produto.categoria;
    document.getElementById("precoCustoProduto").value = produto.precoCusto;
    document.getElementById("precoVendaProduto").value = produto.precoVenda;

    if (produto.fornecedor) {
      document.getElementById("fornecedorSelect").value = produto.fornecedor.id;
    }

    idEdicaoProduto = produto.id;

    const btnSubmit = document.querySelector(
      "#formProduto button[type='submit']",
    );
    btnSubmit.textContent = "Atualizar Produto";
    btnSubmit.classList.replace("btn-primary", "btn-warning");

    window.scrollTo({ top: 0, behavior: "smooth" });
  } catch (error) {
    console.error(error);
  }
};

document
  .getElementById("formProduto")
  ?.addEventListener("submit", async (e) => {
    e.preventDefault();

    const produto = {
      nome: document.getElementById("nomeProduto").value,
      categoria: document.getElementById("categoriaProduto").value,
      precoCusto: parseFloat(
        document.getElementById("precoCustoProduto").value,
      ),
      precoVenda: parseFloat(
        document.getElementById("precoVendaProduto").value,
      ),
      fornecedor: {
        id: parseInt(document.getElementById("fornecedorSelect").value),
      },
    };

    const metodo = idEdicaoProduto ? "PUT" : "POST";
    const url = idEdicaoProduto
      ? `${API_URL_PRODUTOS}/${idEdicaoProduto}`
      : API_URL_PRODUTOS;

    try {
      const response = await fetch(url, {
        method: metodo,
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(produto),
      });

      if (response.ok) {
        resetarFormularioProduto();
        carregarProdutos();
      }
    } catch (error) {
      console.error(error);
    }
  });

function resetarFormularioProduto() {
  document.getElementById("formProduto").reset();
  idEdicaoProduto = null;
  const btnSubmit = document.querySelector(
    "#formProduto button[type='submit']",
  );
  btnSubmit.textContent = "Salvar Produto";
  btnSubmit.classList.replace("btn-warning", "btn-primary");
}

async function deletarProduto(id) {
  try {
    const response = await fetch(`${API_URL_PRODUTOS}/${id}`, {
      method: "DELETE",
    });
    if (response.ok) {
      carregarProdutos();
    }
  } catch (error) {
    console.error(error);
  }
}

carregarFornecedores();
carregarProdutos();

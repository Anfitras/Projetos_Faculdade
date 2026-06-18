const API_URL_MOVIMENTOS = "http://localhost:8080/api/movimentos";
const API_URL_PRODUTOS = "http://localhost:8080/api/produtos";

async function carregarProdutosParaSelect() {
  try {
    const response = await fetch(API_URL_PRODUTOS);
    const produtos = await response.json();
    const select = document.getElementById("produtoMovimento");

    produtos.forEach((produto) => {
      const option = document.createElement("option");
      option.value = produto.id;
      option.textContent = produto.nome;
      select.appendChild(option);
    });
  } catch (error) {
    console.error(error);
  }
}

async function carregarMovimentos() {
  try {
    const response = await fetch(API_URL_MOVIMENTOS);
    const movimentos = await response.json();
    const tbody = document.querySelector("#tabelaMovimentos tbody");
    tbody.innerHTML = "";

    movimentos.forEach((mov) => {
      const dataCriacaoFormatada = new Date(mov.criadoEm).toLocaleString(
        "pt-BR",
      );

      let dataValidadeFormatada = "-";
      if (mov.dataValidade) {
        const partesData = mov.dataValidade.split("-");
        dataValidadeFormatada = `${partesData[2]}/${partesData[1]}/${partesData[0]}`;
      }

      const tr = document.createElement("tr");
      tr.innerHTML = `
                <td>${mov.id}</td>
                <td>${mov.produto.nome}</td>
                <td><strong>${mov.tipo}</strong></td>
                <td>${mov.quantidade}</td>
                <td>${mov.lote || "-"}</td>
                <td>${dataValidadeFormatada}</td>
                <td>${dataCriacaoFormatada}</td>
            `;
      tbody.appendChild(tr);
    });
  } catch (error) {
    console.error(error);
  }
}

document
  .getElementById("formMovimento")
  ?.addEventListener("submit", async (e) => {
    e.preventDefault();

    const dataValidadeRaw = document.getElementById("validadeMovimento").value;

    const movimento = {
      produto: {
        id: parseInt(document.getElementById("produtoMovimento").value),
      },
      tipo: document.getElementById("tipoMovimento").value,
      quantidade: parseInt(
        document.getElementById("quantidadeMovimento").value,
      ),
      observacao: document.getElementById("observacaoMovimento").value,
      lote: document.getElementById("loteMovimento").value,
      dataValidade: dataValidadeRaw ? dataValidadeRaw : null,
    };

    try {
      const response = await fetch(API_URL_MOVIMENTOS, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(movimento),
      });

      if (response.ok) {
        document.getElementById("formMovimento").reset();
        carregarMovimentos();
      } else {
        alert(
          "Erro ao registrar movimentação. Verifique se há estoque suficiente para saída.",
        );
      }
    } catch (error) {
      console.error(error);
    }
  });

carregarProdutosParaSelect();
carregarMovimentos();

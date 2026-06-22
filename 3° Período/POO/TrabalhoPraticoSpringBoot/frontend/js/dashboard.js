const API_URL_DASHBOARD = "http://localhost:8080/api/dashboard";
let chartInstance = null;

async function carregarDashboard() {
  try {
    const response = await fetch(API_URL_DASHBOARD);
    if (!response.ok) throw new Error("Falha ao buscar os dados do servidor");

    const data = await response.json();

    const formatadorBRL = new Intl.NumberFormat("pt-BR", {
      style: "currency",
      currency: "BRL",
    });

    document.getElementById("valorEstoque").textContent = formatadorBRL.format(
      data.valorTotalEstoque,
    );
    document.getElementById("faturamentoMensal").textContent =
      formatadorBRL.format(data.faturamentoMensal);
    document.getElementById("gastoMensal").textContent = formatadorBRL.format(
      data.gastoMensal,
    );
    document.getElementById("quantidadeTotalEstoque").textContent =
      data.quantidadeTotalEstoque;

    const tbodyMov = document.querySelector(
      "#tabelaUltimasMovimentacoes tbody",
    );
    tbodyMov.innerHTML = "";

    data.ultimasMovimentacoes.forEach((mov) => {
      const dataFormatada = new Date(mov.criadoEm).toLocaleString("pt-BR");
      const corTipo = mov.tipo === "ENTRADA" ? "#2ecc71" : "#e74c3c";

      const tr = document.createElement("tr");
      tr.innerHTML = `
                <td>${mov.produto.nome}</td>
                <td><strong style="color: ${corTipo}">${mov.tipo}</strong></td>
                <td>${mov.quantidade}</td>
                <td>${dataFormatada}</td>
            `;
      tbodyMov.appendChild(tr);
    });

    const tbodyVendas = document.querySelector("#tabelaUltimasVendas tbody");
    if (tbodyVendas) {
      tbodyVendas.innerHTML = "";
      data.ultimasVendas.forEach((venda) => {
        const dataFormatada = new Date(venda.criadoEm).toLocaleString("pt-BR");
        const nomeCliente = venda.cliente
          ? venda.cliente.nome
          : "Consumidor Final";

        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>#${venda.id}</td>
            <td>${nomeCliente}</td>
            <td>${dataFormatada}</td>
            <td>${formatadorBRL.format(venda.totalFinal)}</td>
        `;
        tbodyVendas.appendChild(tr);
      });
    }

    const tbodyBaixo = document.querySelector("#tabelaEstoqueBaixo tbody");
    tbodyBaixo.innerHTML = "";

    if (data.produtosBaixoEstoque.length === 0) {
      tbodyBaixo.innerHTML =
        "<tr><td colspan='4' style='text-align: center; color: #2ecc71;'>Nenhum produto com estoque baixo!</td></tr>";
    } else {
      data.produtosBaixoEstoque.forEach((p) => {
        const tr = document.createElement("tr");
        const nomeFornecedor = p.fornecedor
          ? p.fornecedor.nome
          : "Sem Fornecedor";
        tr.innerHTML = `
                <td>${p.nome}</td>
                <td>${p.categoria}</td>
                <td><strong style="color: #e74c3c; font-size: 1.1rem;">${p.estoqueAtual}</strong></td>
                <td>${nomeFornecedor}</td>
            `;
        tbodyBaixo.appendChild(tr);
      });
    }

    renderizarGrafico(data.topProdutosVendidos);
  } catch (error) {
    console.error(error);
  }
}

function renderizarGrafico(produtosTop) {
  const labelsGrafico = [];
  const dadosGrafico = [];
  let quantidadeOutros = 0;

  produtosTop.forEach((item, index) => {
    if (index < 5) {
      labelsGrafico.push(item.nome);
      dadosGrafico.push(item.quantidade);
    } else {
      quantidadeOutros += item.quantidade;
    }
  });

  if (quantidadeOutros > 0) {
    labelsGrafico.push("Outros");
    dadosGrafico.push(quantidadeOutros);
  }

  const ctx = document.getElementById("graficoProdutos").getContext("2d");

  if (chartInstance) {
    chartInstance.destroy();
  }

  chartInstance = new Chart(ctx, {
    type: "pie",
    data: {
      labels: labelsGrafico,
      datasets: [
        {
          data: dadosGrafico,
          backgroundColor: [
            "#3498db",
            "#2ecc71",
            "#e74c3c",
            "#f1c40f",
            "#9b59b6",
            "#95a5a6",
          ],
          borderWidth: 1,
        },
      ],
    },
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: "bottom",
        },
      },
    },
  });
}

carregarDashboard();

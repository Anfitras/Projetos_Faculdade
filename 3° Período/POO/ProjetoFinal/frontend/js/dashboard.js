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
      const corTipo = mov.tipo === "ENTRADA" ? "#22c55e" : "#ef4444";

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
      if (data.ultimasVendas && data.ultimasVendas.length > 0) {
        data.ultimasVendas.forEach((v) => {
          const dataVenda = new Date(v.criadoEm).toLocaleDateString("pt-BR");
          const nomeCli = v.cliente ? v.cliente.nome : "Consumidor Final";
          const tr = document.createElement("tr");
          tr.innerHTML = `
            <td>#${v.id}</td>
            <td>${nomeCli}</td>
            <td>${dataVenda}</td>
            <td><strong>${formatadorBRL.format(v.totalFinal)}</strong></td>
          `;
          tbodyVendas.appendChild(tr);
        });
      }
    }

    const tbodyBaixo = document.querySelector("#tabelaEstoqueBaixo tbody");
    if (tbodyBaixo) {
      tbodyBaixo.innerHTML = "";
      data.produtosBaixoEstoque.forEach((p) => {
        const nomeFornecedor = p.fornecedor ? p.fornecedor.nome : "-";
        const tr = document.createElement("tr");
        tr.innerHTML = `
          <td><strong>${p.nome}</strong></td>
          <td>${p.categoria}</td>
          <td><strong style="color: #ef4444; font-size: 1.1rem;">${p.estoqueAtual}</strong></td>
          <td>${nomeFornecedor}</td>
        `;
        tbodyBaixo.appendChild(tr);
      });
    }

    const tbodyVenc = document.querySelector("#tabelaProximosVencimento tbody");
    if (tbodyVenc) {
      tbodyVenc.innerHTML = "";
      if (
        data.produtosProximosVencimento &&
        data.produtosProximosVencimento.length > 0
      ) {
        const hoje = new Date();
        hoje.setHours(0, 0, 0, 0);

        data.produtosProximosVencimento.forEach((item) => {
          const partes = item.dataValidade.split("-");
          const dataVal = new Date(partes[0], partes[1] - 1, partes[2]);
          dataVal.setHours(0, 0, 0, 0);

          const diffTempo = dataVal.getTime() - hoje.getTime();
          const diffDias = Math.ceil(diffTempo / (1000 * 60 * 60 * 24));

          let badgeStatus = "";
          if (diffDias < 0) {
            badgeStatus = `<span style="background:#fee2e2; color:#991b1b; padding:4px 8px; border-radius:4px; font-size:12px; font-weight:bold;">Vencido há ${Math.abs(diffDias)} dias</span>`;
          } else if (diffDias === 0) {
            badgeStatus = `<span style="background:#fef3c7; color:#991b1b; padding:4px 8px; border-radius:4px; font-size:12px; font-weight:bold;">Vence HOJE!</span>`;
          } else {
            badgeStatus = `<span style="background:#fef9c3; color:#b45309; padding:4px 8px; border-radius:4px; font-size:12px; font-weight:bold;">Faltam ${diffDias} dias</span>`;
          }

          const dataExibicao = `${partes[2]}/${partes[1]}/${partes[0]}`;
          const tr = document.createElement("tr");
          tr.innerHTML = `
            <td><strong>${item.produto.nome}</strong></td>
            <td>${item.lote || "-"}</td>
            <td>${dataExibicao}</td>
            <td>${item.quantidade} un.</td>
            <td>${badgeStatus}</td>
          `;
          tbodyVenc.appendChild(tr);
        });
      } else {
        tbodyVenc.innerHTML = `<tr><td colspan="5" style="text-align:center; padding: 20px; color: #64748b;">Nenhum lote com vencimento próximo (30 dias) detectado no estoque.</td></tr>`;
      }
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
            "#3B82F6",
            "#22C55E",
            "#F59E0B",
            "#EF4444",
            "#8B5CF6",
            "#64748B",
          ],
        },
      ],
    },
    options: {
      responsive: true,
      maintainAspectRatio: false,
    },
  });
}

carregarDashboard();

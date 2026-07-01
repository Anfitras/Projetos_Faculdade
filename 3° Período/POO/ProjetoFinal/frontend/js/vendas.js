const API_URL_VENDAS = "http://localhost:8080/api/vendas";

async function carregarVendas() {
  try {
    const response = await fetch(API_URL_VENDAS);
    const vendas = await response.json();
    const tbody = document.querySelector("#tabelaVendas tbody");
    tbody.innerHTML = "";

    const formatadorBRL = new Intl.NumberFormat("pt-BR", {
      style: "currency",
      currency: "BRL",
    });

    vendas.forEach((venda) => {
      const dataFormatada = new Date(venda.criadoEm).toLocaleString("pt-BR");
      const nomeCliente = venda.cliente
        ? venda.cliente.nome
        : "Consumidor Final";
      const statusClass =
        venda.status === "CANCELADA" ? "status-cancelada" : "status-concluida";

      const btnCancelar =
        venda.status === "CONCLUIDA"
          ? `<button onclick="cancelarVenda(${venda.id})" class="btn btn-small btn-danger">Cancelar Venda</button>`
          : `<span>-</span>`;

      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>#${venda.id}</td>
        <td>${nomeCliente}</td>
        <td>${dataFormatada}</td>
        <td>${venda.formaPagamento}</td>
        <td>${formatadorBRL.format(venda.totalFinal)}</td>
        <td class="${statusClass}">${venda.status}</td>
        <td>${btnCancelar}</td>
      `;
      tbody.appendChild(tr);
    });
  } catch (error) {
    console.error(error);
  }
}

window.cancelarVenda = async function (id) {
  if (
    !confirm(
      "Tem certeza que deseja cancelar esta venda? O estoque será devolvido.",
    )
  )
    return;

  try {
    const response = await fetch(`${API_URL_VENDAS}/${id}/cancelar`, {
      method: "PUT",
    });

    if (response.ok) {
      carregarVendas();
    }
  } catch (error) {
    console.error(error);
  }
};

carregarVendas();

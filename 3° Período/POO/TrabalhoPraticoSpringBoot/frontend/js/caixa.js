const API_URL_VENDAS = "http://localhost:8080/api/vendas";
const API_URL_PRODUTOS = "http://localhost:8080/api/produtos";
const API_URL_CLIENTES = "http://localhost:8080/api/clientes";

let carrinho = [];
let produtosDisponiveis = [];

async function carregarProdutos() {
  try {
    const response = await fetch(API_URL_PRODUTOS);
    produtosDisponiveis = await response.json();
    const select = document.getElementById("produtoCaixa");
    select.innerHTML = '<option value="">Selecione um Produto</option>';

    produtosDisponiveis.forEach((produto) => {
      if (produto.estoqueAtual > 0) {
        const option = document.createElement("option");
        option.value = produto.id;
        option.textContent = `${produto.nome} (Estoque: ${produto.estoqueAtual} | R$ ${produto.precoVenda.toFixed(2)})`;
        select.appendChild(option);
      }
    });
  } catch (error) {
    console.error(error);
  }
}

async function carregarClientes() {
  try {
    const response = await fetch(API_URL_CLIENTES);
    const clientes = await response.json();
    const select = document.getElementById("clienteCaixa");

    clientes.forEach((cliente) => {
      const option = document.createElement("option");
      option.value = cliente.id;
      option.textContent = `${cliente.nome} - CPF: ${cliente.cpf}`;
      select.appendChild(option);
    });
  } catch (error) {
    console.error(error);
  }
}

document
  .getElementById("formAdicionarItem")
  ?.addEventListener("submit", (e) => {
    e.preventDefault();

    const produtoId = parseInt(document.getElementById("produtoCaixa").value);
    const quantidade = parseInt(
      document.getElementById("quantidadeCaixa").value,
    );
    const produto = produtosDisponiveis.find((p) => p.id === produtoId);

    if (quantidade > produto.estoqueAtual) {
      alert("Quantidade solicitada é maior que o estoque disponível!");
      return;
    }

    const itemExistenteIndex = carrinho.findIndex(
      (item) => item.produto.id === produtoId,
    );

    if (itemExistenteIndex !== -1) {
      carrinho[itemExistenteIndex].quantidade += quantidade;
      carrinho[itemExistenteIndex].subtotal =
        carrinho[itemExistenteIndex].quantidade * produto.precoVenda;
    } else {
      carrinho.push({
        produto: { id: produto.id, nome: produto.nome },
        quantidade: quantidade,
        precoUnitario: produto.precoVenda,
        subtotal: quantidade * produto.precoVenda,
      });
    }

    document.getElementById("quantidadeCaixa").value = "";
    atualizarCarrinho();
  });

function atualizarCarrinho() {
  const tbody = document.querySelector("#tabelaCarrinho tbody");
  tbody.innerHTML = "";
  let total = 0;

  carrinho.forEach((item, index) => {
    total += item.subtotal;
    const tr = document.createElement("tr");
    tr.innerHTML = `
            <td>${item.produto.nome}</td>
            <td>${item.quantidade}</td>
            <td>R$ ${item.precoUnitario.toFixed(2)}</td>
            <td>R$ ${item.subtotal.toFixed(2)}</td>
            <td><button onclick="removerDoCarrinho(${index})">Remover</button></td>
        `;
    tbody.appendChild(tr);
  });

  document.getElementById("totalBruto").textContent = total.toFixed(2);
}

function removerDoCarrinho(index) {
  carrinho.splice(index, 1);
  atualizarCarrinho();
}

function imprimirRecibo(venda, itensDoCarrinho) {
  const clienteNome = venda.cliente ? venda.cliente.nome : "Consumidor Final";
  const clienteCpf =
    venda.cliente && venda.cliente.cpf ? venda.cliente.cpf : "000.000.000-00";
  const dataVenda = new Date(venda.criadoEm || Date.now()).toLocaleString(
    "pt-BR",
  );

  let itensHTML = "";
  itensDoCarrinho.forEach((item) => {
    itensHTML += `
      <tr>
        <td>${item.produto.nome}</td>
        <td>${item.quantidade}</td>
        <td>R$ ${parseFloat(item.precoUnitario).toFixed(2)}</td>
        <td>R$ ${parseFloat(item.subtotal).toFixed(2)}</td>
      </tr>
    `;
  });

  const recibo = `
    <html>
      <head>
        <title>Recibo de Venda #${venda.id}</title>
        <style>
          body { font-family: monospace; width: 320px; margin: 0 auto; padding: 20px; color: #000; }
          h2 { text-align: center; margin-bottom: 5px; }
          .text-center { text-align: center; }
          table { width: 100%; border-collapse: collapse; margin: 15px 0; }
          th, td { text-align: left; border-bottom: 1px dashed #ccc; padding: 4px 0; font-size: 12px; }
          .totals { text-align: right; font-weight: bold; margin-top: 10px; font-size: 14px; }
        </style>
      </head>
      <body>
        <h2>ARMAZÉM</h2>
        <div class="text-center">Comprovante de Venda #${venda.id}</div>
        <div class="text-center">Data: ${dataVenda}</div>
        <hr style="border: 1px dashed #000;">
        <div><strong>Cliente:</strong> ${clienteNome}</div>
        <div><strong>CPF:</strong> ${clienteCpf}</div>
        <div><strong>Pagamento:</strong> ${venda.formaPagamento}</div>
        <hr style="border: 1px dashed #000;">
        <table>
          <thead>
            <tr><th>Item</th><th>Qtd</th><th>Un</th><th>Total</th></tr>
          </thead>
          <tbody>
            ${itensHTML}
          </tbody>
        </table>
        <div class="totals">Desconto: R$ ${parseFloat(venda.desconto).toFixed(2)}</div>
        <div class="totals">TOTAL FINAL: R$ ${parseFloat(venda.totalFinal).toFixed(2)}</div>
        <div class="text-center" style="margin-top: 20px;">Obrigado pela preferência!</div>
        <script>
          window.print();
          setTimeout(() => window.close(), 500);
        </script>
      </body>
    </html>
  `;

  const win = window.open("", "_blank", "width=400,height=600");
  win.document.write(recibo);
  win.document.close();
}

document
  .getElementById("btnFinalizarVenda")
  ?.addEventListener("click", async () => {
    if (carrinho.length === 0) {
      alert("Adicione itens ao carrinho antes de finalizar a venda.");
      return;
    }

    const desconto =
      parseFloat(document.getElementById("descontoCaixa").value) || 0;
    const totalBruto = parseFloat(
      document.getElementById("totalBruto").textContent,
    );

    if (desconto > totalBruto) {
      alert("O desconto não pode ser maior que o valor total da venda.");
      return;
    }

    const clienteId = document.getElementById("clienteCaixa").value;

    const venda = {
      desconto: desconto,
      formaPagamento: document.getElementById("formaPagamentoCaixa").value,
      cliente: clienteId ? { id: parseInt(clienteId) } : null,
      itens: carrinho.map((item) => ({
        produto: { id: item.produto.id },
        quantidade: item.quantidade,
      })),
    };

    try {
      const response = await fetch(API_URL_VENDAS, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(venda),
      });

      if (response.ok) {
        const vendaSalva = await response.json();

        imprimirRecibo(vendaSalva, carrinho);

        alert("Venda registrada com sucesso!");
        carrinho = [];
        atualizarCarrinho();
        document.getElementById("descontoCaixa").value = "";
        document.getElementById("clienteCaixa").value = "";
        carregarProdutos();
      } else {
        const erro = await response.text();
        alert("Erro ao registrar venda: " + erro);
      }
    } catch (error) {
      console.error(error);
    }
  });

carregarProdutos();
carregarClientes();

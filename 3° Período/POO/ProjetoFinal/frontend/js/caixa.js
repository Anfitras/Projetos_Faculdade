const API_URL_VENDAS = "http://localhost:8080/api/vendas";
const API_URL_PRODUTOS = "http://localhost:8080/api/produtos";
const API_URL_CLIENTES = "http://localhost:8080/api/clientes";

const CaixaModule = (() => {
  let carrinho = [];
  let produtosDisponiveis = [];

  async function inicializar() {
    await carregarProdutos();
    await carregarClientes();
    configurarEventos();
  }

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
      alert("Erro ao carregar os produtos do banco de dados.");
    }
  }

  async function carregarClientes() {
    try {
      const response = await fetch(API_URL_CLIENTES);
      const clientes = await response.json();
      const select = document.getElementById("clienteCaixa");
      const valorAnterior = select.value;

      select.innerHTML = '<option value="">Consumidor Final (Sem CPF)</option>';

      clientes.forEach((cliente) => {
        const option = document.createElement("option");
        option.value = cliente.id;
        option.textContent = `${cliente.nome} - CPF: ${cliente.cpf}`;
        select.appendChild(option);
      });

      if (valorAnterior) {
        select.value = valorAnterior;
      }
    } catch (error) {
      console.error(error);
      alert("Erro ao carregar os clientes do banco de dados.");
    }
  }

  function adicionarItem(e) {
    e.preventDefault();
    const select = document.getElementById("produtoCaixa");
    const inputQtd = document.getElementById("quantidadeCaixa");
    const produtoId = parseInt(select.value);
    const quantidade = parseInt(inputQtd.value);

    if (isNaN(produtoId)) {
      alert("Por favor, selecione um produto válido.");
      return;
    }

    if (isNaN(quantidade) || quantidade <= 0) {
      alert("A quantidade deve ser maior que zero.");
      return;
    }

    const produto = produtosDisponiveis.find((p) => p.id === produtoId);
    if (quantidade > produto.estoqueAtual) {
      alert("Quantidade solicitada indisponível no estoque atual.");
      return;
    }

    const index = carrinho.findIndex((i) => i.produto.id === produtoId);
    if (index > -1) {
      const novaQtd = carrinho[index].quantidade + quantidade;
      if (novaQtd > produto.estoqueAtual) {
        alert("Estoque insuficiente para somar esta quantidade ao carrinho.");
        return;
      }
      carrinho[index].quantidade = novaQtd;
      carrinho[index].subtotal = novaQtd * produto.precoVenda;
    } else {
      carrinho.push({
        produto: { id: produto.id, nome: produto.nome },
        quantidade: quantidade,
        precoUnitario: produto.precoVenda,
        subtotal: quantidade * produto.precoVenda,
      });
    }

    inputQtd.value = "";
    select.value = "";
    renderizarCarrinho();
  }

  function removerItem(index) {
    carrinho.splice(index, 1);
    renderizarCarrinho();
  }

  function renderizarCarrinho() {
    const tbody = document.querySelector("#tabelaCarrinho tbody");
    tbody.innerHTML = "";
    let totalBruto = 0;

    carrinho.forEach((item, index) => {
      totalBruto += item.subtotal;
      const tr = document.createElement("tr");

      const tdNome = document.createElement("td");
      tdNome.textContent = item.produto.nome;
      tr.appendChild(tdNome);

      const tdQtd = document.createElement("td");
      tdQtd.textContent = item.quantidade;
      tr.appendChild(tdQtd);

      const tdPreco = document.createElement("td");
      tdPreco.textContent = `R$ ${item.precoUnitario.toFixed(2)}`;
      tr.appendChild(tdPreco);

      const tdSub = document.createElement("td");
      tdSub.textContent = `R$ ${item.subtotal.toFixed(2)}`;
      tr.appendChild(tdSub);

      const tdAcao = document.createElement("td");
      const btnRemover = document.createElement("button");
      btnRemover.textContent = "Remover";
      btnRemover.className = "btn btn-danger btn-small btn-remover";
      btnRemover.dataset.index = index;
      tdAcao.appendChild(btnRemover);
      tr.appendChild(tdAcao);

      tbody.appendChild(tr);
    });

    const descontoInput = document.getElementById("descontoCaixa");
    const desconto = descontoInput ? parseFloat(descontoInput.value) || 0 : 0;

    let totalFinal = totalBruto - desconto;
    if (totalFinal < 0) {
      totalFinal = 0;
    }

    document.getElementById("totalCarrinho").textContent =
      "R$ " + totalFinal.toFixed(2).replace(".", ",");
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

  async function finalizarVenda() {
    if (carrinho.length === 0) {
      alert("O carrinho de compras está vazio.");
      return;
    }

    const descontoStr = document.getElementById("descontoCaixa").value;
    const desconto = descontoStr ? parseFloat(descontoStr) : 0;

    const totalBruto = carrinho.reduce((acc, item) => acc + item.subtotal, 0);

    if (desconto > totalBruto) {
      alert("O desconto não pode ser maior que o valor total da venda.");
      return;
    }

    const clienteId = document.getElementById("clienteCaixa").value;

    const payload = {
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
        body: JSON.stringify(payload),
      });

      if (response.ok) {
        const vendaSalva = await response.json();
        imprimirRecibo(vendaSalva, carrinho);
        alert("Venda registrada com sucesso!");
        carrinho = [];
        renderizarCarrinho();
        document.getElementById("descontoCaixa").value = "0";
        document.getElementById("clienteCaixa").value = "";
        carregarProdutos();
      } else {
        const erroTxt = await response.text();
        alert("Erro ao registrar a venda: " + erroTxt);
      }
    } catch (error) {
      console.error(error);
      alert("Erro de conexão ao tentar finalizar a venda.");
    }
  }

  function abrirModalCliente() {
    const modal = document.getElementById("modalNovoCliente");
    if (modal) modal.showModal();
  }

  function fecharModalCliente() {
    const modal = document.getElementById("modalNovoCliente");
    const form = document.getElementById("formModalCliente");
    if (form) form.reset();
    if (modal) modal.close();
  }

  async function salvarNovoCliente(e) {
    e.preventDefault();

    const cpfInput = document.getElementById("modalCpfCliente").value.trim();
    const telefoneInput = document
      .getElementById("modalTelefoneCliente")
      .value.trim();

    if (!/^\d{11}$/.test(cpfInput)) {
      alert("Erro: O CPF deve conter exatamente 11 dígitos numéricos.");
      return;
    }

    if (telefoneInput && !/^\d{11}$/.test(telefoneInput)) {
      alert("Erro: O telefone deve conter exatamente 11 dígitos numéricos.");
      return;
    }

    const cliente = {
      nome: document.getElementById("modalNomeCliente").value.trim(),
      cpf: cpfInput,
      telefone: telefoneInput,
      email: document.getElementById("modalEmailCliente").value.trim(),
    };

    try {
      const response = await fetch(API_URL_CLIENTES, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(cliente),
      });

      if (response.ok) {
        const clienteCriado = await response.json();
        fecharModalCliente();
        await carregarClientes();
        const select = document.getElementById("clienteCaixa");
        if (select) select.value = clienteCriado.id;
      } else {
        const erroTxt = await response.text();
        alert("Erro ao cadastrar cliente: " + erroTxt);
      }
    } catch (err) {
      console.error(err);
      alert("Erro de conexão ao tentar salvar o novo cliente.");
    }
  }

  function configurarEventos() {
    const formAdicionar = document.getElementById("formAdicionarItem");
    if (formAdicionar) formAdicionar.addEventListener("submit", adicionarItem);

    const tbody = document.querySelector("#tabelaCarrinho tbody");
    if (tbody) {
      tbody.addEventListener("click", (e) => {
        if (e.target.classList.contains("btn-remover")) {
          const index = parseInt(e.target.dataset.index);
          removerItem(index);
        }
      });
    }

    const btnFinalizar = document.getElementById("btnFinalizarVenda");
    if (btnFinalizar) btnFinalizar.addEventListener("click", finalizarVenda);

    const btnAbrirModal = document.getElementById("btnAbrirModalCliente");
    if (btnAbrirModal)
      btnAbrirModal.addEventListener("click", abrirModalCliente);

    const btnFechar = document.getElementById("btnFecharModal");
    if (btnFechar) btnFechar.addEventListener("click", fecharModalCliente);

    const formModal = document.getElementById("formModalCliente");
    if (formModal) formModal.addEventListener("submit", salvarNovoCliente);

    const descontoInput = document.getElementById("descontoCaixa");
    if (descontoInput) {
      descontoInput.addEventListener("input", renderizarCarrinho);
    }
  }

  return { inicializar };
})();

document.addEventListener("DOMContentLoaded", CaixaModule.inicializar);

function obterDataAtual() {
  let dataAtual = new Date();
  let dia = dataAtual.getDate();
  let mes = dataAtual.getMonth() + 1;
  let ano = dataAtual.getFullYear();
  return `${dia.toString().padStart(2, "0")}/${mes.toString().padStart(2, "0")}/${ano}`;
}

function obterHoraAtual() {
  const data = new Date();
  const hora = data.getHours().toString().padStart(2, "0");
  const minuto = data.getMinutes().toString().padStart(2, "0");
  const segundo = data.getSeconds().toString().padStart(2, "0");
  return `${hora}:${minuto}:${segundo}`;
}

function calcularDiferencaHoras(hora1, hora2) {
  const [h1, m1, s1] = hora1.split(":").map(Number);
  const [h2, m2, s2] = hora2.split(":").map(Number);
  const diferencaSegundos =
    h2 * 3600 + m2 * 60 + s2 - (h1 * 3600 + m1 * 60 + s1);
  const horas = Math.floor(diferencaSegundos / 3600);
  const minutos = Math.floor((diferencaSegundos % 3600) / 60);
  const segundos = diferencaSegundos % 60;
  return `${horas.toString().padStart(2, "0")}:${minutos.toString().padStart(2, "0")}:${segundos.toString().padStart(2, "0")}`;
}

// Feito com IA
function calcularIdade(dataAtual, dataNascimento) {
  if (dataNascimento === undefined) {
    dataNascimento = dataAtual;
    dataAtual = obterDataAtual();
  }

  function converterDataTexto(dataTexto) {
    if (!/^\d{2}\/\d{2}\/\d{4}$/.test(dataTexto)) return null;
    const [diaTexto, mesTexto, anoTexto] = dataTexto.split("/");
    const dia = Number(diaTexto);
    const mes = Number(mesTexto);
    const ano = Number(anoTexto);
    const data = new Date(ano, mes - 1, dia);

    if (
      data.getFullYear() !== ano ||
      data.getMonth() !== mes - 1 ||
      data.getDate() !== dia
    ) {
      return null;
    }

    return data;
  }

  const nascimento = converterDataTexto(dataNascimento);
  const hoje = converterDataTexto(dataAtual);

  if (!nascimento || !hoje || nascimento > hoje) return null;

  let idade = hoje.getFullYear() - nascimento.getFullYear();
  const aniversarioAindaNaoAconteceu =
    hoje.getMonth() < nascimento.getMonth() ||
    (hoje.getMonth() === nascimento.getMonth() &&
      hoje.getDate() < nascimento.getDate());

  if (aniversarioAindaNaoAconteceu) idade--;
  return idade;
}

using System;
using System.Globalization;

namespace cadastroGado
{
    class programGados
    {
        static void carregarDados(List<Gado> listadeGados, string nomeArquivo)
        {
            if (File.Exists(nomeArquivo))
            {
                string[] linhas = File.ReadAllLines(nomeArquivo);
                foreach (string linha in linhas)
                {
                    string[] campos = linha.Split(',');

                    Gado gado = new Gado();
                    gado.codigo = int.Parse(campos[0]);
                    gado.leite = double.Parse(campos[1]);
                    gado.alim = double.Parse(campos[2]);
                    listadeGados.Add(gado);
                }
                Console.WriteLine("Dados carregados com sucesso!");
            }
            else
                Console.WriteLine("Arquivo não encontrado :(");
        }

        static void carregarDatas(List<Gado> listadeGados, string nomeArquivo)
        {
            if (File.Exists(nomeArquivo))
            {
                string[] linhas = File.ReadAllLines(nomeArquivo);
                foreach (string linha in linhas)
                {
                    string[] campos = linha.Split(',');

                    int idBusca = int.Parse(campos[0]);
                    Gado gadoEncontrado = null;

                    foreach (Gado gado in listadeGados)
                    {
                        if (gado.codigo == idBusca)
                        {
                            gadoEncontrado = gado;
                            break;
                        }
                    }

                    if (gadoEncontrado != null)
                    {
                        Data data = new Data();
                        data.mes = campos[1];
                        data.ano = int.Parse(campos[2]);

                        gadoEncontrado.listadeDadas.Add(data);
                    }
                }
                Console.WriteLine("Dados de nascimento carregados com sucesso!");
            }
            else
            {
                Console.WriteLine(
                    "Arquivo 'listaNasciGados.txt' não encontrado (será criado ao salvar)."
                );
            }
        }

        static void salvarDados(List<Gado> listadeGados, string nomeArquivo)
        {
            StreamWriter writer = new StreamWriter(nomeArquivo);

            foreach (Gado gado in listadeGados)
            {
                writer.WriteLine($"{gado.codigo},{gado.leite},{gado.alim},{gado.abate}");
            }

            Console.WriteLine("Dados de Jogos salvos com sucesso!");
            writer.Dispose();
        }

        static void salvarDatas(List<Gado> listadeGados, string nomeArquivo)
        {
            StreamWriter writer = new StreamWriter(nomeArquivo);

            foreach (Gado gado in listadeGados)
            {
                foreach (Data data in gado.listadeDadas)
                {
                    writer.WriteLine($"{gado.codigo},{data.mes},{data.ano}");
                }
            }

            Console.WriteLine("Dados de Datas salvos com sucesso!");
            writer.Dispose();
        }

        static int idadeGado(Gado g, int mesAtual)
        {
            int idade = 0;

            foreach (Data d in g.listadeDadas)
            {
                int mes = d.mes.ToUpper().Trim() switch
                {
                    "JANEIRO" => 1,
                    "FEVEREIRO" => 2,
                    "MARÇO" => 3,
                    "ABRIL" => 4,
                    "MAIO" => 5,
                    "JUNHO" => 6,
                    "JULHO" => 7,
                    "AGOSTO" => 8,
                    "SETEMBRO" => 9,
                    "OUTUBRO" => 10,
                    "NOVEMBRO" => 11,
                    "DEZEMBRO" => 12,
                    _ => throw new ArgumentException($"Nome do mês inválido: {d.mes}"),
                };

                if (mes <= mesAtual)
                    idade = 2025 - d.ano;
                else if (mes > mesAtual)
                    idade = 2024 - d.ano;
            }

            return idade;
        }

        static void gadosAbate(List<Gado> listadeGados, int mesAtual)
        {
            foreach (Gado g in listadeGados)
            {
                int idade = idadeGado(g, mesAtual);
                if (idade > 5 || g.leite < 40)
                    g.abate = true;
                else
                    g.abate = false;
            }
        }

        static double leiteSemanal(List<Gado> listadeGados)
        {
            double totalLeite = 0.0;

            foreach (Gado g in listadeGados)
            {
                totalLeite += g.leite;
            }

            return totalLeite;
        }

        static double alimSemanal(List<Gado> listadeGados)
        {
            double totalAlim = 0.0;

            foreach (Gado g in listadeGados)
            {
                totalAlim += g.alim;
            }

            return totalAlim;
        }

        static void listaAbate(List<Gado> listadeGados, int mesAtual)
        {
            Console.WriteLine("--- Gados para Abate ---");
            string motivo = "";

            foreach (Gado g in listadeGados)
            {
                if (g.abate == true)
                {
                    int idade = idadeGado(g, mesAtual);

                    if (g.leite < 40 && idade > 5)
                        motivo = "Pouca produção de leite e idade avançada";
                    else if (g.leite < 40)
                        motivo = "Pouca produção de leite";
                    else if (idade > 5)
                        motivo = "Idade avançada";

                    Console.WriteLine("----------------------");
                    Console.WriteLine($"Gódigo: {g.codigo}");
                    Console.WriteLine($"Motivo: {motivo}");
                }
            }
        }

        static void Main()
        {
            List<Gado> listadeGados = new List<Gado>();
            carregarDados(listadeGados, "listaGados.txt");
            carregarDatas(listadeGados, "listaNasciGados.txt");
            Console.Write("Mês Atual(numérico): ");
            int mesAtual = int.Parse(Console.ReadLine());
            gadosAbate(listadeGados, mesAtual);
            Console.Clear();

            int op;

            do
            {
                op = menu();

                switch (op)
                {
                    case 1:
                        Console.WriteLine(
                            $"Total de Leite produzido semanalmente: {leiteSemanal(listadeGados):F1} Litros"
                        );
                        break;
                    case 2:
                        Console.WriteLine(
                            $"Total de Alimento consumido semanalmente: {alimSemanal(listadeGados):F1} KG"
                        );
                        break;
                    case 3:
                        listaAbate(listadeGados, mesAtual);
                        break;
                    case 0:
                        salvarDados(listadeGados, "listaGados.txt");
                        salvarDatas(listadeGados, "listaNasciGados.txt");
                        Console.WriteLine("Saindo...");
                        break;
                }
                Console.ReadKey();
                Console.Clear();
            } while (op != 0);
        }

        static int menu()
        {
            Console.WriteLine("--- Sistema de Controle de Gados ---");
            Console.WriteLine("1 - Total de Leite Produzido Semanalmente");
            Console.WriteLine("2 - Total de Alimento Consumido Semanalmente");
            Console.WriteLine("3 - Gados para Abate");
            Console.WriteLine("0 - Sair");
            Console.Write("Opção: ");
            int op = int.Parse(Console.ReadLine());

            return op;
        }
    }
}

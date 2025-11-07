using System;

namespace CadastroEletro
{
    class Program
    {
        static void addEletro(List<Eletro> listaEletros)
        {
            Eletro novoEletro = new Eletro();
            Console.Write("Entre com o nome: ");
            novoEletro.nome = Console.ReadLine();
            Console.Write("Entre com a potencia: ");
            novoEletro.potencia = double.Parse(Console.ReadLine());
            Console.Write("Entre com a tempo medio de uso diario: ");
            novoEletro.tempoMedioUsoDiario = double.Parse(Console.ReadLine());
            listaEletros.Add(novoEletro);
        }

        static void mostrarEletros(List<Eletro> listaEletros)
        {
            foreach (Eletro e in listaEletros)
            {
                Console.WriteLine("Nome: " + e.nome);
                Console.WriteLine("Potencia: " + e.potencia);
                Console.WriteLine("Tempo Medio de Uso Diario: " + e.tempoMedioUsoDiario);
                Console.WriteLine("-----------------------------");
            }
        }

        static void buscarEletro(List<Eletro> listaEletros)
        {
            Console.WriteLine("Qual eletro você busca: ");
            string eletroBuscado = Console.ReadLine();

            bool achou = false;

            foreach (Eletro e in listaEletros)
            {
                if (e.nome.ToUpper().Equals(eletroBuscado.ToUpper()))
                {
                    Console.WriteLine("--- Eletrodoméstico ---");
                    Console.WriteLine($"Nome: {e.nome}");
                    Console.WriteLine($"Potência: {e.potencia}");
                    Console.WriteLine($"Tempo Médio: {e.tempoMedioUsoDiario}");

                    achou = true;
                }
            }

            if (achou == false)
            {
                Console.WriteLine("Eletrodoméstico não encontrado!");
            }
        }

        static void buscarEletroPotencia(List<Eletro> listaEletros)
        {
            Console.WriteLine("Qual potência você quer usar: ");
            double quantPotencia = double.Parse(Console.ReadLine());

            bool achou = false;

            foreach (Eletro e in listaEletros)
            {
                if (quantPotencia < e.potencia)
                {
                    Console.WriteLine("--- Eletrodoméstico ---");
                    Console.WriteLine($"Nome: {e.nome}");
                    Console.WriteLine($"Potência: {e.potencia}");
                    Console.WriteLine($"Tempo Médio: {e.tempoMedioUsoDiario}");

                    achou = true;
                }
            }

            if (achou == false)
            {
                Console.WriteLine(
                    $"Nenhum eletrodoméstico cadastrado gasta mais que {quantPotencia} kW!"
                );
            }
        }

        static void calcularMediaDiariaMensal(List<Eletro> listaEletros)
        {
            double quantTotalDiaria = 0;

            Console.WriteLine("Quanto custa um kW/h: ");
            double custo = double.Parse(Console.ReadLine());

            foreach (Eletro e in listaEletros)
            {
                quantTotalDiaria += (e.potencia * e.tempoMedioUsoDiario);
            }

            double custoDiario = quantTotalDiaria * custo;
            double custoMensal = custoDiario * 30;

            Console.WriteLine($"Quantidade Diária: R$ {custoDiario:F2}");
            Console.WriteLine($"Quantidade Mensal: R$ {custoMensal:F2}");
        }

        static void calcularMediaEletro(List<Eletro> listaEletros)
        {
            Console.WriteLine("Quanto custa um kW/h: ");
            double custo = double.Parse(Console.ReadLine());

            foreach (Eletro e in listaEletros)
            {
                double quantMensal = 0;
                double custoMensal = 0;

                quantMensal = (e.potencia * e.tempoMedioUsoDiario) * 30;
                custoMensal = quantMensal * custo;

                Console.WriteLine("--- Eletrodoméstico ---");
                Console.WriteLine($"Nome: {e.nome}");
                Console.WriteLine($"Potência Total Gasta Mensalmente: R$ {quantMensal:F2}");
            }
        }

        static void salvarEletros(List<Eletro> listaEletros)
        {
            using (StreamWriter sw = new StreamWriter("eletros.txt"))
            {
                foreach (Eletro e in listaEletros)
                {
                    sw.WriteLine(e.nome + ";" + e.potencia + ";" + e.tempoMedioUsoDiario);
                }
            }
        }

        static void carregarEletros(List<Eletro> listaEletros)
        {
            if (File.Exists("eletros.txt"))
            {
                using (StreamReader sr = new StreamReader("eletros.txt"))
                {
                    string line;
                    while ((line = sr.ReadLine()) != null)
                    {
                        string[] parts = line.Split(';');
                        Eletro e = new Eletro();
                        e.nome = parts[0];
                        e.potencia = double.Parse(parts[1]);
                        e.tempoMedioUsoDiario = double.Parse(parts[2]);
                        listaEletros.Add(e);
                    }
                }
            }
        }

        static int menu()
        {
            Console.WriteLine("1 - Adicionar Eletrodomestico");
            Console.WriteLine("2 - Mostrar Eletrodomesticos");
            Console.WriteLine("3 - Buscar pelo nome");
            Console.WriteLine("4 - Buscar pela potência");
            Console.WriteLine("5 - Calcular consumo diário e mensal");
            Console.WriteLine("6 - Calcular custo total por eletrodomestico");
            Console.WriteLine("0 - Sair");
            Console.Write("Escolha uma opcao: ");
            return int.Parse(Console.ReadLine());
        }

        static void Main()
        {
            List<Eletro> listaEletros = new List<Eletro>();
            carregarEletros(listaEletros);
            int opcao;
            do
            {
                opcao = menu();
                switch (opcao)
                {
                    case 1:
                        addEletro(listaEletros);
                        break;
                    case 2:
                        mostrarEletros(listaEletros);
                        break;
                    case 3:
                        buscarEletro(listaEletros);
                        break;
                    case 4:
                        buscarEletroPotencia(listaEletros);
                        break;
                    case 5:
                        calcularMediaDiariaMensal(listaEletros);
                        break;
                    case 6:
                        calcularMediaEletro(listaEletros);
                        break;
                    case 0:
                        Console.WriteLine("Saindo...");
                        salvarEletros(listaEletros);
                        break;
                }

                Console.ReadKey();
                Console.Clear();
            } while (opcao != 0);
        }
    }
}

using System;
using System.Collections.Generic;
using System.IO;

namespace CadastroViagem
{
    class Program
    {
        //Arthur Beraldo
        static void mostraViagens(List<Viagem> listaDeViagens)
        {
            Console.WriteLine("--- Viagens ---");
            for (int i = 0; i < listaDeViagens.Count; i++)
            {
                Console.WriteLine($"\n--- Viagem {i + 1} ---");
                Console.WriteLine($"Modelo: {listaDeViagens[i].modeloVeiculo}");
                Console.WriteLine($"Placa: {listaDeViagens[i].placaVeiculo}");
                Console.WriteLine($"Destino: {listaDeViagens[i].destino}");
                Console.WriteLine($"Km Rodados: {listaDeViagens[i].kmRodados}");
                Console.WriteLine($"Consumo Medio: {listaDeViagens[i].consumoMedio}");
            }
        }

        static void salvarDados(List<Viagem> listaDeViagens, string nomeArquivo)
        {
            StreamWriter writer = new StreamWriter(nomeArquivo);

            foreach (Viagem viagem in listaDeViagens)
            {
                writer.WriteLine(
                    $"{viagem.modeloVeiculo},{viagem.placaVeiculo},{viagem.kmRodados},{viagem.consumoMedio},{viagem.destino}"
                );
            }

            Console.WriteLine("Dados salvos com sucesso!");
            writer.Dispose();
        }

        static void carregarDados(List<Viagem> listaDeViagens, string nomeArquivo)
        {
            if (File.Exists(nomeArquivo))
            {
                string[] linhas = File.ReadAllLines(nomeArquivo);
                foreach (string linha in linhas)
                {
                    string[] campos = linha.Split(',');
                    Viagem viagem = new Viagem();
                    viagem.modeloVeiculo = campos[0];
                    viagem.placaVeiculo = campos[1];
                    viagem.kmRodados = double.Parse(campos[2]);
                    viagem.consumoMedio = double.Parse(campos[3]);
                    viagem.destino = campos[4];
                    listaDeViagens.Add(viagem);
                }
                Console.WriteLine("Dados carregados com sucesso!");
            }
            else
                Console.WriteLine("Arquivo não encontrado :(");
        }

        static void adicionarViagens(List<Viagem> listaDeViagens)
        {
            Viagem novaViagem = new Viagem();

            Console.WriteLine("Modelo do Veículo: ");
            novaViagem.modeloVeiculo = Console.ReadLine();
            Console.WriteLine("Placa do Veículo: ");
            novaViagem.placaVeiculo = Console.ReadLine();
            Console.WriteLine("Destino: ");
            novaViagem.destino = Console.ReadLine();
            Console.WriteLine("KM Rodados: ");
            novaViagem.kmRodados = double.Parse(Console.ReadLine());
            Console.WriteLine("Consumo Médio: ");
            novaViagem.consumoMedio = double.Parse(Console.ReadLine());

            listaDeViagens.Add(novaViagem);
        }

        static void buscarViagens(List<Viagem> listaDeViagens)
        {
            Console.Write("Placa para busca: ");
            string placa = Console.ReadLine();

            bool achou = false;

            foreach (Viagem v in listaDeViagens)
            {
                if (placa == v.placaVeiculo)
                {
                    Console.WriteLine($"\n--- Viagem ---");
                    Console.WriteLine($"Modelo: {v.modeloVeiculo}");
                    Console.WriteLine($"Placa: {v.placaVeiculo}");
                    Console.WriteLine($"Destino: {v.destino}");
                    Console.WriteLine($"Km Rodados: {v.kmRodados}");
                    Console.WriteLine($"Consumo Medio: {v.consumoMedio}");

                    achou = true;
                }
            }

            if (achou == false)
            {
                Console.WriteLine($"Nunhuma viagem com a placa {placa} foi encontrada.");
            }
        }

        static void buscarViagemCombustivel(List<Viagem> listaDeViagens)
        {
            Console.Write("Quantidade Mínima: ");
            double quantMin = double.Parse(Console.ReadLine());

            bool achou = false;

            foreach (Viagem v in listaDeViagens)
            {
                double quantGasta = 0.0;
                quantGasta = v.kmRodados * v.consumoMedio;

                if (quantGasta > quantMin)
                {
                    Console.WriteLine($"\n--- Viagem {v} ---");
                    Console.WriteLine($"Modelo: {v.modeloVeiculo}");
                    Console.WriteLine($"Placa: {v.placaVeiculo}");
                    Console.WriteLine($"Destino: {v.destino}");
                    Console.WriteLine($"Km Rodados: {v.kmRodados}");
                    Console.WriteLine($"Consumo Medio: {v.consumoMedio}");
                    Console.WriteLine($"Consumo Total: {quantGasta}");

                    achou = true;
                }
            }

            if (achou == false)
            {
                Console.WriteLine($"Nenhuma viagem cadastrada gasta mais que {quantMin} litros.");
            }
        }

        static void consumoGastoViagem(List<Viagem> listaDeViagens)
        {
            Console.Write("Preço do Litro: ");
            double preco = double.Parse(Console.ReadLine());

            foreach (Viagem v in listaDeViagens)
            {
                double consumoTotal = v.kmRodados * v.consumoMedio;
                double gastoTotal = preco * consumoTotal;

                Console.WriteLine($"\n--- Viagem {v} ---");
                Console.WriteLine($"Modelo: {v.modeloVeiculo}");
                Console.WriteLine($"Placa: {v.placaVeiculo}");
                Console.WriteLine($"Destino: {v.destino}");
                Console.WriteLine($"Km Rodados: {v.kmRodados}");
                Console.WriteLine($"Consumo Medio: {v.consumoMedio}");
                Console.WriteLine($"Consumo Total: {consumoTotal}");
                Console.WriteLine($"Gasto Total: R${gastoTotal:F2}");
            }
        }

        static void consumoGastoTotal(List<Viagem> listaDeViagens)
        {
            Console.Write("Preço do Litro: ");
            double preco = double.Parse(Console.ReadLine());

            double consumoTotal = 0.0;

            foreach (Viagem v in listaDeViagens)
            {
                consumoTotal += (v.kmRodados * v.consumoMedio);
            }

            double precoTotal = consumoTotal * preco;

            Console.WriteLine($"Consumo Total: {consumoTotal} Litros.");
            Console.WriteLine($"Preço Total: R${precoTotal:F2}");
        }

        static int menu()
        {
            Console.WriteLine("--- Sistema de Controle de Viagens ---");
            Console.WriteLine("1 - Inserir Viagem");
            Console.WriteLine("2 - Mostrar Viagens");
            Console.WriteLine("3 - Buscar Viagem");
            Console.WriteLine("4 - Buscar Viagem por Combustível");
            Console.WriteLine("5 - Consumo e Gasto de Viagem");
            Console.WriteLine("6 - Consumo e Gasto Total");
            Console.WriteLine("0 - Sair");
            int op = int.Parse(Console.ReadLine());
            return op;
        }

        static void Main()
        {
            List<Viagem> listaDeViagens = new List<Viagem>();
            int op;
            carregarDados(listaDeViagens, "viagens.txt");
            do
            {
                op = menu();
                switch (op)
                {
                    case 1:
                        adicionarViagens(listaDeViagens);
                        break;
                    case 2:
                        mostraViagens(listaDeViagens);
                        break;
                    case 3:
                        buscarViagens(listaDeViagens);
                        break;
                    case 4:
                        buscarViagemCombustivel(listaDeViagens);
                        break;
                    case 5:
                        consumoGastoViagem(listaDeViagens);
                        break;
                    case 6:
                        consumoGastoTotal(listaDeViagens);
                        break;
                    case 0:
                        Console.WriteLine("Saindo...");
                        salvarDados(listaDeViagens, "viagens.txt");
                        break;
                }
                Console.ReadKey();
                Console.Clear();
            } while (op != 0);
        }
    }
}

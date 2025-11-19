// Arthur Beraldo - Tipo 1

namespace Condominio
{
    class Program
    {
		static void carregarDados(List<Apartamento> listaDeApartamentos, string nomeArquivo)
        {
            if (File.Exists(nomeArquivo))
            {
                string[] linhas = File.ReadAllLines(nomeArquivo);
                foreach (string linha in linhas)
                {
                    string[] campos = linha.Split(';');
                    Apartamento apto = new Apartamento();
                    apto.nomeResponsavel = campos[0];
                    apto.numeroApartamento = int.Parse(campos[1]);
                    apto.area = double.Parse(campos[2]);
                    apto.numeroMoradores = int.Parse(campos[3]);
                    apto.valorCondominio = double.Parse(campos[4]);
                    listaDeApartamentos.Add(apto);
                }
                Console.WriteLine("Dados carregados com sucesso!");
            }
            else
            {
                Console.WriteLine("Arquivo não encontrado :(");
            }
        }
		
		static void salvarDados(List<Apartamento> listaDeApartamentos, string nomeArquivo)
        {
            StreamWriter writer = new StreamWriter(nomeArquivo);
            foreach (Apartamento apto in listaDeApartamentos)
            {
                writer.WriteLine($"{apto.nomeResponsavel};{apto.numeroApartamento};{apto.area};{apto.numeroMoradores};{apto.valorCondominio:F2}");
            }
            writer.Dispose();
            Console.WriteLine("Dados salvos com sucesso!");
        }
		
		static double pagamentoTotal(List<Apartamento> listaDeApartamentos)
		{
			double soma = 0.0;
			
			foreach (Apartamento apto in listaDeApartamentos)
			{
				soma += apto.valorCondominio;
			}
			
			return soma;
		}
		
        static void addApartamento(List<Apartamento> listaDeApartamentos)
        {
            Apartamento novoApto = new Apartamento();
            Console.WriteLine("*** Cadastro de Apartamento ***");
            Console.Write("Nome do Responsável: ");
            novoApto.nomeResponsavel = Console.ReadLine();
            Console.Write("Número do Apartamento: ");
            novoApto.numeroApartamento = int.Parse(Console.ReadLine());
            Console.Write("Área do Apartamento (m²): ");
            novoApto.area = double.Parse(Console.ReadLine());
            Console.Write("Número de Moradores: ");
            novoApto.numeroMoradores = int.Parse(Console.ReadLine());
            Console.Write("Valor do Condomínio: R$ ");
            novoApto.valorCondominio = double.Parse(Console.ReadLine());
            listaDeApartamentos.Add(novoApto);
            Console.WriteLine("Apartamento cadastrado com sucesso!");
        }

        static void listarApartamentos(List<Apartamento> listaDeApartamentos)
        {
            Console.WriteLine("*** Lista de Apartamentos ***");
            foreach (Apartamento apto in listaDeApartamentos)
            {
                Console.WriteLine($"Apartamento {apto.numeroApartamento}:");
                Console.WriteLine($"  Responsável: {apto.nomeResponsavel}");
                Console.WriteLine($"  Área: {apto.area} m²");
                Console.WriteLine($"  Número de Moradores: {apto.numeroMoradores}");
                Console.WriteLine($"  Valor do Condomínio: R$ {apto.valorCondominio:F2}");
                Console.WriteLine();
            }
        }
		
		static void buscarApartamento(List<Apartamento> listaDeApartamentos)
		{
			Console.WriteLine("Buscar por:");
			Console.WriteLine("1 - Número do Apartamento");
			Console.WriteLine("2 - Nome do Responsável");
			Console.Write("Opção: ");
			int op = int.Parse(Console.ReadLine());
			Console.Clear();
			
			if (op == 1)
			{
				Console.WriteLine("Número do apto para busca: ");
				int busca = int.Parse(Console.ReadLine());
				bool achou = false;
				
				foreach (Apartamento apto in listaDeApartamentos)
				{
					if (busca == apto.numeroApartamento)
					{
						Console.WriteLine();
						Console.WriteLine($"Apartamento {apto.numeroApartamento}:");
						Console.WriteLine($"  Responsável: {apto.nomeResponsavel}");
						Console.WriteLine($"  Área: {apto.area} m²");
						Console.WriteLine($"  Número de Moradores: {apto.numeroMoradores}");
						Console.WriteLine($"  Valor do Condomínio: R$ {apto.valorCondominio:F2}");
						
						achou = true;
					}
				}
				
				if (achou == false)
						Console.WriteLine($"O apto {busca} não existe");
				
			}
			
			else if (op == 2)
			{
				Console.WriteLine("Nome do responsável para busca: ");
				string busca = Console.ReadLine();
				bool achou = false;
				
				foreach (Apartamento apto in listaDeApartamentos)
				{
					if (apto.nomeResponsavel.ToUpper().Contains(busca.ToUpper()))
					{
						Console.WriteLine();
						Console.WriteLine($"Apartamento {apto.numeroApartamento}:");
						Console.WriteLine($"  Responsável: {apto.nomeResponsavel}");
						Console.WriteLine($"  Área: {apto.area} m²");
						Console.WriteLine($"  Número de Moradores: {apto.numeroMoradores}");
						Console.WriteLine($"  Valor do Condomínio: R$ {apto.valorCondominio:F2}");
						
						achou = true;
					}
				}
				
				if (achou == false)
						Console.WriteLine($"Nenhum apartamento percente a {busca}");
			}
		}
        
		static void calcularArea(List<Apartamento> listaDeApartamentos)
		{
			double maior = 0.0;
			double menor = listaDeApartamentos[0].area;
			double soma = 0.0;
			
			foreach (Apartamento apto in listaDeApartamentos)
			{
				soma += apto.area;
				
				if (maior < apto.area)
						maior = apto.area;
					
				if (menor > apto.area)
						menor = apto.area;
			}
			
			Console.WriteLine("*** Métricas das Áreas dos Apartamentos");
			Console.WriteLine($"Maior Área: {maior} m²");
			Console.WriteLine($"Menor Área: {menor} m²");
			Console.WriteLine($"Área Total do Condomínio: {soma} m²");
		}
		
		static double calcularPagamentos(List<Apartamento> listaDeApartamentos)
		{
			double soma = pagamentoTotal(listaDeApartamentos);
			double media = soma / (listaDeApartamentos.Count);
			
			Console.WriteLine();
			Console.WriteLine("*** Dados Financeiros do Condomínio ***");
			Console.WriteLine($"Valor Total Arrecadado: R$ {soma:F2}");
			Console.WriteLine($"Média dos Valores Pagos: R$ {media:F2}");
			
			return soma;
		}
		
		static void calcularDespesas(List<Apartamento> listaDeApartamentos)
		{
			Console.WriteLine();
			Console.Write("Valor total da despesa mensal: ");
			double despesa = double.Parse(Console.ReadLine());
			
			double soma = pagamentoTotal(listaDeApartamentos);
			
			double saldo = soma - despesa;
			
			Console.Write($"Saldo total do mês: R$ {saldo:F2}");
		}
		
		static void reajustarCondo(List<Apartamento> listaDeApartamentos, double aumentoPorcent)
		{
			foreach(Apartamento apto in listaDeApartamentos)
			{
				apto.valorCondominio = (aumentoPorcent * apto.valorCondominio / 100) + apto.valorCondominio;
				
				Console.WriteLine();
				Console.WriteLine($"Apartamento {apto.numeroApartamento}: Novo valor do condomínio: R$ {apto.valorCondominio:F2}");
			}
		}

        static void Main()
        {
            List<Apartamento> listaDeApartamentos = new List<Apartamento>();
            carregarDados(listaDeApartamentos, "apartamentos.txt");
            int op;
            do
            {
                op = menu();
                switch (op)
                {
                    case 1:
                        addApartamento(listaDeApartamentos);
                        break;
                    case 2:
                        listarApartamentos(listaDeApartamentos);
                        break;
					case 3: 
						buscarApartamento(listaDeApartamentos);
						break;
					case 4:
						calcularArea(listaDeApartamentos);
						break;
					case 5:
						calcularPagamentos(listaDeApartamentos);
						break;
					case 6:
						calcularDespesas(listaDeApartamentos);
						break;
					case 7:
						Console.WriteLine();
						Console.Write("Valor em porcentagem para aumento do aluguel: ");
						double aumentoPorcent = double.Parse(Console.ReadLine());
						reajustarCondo(listaDeApartamentos, aumentoPorcent);
						break;
                    case 0:
                        Console.WriteLine("Saindo...");
                        salvarDados(listaDeApartamentos, "apartamentos.txt");
                        break;
                }
                Console.ReadKey();
                Console.Clear();
            } while (op != 0);
        }
		
		static int menu()
        {
            Console.WriteLine("*** Sistema de Cadastro de Apartamentos ***");
            Console.WriteLine("1 - Cadastrar Apartamento");
            Console.WriteLine("2 - Mostrar Apartamentos");
			Console.WriteLine("3 - Buscar Apartamento");
			Console.WriteLine("4 - Métrica das Áreas");
			Console.WriteLine("5 - Dados Financeiros");
			Console.WriteLine("6 - Calcular Saldo Mensal");
			Console.WriteLine("7 - Reajustar Valor do Condomínio");
            Console.WriteLine("0 - Sair");
            int op = int.Parse(Console.ReadLine());
            return op;
        }
    }
}

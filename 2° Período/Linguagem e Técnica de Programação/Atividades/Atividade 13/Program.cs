//Agabo Monteiro
//Arthur Beraldo

namespace CadastroAcademia
{
    class Program
    {

        static void adicionarAluno(List<AlunoAcademia> listaDeAlunos)
        {
            AlunoAcademia novoAluno = new AlunoAcademia();
            Console.WriteLine("*** Cadastro de Alunos ***");
            Console.Write("Nome do Aluno: ");
            novoAluno.nome = Console.ReadLine();
            Console.Write("Idade: ");
            novoAluno.idade = int.Parse(Console.ReadLine());
            Console.Write("Altura (em metros): ");
            novoAluno.altura = double.Parse(Console.ReadLine());
            Console.Write("Peso (em kg): ");
            novoAluno.peso = double.Parse(Console.ReadLine());
            Console.Write("Plano (Básico, Premium, VIP): ");
            novoAluno.plano = Console.ReadLine();
            Console.Write("Valor da mensalidade: R$ ");
            novoAluno.valorMensalidade = double.Parse(Console.ReadLine());
            Console.Write("Telefone: ");
            novoAluno.telefone = Console.ReadLine();
            listaDeAlunos.Add(novoAluno);
            Console.WriteLine("Aluno cadastrado com sucesso!");
        }

        static void listarAlunos(List<AlunoAcademia> lista)
        {
            Console.WriteLine("Alunos da Academia:");
				
            for (int i = 0; i < lista.Count; i++)
            {
				double imc = lista[i].peso / (lista[i].altura * lista[i].altura);
					
					Console.WriteLine();
                    Console.WriteLine($"*** Aluno {i + 1} ***");
                    Console.WriteLine($"Nome: {lista[i].nome}");
                    Console.WriteLine($"Idade: {lista[i].idade}");
                    Console.WriteLine($"Altura: {lista[i].altura}");
                    Console.WriteLine($"Peso: {lista[i].peso}");
                    Console.WriteLine($"Plano: {lista[i].plano}");
                    Console.WriteLine($"Valor da Mensalidade: R$ {lista[i].valorMensalidade:F2}");
                    Console.WriteLine($"Telefone: {lista[i].telefone}");
					Console.WriteLine($"IMC: {imc:F2}");
            }
        }
		
		static void buscarAluno(List<AlunoAcademia> listaDeAlunos)
		{
			Console.WriteLine("Buscar por:");
			Console.WriteLine("1 - Nome");
			Console.WriteLine("2 - Tipo de Plano");
			int buscar = int.Parse(Console.ReadLine());
			
			if (buscar == 1)
			{
				Console.Write("Nome: ");
				string nome = Console.ReadLine();
				bool achou = false;
				
				foreach (AlunoAcademia a in listaDeAlunos)
				{
					if (a.nome.ToUpper().Contains(nome.ToUpper()))
					{
						Console.WriteLine();
						Console.WriteLine($"Nome: {a.nome}");
						Console.WriteLine($"Idade: {a.idade}");
						Console.WriteLine($"Altura: {a.altura}");
						Console.WriteLine($"Peso: {a.peso}");
						Console.WriteLine($"Plano: {a.plano}");
						Console.WriteLine($"Valor da Mensalidade: R$ {a.valorMensalidade:F2}");
						Console.WriteLine($"Telefone: {a.telefone}");
						
						achou = true;
					}
				}
				
				if (achou == false)
					Console.WriteLine($"O nome {nome} não foi encontrado");
			}
			else if (buscar == 2)
			{
				Console.WriteLine("Básico");
				Console.WriteLine("Intermediário");
				Console.WriteLine("Premium");
				Console.Write("Tipo de Plano: ");
				string tPlano = Console.ReadLine();
				bool achou = false;
				
				foreach (AlunoAcademia a in listaDeAlunos)
				{
					if (a.plano.ToUpper().Contains(tPlano.ToUpper()))
					{
						Console.WriteLine();
						Console.WriteLine($"Nome: {a.nome}");
						Console.WriteLine($"Idade: {a.idade}");
						Console.WriteLine($"Altura: {a.altura}");
						Console.WriteLine($"Peso: {a.peso}");
						Console.WriteLine($"Plano: {a.plano}");
						Console.WriteLine($"Valor da Mensalidade: R$ {a.valorMensalidade:F2}");
						Console.WriteLine($"Telefone: {a.telefone}");
						
						achou = true;
					}
				}
				
				if (achou == false)
					Console.WriteLine($"Nenhum aluno foi encontrado no plano {tPlano}");
			}
			
		}
		
		static void buscarIMC(List<AlunoAcademia> listaDeAlunos)
		{
			Console.Write("IMC Máximo: ");
			double imcMax = double.Parse(Console.ReadLine());
			bool achou = false;
			foreach (AlunoAcademia a in listaDeAlunos)
			{
				double imc = a.peso / (a.altura * a.altura);
				
				if (imc > imcMax)
				{
					Console.WriteLine();
					Console.WriteLine($"Nome: {a.nome}");
					Console.WriteLine($"Idade: {a.idade}");
					Console.WriteLine($"Altura: {a.altura}");
					Console.WriteLine($"Peso: {a.peso}");
					Console.WriteLine($"Plano: {a.plano}");
					Console.WriteLine($"Valor da Mensalidade: R$ {a.valorMensalidade:F2}");
					Console.WriteLine($"Telefone: {a.telefone}");
					Console.WriteLine($"IMC: {imc:F2}");
					achou = true;
				}
			}
			if (achou == false)
			Console.WriteLine($"Nenhum aluno com o IMC acima de {imcMax:F1} foi encontrado.");
		}
		
		static void aumentarPlano(List<AlunoAcademia> listaDeAlunos)
		{
			Console.Write("Aluno: ");
			string aluno = Console.ReadLine();
			
			
			bool achou = false;
			
			foreach (AlunoAcademia a in listaDeAlunos)
			{
				if (a.nome.ToUpper().Contains(aluno.ToUpper()))
				{
					Console.Write("Valor do acrescimo: R$ ");
					double acrescimo = double.Parse(Console.ReadLine());
					
					a.valorMensalidade += acrescimo;
					
					Console.WriteLine($"Novo valor: R$ {a.valorMensalidade}");
					
					achou = true;
				}
			}
			
			if (achou == false)
				Console.WriteLine($"Nenhum aluno \"{aluno}\" foi encontrado.");
		}
		
		static void totalAlunosEValorMedioMensalidades(List<AlunoAcademia> listaDeAlunos)
		{
			double somaTotal = 0;
			int cont = 0;
			
			foreach (AlunoAcademia a in listaDeAlunos)
			{
				cont++;
				somaTotal += a.valorMensalidade;				
			}
			
			double media = somaTotal/cont;
			
			Console.WriteLine("***Estatísticas***");
			Console.WriteLine($"Quantidade total de alunos cadastrado: {cont}");
			Console.WriteLine($"Soma total dos valores dde todos os planos: R$ {somaTotal:F2}");
			Console.WriteLine($"Valor médio dos planos constratados: R$ {media:F2}");
			
		}


        static void salvarDados(List<AlunoAcademia> listaDeAlunos, string nomeArquivo)
        {
            StreamWriter writer = new StreamWriter(nomeArquivo);
            foreach (AlunoAcademia aluno in listaDeAlunos)
            {
                writer.WriteLine($"{aluno.nome};{aluno.idade};{aluno.altura};{aluno.peso};{aluno.plano};{aluno.valorMensalidade};{aluno.telefone}");
            }
            Console.WriteLine("Dados salvos com sucesso!");
            writer.Dispose();
        }

        static void carregarDados(List<AlunoAcademia> listaDeAlunos, string nomeArquivo)
        {
            if (File.Exists(nomeArquivo))
            {
                string[] linhas = File.ReadAllLines(nomeArquivo);
                foreach (string linha in linhas)
                {
                    string[] campos = linha.Split(';');
                    AlunoAcademia aluno = new AlunoAcademia();
                    aluno.nome = campos[0];
                    aluno.idade = int.Parse(campos[1]);
                    aluno.altura = double.Parse(campos[2]);
                    aluno.peso = double.Parse(campos[3]);
                    aluno.plano = campos[4];
                    aluno.valorMensalidade = double.Parse(campos[5]);
                    aluno.telefone = campos[6];
                    listaDeAlunos.Add(aluno);
                }
                Console.WriteLine("Dados carregados com sucesso!");
            }
            else
            {
                Console.WriteLine("Arquivo não encontrado :(");
            }
        }


        static int menu()
        {
            Console.WriteLine("*** Sistema de Cadastro de Alunos da Academia BodyBuilder ***");
            Console.WriteLine("1 - Cadastrar aluno");
            Console.WriteLine("2 - Listar todos os alunos");
            Console.WriteLine("3 - Buscar aluno");
            Console.WriteLine("4 - Mostrar alunos com IMC acima de");
            Console.WriteLine("5 - Aumentar o valor da mensalidade do Aluno");
            Console.WriteLine("6 - Mostrar quantidade total de Alunos");
            Console.WriteLine("0 - Sair");
            int op = int.Parse(Console.ReadLine());
            return op;
        }


        static void Main(string[] args)
        {
            List<AlunoAcademia> listaDeAlunos = new List<AlunoAcademia>();
            int op;
            carregarDados(listaDeAlunos, "alunos.txt");
            do
            {
                op = menu();
                switch (op)
                {
                    case 1:
                        adicionarAluno(listaDeAlunos);
                        break;
                    case 2:
                        listarAlunos(listaDeAlunos);
                        break;
					case 3:
						buscarAluno(listaDeAlunos);
						break;
					case 4:
						buscarIMC(listaDeAlunos);
						break;
					case 5:
						aumentarPlano(listaDeAlunos);
						break;

                    case 6: totalAlunosEValorMedioMensalidades(listaDeAlunos);
						break;    

                    case 0:
                        Console.WriteLine("Saindo...");
                        salvarDados(listaDeAlunos, "alunos.txt");
                        break;
                }
                Console.ReadKey();
                Console.Clear();
            } while (op != 0);
        }

    }
}


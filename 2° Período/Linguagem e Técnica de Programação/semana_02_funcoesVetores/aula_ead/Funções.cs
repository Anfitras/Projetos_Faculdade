using System;

class funções
{
    static double somaMediaFinal(double notaRegular, double NotaProvaFinal)
    {
        double resultado;
        resultado = (NotaProvaFinal * 2 + notaRegular) / 3;
        return resultado;
    }

    static void Main()
    {
        double notaRegular, notaProvaFinal, mediaFinal;

        while (true)
        {
            Console.WriteLine("Digite sua nota regular e a nota da sua prova final: ");
            notaRegular = double.Parse(Console.ReadLine());
            notaProvaFinal = double.Parse(Console.ReadLine());
            mediaFinal = somaMediaFinal(notaRegular, notaProvaFinal);
            Console.WriteLine($"A media final do aluno é: {mediaFinal:F1}");
        }
    }
}
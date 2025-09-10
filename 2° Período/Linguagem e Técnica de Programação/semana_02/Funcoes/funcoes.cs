using System;

class funcoes
{
    static double calcularMediaFinal(double notaReg, double notaFinal)
    {
        double resultado;
        resultado = (notaFinal * 2 + notaReg) / 3;

        return resultado;
    }


    static void Main()
    {
        double notaRegular, notaProvaFinal, mediaFinal;
        while (true)
        {
            Console.WriteLine("Entre com a nota regular e a nota da prova final: ");
            notaRegular = double.Parse(Console.ReadLine());
            notaProvaFinal = double.Parse(Console.ReadLine());
            mediaFinal = calcularMediaFinal(notaRegular, notaProvaFinal);

            Console.WriteLine($"A média final do aluno é {mediaFinal:F2}");

            if (mediaFinal >= 6)
            {
                Console.WriteLine("Aprovado!");
            }
            else
            {
                Console.WriteLine("Reprovado!");
            }
        }
    }
}
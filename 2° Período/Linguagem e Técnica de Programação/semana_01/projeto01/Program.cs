using System;
class Program
{
    static void Main()
    {
        int valor1, valor2, soma;

        Console.WriteLine("Entre com dois valores: ");

        valor1 = int.Parse(Console.ReadLine());
        valor2 = int.Parse(Console.ReadLine());
        soma = valor1 + valor2;

        Console.WriteLine("X = " + soma);
    }
}
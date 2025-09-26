using System;
using System.Globalization;
class Ex1002
{
    static void Main()
    {
        double pi, area, raio, raioQuadrado;

        Console.WriteLine("Digite o raio do circulo: ");
        raio = double.Parse(Console.ReadLine(), CultureInfo.CreateSpecificCulture("en-US"));

        pi = 3.14159;
        raioQuadrado = Math.Pow(raio, 2);

        area = pi * raioQuadrado;

        Console.WriteLine("A=" + area.ToString("F4", CultureInfo.CreateSpecificCulture("en-US")));
    }
}
using System;

class Ex1005
{
    static void Main()
    {
        double A, B, MEDIA;

        //Console.WriteLine("Digite as notas: ");
        A = double.Parse(Console.ReadLine());
        B = Double.Parse(Console.ReadLine());

        MEDIA = ((A * 3.5) + (B * 7.5)) / 11;

        Console.WriteLine($"MEDIA = {MEDIA:F5}");
    }
}

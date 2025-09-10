using System;


class MaiusculaMinuscula
{
    static void Main(string[] args)
    {

        string str1 = "Ana";
        string str2 = "Maria";
        string concatenada = string.Concat(str1, str2);

        Console.WriteLine("String concatenada:" + concatenada);

        string textoMaiusculo = concatenada.ToUpper();
        Console.WriteLine("Texto em maiúsculo:" + textoMaiusculo);

        string textoMinusculo = concatenada.ToLower();
        Console.WriteLine("Texto em minúsculo:" + textoMinusculo);

    }

}
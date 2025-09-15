
using System;

class Concat
{
    static void Main(string[] args)
    {
        string str1 = "Ana";
        string str2 = "Maria";
        string concatenada = string.Concat(str1, str2);
        Console.WriteLine("String concatenada:" + concatenada);

        string substring = concatenada.Substring(0, 3);
        Console.WriteLine("Substring:" + substring);
    }
}
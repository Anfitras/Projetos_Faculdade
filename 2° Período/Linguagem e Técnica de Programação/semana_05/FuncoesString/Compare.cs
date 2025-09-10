using System;
/*string.Compare retorna um int:
< 0 → str1 vem antes de str2
= 0 → str1 é igual a str2
> 0 → str1 vem depois de str2*/
class Compare
{
    public static void Main(string[] args)
    {
        string str1 = "Ana";
        string str2 = "Maria";
        int result = string.Compare(str1, str2);
        if (result == 0)
            Console.WriteLine("As strings são iguais.");
        else if (result > 0)
            Console.WriteLine("A primeira string é maior.");
        else
            Console.WriteLine("A primeira string é menor.");
    }
}
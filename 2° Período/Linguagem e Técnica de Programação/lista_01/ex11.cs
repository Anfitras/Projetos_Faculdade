using System;

class ex11
{
    static void Main()
    {
        Console.Write("Digite a mensagem codificada: ");
        string mensagemCodificada = Console.ReadLine();

        string mensagemDecodificada = "";
        int i = 0;

        while (i < mensagemCodificada.Length)
        {
            char atual = mensagemCodificada[i];

            if (atual == 'p')
            {
                if (i + 1 < mensagemCodificada.Length)
                {
                    mensagemDecodificada += mensagemCodificada[i + 1];
                    i += 2;
                }
                else
                {
                    i++;
                }
            }
            else
            {
                mensagemDecodificada += atual;
                i++;
            }
        }

        Console.WriteLine(mensagemDecodificada);
    }
}

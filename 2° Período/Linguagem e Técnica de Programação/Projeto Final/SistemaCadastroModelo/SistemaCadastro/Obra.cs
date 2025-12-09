using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SistemaCadastro
{
    class Obra
    {
        string nome;
        int tipo;
        decimal nota;
        int ranking;

        public string Nome { get => nome; set => nome = value; }
        public int Tipo { get => tipo; set => tipo = value; }
        public decimal Nota { get => nota; set => nota = value; }
        public int Ranking { get => ranking; set => ranking = value; }
    }
}

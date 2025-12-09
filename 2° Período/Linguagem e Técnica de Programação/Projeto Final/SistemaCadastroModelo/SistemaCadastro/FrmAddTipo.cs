using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SistemaCadastro
{
    public partial class FrmAddTipo : Form
    {
        public FrmAddTipo()
        {
            InitializeComponent();
        }

        private void btnFechar_Click(object sender, EventArgs e)
        {
            Sistema formSistema = new Sistema();
            formSistema.ShowDialog();
            this.Close();
        }

        private void BtnConfirmaCadastro_Click(object sender, EventArgs e)
        {
            ConectaBanco con = new ConectaBanco();
            bool retorno = con.insereTipo(txtAddGenero.Text);

            if (!retorno)
            {
                MessageBox.Show(con.mensagem);
            }
            else
                MessageBox.Show("Tipo adicionado com sucesso!");

            txtAddGenero.Clear();
            txtAddGenero.Focus();
        }
    }
}

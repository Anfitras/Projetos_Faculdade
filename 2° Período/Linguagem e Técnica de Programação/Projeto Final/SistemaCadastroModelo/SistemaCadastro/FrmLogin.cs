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
    public partial class FrmLogin : Form
    {
        public FrmLogin()
        {
            InitializeComponent();
        }

        private void btnFechar_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void BtnLogin_Click(object sender, EventArgs e)
        {
            ConectaBanco conecta = new ConectaBanco();

            if (conecta.verifica(txtUserLogin.Text, txtSenhaLogin.Text))
            {
                MessageBox.Show("Login realizado com sucesso!");
                Sistema sis = new Sistema();
                this.Hide();
                sis.ShowDialog();
                this.Close();
            }
            else
            {
                MessageBox.Show("Usuário ou senha incorretos!" + conecta.mensagem);
            }
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FrmCadastro cadastro = new FrmCadastro();
            this.Hide();
            cadastro.Show();
        }
    }
}

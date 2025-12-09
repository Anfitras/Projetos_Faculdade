using System;
using System.Windows.Forms;

namespace SistemaCadastro
{
    public partial class FrmCadastro : Form
    {
        public FrmCadastro()
        {
            InitializeComponent();
        }

        private void btnFechar_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void BtnCadastro_Click(object sender, EventArgs e)
        {
            string usuario = txtUserCadastro.Text.Trim();
            string senha = txtSenhaCadastro.Text;
            string senhaConfirm = txtConfirmarSenhaCadastro.Text;

            if (string.IsNullOrWhiteSpace(usuario))
            {
                MessageBox.Show("Digite um nome de usuário.");
                txtUserCadastro.Focus();
                return;
            }

            if (senha.Length < 4)
            {
                MessageBox.Show("A senha deve ter no mínimo 4 caracteres.");
                txtSenhaCadastro.Focus();
                return;
            }

            if (!senha.Equals(senhaConfirm))
            {
                MessageBox.Show("As senhas não coincidem.");
                txtSenhaCadastro.SelectAll();
                txtSenhaCadastro.Focus();
                return;
            }

            ConectaBanco conecta = new ConectaBanco();

            bool inseriu = conecta.InsereUsuario(usuario, senha);

            if (!inseriu)
            {
                MessageBox.Show(conecta.mensagem);

                if (conecta.mensagem.Contains("já existe"))
                {
                    txtUserCadastro.SelectAll();
                    txtUserCadastro.Focus();
                }
                return;
            }

            MessageBox.Show("Usuário cadastrado com sucesso!");

            FrmLogin login = new FrmLogin();
            this.Hide();
            login.ShowDialog();
            this.Close();
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            FrmLogin login = new FrmLogin();
            this.Hide();
            login.ShowDialog();
            this.Close();
        }
    }
}

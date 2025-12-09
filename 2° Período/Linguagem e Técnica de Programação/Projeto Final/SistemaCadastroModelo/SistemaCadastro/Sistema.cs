using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SistemaCadastro
{
    public partial class Sistema : Form
    {
        int idAlterar;

        public Sistema()
        {
            InitializeComponent();
            tabControl1.Appearance = TabAppearance.FlatButtons;
            tabControl1.ItemSize = new Size(0, 1);
            tabControl1.SizeMode = TabSizeMode.Fixed;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnCadastra_Click(object sender, EventArgs e)
        {
            marcador.Height = btnCadastra.Height;
            marcador.Top = btnCadastra.Top;
            tabControl1.SelectedTab = tabControl1.TabPages[0];
        }

        private void btnBusca_Click(object sender, EventArgs e)
        {
            marcador.Height = btnBusca.Height;
            marcador.Top = btnBusca.Top;
            tabControl1.SelectedTab = tabControl1.TabPages[1];
        }

        private void Sistema_Load(object sender, EventArgs e)
        {
            listaCBTipos();
            listagridObras();
        }

        void listagridObras()
        {
            ConectaBanco con = new ConectaBanco();
            dgObras.DataSource = con.listaObras();

            dgObras.Columns["id"].Visible = false;

            dgObras.Columns["nome"].HeaderText = "Obra";
            dgObras.Columns["nota"].HeaderText = "Nota";
            dgObras.Columns["rank_popularidade"].HeaderText = "Ranking";
            dgObras.Columns["tipo"].HeaderText = "Tipo";
        }

        public void listaCBTipos()
        {
            ConectaBanco con = new ConectaBanco();
            DataTable tabelaDados = new DataTable();
            tabelaDados = con.listaTipos();
            cbTipo.DataSource = tabelaDados;
            cbTipo.DisplayMember = "tipo";
            cbTipo.ValueMember = "id";

            cbTipo.SelectedIndex = -1;

            cbAlteraTipo.DataSource = tabelaDados.Copy();
            cbAlteraTipo.DisplayMember = "tipo";
            cbAlteraTipo.ValueMember = "id";

            cbAlteraTipo.SelectedIndex = -1;
        }

        private void txtBusca_TextChanged(object sender, EventArgs e)
        {
            (dgObras.DataSource as DataTable).DefaultView.RowFilter = string.Format(
                "nome LIKE '{0}%'",
                txtBusca.Text
            );
        }

        private void btnRemoveObra_Click(object sender, EventArgs e)
        {
            int linha = dgObras.CurrentRow.Index;
            int id = Convert.ToInt32(dgObras.Rows[linha].Cells["id"].Value.ToString());
            DialogResult resp = MessageBox.Show(
                "Tem certeza que deseja remover esta obra?",
                "Confirmação",
                MessageBoxButtons.OKCancel
            );
            if (resp == DialogResult.OK)
            {
                ConectaBanco con = new ConectaBanco();
                bool retorno = con.removeObra(id);
                if (retorno == true)
                {
                    MessageBox.Show("Obra removida com sucesso!");
                    listagridObras();
                }
                else
                    MessageBox.Show(con.mensagem);
            }
        }

        private void btnAlterar_Click(object sender, EventArgs e)
        {
            int linha = dgObras.CurrentRow.Index;
            idAlterar = Convert.ToInt32(dgObras.Rows[linha].Cells["id"].Value.ToString());
            txtAlteraNome.Text = dgObras.Rows[linha].Cells["nome"].Value.ToString();
            cbAlteraTipo.Text = dgObras.Rows[linha].Cells["tipo"].Value.ToString();
            txtAlteraNota.Text = dgObras.Rows[linha].Cells["nota"].Value.ToString();
            txtAlteraRanking.Text = dgObras.Rows[linha].Cells["rank_popularidade"].Value.ToString();
            tabControl1.SelectedTab = tabAlterar;
        }

        private void btnConfirmaAlteracao_Click(object sender, EventArgs e)
        {
            ConectaBanco con = new ConectaBanco();
            Obra novaObra = new Obra();
            novaObra.Nome = txtAlteraNome.Text;
            novaObra.Tipo = int.Parse(cbAlteraTipo.SelectedValue.ToString());
            novaObra.Nota = decimal.Parse(txtAlteraNota.Text);
            novaObra.Ranking = int.Parse(txtAlteraRanking.Text);
            bool retorno = con.alteraObra(novaObra, idAlterar);

            if (!retorno)
            {
                MessageBox.Show(con.mensagem);
            }
            else
                MessageBox.Show("Alteração realizada com sucesso");

            listagridObras();

            tabControl1.SelectedTab = tabControl1.TabPages[1];
        }

        public void limpaCampos()
        {
            txtNome.Clear();
            cbTipo.SelectedIndex = -1;
            txtNota.Clear();
            txtRanking.Clear();
            txtNome.Focus();
        }

        private void BtnConfirmaCadastro_Click(object sender, EventArgs e)
        {
            string nomeObra = txtNome.Text.Trim();

            if (string.IsNullOrEmpty(nomeObra))
            {
                MessageBox.Show("Por favor, digite o nome da obra.");
                txtNome.Focus();
                return;
            }

            if (cbTipo.SelectedIndex == -1)
            {
                MessageBox.Show("Selecione um tipo para a obra.");
                cbTipo.Focus();
                return;
            }

            if (!decimal.TryParse(txtNota.Text, out decimal nota))
            {
                MessageBox.Show("A nota deve ser um número válido.");
                txtNota.Focus();
                return;
            }

            if (!int.TryParse(txtRanking.Text, out int ranking))
            {
                MessageBox.Show("O ranking deve ser um número inteiro.");
                txtRanking.Focus();
                return;
            }

            Obra novaObra = new Obra();
            novaObra.Nome = nomeObra;
            novaObra.Tipo = Convert.ToInt32(cbTipo.SelectedValue);
            novaObra.Nota = nota;
            novaObra.Ranking = ranking;

            ConectaBanco con = new ConectaBanco();
            bool retorno = con.insereObra(novaObra);

            if (!retorno)
            {
                MessageBox.Show(con.mensagem);

                if (
                    con.mensagem.Contains("já está cadastrada")
                    || con.mensagem.Contains("já existe")
                )
                {
                    txtNome.SelectAll();
                    txtNome.Focus();
                }
                return;
            }

            MessageBox.Show("Obra cadastrada com sucesso!");
            limpaCampos();
            listagridObras();
        }

        private void bntAddTipo_Click(object sender, EventArgs e)
        {
            FrmAddTipo formTipo = new FrmAddTipo();
            this.Hide();
            formTipo.ShowDialog();
            this.Close();
        }
    }
}

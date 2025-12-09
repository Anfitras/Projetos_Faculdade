namespace SistemaCadastro
{
    partial class Sistema
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Sistema));
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            this.panel1 = new System.Windows.Forms.Panel();
            this.marcador = new System.Windows.Forms.Panel();
            this.btnBusca = new System.Windows.Forms.Button();
            this.btnCadastra = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.panel4 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabCadastrar = new System.Windows.Forms.TabPage();
            this.bntAddTipo = new System.Windows.Forms.Button();
            this.cbTipo = new System.Windows.Forms.ComboBox();
            this.txtRanking = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.BtnConfirmaCadastro = new System.Windows.Forms.Button();
            this.txtNota = new System.Windows.Forms.TextBox();
            this.txtNome = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.tabBuscar = new System.Windows.Forms.TabPage();
            this.btnAlterar = new System.Windows.Forms.Button();
            this.btnRemoveObra = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.txtBusca = new System.Windows.Forms.TextBox();
            this.dgObras = new System.Windows.Forms.DataGridView();
            this.tabAlterar = new System.Windows.Forms.TabPage();
            this.cbAlteraTipo = new System.Windows.Forms.ComboBox();
            this.txtAlteraRanking = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.txtAlteraNota = new System.Windows.Forms.TextBox();
            this.txtAlteraNome = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.btnConfirmaAlteracao = new System.Windows.Forms.Button();
            this.lblMensagem = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.panel4.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.tabControl1.SuspendLayout();
            this.tabCadastrar.SuspendLayout();
            this.tabBuscar.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgObras)).BeginInit();
            this.tabAlterar.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.panel1.Controls.Add(this.marcador);
            this.panel1.Controls.Add(this.btnBusca);
            this.panel1.Controls.Add(this.btnCadastra);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(180, 500);
            this.panel1.TabIndex = 0;
            // 
            // marcador
            // 
            this.marcador.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.marcador.Location = new System.Drawing.Point(0, 100);
            this.marcador.Name = "marcador";
            this.marcador.Size = new System.Drawing.Size(7, 50);
            this.marcador.TabIndex = 8;
            // 
            // btnBusca
            // 
            this.btnBusca.FlatAppearance.BorderSize = 0;
            this.btnBusca.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(45)))), ((int)(((byte)(45)))), ((int)(((byte)(45)))));
            this.btnBusca.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBusca.Font = new System.Drawing.Font("Segoe UI", 12F);
            this.btnBusca.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.btnBusca.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnBusca.Location = new System.Drawing.Point(7, 155);
            this.btnBusca.Name = "btnBusca";
            this.btnBusca.Size = new System.Drawing.Size(173, 50);
            this.btnBusca.TabIndex = 5;
            this.btnBusca.Text = "    Buscar";
            this.btnBusca.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnBusca.UseVisualStyleBackColor = true;
            this.btnBusca.Click += new System.EventHandler(this.btnBusca_Click);
            // 
            // btnCadastra
            // 
            this.btnCadastra.FlatAppearance.BorderSize = 0;
            this.btnCadastra.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(45)))), ((int)(((byte)(45)))), ((int)(((byte)(45)))));
            this.btnCadastra.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCadastra.Font = new System.Drawing.Font("Segoe UI", 12F);
            this.btnCadastra.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.btnCadastra.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnCadastra.Location = new System.Drawing.Point(7, 100);
            this.btnCadastra.Name = "btnCadastra";
            this.btnCadastra.Size = new System.Drawing.Size(173, 50);
            this.btnCadastra.TabIndex = 3;
            this.btnCadastra.Text = "    Cadastrar";
            this.btnCadastra.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnCadastra.UseVisualStyleBackColor = true;
            this.btnCadastra.Click += new System.EventHandler(this.btnCadastra_Click);
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.panel2.Controls.Add(this.panel3);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel2.Location = new System.Drawing.Point(180, 0);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(720, 15);
            this.panel2.TabIndex = 1;
            // 
            // panel3
            // 
            this.panel3.Location = new System.Drawing.Point(45, 37);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(125, 131);
            this.panel3.TabIndex = 2;
            this.panel3.Visible = false;
            // 
            // panel4
            // 
            this.panel4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.panel4.Controls.Add(this.label1);
            this.panel4.Controls.Add(this.pictureBox1);
            this.panel4.Location = new System.Drawing.Point(210, 30);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(150, 150);
            this.panel4.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 11F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.label1.Location = new System.Drawing.Point(15, 120);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(107, 20);
            this.label1.TabIndex = 3;
            this.label1.Text = "WATCHPOINT";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::SistemaCadastro.Properties.Resources.logo_watchpoint;
            this.pictureBox1.Location = new System.Drawing.Point(20, 15);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(110, 100);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 3;
            this.pictureBox1.TabStop = false;
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabCadastrar);
            this.tabControl1.Controls.Add(this.tabBuscar);
            this.tabControl1.Controls.Add(this.tabAlterar);
            this.tabControl1.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.tabControl1.Location = new System.Drawing.Point(200, 190);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(680, 290);
            this.tabControl1.TabIndex = 9;
            // 
            // tabCadastrar
            // 
            this.tabCadastrar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.tabCadastrar.Controls.Add(this.bntAddTipo);
            this.tabCadastrar.Controls.Add(this.cbTipo);
            this.tabCadastrar.Controls.Add(this.txtRanking);
            this.tabCadastrar.Controls.Add(this.label6);
            this.tabCadastrar.Controls.Add(this.BtnConfirmaCadastro);
            this.tabCadastrar.Controls.Add(this.txtNota);
            this.tabCadastrar.Controls.Add(this.txtNome);
            this.tabCadastrar.Controls.Add(this.label3);
            this.tabCadastrar.Controls.Add(this.label2);
            this.tabCadastrar.Controls.Add(this.label4);
            this.tabCadastrar.Location = new System.Drawing.Point(4, 29);
            this.tabCadastrar.Name = "tabCadastrar";
            this.tabCadastrar.Padding = new System.Windows.Forms.Padding(3);
            this.tabCadastrar.Size = new System.Drawing.Size(672, 257);
            this.tabCadastrar.TabIndex = 0;
            this.tabCadastrar.Text = "Cadastrar";
            // 
            // bntAddTipo
            // 
            this.bntAddTipo.Image = global::SistemaCadastro.Properties.Resources.botao_adicionar;
            this.bntAddTipo.Location = new System.Drawing.Point(627, 70);
            this.bntAddTipo.Name = "bntAddTipo";
            this.bntAddTipo.Size = new System.Drawing.Size(26, 26);
            this.bntAddTipo.TabIndex = 14;
            this.bntAddTipo.UseVisualStyleBackColor = true;
            this.bntAddTipo.Click += new System.EventHandler(this.bntAddTipo_Click);
            // 
            // cbTipo
            // 
            this.cbTipo.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Suggest;
            this.cbTipo.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.cbTipo.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cbTipo.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.cbTipo.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.cbTipo.FormattingEnabled = true;
            this.cbTipo.Location = new System.Drawing.Point(121, 70);
            this.cbTipo.Name = "cbTipo";
            this.cbTipo.Size = new System.Drawing.Size(500, 28);
            this.cbTipo.TabIndex = 10;
            // 
            // txtRanking
            // 
            this.txtRanking.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtRanking.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtRanking.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtRanking.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtRanking.Location = new System.Drawing.Point(121, 150);
            this.txtRanking.Name = "txtRanking";
            this.txtRanking.Size = new System.Drawing.Size(500, 27);
            this.txtRanking.TabIndex = 12;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label6.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label6.Location = new System.Drawing.Point(21, 152);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(65, 20);
            this.label6.TabIndex = 13;
            this.label6.Text = "Ranking:";
            // 
            // BtnConfirmaCadastro
            // 
            this.BtnConfirmaCadastro.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.BtnConfirmaCadastro.FlatAppearance.BorderSize = 0;
            this.BtnConfirmaCadastro.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.BtnConfirmaCadastro.Font = new System.Drawing.Font("Segoe UI", 11F, System.Drawing.FontStyle.Bold);
            this.BtnConfirmaCadastro.ForeColor = System.Drawing.Color.White;
            this.BtnConfirmaCadastro.Image = global::SistemaCadastro.Properties.Resources.adicionar;
            this.BtnConfirmaCadastro.Location = new System.Drawing.Point(280, 200);
            this.BtnConfirmaCadastro.Name = "BtnConfirmaCadastro";
            this.BtnConfirmaCadastro.Size = new System.Drawing.Size(150, 45);
            this.BtnConfirmaCadastro.TabIndex = 13;
            this.BtnConfirmaCadastro.Text = " Confirmar";
            this.BtnConfirmaCadastro.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.BtnConfirmaCadastro.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.BtnConfirmaCadastro.UseVisualStyleBackColor = false;
            this.BtnConfirmaCadastro.Click += new System.EventHandler(this.BtnConfirmaCadastro_Click);
            // 
            // txtNota
            // 
            this.txtNota.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtNota.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtNota.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtNota.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtNota.Location = new System.Drawing.Point(121, 110);
            this.txtNota.Name = "txtNota";
            this.txtNota.Size = new System.Drawing.Size(500, 27);
            this.txtNota.TabIndex = 11;
            // 
            // txtNome
            // 
            this.txtNome.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtNome.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtNome.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtNome.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtNome.Location = new System.Drawing.Point(121, 30);
            this.txtNome.Name = "txtNome";
            this.txtNome.Size = new System.Drawing.Size(500, 27);
            this.txtNome.TabIndex = 9;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label3.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label3.Location = new System.Drawing.Point(21, 112);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(45, 20);
            this.label3.TabIndex = 8;
            this.label3.Text = "Nota:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label2.Location = new System.Drawing.Point(21, 73);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(42, 20);
            this.label2.TabIndex = 7;
            this.label2.Text = "Tipo:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label4.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label4.Location = new System.Drawing.Point(21, 32);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(53, 20);
            this.label4.TabIndex = 6;
            this.label4.Text = "Nome:";
            // 
            // tabBuscar
            // 
            this.tabBuscar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.tabBuscar.Controls.Add(this.btnAlterar);
            this.tabBuscar.Controls.Add(this.btnRemoveObra);
            this.tabBuscar.Controls.Add(this.label5);
            this.tabBuscar.Controls.Add(this.txtBusca);
            this.tabBuscar.Controls.Add(this.dgObras);
            this.tabBuscar.Location = new System.Drawing.Point(4, 29);
            this.tabBuscar.Name = "tabBuscar";
            this.tabBuscar.Padding = new System.Windows.Forms.Padding(3);
            this.tabBuscar.Size = new System.Drawing.Size(672, 257);
            this.tabBuscar.TabIndex = 1;
            this.tabBuscar.Text = "Buscar";
            // 
            // btnAlterar
            // 
            this.btnAlterar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.btnAlterar.FlatAppearance.BorderSize = 0;
            this.btnAlterar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAlterar.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnAlterar.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.btnAlterar.Image = ((System.Drawing.Image)(resources.GetObject("btnAlterar.Image")));
            this.btnAlterar.ImageAlign = System.Drawing.ContentAlignment.TopLeft;
            this.btnAlterar.Location = new System.Drawing.Point(526, 5);
            this.btnAlterar.Name = "btnAlterar";
            this.btnAlterar.Size = new System.Drawing.Size(100, 44);
            this.btnAlterar.TabIndex = 15;
            this.btnAlterar.Text = "Alterar";
            this.btnAlterar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnAlterar.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btnAlterar.UseVisualStyleBackColor = false;
            this.btnAlterar.Click += new System.EventHandler(this.btnAlterar_Click);
            // 
            // btnRemoveObra
            // 
            this.btnRemoveObra.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.btnRemoveObra.FlatAppearance.BorderSize = 0;
            this.btnRemoveObra.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(0)))), ((int)(((byte)(0)))));
            this.btnRemoveObra.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnRemoveObra.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnRemoveObra.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.btnRemoveObra.Image = global::SistemaCadastro.Properties.Resources.minus;
            this.btnRemoveObra.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnRemoveObra.Location = new System.Drawing.Point(410, 5);
            this.btnRemoveObra.Name = "btnRemoveObra";
            this.btnRemoveObra.Size = new System.Drawing.Size(110, 44);
            this.btnRemoveObra.TabIndex = 14;
            this.btnRemoveObra.Text = "Remover";
            this.btnRemoveObra.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnRemoveObra.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btnRemoveObra.UseVisualStyleBackColor = false;
            this.btnRemoveObra.Click += new System.EventHandler(this.btnRemoveObra_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label5.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label5.Location = new System.Drawing.Point(20, 18);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(45, 20);
            this.label5.TabIndex = 2;
            this.label5.Text = "Obra:";
            // 
            // txtBusca
            // 
            this.txtBusca.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtBusca.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtBusca.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtBusca.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtBusca.Location = new System.Drawing.Point(70, 15);
            this.txtBusca.Name = "txtBusca";
            this.txtBusca.Size = new System.Drawing.Size(320, 27);
            this.txtBusca.TabIndex = 1;
            this.txtBusca.TextChanged += new System.EventHandler(this.txtBusca_TextChanged);
            // 
            // dgObras
            // 
            this.dgObras.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgObras.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.dgObras.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgObras.CellBorderStyle = System.Windows.Forms.DataGridViewCellBorderStyle.SingleHorizontal;
            this.dgObras.ColumnHeadersBorderStyle = System.Windows.Forms.DataGridViewHeaderBorderStyle.None;
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Segoe UI", 11F);
            dataGridViewCellStyle1.ForeColor = System.Drawing.Color.White;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dgObras.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.dgObras.ColumnHeadersHeight = 35;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Segoe UI", 11F);
            dataGridViewCellStyle2.ForeColor = System.Drawing.Color.WhiteSmoke;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(60)))), ((int)(((byte)(60)))), ((int)(((byte)(60)))));
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.Color.White;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.dgObras.DefaultCellStyle = dataGridViewCellStyle2;
            this.dgObras.EnableHeadersVisualStyles = false;
            this.dgObras.Location = new System.Drawing.Point(20, 60);
            this.dgObras.Name = "dgObras";
            this.dgObras.ReadOnly = true;
            this.dgObras.RowHeadersVisible = false;
            this.dgObras.RowTemplate.Height = 30;
            this.dgObras.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgObras.Size = new System.Drawing.Size(630, 200);
            this.dgObras.TabIndex = 0;
            // 
            // tabAlterar
            // 
            this.tabAlterar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.tabAlterar.Controls.Add(this.cbAlteraTipo);
            this.tabAlterar.Controls.Add(this.txtAlteraRanking);
            this.tabAlterar.Controls.Add(this.label7);
            this.tabAlterar.Controls.Add(this.txtAlteraNota);
            this.tabAlterar.Controls.Add(this.txtAlteraNome);
            this.tabAlterar.Controls.Add(this.label8);
            this.tabAlterar.Controls.Add(this.label9);
            this.tabAlterar.Controls.Add(this.label10);
            this.tabAlterar.Controls.Add(this.btnConfirmaAlteracao);
            this.tabAlterar.Location = new System.Drawing.Point(4, 29);
            this.tabAlterar.Name = "tabAlterar";
            this.tabAlterar.Padding = new System.Windows.Forms.Padding(3);
            this.tabAlterar.Size = new System.Drawing.Size(672, 257);
            this.tabAlterar.TabIndex = 2;
            this.tabAlterar.Text = "Alterar";
            // 
            // cbAlteraTipo
            // 
            this.cbAlteraTipo.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.cbAlteraTipo.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.cbAlteraTipo.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cbAlteraTipo.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.cbAlteraTipo.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.cbAlteraTipo.FormattingEnabled = true;
            this.cbAlteraTipo.Location = new System.Drawing.Point(120, 60);
            this.cbAlteraTipo.Name = "cbAlteraTipo";
            this.cbAlteraTipo.Size = new System.Drawing.Size(500, 28);
            this.cbAlteraTipo.TabIndex = 23;
            // 
            // txtAlteraRanking
            // 
            this.txtAlteraRanking.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtAlteraRanking.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtAlteraRanking.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtAlteraRanking.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtAlteraRanking.Location = new System.Drawing.Point(120, 140);
            this.txtAlteraRanking.Name = "txtAlteraRanking";
            this.txtAlteraRanking.Size = new System.Drawing.Size(500, 27);
            this.txtAlteraRanking.TabIndex = 20;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label7.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label7.Location = new System.Drawing.Point(20, 142);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(65, 20);
            this.label7.TabIndex = 21;
            this.label7.Text = "Ranking:";
            // 
            // txtAlteraNota
            // 
            this.txtAlteraNota.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtAlteraNota.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtAlteraNota.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtAlteraNota.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtAlteraNota.Location = new System.Drawing.Point(120, 100);
            this.txtAlteraNota.Name = "txtAlteraNota";
            this.txtAlteraNota.Size = new System.Drawing.Size(500, 27);
            this.txtAlteraNota.TabIndex = 19;
            // 
            // txtAlteraNome
            // 
            this.txtAlteraNome.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtAlteraNome.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtAlteraNome.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtAlteraNome.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtAlteraNome.Location = new System.Drawing.Point(120, 20);
            this.txtAlteraNome.Name = "txtAlteraNome";
            this.txtAlteraNome.Size = new System.Drawing.Size(500, 27);
            this.txtAlteraNome.TabIndex = 17;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label8.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label8.Location = new System.Drawing.Point(20, 102);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(45, 20);
            this.label8.TabIndex = 16;
            this.label8.Text = "Nota:";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label9.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label9.Location = new System.Drawing.Point(20, 63);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(42, 20);
            this.label9.TabIndex = 15;
            this.label9.Text = "Tipo:";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label10.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label10.Location = new System.Drawing.Point(20, 22);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(53, 20);
            this.label10.TabIndex = 14;
            this.label10.Text = "Nome:";
            // 
            // btnConfirmaAlteracao
            // 
            this.btnConfirmaAlteracao.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.btnConfirmaAlteracao.FlatAppearance.BorderSize = 0;
            this.btnConfirmaAlteracao.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnConfirmaAlteracao.Font = new System.Drawing.Font("Segoe UI", 11F, System.Drawing.FontStyle.Bold);
            this.btnConfirmaAlteracao.ForeColor = System.Drawing.Color.White;
            this.btnConfirmaAlteracao.Image = ((System.Drawing.Image)(resources.GetObject("btnConfirmaAlteracao.Image")));
            this.btnConfirmaAlteracao.Location = new System.Drawing.Point(280, 200);
            this.btnConfirmaAlteracao.Name = "btnConfirmaAlteracao";
            this.btnConfirmaAlteracao.Size = new System.Drawing.Size(150, 45);
            this.btnConfirmaAlteracao.TabIndex = 22;
            this.btnConfirmaAlteracao.Text = " Salvar";
            this.btnConfirmaAlteracao.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnConfirmaAlteracao.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.btnConfirmaAlteracao.UseVisualStyleBackColor = false;
            this.btnConfirmaAlteracao.Click += new System.EventHandler(this.btnConfirmaAlteracao_Click);
            // 
            // lblMensagem
            // 
            this.lblMensagem.AutoSize = true;
            this.lblMensagem.ForeColor = System.Drawing.Color.Red;
            this.lblMensagem.Location = new System.Drawing.Point(544, 26);
            this.lblMensagem.Name = "lblMensagem";
            this.lblMensagem.Size = new System.Drawing.Size(0, 13);
            this.lblMensagem.TabIndex = 1;
            // 
            // button2
            // 
            this.button2.FlatAppearance.BorderSize = 0;
            this.button2.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.button2.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button2.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold);
            this.button2.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.button2.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.button2.Location = new System.Drawing.Point(860, 5);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(35, 35);
            this.button2.TabIndex = 8;
            this.button2.Text = "X";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // Sistema
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.ClientSize = new System.Drawing.Size(900, 500);
            this.Controls.Add(this.lblMensagem);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.panel4);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Sistema";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Sistema Watchpoint";
            this.Load += new System.EventHandler(this.Sistema_Load);
            this.panel1.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.tabControl1.ResumeLayout(false);
            this.tabCadastrar.ResumeLayout(false);
            this.tabCadastrar.PerformLayout();
            this.tabBuscar.ResumeLayout(false);
            this.tabBuscar.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgObras)).EndInit();
            this.tabAlterar.ResumeLayout(false);
            this.tabAlterar.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btnCadastra;
        private System.Windows.Forms.Button btnBusca;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabCadastrar;
        private System.Windows.Forms.TabPage tabBuscar;
        private System.Windows.Forms.Button BtnConfirmaCadastro;
        private System.Windows.Forms.TextBox txtNota;
        private System.Windows.Forms.TextBox txtNome;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Panel marcador;
        private System.Windows.Forms.TextBox txtRanking;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DataGridView dgObras;
        private System.Windows.Forms.Label lblMensagem;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox txtBusca;
        private System.Windows.Forms.Button btnRemoveObra;
        private System.Windows.Forms.Button btnAlterar;
        private System.Windows.Forms.TabPage tabAlterar;
        private System.Windows.Forms.TextBox txtAlteraRanking;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button btnConfirmaAlteracao;
        private System.Windows.Forms.TextBox txtAlteraNota;
        private System.Windows.Forms.TextBox txtAlteraNome;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.ComboBox cbTipo;
        private System.Windows.Forms.ComboBox cbAlteraTipo;
        private System.Windows.Forms.Button bntAddTipo;
    }
}
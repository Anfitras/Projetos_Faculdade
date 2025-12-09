namespace SistemaCadastro
{
    partial class FrmCadastro
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
            this.txtUserCadastro = new System.Windows.Forms.TextBox();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.txtSenhaCadastro = new System.Windows.Forms.TextBox();
            this.BtnCadastro = new System.Windows.Forms.Button();
            this.btnFechar = new System.Windows.Forms.Button();
            this.txtConfirmarSenhaCadastro = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.linkLabel1 = new System.Windows.Forms.LinkLabel();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtUserCadastro
            // 
            this.txtUserCadastro.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtUserCadastro.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtUserCadastro.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtUserCadastro.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtUserCadastro.Location = new System.Drawing.Point(205, 111);
            this.txtUserCadastro.Name = "txtUserCadastro";
            this.txtUserCadastro.Size = new System.Drawing.Size(191, 27);
            this.txtUserCadastro.TabIndex = 12;
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.panel2.Controls.Add(this.panel3);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel2.Location = new System.Drawing.Point(0, 0);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(595, 15);
            this.panel2.TabIndex = 17;
            // 
            // panel3
            // 
            this.panel3.Location = new System.Drawing.Point(45, 37);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(125, 131);
            this.panel3.TabIndex = 2;
            this.panel3.Visible = false;
            // 
            // txtSenhaCadastro
            // 
            this.txtSenhaCadastro.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtSenhaCadastro.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtSenhaCadastro.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtSenhaCadastro.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtSenhaCadastro.Location = new System.Drawing.Point(205, 171);
            this.txtSenhaCadastro.Name = "txtSenhaCadastro";
            this.txtSenhaCadastro.PasswordChar = '*';
            this.txtSenhaCadastro.Size = new System.Drawing.Size(191, 27);
            this.txtSenhaCadastro.TabIndex = 18;
            // 
            // BtnCadastro
            // 
            this.BtnCadastro.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.BtnCadastro.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.BtnCadastro.FlatAppearance.BorderSize = 0;
            this.BtnCadastro.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.BtnCadastro.Font = new System.Drawing.Font("Segoe UI", 11F, System.Drawing.FontStyle.Bold);
            this.BtnCadastro.ForeColor = System.Drawing.Color.White;
            this.BtnCadastro.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.BtnCadastro.Location = new System.Drawing.Point(245, 278);
            this.BtnCadastro.Name = "BtnCadastro";
            this.BtnCadastro.Size = new System.Drawing.Size(113, 45);
            this.BtnCadastro.TabIndex = 19;
            this.BtnCadastro.Text = "Cadastrar";
            this.BtnCadastro.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.BtnCadastro.UseVisualStyleBackColor = false;
            this.BtnCadastro.Click += new System.EventHandler(this.BtnCadastro_Click);
            // 
            // btnFechar
            // 
            this.btnFechar.AutoSize = true;
            this.btnFechar.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnFechar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.btnFechar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnFechar.Font = new System.Drawing.Font("Microsoft Sans Serif", 1F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnFechar.Image = global::SistemaCadastro.Properties.Resources.close;
            this.btnFechar.Location = new System.Drawing.Point(543, 21);
            this.btnFechar.Name = "btnFechar";
            this.btnFechar.Size = new System.Drawing.Size(40, 40);
            this.btnFechar.TabIndex = 16;
            this.btnFechar.UseVisualStyleBackColor = false;
            this.btnFechar.Click += new System.EventHandler(this.btnFechar_Click);
            // 
            // txtConfirmarSenhaCadastro
            // 
            this.txtConfirmarSenhaCadastro.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtConfirmarSenhaCadastro.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtConfirmarSenhaCadastro.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtConfirmarSenhaCadastro.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtConfirmarSenhaCadastro.Location = new System.Drawing.Point(205, 231);
            this.txtConfirmarSenhaCadastro.Name = "txtConfirmarSenhaCadastro";
            this.txtConfirmarSenhaCadastro.PasswordChar = '*';
            this.txtConfirmarSenhaCadastro.Size = new System.Drawing.Size(191, 27);
            this.txtConfirmarSenhaCadastro.TabIndex = 24;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(202, 95);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(132, 16);
            this.label1.TabIndex = 21;
            this.label1.Text = "Nome de Usuário:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(202, 155);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 16);
            this.label2.TabIndex = 22;
            this.label2.Text = "Senha:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(202, 215);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(125, 16);
            this.label3.TabIndex = 23;
            this.label3.Text = "Confirmar Senha:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(216, 37);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(168, 37);
            this.label4.TabIndex = 25;
            this.label4.Text = "Cadastrar";
            this.label4.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.ForeColor = System.Drawing.Color.White;
            this.label5.Location = new System.Drawing.Point(220, 339);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(91, 13);
            this.label5.TabIndex = 26;
            this.label5.Text = "Já tem um conta?";
            // 
            // linkLabel1
            // 
            this.linkLabel1.AutoSize = true;
            this.linkLabel1.LinkColor = System.Drawing.Color.Red;
            this.linkLabel1.Location = new System.Drawing.Point(308, 339);
            this.linkLabel1.Name = "linkLabel1";
            this.linkLabel1.Size = new System.Drawing.Size(60, 13);
            this.linkLabel1.TabIndex = 27;
            this.linkLabel1.TabStop = true;
            this.linkLabel1.Text = "Clique Aqui";
            this.linkLabel1.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.linkLabel1_LinkClicked);
            // 
            // FrmCadastro
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.ClientSize = new System.Drawing.Size(595, 372);
            this.Controls.Add(this.linkLabel1);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtConfirmarSenhaCadastro);
            this.Controls.Add(this.BtnCadastro);
            this.Controls.Add(this.txtSenhaCadastro);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.btnFechar);
            this.Controls.Add(this.txtUserCadastro);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FrmCadastro";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "FrmCadastro";
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtUserCadastro;
        private System.Windows.Forms.Button btnFechar;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.TextBox txtSenhaCadastro;
        private System.Windows.Forms.Button BtnCadastro;
        private System.Windows.Forms.TextBox txtConfirmarSenhaCadastro;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.LinkLabel linkLabel1;
    }
}
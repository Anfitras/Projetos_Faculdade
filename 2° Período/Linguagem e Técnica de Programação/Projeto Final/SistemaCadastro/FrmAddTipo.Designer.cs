namespace SistemaCadastro
{
    partial class FrmAddTipo
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
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.txtAddGenero = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.btnFechar = new System.Windows.Forms.Button();
            this.BtnConfirmaCadastro = new System.Windows.Forms.Button();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.panel2.Controls.Add(this.panel3);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel2.Location = new System.Drawing.Point(0, 0);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(593, 15);
            this.panel2.TabIndex = 2;
            // 
            // panel3
            // 
            this.panel3.Location = new System.Drawing.Point(45, 37);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(125, 131);
            this.panel3.TabIndex = 2;
            this.panel3.Visible = false;
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.panel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel1.Location = new System.Drawing.Point(0, 15);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(105, 314);
            this.panel1.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(190, 37);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(217, 29);
            this.label1.TabIndex = 4;
            this.label1.Text = "Adicionar Gênero";
            // 
            // txtAddGenero
            // 
            this.txtAddGenero.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(32)))), ((int)(((byte)(32)))), ((int)(((byte)(32)))));
            this.txtAddGenero.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtAddGenero.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.txtAddGenero.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(240)))), ((int)(((byte)(240)))), ((int)(((byte)(240)))));
            this.txtAddGenero.Location = new System.Drawing.Point(195, 104);
            this.txtAddGenero.Name = "txtAddGenero";
            this.txtAddGenero.Size = new System.Drawing.Size(324, 27);
            this.txtAddGenero.TabIndex = 11;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Segoe UI", 11F);
            this.label4.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(160)))), ((int)(((byte)(160)))), ((int)(((byte)(160)))));
            this.label4.Location = new System.Drawing.Point(117, 106);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(60, 20);
            this.label4.TabIndex = 10;
            this.label4.Text = "Gênero:";
            // 
            // btnFechar
            // 
            this.btnFechar.AutoSize = true;
            this.btnFechar.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.btnFechar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.btnFechar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnFechar.Font = new System.Drawing.Font("Microsoft Sans Serif", 1F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnFechar.Image = global::SistemaCadastro.Properties.Resources.close;
            this.btnFechar.Location = new System.Drawing.Point(538, 21);
            this.btnFechar.Name = "btnFechar";
            this.btnFechar.Size = new System.Drawing.Size(40, 40);
            this.btnFechar.TabIndex = 15;
            this.btnFechar.UseVisualStyleBackColor = false;
            this.btnFechar.Click += new System.EventHandler(this.btnFechar_Click);
            // 
            // BtnConfirmaCadastro
            // 
            this.BtnConfirmaCadastro.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(176)))), ((int)(((byte)(0)))), ((int)(((byte)(32)))));
            this.BtnConfirmaCadastro.FlatAppearance.BorderSize = 0;
            this.BtnConfirmaCadastro.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.BtnConfirmaCadastro.Font = new System.Drawing.Font("Segoe UI", 11F, System.Drawing.FontStyle.Bold);
            this.BtnConfirmaCadastro.ForeColor = System.Drawing.Color.White;
            this.BtnConfirmaCadastro.Image = global::SistemaCadastro.Properties.Resources.adicionar;
            this.BtnConfirmaCadastro.Location = new System.Drawing.Point(257, 209);
            this.BtnConfirmaCadastro.Name = "BtnConfirmaCadastro";
            this.BtnConfirmaCadastro.Size = new System.Drawing.Size(150, 45);
            this.BtnConfirmaCadastro.TabIndex = 14;
            this.BtnConfirmaCadastro.Text = " Confirmar";
            this.BtnConfirmaCadastro.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.BtnConfirmaCadastro.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText;
            this.BtnConfirmaCadastro.UseVisualStyleBackColor = false;
            this.BtnConfirmaCadastro.Click += new System.EventHandler(this.BtnConfirmaCadastro_Click);
            // 
            // FrmAddTipo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(18)))), ((int)(((byte)(18)))), ((int)(((byte)(18)))));
            this.ClientSize = new System.Drawing.Size(593, 329);
            this.Controls.Add(this.btnFechar);
            this.Controls.Add(this.BtnConfirmaCadastro);
            this.Controls.Add(this.txtAddGenero);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.panel2);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "FrmAddTipo";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "FrmAddTipo";
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtAddGenero;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button BtnConfirmaCadastro;
        private System.Windows.Forms.Button btnFechar;
    }
}
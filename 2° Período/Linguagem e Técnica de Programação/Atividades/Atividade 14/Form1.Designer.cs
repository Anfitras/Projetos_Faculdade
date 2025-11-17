namespace ProjetoIMC
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            txtPeso = new TextBox();
            btnCalcular = new Button();
            label2 = new Label();
            label3 = new Label();
            txtAltura = new TextBox();
            lblResultado = new Label();
            lblGrau = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F, FontStyle.Bold);
            label1.ForeColor = Color.FromArgb(128, 64, 0);
            label1.Location = new Point(250, 22);
            label1.Name = "label1";
            label1.Size = new Size(168, 32);
            label1.TabIndex = 0;
            label1.Text = "SISTEMA IMC";
            // 
            // txtPeso
            // 
            txtPeso.Font = new Font("Segoe UI", 14F);
            txtPeso.Location = new Point(250, 72);
            txtPeso.Name = "txtPeso";
            txtPeso.Size = new Size(168, 32);
            txtPeso.TabIndex = 1;
            // 
            // btnCalcular
            // 
            btnCalcular.FlatStyle = FlatStyle.Flat;
            btnCalcular.Font = new Font("Segoe UI", 14F, FontStyle.Bold);
            btnCalcular.ForeColor = Color.FromArgb(128, 64, 0);
            btnCalcular.Location = new Point(250, 169);
            btnCalcular.Name = "btnCalcular";
            btnCalcular.Size = new Size(168, 37);
            btnCalcular.TabIndex = 2;
            btnCalcular.Text = "Calcular";
            btnCalcular.UseVisualStyleBackColor = true;
            btnCalcular.Click += btnCalcular_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 18F, FontStyle.Bold);
            label2.ForeColor = Color.FromArgb(128, 64, 0);
            label2.Location = new Point(123, 72);
            label2.Name = "label2";
            label2.Size = new Size(80, 32);
            label2.TabIndex = 3;
            label2.Text = "PESO:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 18F, FontStyle.Bold);
            label3.ForeColor = Color.FromArgb(128, 64, 0);
            label3.Location = new Point(123, 116);
            label3.Name = "label3";
            label3.Size = new Size(112, 32);
            label3.TabIndex = 4;
            label3.Text = "ALTURA:";
            // 
            // txtAltura
            // 
            txtAltura.Font = new Font("Segoe UI", 14F);
            txtAltura.Location = new Point(250, 116);
            txtAltura.Name = "txtAltura";
            txtAltura.Size = new Size(168, 32);
            txtAltura.TabIndex = 5;
            // 
            // lblResultado
            // 
            lblResultado.AutoSize = true;
            lblResultado.Font = new Font("Segoe UI", 18F, FontStyle.Bold);
            lblResultado.ForeColor = Color.FromArgb(128, 64, 0);
            lblResultado.Location = new Point(235, 229);
            lblResultado.Name = "lblResultado";
            lblResultado.Size = new Size(0, 32);
            lblResultado.TabIndex = 6;
            // 
            // lblGrau
            // 
            lblGrau.AutoSize = true;
            lblGrau.Font = new Font("Segoe UI", 18F, FontStyle.Bold);
            lblGrau.ForeColor = Color.FromArgb(128, 64, 0);
            lblGrau.Location = new Point(250, 271);
            lblGrau.Name = "lblGrau";
            lblGrau.Size = new Size(0, 32);
            lblGrau.TabIndex = 7;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.White;
            ClientSize = new Size(691, 321);
            Controls.Add(lblGrau);
            Controls.Add(lblResultado);
            Controls.Add(txtAltura);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(btnCalcular);
            Controls.Add(txtPeso);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox txtPeso;
        private Button btnCalcular;
        private Label label2;
        private Label label3;
        private TextBox txtAltura;
        private Label lblResultado;
        private Label lblGrau;
    }
}

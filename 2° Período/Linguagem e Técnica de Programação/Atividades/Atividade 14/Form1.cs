namespace ProjetoIMC
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnCalcular_Click(object sender, EventArgs e)
        {
            double peso = double.Parse(txtPeso.Text);
            double altura = double.Parse(txtAltura.Text);
            double imc = peso / (altura * altura);
            string grauPeso = "";

            if (imc > 18.5 && imc < 24.9)
            {
                grauPeso = "Peso Normal";
            }
            else if (imc >= 25 && imc < 29.9)
            {
                grauPeso = "Sobrepeso";
            }
            else if (imc >= 30 && imc < 34.9)
            {
                grauPeso = "Obesidade Grau I";
            }
            else if (imc >= 35 && imc < 39.9)
            {
                grauPeso = "Obesidade Grau II";
            }
            else if (imc >= 40)
            {
                grauPeso = "Obesidade Grau III";
            }
            else
            {
                grauPeso = "Abaixo do Peso";
            }

            lblResultado.Text = "Seu IMC é: " + imc.ToString("F2");
            lblGrau.Text = grauPeso;
        }

    }
}

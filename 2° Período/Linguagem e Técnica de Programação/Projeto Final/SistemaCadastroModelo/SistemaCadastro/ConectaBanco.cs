using MySql.Data.MySqlClient;
using Mysqlx;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SistemaCadastro
{
    internal class ConectaBanco
    {
        MySqlConnection conexao = new MySqlConnection("server=*;port=*;user id=root;password=*;database=*");
        public string mensagem;

        public bool insereObra(Obra novaObra)
        {
            try
            {
                conexao.Open();
                MySqlCommand cmd = new MySqlCommand("sp_insereObra", conexao);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("nome", novaObra.Nome);
                cmd.Parameters.AddWithValue("id_tipo", novaObra.Tipo);
                cmd.Parameters.AddWithValue("nota", novaObra.Nota);
                cmd.Parameters.AddWithValue("rank_popularidade", novaObra.Ranking);
                cmd.ExecuteNonQuery();
                return true;
            }
            catch (MySqlException erro)
            {
                if (erro.Number == 1062 || erro.Message.Contains("Duplicate entry"))
                {
                    mensagem = "Esta obra já está cadastrada no sistema.";
                }
                else
                {
                    mensagem = "Erro técnico: " + erro.Message;
                }
                return false;
            }
            finally
            {
                if (conexao.State == ConnectionState.Open)
                    conexao.Close();
            }
        }

        public DataTable listaTipos()
        {
            MySqlCommand cmd = new MySqlCommand("sp_listaTipos", conexao);
            cmd.CommandType = CommandType.StoredProcedure;
            try
            {
                conexao.Open();
                MySqlDataAdapter da = new MySqlDataAdapter(cmd);
                DataTable tabela = new DataTable();
                da.Fill(tabela);
                return tabela;
            }
            catch (MySqlException e)
            {
                mensagem = "Erro: " + e.Message;
                return null;
            }
            finally
            {
                conexao.Close();
            }
        }

        public DataTable listaObras()
        {
            MySqlCommand cmd = new MySqlCommand("sp_listaObras", conexao);
            cmd.CommandType = CommandType.StoredProcedure;
            try
            {
                conexao.Open();
                MySqlDataAdapter da = new MySqlDataAdapter(cmd);
                DataTable tabela = new DataTable();
                da.Fill(tabela);
                return tabela;
            }
            catch (MySqlException e)
            {
                mensagem = "Erro" + e.Message;
                return null;
            }
            finally
            {
                conexao.Close();
            }
        }


        public bool removeObra(int idRemove)
        {
            MySqlCommand cmd = new MySqlCommand("sp_removeObra", conexao);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("idObra", idRemove);
            try
            {
                conexao.Open();
                cmd.ExecuteNonQuery();
                return true;
            }
            catch (MySqlException e)
            {
                mensagem = "Erro: " + e.Message;
                return false;
            }
            finally
            {
                conexao.Close();
            }
        }

        public bool alteraObra(Obra o, int idObra)
        {
            MySqlCommand cmd = new MySqlCommand("sp_alteraObra", conexao);
            cmd.CommandType = CommandType.StoredProcedure;

            cmd.Parameters.AddWithValue("idObra", idObra);
            cmd.Parameters.AddWithValue("nome", o.Nome);
            cmd.Parameters.AddWithValue("tipo", o.Tipo);
            cmd.Parameters.AddWithValue("nota", o.Nota);
            cmd.Parameters.AddWithValue("rank_popularidade", o.Ranking);

            try
            {
                conexao.Open();
                cmd.ExecuteNonQuery();
                return true;
            }
            catch (MySqlException erro)
            {
                if (erro.Number == 1062 || erro.Message.Contains("Duplicate entry"))
                {
                    mensagem = "Já existe outra obra com esse nome. Escolha um nome único.";
                }
                else
                {
                    mensagem = "Erro técnico ao alterar: " + erro.Message;
                }
                return false;
            }
            finally
            {
                if (conexao.State == ConnectionState.Open)
                    conexao.Close();
            }
        }

        public bool insereTipo(string nomeTipo)
        {
            try
            {
                conexao.Open();
                MySqlCommand cmd = new MySqlCommand("sp_insereTipo", conexao);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("nomeTipo", nomeTipo);
                cmd.ExecuteNonQuery();
                return true;
            }
            catch (MySqlException erro)
            {
                if (erro.Number == 1062 || erro.Message.Contains("Duplicate entry"))
                {
                    mensagem = "Esse tipo já existe.";
                }
                else
                {
                    mensagem = "Erro técnico ao alterar: " + erro.Message;
                }
                return false;
            }
        }

        public bool verifica(string user, string senha)
        {
            string senhaHash = Biblioteca.makeHash(senha);
            MySqlCommand cmd = new MySqlCommand("sp_consultaLogin", conexao);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("usuario", user);
            cmd.Parameters.AddWithValue("senha", senhaHash);
            try
            {
                conexao.Open();
                MySqlDataAdapter da = new MySqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            catch (Exception e)
            {
                mensagem = "Erro: " + e.Message;
                return false;
            }
            finally
            {
                conexao.Close();
            }
        }

        public bool InsereUsuario(string usuario, string senha)
        {
            MySqlCommand cmd = new MySqlCommand("sp_cadastroUsuario", conexao);
            cmd.CommandType = CommandType.StoredProcedure;
            string senhaHash = Biblioteca.makeHash(senha);
            cmd.Parameters.AddWithValue("usuario", usuario);
            cmd.Parameters.AddWithValue("senha", senhaHash);
            try
            {
                conexao.Open();
                cmd.ExecuteNonQuery();
                return true;
            }
            catch (MySqlException e)
            {
                if (e.Number == 1062)
                {
                    mensagem = "Nome de usuário já existe.";
                }
                else
                {
                    mensagem = "Erro: " + e.Message;
                }
                return false;
            }
            finally
            {
                conexao.Close();
            }
        }
    }
}

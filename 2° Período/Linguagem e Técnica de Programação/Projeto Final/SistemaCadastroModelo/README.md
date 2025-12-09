# Sistema de Cadastro de Obras

Sistema desktop desenvolvido em C# Windows Forms para gerenciamento e cadastro de filmes, séries, documentários, etc.

## 📋 Descrição

Este projeto é um sistema de cadastro que permite gerenciar informações sobre obras, incluindo nome, tipo (filme, série), nota (entre 1 - 10) e ranking. O sistema utiliza MySQL como banco de dados e oferece uma interface gráfica intuitiva para cadastro e busca de informações.

## 🚀 Tecnologias Utilizadas

- **C# (.NET Framework)** - Linguagem de programação
- **Windows Forms** - Framework para interface gráfica
- **MySQL 8.0.45** - Sistema de gerenciamento de banco de dados
- **Railway** - Site usado para lançamento nas nuvens do banco de dados.
- **Visual Studio 2026** - IDE de desenvolvimento

## 🗄️ Estrutura do Banco de Dados

O sistema utiliza três tabelas principais:

### Tabela `obras`
- `id` (INT, AUTO_INCREMENT, PRIMARY KEY)
- `nome` (VARCHAR(255))
- `id_tipo` (INT, FOREIGN KEY)
-  `nota` (DECIMAL(3,1))
-  `rank_popularidade` (INT)

### Tabela `tipo`
- `id` (INT, AUTO_INCREMENT, PRIMARY KEY)
- `tipo` (VARCHAR(45))
- `integrantes` (INT)

### Tabela `usuarios`
- `idUsuario` (INT, AUTO_INCREMENT, PRIMARY KEY)
- `user` (VARCHAR(100))
- `senha` (VARCHAR(100))

### Stored Procedures

- `sp_alteraObra` - Altera dados de uma obra
- `sp_cadastroUsuario` - Insere um novo usuário no banco
- `sp_consultaLogin` - Lista todos os usuários do banco
- `sp_insereObra` - Insere uma nova obra no banco
- `sp_insereTipo` - Insere um novo tipo de obra no banco
- `sp_listaObras` - Lista todas as obras com seus tipos
- `sp_listaTipos` - Lista todos os tipos de obras disponíveis
- `sp_removeObra` - Remove uma obra do banco

## 🎯 Funcionalidades do Sistema

- ✅ **Cadastro de Obras** - Adicione novas obras com informações completas (necessário preencher todos os campos)
- 🔍 **Busca de Obras** - Pesquise obras cadastradas
- 📝 **Alteração de Dados** - Edite informações de obras existentes
- 🗑️ **Remoção de Obras** - Exclua registros de obras do sistema
- 🎬 **Gerenciamento de Tipos** - Adicione novos tipos de obras
- 📊 **Visualização em Lista** - Veja todas as obras cadastradas

## 🎨 Interface

O sistema inicia na pagina de login:

- **Aba Login** - Formulário para entrar no sistema com base em usuários já cadastrados
- **Aba Cadastro** - Formulário para cadastrar um novo usuário no sistema

O sistema possui uma interface com navegação por abas:

- **Aba Cadastro** - Formulário para inserir novas obras
- **Aba Busca** - Interface para pesquisar e visualizar obras cadastradas

A navegação é facilitada por botões laterais com indicador visual de aba selecionada.


## 📝 Licença

Este projeto é um trabalho acadêmico desenvolvido para fins educacionais.

## 👥 Autor

Desenvolvido como projeto do curso de Linguagem e Técnica de Programação I
Desenvolvido por Arthur Serapião Beraldo

---


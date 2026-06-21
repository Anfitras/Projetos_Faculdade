# Armazém - Sistema de Gerenciamento de Armazém

> **Trabalho Prático de Sistemas de Informação - 3º Período**
>
> **Instituto Federal de Educação, Ciência e Tecnologia do Sul de Minas Gerais - Campus Machado, MG**

---

## 📋 Informações do Projeto

- **Desenvolvedor**: Arthur Serapião Beraldo
- **Orientador**: Prof. Matheus Guedes
- **Instituição**: IFSULDEMINAS - Campus Machado
- **Período**: 3º Período de Sistemas de Informação
- **Data de Entrega**: 2026

---

## 📌 Descrição

O **Armazém** é um sistema web de gerenciamento de armazém desenvolvido como trabalho prático do curso de Sistemas de Informação. O sistema permite o controle completo de:

- **Gestão de Produtos**: Cadastro, atualização e controle de estoque de produtos
- **Controle de Fornecedores**: Gerenciamento de fornecedores e suas informações
- **Gestão de Clientes**: Cadastro e manutenção de dados de clientes
- **Movimentação de Estoque**: Registro de entradas e saídas de produtos
- **Vendas**: Processamento de vendas com cálculo automático de valores
- **Dashboard**: Visualização de métricas e dados consolidados do armazém
- **Autenticação**: Sistema de login com controle de usuários e perfis

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Framework**: Spring Boot 4.0.6
- **Linguagem**: Java 26
- **ORM**: JPA/Hibernate
- **Database**: MySQL
- **Build Tool**: Maven
- **Bibliotecas Adicionais**:
  - Lombok (para redução de boilerplate)
  - Jackson (para serialização JSON)

### Frontend
- **HTML5** - Estrutura
- **CSS3** - Estilização
- **JavaScript Vanilla** - Interatividade
- **Fetch API** - Comunicação com backend

---

## 🚀 Como Começar

### Pré-requisitos

- **Java 26** ou superior
- **Maven 3.8.0** ou superior
- **MySQL 8.0** ou superior
- **Git**
- **Navegador web moderno**

### 1. Clonar o Repositório

```bash
git clone <URL-DO-REPOSITORIO>
cd TrabalhoPraticoSpringBoot
```

### 2. Configurar o Banco de Dados

#### Opção A: Usar o banco existente (Railway)

O arquivo `application.properties` já contém as configurações de conexão com um banco de dados MySQL hospedado. Você pode usar direto:

```bash
cd armazem-backend
```

#### Opção B: Configurar Banco Local (Recomendado para Desenvolvimento)

1. **Instale o MySQL** e crie um banco de dados:

```sql
CREATE DATABASE armazem_db;
USE armazem_db;
```

2. **Edite o arquivo de configuração**:

Abra `armazem-backend/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/armazem_db?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

3. **Execute o script de inicialização** (se disponível) ou deixe o Hibernate criar as tabelas automaticamente com `ddl-auto=create`

### 3. Instalar Dependências (Backend)

```bash
cd armazem-backend
mvn clean install
```

### 4. Executar a Aplicação

#### Backend (Spring Boot)

```bash
mvn spring-boot:run
```

O backend estará disponível em: `http://localhost:8080`

#### Frontend

Você pode servir o frontend de diferentes formas:

**Opção 1: Usando um servidor HTTP simples (Python)**

```bash
cd ../frontend
python -m http.server 8000
```

Acesse: `http://localhost:8000/login.html`

**Opção 2: Usando Node.js com http-server**

```bash
cd ../frontend
npx http-server
```

**Opção 3: Abrir arquivo diretamente**

Abra `frontend/login.html` no navegador (menos recomendado)

---

## 🔑 Credenciais Padrão

Para acessar o sistema, use as seguintes credenciais (você pode cadastrar novas após logar):

- **Usuário**: `admin`
- **Senha**: `admin123` (ajuste conforme seu banco de dados)

- **Usuário**: `caixa`
- **Senha**: `caixa123` (ajuste conforme seu banco de dados)

> **Nota**: As credenciais padrão devem ser alteradas na primeira utilização em ambiente de produção.

---

## 📡 Endpoints da API

A API REST está disponível em `http://localhost:8080/api`

### Autenticação

- `POST /api/auth/login` - Autentica um usuário
  - Body: `{ "username": "admin", "senha": "admin123" }`
  - Response: Dados do usuário autenticado

### Produtos

- `GET /api/produtos` - Lista todos os produtos
- `GET /api/produtos/{id}` - Busca um produto específico
- `POST /api/produtos` - Cria um novo produto
- `PUT /api/produtos/{id}` - Atualiza um produto
- `DELETE /api/produtos/{id}` - Deleta um produto

### Clientes

- `GET /api/clientes` - Lista todos os clientes
- `GET /api/clientes/{id}` - Busca um cliente específico
- `POST /api/clientes` - Cria um novo cliente
- `PUT /api/clientes/{id}` - Atualiza um cliente
- `DELETE /api/clientes/{id}` - Deleta um cliente

### Fornecedores

- `GET /api/fornecedores` - Lista todos os fornecedores
- `GET /api/fornecedores/{id}` - Busca um fornecedor específico
- `POST /api/fornecedores` - Cria um novo fornecedor
- `PUT /api/fornecedores/{id}` - Atualiza um fornecedor
- `DELETE /api/fornecedores/{id}` - Deleta um fornecedor

### Vendas

- `GET /api/vendas` - Lista todas as vendas
- `GET /api/vendas/{id}` - Busca uma venda específica
- `POST /api/vendas` - Cria uma nova venda
- `PUT /api/vendas/{id}` - Atualiza uma venda
- `DELETE /api/vendas/{id}` - Cancela uma venda

### Movimentação de Estoque

- `GET /api/estoque-movimentos` - Lista todas as movimentações
- `POST /api/estoque-movimentos` - Registra uma movimentação

### Dashboard

- `GET /api/dashboard` - Retorna dados consolidados do dashboard
  - Response: Métricas de produtos, vendas, clientes, etc.

---

## 🎯 Funcionalidades Principais

### 1. **Autenticação e Controle de Acesso**
   - Login seguro de usuários
   - Controle de sessão via localStorage
   - Proteção de rotas no frontend

### 2. **Gestão de Produtos**
   - Cadastro e atualização de produtos
   - Controle de estoque (mínimo e atual)
   - Código de barras
   - Preço de custo e venda
   - Informações de validade
   - Relação com fornecedores

### 3. **Gestão de Fornecedores**
   - Cadastro de fornecedores
   - Informações de contato
   - Vinculação com produtos

### 4. **Gestão de Clientes**
   - Cadastro de clientes
   - Dados de contato
   - Histórico de compras

### 5. **Processamento de Vendas**
   - Criação de pedidos de venda
   - Itens da venda com quantidade e preço
   - Cálculo automático do total
   - Forma de pagamento

### 6. **Movimentação de Estoque**
   - Registrar entradas de estoque
   - Registrar saídas de estoque
   - Histórico de movimentações
   - Tipos de movimento

### 7. **Dashboard**
   - Visualização de métricas principais
   - Produtos mais vendidos
   - Quantidade de clientes
   - Valor total de vendas
   - Produtos com baixo estoque

---

## 🧪 Testes Unitários

O projeto inclui testes unitários para as principais funcionalidades:

```bash
cd armazem-backend
mvn test
```

Testes incluídos:
- `ClienteServiceTest.java` - Testes do serviço de clientes
- `ProdutoServiceTest.java` - Testes do serviço de produtos
- `VendaServiceTest.java` - Testes do serviço de vendas

---

## 🔧 Construção e Deploy

### Compilar o Projeto

```bash
cd armazem-backend
mvn clean package
```

Isso gerará um arquivo JAR em `target/armazem-backend-1.0-SNAPSHOT.jar`

### Executar o JAR

```bash
java -jar target/armazem-backend-1.0-SNAPSHOT.jar
```

---

## 📊 Modelo de Dados

### Principais Tabelas

- **usuario** - Usuários do sistema
- **perfil** - Perfis de acesso (Admin, Gerente, Vendedor, etc.)
- **cliente** - Informações de clientes
- **fornecedor** - Informações de fornecedores
- **produto** - Catálogo de produtos
- **estoque_movimento** - Histórico de movimentações
- **tipo_movimento** - Tipos de movimento (Entrada, Saída, Devolução)
- **venda** - Pedidos de venda
- **venda_item** - Itens de cada venda
- **forma_pagamento** - Formas de pagamento disponíveis

### Relacionamentos Principais

```
Usuario (1) -------> (N) Venda
Fornecedor (1) -----> (N) Produto
Cliente (1) --------> (N) Venda
Produto (1) --------> (N) VendaItem
Venda (1) ---------> (N) VendaItem
Produto (1) --------> (N) EstoqueMovimento
```

---

## 🐛 Troubleshooting

### Problema: "Erro ao conectar com o servidor"

**Solução**: Certifique-se de que:
1. O backend está rodando em `http://localhost:8080`
2. O CORS está configurado corretamente (já está em `*`)
3. Verifique o console do navegador para mais detalhes

### Problema: "java.sql.SQLNonTransientConnectionException"

**Solução**: Verifique as credenciais do banco de dados em `application.properties`:
1. Host e porta corretos
2. Nome do banco existe
3. Usuário e senha estão certos

### Problema: "Produtos não aparecem no dashboard"

**Solução**:
1. Verifique se há produtos cadastrados no banco
2. Verifique se não há erros no console do backend
3. Limpe o cache do navegador (Ctrl + Shift + Del)

---

## 📝 Notas Importantes

- O arquivo `application.properties` contém as configurações de banco de dados e é mantido no repositório para facilitar a avaliação
- Senhas e dados sensíveis em ambiente de produção devem usar variáveis de ambiente
- O frontend comunica com o backend via FETCH API - certifique-se de estar usando um navegador moderno

---

## 📚 Recursos Adicionais

- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação JPA/Hibernate](https://hibernate.org/orm/)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [MDN Web Docs - Fetch API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API)

---

## 📄 Licença

Este projeto é desenvolvido como trabalho acadêmico no IFSULDEMINAS - Campus Machado.

---

## ✉️ Contato

**Desenvolvedor**: Arthur Serapião Beraldo  
**Orientador**: Prof. Matheus Guedes  
**Instituição**: IFSULDEMINAS - Campus Machado, MG

---

**Última atualização**: Junho de 2026

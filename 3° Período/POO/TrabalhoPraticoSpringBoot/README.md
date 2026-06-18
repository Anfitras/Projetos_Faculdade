# Sistema de Gestão de Armazém (ERP e PDV)

Um sistema completo (Full-Stack) para gerenciamento de estoque e frente de caixa (PDV), desenvolvido com o objetivo de aplicar conceitos avançados de Engenharia de Software, Arquitetura RESTful e Test-Driven Development (TDD).

Este projeto gerencia o fluxo completo de um armazém, desde a entrada de mercadorias e controle de validade até a venda ao consumidor final com emissão de recibo e estorno de estoque.

## 🚀 Funcionalidades

* **Frente de Caixa (PDV):** Interface rápida para registro de vendas, cálculo automático de subtotais, aplicação de descontos e emissão de recibo não fiscal para impressão.
* **Vínculo de Clientes:** Opção de associar o CPF do cliente à venda para histórico e fidelização.
* **Gestão de Estoque Dinâmica:** Baixa automática de produtos no ato da venda e geração de histórico de movimentação (Entrada/Saída) com rastreio de validade e lotes.
* **Cancelamento e Estorno:** Funcionalidade de anulação de vendas concluídas, com devolução automática e transparente dos itens ao estoque físico.
* **Dashboard Gerencial:** Painel analítico com indicadores de faturamento mensal, valor total imobilizado em estoque, alertas de produtos em nível crítico e gráficos dos itens mais vendidos.
* **Controle de Acesso:** Autenticação baseada em perfis (Administrador, Gerente e Operador de Caixa).
* **Gestão de Cadastros:** CRUD completo para Produtos, Fornecedores e Clientes, com validações de integridade no banco de dados (ex: CPF e CNPJ únicos).

## 🛠️ Tecnologias Utilizadas

**Backend:**
* Java
* Spring Boot (Web, Data JPA)
* Hibernate
* MySQL (Banco de Dados Relacional)
* JUnit 5 e Mockito (Testes Automatizados)
* Maven (Gerenciamento de Dependências)

**Frontend:**
* HTML5 e CSS3
* JavaScript (Vanilla)
* Chart.js (Renderização de Gráficos)
* Integração via Fetch API

## ⚙️ Como Funciona (Arquitetura)

O projeto adota uma arquitetura cliente-servidor padrão. O frontend interage exclusivamente com a API RESTful exposta pelo backend do Spring Boot, trafegando dados no formato JSON. O Spring Data JPA traduz as regras de negócio e os objetos Java para as tabelas relacionais do MySQL, garantindo a persistência e a integridade transacional.

## 💻 Como Executar o Projeto

### Pré-requisitos
* Java Development Kit (JDK) instalado
* Apache Maven instalado
* Servidor MySQL rodando localmente (porta 3306)

### 1. Configuração do Banco de Dados
Acesse o seu servidor MySQL e crie o banco de dados da aplicação:
```sql
CREATE DATABASE armazem_db;
```
Configure as credenciais de acesso no arquivo `armazem-backend/src/main/resources/application.properties`.

### 2. Executando o Backend
Abra o seu emulador de terminal e navegue até a pasta do backend:
```bash
cd armazem-backend
```
Faça o download das dependências e compile o projeto:
```bash
mvn clean install
```
Inicie o servidor Spring Boot:
```bash
mvn spring-boot:run
```
O servidor estará rodando em `http://localhost:8080`.

### 3. Executando o Frontend
Como o frontend é construído com HTML, CSS e JS puros, não há necessidade de um servidor Node.js complexo. Basta abrir o arquivo `index.html` (localizado na pasta `frontend/`) diretamente no seu navegador web, ou utilizar uma extensão como o *Live Server* do seu editor de código.

## 🧪 Testes Automatizados

O projeto possui uma suíte de testes de unidade e de integração, garantindo o correto funcionamento das regras de negócio (como bloqueio de vendas sem estoque e validação de CPFs).

Para rodar a bateria de testes via terminal:
```bash
cd armazem-backend
mvn test
```

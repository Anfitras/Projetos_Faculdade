# Armazém — Versão Spring Boot

Sistema de Gerenciamento de Estoque e Frente de Caixa (PDV), reescrito utilizando
Spring Boot, Spring Data JPA, Lombok e Maven, seguindo a estrutura e as anotações
apresentadas em aula (Controller → Service → Repository → Model).

## Stack

- Java 21
- Spring Boot 3.3.4 (Spring Web + Spring Data JPA)
- Lombok
- MySQL (mesmo banco `armazem_db` do projeto original)
- Maven
- Frontend: HTML5, CSS3 e JavaScript Vanilla (idêntico ao projeto original)

## Estrutura de pacotes

```
com.armazem.backend
 ├── config       -> Configuração de CORS
 ├── controller   -> @RestController (camada que recebe requisições HTTP)
 ├── service      -> @Service (regras de negócio)
 ├── repository   -> interfaces JpaRepository (persistência)
 ├── model        -> @Entity (mapeamento das tabelas)
 └── dto          -> objetos de transferência (Dashboard, Login, etc.)
```

## Pré-requisitos

- JDK 21 instalado (`java -version`)
- Maven instalado (`mvn -version`)
- MySQL rodando localmente, com o banco `armazem_db` criado e o usuário/senha
  configurados em `src/main/resources/application.properties`
- Caso queira popular o banco com os dados de exemplo do projeto original,
  importe o arquivo `src/main/resources/dump-armazem_db.sql`

## Como rodar o backend

Na raiz do projeto (onde está o `pom.xml`):

```bash
mvn spring-boot:run
```

O Spring Boot vai subir o servidor embutido (Tomcat) na porta `8080`.
Como o `spring.jpa.hibernate.ddl-auto=update` está ativo, o Hibernate cria/ajusta
automaticamente as tabelas a partir das entidades — não é necessário rodar o
script SQL manualmente, exceto se você quiser os dados de exemplo.

## Como rodar o frontend

A pasta `frontend/` é independente do Maven. Basta abrir os arquivos `.html`
diretamente no navegador, ou usar a extensão Live Server do VS Code,
com o backend já rodando na porta 8080.

## Observações

- A configuração de banco está em `src/main/resources/application.properties`.
- A lógica de negócio (entrada/saída de estoque, registro e cancelamento de
  venda, dashboard) é a mesma do projeto original; o que mudou foi a forma de
  acessar o banco (Spring Data JPA no lugar de JDBC puro) e a injeção de
  dependências (`@Autowired` no lugar de `new` manual).

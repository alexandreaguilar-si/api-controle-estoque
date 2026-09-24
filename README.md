# Sistema de Controle de Estoque (API REST com Spring Boot)

API RESTful desenvolvida em Java 21 e Spring Boot, estruturada como evolução técnica para o gerenciamento de inventário. O projeto abandona a persistência local via JDBC e adota arquitetura corporativa em camadas com banco de dados relacional em nuvem (PostgreSQL via Supabase).

---

## Sobre o Projeto

O sistema foi desenhado para expor endpoints HTTP padronizados para operações de CRUD de produtos. A aplicação segue os padrões oficiais de mercado do ecossistema Spring, utilizando o Spring Data JPA para o mapeamento objeto-relacional (ORM) e injeção de dependências por construtor, garantindo desacoplamento e alta manutenibilidade do código.

---

## Ferramentas e Tecnologias

- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL (Supabase)
- Maven
- Git e GitHub
- VS Code

---

## Estrutura do Projeto

src/main/java/com/estoque/api_controle_estoque/
├── controller/     # Camada de Apresentação (REST Endpoints)
├── service/        # Camada de Regras de Negócio e Transações
├── repository/     # Camada de Persistência (Spring Data JPA)
└── model/          # Entidades de Domínio (Mapeamento ORM)

### Organização das Camadas
- controller: Responsável por receber as requisições HTTP (GET, POST, DELETE), mapear as rotas e retornar as respostas formatadas em JSON.
- service: Concentra toda a lógica de negócio, regras de validação e fluxo transacional da aplicação.
- repository: Interface que estende o JpaRepository, automatizando a comunicação com o banco de dados sem necessidade de escrever SQL manual.
- model: Define a entidade de domínio Produto, mapeada diretamente para a tabela do banco de dados relacional.

---

## Configuração e Execução

### Pré-requisitos
- Java 21 e Maven instalados na sua máquina.
- Instância de banco de dados ativa no PostgreSQL (Supabase).

### Configuração da Conexão
Abra o ficheiro src/main/resources/application.properties e insira as credenciais reais do pooler de conexão fornecidas pelo Supabase:

spring.datasource.url=jdbc:postgresql://<SEU_HOST_DO_POOLER>:6543/postgres?pgbouncer=true&sslmode=require
spring.datasource.username=postgres.<SEU_ID_DE_PROJETO>
spring.datasource.password=SUA_SENHA_AQUI

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

### Executando a Aplicação
No terminal integrado do seu VS Code, utilize o Maven Wrapper para compilar e iniciar o servidor embutido:

- No Windows (PowerShell):
  .\mvnw.cmd spring-boot:run

- No Linux / macOS:
  ./mvnw spring-boot:run

A API estará a rodar localmente e pronta para receber requisições em http://localhost:8080.

---

## Endpoints da API

- GET /produtos : Retorna a lista completa de todos os produtos cadastrados no estoque
- GET /produtos/{id} : Busca um produto específico filtrando pelo seu ID único
- POST /produtos : Cadastra um novo item no inventário
- DELETE /produtos/{id} : Remove um produto do sistema através do ID

---

## Objetivo

Este projeto faz parte da minha jornada de transição para o desenvolvimento backend profissional, demonstrando a capacidade de projetar microsserviços modernos, lidar com infraestrutura em nuvem e aplicar rigorosamente boas práticas de arquitetura limpa.

Desenvolvido por Alexandre Aguilar.
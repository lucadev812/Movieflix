# 🎬 MovieFlix API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de filmes, categorias e plataformas de streaming.  
O projeto segue boas práticas de arquitetura, organização em camadas e padrões REST.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **Postman** (para testes da API)

---

## 🧱 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas:

- **Controller** → Responsável por receber as requisições HTTP
- **Service** → Contém a lógica de negócio
- **Repository** → Comunicação com o banco de dados
- **DTOs** → Transporte de dados entre camadas
- **Mapper** → Conversão entre entidades e DTOs
- **Entity** → Representação das tabelas do banco

---

## 📌 Funcionalidades

- 📽️ Cadastro de filmes
- 📂 Associação de filmes com categorias
- 📺 Associação de filmes com plataformas de streaming
- 📄 Listagem de filmes
- 🔍 Busca por ID
- ✏️ Atualização de dados
- ❌ Remoção de registros

---

## 📬 Endpoints Principais

### 🎥 Filmes
- `POST /movieflix/movie` → Cadastrar filme  
- `GET /movieflix/movie` → Listar filmes  
- `GET /movieflix/movie/{id}` → Buscar filme por ID  
- `PUT /movieflix/movie/{id}` → Atualizar filme  
- `DELETE /movieflix/movie/{id}` → Remover filme  

*(Os endpoints podem variar conforme sua implementação)*

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior
- Maven
- PostgreSQL
- IDE (IntelliJ, Eclipse ou VS Code)

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/Movieflix.git

# Entre no diretório
cd Movieflix

# Execute o projeto
./mvnw spring-boot:run


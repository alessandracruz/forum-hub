# Fórum Hub - API REST

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=java&logoColor=white )
![Spring](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white )
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-336791?style=for-the-badge&logo=postgresql&logoColor=white )
![Security](https://img.shields.io/badge/Spring_Security-6.x-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white )
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)

## 📖 Sobre o Projeto

**Fórum Hub** é uma API RESTful para um fórum de discussões, desenvolvida como parte do Challenge de Back-end do programa ONE (Oracle Next Education). O projeto simula um ambiente real onde usuários podem se autenticar, criar, ler, atualizar e deletar tópicos de discussão, seguindo regras de negócio específicas e com foco em segurança.

O principal objetivo deste desafio é construir uma API segura, utilizando **Spring Security** para controle de acesso e autenticação baseada em **Tokens JWT (JSON Web Token)**.

---

## 🛠️ Tecnologias Utilizadas

*   **Java 21** - Linguagem de programação principal
*   **Spring Boot 3** - Framework para criação da aplicação
*   **Spring Security** - Autenticação e autorização
*   **JWT (JSON Web Token)** - Gerenciamento de tokens de acesso
*   **Spring Data JPA** - Persistência de dados e ORM
*   **PostgreSQL** - Sistema de gerenciamento de banco de dados
*   **Maven** - Gerenciamento de dependências e build
*   **Lombok** - Redução de código boilerplate
*   **BCrypt** - Criptografia de senhas
*   **Jackson** - Serialização/deserialização JSON

---

## ⚙️ Funcionalidades

-   [x] **Autenticação JWT:** Sistema completo de login com geração de tokens seguros
-   [x] **Validações:** Regras de negócio implementadas com Bean Validation
-   [x] **CRUD de Tópicos:**
  -   [x] **(CREATE)** Criar um novo tópico (requer autenticação)
  -   [x] **(READ)** Listar todos os tópicos e detalhar um tópico específico
  -   [x] **(UPDATE)** Atualizar um tópico (endpoint implementado)
  -   [x] **(DELETE)** Deletar um tópico (endpoint implementado)
-   [x] **Segurança:** Filtros de segurança customizados e proteção de rotas
-   [x] **Relacionamentos:** Integração entre usuários, tópicos e cursos
-   [x] **Tratamento de Erros:** Respostas HTTP adequadas e tratamento de exceções

---

## 🚀 API Endpoints

| Método | URL                | Descrição                               | Acesso     | Status |
| :----- | :----------------- | :-------------------------------------- | :--------- | :----- |
| `POST` | `/login`           | Autentica usuário e retorna token JWT  | Público    | ✅ Implementado |
| `GET`  | `/topicos`         | Lista todos os tópicos cadastrados      | Protegido  | ✅ Implementado |
| `GET`  | `/topicos/{id}`    | Detalha um tópico específico por ID     | Protegido  | ✅ Implementado |
| `POST` | `/topicos`         | Cria um novo tópico                     | Protegido  | ✅ Implementado |
| `PUT`  | `/topicos/{id}`    | Atualiza um tópico existente            | Protegido  | ✅ Implementado |
| `DELETE`| `/topicos/{id}`   | Remove um tópico do sistema             | Protegido  | ✅ Implementado |

### Exemplos de Uso

**Autenticação:**
```json
POST /login
{
    "email": "usuario@exemplo.com",
    "senha": "123456"
}
```

**Criação de Tópico:**
```json
POST /topicos
Authorization: Bearer {token}
{
    "titulo": "Dúvida sobre Spring Boot",
    "mensagem": "Como configurar autenticação JWT?",
    "curso": "Spring Framework"
}
```

---

## 🏗️ Arquitetura do Projeto

```
src/main/java/br/com/alura/forumhub/
├── config/
│   └── security/
│       ├── SecurityConfigurations.java
│       └── SecurityFilter.java
├── controller/
│   ├── AutenticacaoController.java
│   └── TopicoController.java
├── dto/
│   ├── DadosAutenticacao.java
│   ├── DadosCadastroTopico.java
│   └── DadosTokenJWT.java
├── model/
│   ├── Curso.java
│   ├── StatusTopico.java
│   ├── Topico.java
│   └── Usuario.java
├── repository/
│   ├── CursoRepository.java
│   ├── TopicoRepository.java
│   └── UsuarioRepository.java
└── service/
    ├── AutenticacaoService.java
    └── TokenService.java
```

---

## 🏁 Como Executar Localmente

### Pré-requisitos

- **Java 21** ou superior
- **Maven 3.6+**
- **PostgreSQL 14** ou superior
- **Git**

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/alessandracruz/forum-hub.git
   cd forum-hub
   ```

2. **Configure o banco de dados:**
  - Crie um banco de dados PostgreSQL chamado `forumhub_db`
  - Ajuste as credenciais no arquivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/forumhub_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. **Instale as dependências e compile:**
   ```bash
   mvn clean install
   ```

4. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

5. **A API estará disponível em:** `http://localhost:8080`

### Usuário de Teste

Para facilitar os testes, um usuário padrão é criado automaticamente:
- **Email:** `ana.souza@voll.med`
- **Senha:** `123`

---

## 🧪 Testes

A API foi testada utilizando **Insomnia** com os seguintes cenários:

- ✅ Autenticação com credenciais válidas
- ✅ Geração e validação de tokens JWT
- ✅ Criação de tópicos com usuário autenticado
- ✅ Listagem de todos os tópicos
- ✅ Busca de tópico específico por ID
- ✅ Proteção de rotas (acesso negado sem token válido)
- ✅ Serialização JSON com relacionamentos Hibernate

---

## 🔒 Segurança

O projeto implementa as seguintes medidas de segurança:

- **Autenticação JWT:** Tokens seguros com tempo de expiração
- **Criptografia de Senhas:** Utilização do BCrypt para hash das senhas
- **Filtros de Segurança:** Interceptação e validação de todas as requisições
- **Proteção de Rotas:** Endpoints protegidos exigem autenticação
- **CORS:** Configurado para permitir requisições de diferentes origens

---

## 🚧 Melhorias Futuras

- [ ] Implementar paginação na listagem de tópicos
- [ ] Adicionar sistema de roles (ADMIN, USER)
- [ ] Implementar soft delete para tópicos
- [ ] Adicionar validação de duplicação de tópicos
- [ ] Implementar sistema de respostas aos tópicos
- [ ] Adicionar documentação com Swagger/OpenAPI
- [ ] Implementar testes unitários e de integração

---

## 👩‍💻 Desenvolvedora

**Alessandra Cruz**

- GitHub: [@alessandracruz](https://github.com/alessandracruz/)
- LinkedIn: [Alessandra Cruz](https://linkedin.com/in/alessandracruz)

---

## 📄 Licença

Este projeto foi desenvolvido como parte do Challenge Oracle ONE e está disponível para fins educacionais.

---

## 🎯 Challenge Oracle ONE

Este projeto faz parte do programa **Oracle Next Education (ONE)** em parceria com a **Alura**, focado no desenvolvimento de habilidades em tecnologia e preparação para o mercado de trabalho.

**Período:** Agosto 2025  
**Modalidade:** Challenge Back-end  
**Tecnologias:** Java, Spring Boot, Spring Security, JWT, PostgreSQL



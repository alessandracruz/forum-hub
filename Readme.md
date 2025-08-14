# Fórum Hub - API REST

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=java&logoColor=white )
![Spring](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white )
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-336791?style=for-the-badge&logo=postgresql&logoColor=white )
![Security](https://img.shields.io/badge/Spring_Security-6.x-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white )

## 📖 Sobre o Projeto

**Fórum Hub** é uma API RESTful para um fórum de discussões, desenvolvida como parte do Challenge de Back-end do programa ONE (Oracle Next Education). O projeto simula um ambiente real onde usuários podem se autenticar, criar, ler, atualizar e deletar tópicos de discussão, seguindo regras de negócio específicas e com foco em segurança.

O principal objetivo deste desafio é construir uma API segura, utilizando **Spring Security** para controle de acesso e autenticação baseada em **Tokens JWT (JSON Web Token)**.

---

## 🛠️ Tecnologias Utilizadas

*   **Java 17+**
*   **Spring Boot 3**
*   **Spring Security** para autenticação e autorização
*   **JWT (JSON Web Token)** para gerenciamento de tokens
*   **Spring Data JPA** para persistência de dados
*   **PostgreSQL** como banco de dados
*   **Maven** para gerenciamento de dependências
*   **Lombok** para redução de código boilerplate (opcional, mas recomendado)
*   **Insomnia/Postman** para testes de endpoints

---

## ⚙️ Funcionalidades

-   [ ] **Autenticação:** Geração de token JWT para usuários cadastrados.
-   [ ] **Validações:** Regras de negócio e de segurança para criação e atualização de tópicos.
-   [ ] **CRUD de Tópicos:**
    -   [ ] **(CREATE)** Criar um novo tópico (requer autenticação).
    -   [ ] **(READ)** Listar todos os tópicos e detalhar um tópico específico.
    -   [ ] **(UPDATE)** Atualizar um tópico (apenas o autor do tópico pode atualizar).
    -   [ ] **(DELETE)** Deletar um tópico (apenas o autor do tópico pode deletar).

---

## 🚀 API Endpoints (Em Construção)

| Método | URL                | Descrição                               | Acesso     |
| :----- | :----------------- | :-------------------------------------- | :--------- |
| `POST` | `/login`           | Autentica um usuário e retorna um token | Público    |
| `GET`  | `/topicos`         | Lista todos os tópicos                  | Público    |
| `GET`  | `/topicos/{id}`    | Detalha um tópico específico            | Público    |
| `POST` | `/topicos`         | Cria um novo tópico                     | Protegido  |
| `PUT`  | `/topicos/{id}`    | Atualiza um tópico                      | Protegido  |
| `DELETE`| `/topicos/{id}`    | Deleta um tópico                        | Protegido  |

---

## 🏁 Como Executar Localmente

*(Esta seção será preenchida ao final do desenvolvimento)*


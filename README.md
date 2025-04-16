# Sistema Bancário Digital

## 📋 Sobre o Projeto

Este é um sistema bancário digital moderno desenvolvido com Spring Boot 3, Java 17. O sistema oferece uma API REST completa para gerenciamento de contas bancárias, cartões, recursos e notícias, além de uma interface web amigável.

## ✨ Funcionalidades

### API REST
- Gerenciamento de contas bancárias
- Gerenciamento de cartões
- Gerenciamento de recursos (features)
- Gerenciamento de notícias
- Documentação Swagger/OpenAPI

### Interface Web
- Dashboard intuitivo
- Listagem de todas as entidades
- Formulários para criação e edição
- Design moderno com Bootstrap

## 🛠️ Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (desenvolvimento) / PostgreSQL (produção)
- Thymeleaf
- Bootstrap 5
- Font Awesome
- Railway (deploy)
- Gradle (build)

## 🚀 Como Executar

### Pré-requisitos
- Java 17
- Gradle
- Git

### Instalação

1. Clone o repositório:
```bash
git clone https://github.com/denisecabral12/Desafio-API-REST-na-Nuvem-Usando-Spring-Boot-3-Java-17-e-Railway.git
```

2. Entre no diretório do projeto:
```bash
cd nome-da-pasta
```

3. Execute o projeto:
```bash
./gradlew bootRun
```

### Perfis / Profiles

- `dev`: Ambiente de desenvolvimento (H2 Database)
- `prd`: Ambiente de produção (PostgreSQL)

## 📚 Documentação

### API REST
A documentação da API está disponível em:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI: `http://localhost:8080/v3/api-docs`

### Endpoints Principais

#### Contas / Accounts
- GET `/api/accounts` - Lista todas as contas
- GET `/api/accounts/{id}` - Busca uma conta específica
- POST `/api/accounts` - Cria uma nova conta
- PUT `/api/accounts/{id}` - Atualiza uma conta
- DELETE `/api/accounts/{id}` - Remove uma conta

#### Cartões / Cards
- GET `/api/cards` - Lista todos os cartões
- GET `/api/cards/{id}` - Busca um cartão específico
- POST `/api/cards` - Cria um novo cartão
- PUT `/api/cards/{id}` - Atualiza um cartão
- DELETE `/api/cards/{id}` - Remove um cartão

#### Recursos / Features
- GET `/api/features` - Lista todos os recursos
- GET `/api/features/{id}` - Busca um recurso específico
- POST `/api/features` - Cria um novo recurso
- PUT `/api/features/{id}` - Atualiza um recurso
- DELETE `/api/features/{id}` - Remove um recurso

#### Notícias / News
- GET `/api/news` - Lista todas as notícias
- GET `/api/news/{id}` - Busca uma notícia específica
- POST `/api/news` - Cria uma nova notícia
- PUT `/api/news/{id}` - Atualiza uma notícia
- DELETE `/api/news/{id}` - Remove uma notícia

### Interface Web
A interface web está disponível em:
- Home: `http://localhost:8080/web`
- Contas: `http://localhost:8080/web/accounts`
- Cartões: `http://localhost:8080/web/cards`
- Recursos: `http://localhost:8080/web/features`
- Notícias: `http://localhost:8080/web/news`

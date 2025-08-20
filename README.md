# 🧾 Gerenciador de Notas Fiscais

Um projeto de aplicação web full-stack desenvolvido com Java e Spring Boot para gerenciar e organizar notas fiscais.

## ✨ Funcionalidades

- **CRUD Completo:** Crie, visualize, edite e exclua notas fiscais.
- **Visualização Ordenada:** A lista principal é sempre exibida em ordem de data de vencimento.
- **Banco de Dados Persistente:** Utiliza MySQL para armazenar os dados de forma permanente.
- **Alerta de Vencimento:** Uma seção de destaque na página inicial alerta sobre notas que vencem nos próximos 7 dias.
- **Interface Web:** Interface de usuário limpa e responsiva construída com Thymeleaf e Bootstrap.

## 🛠️ Tecnologias Utilizadas

- **Backend:** Java 21, Spring Boot, Spring Web, Spring Data JPA
- **Frontend:** Thymeleaf, HTML5, Bootstrap 5
- **Banco de Dados:** MySQL
- **Build Tool:** Maven

## 🚀 Como Executar

1. Clone o repositório.
2. Configure as credenciais do seu banco de dados MySQL no arquivo `src/main/resources/application.properties`.
3. Execute a aplicação através da sua IDE.
4. Acesse `http://localhost:8080` no seu navegador.
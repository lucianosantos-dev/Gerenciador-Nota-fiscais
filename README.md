# 📑 Gerenciador de Notas Fiscais — API Backend

Solução Full-Stack desenvolvida para o gerenciamento, organização e controle financeiro de notas fiscais, focada em regras de negócio eficientes e usabilidade. 

O projeto passou por um processo completo de **engenharia reversa e refatoração arquitetural**. A aplicação, que originalmente utilizava acoplamento com renderização via Thymeleaf, foi modernizada para o padrão de mercado atual, transformando-se em uma API REST totalmente desacoplada e preparada para integração com ecossistemas modernos de Single Page Applications (SPA).

## 🛠️ Destaques Técnicos & Engenharia de Software

- **Evolução do Backend (Java & Spring Boot):** Migração do modelo monolítico tradicional para uma arquitetura baseada em APIs REST limpas. Implementação de camadas segregadas através de **DTOs (Data Transfer Objects)** para garantir o encapsulamento seguro dos dados na trafegação da rede.
- **Persistência & Versionamento de Dados:** Armazenamento robusto em banco de dados **MySQL** utilizando **Spring Data JPA** e **Hibernate** para o mapeamento objeto-relacional. Introdução do **Flyway Migrations** para realizar o versionamento e controle controlado do esquema do banco de dados, eliminando criações manuais de tabelas.
- **Lógica de Negócio Aplicada:** Desenvolvimento de endpoints dinâmicos na API que identificam e filtram automaticamente notas com vencimento nos próximos 7 dias, ordenando o fluxo de payload por prioridade de vencimento.
- **Qualidade de Processo:** Controle de versão gerenciado de forma profissional via **Git**, aplicando o fluxo de ramificações do **GitFlow** e histórico de mensagens padronizado rigorosamente com **Conventional Commits**.

## 💻 Tecnologias Utilizadas

- **Linguagem Principal:** Java 21
- **Framework Core:** Spring Boot (Spring Web, Spring Data JPA)
- **Banco de Dados:** MySQL 8
- **Migração de Dados:** Flyway DB
- **Gerenciador de Dependências:** Maven

## 🚀 Como Executar a API

1. Clone este repositório.
2. Certifique-se de ter um banco de dados MySQL ativo no seu ambiente.
3. Configure as credenciais de acesso ao seu banco de dados local no arquivo `src/main/resources/application.properties`.
4. Execute a aplicação através de sua IDE de preferência ou via terminal utilizando o comando:
   ```bash
   mvn spring-boot:run

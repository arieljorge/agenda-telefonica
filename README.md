# Agenda Telefônica CLI

Projeto Integrador II-A desenvolvido para a disciplina de Análise e Desenvolvimento de Sistemas da Pontifícia Universidade Católica de Goiás (PUC Goiás).

## Sobre o Projeto

A Agenda Telefônica CLI é uma aplicação Java executada via terminal que permite o gerenciamento de contatos telefônicos através das operações básicas de CRUD (Create, Read, Update e Delete).

O sistema possibilita o cadastro, consulta, atualização, remoção e listagem de contatos contendo:

* Nome
* Telefone
* E-mail

Os dados são persistidos em banco de dados PostgreSQL utilizando JDBC.

---

## Objetivo Acadêmico

Este projeto foi desenvolvido como parte do Projeto Integrador II-A, cujo objetivo é aplicar conceitos relacionados a:

* Programação Orientada a Objetos (POO)
* Persistência de dados
* Banco de Dados Relacional
* JDBC
* Manipulação de dados
* Tratamento de exceções
* Implementação das operações CRUD

---

## Tecnologias Utilizadas

| Tecnologia             | Versão |
|------------------------| ------ |
| Java                   | 21     |
| PostgreSQL             | 15     |
| PostgreSQL JDBC Driver | 42.7.7 |
| Gradle                 | 9.3.0  |

---

## Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   ├── dao
│   │   ├── model
│   │   ├── service
│   │   ├── util
│   │   └── AgendaTeste.java
│   └── resources
│       ├── application.properties
│       └── dump.sql
```

---

## Banco de Dados

O projeto utiliza PostgreSQL 15.

### Criação do Banco

```sql
CREATE DATABASE agenda;
```

### Importação do Dump

O arquivo de exportação do banco encontra-se em:

```text
src/main/resources/dump.sql
```

Importe o arquivo utilizando:

```bash
psql -U postgres -d agenda -f dump.sql
```

ou através do PgAdmin.

---

## Configuração

Configure as credenciais do banco de dados no arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
db.url=jdbc:postgresql://localhost:5432/agenda
db.username=postgres
db.password=postgres
```

---

## Executando a Aplicação

### Utilizando o código-fonte

```bash
./gradlew clean jar
java -jar build/libs/agenda-telefonica-1.0.0.jar
```

### Utilizando a Release

A release disponibilizada neste repositório já contém o arquivo compilado.

Pré-requisitos:

* Java 21 instalado
* PostgreSQL 15 configurado
* Banco de dados restaurado através do arquivo dump.sql

Execução:

```bash
java -jar agenda-telefonica.jar
```

---

## Funcionalidades

### Adicionar Contato

Permite cadastrar um novo contato informando:

* Nome
* Telefone
* E-mail

### Buscar Contato

Realiza a consulta de um contato através do nome.

### Atualizar Contato

Permite alterar os dados de um contato previamente cadastrado.

### Remover Contato

Remove um contato existente.

### Listar Contatos

Exibe todos os contatos armazenados no banco de dados.

---

## Menu da Aplicação

```text
===== AGENDA TELEFÔNICA =====

1 - Adicionar contato
2 - Remover contato
3 - Buscar contato
4 - Listar contatos
5 - Atualizar contato
6 - Sair
```

A aplicação permanece em execução até que a opção de saída seja selecionada.

---

## Tratamento de Exceções

O sistema implementa tratamento para situações como:

* Contato não encontrado
* Operações inválidas
* Falhas de conexão com o banco
* Entrada de dados incorreta pelo usuário

---

## Entregáveis do Projeto Integrador

Conforme especificado na proposta do Projeto Integrador II-A, a entrega é composta por:

* Código-fonte da aplicação Java
* Banco de dados exportado (.sql)
* Vídeo demonstrando todas as operações CRUD
* Documentação do projeto

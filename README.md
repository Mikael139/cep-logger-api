# Desafio Técnico - API de Consulta de CEP com Logs

Este projeto é a solução para um desafio técnico cujo tema foi livre, desenvolvendo uma aplicação que atende aos critérios propostos.

---

## Sobre o Desafio

O objetivo do desafio foi construir uma aplicação que:

1. Prover a capacidade de realizar operações de busca de CEP em uma API externa (neste caso, a API do [ViaCEP](https://viacep.com.br/));
2. Registrar os logs das consultas em banco de dados, incluindo horário da consulta e dados retornados;
3. Aplicar conceitos básicos de SOLID no desenvolvimento;
4. Expor o código em repositório público no GitHub.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data MongoDB** (banco NoSQL)
- **Lombok** (redução de getters e setters)
- **API ViaCEP** para consulta de CEPs externas
- **MongoDB** para armazenamento de logs e dados
- **Spring Security** para autenticação básica (login e cadastro) com hash
  
---

## Estrutura da Aplicação

- **Controllers:** Expõem endpoints REST para autenticação, consulta de CEP, e gerenciamento de favoritos.
- **Services:** Contêm a lógica de negócio para buscar CEP, registrar logs, e gerenciar usuários/favoritos.
- **Repositories:** Interface com o MongoDB para persistência de dados.
- **DTOs:** Objetos para transferência de dados entre camadas.
- **Config:** Configurações de segurança, CORS e autenticação.

---

## Como executar a API localmente

### Pré-requisitos:

- Java 17 instalado
- MongoDB rodando localmente (pode ser via Docker ou instalado na máquina)
- Maven instalado para build (ou usar IDE que suporte Maven)

---

### Passos para rodar

1. **Clone o repositório:**

```bash
git clone https://github.com/Mikael139/cep-logger-api.git
cd cep-logger-api

## Endpoints principais

| Método | URL               | Descrição                                | Autenticação? |
|--------|-------------------|-----------------------------------------|--------------|
| POST   | /auth/register    | Cadastrar novo usuário                   | Não          |
| POST   | /auth/login       | Login do usuário                         | Não          |
| GET    | /cep/{cep}        | Busca CEP na API ViaCEP e registra log  | Não          |
| POST   | /favoritos        | Favoritar um CEP (usuário logado)       | Sim          |
| GET    | /favoritos        | Listar CEPs favoritos do usuário        | Sim          |
| DELETE | /favoritos/{id}   | Remover CEP dos favoritos                | Sim          |

---

## Observações

- A autenticação é feita via Basic Auth com Spring Security.
- As buscas de CEP são feitas consumindo a API do ViaCEP.
- Logs de cada consulta são armazenados no MongoDB com horário e resposta.
- Aplicação segue os conceitos básicos do SOLID para manter código limpo e modular.

<img width="540" height="417" alt="image" src="https://github.com/user-attachments/assets/25ad920a-9dd7-454d-9efa-85aac41efc40" />

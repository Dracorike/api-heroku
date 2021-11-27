# ESPECIFICAÇÃO DA APLICAÇÃO

Você foi contratado por uma empresa de pesquisa de mercado. A empresa deseja disponibilizar um aplicativo aos seus colaboradores para facilitar a captação de dados para pesquisa eleitoral. O candidato “João do MS”, contratante da pesquisa, quer saber o perfil dos eleitores que votam nele e o perfil dos eleitores que não votam nele. O perfil é composto pela idade, sexo, profissão e renda mensal. Você foi incumbido de projetar uma WebApi que seja o “backend” do aplicativo de pesquisa eleitoral. Sua webapi deve ter os seguintes serviços:

Registrar uma consulta a um eleitor: Esse serviço deve registrar o nome do participante na pesquisa, sua idade, sexo, profissão, renda mensal e, se vota ou não no candidato “João do MS”;
Consultar o percentual de aceitação/rejeição por faixa etária: Dado uma faixa etária (idade inicial, idade final), informar o percentual de aceitação (que vão votar em “João do MS”) e o percentual de rejeição (que não vão votar em “João do MS”);
Consultar o percentual de aceitação/rejeição por sexo (M/F): Dado o sexo (M/F), informar o percentual de aceitação (que vão votar em “João do MS”) e o percentual de rejeição (que não vão votar em “João do MS”);
Consultar o percentual de aceitação/rejeição por faixa de renda mensal: Dado uma faixa de renda mensal (renda inicial, renda final), informar o percentual de aceitação (que vão votar em “João do MS”) e o percentual de rejeição (que não vão votar em “João do MS”);

## REQUISITOS PARA RODAR A APLICAÇÃO

- Java 11 ou superior
- Banco de dados Postgres ou Docker

`Para rodar o banco de dados com Docker basta rodar o comando *docker compose up* na pasta do projeto`

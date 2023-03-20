# Descrição

App-prestador-servico
Repositório para desenvolvimento do projeto de uma aplicação, utilizando o framework Spring (FIAP - Digital Business Enablement)

Vamos criar uma aplicação para que prestadores de serviço, como eletricistas, técnicos em eletrodomésticos, etc, possam se registrar e procurar serviços.
Do outro lado, teremos a opção de usuários se registrarem e fazerem pedidos aos prestadores de serviço, conectando os dois lados e encurtando este caminho.


# Como clonar o repositório

``` bash
$ # no terminal digite
$ git clone https://github.com/InsaneXurow10/App-prestador-servico

```


# Endpoints

Divididos pelas páginas do Front-end às quais eles fazem referência.

## Página de Perfil
/Perfil/{id} - usando o verbo GET para mostrar as informações do perfil.

/Perfil/{id} - usando o verbo PUT para atualizar as informações do perfil.

/Perfil/{id} - usando o verbo DELETE para deletar o perfil.

## Páginas de Login e Registro
/Login/{id} -  usando o verbo GET para requerer as informações e compará-las no banco de dados.

/Registro - em um formulário de registro, usando o verbo POST para enviar ao banco de dados um novo registro.

## Página Principal
/Principal/Publicar - função que usa o verbo POST para postar uma publicação do Usuário.

/Principal/Publicacao/{id} - função que usa o verbo GET para procurar uma publicação do Usuário, com id da publicação.

/Principal/Publicacao/{id} - função que usa o verbo PUT para atualizar uma publicação do Usuário, com id da publicação.

/Principal/Publicacao/{id} - função que usa o verbo DELETE para deletar uma publicação do Usuário, com id da publicação.

# Descrição

App-prestador-servico
Repositório para desenvolvimento do projeto de uma aplicação, utilizando o framework Spring (FIAP - Digital Business Enablement 2TDSA)

Vamos criar uma aplicação para que prestadores de serviço, como eletricistas, técnicos em eletrodomésticos, etc, possam se registrar e procurar serviços.
Do outro lado, teremos a opção de usuários se registrarem e fazerem pedidos aos prestadores de serviço, conectando os dois lados e encurtando este caminho.


# Como clonar o repositório

``` bash
$ # no terminal digite
$ git clone https://github.com/Gabriel-Llanir/FazTudo

```


# Endpoints

Divididos pelas páginas do Front-end às quais eles fazem referência.

## Página de Login
/login - usando o verbo POST para autenticar o login de usuários e prestadores.

## Página do Usuário
/usuario - usando o verbo PUT para atualizar as informações do usuário no banco de dados.

/usuario - usando o verbo POST para registrar um novo usuário no banco de dados.

/usuario/{id} - usando o verbo GET para mostrar as informações do usuário.

/usuario/{id}/publicacoes - usando o verbo GET para mostrar todas as publicações do usuário.

/usuario/{id} - usando o verbo DELETE para excluir/desativar um usuário no banco de dados.

/usuario/remove/{id} - usando o verbo DELETE para remover completamente um usuário do banco de dados.

## Página do Prestador
/prestador - usando o verbo PUT para atualizar as informações do prestador no banco de dados.

/prestador - usando o verbo POST para registrar um novo prestador no banco de dados.

/prestador/{id} - usando o verbo GET para mostrar as informações do prestador.

/prestador/{id} - usando o verbo DELETE para excluir/desativar um prestador no banco de dados.

/prestador/remove/{id} - usando o verbo DELETE para remover completamente um prestador do banco de dados.

## Página Principal
/principal/publicacao - usando o verbo GET para mostrar todas as publicações na plataforma.

/principal/publicacao - usando o verbo POST para postar uma publicação do Usuário na plataforma.

/principal/publicacao/{id} - usando o verbo GET para procurar uma publicação.

/principal/publicacao/{id} - usando o verbo PUT para atualizar uma publicação.

/principal/publicacao/{usuario_id}/{id} - usando o verbo DELETE para apagar uma publicação.

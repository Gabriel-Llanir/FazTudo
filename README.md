<h1>Descrição</h1>

App-prestador-servico
Repositório para desenvolvimento do projeto de uma aplicação para prestadores de serviço (FIAP - Digital Business Enablement)

Vamos criar uma aplicação para que prestadores de serviço, como eletricistas, técnicos em eletrodomésticos, etc, possam se registrar e oferecerem seus serviços.
Do outro lado, teremos a opção de usuários se registrarem e fazerem pedidos aos prestadores de serviço, conectando os dois lados e encurtando este caminho.



<h1>Endpoints</h1>


/Perfil - na página de perfil, usando o verbo GET para mostrar as informações do perfil.

/Perfil - na página de perfil, usando o verbo PUT para atualizar as informações do perfil.

/Perfil - na página de perfil, usando o verbo DELETE para deletar o perfil.
<hr>
/Login -  na página de login, usando o verbo GET para requerer as informações e compará-las no banco de dados.

/Registro - na página de registro, em um formulário de registro, usando o verbo POST para enviar ao banco de dados um novo registro.
<hr> 
/Principal/Publicar - na página principal, método que usa o verbo POST para postar uma publicação do Usuário.

/Principal/Publicacao/id - na página principal, função que usa o verbo GET para procurar uma publicação do Usuário, com id da publicação.
/Principal/Publicacao/id - na página principal, função que usa o verbo PUT para atualizar uma publicação do Usuário, com id da publicação.
/Principal/Publicacao/id - na página principal, função que usa o verbo DELETE para deletar uma publicação do Usuário, com id da publicação.

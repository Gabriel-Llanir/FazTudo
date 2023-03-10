<h1>Descrição</h1>

App-prestador-servico
Repositório para desenvolvimento do projeto de uma aplicação para prestadores de serviço (FIAP - Digital Business Enablement)

Vamos criar uma aplicação para que prestadores de serviço, como eletricistas, técnicos em eletrodomésticos, etc, possam se registrar e oferecerem seus serviços.
Do outro lado, teremos a opção de usuários se registrarem e fazerem pedidos aos prestadores de serviço, conectando os dois lados e encurtando este caminho.



<h1>Endpoints</h1>


/Login - formulário de login, usando o verbo GET para requerer as informações e compará-las no banco de dados, recebendo como resposta o login na plataforma.

/Register - formulário de registro, usando o verbo POST para enviar ao banco de dados um novo registro.

/Profile - na página de perfil o usuário é capaz de fazer a requisição de alterar seus dados, usando o verbo PATCH para atualizar as informações.

/Main - na página pricipal da plataforma, os usuários podem fazer uma publicação, usando o verbo POST para enviar as informações do chamado ao banco de dados e criando uma publicação na plataforma.

/Main/Publicar - na página principal, usando o verbo GET para requerer as informações da publicação.

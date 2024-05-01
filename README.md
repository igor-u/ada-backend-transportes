## API RESTful de entregas que consome a Route Monitoring API da TomTom Move.

Os testes foram feitos no Postman.

Para o consumo de uma rota deve-se acessar o caminho: "/routeapi/{rota}", em que {rota} é o identificador da rota na API consumida.

Não foi feita uma assinatura na TomTom Move, então o máximo de rotas que pôde-se armazenar na plataforma foi 2. A data de expiração da API Key usada é 19 de maio de 2024 - é preciso
alterar a URI no método consumir() da classe ConsomeTomtom, caso a API Key esteja expirada.

Nos testes, o identificador {rota} usado foi 64325: "/routeapi/64325". A alternativa para simular diferentes rotas foi editar uma única
rota (64325) pela plataforma da Route Monitoring API antes de consumi-la, armazenando-a no banco de dados como se fosse uma nova;
consumir a mesma rota sem editá-la (com os mesmos dados) também funciona.

### Login
{<br/>
    "login": "igor<i></i>@gmail.com",<br/>
    "senha": "12345"<br/>
}<br/>
- Deve ser passado no header "Authorization" o Token (JWT) gerado pela classe LoginController para todas as outras requisições.

### Exemplo de Cadastro de Entrega
{<br/>
    "descricao": "Produto",<br/>
    "inicio": "2024-04-30T12:08:28.097832",<br/>
    "fim": "2024-04-30T14:10:44.087831",<br/>
    "rota": {dadosRota}<br/>
}<br/>
- Em que {dadosRota} deve ser o body da response dos métodos consumir() da classe ConsomeTomtom, ou
 buscarPorId() da classe RotaController, ou um objeto ExibicaoRotaDTO serializado para JSON no método listar() de RotaController.

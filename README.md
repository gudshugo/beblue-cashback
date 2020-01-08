# beblue-cashback

Projeto de uma API REST para calcular cashback em Java (Spring Framework).

## Requerimentos:
  
  ```Maven V.3.5+```
  ```Java V.8+```
  ```Docker V.19.03.1+```

## Executando o projeto:

Para subir o container com o projeto, execute: 

`$ sh start-application.sh`

Para parar a aplicação:

`$ sh stop-application.sh`

## Endpoints

 - Endpoint para consultar o catálogo de discos de forma paginada, filtrando por gênero e ordenando de forma crescente pelo nome do disco:
```
http://localhost:8089/v1/discos?generoId=
```
onde o parâmetro obrigatório da requisição é o identificador de um gênero (generoId), sendo colocado o gênero 1 como default. Os parâmetros opcionais são: page, linesPerPage, orderBy e direction (parâmetros do spring data page) - Se você consultar sem o parâmetro generoId, a requisição retornará por default os discos do genero com identificador igual a 1.
  
  - Endpoint para consultar o disco pelo seu identificador:
```
http://localhost:8089/v1/disco/{discoId}
```  
onde o parâmetro obrigatório da requisição é o identificador de um disco (discoID).   

  - Endpoint para registrar uma nova venda de discos calculando o valor total de cashback considerando a tabela:
```
http://localhost:8089/v1/venda
```  
onde deve ser enviado no body da requisição o seguinte formato de vetor:

```
{
	"discoIds" : []
}
```

  - Endpoint para consultar venda por identificador:
```
http://localhost:8089/v1/venda/{vendaId}
```    
onde o parâmetro obrigatório da requisição é o identificador de uma venda (vendaId).   
  
  - Endpoint para consultar todas as vendas efetuadas de forma paginada, filtrando pelo range de datas (inicial e final) da venda e ordenando de forma decrescente pela data da venda:
``` 
 http://localhost:8089/v1/vendas?dataInicio=&dataFim=
```   
onde o parâmetro obrigatório da requisição são dataInicio e dataFim (no formato 2019/11/11). Os parâmetros opcionais são: page, linesPerPage, orderBy e direction (parâmetros do spring data page).

## Para acessar a documentação completa:

``` 
 http://localhost:8089/swagger-ui.html
```   

Caso queira importar o projeto em alguma IDE, importar apenas a pasta /application.

Na raiz do projeto também tem o arquivo JSON referente a coleção com as rotas na aplicação do Postman, com os endpoints organizados.

## Melhorias no projeto:

1. Criar ambiente de testes automatizados por meio de ferramentas de integração contínua (Jenkins, Circle CI) em conjunto com análise de código automática com ferramentas como Sonarqube.
2. Utilizar message broker tornando alguns processos da API mais assíncronos.
3. Implementar serviço de load balancer para interceptar requisições da API.

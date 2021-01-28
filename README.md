# beblue-cashback

Project of a REST API to calculate cashback in Java (Spring Framework).

## Requirements:
  
  ```Maven V.3.5+```
  ```Java V.8+```
  ```Docker V.19.03.1+```

## Running the project:

To run the container in the docker with the project, execute: 

`$ sh start-application.sh`

To stop the application:

`$ sh stop-application.sh`

## Endpoints

 - Endpoint to consult the disc catalog in a paginated way, filtering by genre and sorting in ascending order by disc name:
```
http://localhost:8089/v1/discos?generoId=
```
where the mandatory request parameter is a gender identifier (generoId), with gender 1 as the default. Optional parameters are: page, linesPerPage, orderBy and direction (spring data page parameters) - If you consult without the generoId parameter, the request will return by default the disks of the genus with an identifier equal to 1.
  
  - Endpoint to query the disk by its identifier:
```
http://localhost:8089/v1/disco/{discoId}
```  
where the mandatory request parameter is a disk identifier (diskID).

  - Endpoint to register a new record sale by calculating the total cashback amount considering the table:
```
http://localhost:8089/v1/venda
```  
where the following vector format must be sent in the request body:

```
{
	"discoIds" : []
}
```

  - Endpoint to consult sales by identifier:

```
http://localhost:8089/v1/venda/{vendaId}
```    
where the mandatory parameter of the request is the identifier of a sale (saleId).   
  
  - Endpoint to consult all sales made in a paginated way, filtering by the date range (initial and final) of the sale and ordering in descending order by the date of the sale:
``` 
 http://localhost:8089/v1/vendas?dataInicio=&dataFim=
```   
where the mandatory parameter of the request are dataInicio and dataFim (in the format 11/11/11). The optional parameters are: page, linesPerPage, orderBy and direction (spring data page parameters).

## To access the complete requisition documentation:

``` 
 http://localhost:8089/swagger-ui.html
```   

If you want to import the project in any IDE, import only the /application folder.

At the root of the project there is also the JSON file referring to the collection with the routes in the Postman application, with the organized endpoints.

## Improvements:

1. Create an automated testing environment using continuous integration tools (Jenkins, Circle CI) together with automatic code analysis with tools like Sonarqube.
2. Use message broker making some API processes more asynchronous.
3. Implement load balancer service to intercept API requests (Netflix Zuul, Ribbon, Hystrix).

![alt text](https://img.ibxk.com.br/2020/01/30/30021141299110.jpg?w=1120&h=420&mode=crop&scale=both)

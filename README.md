# beblue-cashback
Projeto de uma API REST em Java (Spring Framework) referente ao teste técnico para desenvolvedor java na Fintech Beblue.

## Requerimentos:
  
  ```Maven V.3.5+``` 
  
  ```Java V.8+```

## Executando o projeto:

Para subir o container com o projeto, execute: 

```sh
start-application.sh
```

Para visualizar os testes unitários durante a compilação do maven:

```sh
start-application-with-tests.sh
```

## Melhorias no projeto:

1. Criar ambiente de testes automatizados por meio de ferramentas de integração contínua (Jenkins, Circle CI) em conjunto com análise de código automática com ferramentas como Sonarqube.
2. Utilizar message broker tornando alguns processos da API mais assíncronos.

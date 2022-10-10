# Desafio Exploração planetária

# Stack
 - Kotlin
 - Golang
# Banco de dados
 - Postgres
 - MongoDB
# Broker
 - Kafka
# Cache
 - Redis
# Infraestrutura e Recursis
 - Docker
 - Logstash
 - Elasticsearch
 - Elastic APM
 - Kibana
 - Grafana
 - Prometheus

## Pré-requisito
- Docker instalado

## Tutorial para executar projeto
Inicialmente é necessário buildar e construir a imagem docker dos serviços conforme instruções abaixo:

### Setup inicial - build e criação de imagens
 - Acessar a pasta do serviço ms-planet e executar os comandos: 
 1º comando: ```mvn clean package -DskipTests```
 2º comando: ```docker build -t desafio-exploracao-planetaria/ms-planet .```  

- Acessar a pasta do serviço ms-probe e executar os comandos
 1º comando: ```mvn clean package -DskipTests```
 2º comando: ```docker build -t desafio-exploracao-planetaria/ms-probe .``` 

- Acessar a pasta do serviço ms-impact-analyzer e executar os comandos
 1º comando: ```mvn clean package -DskipTests```
 2º comando: ```docker build -t desafio-exploracao-planetaria/ms-impact-analyzer .``` 

- Acessar a pasta do serviço ms-radar e executar o comando:
 ```docker build -t desafio-exploracao-planetaria/ms-radar .```

### Iniciar serviços e infraestrutura
 - Acessar a pasta infra/docker e digitar o comando:
 ```docker compose up -d```

### Criar indíce no Elasticsearch
  - Acessar http://localhost:5601, no menu lateral nevegar até a opção **management** e clicar em DevTools. No painel do DevTools executar o seguinte comando: 
  ```PUT /probe-collision```
  Obs: **ESSA PARTE DA CRIAÇÃO DO ÍNDICE É SUPER IMPORTANTE PARA O FUNCIONAMENTO DA SOLUÇÃO COMPLETA**

### Fluxo 
 1º Adicionar planeta
 2º Adicionar sonda
 3º Adicionar instruções de pouso
 4º Enviar comandos para a sonda
 
 ### Collection do Postman
 - A collection do postman está na pasta **collection**.

### ATENÇÃO
 - Após iniciar os serviços com o docker compose, verifique pelo logs se todos serviços subiram com sucesso antes de executar o fluxo, para isso basta executar o comando:
 ```docker logs -f [nome-do-container]```
 - Se notar algum comportamento estranho em algum container reiniciei o container com o comando: **docker restart [nome-do-container]**. Caso o problema ainda persistir, remova o container com o comando **docker rm -f [nome-do-container]**. Após o procedimento, execute novamente o comando **docker compose up -d** para subir novamente os serviços

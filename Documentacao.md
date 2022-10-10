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

### Fluxo 
 1º Adicionar planeta
 2º Adicionar sonda
 3º Adicionar instruções de pouso
 4º Enviar comandos para a sonda
 
 ### Collection do Postman
 - A collection do postman está na pasta **collection**.

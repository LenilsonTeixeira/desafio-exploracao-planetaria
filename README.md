# Desafio Exploração planetária

# Arquitetura
![](https://github.com/LenilsonTeixeira/desafio-exploracao-planetaria/blob/main/arquitetura.png)

# Service Map
![](https://github.com/LenilsonTeixeira/desafio-exploracao-planetaria/blob/main/service-map.png)

# APM
![](https://github.com/LenilsonTeixeira/desafio-exploracao-planetaria/blob/main/apm.png)

# Pipeline Logstash
![](https://github.com/LenilsonTeixeira/desafio-exploracao-planetaria/blob/main/pipeline-logstash.png)

# Mensagem processada através do pipeline do Logstash
![](https://github.com/LenilsonTeixeira/desafio-exploracao-planetaria/blob/main/mensagem-processada-logstash.png)

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

## URLs
- http://localhost:5601 (Kibana)
- http://localhost:5601/app/dev_tools#/console (DevTools)
- http://localhost:9200 (Elasticsearch)
- http://localhost:5601/app/apm/services (APM)
- http://localhost:9090/targets (Prometheus)
- http://localhost:3000/login (Grafana) Usuário: admin Senha: admin 

**Consultas internas:**
- GET http://localhost:8087/probes/collision?planet=terra&probe=lunar&locationX=3&locationY=3 (exemplo de chamada ao ms-impact-analyzer)
- GET http://localhost:8085/planets/marte  (exemplo de chamada ao ms-radar para consutar planeta salvo no cache)
- GET http://localhost:8085/probes/lunar (exemplo de chamada ao ms-radar para consultar informação atualizada da sonda no cache)


### ATENÇÃO
 - Após iniciar os serviços com o docker compose, verifique pelo logs se todos serviços subiram com sucesso antes de executar o fluxo, para isso basta executar o comando:
 ```docker logs -f [nome-do-container]```
 - Se notar algum comportamento estranho em algum container reiniciei o container com o comando: **docker restart [nome-do-container]**. Caso o problema ainda persistir, remova o container com o comando **docker rm -f [nome-do-container]**. Após o procedimento, execute novamente o comando **docker compose up -d** para subir novamente os serviços.

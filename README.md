# PS-Java
## Desafio PS-Java da Supera.
### Versão do Java - 11.
---

## Como executar o projeto?
### Faça a importação do projeto no Eclipse (ou uma IDE de sua preferência) e para rodar o projeto executar a classe principal do projeto "GameStoreApplication.java".

## Endpoints
LISTAR TODOS OS PRODUTOS (GET)
http://localhost:8080/products

DETALHES DO PRODUTO (GET)
http://localhost:8080/products/1

ADICIONAR UM PRODUTO (POST)
http://localhost:8080/products
Exemplo:
{
    "id": 4,
    "name": "Dragon Quest VIII",
    "price": 100.0,
    "score": 3,
    "image": "dragonquest8.png"
}

LISTAR PRODUTOS DO CARRINHO (GET) - Não concluído
http://localhost:8080/checkout

ADICIONAR UM PRODUTO AO CARRINHO (POST) - Não concluído
/checkout...

REMOVER UM PRODUTO DO CARRINHO (DELETE) - Não concluído
/checkout...

### OBS: Na pasta resources tem um arquivo chamado data.sql que gera alguns inserts sempre que a aplicação é executada. Neste projeto foi utilizado o banco de dados chamado H2, que salva os dados em memória durante a execução.

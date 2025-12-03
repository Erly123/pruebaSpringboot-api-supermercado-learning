<h1 align="center">
  Supermercado Service Api
</h1>

<p align="center">
 <a href="https://www.linkedin.com/in/erly-choqque-layme-449391208" target="_blank">
  <img src="https://img.shields.io/static/v1?label=LinkedIn&message=@erlychoqquelayme&color=0A66C2&labelColor=000000" alt="@erlychoqquelayme" />
 </a>
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Projeto&color=0A66C2&labelColor=000000" alt="Projeto" />
</p>

API para gerenciar produtos, categorias e vendas (CRUD)

## Tecnologias

- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate Validator
- Lombok

## Práticas adotadas

- SOLID
- Testes automatizados
- Uso de DTOs para a API
- Injeção de Dependências
- Separação de regras de negócio em Services
- Tratamento de exceções customizadas

## Como Executar

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar pruebaSpringboot-api-supermercado/target/pruebaSpringboot-api-supermercado-0.0.1-SNAPSHOT.jar
```

### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name pruebaSpringboot-api-supermercado -p 8080:8080  -d pruebaSpringboot-api-supermercado:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

- POST /api/productos
```
http://localhost:8080/api/productos
{
    "nombre" : "Coca",
    "categoria" : "Bebidas",
    "precio" : 1500.0,
    "cantidad" : 30
}

Status 201 Ok
Location: /api/productos1
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 03 Dec 2025 18:34:56 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
    "id": 1,
    "nombre": "Coca",
    "categoria": "Bebidas",
    "precio": 1500.0,
    "cantidad": 30
}
```
- POST /api/sucursales
```
http://localhost:8080/api/sucursales
{
    "nombre" : "Sucursal 1",
    "direccion" : "Calle 1"
}

Status 201 Ok
Location: /api/sucursales1
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 03 Dec 2025 18:38:32 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
    "id": 1,
    "nombre": "Sucursal 1",
    "direccion": "Calle 1"
}
```
- POST /api/ventas
```
http://localhost:8080/api/ventas
{
    "fecha": "2026-12-12",
    "estado": "REGISTRADO",
    "idSucursal": 1,
    "detalle": [
        {
            "id": 1,
            "nombreProd": "Coca",
            "cantProd": 2,
            "precio": 1500.0,
            "subtotal": 3000.0
        },
        {
            "id": 2,
            "nombreProd": "Naranja",
            "cantProd": 3,
            "precio": 1500.0,
            "subtotal": 4500.0
        }
    ],
    "total": 7500.0
}

Status 201 Ok
Location: /api/ventas/1
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 03 Dec 2025 18:41:32 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
    "id": 1,
    "fecha": "2026-12-12",
    "estado": "REGISTRADO",
    "idSucursal": 1,
    "detalle": [
        {
            "id": 1,
            "nombreProd": "Coca",
            "cantProd": 2,
            "precio": 1500.0,
            "subtotal": 3000.0
        },
        {
            "id": 2,
            "nombreProd": "Naranja",
            "cantProd": 3,
            "precio": 1500.0,
            "subtotal": 4500.0
        }
    ],
    "total": 7500.0
}
```

- GET /api/ventas
```
http://localhost:8080/api/ventas

Status 200 Ok
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 03 Dec 2025 19:00:30 GMT 
Keep-Alive: timeout=60
Connection: keep-alive

[
    {
        "id": 1,
        "fecha": "2026-12-12",
        "estado": "REGISTRADO",
        "idSucursal": 1,
        "detalle": [
            {
                "id": 1,
                "nombreProd": "Coca",
                "cantProd": 2,
                "precio": 1500.0,
                "subtotal": 3000.0
            },
            {
                "id": 2,
                "nombreProd": "Naranja",
                "cantProd": 3,
                "precio": 1500.0,
                "subtotal": 4500.0
            }
        ],
        "total": 7500.0
    }
]
```

- PUT /api/ventas/{id}
```
http://localhost:8080/api/ventas/1
{
    "fecha": "2026-12-12",
    "estado": "REGISTRADO",
    "idSucursal": 2,
    "detalle": [
        {
            "id": 1,
            "nombreProd": "Coca",
            "cantProd": 3,
            "precio": 1500.0,
            "subtotal": 4500.0
        },
        {
            "id": 2,
            "nombreProd": "Naranja",
            "cantProd": 3,
            "precio": 1500.0,
            "subtotal": 4500.0
        }
    ],
    "total": 9000.0
}


Status 200 Ok
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 03 Dec 2025 18:56:43 GMT 19:00:30
Keep-Alive: timeout=60
Connection: keep-alive

{
    "id": 1,
    "fecha": "2026-12-12",
    "estado": "REGISTRADO",
    "idSucursal": 2,
    "detalle": [
        {
            "id": 1,
            "nombreProd": "Coca",
            "cantProd": 2,
            "precio": 1500.0,
            "subtotal": 3000.0
        },
        {
            "id": 2,
            "nombreProd": "Naranja",
            "cantProd": 3,
            "precio": 1500.0,
            "subtotal": 4500.0
        }
    ],
    "total": 7500.0
}

```
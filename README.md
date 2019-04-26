# sample-micronaut
Micronaut is a new JVM-based framework.

## Docs 
https://docs.micronaut.io/latest/guide/index.html
Security guide https://guides.micronaut.io/micronaut-oauth2-okta/guide/index.html

## swagger (OpenApi v3)
http://localhost:8080/swagger/sample-micronaut-application-1.0.yml

## Tests
```
GET http://localhost:8080/foo/greeting?name=Petr

HTTP/1.1 200 OK
Date: Thu, 25 Apr 2019 20:10:53 GMT
content-type: application/json
content-length: 31
connection: keep-alive

{
  "id": 4,
  "name": "Hola, Petr!"
}
```

```
POST http://localhost:8080/foo/greeting
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{"name":"man"}
>>
HTTP/1.1 200 OK
Date: Thu, 25 Apr 2019 20:14:07 GMT
content-type: application/json
content-length: 34
connection: keep-alive

{
  "id": 6,
  "name": "Hola, man!"
}

```
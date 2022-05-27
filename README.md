#Pasos
##Generar el UberJar

Ingresar el directorio del proyecto donde se encuentra el archivo pom.xml
```
mvn clean install
```

## Ejecutar
```
java -jar target/mongodbatlasdriver-0.1-microbundle.jar                                                
```

## Se generan los enpoints
http://localhost:8080/

```
'ROOT' REST Endpoints:
GET     /api/application.wadl
GET     /api/country
GET     /api/country/{id}
GET     /api/hello
GET     /openapi/
GET     /openapi/application.wadl

]]

```

Dssde el navegador
Obtener todos los documentos
http://localhost:8080/api/country/

Buscar por idcountry=PA
http://localhost:8080/api/country/PA
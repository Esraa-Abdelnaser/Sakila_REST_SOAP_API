
# Sakila SOAP and REST API

The Sakila API is a RESTful and SOAP API for accessing the Sakila database, which is a sample database provided by MySQL. The API allows developers to retrieve information about films, actors, customers, and other entities in the database.

## Documentation

[Postman RESTful API](https://documenter.getpostman.com/view/26735340/2s93Y2R1RN)

[Postman SOAP API]()

## Technologies used
- JAX-RS (Jersey)
- JAX-WS (Metro)
- JSON-B
- JAX-B
- JAX-P
- Maven
- Map struct
- Lombok
- Tomcat
- Jakarta persistance (Hibernate)
- MySql
- Intellij IDEA Ultimate
- Postman
- SOAP-UI

## REST API

The REST API provides endpoints for accessing the Sakila database using HTTP requests. The endpoints are organized around resources such as films, actors, and customers. Each resource has a unique URI, and the API supports the following HTTP methods:
- GET: retrieve a resource or a collection of resources
- POST: create a new resource
- PUT: update an existing resource
- DELETE: delete a resource

## Endpoints

| Endpoint      | Resource     
| :--------      | :------- 
| `/actor`      | ActorResource
| `/address`      | AddressResource
| `/category`      | CategoryResource
| `/city`      | CityResource
| `/country`      | CountryResource
| `/customer`      | CustomerResource
| `/film`      | FilmResource
| `/filmText`      | FilmTextResource
| `/inventory`      | InventoryResource
| `/language`      | LanguageResource
| `/payment`      | PaymentResource
| `/rental`      | RentalResource
| `/staff`      | StaffResource
| `/store`      | StoreResource

To retrieve information about all films, you can send a GET request to the /films endpoint. To retrieve information about a specific film, you can send a GET request to the /films/{id} endpoint, where {id} is the ID of the film.

## Authentication
The Sakila API does not require authentication. However, it is recommended to implement authentication and authorization mechanisms if the API is used in production environments.

## SOAP API
The SOAP API provides a WSDL file that describes the available operations and data types. The API uses SOAP over HTTP as the transport protocol and XML as the data format.

## Run with Maven
Clone the project

```bash
  git clone https://github.com/Esraa-Abdelnaser/Sakila_REST_SOAP_API
```

Go to the project directory

```bash
  cd Sakila_REST_SOAP_API
```
- Create db user and set the username and password values in the persistence.xml
- Create db named sakila in your MySql Server
- Run your tomcat apache server and then change the configuration of tomcat in pom.xml
- Deploy the application using the following maven command
```
  mvn clean install tomcat7:redeploy
```

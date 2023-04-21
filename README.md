# Sakila SOAP and REST API

The Sakila API is a RESTful and SOAP API for accessing the Sakila database, which is a sample database provided by
MySQL. The API allows developers to perform CRUD operations on films, actors, customers, and other entities in the
database.

## Documentation

[Postman RESTful API](https://documenter.getpostman.com/view/26735340/2s93Y3ugCW)

[Postman SOAP API](https://documenter.getpostman.com/view/26735340/2s93Y3uftt)

[SOAP-UI project WSDL](https://github.com/Esraa-Abdelnaser/Sakila_REST_SOAP_API/blob/main/wsdl_soapui-project.xml)
## Technologies used

- JAX-RS (Jersey)
- JAX-WS (Metro)
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

The REST API provides endpoints for accessing the Sakila database using HTTP requests. The endpoints are organized
around resources such as film, actor, and customer. Each resource has a unique URI, and the API supports the
following HTTP methods:

- GET: retrieve a resource or a collection of resources
- POST: create a new resource
- PUT: update an existing resource
- DELETE: delete a resource

## Endpoints

| Endpoint     | Resource          |
|:-------------|:------------------|
| `/actor`     | ActorResource     |
| `/address`   | AddressResource   |
| `/category`  | CategoryResource  |
| `/city`      | CityResource      |
| `/country`   | CountryResource   |
| `/customer`  | CustomerResource  |
| `/film`      | FilmResource      |
| `/filmText`  | FilmTextResource  |
| `/inventory` | InventoryResource |
| `/language`  | LanguageResource  |
| `/payment`   | PaymentResource   |
| `/rental`    | RentalResource    |
| `/staff`     | StaffResource     |
| `/store`     | StoreResource     |

To retrieve information about all films, you can send a GET request to the /films endpoint. To retrieve information
about a specific film, you can send a GET request to the /film/{id} endpoint, where {id} is the ID of the film.
Creating a new resource with POST

To create a new resource, send a POST request to the corresponding endpoint with the resource data in the request body.
For example, to create a new film, send a POST request to the /film endpoint with the film details in the request body.

To update an existing resource, send a PUT request to the corresponding endpoint with the updated resource data in the
request body.
For example, to update an existing film, send a PUT request to the /film endpoint, where {id} is the ID of the
film to be updated, with the updated film details in the request body.

To delete a resource, send a DELETE request to the corresponding endpoint with the ID of the resource to be deleted.
For example, to delete an existing film, send a DELETE request to the /film/{id} endpoint, where {id} is the ID of the
film to be deleted.

## SOAP API

The SOAP API provides a WSDL file that describes the available operations and data types. The API uses SOAP over HTTP as
the transport protocol and XML as the data format.

## Endpoints

| Endpoint               | Service          |
|:-----------------------|:-----------------|
| `/ws/actorService`     | ActorService     |
| `/ws/addressService`   | AddressService   |
| `/ws/categoryService`  | CategoryService  |
| `/ws/cityService`      | CityService      |
| `/ws/countryService`   | CountryService   |
| `/ws/customerService`  | CustomerService  |
| `/ws/filmService`      | FilmService      |
| `/ws/filmTextService`  | FilmTextService  |
| `/ws/inventoryService` | InventoryService |
| `/ws/languageService`  | LanguageService  |
| `/ws/paymentService`   | PaymentService   |
| `/ws/rentalService`    | RentalService    |
| `/ws/staffService`     | StaffService     |
| `/ws/storeService`     | StoreService     |

## Conclusion

The Sakila API provides a convenient way to access the Sakila database using RESTful and SOAP interfaces. The API is
easy to use and can be integrated with a wide range of HTTP clients and programming languages.

## Database Schema

<p align="center">
  <img src="src/main/resources/imgs/sakila-schema.png" title="erd">
</p>

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

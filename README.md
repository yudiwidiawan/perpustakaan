# Getting Started

This is a backend REST API to manage a simple book library built using Spring Boot. There are few simple features such as :

1. Insert books data
    - Using [POST] /api/v1/book
2. Insert recipients data
    - Using [POST] /api/v1/recipient
3. Recipient rent the books and return the books Action
    - Using [PUT] /api/v1/book/{bookId}/borrow to borrow a book
    - Using [PUT] /api/v1/book/{bookBorrowId}/return to return a book
4. Get List of Borrowed Book
    - Using [GET] /api/v1/book/borrow-status

Complete API documentation can be accessed via :
- hostname:port/swagger-ui/index.html

Before running this project, make sure to install and run MySQL instance, create the database named 'perpustakaan' and run the database.sql script in MySQL Editor.
Database credentials are saved in application.properties in this project.


These are the following credentials for getting started :

1. Admin
    - username: yudiadmin@gmail.com
    - password: admin123





### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web.security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


#### Spring E-Commerce

[![Java CI with Maven](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml/badge.svg)](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml) <a href="https://github.com/JunChen22/E-commerce-React"><img src="https://img.shields.io/badge/Frontend-React-green"></a> <a href="https://github.com/JunChen22/E-commerce-microservice"><img src="https://img.shields.io/badge/Miscroservice-version-green"></a> <a href="TBD"><img src="https://img.shields.io/badge/Demo-running-green"></a>

Single vendor E-commerce suited for small to medium business. It's more of a database driven design approach. Turn existing
RDMS turned into e-commerce.

``` lua
E-commerece 
├── E-commerece-admin    -- the admin(owner) used to manage the e-commerece and users
├── E-commerece-app      -- main application, process the requests.
├── E-commerece-search   -- searching related module, in-memory imported in data for fast search
├── E-commerece-common   -- shared common module     -- not being used, idk why intelliJ kept giving me problem when separated.
├── E-commerece-mbg      -- shared mybatist module   -- not being used, idk why intelliJ kept giving me problem when separated.
└── E-commerece-security -- shared security module   -- not being used, idk why intelliJ kept giving me problem when separated.
The .env file stores login infos for easier change. Gets read in during run time by docker.

ECom-app 
├── config                 - MyBatis configuration and other configuration.
├── controller              
├── domain (domain model)  - custom data object, provide more complex funtionality with custom DAO and xml. Internal use.
├── dao                    - custom data access object(DAO) interface to interact with Postgres. Definitition impltemented in resources.
├── dto                    - data transfer object, custom object to return or received from backend to frontend. keep it small for effiency.
├── mbg     
│   ├── mapper             - Mybatis generated, interfaces for generic function to interact with Postgres
│   └── model              - Mybatis generated, turn Postgres table into model, basic function, getting setter for colum.  
├── security               - no security will be added untill admin's is complete.
├── service
└── resources
    ├── mapper             - Mybatis generated, generic definition for the generated mapper interfaces. 
    ├── dao                - custom SQL in xml file
    ├── application.yml
    └── generatorConfig.xml - MyBatisGenerator setting.

ECom-admin is similar structure and provide similar basic functions. But ECom-admin provides more unique ones.
Will have role and permission based.
ECom-admin 
├── config                 - MyBatis configuration and other configuration.
├── controller              
├── dao                    - custom data access object(DAO) interface to interact with Postgres. Definitition impltemented in resources.
├── dto                    - data transfer object, custom object to return or received from backend to frontend. keep it small for effiency.
├── mbg     
│   ├── mapper             - Mybatis generated, interfaces for generic function to interact with Postgres
│   └── model              - Mybatis generated, turn Postgres table into model, basic function, getting setter for colum.  
├── security               
├── service
└── resources
    ├── mapper             - Mybatis generated, generic definition for the generated mapper interfaces. 
    ├── dao                - custom SQL in xml file
    ├── application.yml
    └── generatorConfig.xml - MyBatisGenerator setting.

ECom-search is more of a standalone part of the E-commerece
ECom-search
├── config                 - MyBatis configuration and other configuration.
├── controller              
├── dao                    - custom data access object(DAO) interface to interact with Postgres. Definitition impltemented in resources.
├── elastic search     
│   ├── document
│   └── repository
├── mongodb                - store search history.
├── service
└── resources
    ├── dao                - custom SQL in xml file
    └── application.yml

```

Hibernate is an ORM framework that provides a high-level, declarative way to define your data model in Java and have
Hibernate generate the database schema for you, while MyBatis is a SQL mapper framework that provides a low-level,
programmatic way to interact with a database using SQL statements. MyBatis Generator is a tool that generates Java
code based on an existing database schema to help with building a custom data access layer.

Tried separating mbg to another module but kept having problem with it. Either maven or IntelliJ error. Right now it's 
kept together and will separate it later.

API calls and documentations
- get the whole landscape running then
- go to http://localhost:8080/swagger-ui.html
- in E-commerece.postman_collection, there's a examples for simples apis used in Postman.

Set up/installation:

```
Database and mybatis generator

  Generate mybatis files
 $ docker-compose up postgres
 $ cd ECom-app
 $ mvn mybatis-generator:generate -Dmybatis.generator.overwrite=true // generate DAO, mapper and java clasees
 $ docker-compose down

need to put your own paypal id and secret from Paypal developer API credential at https://developer.paypal.com/home/
in ECom-app's application.yml or .env file.  The program won't run without it. And remove it when sharing program.
And create a paypal sandbox account so transaction is not real.

  Start whole landscape
 $ mvn package
 $ docker-compose build
 $ docker-compose up
 
  Import data into elastic search
 $  curl -X POST http://localhost:8080/esProduct/importAll   // should return number of items imported
 

Other nesscary commands
 
 $ docker exec -it e-commerce_mongodb_1 bash     // interact with mongodb    
 # mongosh

 $ docker exec -it e-commerce_postgres_1 psql -U postgres    // interact with postgres
 $ \c springecommerece
 
```

### Tech stack
| Tech                                                            | role                                  | version | How is it being used here                       |
|-----------------------------------------------------------------|---------------------------------------|---------|-------------------------------------------------|
| [SpringBoot](https://spring.io/projects/spring-boot)            | MVC framework                         | 2.5.2   |                                                 |
| [SpringSecurity](https://spring.io/projects/spring-security)    | Security                              | 2.5.2   |                                                 |
| [PostgreSQL](https://www.postgresql.org/)                       | SQL database                          | 9.6.10  | store all product and user related data         |
| [MyBatis](http://www.mybatis.org/mybatis-3/zh/index.html)       | ORM framework                         | 2.3.0   | ORM(object relation mapping), middle ware       |
| [MyBatisGenerator](http://www.mybatis.org/generator/index.html) | Sourcecode generator                  | 1.4.0   | Generate basic functionality(CRUD) to database  |
| [RabbitMQ](https://www.rabbitmq.com/)                           | Message queue                         |         |                                                 |
| [Redis](https://redis.io/)                                      | Cache mechanism                       |         | used like a scheduler here, emails verification |
| [MongoDB](https://www.mongodb.com)                              | NoSql database(search & read history) | 5.0.0   | store user search & view history                |
| [Elasticsearch](https://github.com/elastic/elasticsearch)       | Search engine                         | 7,12.0  | imported data from PostgreSQL for fast search   |
| [LogStash](https://github.com/elastic/logstash)                 | Logging Service                       | 7,12.0  |                                                 |
| [Kibana](https://github.com/elastic/kibana)                     | Elasticsearch LogStash visualization  | 7,12.0  |                                                 |
| [Nginx](https://www.nginx.com/)                                 | Webserver / Load balancing            |         |                                                 |
| [Docker](https://www.docker.com)                                | Containerization                      |         | Easier deployment                               |
| [JWT](https://github.com/jwtk/jjwt)                             | Encryption tool                       |         |                                                 |
| [Lombok](https://github.com/rzwitserloot/lombok)                | minimize boilerplate                  |         |                                                 |
| [PageHelper](http://git.oschina.net/free/Mybatis_PageHelper)    | MyBatis pagination helper             |         |                                                 |
| [Swagger-UI](https://github.com/swagger-api/swagger-ui)         | Documentation tool                    |         |                                                 |
| [Hibernate-Validator](http://hibernate.org/validator)           | Validation                            |         |                                                 |
| [PayPal](https://developer.paypal.com/home)                     | Payment Gateway                       | 1.14.0  | Third party payment processor                   |
| [Ubuntu](https://ubuntu.com/)                                   | OS                                    |         |                                                 |
| AWS S3                                                          | File storage                          |         | store images, videos                            |


IntelliJ plugin
- MyBatisCodeHelperPro 3.1.8 (highly needed when writing dao.xml)

Redis wasn't being used yet.

![alt text](./document/Monolith.png)

Admin - administrative task and all the function app can do. With it's own database for admin information.  

App - 5 major category/service and security. All write operations are send off to RabbitMQ so it can be processed asynchronously.

Product management system(PMS) - manage their product catalog, including product data, pricing, and inventory.
- product
- brand
- review

Order management system(OMS) -  manage their order processing, inventory, shipping, and other fulfillment-related tasks.
- order management
- return/refund
- shopping cart

Sales management system(SMS) - manage their sales processes, including lead generation, customer relationship management, and sales analytics.
- sales
- promotion sales (time frame)
- flash sales (by short time or by number of sales)
- coupon
- view used coupon history

Content management system(CMS) - create, manage, and publish digital content, such as text, images, and multimedia, on websites or other digital platforms.
- misc things like
- Contact US
- Buyer's guide("article")
- product comparison
- guide on what to buy
- about us
- shipping and return
- warranty
- home page(words and pictures)
- product comparison
- FAQ

User management system(UMS) - manage user accounts and permissions, including authentication, authorization, and access control.
- User


### Order process flow

1. add product -> cart,cart items

2. cart items -> checkout -> generate order

3. (will ask for login if your e-commerce requires, this ECom requires)

4. generate (actual) order ->
   calculate final price(coupon, promotion, sale), check stock, lock in stock, shipping
   -> send price to PayPal -> PayPal send customer to their paypal page -> (this part not done by us)
   they choose their payment and agreed amount to pay to PayPal -> PayPal send us pay proof they paid to PayPal,
   and redirect user to success page
   -> use said proof to get the payment to us -> finish post payment work like update stock, generate order
   serial number, create order to our database, delete user shopping cart


![alt text](./document/paypal%20checkout%20workflow.png)



Docker:
- https://docs.docker.com/engine/install/ubuntu/

Elastic search:
- https://www.elastic.co/guide/en/elasticsearch/reference/current/deb.html#install-deb

### Material used:
- https://github.com/macrozheng/mall
- https://www.youtube.com/watch?v=EpYBP7EZ8Y4
- https://www.youtube.com/watch?v=-PcU6uf-p3g&list=PLA7e3zmT6XQUNzbNoTb-8c-VTa_i_w5-y

JWT:
- https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
- https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world

MyBatis
- https://mybatis.org/mybatis-3/sqlmap-xml.html
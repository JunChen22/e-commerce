#### Spring E-Commerce

[![Java CI with Maven](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml/badge.svg)](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml) <a href="https://github.com/JunChen22/E-commerce-React"><img src="https://img.shields.io/badge/Frontend-React-green"></a> <a href="https://github.com/JunChen22/E-commerce-microservice"><img src="https://img.shields.io/badge/Miscroservice-version-green"></a> <a href="TBD"><img src="https://img.shields.io/badge/Demo-running-green"></a>

This project was based on mall by macrozheng on GitHub. It's more of a data base driven design approach. Existing
RDMS turned into e-commerce.

``` lua
E-commerece 
├── E-commerece-admin    -- the admin(owner) used to manage the e-commerece and users
├── E-commerece-app      -- main application, process the requests.
├── E-commerece-search   -- searching related module, in-memory imported in data for fast search
├── E-commerece-common   -- shared common module
├── E-commerece-mbg      -- shared mybatist module
└── E-commerece-security -- shared security module
The .env file stores login infos for easier change. Gets read in during run time by docker.

E-commerece-app 
├── component   
├── config                 - MyBatis configuration and other configuration.
├── controller              
├── domain                 - provide more complex funtionality with custom DAO and xml.
├── dao                    - custom data access object(DAO) interface to interact with Postgres. Definitition impltemented in resources.
├── dto                    - data transfer object, 
├── mbg     
│   ├── mapper             - Mybatis generated, interfaces for generic function to interact with Postgres
│   └── model              - Mybatis generated, turn Postgres table into model, basic function, getting setter for colum.  
├── mongodb                - not being used yet.
├── security
├── service
└── resources
    ├── mapper             - Mybatis generated, generic definition for the generated mapper interfaces. 
    ├── dao                - custom SQL in xml file
    ├── application.yml
    └── generatorConfig.xml - MyBatisGenerator setting.

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
- in API_calls.txt, there's a examples for simples apis.

Set up/installation:

```
Database and mybatis generator

  Generate mybatis files
 $ docker-compose up postgres
 $ cd ECom-app
 $ mvn mybatis-generator:generate -Dmybatis.generator.overwrite=true // generate DAO, mapper and java clasees
 $ docker-compose down

  Start whole landscape
 $ mvn package
 $ docker-compose build
 $ docker-compose up
 
  Import data into elastic search
 $  curl -X POST http://localhost:8080/esProduct/importAll   // should return number of items imported
 
```

### Tech stack
| Tech                | role                                  | version | documentation                                  |
|---------------------|---------------------------------------|---------|------------------------------------------------|
| SpringBoot          | MVC framework                         |         | https://spring.io/projects/spring-boot         |
| SpringSecurity      | Security                              |         | https://spring.io/projects/spring-security     |
| PostgreSQL          | SQL database                          |         | https://www.postgresql.org/                    |
| MyBatis             | ORM framework                         |         | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator    | Sourcecode generator                  |         | http://www.mybatis.org/generator/index.html    |
| RabbitMQ            | Message queue                         |         | https://www.rabbitmq.com/                      |
| Redis               | Cache mechanism                       |         | https://redis.io/                              |
| MongoDB             | NoSql database(search & read history) |         | https://www.mongodb.com                        |
| Elasticsearch       | Search engine                         |         | https://github.com/elastic/elasticsearch       |
| LogStash            | Logging Service                       |         | https://github.com/elastic/logstash            |
| Kibana              | Elasticsearch LogStash visualization  |         | https://github.com/elastic/kibana              |
| Nginx               | Webserver                             |         | https://www.nginx.com/                         |
| Docker              | Containerization                      |         | https://www.docker.com                         |
| Kubernetes          | Container Orchestration               |         | https://kubernetes.io/                         |
| JWT                 | Encryption tool                       |         | https://github.com/jwtk/jjwt                   |
| Lombok              | minimize boilerplate                  |         | https://github.com/rzwitserloot/lombok         |
| PageHelper          | MyBatis pagination helper             |         | http://git.oschina.net/free/Mybatis_PageHelper |
| Swagger-UI          | Documentation tool                    |         | https://github.com/swagger-api/swagger-ui      |
| Hibernate-Validator | Validation                            |         | http://hibernate.org/validator                 |
| PayPal              | Payment Gateway                       | 1.4.1   | https://developer.paypal.com/home              |
| Google Pay          | Payment Gateway                       |         | https://developers.google.com/pay/api          |
| Ubuntu              | OS                                    |         | https://ubuntu.com/                            |
| AWS S3              | File storage                          |         |                                                |






Mongo and Redis wasn't being used yet.



Categories of the shop

- Product management system(PMS)
- Order management system(OMS)
- Sales management system(SMS)
- Content management system(CMS)
- User management system(UMS)

Product Management System:
A software application that helps businesses manage their product catalog, including product data, pricing, and inventory.

Content Management System:
A software application that allows users to create, manage, and publish digital content, such as text, images, and multimedia, on websites or other digital platforms.

Order Management System:
A software application that helps businesses manage their order processing, inventory, shipping, and other fulfillment-related tasks.

Sales Management System:
A software application that helps businesses manage their sales processes, including lead generation, customer relationship management, and sales analytics.

User Management System:
A software application that helps businesses manage user accounts and permissions, including authentication, authorization, and access control.


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
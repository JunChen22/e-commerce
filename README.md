#### Spring E-Commerce 

[![Java CI with Maven](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml/badge.svg)](https://github.com/JunChen22/E-commerce/actions/workflows/maven.yml) <a href="https://github.com/JunChen22/E-commerce-React"><img src="https://img.shields.io/badge/Frontend-React-green"></a> <a href="https://github.com/JunChen22/E-commerce-microservice"><img src="https://img.shields.io/badge/Miscroservice-version-green"></a> <a href="TBD"><img src="https://img.shields.io/badge/Demo-running-green"></a>

This project was based on mall by macrozheng on github. 

``` lua
E-commerece 
├── E-commerece-admin    -- the admin(owner) used to manage the e-commerece and users
├── E-commerece-app      -- main application, process the requests.
├── E-commerece-search   -- searching related module, in-memory imported in data for fast search
├── E-commerece-common   -- shared common module
├── E-commerece-mbg      -- shared mybatist module
└── E-commerece-security -- shared security module

The .env file stores login infos for easier change. Gets read in during run time by docker.
```

MyBatis is more of a build around the database. Using MyBatis Generator to generate java boilerplate code of the database.
And can create custom DAO and write custom SQL for it in resources/dao. Kind of opposite of Hibernate approach. 
Write java code to then it will create custom table.



API calls and documentations
 - get the whole landscape running then
 - go to http://localhost:8080/swagger-ui.html


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
```

### Tech stack 
| Tech                | role                                 | version  | documentation                                  |
|---------------------|--------------------------------------|----------|------------------------------------------------|
| SpringBoot          | MVC framework                        |          | https://spring.io/projects/spring-boot         |
| SpringSecurity      | Security                             |          | https://spring.io/projects/spring-security     |
| PostgreSQL          | SQL database                         |          | https://www.postgresql.org/                    |
| MyBatis             | ORM framework                        |          | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator    | Sourcecode generator                 |          | http://www.mybatis.org/generator/index.html    |
| Elasticsearch       | Search engine                        |          | https://github.com/elastic/elasticsearch       |
| RabbitMQ            | Message queue                        |          | https://www.rabbitmq.com/                      |
| Redis               | Cache mechanism                      |          | https://redis.io/                              |
| MongoDB             | NoSql database                       |          | https://www.mongodb.com                        |
| LogStash            | Logging Service                      |          | https://github.com/elastic/logstash            |
| Kibina              | Elasticsearch LogStash visualization |          | https://github.com/elastic/kibana              |
| Nginx               | Webserver                            |          | https://www.nginx.com/                         |
| Docker              | Containerization                     |          | https://www.docker.com                         |
| Kubernetes          | Container Orchestration              |          | https://kubernetes.io/                         |
| JWT                 | Encryption tool                      |          | https://github.com/jwtk/jjwt                   |
| Lombok              | minimize boilerplate                 |          | https://github.com/rzwitserloot/lombok         |
| PageHelper          | MyBatis pagination helper            |          | http://git.oschina.net/free/Mybatis_PageHelper |
| Swagger-UI          | Documentation tool                   |          | https://github.com/swagger-api/swagger-ui      |
| Hibernate-Validator | Validation                           |          | http://hibernate.org/validator                 |
| PayPal              | Payment Gateway                      |          | https://developer.paypal.com/home              |
| Google Pay          | Payment Gateway                      |          | https://developers.google.com/pay/api          |
| Ubuntu              | OS                                   |          | https://ubuntu.com/                            |
| AWS S3              | File storage                         |          |                                                |


Categories of the shop

- Product management system(PMS)
- Order management system(OMS)
- Sales management system(SMS)
- Content management system(CMS)
- User management system(UMS)

Product Management System: A software application that helps businesses manage their product catalog, including product data, pricing, and inventory.

Content Management System: A software application that allows users to create, manage, and publish digital content, such as text, images, and multimedia, on websites or other digital platforms.

Order Management System: A software application that helps businesses manage their order processing, inventory, shipping, and other fulfillment-related tasks.

Sales Management System: A software application that helps businesses manage their sales processes, including lead generation, customer relationship management, and sales analytics.

User Management System: A software application that helps businesses manage user accounts and permissions, including authentication, authorization, and access control.


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

#### Spring E-Commerce 
[![Build Status](https://travis-ci.com/JunChen22/Spring-E-commerce.svg?branch=master)](https://travis-ci.com/JunChen22/Spring-E-commerce)

This project was based on mall by macrozheng on github.

``` lua
E-commerece 
├── E-commerece-app  -- main application
├── E-commerece-search  -- searching related module
├── E-commerece-common  -- shared common module
├── E-commerece-mbg  -- shared mybatist module
└── E-commerece-security -- shared security module
```

API calls
 - go to http://localhost:8080/swagger-ui.html


Set up/installation:


	Database:

		$ sudo apt-get install postgres
     	$ sudo -u postgres psql
     	# CREATE DATABASE springecommerece;
        # ALTER USER postgres PASSWORD 'password';
        # \q
    	```
    	Docker:
            https://docs.docker.com/engine/install/ubuntu/
    	Elastic search:
            https://www.elastic.co/guide/en/elasticsearch/reference/current/deb.html#install-deb



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






###Material used:
- https://github.com/macrozheng/mall
- https://www.youtube.com/watch?v=EpYBP7EZ8Y4
- https://www.youtube.com/watch?v=-PcU6uf-p3g&list=PLA7e3zmT6XQUNzbNoTb-8c-VTa_i_w5-y


JWT:
- https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
- https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world
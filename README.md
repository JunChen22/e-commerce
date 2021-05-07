#### Spring E-Commerce 
[![Build Status](https://travis-ci.com/JunChen22/Spring-E-commerce.svg?branch=master)](https://travis-ci.com/JunChen22/Spring-E-commerce)

This project was based on mall by macrozheng on github.


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


Start:
- run the program
    ```
     $ mvn spring-boot::run
    ```

Tech used:
- Ubuntu: OS
- SpringBoot
- SpringSecurity
- MyBatis - ORM
- Postgres - database
- Swagger-UI - documentation
- AWS S3 API - file storage
- Docker - container
- Stripe API - Payment Gateway/processor
- Elasticsearch - search engine 
- RabbitMq - message queue

###Material used:
- https://github.com/macrozheng/mall
- https://www.youtube.com/watch?v=EpYBP7EZ8Y4
- https://www.youtube.com/watch?v=-PcU6uf-p3g&list=PLA7e3zmT6XQUNzbNoTb-8c-VTa_i_w5-y


JWT:
- https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
- https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world
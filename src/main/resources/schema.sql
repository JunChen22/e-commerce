 --------Product related
DROP TABLE IF EXISTS brand;

CREATE TABLE brand
  (
     id       SERIAL,
     name     TEXT,
     alphabet TEXT,
     status   TEXT,
     logo     TEXT
  );

DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category
  (
     id        SERIAL  PRIMARY KEY,
     name      TEXT,
     product_count NUMERIC ,
     icon      TEXT,
     parent_id NUMERIC,-- sub category
     level     NUMERIC
  );

DROP TABLE IF EXISTS product_attribute_category;

CREATE TABLE product_attribute_category
  (
     id        SERIAL,
     name TEXT,
     attribute_amount           NUMERIC
  );

DROP TABLE IF EXISTS product_attribute_type;

CREATE TABLE product_attribute_type
  (
     id        SERIAL,
     attribute_category_id NUMERIC,
     name           TEXT
  );

DROP TABLE IF EXISTS product;

CREATE TABLE product
  (
     id                SERIAL,
     brand_id          NUMERIC,
     category_id       NUMERIC,
     name              TEXT,
     picture           TEXT,
     description       TEXT,
     price             NUMERIC,
     sale_price        NUMERIC,
     stock             NUMERIC,
     description_album TEXT,
     status            TEXT
  );


DROP TABLE IF EXISTS product_attribute;

CREATE TABLE product_attribute
  (
     id SERIAL,
     product_id NUMERIC,
     attribute_type_id NUMERIC,
     attribute_value TEXT,
     attribute_unit TEXT
  );


DROP TABLE IF EXISTS comment;

CREATE TABLE comment
  (
     id          SERIAL,
     product_id  NUMERIC,
     member_name TEXT,
     member_icon TEXT,
     star        NUMERIC,
     create_time TIMESTAMP,
     tittle      TEXT,
     likes       NUMERIC,
     content     TEXT,
     pictures    TEXT
  );

DROP TABLE IF EXISTS product_change_log;

CREATE TABLE product_change_log
  (
     id          SERIAL,
     product_id  NUMERIC,
     price_old   NUMERIC,
     price_new   NUMERIC,
     unit_old    NUMERIC,
     unit_new    NUMERIC,
     operate_man TEXT,
     create_time TIMESTAMP
  );

----------User related-----------------
DROP TABLE IF EXISTS member;

CREATE TABLE member
  (
     id           SERIAL ,
     username     TEXT,
     password     TEXT,
     phone_number TEXT,
     status       TEXT,
     create_time  TIMESTAMP,
     last_login   TIMESTAMP,
     source_type  TEXT,
     icon         TEXT
  );

DROP TABLE IF EXISTS receive_address;

CREATE TABLE receive_address
  (  id         SERIAL,
     member_id    NUMERIC,
     phone_number TEXT,
     street       TEXT,
     city         TEXT,
     state        TEXT,
     zip_code     TEXT,
     note         TEXT
  );

DROP TABLE IF EXISTS member_login_log;

CREATE TABLE member_login_log
  (
     id         SERIAL,
     member_id  NUMERIC,
     login_time TIMESTAMP,
     ip_address TEXT,
     login_type TEXT -- 0/1/2 pc TEXT, ios TEXT, android
  );

---------Admin related----------------
DROP TABLE IF EXISTS admin;

CREATE TABLE admin
  (
     id          SERIAL,
     username    TEXT,
     password    TEXT,
     icon        TEXT,
     email       TEXT,
     name        TEXT,
     create_time TIMESTAMP,
     last_login  TIMESTAMP,
     status      TEXT
  );

DROP TABLE IF EXISTS admin_login_log;

CREATE TABLE admin_login_log
  (
     id         SERIAL,
     admin_id   NUMERIC,
     login_time TIMESTAMP,
     ip_address TEXT,
     user_agent TEXT -- type of browser
  );

DROP TABLE IF EXISTS roles;

CREATE TABLE roles
  (
     id          SERIAL,
     name        TEXT,
     description TEXT,
     create_time TIMESTAMP,
     status      TEXT
  );

DROP TABLE IF EXISTS admin_role_relation;

CREATE TABLE admin_role_relation
  (
     id       SERIAL,
     admin_id NUMERIC,
     role_id  NUMERIC
  );
---------Order related-------
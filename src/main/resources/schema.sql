 --------Product related
DROP TABLE IF EXISTS brand;

CREATE TABLE brand
  (
     id       SERIAL  PRIMARY KEY ,
     name     TEXT,
     alphabet TEXT,
     status   TEXT,
     logo     TEXT
  );

DROP TABLE IF EXISTS comment;

CREATE TABLE comment
  (
     id          TEXT,
     product_id  TEXT,
     member_name TEXT,
     member_icon TEXT,
     star        TEXT,
     create_time TIMESTAMP,
     tittle      TEXT,
     likes       TEXT,
     content     TEXT,
     pictures    TEXT
  );

DROP TABLE IF EXISTS product;

CREATE TABLE product
  (
     id                TEXT,
     brand_id          TEXT,
     serial_number     TEXT,
     brand_name         TEXT,
     category_id       TEXT,
     category_name     TEXT,
     name              TEXT,
     picture           TEXT,
     description       TEXT,
     price             TEXT,
     sale_price        TEXT,
     stock             TEXT,
     description_album TEXT,
     status            TEXT
  );

DROP TABLE IF EXISTS product_category;

CREATE TABLE product_category
  (
     id        TEXT,
     alphabet  TEXT,
     name      TEXT,
     icon      TEXT,
     parent_id TEXT,-- sub category
     level     TEXT
  );

DROP TABLE IF EXISTS product_change_log;

CREATE TABLE product_change_log
  (
     id          TEXT,
     product_id  TEXT,
     price_old   TEXT,
     price_new   TEXT,
     unit_old    TEXT,
     unit_new    TEXT,
     operate_man TEXT,
     create_time TIMESTAMP
  );

----------User related-----------------
DROP TABLE IF EXISTS member;

CREATE TABLE member
  (
     id           TEXT,
     username     TEXT,
     password     TEXT,
     phone_number TEXT,
     status       TEXT,
     create_time  TIMESTAMP,
     last_login   TEXT,
     source_type  TEXT,
     icon         TEXT
  );

DROP TABLE IF EXISTS receive_address;

CREATE TABLE receive_address
  (
     member_id    TEXT,
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
     id         TEXT,
     member_id  TEXT,
     login_time TIMESTAMP,
     ip_address TEXT,
     login_type TEXT -- 0/1/2 pc TEXT, ios TEXT, android
  );

---------Admin related----------------
DROP TABLE IF EXISTS admin;

CREATE TABLE admin
  (
     id          TEXT,
     username    TEXT,
     password    TEXT,
     icon        TEXT,
     email       TEXT,
     name        TEXT,
     create_time TIMESTAMP,
     last_login  TEXT,
     status      TEXT
  );

DROP TABLE IF EXISTS admin_login_log;

CREATE TABLE admin_login_log
  (
     id         TEXT,
     admin_id   TEXT,
     login_time TIMESTAMP,
     ip_address TEXT,
     user_agent TEXT -- type of browser
  );

DROP TABLE IF EXISTS roles;

CREATE TABLE roles
  (
     id          TEXT,
     name        TEXT,
     description TEXT,
     create_time TIMESTAMP,
     status      TEXT
  );

DROP TABLE IF EXISTS admin_role_relation;

CREATE TABLE admin_role_relation
  (
     id       TEXT,
     admin_id TEXT,
     role_id  TEXT
  );
---------Order related-------
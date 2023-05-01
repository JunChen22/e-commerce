--------Product related
DROP TABLE IF EXISTS brand;

CREATE TABLE brand
  (
     id       SERIAL PRIMARY KEY,
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

DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id                bigint PRIMARY KEY NOT NULL,
  brand_id          NUMERIC,
  brand_name        TEXT,
  name              TEXT,
  category_id       NUMERIC,
  category_name TEXT,
  attribute_category_id NUMERIC,	--
  sn  NUMERIC,
  delete_status NUMERIC DEFAULT 0, -- 0-> product not deleted; 1->product deleted
  publish_status NUMERIC DEFAULT 1, -- 0-> product is not published; 1->product is published
  new_status NUMERIC, -- 0->not new product; 1->new product
  recommend_status NUMERIC, -- 0->not recommand; 1->recommand
  verify_status NUMERIC, -- 0->not verified; 1->verified
  sub_title TEXT,
  picture           TEXT,
  description       TEXT,
  original_price  NUMERIC,
  on_sale_status NUMERIC,  --  0-> not on sale; 1-> is on sale
  sale_price        NUMERIC,
  stock             NUMERIC,
  low_stock NUMERIC, -- low stock alert
  unit TEXT,
  weight decimal(10,2), -- product weight in grams
  promotion_start_time DATE,
  promotion_end_time DATE,
  promotion_per_limit NUMERIC,
  promotion_type NUMERIC, -- 0->not on sale; 1-> on sale; 2-> membership discount; 3->flash sale;
  keywords TEXT,
  description_album TEXT,
  album_pics TEXT,  -- album link sepearted by comma
  detail_title TEXT,
  detail_desc text,
  note TEXT
  --variant           NUMERIC
);


DROP TABLE IF EXISTS product_attribute_category;

CREATE TABLE product_attribute_category
  (
     id        SERIAL PRIMARY KEY,
     name TEXT,
     attribute_amount           NUMERIC
  );


DROP TABLE IF EXISTS product_attribute_type;

CREATE TABLE product_attribute_type
  (
     id        SERIAL PRIMARY KEY,
     attribute_category_id NUMERIC,
     name           TEXT
  );


DROP TABLE IF EXISTS product_attribute;

CREATE TABLE product_attribute
  (
     id SERIAL PRIMARY KEY,
     product_id NUMERIC,
     attribute_type_id NUMERIC,
     attribute_value TEXT,
     attribute_unit TEXT
  );

DROP TABLE IF EXISTS comment;

CREATE TABLE comment
  (
     id          SERIAL PRIMARY KEY,
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
     id          SERIAL PRIMARY KEY,
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
     id           SERIAL PRIMARY KEY,
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
  (  id         SERIAL PRIMARY KEY,
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
     id         SERIAL PRIMARY KEY,
     member_id  NUMERIC,
     login_time TIMESTAMP,
     ip_address TEXT,
     login_type TEXT -- 0/1/2 pc TEXT, ios TEXT, android
  );

---------Admin related----------------
DROP TABLE IF EXISTS admin;

CREATE TABLE admin
  (
     id          SERIAL PRIMARY KEY,
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
     id         SERIAL PRIMARY KEY,
     admin_id   NUMERIC,
     login_time TIMESTAMP,
     ip_address TEXT,
     user_agent TEXT -- type of browser
  );

DROP TABLE IF EXISTS roles;

CREATE TABLE roles
  (
     id          SERIAL PRIMARY KEY,
     name        TEXT,
     description TEXT,
     create_time TIMESTAMP,
     status      TEXT
  );

DROP TABLE IF EXISTS permission;

CREATE TABLE permission (
    id      SERIAL PRIMARY KEY,
    parent_id NUMERIC,-- sub permission
    name    TEXT,
    value   TEXT,
    create_time TIMESTAMP,
    status  TEXT
);

DROP TABLE IF EXISTS role_permission_relation;

CREATE TABLE role_permission_relation
  (
     id       SERIAL PRIMARY KEY,
     role_id NUMERIC,
     permission_id  NUMERIC
   );

DROP TABLE IF EXISTS admin_role_relation;

CREATE TABLE admin_role_relation
  (
     id       SERIAL PRIMARY KEY,
     admin_id NUMERIC,
     role_id  NUMERIC
  );


/*

one for order admin
one for usre admin
one for postting stuff
one for all admin stuff
want to see their history
 */
---------Order related-------

















---------------- product
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (1, 'Gucci', 'G', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (2, 'Apple', 'A', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (3, 'Samsung', 'S', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (4, 'Sony', 'S', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (5, 'Lenovo', 'L', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (6, 'Logitech', 'L', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (7, 'OnePlus', 'O', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (8, 'Nike', 'N', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (9, 'Adidas', 'A', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (10, 'Hanes', 'H', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (11, 'Cengage Learning', 'C', '', 'active');
INSERT INTO brand(id, name, alphabet, logo, status) VALUES (12, 'Arthur A. Levine Books', 'A', ' new logo', 'active');


INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (1, 'Fashion', 1, '', 0, 1);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (2,  'Books, Movies and Music', 1, '', 0, 1);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (3,  'Electronics', 1, '', 0, 1);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (4,  'Home & Garden', 1, '', 0, 1);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (5, 'Sporting Goods', 1, '', 0, 1);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (6, 'Health and Beauty', 1, '', 0, 1);
---
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (7, 'men clothing', 3, '', 1, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (8, 'men shoes', 3, '', 1, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (9, 'women shoes', 3, '', 1, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (10, 'women clothing', 3, '', 1, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (11, 'women accessories', 3, '', 1, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (12, 'DVDs',3, '', 2, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (13, 'Books',3, '', 2, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (14, 'Instrument',3, '', 2, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (15, 'cellphones',3, '', 3, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (16, 'computers',3, '', 3, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (17, 'video games and consoles',3, '', 3, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (18, 'vehicle Electronics',3, '', 3, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (19, 'power tools',3, '', 4, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (20, 'outdoor',3, '', 4, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (21, 'kitchen',3, '', 4, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (22, 'outdoor sports',3, '', 5, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (23, 'team sports',3, '', 5, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (24, 'fitness',3, '', 5, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (25, 'vitamins',3, '', 6, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (26, 'skin care',3, '', 6, 2);
INSERT INTO product_category(id, name, product_count, icon, parent_id, level) VALUES (27, 'health care products',3, '', 6, 2);

-- to differentiate what kind
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(1, 'phone', 5);
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(2, 'shoes', 3);
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(3, 'book', 3);
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(4, 'tshirt', 2);


INSERT INTO product(id, brand_id, category_id, attribute_category_id, brand_name, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (1, 2, 15, 1, 'apple', 'Iphone-10', ' ', 'phone desc' , 1000, 999, 22, '', 'smart phone');
INSERT INTO product(id, brand_id, category_id, attribute_category_id, brand_name, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (2, 3,  15, 1, 'samsung','note 10', ' ', 'phone desc' , 1000, 999, 17, '', 'smart phone');
INSERT INTO product(id, brand_id, category_id, attribute_category_id, brand_name, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (3, 7,  15, 1, 'oneplus', 'oneplus 8p', ' ', 'phone desc' , 499, 480, 15, '', 'smart phone');

INSERT INTO product(id, brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (4, 8,  8, 'Air jordon', ' ', 'shoes desc' , 120, 115, 20, '');
INSERT INTO product(id, brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (5, 9,  8, 'Ultraboost 20 Sneaker', ' ', 'shoes desc' , 110, 99, 20, '');

INSERT INTO product(id, brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (6, 8, 7,  't-shirt', ' ', 'clothing desc' , 23, 20, 20, '');
INSERT INTO product(id, brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (7, 9,  7, 't-shirt', ' ', 'clothing desc' , 16, 12, 20, '');
INSERT INTO product(id, brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (8, 10,  7, 'hawaii', ' ', 'clothing desc' , 20, 15, 20, '');

INSERT INTO product(id, brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (9, 11,  13,  'Calculus: Early Transcendentals 8th Edition', ' ', 'book desc' , 26, 20, 5, '', 'book');
INSERT INTO product(id, brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (10, 12,  13, 'Harry Potter book 2', '', 'book desc' , 20, 18, 20, '', 'book');

-- electronics
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (1, 1, 'storage capacity');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (2, 1, 'screen size');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (3, 1, 'screen resolution');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (4, 1, 'batter capacity');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (5, 1, 'processor');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (6, 1, 'color');

--- shoes
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (7, 2, 'style');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (8, 2, 'shoes size');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (9, 2, 'color');

--- book
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (10, 3, 'ISBN');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (11, 3, 'length');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (12, 3, 'language');

--- cloths
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (13, 4, 'size');
INSERT INTO product_attribute_type (id, attribute_category_id, name) VALUES (14, 4, 'color');




INSERT INTO product_attribute (id, product_id, attribute_type_id, attribute_value, attribute_unit) VALUES(1, 1, 1, '128,256,512', 'GB');
INSERT INTO product_attribute (id, product_id, attribute_type_id, attribute_value, attribute_unit) VALUES(2, 1, 2, '6','inches');
INSERT INTO product_attribute (id, product_id, attribute_type_id, attribute_value, attribute_unit) VALUES(3, 1, 3, '2500x1600', 'pixels');
INSERT INTO product_attribute (id, product_id, attribute_type_id, attribute_value, attribute_unit) VALUES(4, 1, 4, '2500', 'mAhs');
INSERT INTO product_attribute (id, product_id, attribute_type_id, attribute_value, attribute_unit) VALUES(5, 1, 5, 'A12', 'chip');
INSERT INTO product_attribute (id, product_id, attribute_type_id, attribute_value, attribute_unit) VALUES(6, 1, 6, 'Gold,Black,Gray','color');

INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(7, 2,1, '128,256,512', 'GB');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(8, 2,2, '7','inches');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(9, 2,3, '2500x1600', 'pixels');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(10, 2,4, '3500', 'mAhs');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(11, 2,5, 'Snapdragon 850', 'chip');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(12, 2,6, 'Black','color');

INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(13, 3,1, '128,256,512', 'GB');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(14, 3,2, '5.5','inches');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(15, 3,3, '1920x1200', 'pixels');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(16, 3,4, '2800', 'mAhs');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(17, 3,5, 'Snapdragon 835', 'chip');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(18, 3,6 ,'Black,White','color');

INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(19,4,7,'basketball','style');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(20,4,8,'7,7.5,8,8.5,9,9.5,10','inches');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(21,4,9,'Black,White','color');

INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(22,5,7,'running','style');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(23,5,8,'7,7.5,8,8.5,9,9.5,10','inches');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(24,5,9,'Black','color');

INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(25, 6,13,'M/L/XL/XXL','size');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(26, 6,14,'Black,Blue,White','color');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(27, 7, 13,'M/L/XL/XXL','size');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(28, 7,14,'Blue,White','color');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(29, 8, 13,'M/L/XL/XXL','size');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(30, 8, 14,'Black,White','color');

INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(31,9,10,'1285741552','ISBN');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(32,9,11,'1379','pages');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(33,9, 12,'english','language');

INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(34, 10,10,'0545791324', 'ISBN');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(35, 10,11,'272', 'pages');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(36, 10,12,'english','language');


INSERT INTO comment(id, product_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (1,4, 'user2', '', '3.5','2020-03-18 22:18:40', 'size smaller than expected', 1,'size was smaller than expected','');
INSERT INTO comment(id, product_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (2, 4 ,'test1', '','1', '2020-03-18 16:18:25','item arrive late', 1,'late','');
INSERT INTO comment(id, product_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (3,1,'user2','',5,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO comment(id, product_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (4,2,'user2','',5,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO comment(id, product_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (5,3,'user1','',1,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO comment(id, product_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (6,5,'test1','',1,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO comment(id, product_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (7,6,'test1','',5,'2020-03-18 16:18:25','good',1,'item is good','');


-- data manipulation will be change by service later
INSERT INTO product_change_log(id, product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (1,4,120,99,20,20,'jun','2020-03-18 16:18:25');
UPDATE product SET original_price = 99 WHERE id = 4;
INSERT INTO product_change_log(id, product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (2,2,499,299,15,15,'jun','2020-03-18 16:18:25');
UPDATE product SET original_price = 299 WHERE id = 2;
INSERT INTO product_change_log(id, product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (3,1,1000,899,22,22,'jun','2020-03-18 16:18:25');
UPDATE product SET original_price = 999 WHERE id = 1;
INSERT INTO product_change_log(id, product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (4,1,899,899,22,20,'jun','2020-03-18 16:18:25');
UPDATE product SET stock = 20 WHERE id = 1;


---------------User  all password is password
INSERT INTO member(id, username, password, phone_number, status, create_time,icon, last_login)
            VALUES (1,'user1','$2a$10$PHcLPlJod/fKyjMUsGuSVeVnI0.EKudDleRT9vM9jqCJzL9QvC5Ju', '212-212-2222','active','2020-03-18 22:18:40','','2020-03-18 22:20:24');
INSERT INTO member(id, username, password, phone_number, status, create_time,icon, last_login)
            VALUES (2,'user2','$2a$10$pSHd2ngUssBZYRlHQQaKu.rb0me5ZAgld0fVASB50vrMslLb8md0a', '877-393-4448', 'active','2020-03-19 14:02:32','','2020-03-19 22:18:40');
INSERT INTO member(id, username, password, phone_number, status, create_time,icon, last_login)
            VALUES (3, 'test1', '$2a$10$xEbGJ1QHr/CZ.ltRIP4A9.K27Sq3HJ4Dh/sN0ssd5GwkaPbjPRW9S','112-323-1111', 'active', '2020-03-18 04:20:52','','2020-03-20 05:01:02');

INSERT INTO receive_address(id, member_id, phone_number, street, city, state, zip_code, note) VALUES (1, 1,'212-212-2222', '1 1st street 2nd ave', 'Chicago','Illinois','60007','');
INSERT INTO receive_address(id, member_id, phone_number, street, city, state, zip_code, note) VALUES (2, 1, '111-111-1111', '2 2nd street 3rd ave Apt 4F', 'Dallas','Texas', '75001' ,'please call, door bell broken');
INSERT INTO receive_address(id, member_id, phone_number, street, city, state, zip_code, note) VALUES (3, 2,'212-212-2222', '3 4st street 5nd ave', 'San Francisco','California','94016','');
INSERT INTO receive_address(id, member_id, phone_number, street, city, state, zip_code, note) VALUES (4, 3,'212-212-2222', '5 6st street 7nd ave', 'Miami','Florida','33101','');

--- login type ,pc/andriod/IOS   = 0/1/2
INSERT INTO member_login_log(id, member_id, login_time, ip_address, login_type) VALUES (1,1,'2020-03-18 22:18:40','127.0.0.1','0');
INSERT INTO member_login_log(id, member_id, login_time, ip_address, login_type) VALUES (2,1,'2020-03-18 22:20:24', '127.0.0.1','0');
INSERT INTO member_login_log(id, member_id, login_time, ip_address, login_type) VALUES (3, 2, '2020-03-19 14:02:32', '127.0.0.1','1');
INSERT INTO member_login_log(id, member_id, login_time, ip_address, login_type) VALUES (4, 2, '2020-03-19 22:18:40', '127.0.0.1','1');
INSERT INTO member_login_log(id, member_id, login_time, ip_address, login_type) VALUES (5, 3, '2020-03-18 04:20:52', '127.0.0.1','0');
INSERT INTO member_login_log(id, member_id, login_time, ip_address, login_type) VALUES (6, 3,'2020-03-20 05:01:02', '127.0.0.1','2');


--------------Admin

-- username : adminacct  password: adminpass
INSERT INTO admin(id, username, password, email, name, create_time, status) VALUES (1, 'adminacct', '$2a$10$c.FVHJ7x9Gedv.StYqdOB.FB1dNVCLBxS76ZbLutbTHwL15hcFGh2', 'admin@gmail.com', 'jun', '2020-03-18 22:18:40', 'active');
-- username : devacct   password: devpass
INSERT INTO admin(id, username, password, email, name, create_time, status) VALUES (12, 'devacct', '$2a$10$zykJppm18avEb79CGEtFjOIwKlgUJ4BeMFiF8HGjccVMgJ8XTjZpy', 'dev@gmail.com', 'dev', '2020-03-20 12:06:40', 'active');

INSERT INTO roles(id, name, description, create_time, status) VALUES (1, 'ROLE_admin', 'root', '2020-03-18 22:18:40', 'active');
INSERT INTO roles(id, name, description, create_time, status) VALUES (2, 'ROLE_admin-user', 'manage user related issue', '2020-03-21 12:35:20', 'active');
INSERT INTO roles(id, name, description, create_time, status) VALUES (3, 'ROLE_admin-order', 'manage order issues', '2020-03-23 09:42:22', 'active');


INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent) VALUES ('1', '1', '2018-12-23 14:27:00', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('2', '1', '2019-04-07 16:04:39', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('3', '1', '2019-04-08 21:47:52', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('4', '1', '2019-04-08 21:48:18', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('5', '1', '2019-04-18 22:18:40', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('6', '12', '2019-04-20 12:45:16', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('7', '12', '2019-05-19 14:52:12', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('8', '1', '2019-05-25 15:00:17', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('9', '12', '2019-06-19 20:11:42', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('10', '12', '2019-06-30 10:33:48', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('11', '1', '2019-06-30 10:34:31', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('12', '1', '2019-06-30 10:35:34', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('13', '1', '2019-07-27 17:11:01', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('14', '1', '2019-07-27 17:13:18', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('15', '1', '2019-07-27 17:15:35', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('16', '1', '2019-07-27 17:17:11', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('17', '1', '2019-07-27 17:18:34', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('18', '1', '2019-07-27 21:21:52', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('19', '12', '2019-07-27 21:34:29', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('20', '12', '2019-07-27 21:35:17', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('21', '1', '2019-07-27 21:35:48', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('22', '1', '2019-07-27 21:40:33', '0:0:0:0:0:0:0:1', null);
INSERT INTO admin_login_log(id, admin_id, login_time, ip_address, user_agent)  VALUES ('23', '12', '2019-08-18 16:00:38', '0:0:0:0:0:0:0:1', null);


INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('1', '0', 'product', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('2', '0', 'order', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('3', '0', 'user', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('4', '0', 'sales', null, '2019-08-18 16:00:38', 'active');

INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('5', '1', 'retrieve product', 'product:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('6', '1', 'create product', 'product:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('7', '1', 'update product', 'product:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('8', '1', 'delete product', 'product:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('9', '1', 'retrieve brand', 'brand:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('10', '1', 'create brand', 'brand:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('11', '1', 'update brand', 'brand:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('12', '1', 'delete brand', 'brand:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('13', '1', 'retrieve product_category', 'product_category:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('14', '1', 'create product_category', 'product_category:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('15', '1', 'update product_category', 'product_category:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('16', '1', 'delete product_category', 'product_category:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('17', '1', 'retrieve product_attribute', 'product_attribute:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('18', '1', 'create product_attribute', 'product_attribute:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('19', '1', 'update product_attribute', 'product_attribute:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission(id, parent_id, name, value, create_time, status)  VALUES ('20', '1', 'delete product_attribute', 'product_attribute:delete', '2019-08-18 16:00:38', 'active');

-- need one for order

INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('1', '1', '1');

INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('2', '1', '5');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('3', '1', '6');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('4', '1', '7');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('5', '1', '8');

INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('6', '1', '9');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('7', '1', '10');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('8', '1', '11');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('9', '1', '12');

INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('10', '1', '13');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('11', '1', '14');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('12', '1', '15');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('13', '1', '16');

INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('14', '1', '17');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('15', '1', '18');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('16', '1', '19');
INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('17', '1', '20');

INSERT INTO role_permission_relation(id, role_id, permission_id)  VALUES ('18', '3', '2');


INSERT INTO admin_role_relation(id, admin_id, role_id) VALUES (1, 1, 1);
INSERT INTO admin_role_relation(id, admin_id, role_id) VALUES (2, 12, 3);








--------------------------------------------
-------- OMS - Order management system -----
--  order, shopping cart, address, return --
--------------------------------------------

DROP TABLE IF EXISTS cart_item;
CREATE TABLE cart_item (
  id bigint NOT NULL,
  product_id bigint,
  product_sku_id bigint,
  member_id bigint,
  quantity integer,
  price numeric(10,2),
  product_pic varchar(1000),
  product_name varchar(500),
  product_sub_title varchar(500),           -- selling points,
  product_sku_code varchar(200),
  create_date timestamp,
  modify_date timestamp,
  delete_status integer DEFAULT 0,
  product_category_id bigint,
  product_brand varchar(200),
  product_sn varchar(200),
  product_attr varchar(500)
);

INSERT INTO cart_item (id, product_id, product_sku_id, member_id, quantity, price, product_pic, product_name, product_sub_title, product_sku_code, create_date, modify_date, delete_status, product_category_id, product_brand, product_sn, product_attr) VALUES

(1, 1001, 10001, 123, 2, 10.99, 'https://example.com/product1.jpg', 'Product 1', 'Amazing product 1', 'ABC123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 101, 'Brand A', 'SN-1001', 'Size: M, Color: Red'),
(2, 1001, 10002, 123, 1, 9.99, 'https://example.com/product1.jpg', 'Product 1', 'Amazing product 1', 'ABC124', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 101, 'Brand A', 'SN-1001', 'Size: L, Color: Blue'),
(3, 1002, 10003, 456, 3, 5.99, 'https://example.com/product2.jpg', 'Product 2', 'Fantastic product 2', 'DEF123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 102, 'Brand B', 'SN-1002', 'Size: S, Color: Green'),
(4, 1003, 10004, 789, 1, 19.99, 'https://example.com/product3.jpg', 'Product 3', 'Incredible product 3', 'GHI123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 103, 'Brand C', 'SN-1003', 'Size: XL, Color: Black'),
(5, 1003, 10005, 789, 2, 18.99, 'https://example.com/product3.jpg', 'Product 3', 'Incredible product 3', 'GHI124', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 103, 'Brand C', 'SN-1003', 'Size: XXL, Color: White'),
(6, 1004, 10006, 111, 1, 15.99, 'https://example.com/product4.jpg', 'Product 4', 'Awesome product 4', 'JKL123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 104, 'Brand D', 'SN-1004', 'Size: M, Color: Grey');




DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon (
  id bigint NOT NULL,
  type integer NULL DEFAULT NULL,           -- discount on 0-> all, 1 -> specific brand, 2-> specific item
  name varchar(100),
  amount numeric(10,2) NULL DEFAULT NULL,   -- amount discounted
  start_time timestamp NULL DEFAULT NULL,
  end_time timestamp NULL DEFAULT NULL,
  note varchar(200) NULL DEFAULT NULL,
  count integer NULL DEFAULT NULL,          -- number of this coupon
  publish_count integer NULL DEFAULT NULL,  -- number of send/publish coupons to users
  used_count integer NULL DEFAULT NULL,      -- number of used coupons
  code varchar(64) NULL DEFAULT NULL
);

INSERT INTO coupon(id, type, name, amount, start_time, end_time, count, publish_count, used_count, code) VALUES (
11, 0, '$15 off whole order',15.00, '2019-08-18 16:00:3', '2023-08-18 16:00:3', 20, 10 , 0, '15OFF');

INSERT INTO coupon(id, type, name, amount, start_time, end_time, count, publish_count, used_count, code) VALUES (
22, 1, '$50 off Apple product', 50.00, '2019-08-18 16:00:3', '2023-08-18 16:00:3', 1, 1 , 0, '50OFF');

INSERT INTO coupon(id, type, name, amount, start_time, end_time, count, publish_count, used_count, code) VALUES (
33, 0, 'All free', 999999.99, '2019-08-18 16:00:3', '2023-08-18 16:00:3', 1, 1 , 1, 'FREE');


DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
   id bigint NOT NULL,
   member_id BIGINT NOT NULL,
   coupon_id BIGINT,
   order_sn VARCHAR(64),
   create_time TIMESTAMP,
   member_email VARCHAR(64),
   total_amount NUMERIC(10,2),
   pay_amount NUMERIC(10,2),
   shipping_cost NUMERIC(10,2),
   promotion_amount NUMERIC(10,2),
   coupon_amount NUMERIC(10,2),
   discount_amount NUMERIC(10,2),
   pay_type INTEGER,              -- not paid -> 0, paypal -> 1, google pay ->
   source_type INTEGER,           -- pc -> 0 , mobile -> 1
   status INTEGER,                -- waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5
   delivery_company VARCHAR(64),
   delivery_tracking_number VARCHAR(64),
   promotion_info VARCHAR(100),           -- buy one get one free, buy x amount get y % discount, free shipping, etc
   invoice_content VARCHAR(200),
   invoice_receiver_phone VARCHAR(32),
   invoice_receiver_email VARCHAR(64),
   receiver_name VARCHAR(100) NOT NULL,
   receiver_phone VARCHAR(32) NOT NULL,
   receiver_state VARCHAR(32),
   receiver_city VARCHAR(32),
   receiver_zip_code VARCHAR(32),
   receiver_detail_address VARCHAR(200),
   note VARCHAR(500),
   confirm_status INTEGER,
   delete_status INTEGER NOT NULL DEFAULT 0,
   payment_time TIMESTAMP,
   delivery_time TIMESTAMP,
   receive_time TIMESTAMP,
   comment_time TIMESTAMP,
   modify_time TIMESTAMP
);


INSERT INTO orders (id, member_id, coupon_id, order_sn, create_time, member_email, total_amount, pay_amount, shipping_cost, promotion_amount, coupon_amount, discount_amount, pay_type, source_type, status, delivery_company, delivery_tracking_number, promotion_info, invoice_content, invoice_receiver_phone, invoice_receiver_email, receiver_name, receiver_phone, receiver_state, receiver_city, receiver_zip_code, receiver_detail_address, note, confirm_status, delete_status, payment_time, delivery_time, receive_time, comment_time, modify_time)
VALUES
(1, 1001, null, '20230425-1001', '2023-04-25 08:30:00', 'john@example.com', 150.50, 150.50, 0.00, 0.00, 0.00, 0.00, 1, 0, 0, 'UPS', '1234567890', 'Free shipping on orders over $100', 'T-shirt, socks, shoes', '123-456-7890', 'jane@example.com', 'Jane Doe', '555-555-5555', 'California', 'San Francisco', '12345', '123 Main St', 'This order is a gift', 1, 0, '2023-04-25 08:30:00', '2023-04-26 09:30:00', '2023-04-28 12:30:00', '2023-04-29 10:30:00', '2023-04-30 11:30:00'),

(2, 102, NULL, 'ORDER-987654', '2023-04-24 09:12:34', 'janedoe@example.com', 50.00, 50.00, 0.00, 0.00, 0.00, 0.00, 0, 1, 3, 'USPS', '9876543210', 'free shipping', 'Product B', '555-999-8888', 'janedoe@example.com', 'Jane Doe', '555-123-4567', 'CA', 'San Francisco', '94102', '456 Market St', NULL, 1, 0, '2023-04-24 09:15:00', '2023-04-25 14:00:00', '2023-04-28 09:00:00', '2023-04-30 10:00:00', '2023-04-30 11:00:00'),

(5, 1234567, NULL, 'ORD-00005', '2022-01-07 12:30:00', 'jane_doe@example.com', 78.50, 78.50, 0.00, 0.00, 0.00, 0.00, 1, 0, 3, 'DHL', '123456789', 'Free shipping on orders over $50', 'Product invoice', '555-123-4567', 'jane_doe@example.com', 'Jane Doe', '555-123-4567', 'New York', 'New York City', '10001', '123 Main St, Apt 4B', 'Please deliver to front desk', 1, 0, '2022-01-08 08:30:00', '2022-01-09 10:45:00', '2022-01-12 14:15:00', NULL, '2022-01-12 14:15:00'),

(6, 7654321, 123, 'ORD-00006', '2022-01-11 09:45:00', 'john_smith@example.com', 110.00, 98.00, 12.00, 0.00, 5.00, 7.00, 1, 1, 2, 'USPS', '987654321', 'Buy $100 get $10 off', 'Tax invoice', '555-987-6543', 'john_smith@example.com', 'John Smith', '555-987-6543', 'California', 'Los Angeles', '90001', '456 Oak St, Apt 12C', NULL, 1, 0, '2022-01-12 11:15:00', '2022-01-13 16:30:00', NULL, NULL, '2022-01-13 16:30:00');









DROP TABLE IF EXISTS order_item;
CREATE TABLE order_item (
	id BIGINT NOT NULL,
	order_id BIGINT DEFAULT NULL,
	order_sn VARCHAR(64) DEFAULT NULL,
	product_id BIGINT DEFAULT NULL,
	product_pic VARCHAR(500) DEFAULT NULL,
	product_name VARCHAR(200) DEFAULT NULL,
	product_brand VARCHAR(200) DEFAULT NULL,
	product_sn VARCHAR(64) DEFAULT NULL,
	product_price NUMERIC(10,2) DEFAULT NULL,
	product_quantity INTEGER DEFAULT NULL,
	product_sku_id BIGINT DEFAULT NULL,
	product_sku_code VARCHAR(50) DEFAULT NULL,
	product_category_id BIGINT DEFAULT NULL,
	promotion_name VARCHAR(200) DEFAULT NULL,
	promotion_amount NUMERIC(10,2) DEFAULT NULL,
	coupon_amount NUMERIC(10,2) DEFAULT NULL,
	real_amount NUMERIC(10,2) DEFAULT NULL,
	product_attr VARCHAR(500) DEFAULT NULL
);

INSERT INTO
  order_item (id,order_id,order_sn,product_id,product_pic,product_name,product_brand,product_sn,product_price,product_quantity,product_sku_id,product_sku_code,product_category_id,promotion_name,promotion_amount,coupon_amount,real_amount,product_attr)
VALUES
  (1,1001,'ORDER-1001',101,'https://example.com/products/101.jpg','Product 101','Brand A','PSN-101',19.99,2,1001,'SKU-1001',10,'20% OFF',4.00,2.00,27.98,'{"Color": "Red", "Size": "M"}'),
  (2,1001,'ORDER-1001',102,'https://example.com/products/102.jpg','Product 102','Brand B','PSN-102',29.99,1,1002,'SKU-1002',10,'50% OFF',15.00,0.00,14.99,'{"Color": "Blue", "Size": "L"}'),
  (3,1002,'ORDER-1002',103,'https://example.com/products/103.jpg','Product 103','Brand C','PSN-103',9.99,3,1003,'SKU-1003',10,NULL,0.00,0.00,29.97,'{"Color": "Black", "Size": "S"}'),
  (4,1002,'ORDER-1002',104,'https://example.com/products/104.jpg','Product 104','Brand D','PSN-104',49.99,2,1004,'SKU-1004',12,'15% OFF',7.50,0.00,92.48,'{"Color": "Green", "Size": "M"}'),
  (5,1003,'ORDER-1003',105,'https://example.com/products/105.jpg','Product 105','Brand E','PSN-105',99.99,1,1005,'SKU-1005',11,'10% OFF',10.00,5.00,89.99,'{"Color": "White", "Size": "XL"}');



DROP TABLE IF EXISTS company_address;               -- your(owner) company/warehouses, where product shipping from.
CREATE TABLE company_address (
  id BIGINT NOT NULL,
  address_name VARCHAR(200) NULL DEFAULT NULL,
  send_status INTEGER NULL DEFAULT NULL,            -- does this location send out product. no -> 0 . yes -> 1
  receive_status INTEGER NULL DEFAULT NULL,         -- does this location receive return item(return center) no -> 0 . yes -> 1
  receiver_name VARCHAR(64) NULL DEFAULT NULL,
  receiver_phone VARCHAR(64) NULL DEFAULT NULL,
  state VARCHAR(64) NULL DEFAULT NULL,
  city VARCHAR(64) NULL DEFAULT NULL,
  zip_code VARCHAR(64) NULL DEFAULT NULL,
  detail_address VARCHAR(200) NULL DEFAULT NULL
);


INSERT INTO company_address(id, address_name, send_status, receive_status, receiver_name ,  receiver_phone , state, city, zip_code, detail_address) VALUES
(1, '111 over there send out avenue 2nd floor', 1, 0, 'Jun' , 1800000000, 'New York', 'New York', 11220, '222 over there avenue 2nd floor, go through the gate in north east corner to unload');

INSERT INTO company_address(id, address_name, send_status, receive_status, receiver_name ,  receiver_phone , state, city, zip_code, detail_address) VALUES
(2, '222 right here return avenue', 0, 1, 'Jun' , 1800000000, 'Nevada', 'Las Vegas', 88901, 'Next to the casino');

INSERT INTO company_address(id, address_name, send_status, receive_status, receiver_name ,  receiver_phone , state, city, zip_code, detail_address) VALUES
(3, '333 backup warehouse avenue', 1, 1, 'Jun' , 1800000000, 'Pennsylvania', 'Philadelphia', 19019, 'Big red sign turn left and ring bell to enter');




---------- OMS - return orders  --------------



DROP TABLE IF EXISTS order_return_reason;
CREATE TABLE order_return_reason (
  id BIGINT NOT NULL,
  order_id BIGINT NOT NULL,
  reason VARCHAR(100) ,             -- pre-set reasons,      new return(buyer remorse), malfunction(DOA), and other
  description VARCHAR(100),         -- detail return reason
  status INT ,                      -- not active 0 , active - 1.
  create_time TIMESTAMP
);

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (1, 1001, 'new return', 'Changed my mind about the purchase', 1, '2022-02-01 10:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (2, 1002, 'malfunction', 'Item was dead on arrival', 1, '2022-02-02 12:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (3, 1003, 'other', 'Received wrong item', 1, '2022-02-03 15:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (4, 1001, 'new return', 'Size didn''t fit', 0, '2022-02-04 14:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (5, 1002, 'malfunction', 'Item stopped working after 3 days', 1, '2022-02-05 09:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (6, 1004, 'new return', 'Changed my mind about the color', 1, '2022-02-06 11:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (7, 1003, 'other', 'Item arrived with missing parts', 0, '2022-02-07 16:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (8, 1002, 'new return', 'Ordered wrong item by mistake', 1, '2022-02-08 10:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (9, 1004, 'malfunction', 'Item has scratches and dents', 1, '2022-02-09 13:00:00');

INSERT INTO order_return_reason (id, order_id, reason, description, status, create_time)
VALUES (10, 1001, 'other', 'Received duplicate order', 1, '2022-02-10 15:00:00');



DROP TABLE IF EXISTS order_return_apply;
CREATE TABLE order_return_apply  (
  id bigint NOT NULL,
  order_id bigint ,
  company_address_id bigint ,                   -- return to you(owner), return center or warehouse
  product_id bigint  ,
  order_sn varchar(64) ,
  create_time timestamp,
  member_username varchar(64) ,
  return_amount decimal(10, 2)  ,
  return_name varchar(100) ,
  return_phone varchar(100) ,
  status int NULL DEFAULT NULL ,                -- return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3
  handle_time timestamp,                        -- how long did this return took
  product_pic varchar(500) ,
  product_name varchar(200) ,
  product_brand varchar(200) ,
  product_attr varchar(500) ,
  product_count int,
  product_price decimal(10, 2) ,
  product_real_price decimal(10, 2) ,
  reason varchar(200) ,
  description varchar(500) ,
  proof_pics varchar(1000) ,
  handle_note varchar(500) ,
  handle_operator varchar(100) ,                -- who processed this return
  receive_operator varchar(100) ,               -- who received the return item
  receive_time timestamp,
  receive_note varchar(500)
);

INSERT INTO order_return_apply (id, order_id, company_address_id, product_id, order_sn, create_time, member_username, return_amount, return_name, return_phone, status, handle_time, product_pic, product_name, product_brand, product_attr, product_count, product_price, product_real_price, reason, description, proof_pics, handle_note, handle_operator, receive_operator, receive_time, receive_note)
VALUES

(1, 1001, 2001, 3001, 'ORD-001', '2023-04-01 10:00:00', 'JohnDoe', 50.00, 'John Doe', '555-123-4567', 0, '2023-04-03 10:00:00', 'https://example.com/product1.jpg', 'Product 1', 'Brand 1', 'Color: Red, Size: L', 1, 100.00, 90.00, 'Wrong size', 'Received size L, ordered size M', 'https://example.com/proof1.jpg, https://example.com/proof2.jpg', 'Handled successfully', 'JaneSmith', 'JohnDoe', '2023-04-04 10:00:00', 'Received item in good condition'),

(2, 1002, 2002, 3002, 'ORD-002', '2023-04-02 14:00:00', 'JaneSmith', 75.00, 'Jane Smith', '555-987-6543', 1, NULL, 'https://example.com/product2.jpg', 'Product 2', 'Brand 2', 'Color: Blue, Size: M', 2, 50.00, 45.00, 'Defective product', 'Product arrived damaged', 'https://example.com/proof3.jpg', 'Awaiting handling', NULL, NULL, NULL, NULL),

(3, 1003, 2003, 3003, 'ORD-003', '2023-04-03 09:30:00', 'BobJohnson', 25.00, 'Bob Johnson', '555-555-1212', 0, '2023-04-05 09:30:00', 'https://example.com/product3.jpg', 'Product 3', 'Brand 3', 'Color: Green, Size: XL', 1, 75.00, 70.00, 'Wrong item', 'Received wrong product', 'https://example.com/proof4.jpg', 'Item rejected', 'MikeBrown', NULL, NULL, NULL),

(4, 1004, 2001, 3004, 'ORD-004', '2023-04-04 12:00:00', 'SarahLee', 20.00, 'Sarah Lee', '555-555-5555', 0, NULL, 'https://example.com/product4.jpg', 'Product 4', 'Brand 4', 'Color: Black, Size: S', 1, 30.00, 25.00, 'Changed mind', 'No longer want the product', NULL, 'Awaiting handling', NULL, NULL, NULL, NULL),

(5, 1005, 2002, 3005, 'ORD-005', '2023-04-07 15:30:00', 'MikeBrown', 60.00, 'Mike Brown', '555-123-7890', 2, '2023-04-08 10:00:00', 'https://example.com/product5.jpg', 'Product 5', 'Brand 5', 'Color: White, Size: L', 1, 80.00, 75.00, 'Not as described', 'Product did not match description', 'https://example.com/proof5.jpg', 'Handled successfully', 'JaneSmith', 'MikeBrown', '2023-04-08 10:00:00', 'Refund received');


DROP TABLE IF EXISTS order_change_history;
CREATE TABLE order_operate_history (
  id bigint NOT NULL,
  order_id bigint NULL DEFAULT NULL ,
  change_operator varchar(100) ,                    -- who changed the order,  0-> user   1-> admin/dev  2-> system,automatically
  create_time timestamp NULL DEFAULT NULL ,
  order_status int NULL DEFAULT NULL ,              -- waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5
  note varchar(500) NULL DEFAULT NULL
);

INSERT INTO order_operate_history (id, order_id, change_operator, create_time, order_status, note) VALUES
(1, 1001, '0', '2022-01-01 10:00:00', 0, 'Order created'),
(2, 1001, '2', '2022-01-01 10:02:00', 0, 'Order auto-cancelled due to payment timeout'),
(3, 1002, '0', '2022-01-02 12:00:00', 0, 'Order created'),
(4, 1002, '1', '2022-01-03 09:30:00', 1, 'Order started fulfillment'),
(5, 1001, '0', '2022-01-05 15:00:00', 0, 'Order re-created'),
(6, 1001, '0', '2022-01-05 15:01:00', 1, 'Order started fulfillment'),
(7, 1002, '1', '2022-01-05 16:00:00', 2, 'Order sent for delivery'),
(8, 1001, '0', '2022-01-08 09:00:00', 3, 'Order received'),
(9, 1002, '0', '2022-01-10 10:00:00', 3, 'Order received'),
(10, 1001, '1', '2022-01-12 14:00:00', 4, 'Order closed due to return period expiry'),
(11, 1002, '2', '2022-01-13 11:00:00', 5, 'Order marked as invalid due to product recall');


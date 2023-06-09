--------Product related
DROP TABLE IF EXISTS brand;
CREATE TABLE brand
  (
     id SERIAL PRIMARY KEY,
     name     TEXT,
     alphabet TEXT,
     status   TEXT,
     logo     TEXT
  );

DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category
  (
     id SERIAL PRIMARY KEY,
     name      TEXT,
     product_count NUMERIC ,
     icon      TEXT,
     parent_id NUMERIC,-- sub category
     level     NUMERIC
  );

DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id SERIAL PRIMARY KEY,
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
  original_price  decimal(10, 2),
  on_sale_status NUMERIC,  --  0-> not on sale; 1-> is on sale; 2-> flash sale/special sales/clarance/used item
  sale_price        decimal(10, 2),
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
     id SERIAL PRIMARY KEY,
     name TEXT,
     attribute_amount           NUMERIC
  );


DROP TABLE IF EXISTS product_attribute_type;

CREATE TABLE product_attribute_type
  (
     id SERIAL PRIMARY KEY,
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

DROP TABLE IF EXISTS review;

CREATE TABLE review
  (
     id SERIAL PRIMARY KEY,
     product_id  NUMERIC,
     member_id NUMERIC,
     member_name TEXT,
     member_icon TEXT,
     star        NUMERIC,
     create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_time TIMESTAMP DEFAULT NULL,
     tittle      TEXT,
     likes       NUMERIC,
     content     TEXT,
     pictures    TEXT
  );

DROP TABLE IF EXISTS product_change_log;

CREATE TABLE product_change_log
  (
     id SERIAL PRIMARY KEY,
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
     id SERIAL PRIMARY KEY,
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
  (  id SERIAL PRIMARY KEY,
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
     id SERIAL PRIMARY KEY,
     member_id  NUMERIC,
     login_time TIMESTAMP,
     ip_address TEXT,
     login_type TEXT -- 0/1/2 pc TEXT, ios TEXT, android
  );

---------Admin related----------------
DROP TABLE IF EXISTS admin;

CREATE TABLE admin
  (
     id SERIAL PRIMARY KEY,
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
	id SERIAL PRIMARY KEY,
	admin_id    NUMERIC,
	login_date  DATE,
	login_time  VARCHAR(50),
	ip_address  VARCHAR(20),
	user_agent  INT
 );

DROP TABLE IF EXISTS roles;

CREATE TABLE roles
  (
     id SERIAL PRIMARY KEY,
     name        TEXT,
     description TEXT,
     create_time TIMESTAMP,
     status      TEXT
  );

DROP TABLE IF EXISTS permission;

CREATE TABLE permission (
    id SERIAL PRIMARY KEY,
    parent_id NUMERIC,-- sub permission
    name    TEXT,
    value   TEXT,
    create_time TIMESTAMP,
    status  TEXT
);

DROP TABLE IF EXISTS role_permission_relation;

CREATE TABLE role_permission_relation
  (
     id SERIAL PRIMARY KEY,
     role_id NUMERIC,
     permission_id  NUMERIC
   );

DROP TABLE IF EXISTS admin_role_relation;

CREATE TABLE admin_role_relation
  (
     id SERIAL PRIMARY KEY,
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
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Gucci', 'G', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Apple', 'A', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Samsung', 'S', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Sony', 'S', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Lenovo', 'L', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Logitech', 'L', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('OnePlus', 'O', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Nike', 'N', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Adidas', 'A', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Hanes', 'H', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Cengage Learning', 'C', '', 'active');
INSERT INTO brand(name, alphabet, logo, status) VALUES ('Arthur A. Levine Books', 'A', ' new logo', 'active');


INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Fashion', 1, '', 0, 1);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Books, Movies and Music', 1, '', 0, 1);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Electronics', 1, '', 0, 1);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Home & Garden', 1, '', 0, 1);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Sporting Goods', 1, '', 0, 1);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Health and Beauty', 1, '', 0, 1);
---
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('men clothing', 3, '', 1, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('men shoes', 3, '', 1, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('women shoes', 3, '', 1, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('women clothing', 3, '', 1, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('women accessories', 3, '', 1, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('DVDs',3, '', 2, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Books',3, '', 2, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('Instrument',3, '', 2, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('cellphones',3, '', 3, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('computers',3, '', 3, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('video games and consoles',3, '', 3, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('vehicle Electronics',3, '', 3, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('power tools',3, '', 4, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('outdoor',3, '', 4, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('kitchen',3, '', 4, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('outdoor sports',3, '', 5, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('team sports',3, '', 5, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('fitness',3, '', 5, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('vitamins',3, '', 6, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('skin care',3, '', 6, 2);
INSERT INTO product_category(name, product_count, icon, parent_id, level) VALUES ('health care products',3, '', 6, 2);

-- to differentiate what kind
INSERT INTO product_attribute_category (name, attribute_amount) VALUES ('phone', 5);
INSERT INTO product_attribute_category (name, attribute_amount) VALUES ('shoes', 3);
INSERT INTO product_attribute_category (name, attribute_amount) VALUES ('book', 3);
INSERT INTO product_attribute_category (name, attribute_amount) VALUES ('tshirt', 2);

INSERT INTO product(brand_id, category_id, attribute_category_id, brand_name, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (2, 15, 1, 'apple', 'Iphone-10', ' ', 'phone desc' , 1000, 999, 22, '', 'smart phone');
INSERT INTO product(brand_id, category_id, attribute_category_id, brand_name, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (3,  15, 1, 'samsung','note 10', ' ', 'phone desc' , 1000, 999, 17, '', 'smart phone');
INSERT INTO product(brand_id, category_id, attribute_category_id, brand_name, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (7,  15, 1, 'oneplus', 'oneplus 8p', ' ', 'phone desc' , 499, 480, 15, '', 'smart phone');

INSERT INTO product(brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (8,  8, 'Air jordon', ' ', 'shoes desc' , 120, 115, 20, '');
INSERT INTO product(brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (9,  8, 'Ultraboost 20 Sneaker', ' ', 'shoes desc' , 110, 99, 20, '');

INSERT INTO product(brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (8, 7,  't-shirt', ' ', 'clothing desc' , 23, 20, 20, '');
INSERT INTO product(brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (9,  7, 't-shirt', ' ', 'clothing desc' , 16, 12, 20, '');
INSERT INTO product(brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album)
            VALUES (10,  7, 'hawaii', ' ', 'clothing desc' , 20, 15, 20, '');

INSERT INTO product(brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (11,  13,  'Calculus: Early Transcendentals 8th Edition', ' ', 'book desc' , 26, 20, 5, '', 'book');
INSERT INTO product(brand_id, category_id, name, picture, description, original_price, sale_price, stock, description_album, keywords)
            VALUES (12,  13, 'Harry Potter book 2', '', 'book desc' , 20, 18, 20, '', 'book');

-- electronics
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (1, 'storage capacity');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (1, 'screen size');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (1, 'screen resolution');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (1, 'batter capacity');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (1, 'processor');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (1, 'color');

--- shoes
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (2, 'style');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (2, 'shoes size');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (2, 'color');

--- book
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (3, 'ISBN');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (3, 'length');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (3, 'language');

--- cloths
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (4, 'size');
INSERT INTO product_attribute_type (attribute_category_id, name) VALUES (4, 'color');


INSERT INTO product_attribute (product_id, attribute_type_id, attribute_value, attribute_unit) VALUES (1, 1, '128,256,512', 'GB');
INSERT INTO product_attribute (product_id, attribute_type_id, attribute_value, attribute_unit) VALUES (1, 2, '6','inches');
INSERT INTO product_attribute (product_id, attribute_type_id, attribute_value, attribute_unit) VALUES (1, 3, '2500x1600', 'pixels');
INSERT INTO product_attribute (product_id, attribute_type_id, attribute_value, attribute_unit) VALUES (1, 4, '2500', 'mAhs');
INSERT INTO product_attribute (product_id, attribute_type_id, attribute_value, attribute_unit) VALUES (1, 5, 'A12', 'chip');
INSERT INTO product_attribute (product_id, attribute_type_id, attribute_value, attribute_unit) VALUES (1, 6, 'Gold,Black,Gray','color');

INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (2, 1, '128,256,512', 'GB');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (2, 2, '7','inches');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (2, 3, '2500x1600', 'pixels');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (2, 4, '3500', 'mAhs');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (2, 5, 'Snapdragon 850', 'chip');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (2, 6, 'Black','color');

INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (3, 1, '128,256,512', 'GB');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (3, 2, '5.5','inches');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (3, 3, '1920x1200', 'pixels');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (3, 4, '2800', 'mAhs');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (3, 5, 'Snapdragon 835', 'chip');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (3, 6 ,'Black,White','color');

INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (4, 7,'basketball','style');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (4, 8,'7,7.5,8,8.5,9,9.5,10','inches');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (4, 9,'Black,White','color');

INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (5, 7,'running','style');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (5, 8,'7,7.5,8,8.5,9,9.5,10','inches');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (5, 9,'Black','color');

INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (6, 13,'M/L/XL/XXL','size');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (6, 14,'Black,Blue,White','color');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (7, 13,'M/L/XL/XXL','size');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (7, 14,'Blue,White','color');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (8, 13,'M/L/XL/XXL','size');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (8, 14,'Black,White','color');

INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (9, 10,'1285741552','ISBN');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (9, 11,'1379','pages');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES (9, 12,'english','language');

INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(10, 10,'0545791324', 'ISBN');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(10, 11,'272', 'pages');
INSERT INTO product_attribute (product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(10, 12,'english','language');

INSERT INTO review (product_id, member_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (4, 1, 'user2', '', '3.5','2020-03-18 22:18:40', 'size smaller than expected', 1,'size was smaller than expected','');
INSERT INTO review (product_id, member_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (4, 1, 'test1', '','1', '2020-03-18 16:18:25','item arrive late', 1,'late','');
INSERT INTO review (product_id, member_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (1, 2, 'user2','',5,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO review (product_id, member_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (2, 3, 'user2','',5,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO review (product_id, member_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (3, 3, 'user1','',1,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO review (product_id, member_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (5, 4, 'test1','',1,'2020-03-18 16:18:25','good',1,'item is good','');
INSERT INTO review (product_id, member_id, member_name, member_icon,star, create_time, tittle, likes, content, pictures) VALUES (6, 4, 'test1','',5,'2020-03-18 16:18:25','good',1,'item is good','');


-- data manipulation will be change by service later
INSERT INTO product_change_log (product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (4,120,99,20,20,'jun','2020-03-18 16:18:25');
INSERT INTO product_change_log (product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (2,499,299,15,15,'jun','2020-03-18 16:18:25');
INSERT INTO product_change_log (product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (1,1000,899,22,22,'jun','2020-03-18 16:18:25');
INSERT INTO product_change_log (product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (1,899,899,22,20,'jun','2020-03-18 16:18:25');

-------------------------- UMS

---------------User  all password is password
INSERT INTO member (username, password, phone_number, status, create_time,icon, last_login)
            VALUES ('user1','$2a$10$PHcLPlJod/fKyjMUsGuSVeVnI0.EKudDleRT9vM9jqCJzL9QvC5Ju', '212-212-2222','active','2020-03-18 22:18:40','','2020-03-18 22:20:24');
INSERT INTO member (username, password, phone_number, status, create_time,icon, last_login)
            VALUES ('user2','$2a$10$pSHd2ngUssBZYRlHQQaKu.rb0me5ZAgld0fVASB50vrMslLb8md0a', '877-393-4448', 'active','2020-03-19 14:02:32','','2020-03-19 22:18:40');
INSERT INTO member (username, password, phone_number, status, create_time,icon, last_login)
            VALUES ('test1', '$2a$10$xEbGJ1QHr/CZ.ltRIP4A9.K27Sq3HJ4Dh/sN0ssd5GwkaPbjPRW9S','112-323-1111', 'active', '2020-03-18 04:20:52','','2020-03-20 05:01:02');

INSERT INTO receive_address (member_id, phone_number, street, city, state, zip_code, note) VALUES (1,'212-212-2222', '1 1st street 2nd ave', 'Chicago','Illinois','60007','');
INSERT INTO receive_address (member_id, phone_number, street, city, state, zip_code, note) VALUES (1, '111-111-1111', '2 2nd street 3rd ave Apt 4F', 'Dallas','Texas', '75001' ,'please call, door bell broken');
INSERT INTO receive_address (member_id, phone_number, street, city, state, zip_code, note) VALUES (2,'212-212-2222', '3 4st street 5nd ave', 'San Francisco','California','94016','');
INSERT INTO receive_address (member_id, phone_number, street, city, state, zip_code, note) VALUES (3,'212-212-2222', '5 6st street 7nd ave', 'Miami','Florida','33101','');

--- login type ,pc/andriod/IOS   = 0/1/2
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (1,'2020-03-18 22:18:40','127.0.0.1','0');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (1,'2020-03-18 22:20:24', '127.0.0.1','0');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (2, '2020-03-19 14:02:32', '127.0.0.1','1');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (2, '2020-03-19 22:18:40', '127.0.0.1','1');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (3, '2020-03-18 04:20:52', '127.0.0.1','0');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (3,'2020-03-20 05:01:02', '127.0.0.1','2');


--------------Admin

-- username : adminacct  password: adminpass      first admin have all permission, second is for order and only have order permission
-- and third admin is for user and have all user permission.
INSERT INTO admin(username, password, email, name, create_time, status) VALUES ('adminacct', '$2a$10$c.FVHJ7x9Gedv.StYqdOB.FB1dNVCLBxS76ZbLutbTHwL15hcFGh2', 'admin@gmail.com', 'jun', '2020-03-18 22:18:40', 'active');

INSERT INTO admin(username, password, email, name, create_time, status) VALUES ('adminacctorder', '$2a$10$c.FVHJ7x9Gedv.StYqdOB.FB1dNVCLBxS76ZbLutbTHwL15hcFGh2', 'order@gmail.com', 'jun', '2020-03-18 22:18:40', 'active');

INSERT INTO admin(username, password, email, name, create_time, status) VALUES ('adminacctuser', '$2a$10$c.FVHJ7x9Gedv.StYqdOB.FB1dNVCLBxS76ZbLutbTHwL15hcFGh2', 'user@gmail.com', 'jun', '2020-03-18 22:18:40', 'active');

-- username : devacct   password: devpass
INSERT INTO admin(username, password, email, name, create_time, status) VALUES ('devacct', '$2a$10$zykJppm18avEb79CGEtFjOIwKlgUJ4BeMFiF8HGjccVMgJ8XTjZpy', 'dev@gmail.com', 'dev', '2020-03-20 12:06:40', 'active');

INSERT INTO roles (name, description, create_time, status) VALUES ('ROLE_admin-product', 'manage product issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, create_time, status) VALUES ('ROLE_admin-order', 'manage order issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, create_time, status) VALUES ('ROLE_admin-user', 'manage user related issue', '2020-03-21 12:35:20', 'active');
INSERT INTO roles (name, description, create_time, status) VALUES ('ROLE_admin-sale', 'manage sale issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, create_time, status) VALUES ('ROLE_admin-content', 'manage content issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, create_time, status) VALUES ('ROLE_admin-root', 'root', '2020-03-18 22:18:40', 'active');

-- base permission
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('0', 'product', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('0', 'order', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('0', 'user', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('0', 'sales', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('0', 'content', null, '2019-08-18 16:00:38', 'active');

-- CRUD product
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'create product', 'product:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'read product', 'product:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'update product', 'product:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'delete product', 'product:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'create brand', 'brand:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'read brand', 'brand:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'update brand', 'brand:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'delete brand', 'brand:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'create product_category', 'product_category:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'read product_category', 'product_category:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'update product_category', 'product_category:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'delete product_category', 'product_category:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'create product_attribute', 'product_attribute:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'read product_attribute', 'product_attribute:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'update product_attribute', 'product_attribute:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('1', 'delete product_attribute', 'product_attribute:delete', '2019-08-18 16:00:38', 'active');

-- CRUD Order
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('2', 'create order', 'order:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('2', 'read order', 'order:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('2', 'update order', 'order:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('2', 'delete order', 'order:delete', '2019-08-18 16:00:38', 'active');

-- CRUD user
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('3', 'create user', 'user:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('3', 'read user', 'user:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('3', 'update user', 'user:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('3', 'delete user', 'user:delete', '2019-08-18 16:00:38', 'active');

-- CRUD Sales
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('4', 'create sales', 'sales:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('4', 'read sales', 'sales:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('4', 'update sales', 'sales:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('4', 'delete sales', 'sales:delete', '2019-08-18 16:00:38', 'active');

-- CRUD Content
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('5', 'create content', 'content:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('5', 'read content', 'content:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('5', 'update content', 'content:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, create_time, status) VALUES ('5', 'delete content', 'content:delete', '2019-08-18 16:00:38', 'active');


-- role to permission
-- assign role_admin-order to have order level 0. (permission 1-5 all level 0)
-- and with joins, all order level to have all CRUD permission
-- one role have CRUD to their area
INSERT INTO role_permission_relation (role_id, permission_id)  VALUES ('1', '1'); -- ROLE_admin-product
INSERT INTO role_permission_relation (role_id, permission_id)  VALUES ('2', '2'); -- ROLE_admin-order
INSERT INTO role_permission_relation (role_id, permission_id)  VALUES ('3', '3'); -- ROLE_admin-user
INSERT INTO role_permission_relation (role_id, permission_id)  VALUES ('4', '4'); -- ROLE_admin-sale
INSERT INTO role_permission_relation (role_id, permission_id)  VALUES ('5', '5'); -- ROLE_admin-content

-- main admin have all permission/roles, have a root admin as role
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (1, 1);
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (1, 2);
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (1, 3);
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (1, 4);
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (1, 5);
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (1, 6);

-- order admin responsible for order management
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (2, 2);

-- user admin responsible for user management
INSERT INTO admin_role_relation(admin_id, role_id) VALUES (3, 3);


-- admin have many different roles
-- different roles have different permission

-- user_agent 1 -> pc , 2 -> mobile users
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-06-22', '9:37', '134.163.118.46', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2023-02-10', '16:29', '63.34.62.42', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2023-03-24', '19:37', '135.233.10.69', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-09-12', '1:38', '20.247.202.109', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2023-02-15', '20:00', '36.98.223.124', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (3, '2022-06-23', '6:28', '173.205.10.223', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (3, '2023-04-22', '11:15', '196.204.187.66', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (3, '2022-05-04', '12:59', '71.116.127.75', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (3, '2023-04-29', '10:24', '150.162.71.34', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-07-17', '23:12', '120.114.34.124', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-06-09', '2:29', '217.211.41.124', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-09-06', '17:55', '123.88.59.30', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-11-16', '15:38', '38.151.187.192', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2023-03-14', '19:25', '240.177.24.96', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-10-22', '9:27', '21.229.17.241', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-10-01', '14:26', '10.201.14.67', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-06-23', '0:04', '60.94.22.72', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-12-21', '7:41', '31.173.45.239', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-08-25', '1:44', '93.236.87.97', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2023-03-21', '19:46', '188.250.113.175', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2023-02-26', '13:03', '218.254.5.254', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-11-23', '18:33', '104.148.201.62', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-12-02', '9:31', '78.116.167.232', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (3, '2022-11-22', '6:26', '235.188.63.46', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-06-27', '18:32', '94.211.177.207', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-07-24', '23:45', '165.173.17.183', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2023-02-03', '9:38', '124.116.179.206', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (1, '2022-12-23', '23:22', '128.42.207.29', 1);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (3, '2022-10-22', '20:38', '68.210.228.208', 2);
insert into admin_login_log (admin_id, login_date, login_time, ip_address, user_agent) values (2, '2022-05-29', '21:51', '165.130.166.222', 1);

















--------------------------------------------
-------- OMS - Order management system -----
--  order, shopping cart, address, return --
--------------------------------------------

DROP TABLE IF EXISTS cart_item;
CREATE TABLE cart_item (
  id SERIAL PRIMARY KEY,
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

INSERT INTO cart_item (product_id, product_sku_id, member_id, quantity, price, product_pic, product_name, product_sub_title, product_sku_code, create_date, modify_date, delete_status, product_category_id, product_brand, product_sn, product_attr) VALUES

(1, 01, 1, 2, 10.99, 'https://example.com/product1.jpg', 'Product 1', 'Amazing product 1', 'ABC123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 101, 'Brand A', 'SN-1', 'Size: M, Color: Red'),
(1, 02, 1, 1, 9.99, 'https://example.com/product1.jpg', 'Product 1', 'Amazing product 1', 'ABC124', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 101, 'Brand A', 'SN-1', 'Size: L, Color: Blue'),
(2, 03, 2, 3, 5.99, 'https://example.com/product2.jpg', 'Product 2', 'Fantastic product 2', 'DEF123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 102, 'Brand B', 'SN-2', 'Size: S, Color: Green'),
(3, 04, 2, 1, 19.99, 'https://example.com/product3.jpg', 'Product 3', 'Incredible product 3', 'GHI123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 103, 'Brand C', 'SN-3', 'Size: XL, Color: Black'),
(3, 05, 2, 2, 18.99, 'https://example.com/product3.jpg', 'Product 3', 'Incredible product 3', 'GHI124', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 103, 'Brand C', 'SN-3', 'Size: XXL, Color: White'),
(4, 06, 3, 1, 15.99, 'https://example.com/product4.jpg', 'Product 4', 'Awesome product 4', 'JKL123', '2023-04-25 08:30:00', '2023-04-25 08:30:00', 0, 104, 'Brand D', 'SN-4', 'Size: M, Color: Grey');






DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon (
  id SERIAL PRIMARY KEY,
  type integer NULL DEFAULT NULL,           -- discount on 0-> all, 1 -> specific brand, 2-> specific item
  name varchar(100),
  amount numeric(10,2) NULL DEFAULT NULL,   -- amount discounted
  start_time timestamp NULL DEFAULT NULL,
  end_time timestamp NULL DEFAULT NULL,
  note varchar(200) NULL DEFAULT NULL,
  count integer NULL DEFAULT NULL,          -- number of this coupon
  publish_count integer NULL DEFAULT NULL,  -- number of send/publish coupons to users
  used_count integer NULL DEFAULT NULL,      -- number of used coupons
  code varchar(64) NULL DEFAULT NULL,
  status integer NULL DEFAULT NULL          -- is the coupon active or disable ,  0 -> disable, 1 -> active
);

INSERT INTO coupon(type, name, amount, start_time, end_time, count, publish_count, used_count, code, status)
VALUES (0, '$15 off whole order',15.00, '2019-08-18 16:00:3', '2023-08-18 16:00:3', 20, 10 , 0, '15OFF', 1);

INSERT INTO coupon(type, name, amount, start_time, end_time, count, publish_count, used_count, code, status)
VALUES (1, '$50 off Apple product', 50.00, '2019-08-18 16:00:3', '2023-08-18 16:00:3', 1, 1 , 0, '50OFF', 1);

INSERT INTO coupon(type, name, amount, start_time, end_time, count, publish_count, used_count, code, status)
VALUES (0, 'All free', 999999.99, '2019-08-18 16:00:3', '2023-08-18 16:00:3', 1, 1 , 1, 'FREE', 1);

INSERT INTO coupon(type, name, amount, start_time, end_time, count, publish_count, used_count, code, status)
VALUES (0, 'not working coupon', 999999.99, '2019-08-18 16:00:3', '2023-08-18 16:00:3', 1, 1 , 0, 'FREE', 0);


DROP TABLE IF EXISTS coupon_history;
CREATE TABLE coupon_history (
    id SERIAL PRIMARY KEY,
    coupon_id bigint NOT NULL,
    member_id  bigint NOT NULL,
    order_id  bigint NOT NULL,
    order_sn VARCHAR(64),
    used_time timestamp NULL DEFAULT NULL,
    code varchar(64) NULL DEFAULT NULL
);

INSERT INTO coupon_history (coupon_id, member_id, order_id, order_sn, used_time, code)
VALUES
(1, 1, 1, '20230425-1001', '2023-04-25 08:45:00', '15OFF'),
(2, 2, 2, 'ORDER-987654', '2023-03-25 08:45:00', '15OFF'),
(3, 1, 3, 'ORD-00003', '2023-02-25 08:45:00', '50OFF'),
(1, 3, 4, 'ORD-00004', '2022-01-11 10:00:00', 'FREE');






DROP TABLE IF EXISTS orders;
CREATE TABLE orders (   -- have to called orders instead of order, or else conflict with ORDER BY
   id SERIAL PRIMARY KEY,
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
   note VARCHAR(500),       -- note left by previous admin stating what's happening
   confirm_status INTEGER,
   delete_status INTEGER NOT NULL DEFAULT 0,
   payment_time TIMESTAMP,
   delivery_time TIMESTAMP,
   receive_time TIMESTAMP,
   comment varchar(200),        -- comment left customer like "leave the package under the rug"
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   modify_time TIMESTAMP
);

INSERT INTO orders (member_id, coupon_id, order_sn, create_time, member_email, total_amount, pay_amount, shipping_cost, promotion_amount, coupon_amount, discount_amount, pay_type, source_type, status, delivery_company, delivery_tracking_number, promotion_info, invoice_content, invoice_receiver_phone, invoice_receiver_email, receiver_name, receiver_phone, receiver_state, receiver_city, receiver_zip_code, receiver_detail_address, note, confirm_status, delete_status, payment_time, delivery_time, receive_time, comment, modify_time)
VALUES
(1, 11, '20230425-1001', '2023-04-25 08:30:00', 'john@example.com', 150.50, 150.50, 0.00, 0.00, 0.00, 0.00, 1, 0, 0, 'UPS', '1234567890', 'Free shipping on orders over $100', 'T-shirt, socks, shoes', '123-456-7890', 'jane@example.com', 'Jane Doe', '555-555-5555', 'California', 'San Francisco', '12345', '123 Main St', 'This order is a gift', 1, 0, '2023-04-25 08:30:00', '2023-04-26 09:30:00', '2023-04-28 12:30:00', 'Please include stickers', '2023-04-30 11:30:00'),

(2, 22, 'ORDER-987654', '2023-04-24 09:12:34', 'janedoe@example.com', 50.00, 50.00, 0.00, 0.00, 0.00, 0.00, 0, 1, 3, 'USPS', '9876543210', 'free shipping', 'Product B', '555-999-8888', 'janedoe@example.com', 'Jane Doe', '555-123-4567', 'CA', 'San Francisco', '94102', '456 Market St', NULL, 1, 0, '2023-04-24 09:15:00', '2023-04-25 14:00:00', '2023-04-28 09:00:00', 'no comments', '2023-04-30 11:00:00'),

(1, 33, 'ORD-00005', '2022-01-07 12:30:00', 'jane_doe@example.com', 78.50, 78.50, 0.00, 0.00, 0.00, 0.00, 1, 0, 3, 'DHL', '123456789', 'Free shipping on orders over $50', 'Product invoice', '555-123-4567', 'jane_doe@example.com', 'Jane Doe', '555-123-4567', 'New York', 'New York City', '10001', '123 Main St, Apt 4B', 'Please deliver to front desk', 1, 0, '2022-01-08 08:30:00', '2022-01-09 10:45:00', '2022-01-12 14:15:00', 'I order it with other item, please ship it together', '2022-01-12 14:15:00'),

(3, 11, 'ORD-00006', '2022-01-11 09:45:00', 'john_smith@example.com', 110.00, 98.00, 12.00, 0.00, 5.00, 7.00, 1, 1, 2, 'USPS', '987654321', 'Buy $100 get $10 off', 'Tax invoice', '555-987-6543', 'john_smith@example.com', 'John Smith', '555-987-6543', 'California', 'Los Angeles', '90001', '456 Oak St, Apt 12C', NULL, 1, 0, '2022-01-12 11:15:00', '2022-01-13 16:30:00', NULL, 'Hello', '2022-01-13 16:30:00'),

(3, NULL, 'ORD-00006', '2022-01-11 09:45:00', 'john_smith@example.com', 110.00, 98.00, 12.00, 0.00, 5.00, 7.00, 1, 1, 2, 'USPS', '987654321', 'Buy $100 get $10 off', 'Tax invoice', '555-987-6543', 'john_smith@example.com', 'John Smith', '555-987-6543', 'California', 'Los Angeles', '90001', '456 Oak St, Apt 12C', NULL, 1, 0, '2022-01-12 11:15:00', '2022-01-13 16:30:00', NULL, NULL, '2022-01-13 16:30:00');




DROP TABLE IF EXISTS order_item;
CREATE TABLE order_item (
	id SERIAL PRIMARY KEY,
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
  order_item (order_id, order_sn, product_id, product_pic, product_name, product_brand, product_sn, product_price, product_quantity,product_sku_id,product_sku_code,product_category_id,promotion_name,promotion_amount,coupon_amount,real_amount,product_attr)
VALUES
  (1,'ORDER-1001',101,'https://example.com/products/101.jpg','Product 101','Brand A','PSN-101',19.99,2,1001,'SKU-1001',10,'20% OFF',4.00,2.00,27.98,'{"Color": "Red", "Size": "M"}'),
  (1,'ORDER-1001',102,'https://example.com/products/102.jpg','Product 102','Brand B','PSN-102',29.99,1,1002,'SKU-1002',10,'50% OFF',15.00,0.00,14.99,'{"Color": "Blue", "Size": "L"}'),
  (2,'ORDER-1001',102,'https://example.com/products/102.jpg','Product 102','Brand B','PSN-102',29.99,1,1002,'SKU-1002',10,'50% OFF',15.00,0.00,14.99,'{"Color": "Blue", "Size": "L"}'),
  (3,'ORDER-1002',103,'https://example.com/products/103.jpg','Product 103','Brand C','PSN-103',9.99,3,1003,'SKU-1003',10,NULL,0.00,0.00,29.97,'{"Color": "Black", "Size": "S"}'),
  (4,'ORDER-1002',104,'https://example.com/products/104.jpg','Product 104','Brand D','PSN-104',49.99,2,1004,'SKU-1004',12,'15% OFF',7.50,0.00,92.48,'{"Color": "Green", "Size": "M"}'),
  (5,'ORDER-1003',105,'https://example.com/products/105.jpg','Product 105','Brand E','PSN-105',99.99,1,1005,'SKU-1005',11,'10% OFF',10.00,5.00,89.99,'{"Color": "White", "Size": "XL"}');



DROP TABLE IF EXISTS company_address;               -- your(owner) company/warehouses, where product shipping from.
CREATE TABLE company_address (
  id SERIAL PRIMARY KEY,
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


INSERT INTO company_address(address_name, send_status, receive_status, receiver_name ,  receiver_phone , state, city, zip_code, detail_address) VALUES
('111 over there send out avenue 2nd floor', 1, 0, 'Jun' , 1800000000, 'New York', 'New York', 11220, '222 over there avenue 2nd floor, go through the gate in north east corner to unload');

INSERT INTO company_address(address_name, send_status, receive_status, receiver_name ,  receiver_phone , state, city, zip_code, detail_address) VALUES
('222 right here return avenue', 0, 1, 'Jun' , 1800000000, 'Nevada', 'Las Vegas', 88901, 'Next to the casino');

INSERT INTO company_address(address_name, send_status, receive_status, receiver_name ,  receiver_phone , state, city, zip_code, detail_address) VALUES
('333 backup warehouse avenue', 1, 1, 'Jun' , 1800000000, 'Pennsylvania', 'Philadelphia', 19019, 'Big red sign turn left and ring bell to enter');





---------- OMS - return orders  --------------



DROP TABLE IF EXISTS order_return_reason;
CREATE TABLE order_return_reason (
  id SERIAL PRIMARY KEY,
  order_id BIGINT NOT NULL,
  reason VARCHAR(100) ,             -- pre-set reasons,      new return(buyer remorse), malfunction(DOA), and other
  description VARCHAR(100),         -- detail return reason
  status INT ,                      -- not active 0 , active - 1.
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO order_return_reason (order_id, reason, description, status, created_at)
VALUES (1, 'new return', 'Changed my mind about the purchase', 1, '2022-02-01 10:00:00');

INSERT INTO order_return_reason (order_id, reason, description, status, created_at)
VALUES (2, 'malfunction', 'Item was dead on arrival', 1, '2022-02-02 12:00:00');

INSERT INTO order_return_reason (order_id, reason, description, status, created_at)
VALUES (3, 'other', 'Received wrong item', 1, '2022-02-03 15:00:00');

INSERT INTO order_return_reason (order_id, reason, description, status, created_at)
VALUES (4, 'new return', 'Size didn''t fit', 0, '2022-02-04 14:00:00');

INSERT INTO order_return_reason (order_id, reason, description, status, created_at)
VALUES (5, 'malfunction', 'Item stopped working after 3 days', 1, '2022-02-05 09:00:00');


DROP TABLE IF EXISTS order_return_apply;
CREATE TABLE order_return_apply  (
  id SERIAL PRIMARY KEY,
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

INSERT INTO order_return_apply (order_id, company_address_id, product_id, order_sn, create_time, member_username, return_amount, return_name, return_phone, status, handle_time, product_pic, product_name, product_brand, product_attr, product_count, product_price, product_real_price, reason, description, proof_pics, handle_note, handle_operator, receive_operator, receive_time, receive_note)
VALUES

(1, 2001, 3001, 'ORD-001', '2023-04-01 10:00:00', 'JohnDoe', 50.00, 'John Doe', '555-123-4567', 0, '2023-04-03 10:00:00', 'https://example.com/product1.jpg', 'Product 1', 'Brand 1', 'Color: Red, Size: L', 1, 100.00, 90.00, 'Wrong size', 'Received size L, ordered size M', 'https://example.com/proof1.jpg, https://example.com/proof2.jpg', 'Handled successfully', 'JaneSmith', 'JohnDoe', '2023-04-04 10:00:00', 'Received item in good condition'),

(2, 2002, 3002, 'ORD-002', '2023-04-02 14:00:00', 'JaneSmith', 75.00, 'Jane Smith', '555-987-6543', 1, NULL, 'https://example.com/product2.jpg', 'Product 2', 'Brand 2', 'Color: Blue, Size: M', 2, 50.00, 45.00, 'Defective product', 'Product arrived damaged', 'https://example.com/proof3.jpg', 'Awaiting handling', NULL, NULL, NULL, NULL),

(3, 2003, 3003, 'ORD-003', '2023-04-03 09:30:00', 'BobJohnson', 25.00, 'Bob Johnson', '555-555-1212', 0, '2023-04-05 09:30:00', 'https://example.com/product3.jpg', 'Product 3', 'Brand 3', 'Color: Green, Size: XL', 1, 75.00, 70.00, 'Wrong item', 'Received wrong product', 'https://example.com/proof4.jpg', 'Item rejected', 'MikeBrown', NULL, NULL, NULL),

(4, 2001, 3004, 'ORD-004', '2023-04-04 12:00:00', 'SarahLee', 20.00, 'Sarah Lee', '555-555-5555', 0, NULL, 'https://example.com/product4.jpg', 'Product 4', 'Brand 4', 'Color: Black, Size: S', 1, 30.00, 25.00, 'Changed mind', 'No longer want the product', NULL, 'Awaiting handling', NULL, NULL, NULL, NULL),

(5, 2002, 3005, 'ORD-005', '2023-04-07 15:30:00', 'MikeBrown', 60.00, 'Mike Brown', '555-123-7890', 2, '2023-04-08 10:00:00', 'https://example.com/product5.jpg', 'Product 5', 'Brand 5', 'Color: White, Size: L', 1, 80.00, 75.00, 'Not as described', 'Product did not match description', 'https://example.com/proof5.jpg', 'Handled successfully', 'JaneSmith', 'MikeBrown', '2023-04-08 10:00:00', 'Refund received');


DROP TABLE IF EXISTS order_change_history;
CREATE TABLE order_change_history (
  id SERIAL PRIMARY KEY,
  order_id bigint NULL DEFAULT NULL ,
  change_operator varchar(100) ,                    -- who changed the order,  0-> user   1-> admin/dev  2-> system,automatically
  create_time timestamp NULL DEFAULT NULL ,
  order_status int NULL DEFAULT NULL ,              -- waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5
  note varchar(500) NULL DEFAULT NULL
);

INSERT INTO order_change_history (order_id, change_operator, create_time, order_status, note) VALUES
(1, '0', '2022-01-01 10:00:00', 0, 'Order created'),
(1, '2', '2022-01-01 10:02:00', 0, 'Order auto-cancelled due to payment timeout'),
(2, '0', '2022-01-02 12:00:00', 0, 'Order created'),
(2, '1', '2022-01-03 09:30:00', 1, 'Order started fulfillment'),
(3, '0', '2022-01-05 15:00:00', 0, 'Order re-created'),
(3, '0', '2022-01-05 15:01:00', 1, 'Order started fulfillment'),
(4, '1', '2022-01-05 16:00:00', 2, 'Order sent for delivery'),
(4, '0', '2022-01-08 09:00:00', 3, 'Order received'),
(5, '0', '2022-01-10 10:00:00', 3, 'Order received'),
(5, '1', '2022-01-12 14:00:00', 4, 'Order closed due to return period expiry'),
(1, '2', '2022-01-13 11:00:00', 5, 'Order marked as invalid due to product recall');


























-- CMS
-- Content management system
-- articles(Buying Guide, product comparison, other MISC if you're specialized shop),
-- images(Store as images urls but it will be store somewhere else like Amazon s3) ,
-- and video(as in links(youtube private(unlisted or published in your channel) or public video) or store somewhere)

DROP TABLE IF EXISTS article;
CREATE TABLE article (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  body TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL
);

INSERT INTO article (title, body) VALUES
('Buyer''s guide', 'This article provides a comprehensive guide for buyers.'),
('Product Comparison', 'This article compares different products and their features.'),
('How to Choose the Right Product', 'This article provides tips on how to choose the right product for your needs.');

DROP TABLE IF EXISTS article_QA;
CREATE TABLE article_QA (
    id SERIAL PRIMARY KEY,
    article_id INT NOT NULL,
    question TEXT NOT NULL,
    answer TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NULL
);

INSERT INTO article_QA (article_id, question, answer) VALUES
(1, 'What is a buyer''s guide?', 'A buyer''s guide is a document or article that provides information about a particular product or service to help potential buyers make informed decisions.'),
(1, 'What should I look for in a buyer''s guide?', 'A good buyer''s guide should provide detailed information about the product or service, including its features, benefits, and drawbacks, as well as pricing and purchasing options.'),
(2, 'Which product is the best?', 'It depends on your needs and preferences. This article provides a comparison of different products and their features to help you make an informed decision.'),
(2, 'What are the key features to look for in a product?', 'The key features to look for in a product depend on what you plan to use it for. This article provides a comparison of different products and their features to help you make an informed decision.'),
(3, 'How can I choose the right product?', 'Choosing the right product depends on your needs, preferences, and budget. This article provides tips on how to choose the right product for your needs.');

DROP TABLE IF EXISTS article_image;
CREATE TABLE article_image (
  id SERIAL PRIMARY KEY,
  article_id INT NOT NULL,
  filename VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL
);

INSERT INTO article_image (article_id, filename) VALUES
(1, 'https://i.imgur.com/FSzSViN.png'),
(1, 'buyer_guide_cover.jpg'),
(1, 'buyer_guide_infographic.png'),
(2, 'product_comparison_table.jpg'),
(3, 'choose_right_product_flowchart.png');


DROP TABLE IF EXISTS article_video;
CREATE TABLE article_video (
  id SERIAL PRIMARY KEY,
  article_id INT NOT NULL,
  url VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL
);

INSERT INTO article_video (article_id, url) VALUES
(1, 'https://i.imgur.com/tovhDTo.mp4'),
(2, 'https://youtu.be/dQw4w9WgXcQ');




--------------
---  SMS  ----
--------------

DROP TABLE IF EXISTS promotion_sale;
CREATE TABLE promotion_sale (

);

DROP TABLE IF EXISTS promotion_log;
CREATE TABLE promotion_log (

);






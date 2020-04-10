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

-- electronic , cloths , others
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(1, 'electronic', 5);
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(2, 'shoes', 3);
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(3, 'book', 3);
INSERT INTO product_attribute_category( id, name, attribute_amount) VALUES(4, 'tshirt', 2);

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

INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (1, 2, 13,  'Iphone-10', ' ', 'phone desc' , 1000, 999, 22, '', 'active');
INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (2, 3,  13,  'note 10', ' ', 'phone desc' , 1000, 999, 17, '', 'active');
INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (3, 7,  13,  'oneplus 8p', ' ', 'phone desc' , 499, 480, 15, '', 'active');

INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (4, 8,  8, 'Air jordon', ' ', 'shoes desc' , 120, 115, 20, '', 'active');
INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (5, 9,  8, 'Ultraboost 20 Sneaker', ' ', 'shoes desc' , 110, 99, 20, '', 'active');

INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (6, 8, 7,  't-shrt', ' ', 'clothing desc' , 23, 20, 20, '', 'active');
INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (7, 9,  7, 't-shirt', ' ', 'clothing desc' , 16, 12, 20, '', 'active');
INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (8, 10,  7, 'hawaii', ' ', 'clothing desc' , 20, 15, 20, '', 'active');

INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (9, 11,  13,  'Calculus: Early Transcendentals 8th Edition', ' ', 'book desc' , 26, 20, 5, '', 'active');
INSERT INTO product(id, brand_id, category_id, name, picture, description, price, sale_price, stock, description_album, status)
            VALUES (10, 12,  13, 'Harry Potter book 2', '', 'book desc' , 20, 18, 20, '', 'active');


INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(1, 1, 1, '128,256,512', 'GB');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(2, 1, 2, '6','inches');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(3, 1, 3, '2500x1600', 'pixels');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(4, 1,4, '2500', 'mAhs');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(5, 1,5, 'A12', 'chip');
INSERT INTO product_attribute (id,product_id, attribute_type_id,attribute_value, attribute_unit) VALUES(6, 1,6, 'Gold,Black,Gray','color');

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
UPDATE product SET price = 99 WHERE id = 4;
INSERT INTO product_change_log(id, product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (2,2,499,299,15,15,'jun','2020-03-18 16:18:25');
UPDATE product SET price = 299 WHERE id = 2;
INSERT INTO product_change_log(id, product_id, price_old, price_new, unit_old, unit_new, operate_man, create_time) VALUES (3,1,1000,899,22,22,'jun','2020-03-18 16:18:25');
UPDATE product SET price = 999 WHERE id = 1;
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


INSERT INTO roles(id, name, description, create_time, status) VALUES (1, 'admin', 'root', '2020-03-18 22:18:40', 'active');
INSERT INTO roles(id, name, description, create_time, status) VALUES (2, 'admin-user', 'manage user related issue', '2020-03-21 12:35:20', 'active');
INSERT INTO roles(id, name, description, create_time, status) VALUES (3, 'admin-order', 'manage order issues', '2020-03-23 09:42:22', 'active');


INSERT INTO admin_role_relation(id, admin_id, role_id) VALUES (1, 1, 1);
INSERT INTO admin_role_relation(id, admin_id, role_id) VALUES (2, 12, 3);


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







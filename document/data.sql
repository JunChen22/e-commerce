-------------------
----- PMS ---------
-------------------

DROP TABLE IF EXISTS brand;
CREATE TABLE brand
  (
     id SERIAL PRIMARY KEY,
     name     TEXT,
     alphabet TEXT,
     status   TEXT DEFAULT 'active',
     logo     TEXT
  );

-- phone/computer/electronic brand
INSERT INTO brand(name, alphabet, logo, status) VALUES
('Apple', 'A', 'apple.jpg', 'active'),
('Samsung', 'S', 'samsung.jpg', 'active'),
('Google', 'G', 'google.jpg', 'active'),
('OnePlus', 'O', 'OnePlus.jpg', 'active'),
('Lenovo', 'L', 'lenovo.jpg', 'active'),
('ASUS', 'A', 'asus.jpg', 'active'),
('Acer', 'A', 'acer.jpg', 'active'),
('Alienware', 'A', 'alienware.jpg', 'active'),
('Razer', 'R', 'razer.jpg', 'active'),
('Microsoft', 'M', 'microsoft.jpg', 'active'),
('Dell', 'D', 'dell.jpg', 'active'),
('HP', 'H', 'hp.jpg', 'active'),
('MSI', 'M', 'msi.jpg', 'active');

-- electrics
INSERT INTO brand(name, alphabet, logo, status) VALUES
('Anker', 'A', 'anker.jpg', 'active'),
('Fitbit', 'F', 'fitbit.jpg', 'active'),
('SanDisk', 'S', 'sandisk.jpg', 'active'),
('Tile', 'T', 'tile.jpg', 'active');

-- video and audio
INSERT INTO brand(name, alphabet, logo, status) VALUES
('GoPro', 'G', 'gopro.jpg', 'active'),
('Logitech', 'L', 'logitech.jpg', 'active'),
('JBL', 'J', 'jbl.jpg', 'active'),
('UE', 'U', 'ue.jpg', 'active');

-- clothing brand
INSERT INTO brand(name, alphabet, logo, status) VALUES
('Gucci', 'G', 'gucci.jpg', 'active'),
('Nike', 'N', 'nike.jpg', 'active'),
('Adidas', 'A', 'adidas.jpg', 'active'),
('Gucci', 'G', 'gucci.jpg', 'active'),
('Zara', 'Z', 'zara.jpg', 'active'),
('HM', 'H', 'hm.jpg', 'active'),
('Levis', 'L', 'levis.jpg', 'active'),
('Calvin Klein', 'C', 'calvinklein.jpg', 'active'),
('Versace', 'V', 'versace.jpg', 'active');

-- health and beauty brand
INSERT INTO brand(name, alphabet, logo, status) VALUES
('Nivea', 'N', 'nivea.jpg', 'active'),
('Dove', 'D', 'dove.jpg', 'active'),
('Cetaphil', 'C', 'cetaphil.jpg', 'active'),
('Neutrogena', 'N', 'neutrogena.jpg', 'active'),
('Aveeno', 'A', 'aveeno.jpg', 'active'),
('Olay', 'O', 'olay.jpg', 'active');

-- books
INSERT INTO brand(name, alphabet, logo, status) VALUES
('Penguin Books', 'P', 'penguinbooks.jpg', 'active'),
('HarperCollins', 'H', 'harpercollins.jpg', 'active'),
('Random House', 'R', 'randomhouse.jpg', 'active'),
('Book', 'B', 'book.jpg', 'active');

-- etc
INSERT INTO brand(name, alphabet, logo, status) VALUES
('Coca-Cola', 'C', 'cocacola.jpg', 'active'),
-- kitchen
('Zojirushi', 'Z', 'zojirushi.jpg', 'active'),
('Yeti', 'Y', 'yeti.jpg', 'active');


DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category
  (
     id SERIAL PRIMARY KEY,
     name      TEXT,
     parent_id NUMERIC,-- sub category
     level     NUMERIC
  );


-- main category
INSERT INTO product_category(name, parent_id, level) VALUES
('Fashion', 0, 1),
('Books, movies and music', 0, 1),
('Electronics', 0, 1),
('Home & garden', 0, 1),
('Sporting goods', 0, 1),
('Health and beauty', 0, 1);

--- sub category
INSERT INTO product_category(name, parent_id, level) VALUES
-- Fashion
('Men clothing', 1, 2),
('Men shoes', 1, 2),
('Women shoes', 1, 2),
('Women clothing', 1, 2),
('Women accessories', 1, 2),
-- Books, Movies and Music
('DVDs', 2, 2),
('Books', 2, 2),
('Instrument', 2, 2),
 -- Electronics
('Smartphones', 3, 2),
('Desktop', 3, 2),
('Laptop', 3, 2),
('Video games and consoles', 3, 2),
('Tablets', 3, 2),
('Wearables', 3, 2),
('Headphones', 3, 2),
('Storage', 3, 2),
('Monitors', 3, 2),
-- Home & Garden
('Power tools', 4, 2),
('Outdoor', 4, 2),
('Kitchen', 4, 2),
-- Sporting Goods
('Outdoor sports', 5, 2),
('Team sports', 5, 2),
('Fitness', 5, 2),
 -- Health and Beauty
('Vitamins', 6, 2),
('Skin care', 6, 2),
('Health care products', 6, 2);















DROP TABLE IF EXISTS product_attribute_category;
CREATE TABLE product_attribute_category
  (
     id SERIAL PRIMARY KEY,
     name TEXT,                     -- name of category. For example phone, shoes,
     attribute_amount  NUMERIC      -- number of attribute for this, phone have 6 attribute, storage capacity, screen size, battery capapcity, etc
  );

-- category -> Fashion - >
INSERT INTO product_attribute_category (name, attribute_amount)
VALUES
('Men clothing', 3),
('Men shoes', 3),
('Women shoes', 3),
('Women clothing', 3),
('Women accessories', 3);

-- category -> Books, Movies and Music - >
INSERT INTO product_attribute_category (name, attribute_amount)
VALUES
('DVDs', 1),
('Books', 3),
('Instrument', 2);

-- category -> Electronics - >
INSERT INTO product_attribute_category (name, attribute_amount)
VALUES
('Smartphones', 10),
('Desktop', 8),
('Laptop', 10),
('Video games and consoles', 4),
('Tablets', 10),
('Wearables', 10),
('Headphones', 4),
('Storage', 5),
('Monitors', 7);

-- category -> Home & Garden - >
INSERT INTO product_attribute_category (name, attribute_amount)
VALUES
('Power tools', 2),
('Outdoor', 1),
('Kitchen', 1);

-- category -> Sporting Goods - >
INSERT INTO product_attribute_category (name, attribute_amount)
VALUES
('Outdoor sports', 1),
('Team sports', 1),
('Fitness', 1);


-- category -> Health and Beauty - >
INSERT INTO product_attribute_category (name, attribute_amount)
VALUES
('Vitamins', 1),
('Skin care', 1),
('Health care products', 1);


DROP TABLE IF EXISTS product_attribute_type;
CREATE TABLE product_attribute_type
  (
     id SERIAL PRIMARY KEY,
     attribute_category_id NUMERIC,
     name           TEXT
  );

-- Men clothing
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(1, 'size'),
(1, 'color'),
(1, 'style');

-- Men shoes
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(2, 'size'),
(2, 'color'),
(2, 'style');

-- Women shoes
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(3, 'size'),
(3, 'color'),
(3, 'style');

-- Women clothing
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(4, 'size'),
(4, 'color'),
(4, 'style');

-- Women accessories
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(5, 'size'),
(5, 'color'),
(5, 'style');

-- DVDs
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(6, 'movie type');   -- action, comedy, romance and etc

-- Books
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(7, 'ISBN'),
(7, 'length'),
(7, 'language');

-- Instrument
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(8, 'material'),
(8, 'type');  -- guitar , piano, jazz

-- Smartphones
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(9, 'storage capacity'),
(9, 'camera resolution'),
(9, 'screen size'),
(9, 'ram size'),
(9, 'screen resolution'),
(9, 'battery capacity'),
(9, 'processor'),
(9, 'color'),
(9, 'ports'),
(9, 'year model');

-- Desktop
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(10, 'storage capacity'),
(10, 'ram size'),
(10, 'cooling type'),
(10, 'graphic card'),
(10, 'processor'),
(10, 'case'),
(10, 'ports'),
(10, 'year model');

-- Laptop
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(11, 'storage capacity'),
(11, 'screen size'),
(11, 'ram size'),
(11, 'screen resolution'),
(11, 'battery capacity'),
(11, 'processor'),
(11, 'color'),
(11, 'keyboard language'),
(11, 'ports'),
(11, 'year model');

-- Video games and consoles
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(12, 'game type'),    -- action, horror, FPS, RPG and etc
(12, 'console type'),
(12, 'ports'),
(12, 'year model');

-- Tablets
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(13, 'storage capacity'),
(13, 'camera resolution'),
(13, 'screen size'),
(13, 'ram size'),
(13, 'screen resolution'),
(13, 'battery capacity'),
(13, 'processor'),
(13, 'color'),
(13, 'ports'),
(13, 'year model');

-- Wearables
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(14, 'storage capacity'),
(14, 'camera resolution'),
(14, 'screen size'),
(14, 'ram size'),
(14, 'screen resolution'),
(14, 'battery capacity'),
(14, 'processor'),
(14, 'color'),
(14, 'ports'),
(14, 'year model');

-- Headphones
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(15, 'color'),
(15, 'connection type'),     -- wired, wireless
(15, 'ports'),
(15, 'year model');

-- Storage
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(16, 'storage type'),     -- NVME, SATA , HDD, USB flash drive, or tape
(16, 'connection port'),  -- USB-A, USB-C , m.2, SATA connection and etc
(16, 'storage size'),
(16, 'storage speed'),    -- read/write speed
(16, 'year model');

-- Monitors
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(17, 'screen size'),
(17, 'screen resolution'),
(17, 'screen refresh rate'),
(17, 'color'),
(17, 'speaker'),
(17, 'ports'),
(17, 'year model');

-- Power tools
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(18, 'battery capacity'),
(18, 'power(watts)');

-- Outdoor
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(19, 'dimension L x W x H');

-- Kitchen
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(20, 'dimension L x W x H');

-- Outdoor sports
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(21, 'sport type');

-- Team sports
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(22, 'sport type');

-- Fitness
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(23, 'dimension L x W x H');

-- Vitamins
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(24, 'dimension L x W x H');


-- Skin care
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(25, 'dimension L x W x H');


-- Health care products
INSERT INTO product_attribute_type (attribute_category_id, name)
VALUES
(26, 'dimension L x W x H');













DROP TABLE IF EXISTS product;
CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  brand_id          NUMERIC,
  brand_name        TEXT,
  name              TEXT,
  category_id       NUMERIC,
  category_name TEXT,
  attribute_category_id NUMERIC,	--
  sn  varchar(64),
  new_status NUMERIC, -- 0->not new product; 1->new product
  recommend_status NUMERIC, -- 0->not recommend; 1->recommend
  verify_status NUMERIC, -- 0->not verified; 1->verified
  sub_title TEXT,
  cover_picture           TEXT,           --  preview picture, for like list all, search all picture when getting specific
  picture_album  NUMERIC,           -- collection of pictures
  description       TEXT,
  original_price  decimal(10, 2),
  on_sale_status INTEGER,  --  0-> not on sale; 1-> is on sale; 2-> flash sale/special sales/clarance/used item
  sale_price        decimal(10, 2),     -- TODO: currently using it as lowest price of all sku variants. and using original price as highest, it changes with more sku variants added.
  stock             INTEGER,
  low_stock INTEGER, -- -- low stock alarm, default is about 10% alarm
  unit_sold INTEGER,
  weight decimal(10,2), -- product weight in grams
  keywords TEXT,
  detail_title TEXT,                -- at the bottom of product with detail title, description and picture
  detail_desc TEXT,
  description_album NUMERIC,
  delete_status INTEGER DEFAULT 0, -- 0-> product not deleted; 1->product deleted, record purpose
  publish_status INTEGER DEFAULT 1, -- 0-> product is not published; 1->product is published, to temporary stop sale.
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  note TEXT
);


-- Insert data into the product table
INSERT INTO product (brand_id, brand_name, name, category_id, category_name, attribute_category_id, sn, sub_title, cover_picture, picture_album, description, original_price, on_sale_status, sale_price, stock, low_stock, unit_sold, weight, keywords, detail_title, detail_desc, description_album)
VALUES
-- Apple
(1, 'Apple', 'iPhone 12', 15, 'Smartphones', 9, 'SN-123', 'Powerful and sleek', 'iphone12.jpg', 1, 'The iPhone 12 is the latest flagship smartphone from Apple.', 899.99, 0, 899.99, 100, 10, 50, 150, 'Apple, iPhone, smartphone', 'Product Details', 'Explore the amazing features of the iPhone 12.', 2),
(1, 'Apple', 'iPhone SE', 15, 'Smartphones', 9, 'SN-456', 'Compact and affordable', 'iphoneSE.jpg', 3, 'The iPhone SE packs power and performance into a compact design.', 499.99, 0, 499.99, 50, 5, 30, 120, 'Apple, iPhone, smartphone', 'Product Details', 'Discover the capabilities of the iPhone SE.', 4),
(3, 'Google', 'Pixel 5', 15, 'Smartphones', 9, 'SN-345', 'Capture the perfect shot', 'pixel5.jpg', 5, 'The Pixel 5 features an exceptional camera and advanced AI capabilities.', 799.99, 0, 799.99, 80, 8, 40, 140, 'Google, Pixel, smartphone', 'Product Details', 'Capture stunning photos with the Pixel 5.', 6),
(4, 'OnePlus', 'OnePlus 9 Pro', 15, 'Smartphones', 9, 'SN-789', 'Flagship performance', 'oneplus9Pro.jpg', 7, 'The OnePlus 9 Pro delivers exceptional performance and photography capabilities.', 1099.99, 0, 1099.99, 100, 10, 60, 180, 'OnePlus, smartphone', 'Product Details', 'Experience flagship performance with the OnePlus 9 Pro.', 8),
(2, 'Samsung', 'Galaxy S21', 15, 'Smartphones', 9, 'SN-234', 'Powerful and feature-rich', 'galaxyS21.jpg', 9, 'The Galaxy S21 offers cutting-edge technology and a stunning display.', 1099.99, 0, 1099.99, 150, 15, 70, 170, 'Samsung, Galaxy, smartphone', 'Product Details', 'Experience the brilliance of the Galaxy S21.', 10),

(1, 'Apple', 'AirPods Pro', 21, 'Headphones', 15, 'SN-234', 'Immersive sound, active noise cancellation', 'airPodsPro.jpg', 11, 'The AirPods Pro deliver immersive sound and feature active noise cancellation for an enhanced audio experience.', 249.99, 0, 249.99, 200, 20, 150, 40, 'Apple, AirPods, headphones', 'Product Details', 'Enjoy immersive sound with the AirPods Pro.', 12),
(1, 'Apple', 'AirPods 2', 21, 'Headphones', 15, 'SN-789', 'Immersive audio experience', 'airpods2.jpg', 13, 'The AirPods 2 deliver superior sound quality with active noise cancellation.', 249.99, 0, 249.99, 200, 20, 100, 50, 'Apple, AirPods, headphones', 'Product Details', 'Enjoy immersive audio with the AirPods Pro.', 14),
(4, 'OnePlus', 'OnePlus Buds Pro', 21, 'Headphones', 15, 'SN-012', 'Immersive audio experience', 'oneplusBudsPro.jpg', 15, 'The OnePlus Buds Pro offer immersive sound and advanced noise cancellation.', 149.99, 0, 149.99, 150, 15, 90, 30, 'OnePlus, earbuds, headphones', 'Product Details', 'Enjoy immersive audio with the OnePlus Buds Pro.', 16),

(1, 'Apple', 'iPad Pro', 19, 'Tablets', 13, 'SN-901', 'The ultimate iPad experience', 'iPadPro.jpg', 17, 'The iPad Pro offers the ultimate tablet experience with its powerful performance and stunning display.', 799.99, 0, 799.99, 150, 15, 100, 470, 'Apple, iPad, tablet', 'Product Details', 'Experience the ultimate tablet experience with the iPad Pro.', 18),

(4, 'OnePlus', 'OnePlus Watch', 20, 'Wearables', 14, 'SN-345', 'Stylish and smart', 'oneplusWatch.jpg', 19, 'The OnePlus Watch combines style and smart features for a seamless wearable experience.', 199.99, 0, 199.99, 80, 8, 50, 60, 'OnePlus, smartwatch', 'Product Details', 'Stay connected with the OnePlus Watch.', 20),
(2, 'Samsung', 'Galaxy Watch 3', 20, 'Wearables', 14, 'SN-567', 'Stylish and functional', 'galaxyWatch3.jpg', 21, 'The Galaxy Watch 3 combines style and functionality for a smart wearable experience.', 349.99, 0, 349.99, 100, 10, 50, 90, 'Samsung, Galaxy, smartwatch', 'Product Details', 'Stay connected with the Galaxy Watch 3.', 22),

(2, 'Samsung', 'T5 Portable SSD', 22, 'Storage', 16, 'SN-890', 'Fast and portable storage', 't5PortableSSD.jpg', 23, 'The T5 Portable SSD offers fast and secure storage for your data on the go.', 179.99, 0, 179.99, 250, 25, 120, 200, 'Samsung, SSD, storage', 'Product Details', 'Store and transfer your data with the T5 Portable SSD.', 24),

(1, 'Apple', 'MacBook Pro', 17, 'Laptop', 11, 'SN-678', 'Powerful performance, sleek design', 'macBookPro.jpg', 25, 'The MacBook Pro combines powerful performance with a sleek design, making it the perfect choice for professionals.', 1999.99, 0, 1999.99, 80, 8, 40, 170, 'Apple, MacBook, laptop', 'Product Details', 'Unleash your creativity with the MacBook Pro.', 26),
(11, 'Dell', 'XPS 13', 17, 'Laptop', 11, 'SN-456', 'Compact and powerful', 'xps13.jpg', 27, 'The XPS 13 is a compact and powerful laptop that delivers exceptional performance in a sleek design.', 1399.99, 0, 1399.99, 150, 15, 90, 110, 'Dell, XPS, laptop', 'Product Details', 'Experience power and portability with the XPS 13.', 28),
(5, 'Lenovo', 'ThinkPad X1 Carbon', 17, 'Laptop', 11, 'SN-123', 'Powerful and lightweight', 'thinkpadX1Carbon.jpg', 29, 'The ThinkPad X1 Carbon is a powerful and lightweight laptop designed for professionals.', 1499.99, 0, 1499.99, 200, 20, 100, 120, 'Lenovo, ThinkPad, laptop', 'Product Details', 'Experience the power of the ThinkPad X1 Carbon.', 30),
(5, 'Lenovo', 'Yoga C940', 17, 'Laptop', 11, 'SN-456', 'Versatile and stylish', 'yogaC940.jpg', 31, 'The Yoga C940 is a versatile and stylish 2-in-1 laptop with impressive performance.', 1299.99, 0, 1299.99, 150, 15, 80, 140, 'Lenovo, Yoga, laptop', 'Product Details', 'Unleash your creativity with the Yoga C940.', 32),
(5, 'Lenovo', 'IdeaPad Gaming 3', 17, 'Laptop', 11, 'SN-789', 'Powerful gaming performance', 'ideapadGaming3.jpg', 33, 'The IdeaPad Gaming 3 is a powerful gaming laptop that delivers exceptional performance.', 999.99, 0, 999.99, 100, 10, 50, 180, 'Lenovo, IdeaPad, gaming laptop', 'Product Details', 'Immerse yourself in the world of gaming with the IdeaPad Gaming 3.', 34),
(8, 'Alienware', 'Alienware m15 R5', 17, 'Laptop', 11, 'SN-901', 'Unleash gaming supremacy', 'alienwarem15R5.jpg', 35, 'The Alienware m15 R5 is a gaming laptop that delivers unrivaled gaming performance.', 1999.99, 0, 1999.99, 80, 8, 50, 230, 'Alienware, gaming laptop', 'Product Details', 'Experience gaming supremacy with the Alienware m15 R5.', 36),

(10, 'Microsoft', 'Xbox Series X', 18, 'Video Games and Consoles', 12, 'SN-123', 'Next-generation gaming', 'xboxSeriesX.jpg', 37, 'The Xbox Series X offers next-generation gaming with its powerful performance and immersive gaming experiences.', 499.99, 0, 499.99, 80, 8, 50, 4000, 'Microsoft, Xbox, gaming console', 'Product Details', 'Enter the next generation of gaming with the Xbox Series X.', 38),

(11, 'Dell', 'Dell UltraSharp U2720Q', 23, 'Monitors', 17, 'SN-012', 'Exceptional color accuracy', 'dellUltraSharpU2720Q.jpg', 39, 'The Dell UltraSharp U2720Q is a professional-grade monitor that offers exceptional color accuracy for precise image reproduction.', 599.99, 0, 599.99, 120, 12, 70, 630, 'Dell, UltraSharp, monitor', 'Product Details', 'Experience exceptional color accuracy with the Dell UltraSharp U2720Q.', 40);

-- sneakers/shoes
INSERT INTO product (brand_id, brand_name, name, category_id, category_name, attribute_category_id, sn, sub_title, cover_picture, picture_album, description, original_price, on_sale_status, sale_price, stock, low_stock, unit_sold, weight, keywords, detail_title, detail_desc, description_album)
VALUES
(23, 'Nike', 'Nike Air Max 270', 8, 'Men shoes', 2, 'SN-001', 'Iconic design and comfort', 'nikeAirMax270.jpg', 41, 'Experience iconic design and unmatched comfort with the Nike Air Max 270 sneakers.', 129.99, 0, 129.99, 100, 10, 50, 500, 'Nike, Air Max, sneakers', 'Product Details', 'Step up your style game with the Nike Air Max 270.', 42),
(23, 'Nike', 'Nike ZoomX Vaporfly NEXT', 8, 'Men shoes', 2, 'SN-003', 'Unmatched speed and performance', 'nikeZoomXVaporfly.jpg', 43, 'The Nike ZoomX Vaporfly NEXT% provides unmatched speed and performance for professional runners.', 249.99, 0, 249.99, 80, 8, 30, 350, 'Nike, ZoomX Vaporfly, sneakers', 'Product Details', 'Take your running to the next level with the Nike ZoomX Vaporfly NEXT.', 44),
(24, 'Adidas', 'Adidas Ultra Boost', 8, 'Men shoes', 2, 'SN-004', 'Ultimate comfort and style', 'adidasUltraBoost.jpg', 45, 'Experience ultimate comfort and style with the Adidas Ultra Boost sneakers.', 149.99, 0, 149.99, 150, 15, 60, 450, 'Adidas, Ultra Boost, sneakers', 'Product Details', 'Elevate your sneaker game with the Adidas Ultra Boost.', 46),
(24, 'Adidas', 'Adidas Adilette Slides', 9, 'Women shoes ', 3, 'SN-006', 'Casual and comfortable', 'adidasAdiletteSlides.jpg', 47, 'The Adidas Adilette Slides are casual and comfortable sandals perfect for lounging or post-workout relaxation.', 29.99, 0, 29.99, 200, 20, 120, 150, 'Adidas, Adilette, slides, sandals', 'Product Details', 'Slip into comfort with the Adidas Adilette Slides.', 48);


-- clothings
INSERT INTO product (brand_id, brand_name, name, category_id, category_name, attribute_category_id, sn, sub_title, cover_picture, picture_album, description, original_price, on_sale_status, sale_price, stock, low_stock, unit_sold, weight, keywords, detail_title, detail_desc, description_album)
VALUES
(23, 'Nike', 'Nike Dri-FIT T-Shirt', 7, 'Men clothing', 1, 'SN-002', 'Stay cool and comfortable', 'nikeDriFitShirt.jpg', 49, 'The Nike Dri-FIT T-Shirt keeps you cool and comfortable during your workouts or everyday activities.', 29.99, 0, 29.99, 200, 20, 100, 200, 'Nike, Dri-FIT, t-shirt', 'Product Details', 'Upgrade your wardrobe with the Nike Dri-FIT T-Shirt.', 50),
(29, 'Calvin Klein', 'Calvin Klein Logo T-Shirt', 7, 'Men clothing', 1, 'SN-008', 'Classic and timeless', 'calvinKleinLogoShirt.jpg', 51, 'The Calvin Klein Logo T-Shirt features a classic and timeless design that adds style to any outfit.', 39.99, 0, 39.99, 100, 10, 70, 250, 'Calvin Klein, logo t-shirt, clothing', 'Product Details', 'Make a statement with the Calvin Klein Logo T-Shirt.', 52),
(24, 'Adidas', 'Adidas Essential Track Pants', 7, 'Men clothing', 1, 'SN-005', 'Sporty and versatile', 'adidasTrackPants.jpg', 53, 'The Adidas Essential Track Pants offer a sporty and versatile option for your everyday activities.', 49.99, 0, 49.99, 100, 10, 80, 300, 'Adidas, track pants, clothing', 'Product Details', 'Stay comfortable and stylish with the Adidas Essential Track Pants.', 54);


-- Books
INSERT INTO product (brand_id, brand_name, name, category_id, category_name, attribute_category_id, sn, sub_title, cover_picture, picture_album, description, original_price, on_sale_status, sale_price, stock, low_stock, unit_sold, weight, keywords, detail_title, detail_desc, description_album)
VALUES
(40, 'Books', 'The Great Gatsby', 13, 'Books', 7, 'SN-010', 'A classic tale of wealth and obsession', 'greatGatsby.jpg', 55, 'The Great Gatsby is a classic novel that explores themes of wealth, love, and the American Dream.', 14.99, 0, 14.99, 200, 20, 150, 300, 'The Great Gatsby, novel, literature', 'Product Details', 'Immerse yourself in the world of The Great Gatsby.', 56),
(40, 'Books', 'To Kill a Mockingbird', 13, 'Books', 7, 'SN-011', 'A powerful story of racial injustice and compassion', 'toKillAMockingbird.jpg', 57, 'To Kill a Mockingbird is a powerful novel that addresses themes of racial injustice and the power of compassion.', 12.99, 0, 12.99, 150, 15, 120, 250, 'To Kill a Mockingbird, novel, literature', 'Product Details', 'Experience the impact of To Kill a Mockingbird.', 58),
(40, 'Books', 'Harry Potter and the Sorcerer''s Stone', 13, 'Books', 7, 'SN-012', 'The beginning of a magical journey', 'harryPotterSorcerersStone.jpg', 59, 'Harry Potter and the Sorcerer''s Stone is the first book in the Harry Potter series, introducing readers to the magical world of Hogwarts.', 19.99, 0, 19.99, 100, 10, 200, 400, 'Harry Potter, Sorcerer''s Stone, fantasy, literature', 'Product Details', 'Embark on a magical journey with Harry Potter and the Sorcerer''s Stone.', 60);



-- A product SKU (Stock Keeping Unit) is a unique identifier assigned to a specific product variant to facilitate inventory management, tracking, and sales analysis.
DROP TABLE IF EXISTS product_sku;
CREATE TABLE product_sku (    -- all product have one default sku variant
  id SERIAL PRIMARY KEY,
  product_id INTEGER,
  sku_code TEXT,
  picture TEXT,
  price NUMERIC,
  promotion_price NUMERIC,
  stock INTEGER,
  low_stock INTEGER,     -- low stock alarm, default is about 10% alarm
  lock_stock INTEGER DEFAULT 0, -- lock stock is updated from lock stock + order quantity, can't order when current stock is less than lock stock. update lock stock to 0 after ordered.
  unit_sold INTEGER,
  status INTEGER DEFAULT 1      -- product sku online status , 0 - offline  1 - online ready for purchase
);

INSERT INTO product_sku (product_id, sku_code, picture, price, promotion_price, stock, low_stock, unit_sold)
VALUES
-- iphone
(1, 'IP12-RED', 'iphone12-red.jpg', 899.99 ,  899.99 , 35 , 4 , 20),
(1, 'IP12-WHITE', 'iphone12-white.jpg', 899.99 , 899.99 , 35 , 4 , 20),
(1, 'IP12-BLACK', 'iphone12-black.jpg', 899.99 , 899.99 , 30 , 2 , 10),
(2, 'IPSE-BLUE', 'iphonese-blue.jpg', 499.99 ,  499.99 , 25 ,  3 , 25),
(2, 'IPSE-RED', 'iphonese-red.jpg', 499.99 , 499.99 , 25 , 3 , 5),
(3, 'PX5', 'pixel5.jpg', 799.99 ,  799.99 , 80 ,  8 , 40),
(4, 'OP9P', 'oneplus9pro.jpg', 1099.99 , 1099.99 , 100 , 10 , 60),
(5, 'GS21', 'galaxys21.jpg', 1099.99 , 1099.99 , 150 , 15 , 70),
(6, 'APRO1', 'airpodspro.jpg', 249.99 ,  249.99 , 200 , 20 , 150),
(7, 'APO2', 'airpods2.jpg', 249.99 ,  249.99 , 200 , 20 , 100),
(8, 'OBPRO', 'oneplusbudspro.jpg', 149.99 ,  149.99 , 150 , 15 , 90),
(9, 'IPPRO', 'ipadpro.jpg', 799.99 ,  799.99 , 150 , 15 , 100),
(10, 'OPW3', 'onepluswatch.jpg', 199.99 ,  199.99 , 80 ,  8 , 50),
(11, 'GW3', 'galaxywatch3.jpg', 349.99 ,  349.99 , 100 , 10 , 50),
(12, 'T5SSD', 't5portablessd.jpg', 179.99 ,  179.99 , 250 , 25 , 120),
(13, 'MBP', 'macbookpro.jpg', 1999.99 , 1999.99 , 80 ,  8 , 40),
(14, 'XPS13', 'xps13.jpg', 1399.99 , 1399.99 , 150 , 15 , 90),
(15, 'TPX1C', 'thinkpadx1carbon.jpg', 1499.99 , 1499.99 , 200 , 20 , 100),
(16, 'YC940', 'yogac940.jpg', 1299.99 , 1299.99 , 150 , 15 , 80),
(17, 'IPG3', 'ideapadgaming3.jpg', 999.99 ,  999.99 , 100 , 10 , 50),
(18, 'AM15R5', 'alienwarem15r5.jpg', 1999.99 , 1999.99 , 80 ,  8 , 50),
(19, 'XSX', 'xboxseriesx.jpg', 499.99 ,  499.99 , 80 ,  8 , 50),
(20, 'DUU2720Q', 'dellultrasharp.jpg', 599.99 ,  599.99 , 120 , 12 , 70),
(21, 'NAM270', 'nikeairmax270.jpg', 129.99 ,  129.99 , 100 , 10 , 50),
(22, 'NZVNEXT', 'nikezoomx.jpg', 249.99 ,  249.99 , 80 ,  8 , 30),
(23, 'AUB', 'adidasultraboost.jpg', 149.99 ,  149.99 , 150 , 15 , 60),
(24, 'AAS', 'adidasadilette.jpg', 29.99 ,  29.99 , 200 , 20 , 120),
(25, 'NDFTS', 'nikedrifit.jpg', 29.99 ,  29.99 , 200 , 20 , 100),
(26, 'CKLTS', 'calvinkleintshirt.jpg', 39.99 ,  39.99 , 100 , 10 , 70),
(27, 'AEPTP', 'adidasessentialpants.jpg', 49.99 ,  49.99 , 100 , 10 , 80),
(28, 'TGG', 'thegreatgatsby.jpg', 14.99 ,  14.99 , 200 , 20 , 150),
(29, 'TKAM', 'tokillamockingbird.jpg', 12.99 ,  12.99 , 150 , 15 , 120),
(30, 'HPSS', 'harrypotter.jpg', 19.99 ,  19.99 , 100 , 10 , 200);



DROP TABLE IF EXISTS product_attribute;
CREATE TABLE product_attribute
  (
     id SERIAL PRIMARY KEY,
     sku_code TEXT,
     product_id NUMERIC,
     attribute_type_id NUMERIC,
     attribute_value TEXT,
     attribute_unit TEXT
  );


INSERT INTO product_attribute (product_id, sku_code, attribute_type_id, attribute_value, attribute_unit)
VALUES
-- iPhone 12 and variant(red, white, black)
(1, 'IP12-RED', 22, '128 GB', 'GB'), -- storage capacity
(1, 'IP12-RED', 23, '12 MP', 'MP'), -- camera resolution
(1, 'IP12-RED', 24, '6.1 inches', 'inches'), -- screen size
(1, 'IP12-RED', 25, '4 GB', 'GB'), -- RAM size
(1, 'IP12-RED', 26, '2532 x 1170 pixels', 'pixels'), -- screen resolution
(1, 'IP12-RED', 27, '2815 mAh', 'mAh'), -- battery capacity
(1, 'IP12-RED', 28, 'Apple A14 Bionic', NULL), -- processor
(1, 'IP12-RED', 29, 'Red', NULL), -- color
(1, 'IP12-RED', 30, 'Lightning', NULL), -- ports
(1, 'IP12-RED', 31, '2022', NULL), -- year

(1, 'IP12-WHITE', 22, '128 GB', 'GB'), -- storage capacity
(1, 'IP12-WHITE', 23, '12 MP', 'MP'), -- camera resolution
(1, 'IP12-WHITE', 24, '6.1 inches', 'inches'), -- screen size
(1, 'IP12-WHITE', 25, '4 GB', 'GB'), -- RAM size
(1, 'IP12-WHITE', 26, '2532 x 1170 pixels', 'pixels'), -- screen resolution
(1, 'IP12-WHITE', 27, '2815 mAh', 'mAh'), -- battery capacity
(1, 'IP12-WHITE', 28, 'Apple A14 Bionic', NULL), -- processor
(1, 'IP12-WHITE', 29, 'White', NULL), -- color
(1, 'IP12-WHITE', 30, 'Lightning', NULL), -- ports
(1, 'IP12-WHITE', 31, '2022', NULL), -- year

(1, 'IP12-BLACK', 22, '128 GB', 'GB'), -- storage capacity
(1, 'IP12-BLACK', 23, '12 MP', 'MP'), -- camera resolution
(1, 'IP12-BLACK', 24, '6.1 inches', 'inches'), -- screen size
(1, 'IP12-BLACK', 25, '4 GB', 'GB'), -- RAM size
(1, 'IP12-BLACK', 26, '2532 x 1170 pixels', 'pixels'), -- screen resolution
(1, 'IP12-BLACK', 27, '2815 mAh', 'mAh'), -- battery capacity
(1, 'IP12-BLACK', 28, 'Apple A14 Bionic', NULL), -- processor
(1, 'IP12-BLACK', 29, 'Black', NULL), -- color
(1, 'IP12-BLACK', 30, 'Lightning', NULL), -- ports
(1, 'IP12-BLACK', 31, '2022', NULL), -- year

-- iPhone SE  and variant(blue and red)
(2, 'IPSE-BLUE', 22, '64 GB', 'GB'),
(2, 'IPSE-BLUE', 23, '12 MP', 'MP'),
(2, 'IPSE-BLUE', 24, '4.7 inches', 'inches'),
(2, 'IPSE-BLUE', 25, '3 GB', 'GB'),
(2, 'IPSE-BLUE', 26, '1334 x 750 pixels', 'pixels'),
(2, 'IPSE-BLUE', 27, '1821 mAh', 'mAh'),
(2, 'IPSE-BLUE', 28, 'Apple A13 Bionic', NULL),
(2, 'IPSE-BLUE', 29, 'Blue', NULL),
(2, 'IPSE-BLUE', 30, 'Lightning', NULL),
(2, 'IPSE-BLUE', 31, '2022', NULL), -- year

(2, 'IPSE-RED', 22, '64 GB', 'GB'),
(2, 'IPSE-RED', 23, '12 MP', 'MP'),
(2, 'IPSE-RED', 24, '4.7 inches', 'inches'),
(2, 'IPSE-RED', 25, '3 GB', 'GB'),
(2, 'IPSE-RED', 26, '1334 x 750 pixels', 'pixels'),
(2, 'IPSE-RED', 27, '1821 mAh', 'mAh'),
(2, 'IPSE-RED', 28, 'Apple A13 Bionic', NULL),
(2, 'IPSE-RED', 29, 'Red', NULL),
(2, 'IPSE-RED', 30, 'Lightning', NULL),
(2, 'IPSE-RED', 31, '2022', NULL), -- year

-- Pixel 5
(3, 'PX5', 22, '128 GB', 'GB'),
(3, 'PX5', 23, '12.2 MP', 'MP'),
(3, 'PX5', 24, '6 inches', 'inches'),
(3, 'PX5', 25, '8 GB', 'GB'),
(3, 'PX5', 26, '2340 x 1080 pixels', 'pixels'),
(3, 'PX5', 27, '4080 mAh', 'mAh'),
(3, 'PX5', 28, 'Qualcomm Snapdragon 765G', NULL),
(3, 'PX5', 29, 'Black', NULL),
(3, 'PX5', 30, 'USB-C', NULL),
(3, 'PX5', 31, '2022', NULL), -- year

-- OnePlus 9 Pro
(4, 'OP9P', 22, '256 GB', 'GB'),
(4, 'OP9P', 23, '48 MP', 'MP'),
(4, 'OP9P', 24, '6.7 inches', 'inches'),
(4, 'OP9P', 25, '12 GB', 'GB'),
(4, 'OP9P', 26, '1440 x 3216 pixels', 'pixels'),
(4, 'OP9P', 27, '4500 mAh', 'mAh'),
(4, 'OP9P', 28, 'Qualcomm Snapdragon 888', NULL),
(4, 'OP9P', 29, 'Various colors', NULL),
(4, 'OP9P', 30, 'USB-C', NULL),
(4, 'OP9P', 31, '2022', NULL), -- year

-- Galaxy S21
(5, 'GS21', 22, '128 GB', 'GB'), -- storage capacity
(5, 'GS21', 23, '12 MP', 'MP'), -- camera resolution
(5, 'GS21', 24, '6.2 inches', 'inches'), -- screen size
(5, 'GS21', 25, '8 GB', 'GB'), -- RAM size
(5, 'GS21', 26, '2400 x 1080 pixels', 'pixels'), -- screen resolution
(5, 'GS21', 27, '4000 mAh', 'mAh'), -- battery capacity
(5, 'GS21', 28, 'Samsung Exynos 2100', NULL), -- processor
(5, 'GS21', 29, 'Various colors', NULL), -- color
(5, 'GS21', 30, 'USB-C', NULL), -- ports
(5, 'GS21', 31, '2022', NULL), -- year

-- AirPods Pro
(6, 'APRO1', 74, 'White', NULL), -- color
(6, 'APRO1', 75, 'Wireless', NULL), -- connection type
(6, 'APRO1', 76, 'Lightning', NULL), -- ports
(6, 'APRO1', 77, '2022', NULL), -- year

-- AirPods 2
(7, 'APO2', 74, 'White', NULL),
(7, 'APO2', 75, 'Wireless', NULL),
(7, 'APO2', 76, 'Lightning', NULL),
(7, 'APO2', 77, '2022', NULL), -- year

-- OnePlus Buds Pro
(8, 'OBPRO', 74, 'Black', NULL),
(8, 'OBPRO', 75, 'Wireless', NULL),
(8, 'OBPRO', 76, 'USB-C', NULL),
(8, 'OBPRO', 77, '2022', NULL), -- year

-- ipad pro
(9, 'IPPRO', 54, '256 GB', 'GB'), -- storage capacity
(9, 'IPPRO', 55, '12 MP', 'MP'), -- camera resolution
(9, 'IPPRO', 56, '12.9 inches', 'inches'), -- screen size
(9, 'IPPRO', 57, '16 GB', 'GB'), -- RAM size
(9, 'IPPRO', 58, '2732 x 2048 pixels', 'pixels'), -- screen resolution
(9, 'IPPRO', 59, '10090 mAh', 'mAh'), -- battery capacity
(9, 'IPPRO', 60, 'Apple M1', NULL), -- processor
(9, 'IPPRO', 61, 'Various colors', NULL), -- color
(9, 'IPPRO', 62, 'USB-C', NULL), -- ports
(9, 'IPPRO', 63, '2022', NULL), -- year

-- OnePlus Watch 3
(10, 'OPW3', 64, '4 GB', 'GB'), -- storage capacity
(10, 'OPW3', 65, NULL, NULL), -- camera resolution (not applicable)
(10, 'OPW3', 66, '1.59 inches', 'inches'), -- screen size
(10, 'OPW3', 67, '1 GB', 'GB'), -- RAM size
(10, 'OPW3', 68, '454 x 454 pixels', 'pixels'), -- screen resolution
(10, 'OPW3', 69, '402 mAh', 'mAh'), -- battery capacity
(10, 'OPW3', 70, 'Snapdragon Wear 4100', NULL), -- processor
(10, 'OPW3', 71, 'Various colors', NULL), -- color
(10, 'OPW3', 72, 'Charging dock', NULL), -- ports
(10, 'OPW3', 73, '2022', NULL), -- year

-- Galaxy Watch3
(11, 'GW3', 64, '8 GB', 'GB'), -- storage capacity
(11, 'GW3', 65, NULL, NULL), -- camera resolution (not applicable)
(11, 'GW3', 66, '1.4 inches', 'inches'), -- screen size
(11, 'GW3', 67, '1 GB', 'GB'), -- RAM size
(11, 'GW3', 68, '360 x 360 pixels', 'pixels'), -- screen resolution
(11, 'GW3', 69, '340 mAh', 'mAh'), -- battery capacity
(11, 'GW3', 70, 'Exynos 9110', NULL), -- processor
(11, 'GW3', 71, 'Various colors', NULL), -- color
(11, 'GW3', 72, 'Wireless charging', NULL), -- ports
(11, 'GW3', 73, '2022', NULL), -- year

-- T5 Portable SSD
(12, 'T5SSD', 78, 'SSD', NULL), -- storage type
(12, 'T5SSD', 79, 'USB-C', NULL), -- connection port
(12, 'T5SSD', 80, '1 TB', 'TB'), -- storage size
(12, 'T5SSD', 81, 'Up to 540 MB/s', 'MB/s'), -- storage speed
(12, 'T5SSD', 82, '2022', NULL), -- year

-- MacBook Pro
(13, 'MBP', 40, '512 GB', 'GB'), -- storage capacity
(13, 'MBP', 41, '13.3 inches', 'inches'), -- screen size
(13, 'MBP', 42, '16 GB', 'GB'), -- RAM size
(13, 'MBP', 43, '2560 x 1600 pixels', 'pixels'), -- screen resolution
(13, 'MBP', 44, 'Up to 10 hours', 'hours'), -- battery capacity
(13, 'MBP', 45, 'Intel Core i7', NULL), -- processor
(13, 'MBP', 46, 'Silver', NULL), -- color
(13, 'MBP', 47, 'English', NULL), -- keyboard language
(13, 'MBP', 48, 'USB-C', NULL), -- ports
(13, 'MBP', 49, '2022', NULL), -- year

-- XPS 13
(14, 'XPS13', 40, '1 TB', 'TB'),
(14, 'XPS13', 41, '13.4 inches', 'inches'),
(14, 'XPS13', 42, '16 GB', 'GB'),
(14, 'XPS13', 43, '3840 x 2400 pixels', 'pixels'),
(14, 'XPS13', 44, 'Up to 14 hours', 'hours'),
(14, 'XPS13', 45, 'Intel Core i7', NULL),
(14, 'XPS13', 46, 'Silver', NULL),
(14, 'XPS13', 47, 'English', NULL),
(14, 'XPS13', 48, 'USB-C', NULL),
(14, 'XPS13', 49, '2022', NULL), -- year

-- ThinkPad X1 Carbon
(15, 'TPX1C', 40, '512 GB', 'GB'),
(15, 'TPX1C', 41, '14 inches', 'inches'),
(15, 'TPX1C', 42, '16 GB', 'GB'),
(15, 'TPX1C', 43, '2560 x 1440 pixels', 'pixels'),
(15, 'TPX1C', 44, 'Up to 19.5 hours', 'hours'),
(15, 'TPX1C', 45, 'Intel Core i7', NULL),
(15, 'TPX1C', 46, 'Black', NULL),
(15, 'TPX1C', 47, 'English', NULL),
(15, 'TPX1C', 48, 'HDMI, USB-C', NULL),
(15, 'TPX1C', 49, '2022', NULL), -- year

-- Yoga C940
(16, 'YC940', 40, '1 TB', 'TB'),
(16, 'YC940', 41, '14 inches', 'inches'),
(16, 'YC940', 42, '16 GB', 'GB'),
(16, 'YC940', 43, '3840 x 2160 pixels', 'pixels'),
(16, 'YC940', 44, 'Up to 15 hours', 'hours'),
(16, 'YC940', 45, 'Intel Core i7', NULL),
(16, 'YC940', 46, 'Iron Grey', NULL),
(16, 'YC940', 47, 'English', NULL),
(16, 'YC940', 48, 'USB-C', NULL),
(16, 'YC940', 49, '2022', NULL), -- year

-- IdeaPad Gaming 3
(17, 'IPG3', 40, '512 GB', 'GB'),
(17, 'IPG3', 41, '15.6 inches', 'inches'),
(17, 'IPG3', 42, '8 GB', 'GB'),
(17, 'IPG3', 43, '1920 x 1080 pixels', 'pixels'),
(17, 'IPG3', 44, 'Up to 9 hours', 'hours'),
(17, 'IPG3', 45, 'AMD Ryzen 5', NULL),
(17, 'IPG3', 46, 'Black', NULL),
(17, 'IPG3', 47, 'English', NULL),
(17, 'IPG3', 48, 'HDMI, USB-C', NULL),
(17, 'IPG3', 49, '2022', NULL), -- year

-- Alienware m15 R5
(18, 'AM15R5', 40, '1 TB', 'TB'),
(18, 'AM15R5', 41, '15.6 inches', 'inches'),
(18, 'AM15R5', 42, '16 GB', 'GB'),
(18, 'AM15R5', 43, '3840 x 2160 pixels', 'pixels'),
(18, 'AM15R5', 44, 'Up to 6 hours', 'hours'),
(18, 'AM15R5', 45, 'AMD Ryzen 9', NULL),
(18, 'AM15R5', 46, 'Lunar Light', NULL),
(18, 'AM15R5', 47, 'English', NULL),
(18, 'AM15R5', 48, 'USB-C', NULL),
(18, 'AM15R5', 49, '2022', NULL), -- year

-- Xbox Series X
(19, 'XSX', 50, 'Action, Horror, FPS, RPG', NULL), -- Game type
(19, 'XSX', 51, 'Console', NULL), -- Console type
(19, 'XSX', 52, 'HDMI, USB-A, USB-C, Ethernet', NULL), -- Ports
(19, 'XSX', 53, '2022', NULL), -- year

-- Dell UltraSharp U2720Q
(20, 'DUU2720Q', 83, '27 inches', 'inches'), -- Screen size
(20, 'DUU2720Q', 84, '3840 x 2160 pixels', 'pixels'), -- Screen resolution
(20, 'DUU2720Q', 85, '60 Hz', 'Hz'), -- Screen refresh rate
(20, 'DUU2720Q', 86, '16.7 million colors', NULL), -- Color
(20, 'DUU2720Q', 87, 'No', NULL), -- Speaker
(20, 'DUU2720Q', 88, 'HDMI, DisplayPort, USB-C', NULL), -- Ports
(20, 'DUU2720Q', 89, '2022', NULL), -- year

-- Nike Air Max 270
(21, 'NAM270', 40, '10', NULL), -- Size
(21, 'NAM270', 37, 'Black/White', NULL), -- Color
(21, 'NAM270', 41, 'Athletic', NULL), -- Style

-- Nike ZoomX Vaporfly NEXT
(22, 'NZVNEXT', 4, '9.5', NULL),
(22, 'NZVNEXT', 5, 'Pink/Black', NULL),
(22, 'NZVNEXT', 6, 'Running', NULL),

-- Adidas Ultra Boost
(23, 'AUB', 4, '11', NULL),
(23, 'AUB', 5, 'White', NULL),
(23, 'AUB', 6, 'Athletic', NULL),

-- Adidas Adilette Slides
(24, 'AAS', 7, '8', NULL),
(24, 'AAS', 8, 'Blue', NULL),
(24, 'AAS', 9, 'Slides', NULL),

-- Nike Dri-FIT T-Shirt
(25, 'NDFTS', 1, 'M', NULL),
(25, 'NDFTS', 2, 'Red', NULL),
(25, 'NDFTS', 3, 'Short Sleeve', NULL),

-- Calvin Klein Logo T-Shirt
(26, 'CKLTS', 1, 'L', NULL),
(26, 'CKLTS', 2, 'Black', NULL),
(26, 'CKLTS', 3, 'Short Sleeve', NULL),

-- Adidas Essential Track Pants
(27, 'AEPTP', 1, 'XL', NULL),
(27, 'AEPTP', 2, 'Gray', NULL),
(27, 'AEPTP', 3, 'Track Pants', NULL),

-- The Great Gatsby
(28, 'TGG', 17, '9780743273565', NULL), -- ISBN
(28, 'TGG', 18, '180', 'pages'), -- Length
(28, 'TGG', 19, 'English', NULL), -- Language

-- To Kill a Mockingbird
(29, 'TKAM', 17, '9780060935467', NULL),
(29, 'TKAM', 18, '336', 'pages'),
(29, 'TKAM', 19, 'English', NULL),

-- Harry Potter and the Sorcerer's Stone
(30, 'HPSS', 17, '9780590353427', NULL),
(30, 'HPSS', 18, '320', 'pages'),
(30, 'HPSS', 19, 'English', NULL);


DROP TABLE IF EXISTS product_album;
CREATE TABLE product_album (
    id SERIAL PRIMARY KEY,
    name TEXT,
    product_id  NUMERIC,
    cover_pic TEXT,
    pic_count NUMERIC,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO product_album (name, product_id, cover_pic, description)
VALUES
('product album', 1, 'https://i.imgur.com/hFS4omM.png', 'album description'),
('description album', 1, 'https://i.imgur.com/tCUq2GJ.jpeg', 'album description'),
('product album', 2, 'https://i.imgur.com/kZPEccB.jpeg', 'album description'),
('description album', 2, 'https://i.imgur.com/ZBk3W8l.jpeg', 'album description'),
('product album', 3, 'https://i.imgur.com/XULiMJ5.jpeg', 'album description'),
('description album', 3, 'https://i.imgur.com/e5LvUqr.jpeg', 'album description'),
('product album', 4, 'https://i.imgur.com/T7ghiT8.jpeg', 'album description'),
('description album', 4, 'https://i.imgur.com/aiw2EfU.jpeg', 'album description'),
('product album', 5, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('description album', 5, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('product pic', 6, 'https://i.imgur.com/hFS4omM.png', 'album description'),
('description pic', 6, 'https://i.imgur.com/tCUq2GJ.jpeg', 'album description'),
('product pic', 7, 'https://i.imgur.com/kZPEccB.jpeg', 'album description'),
('description pic', 7, 'https://i.imgur.com/ZBk3W8l.jpeg', 'album description'),
('product pic', 8, 'https://i.imgur.com/XULiMJ5.jpeg', 'album description'),
('description pic', 8, 'https://i.imgur.com/e5LvUqr.jpeg', 'album description'),
('product pic', 9, 'https://i.imgur.com/T7ghiT8.jpeg', 'album description'),
('description pic', 9, 'https://i.imgur.com/aiw2EfU.jpeg', 'album description'),
('product pic', 10, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('description pic', 10, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('product album', 11, 'https://i.imgur.com/hFS4omM.png', 'album description'),
('description album', 11, 'https://i.imgur.com/tCUq2GJ.jpeg', 'album description'),
('product album', 12, 'https://i.imgur.com/kZPEccB.jpeg', 'album description'),
('description album', 12, 'https://i.imgur.com/ZBk3W8l.jpeg', 'album description'),
('product album', 13, 'https://i.imgur.com/XULiMJ5.jpeg', 'album description'),
('description album', 13, 'https://i.imgur.com/e5LvUqr.jpeg', 'album description'),
('product album', 14, 'https://i.imgur.com/T7ghiT8.jpeg', 'album description'),
('description album', 14, 'https://i.imgur.com/aiw2EfU.jpeg', 'album description'),
('product album', 15, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('description album', 15, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('product pic', 16, 'https://i.imgur.com/hFS4omM.png', 'album description'),
('description pic', 16, 'https://i.imgur.com/tCUq2GJ.jpeg', 'album description'),
('product pic', 17, 'https://i.imgur.com/kZPEccB.jpeg', 'album description'),
('description pic', 17, 'https://i.imgur.com/ZBk3W8l.jpeg', 'album description'),
('product pic', 18, 'https://i.imgur.com/XULiMJ5.jpeg', 'album description'),
('description pic', 18, 'https://i.imgur.com/e5LvUqr.jpeg', 'album description'),
('product pic', 19, 'https://i.imgur.com/T7ghiT8.jpeg', 'album description'),
('description pic', 19, 'https://i.imgur.com/aiw2EfU.jpeg', 'album description'),
('product pic', 20, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('description pic', 20, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('product album', 21, 'https://i.imgur.com/hFS4omM.png', 'album description'),
('description album', 21, 'https://i.imgur.com/tCUq2GJ.jpeg', 'album description'),
('product album', 22, 'https://i.imgur.com/kZPEccB.jpeg', 'album description'),
('description album', 22, 'https://i.imgur.com/ZBk3W8l.jpeg', 'album description'),
('product album', 23, 'https://i.imgur.com/XULiMJ5.jpeg', 'album description'),
('description album', 23, 'https://i.imgur.com/e5LvUqr.jpeg', 'album description'),
('product album', 24, 'https://i.imgur.com/T7ghiT8.jpeg', 'album description'),
('description album', 24, 'https://i.imgur.com/aiw2EfU.jpeg', 'album description'),
('product album', 25, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('description album', 25, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('product pic', 26, 'https://i.imgur.com/hFS4omM.png', 'album description'),
('description pic', 26, 'https://i.imgur.com/tCUq2GJ.jpeg', 'album description'),
('product pic', 27, 'https://i.imgur.com/kZPEccB.jpeg', 'album description'),
('description pic', 27, 'https://i.imgur.com/ZBk3W8l.jpeg', 'album description'),
('product pic', 28, 'https://i.imgur.com/XULiMJ5.jpeg', 'album description'),
('description pic', 28, 'https://i.imgur.com/e5LvUqr.jpeg', 'album description'),
('product pic', 29, 'https://i.imgur.com/T7ghiT8.jpeg', 'album description'),
('description pic', 29, 'https://i.imgur.com/aiw2EfU.jpeg', 'album description'),
('product pic', 30, 'https://i.imgur.com/AaevbdO.png', 'album description'),
('description pic', 30, 'https://i.imgur.com/AaevbdO.png', 'album description');

DROP TABLE IF EXISTS product_pictures;
CREATE TABLE product_pictures
  (
     id SERIAL PRIMARY KEY,
     product_album_id NUMERIC,
     product_id  NUMERIC,
     filename VARCHAR(255),
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );


INSERT INTO product_pictures (product_album_id, filename)
VALUES
(1, 'https://i.imgur.com/hFS4omM.png'),
(1, 'https://i.imgur.com/1CwQZDS.jpeg'),
(2, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(3, 'https://i.imgur.com/kZPEccB.jpeg'),
(3, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(4, 'https://i.imgur.com/XULiMJ5.jpeg'),
(5, 'https://i.imgur.com/e5LvUqr.jpeg'),
(5, 'https://i.imgur.com/T7ghiT8.jpeg'),
(6, 'https://i.imgur.com/aiw2EfU.jpeg'),
(7, 'https://i.imgur.com/AaevbdO.png'),
(7, 'https://i.imgur.com/hFS4omM.png'),
(8, 'https://i.imgur.com/1CwQZDS.jpeg'),
(9, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(9, 'https://i.imgur.com/kZPEccB.jpeg'),
(10, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(11, 'https://i.imgur.com/XULiMJ5.jpeg'),
(11, 'https://i.imgur.com/e5LvUqr.jpeg'),
(12, 'https://i.imgur.com/T7ghiT8.jpeg'),
(13, 'https://i.imgur.com/aiw2EfU.jpeg'),
(13, 'https://i.imgur.com/AaevbdO.png'),
(14, 'https://i.imgur.com/hFS4omM.png'),
(15, 'https://i.imgur.com/1CwQZDS.jpeg'),
(15, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(16, 'https://i.imgur.com/kZPEccB.jpeg'),
(17, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(17, 'https://i.imgur.com/XULiMJ5.jpeg'),
(18, 'https://i.imgur.com/e5LvUqr.jpeg'),
(19, 'https://i.imgur.com/T7ghiT8.jpeg'),
(19, 'https://i.imgur.com/aiw2EfU.jpeg'),
(20, 'https://i.imgur.com/AaevbdO.png'),
(21, 'https://i.imgur.com/hFS4omM.png'),
(21, 'https://i.imgur.com/1CwQZDS.jpeg'),
(22, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(23, 'https://i.imgur.com/kZPEccB.jpeg'),
(23, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(24, 'https://i.imgur.com/XULiMJ5.jpeg'),
(25, 'https://i.imgur.com/e5LvUqr.jpeg'),
(25, 'https://i.imgur.com/T7ghiT8.jpeg'),
(26, 'https://i.imgur.com/aiw2EfU.jpeg'),
(27, 'https://i.imgur.com/AaevbdO.png'),
(27, 'https://i.imgur.com/hFS4omM.png'),
(28, 'https://i.imgur.com/1CwQZDS.jpeg'),
(29, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(29, 'https://i.imgur.com/kZPEccB.jpeg'),
(30, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(31, 'https://i.imgur.com/hFS4omM.png'),
(31, 'https://i.imgur.com/1CwQZDS.jpeg'),
(32, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(33, 'https://i.imgur.com/kZPEccB.jpeg'),
(33, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(34, 'https://i.imgur.com/XULiMJ5.jpeg'),
(35, 'https://i.imgur.com/e5LvUqr.jpeg'),
(35, 'https://i.imgur.com/T7ghiT8.jpeg'),
(36, 'https://i.imgur.com/aiw2EfU.jpeg'),
(37, 'https://i.imgur.com/AaevbdO.png'),
(37, 'https://i.imgur.com/hFS4omM.png'),
(38, 'https://i.imgur.com/1CwQZDS.jpeg'),
(39, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(39, 'https://i.imgur.com/kZPEccB.jpeg'),
(40, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(41, 'https://i.imgur.com/hFS4omM.png'),
(41, 'https://i.imgur.com/1CwQZDS.jpeg'),
(42, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(43, 'https://i.imgur.com/kZPEccB.jpeg'),
(43, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(44, 'https://i.imgur.com/XULiMJ5.jpeg'),
(45, 'https://i.imgur.com/e5LvUqr.jpeg'),
(45, 'https://i.imgur.com/T7ghiT8.jpeg'),
(46, 'https://i.imgur.com/aiw2EfU.jpeg'),
(47, 'https://i.imgur.com/AaevbdO.png'),
(47, 'https://i.imgur.com/hFS4omM.png'),
(48, 'https://i.imgur.com/1CwQZDS.jpeg'),
(49, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(49, 'https://i.imgur.com/kZPEccB.jpeg'),
(50, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(51, 'https://i.imgur.com/hFS4omM.png'),
(51, 'https://i.imgur.com/1CwQZDS.jpeg'),
(52, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(53, 'https://i.imgur.com/kZPEccB.jpeg'),
(53, 'https://i.imgur.com/ZBk3W8l.jpeg'),
(54, 'https://i.imgur.com/XULiMJ5.jpeg'),
(55, 'https://i.imgur.com/e5LvUqr.jpeg'),
(55, 'https://i.imgur.com/T7ghiT8.jpeg'),
(56, 'https://i.imgur.com/aiw2EfU.jpeg'),
(57, 'https://i.imgur.com/AaevbdO.png'),
(57, 'https://i.imgur.com/hFS4omM.png'),
(58, 'https://i.imgur.com/1CwQZDS.jpeg'),
(59, 'https://i.imgur.com/tCUq2GJ.jpeg'),
(59, 'https://i.imgur.com/kZPEccB.jpeg'),
(60, 'https://i.imgur.com/ZBk3W8l.jpeg');



-- product get two album, one for preview and the other is in description
DROP TABLE IF EXISTS product_update_log;
CREATE TABLE product_update_log
  (
     id SERIAL PRIMARY KEY,
     product_id  NUMERIC,
     price_old   NUMERIC,
     price_new   NUMERIC,
     sale_price_old    NUMERIC,
     sale_price_new    NUMERIC,
     operate_man TEXT,          -- who changed it
     old_stock NUMERIC,
     added_stock NUMERIC,
     total_stock NUMERIC,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

INSERT INTO product_update_log (product_id, price_old, price_new, sale_price_old, sale_price_new, old_stock, added_stock, total_stock, operate_man)
VALUES
(1, 899.99, 899.99, 899.99, 899.99, 100, 0, 100, 'jun'),
(2, 499.99, 499.99, 499.99, 499.99, 50, 0, 50, 'jun'),
(3, 249.99, 249.99, 249.99, 249.99, 200, 0, 200, 'jun'),
(4, 1099.99, 1099.99, 1099.99, 1099.99, 150, 0, 150, 'jun'),
(5, 349.99, 349.99, 349.99, 349.99, 100, 0, 100, 'jun'),
(6, 179.99, 179.99, 179.99, 179.99, 250, 0, 250, 'jun');


DROP TABLE IF EXISTS review;
CREATE TABLE review
  (
     id SERIAL PRIMARY KEY,
     product_id  NUMERIC,
     member_id NUMERIC,
     member_name TEXT,
     member_icon TEXT,
     star        NUMERIC,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP DEFAULT NULL,
     tittle      TEXT,
     likes       NUMERIC DEFAULT 1,
     verified  boolean,
     content     TEXT
  );

-- TODO: should I just store picture in one review and separation by semi-colon or continue to use album
INSERT INTO review (product_id, member_id, member_name, member_icon, star, created_at, tittle, likes, content)
VALUES
(1, 1, 'user1', 'icon.jpg', 3.5, '2020-03-18 22:18:40', 'size smaller than expected', 1,'size was smaller than expected'),
(1, 2, 'user1', 'icon.jpg', 1, '2020-03-18 16:18:25','item arrive late', 1,'late'),
(1, 3, 'user3', 'icon.jpg', 5, '2020-03-18 16:18:25','good',1,'item is good'),
(3, 1, 'user1', 'icon.jpg', 1, '2020-03-18 16:18:25','good',1,'item is good'),
(3, 2, 'user2', 'icon.jpg', 5, '2020-03-18 16:18:25','good',1,'item is good'),
(14, 1, 'user1', 'icon.jpg', 1, '2020-03-18 16:18:25','good',1,'item is good'),
(14, 2, 'user2', 'icon.jpg', 5, '2020-03-18 16:18:25','good',1,'item is good'),
(15, 1, 'user1', 'icon.jpg', 5, '2020-03-18 16:18:25','good',1,'item is good'),
(15, 2, 'user2', 'icon.jpg', 1, '2020-03-18 16:18:25','good',1,'item is good'),
(15, 3, 'user3', 'icon.jpg', 1, '2020-03-18 16:18:25','good',1,'item is good');

DROP TABLE IF EXISTS review_album;
CREATE TABLE review_album
  (
     id SERIAL PRIMARY KEY,
     review_id  NUMERIC,
     pic_count NUMERIC,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

INSERT INTO review_album (review_id, pic_count)
VALUES
(1, 3),
(2, 1),
(3, 2),
(4, 2),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 2);



DROP TABLE IF EXISTS review_pictures;
CREATE TABLE review_pictures
  (
     id SERIAL PRIMARY KEY,
     review_album_id  NUMERIC,
     filename VARCHAR(255),
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

INSERT INTO review_pictures (review_album_id, filename)
VALUES
(1, 'https://i.imgur.com/rzocQcD.jpeg'),
(1, 'https://i.imgur.com/LUszOiA.jpeg'),
(1, 'https://i.imgur.com/IQAzB6P.jpeg'),
(2, 'https://i.imgur.com/IQAzB6P.jpeg'),
(3, 'https://i.imgur.com/Kz8xPFg.png'),
(3, 'https://i.imgur.com/Kz8xPFg.png'),
(4, 'https://i.imgur.com/detILKk.png'),
(4, 'https://i.imgur.com/detILKk.png'),
(5, 'https://i.imgur.com/rzocQcD.jpeg'),
(6, 'https://i.imgur.com/LUszOiA.jpeg'),
(7, 'https://i.imgur.com/IQAzB6P.jpeg'),
(8, 'https://i.imgur.com/Kz8xPFg.png'),
(9, 'https://i.imgur.com/detILKk.png'),
(10, 'https://i.imgur.com/rzocQcD.jpeg'),
(10, 'https://i.imgur.com/LUszOiA.jpeg');





-------------------------------
---------- UMS ----------------
-------------------------------
-- user related management system ---
DROP TABLE IF EXISTS member;

CREATE TABLE member
  (
     id SERIAL PRIMARY KEY,
     username     TEXT,
     password     TEXT,
     name        TEXT,
     phone_number TEXT,
     email       TEXT,
     status       INTEGER DEFAULT 1,
     delete_status       INTEGER DEFAULT 0,
     created_at  TIMESTAMP,
     last_login   TIMESTAMP,
     source_type  TEXT          -- web user -> 0 , mobile user -> 1
  );

DROP TABLE IF EXISTS member_icon;

CREATE TABLE member_icon
(
    id SERIAL PRIMARY KEY,
    member_id NUMERIC,
    filename TEXT
);


DROP TABLE IF EXISTS address;

CREATE TABLE address
  (
     id SERIAL PRIMARY KEY,
     member_id    NUMERIC,
     receiver_name TEXT,
     phone_number TEXT,
     detail_address  TEXT,
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



---------------User  all password is password
INSERT INTO member (username, password, name, phone_number, created_at, last_login)
            VALUES ('user1','$2a$10$PHcLPlJod/fKyjMUsGuSVeVnI0.EKudDleRT9vM9jqCJzL9QvC5Ju', 'Jun', '212-212-2222', '2020-03-18 22:18:40', '2020-03-18 22:20:24');
INSERT INTO member (username, password, name,  phone_number, created_at, last_login)
            VALUES ('user2','$2a$10$pSHd2ngUssBZYRlHQQaKu.rb0me5ZAgld0fVASB50vrMslLb8md0a', 'John', '877-393-4448', '2020-03-19 14:02:32', '2020-03-19 22:18:40');
INSERT INTO member (username, password, name,  phone_number, created_at, last_login)
            VALUES ('user3', '$2a$10$xEbGJ1QHr/CZ.ltRIP4A9.K27Sq3HJ4Dh/sN0ssd5GwkaPbjPRW9S', 'Jane', '112-323-1111', '2020-03-18 04:20:52', '2020-03-20 05:01:02');

INSERT INTO member_icon (member_id, filename)
VALUES
(1, 'https://i.imgur.com/aPrCAdn.png'),
(2, 'https://i.imgur.com/1URlVYg.png'),
(3, 'https://i.imgur.com/IG2yW8k.jpeg');


INSERT INTO address (member_id, receiver_name, phone_number, detail_address, city, state, zip_code, note) VALUES (1, 'Jun',  '212-212-2222', '1 1st street 2nd ave', 'Chicago','Illinois','60007','');
INSERT INTO address (member_id, receiver_name, phone_number, detail_address, city, state, zip_code, note) VALUES (2, 'John', '111-111-1111', '2 2nd street 3rd ave Apt 4F', 'Dallas','Texas', '75001' ,'please call, door bell broken');
INSERT INTO address (member_id, receiver_name, phone_number, detail_address, city, state, zip_code, note) VALUES (3, 'Jane', '212-212-2222', '3 4st street 5nd ave', 'San Francisco','California','94016','');

--- login type ,pc/andriod/IOS   = 0/1/2
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (1,'2020-03-18 22:18:40','127.0.0.1','0');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (1,'2020-03-18 22:20:24', '127.0.0.1','0');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (2, '2020-03-19 14:02:32', '127.0.0.1','1');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (2, '2020-03-19 22:18:40', '127.0.0.1','1');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (3, '2020-03-18 04:20:52', '127.0.0.1','0');
INSERT INTO member_login_log (member_id, login_time, ip_address, login_type) VALUES (3,'2020-03-20 05:01:02', '127.0.0.1','2');



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
     created_at TIMESTAMP,
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
     created_at TIMESTAMP,
     status      TEXT
  );

DROP TABLE IF EXISTS permission;

CREATE TABLE permission (
    id SERIAL PRIMARY KEY,
    parent_id NUMERIC,-- sub permission
    name    TEXT,
    value   TEXT,
    created_at TIMESTAMP,
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

--------------Admin

-- username : adminacct  password: adminpass      first admin have all permission, second is for order and only have order permission
-- and third admin is for user and have all user permission.
INSERT INTO admin(username, password, email, name, created_at, status) VALUES ('adminacct', '$2a$10$c.FVHJ7x9Gedv.StYqdOB.FB1dNVCLBxS76ZbLutbTHwL15hcFGh2', 'admin@gmail.com', 'jun', '2020-03-18 22:18:40', 'active');

INSERT INTO admin(username, password, email, name, created_at, status) VALUES ('adminacctorder', '$2a$10$c.FVHJ7x9Gedv.StYqdOB.FB1dNVCLBxS76ZbLutbTHwL15hcFGh2', 'order@gmail.com', 'jun', '2020-03-18 22:18:40', 'active');

INSERT INTO admin(username, password, email, name, created_at, status) VALUES ('adminacctuser', '$2a$10$c.FVHJ7x9Gedv.StYqdOB.FB1dNVCLBxS76ZbLutbTHwL15hcFGh2', 'user@gmail.com', 'jun', '2020-03-18 22:18:40', 'active');

-- username : devacct   password: devpass
INSERT INTO admin(username, password, email, name, created_at, status) VALUES ('devacct', '$2a$10$zykJppm18avEb79CGEtFjOIwKlgUJ4BeMFiF8HGjccVMgJ8XTjZpy', 'dev@gmail.com', 'dev', '2020-03-20 12:06:40', 'active');

INSERT INTO roles (name, description, created_at, status) VALUES ('ROLE_admin-product', 'manage product issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, created_at, status) VALUES ('ROLE_admin-order', 'manage order issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, created_at, status) VALUES ('ROLE_admin-user', 'manage user related issue', '2020-03-21 12:35:20', 'active');
INSERT INTO roles (name, description, created_at, status) VALUES ('ROLE_admin-sale', 'manage sale issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, created_at, status) VALUES ('ROLE_admin-content', 'manage content issues', '2020-03-23 09:42:22', 'active');
INSERT INTO roles (name, description, created_at, status) VALUES ('ROLE_admin-root', 'root', '2020-03-18 22:18:40', 'active');
INSERT INTO roles (name, description, created_at, status) VALUES ('ROLE_member', 'root', '2020-03-18 22:18:40', 'active');

-- base permission
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('0', 'product', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('0', 'order', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('0', 'user', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('0', 'sales', null, '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('0', 'content', null, '2019-08-18 16:00:38', 'active');

-- CRUD product
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'create product', 'product:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'read product', 'product:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'update product', 'product:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'delete product', 'product:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'create brand', 'brand:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'read brand', 'brand:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'update brand', 'brand:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'delete brand', 'brand:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'create product_category', 'product_category:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'read product_category', 'product_category:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'update product_category', 'product_category:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'delete product_category', 'product_category:delete', '2019-08-18 16:00:38', 'active');

INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'create product_attribute', 'product_attribute:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'read product_attribute', 'product_attribute:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'update product_attribute', 'product_attribute:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('1', 'delete product_attribute', 'product_attribute:delete', '2019-08-18 16:00:38', 'active');

-- CRUD Order
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('2', 'create order', 'order:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('2', 'read order', 'order:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('2', 'update order', 'order:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('2', 'delete order', 'order:delete', '2019-08-18 16:00:38', 'active');

-- CRUD user
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('3', 'create user', 'user:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('3', 'read user', 'user:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('3', 'update user', 'user:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('3', 'delete user', 'user:delete', '2019-08-18 16:00:38', 'active');

-- CRUD Sales
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('4', 'create sales', 'sales:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('4', 'read sales', 'sales:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('4', 'update sales', 'sales:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('4', 'delete sales', 'sales:delete', '2019-08-18 16:00:38', 'active');

-- CRUD Content
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('5', 'create content', 'content:create', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('5', 'read content', 'content:read', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('5', 'update content', 'content:update', '2019-08-18 16:00:38', 'active');
INSERT INTO permission (parent_id, name, value, created_at, status) VALUES ('5', 'delete content', 'content:delete', '2019-08-18 16:00:38', 'active');


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

DROP TABLE IF EXISTS shopping_cart;
CREATE TABLE shopping_cart (
    id SERIAL PRIMARY KEY,
    member_id bigint,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP DEFAULT NULL
);

INSERT INTO shopping_cart (member_id, created_at, modify_date) VALUES
(1, '2023-04-25 08:30:00', '2023-04-25 08:30:00'),
(2, '2023-04-25 08:30:00', '2023-04-25 08:30:00'),
(3, '2023-04-25 08:30:00', '2023-04-25 08:30:00');


DROP TABLE IF EXISTS cart_item;
CREATE TABLE cart_item (
  id SERIAL PRIMARY KEY,
  cart_id bigint,
  product_id bigint,
  product_name varchar(500),
  product_sku varchar(500),
  product_pic varchar(1000),
  quantity integer,
  price numeric(10,2),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modify_date TIMESTAMP DEFAULT NULL
);

INSERT INTO cart_item (cart_id, product_id, product_name, product_sku, product_pic, quantity, price) VALUES

(2, 21, 'Nike Air Max 270', 'NAM270', 'nikeairmax270.jpg', 1, 129.99),
(2, 29, 'To Kill a Mockingbird ', 'TKAM', 'tokillamockingbird.jpg', 1, 12.99),

(3, 25, 'Nike Dri-FIT T-Shirt ', 'NDFTS', 'nikeDriFitShirt.jpg', 2, 29.99),
(3, 2, 'iPhone SE','IPSE-RED' , 'iphonese-red.jpg', 1, 449.99),

(5, 5, 'Galaxy S21', 'GS21', 'galaxyS21.jpg', 2, 1099.99),
(5, 19, 'Xbox Series X', 'XSX', 'xboxSeriesX.jpg', 1, 499.99);



DROP TABLE IF EXISTS orders;
CREATE TABLE orders (   -- have to called orders instead of order, or else conflict with ORDER BY
   id SERIAL PRIMARY KEY,
   member_id BIGINT NOT NULL,
   coupon_id BIGINT,
   order_sn VARCHAR(64),
   member_email VARCHAR(64),
   total_amount NUMERIC(10,2),
   promotion_amount NUMERIC(10,2),
   coupon_amount NUMERIC(10,2),
   discount_amount NUMERIC(10,2),
   shipping_cost NUMERIC(10,2),
   pay_amount NUMERIC(10,2),
   pay_type INTEGER,              -- credit card -> 0, paypal -> 1, google pay -> 2
   source_type INTEGER,           -- pc -> 0 , mobile -> 1
   status INTEGER DEFAULT 0,                -- waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid/cancel 5
   delivery_company VARCHAR(64),
   delivery_tracking_number VARCHAR(64),
   receiver_phone VARCHAR(32),
   receiver_name VARCHAR(100) NOT NULL,
   receiver_detail_address VARCHAR(200),
   receiver_city VARCHAR(32),
   receiver_state VARCHAR(32),
   receiver_zip_code VARCHAR(32),
   payment_id VARCHAR(32),
   payer_id VARCHAR(32),
   payment_time TIMESTAMP,                  --
   delivery_time TIMESTAMP,                 -- TBD by UPS api/label and added in
   receive_time TIMESTAMP DEFAULT NULL,      -- update it after UPS said received, should be using redis to do this
   comment varchar(200) DEFAULT NULL,        -- comment left customer like "leave the package under the rug"
   admin_note VARCHAR(500) DEFAULT NULL,       -- note left by previous admin stating what's happening
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP DEFAULT NULL
);

INSERT INTO orders (member_id, coupon_id, order_sn, total_amount,  promotion_amount, coupon_amount, discount_amount, shipping_cost, pay_amount,
                    pay_type, source_type, status, delivery_company, delivery_tracking_number,
                    receiver_name, receiver_phone, member_email, receiver_detail_address, receiver_city, receiver_state, receiver_zip_code,
                    payment_time, delivery_time, comment)
VALUES
(1, 1, '1001', 2499.98, 149.99, 15, 164.99, 0, 2334.99, 1, 0, 1, 'UPS', '1234567890',
'Jane Doe', '123-456-7890', 'john@example.com', '123 Main St', 'San Francisco', 'California', '12345',
'2023-04-25 08:30:00', NULL, 'Please include stickers'),
-- $20 off + 10% off coupon
(2, 2, '1002', 2199.98, 20, 217.99, 237.99, 0, 1961.99, 1, 0, 2, 'UPS', '9876543210',
'Jane Doe', '555-999-8888', 'janedoe@example.com', '456 Market St', 'San Francisco', 'CA', '94102',
'2023-04-24 09:15:00', NULL, 'no comments'),

(1, 1, '1003', 1399.99, 100, 15, 115, 0, 1284, 1, 0, 3, 'UPS', '123456789',
'Jane Doe', '555-123-4567', 'jane_doe@example.com', '123 Main St, Apt 4B', 'New York City', 'New York', '10001',
'2022-01-09 10:45:00', NULL, 'I order it with other item, please ship it together'),

(2, NULL, '1004', 129.99, 0, 0, 0, 0, 129.99, 1, 0, 4, 'UPS', '987654321',
'John Smith', '555-987-6543', 'john_smith@example.com', '456 Oak St, Apt 12C', 'Los Angeles', 'California', '90001',
'2022-01-12 11:15:00', NULL, NULL),

(3, 3, '1005', 19999.90, 1000, 999999.99, 1000999.99, 0, 0, 1, 1, 5, 'USPS', '987654321',
'John Smith','555-987-6543', 'john_smith@example.com', '456 Oak St, Apt 12C', 'Los Angeles', 'California', '90001',
'2022-01-12 11:15:00', NULL, NULL);


-- all the items in one order
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
	coupon_amount NUMERIC(10,2) DEFAULT NULL,               -- the coupon that applied to the product will have it if not just 0
	real_amount NUMERIC(10,2) DEFAULT NULL
);

INSERT INTO
  order_item (order_id, order_sn, product_id, product_pic, product_name, product_brand, product_sn, product_price, product_quantity,
                product_sku_id, product_sku_code, product_category_id, promotion_name, promotion_amount, coupon_amount, real_amount)
VALUES
  -- 1 iphone se red and a macbook , 15$ off
  (1, '1001', 2, 'iphoneSE.jpg', 'iPhone SE', 'Apple', 'SN-456', 499.99, 1, 5, 'IPSE-RED', 15, 'iphone-SE 10% OFF', 49.99, 0, 450),
  (1, '1001', 13, 'macBookPro.jpg', 'MacBook Pro', 'Apple', 'SN-678', 1999.99, 1, 16, 'MBP', 17, 'All laptop 100 off', 100, 0, 1899.99),
  -- 2 OnePlus 9 , 10 % off
  (2, '1002', 4, 'oneplus9Pro.jpg', 'OnePlus 9 Pro', 'OnePlus', 'SN-789', 1099.99, 2, 7, 'OP9P', 15, 'OnePlus product $10 off', 20, 0, 2179.98),
  -- xps13 $15 off
  (3, '1003', 14, 'xps13.jpg', 'XPS 13', 'Dell', 'SN-456', 1399.99, 1, 17, 'XPS13', 17, 'All laptop 100 off', 100, 0, 1299.99),
  -- sneaker, no coupon
  (4, '1004', 21, 'nikeairmax270.jpg', 'Nike Air Max 270', 'Nike', 'SN-001', 129.99, 1, 24, 'NAM270', 8, '', 0, 0, 129.99),
  -- 10 macbook invalid free coupon
  (5, '1005', 13, 'macBookPro.jpg', 'MacBook Pro', 'Apple', 'SN-678', 1999.99, 10, 16, 'MBP', 17, 'All laptop 100 off', 1000, 0, 18999.90);


-- update order status history/logs
DROP TABLE IF EXISTS order_change_history;
CREATE TABLE order_change_history (
  id SERIAL PRIMARY KEY,
  order_id bigint NULL DEFAULT NULL ,
  change_operator varchar(100) ,                    -- who changed the order,  0-> user   1-> admin/dev  2-> system,automatically
  created_at timestamp NULL DEFAULT NULL ,
  order_status int NULL DEFAULT NULL ,              -- waiting for payment 0 , fulfilling 1,  send 2 , complete(received) 3, closed(out of return period) 4 ,invalid 5
  note varchar(500) NULL DEFAULT NULL
);

INSERT INTO order_change_history (order_id, change_operator, created_at, order_status, note) VALUES
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
('111 over there send out avenue 2nd floor', 1, 0, 'Jun' , 1800000000, 'New York', 'New York', 11220, '222 over there avenue 2nd floor, go through the gate in north east corner to unload'),
('222 right here return avenue', 0, 1, 'Jun' , 1800000000, 'Nevada', 'Las Vegas', 88901, 'Next to the casino'),
('333 backup warehouse avenue', 1, 1, 'Jun' , 1800000000, 'Pennsylvania', 'Philadelphia', 19019, 'Big red sign turn left and ring bell to enter');


--- when admin/operator determined if the product can be return, one item(s) return at a time
DROP TABLE IF EXISTS return_request;
CREATE TABLE return_request  (
  id SERIAL PRIMARY KEY,
  order_id bigint ,
  company_address_id bigint ,                   -- return to you(owner), return center or warehouse
  order_sn varchar(64) ,
  member_id bigint ,
  return_quantity bigint,                       -- number of items to be returned
  return_name varchar(100) ,
  return_phone varchar(100) ,
  status int,                -- return status,  waiting to process 0 , returning(sending) 1, complete 2, rejected(not matching reason) 3
  handle_time timestamp,                        -- how long to return this item, e.g 2 weeks to return this or return is voided.
  asking_amount decimal(10, 2),
  refunded_amount decimal(10, 2),
  reason varchar(200) ,                         -- pre-set reasons
  description varchar(500) ,
  handle_note varchar(500) ,                    -- notes from admin to customer or rejection reason
  handle_operator varchar(100) ,                -- who processed this return
  receive_operator varchar(100) ,               -- who received the return item
  receive_time timestamp,
  receive_note varchar(500),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO return_request (order_id, company_address_id, order_sn, member_id, return_quantity, return_name, return_phone, status,
                                 handle_time, asking_amount, reason, description, handle_note, handle_operator, receive_operator,
                                 receive_time, receive_note
) VALUES
(1001, 1, 'OR123456', 2001, 3, 'John Doe', '555-123-4567', 0,
 NULL, NULL, 'Item damaged upon arrival', 'Received two damaged items in the package.',
 NULL, NULL, NULL, NULL, NULL),
(1002, 2, 'OR789012', 2002, 1, 'Alice Smith', '555-987-6543', 1,
 NULL, NULL, 'Wrong item received', 'Received a different product than what was ordered.',
 NULL, NULL, NULL, NULL, NULL),
(1003, 3, 'OR456789', 2003, 6, 'Mary Johnson', '555-789-1234', 2,
 '2023-09-09 14:30:00', 75.99, 'Changed my mind', 'Decided not to keep these items.',
 'Refund processed successfully.', 'AdminUser123', 'WarehouseStaff456',
 '2023-09-10 09:15:00', 'Items received in good condition.'),
(1004, 1, 'OR987654', 2004, 1, 'David Wilson', '555-555-5555', 3,
 NULL, NULL, 'Item does not match the description', 'The product received is not as described on the website.',
 'Rejected due to mismatch.', 'AdminUser789', NULL, NULL, NULL),
(1005, 2, 'OR555555', 2005, 2, 'Linda Davis', '555-123-7890', 0,
 NULL, NULL, 'Item arrived late', 'Items arrived after the expected delivery date.',
 NULL, NULL, NULL, NULL, NULL);

DROP TABLE IF EXISTS return_item;
CREATE TABLE return_item (
    id SERIAL PRIMARY KEY,
    return_request_id bigint NOT NULL,
    brand_id bigint,
    order_id bigint,
    order_sn varchar(64),
    product_id bigint,
    product_sku varchar(100),
    purchased_price decimal(10, 2),
    quantity bigint
);

INSERT INTO return_item (
    return_request_id, brand_id, order_id, order_sn,
    product_id, product_sku, quantity
) VALUES
(1, 100, 1001, 'OR123456', 101, 'SKU001', 1),
(1, 100, 1001, 'OR123456', 102, 'SKU002', 2),
(2, 200, 1002, 'OR789012', 201, 'SKU003', 1),
(3, 100, 1003, 'OR456789', 301, 'SKU004', 3),
(3, 100, 1003, 'OR456789', 302, 'SKU005', 2),
(3, 200, 1003, 'OR456789', 303, 'SKU006', 1),
(4, 200, 1004, 'OR987654', 401, 'SKU007', 1),
(5, 300, 1005, 'OR555555', 501, 'SKU008', 2);

DROP TABLE IF EXISTS return_reason_pictures;
CREATE TABLE return_reason_pictures (
  id SERIAL PRIMARY KEY,
  return_request_id bigint NOT NULL,
  filename VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO return_reason_pictures (return_request_id, filename)
VALUES
(1, 'https://i.imgur.com/zNGBoLk.jpeg'),
(1, 'https://i.imgur.com/DebpKZa.png'),
(2, 'https://i.imgur.com/UJSZE08.jpeg'),
(3, 'https://i.imgur.com/DCtQmc2.png'),
(4, 'https://i.imgur.com/UHgW2D8.jpeg'),
(5, 'https://i.imgur.com/UHgW2D8.jpeg');

DROP TABLE IF EXISTS return_log;
CREATE TABLE return_log (
    id SERIAL PRIMARY KEY,
    return_request_id bigint,
    action       varchar(100),
    operator     varchar(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO return_log (
    return_request_id, action, operator
) VALUES
(1, 'APPLY', 'Jun'),
(1, 'APPLY', 'Jun'),
(2, 'APPLY', 'Jun');








--------------
---  CMS  ----
--------------
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

DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon (
  id SERIAL PRIMARY KEY,
  coupon_type integer NULL DEFAULT NULL,           -- discount on 0-> all, 1 -> specific brand,  2-> specific category , 3-> specific item
  name varchar(100),
  discount_type  integer NULL DEFAULT NULL,   -- 0 -> by amount , 1->  by percent off
  amount numeric(10,2) NULL DEFAULT NULL,   -- amount discounted
  start_time timestamp NULL DEFAULT NULL,
  end_time timestamp NULL DEFAULT NULL,
  note varchar(200) NULL DEFAULT NULL,
  count integer NULL DEFAULT NULL,          -- number of this coupon
  publish_count integer NULL DEFAULT NULL,  -- number of send/publish coupons to users
  used_count integer NULL DEFAULT NULL,      -- number of used coupons
  code varchar(64) NULL DEFAULT NULL,
  status integer NULL DEFAULT 1          -- is the coupon active or disable ,  0 -> disable, 1 -> active
);

-- TODO: make sure free coupon don't go negative
INSERT INTO coupon(coupon_type, name, discount_type, amount, start_time, end_time, count, publish_count, used_count, code, status)
VALUES
(0, '$15 off whole order', 0, 15.00, '2019-08-18 16:00:3', '2025-08-18 16:00:3', 20, 10 , 0, '15OFF', 1),
(0, '10% off whole order', 1, 10, '2019-08-18 16:00:3', '2025-08-18 16:00:3', 20, 10 , 0, '10OFF', 1),
(0, 'All free', 0, 999999.99, '2019-08-18 16:00:3', '2025-08-18 16:00:3', 1, 1 , 1, 'FREE', 1),
(1, '$50 off Apple product', 0, 50.00, '2019-08-18 16:00:3', '2025-08-18 16:00:3', 1, 1 , 0, '50OFFAPPLE', 1),
(2, '60% off shirts', 1, 60, '2019-08-18 16:00:3', '2025-08-18 16:00:3', 1, 1 , 0, '60OFFSHIRTS', 1),
(3, '20% off Galaxy S21', 1, 20, '2019-08-18 16:00:3', '2025-08-18 16:00:3', 1, 1 , 1, '20OFFS21', 1);


-- the product that are affected by the coupon, coupon type 1-3 will use this. 0 type will not.
DROP TABLE IF EXISTS coupon_product_relation;
CREATE TABLE coupon_product_relation(
      id SERIAL PRIMARY KEY,
      coupon_id integer,
      product_id integer,
      product_name varchar(100),
      product_sn varchar(100),
      product_sku_code varchar(100)
);

INSERT INTO coupon_product_relation(coupon_id, product_id, product_name, product_sn, product_sku_code)
VALUES
(4, 1, 'iPhone 12', 'SN-123', 'IP12-RED'),
(4, 1, 'iPhone 12', 'SN-123', 'IP12-WHITE'),
(4, 1, 'iPhone 12', 'SN-123', 'IP12-BLACK'),
(4, 2, 'iPhone SE', 'SN-456', 'IPSE-RED'),
(4, 2, 'iPhone SE', 'SN-456', 'IPSE-BLUE'),
(4, 6, 'AirPods Pro', 'SN-234', 'APRO1'),
(4, 7, 'AirPods 2', 'SN-789', 'APO2'),
(4, 9, 'iPad Pro', 'SN-901', 'IPPRO'),
(4, 13, 'MacBook Pro', 'SN-678', 'MBP');


INSERT INTO coupon_product_relation(coupon_id, product_id, product_name, product_sn, product_sku_code)
VALUES
(5, 25, 'Nike Dri-FIT T-Shirt', 'SN-002', 'NDFTS'),
(5, 26, 'Calvin Klein Logo T-Shirt', 'SN-008', 'CKLTS'),
(5, 27, 'Adidas Essential Track Pants', 'SN-005', 'AEPTP');


INSERT INTO coupon_product_relation(coupon_id, product_id, product_name, product_sn, product_sku_code)
VALUES
(6, 5, 'Galaxy S21', 'SN-234', 'GS21');


DROP TABLE IF EXISTS coupon_history;
CREATE TABLE coupon_history (
    id SERIAL PRIMARY KEY,
    coupon_id bigint NOT NULL,
    member_id  bigint NOT NULL,
    order_id  bigint NOT NULL,
    used_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    code varchar(64) NULL DEFAULT NULL
);

INSERT INTO coupon_history (coupon_id, member_id, order_id, used_time, code)
VALUES
(1, 1, 1, '2023-04-25 08:45:00', '15OFF'),
(2, 2, 2, '2023-03-25 08:45:00', '15OFF'),
(3, 1, 3, '2023-02-25 08:45:00', '50OFF'),
(1, 3, 4, '2022-01-11 10:00:00', 'FREE');


DROP TABLE IF EXISTS promotion_sale;
CREATE TABLE promotion_sale (
    id SERIAL PRIMARY KEY,
    name varchar(100) ,
    promotion_type integer ,      -- discount on 0-> all, 1 -> specific brand,  2-> specific category , 3-> specific item
    discount_type  integer,       -- 0 -> by amount , 1->  by percent off
    amount numeric,
    status integer,               -- 0-> not active, 1-> active is it active
    start_time TIMESTAMP,
    end_time   TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-- TODO: does sale stacks?.  and need a way to check discounts time expiration. maybe redis or spring scheduler/task
INSERT INTO promotion_sale(name, promotion_type, discount_type, amount, status, start_time, end_time)
VALUES
('Every thing 10% off', 0, 1, 10, 0, '2023-02-25 08:45:00', '2023-08-25 08:45:00'),
('OnePlus product $10 off', 1, 0, 10, 1, '2023-02-25 08:45:00', '2023-08-25 08:45:00'),
('All laptop 100 off', 2, 0, 100, 1, '2023-02-25 08:45:00', '2023-08-25 08:45:00'),
('iphone-SE 10% OFF', 3, 1, 10, 1, '2023-02-25 08:45:00', '2023-08-25 08:45:00');

-- products that affected by this promotion
-- user other services to find, brand, category, specific product, or All
DROP TABLE IF EXISTS promotion_sale_product;
CREATE TABLE promotion_sale_product (
    id SERIAL PRIMARY KEY,
    promotion_sale_id bigint NOT NULL,
    product_id bigint NOT NULL,
    product_sku_code TEXT,
    promotion_price numeric NOT NULL,       -- what the price - promotion sale amount = promotion_price
    promotion_limit_item  integer NOT NULL,      -- how many allowed to sell at discount, need to check sku stock
    promotion_limit_per_user  integer NOT NULL       -- number of limit per member/account
);

-- TODO: need to check when stock/sold meet limit before canceling hte discount
-- does it have priority for discount? like all > category -> brand -> specific product and do they stack?
INSERT INTO promotion_sale_product (promotion_sale_id , product_id, product_sku_code, promotion_price, promotion_limit_item, promotion_limit_per_user)
VALUES
-- All laptop 100 off
(3, 13, 'MBP', 1899.99, 80, 3),
(3, 14, 'XPS13', 1299.99, 150, 3),
(3, 15, 'TPX1C', 1399.99, 200, 3),
(3, 16, 'YC940', 1199.99, 150, 3),
(3, 17, 'IPG3', 899.99, 100, 3),
(3, 18, 'AM15R5', 1899.99, 80, 3);

-- update here to make it more consistency, will update using service when E-Com is running
UPDATE product SET on_sale_status = 1, sale_price = 1899.99  WHERE id = 13;
UPDATE product_sku SET promotion_price = 1899.99 WHERE product_id = 13 AND sku_code = 'MBP';

UPDATE product SET on_sale_status = 1, sale_price = 1299.99 WHERE id = 14;
UPDATE product_sku SET promotion_price = 1299.99 WHERE product_id = 14 AND sku_code = 'XPS13';

UPDATE product SET on_sale_status = 1, sale_price = 1399.99  WHERE id = 15;
UPDATE product_sku SET promotion_price = 1399.99 WHERE product_id = 15 AND sku_code = 'TPX1C';

UPDATE product SET on_sale_status = 1, sale_price = 1199.99  WHERE id = 16;
UPDATE product_sku SET promotion_price = 1199.99 WHERE product_id = 16 AND sku_code = 'YC940';

UPDATE product SET on_sale_status = 1, sale_price = 899.99 WHERE id = 17;
UPDATE product_sku SET promotion_price = 899.99 WHERE product_id = 17 AND sku_code = 'IPG3';

UPDATE product SET on_sale_status = 1, sale_price = 1899.99 WHERE id = 18;
UPDATE product_sku SET promotion_price = 1899.99 WHERE product_id = 18 AND sku_code = 'AM15R5';

-- OnePlus product $10 off
INSERT INTO promotion_sale_product (promotion_sale_id , product_id, product_sku_code, promotion_price, promotion_limit_item, promotion_limit_per_user)
VALUES
(2, 13, 'OP9P', 1089.99, 100, 3),
(2, 14, 'OBPRO', 139.99, 150, 3),
(2, 15, 'OPW3', 189.99, 80, 3);

UPDATE product SET on_sale_status = 1, sale_price = 1089.99 WHERE id = 4;
UPDATE product_sku SET promotion_price = 1089.99 WHERE product_id = 4 AND sku_code = 'OP9P';

UPDATE product SET on_sale_status = 1, sale_price = 139.99 WHERE id = 8;
UPDATE product_sku SET promotion_price = 139.99 WHERE product_id = 8 AND sku_code = 'OBPRO';

UPDATE product SET on_sale_status = 1, sale_price = 189.99 WHERE id = 10;
UPDATE product_sku SET promotion_price = 189.99 WHERE product_id = 10 AND sku_code = 'OPW3';

-- iphone-SE 10% OFF
INSERT INTO promotion_sale_product (promotion_sale_id , product_id, product_sku_code, promotion_price, promotion_limit_item, promotion_limit_per_user)
VALUES
(4, 2, 'IPSE-BLUE', 449.99, 25, 3),
(4, 2, 'IPSE-RED', 449.99, 25, 3);

UPDATE product SET on_sale_status = 1, sale_price = 449.99  WHERE id = 2;
UPDATE product_sku SET promotion_price = 449.99 WHERE product_id = 2 AND sku_code = 'IPSE-BLUE';

UPDATE product SET on_sale_status = 1, sale_price = 449.99 WHERE id = 2;
UPDATE product_sku SET promotion_price = 449.99 WHERE product_id = 2 AND sku_code = 'IPSE-RED';


-- keep track of changes/update to promotion
DROP TABLE IF EXISTS promotion_sale_log;
CREATE TABLE promotion_sale_log (
    id SERIAL PRIMARY KEY,
    promotion_sale_id numeric,
    sale_action TEXT,
    promotion_type integer,    -- discount on 0-> all, 1 -> specific brand,  2-> specific category , 3-> specific item
    discount_type  integer,       -- 0 -> by amount , 1->  by percent off
    amount numeric,
    operate_man TEXT,     -- who made the change
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO promotion_sale_log(promotion_sale_id, sale_action, promotion_type, discount_type, amount, operate_man)
VALUES
(1, 'update action', 0, 1, 20, 'admin'),
(2, 'update action', 1, 1, 10, 'admin'),
(3, 'update action', 2, 0, 100, 'admin'),
(4, 'update action', 3, 1, 10, 'admin');

INSERT INTO authorities (email,roles) VALUES ('hojat@yahoo.com','ADMIN');
INSERT INTO authorities (email,roles) VALUES ('mamad@yahoo.com','USER');
INSERT INTO users_tbl (id,cover,created_at,email,enabled,name,password,updated_at) VALUES (1000,'','2020-01-27 23:11:58','hojat@yahoo.com',1,'hojat','$2a$10$rf/czIw6K.mZrWmLdv8SNuj3U9SFxllPueo7UbaXYERyPyCppxO6C','2020-01-27 23:11:58');
INSERT INTO users_tbl (id,cover,created_at,email,enabled,name,password,updated_at) VALUES (2000,'','2020-01-27 23:11:58','mamad@yahoo.com',1,'mamad','$2a$10$rf/czIw6K.mZrWmLdv8SNuj3U9SFxllPueo7UbaXYERyPyCppxO6C','2020-01-27 23:11:58');
INSERT INTO terms (id,title) VALUES (10,'ترم یک');
INSERT INTO terms (id,title) VALUES (20,'ترم دو');
INSERT INTO terms (id,title) VALUES (30,'ترم سه');
INSERT INTO terms (id,title) VALUES (40,'ترم چهار');
INSERT INTO course (id,code,created_at,max,name,unit,updated_at,term_id) VALUES (100,412563,'2020-01-27 23:11:58',15,'ریاضی',3,'2020-01-27 23:11:58',10);
INSERT INTO course (id,code,created_at,max,name,unit,updated_at,term_id) VALUES (200,412563,'2020-01-27 23:11:58',15,'ریاضی مهندسی',3,'2020-01-27 23:11:58',10);
INSERT INTO course (id,code,created_at,max,name,unit,updated_at,term_id) VALUES (300,412563,'2020-01-27 23:11:58',15,'طراحی وب',3,'2020-01-27 23:11:58',20);
INSERT INTO course (id,code,created_at,max,name,unit,updated_at,term_id) VALUES (400,412563,'2020-01-27 23:11:58',15,'جاوا',3,'2020-01-27 23:11:58',30);
INSERT INTO course (id,code,created_at,max,name,unit,updated_at,term_id) VALUES (500,412563,'2020-01-27 23:11:58',15,'متن باز',3,'2020-01-27 23:11:58',40);
INSERT INTO category_tbl (id,created_at,title,updated_at) VALUES (5000,'2020-01-27 23:11:58','اطلاعیه','2020-01-27 23:11:58');
INSERT INTO category_tbl (id,created_at,title,updated_at) VALUES (5001,'2020-01-27 23:11:58','تغییرات','2020-01-27 23:11:58');
INSERT INTO category_tbl (id,created_at,title,updated_at) VALUES (5002,'2020-01-27 23:11:58','دانشجویی','2020-01-27 23:11:58');


create table category (

	id IDENTITY,
	name VARCHAR(50) not null,
	description VARCHAR(255) not null,
	is_active BOOLEAN not null,
	
	constraint pk_category_id PRIMARY KEY (id)
	
);

create table product (

	pid IDENTITY primary key,
	pname VARCHAR(50) not null,
	pdesc VARCHAR(255) not null,
	pimage VARCHAR(50) not null,
	price number(9)not null,
	pcolor VARCHAR(20) not null,
	id NUMBER(4) not null,
	is_active BOOLEAN not null,
	constraint fk_key_category foreign key (id) references category(id)
	
);


create table supplier (
	
	sid IDENTITY primary key,
	sname VARCHAR(50) not null,
	sdesc VARCHAR(255) not null,
	is_active BOOLEAN not null

);

create table stock (
	
	stockid IDENTITY primary key,
	pid number(4) foreign key references product(pid) on delete cascade,
	sid number(4) foreign key references supplier(sid) on delete cascade,
	price number(9) not null,
	quantity number(9) not null,
	is_active boolean not null
	
);

insert into product values(4,'j2 2016','j2 desc is here','j2.png',19000,3,true);
insert into product values(5,'j2 2017','j2 2017 desc is here','j27.png',21000,3,true);
insert into product values(6,'note 4','note 4 desc is here','j2.png',24000,3,true);



insert into Category values(1,'Samsung','This is Samsung description',true);
insert into Category values(2,'HTC','This is HTC description',true);
insert into Category values(3,'Vivo','This is Vivo description',true);
insert into Category values(4,'Lenovo','This is Lenovo description',true);
insert into Category values(5,'Gionee','This is Gionee description',true);
insert into Category values(6,'LG','This is LG description',true);
insert into Category values(7,'Motorola','This is Motorola description',true);
insert into Category values(8,'Panasonic','This is Panasonic description',true);
insert into Category values(9,'OnePlus','This is OnePlus description',true);


insert into Product values(1,'Galaxy A9 pro','This is Galaxy A9 pro desc','image',32490,1,true);
insert into Product values(2,'Galaxy A5 (2016)','This is Galaxy A5 (2016) desc','image',21900,1,true);
insert into Product values(3,'Galaxy A7 (2016)','This is Galaxy A7 (2016) desc','image',25900,1,true);
insert into Product values(4,'Galaxy J5 prime','This is Galaxy J5 prime desc','image',14790,1,true);
insert into Product values(5,'Galaxy J1','This is Galaxy J1 desc','image',6890,1,true);
insert into Product values(6,'Galaxy J2 Ace','This is Galaxy J2 Ace desc','image',8490,1,true);
insert into Product values(7,'Galaxy J2 pro','This is Galaxy J2 pro desc','image',9490,1,true);
insert into Product values(8,'Galaxy J7 prime','This is Galaxy J7 prime desc','image',16900,1,true);
insert into Product values(9,'Galaxy Note 5','This is Galaxy Note 5 desc','image',43900,1,true);
insert into Product values(10,'Galaxy On Nxt','This is Galaxy On Nxt desc','image',16900,1,true);
insert into Product values(11,'Galaxy On 8','This is Galaxy On 8 desc','image',14900,1,true);
insert into Product values(12,'Galaxy S7','This is Galaxy S7 desc','image',43400,1,true);
insert into Product values(13,'Galaxy S7 Edge','This is Galaxy S7 Edge desc','image',50900,1,true);


insert into Product values(14,'10','This is HTC 10 desc','image',42999,2,true);
insert into Product values(15,'Desire 620G','This is Desire 620G desc','image',6649,2,true);
insert into Product values(16,'Desire 626','This is Desire 626 desc','image',10490,2,true);
insert into Product values(17,'Desire 628','This is Desire 628 desc','image',11999,2,true);
insert into Product values(18,'One A9','This is One A9 desc','image',23789,2,true);
insert into Product values(19,'One M8 Eye','This is One M8 Eye desc','image',17199,2,true);
insert into Product values(20,'One X9','This is One X9 desc','image',21790,2,true);


insert into Product values(21,'V3','This is V3 desc','image',17499,3,true);
insert into Product values(22,'V5','This is V5 desc','image',17999,3,true);
insert into Product values(23,'V5 pro','This is V5 plus desc','image',27999,3,true);


insert into Product values(24,'Vibe K5 Note','This is Vibe K5 Note desc','image',11999,4,true);
insert into Product values(25,'Vibe K5 Plus','This is Vibe K5 Plus desc','image',8499,4,true);
insert into Product values(26,'Vibe P1m','This is Vibe P1m desc','image',6999,4,true);


insert into Product values(27,'Elife S7','This is Elife S7 desc','image',15500,5,true);
insert into Product values(28,'F103 3GB','This is F103 3GB desc','image',11949,5,true);
insert into Product values(29,'F103 pro','This is F103 pro desc','image',10999,5,true);
insert into Product values(30,'Marathon M5 lite','This is Marathon M5 lite desc','image',11998,5,true);
insert into Product values(31,'S6s','This is S6s desc','image',15999,5,true);

insert into Product values(32,'H860 G5','This is H860 G5 desc','image',33983,6,true);
insert into Product values(33,'K10','This is K10 desc','image',11990,6,true);
insert into Product values(34,'Nexus 5','This is Nexus 5 desc','image',13299,6,true);
insert into Product values(35,'Stylus 2','This is Stylus 2 desc','image',14689,6,true);
insert into Product values(36,'V20','This is V20 desc','image',47990,6,true);
insert into Product values(37,'X Screen K500I','This is X Screen K500I desc','image',11990,6,true);
insert into Product values(38,'XCam K580I','This is XCam K580I desc','image',13719,6,true);

insert into Product values(39,'Moto E3 power','This is Moto E3 Power desc','image',7999,7,true);
insert into Product values(40,'Moto G Turbo','This is Moto G Turbo desc','image',9999,7,true);
insert into Product values(41,'Moto M','This is Moto M desc','image',15999,7,true);
insert into Product values(42,'Moto Z Play','This is Moto Z Play desc','image',24999,7,true);


insert into Product values(43,'Eluga A2','This is Eluga A2 desc','image',8999,8,true);
insert into Product values(44,'Eluga Mark2','This is Eluga Mark2 desc','image',10499,8,true);
insert into Product values(45,'Eluga Note','This is Eluga Note desc','image',9999,8,true);
insert into Product values(46,'Eluga Turbo','This is Eluga Turbo desc','image',9990,8,true);
insert into Product values(47,'P55 Novo','This is P55 Novo desc','image',8545,8,true);


insert into Product values(48,'2','This is OnePlus 2 desc','image',19999,9,true);
insert into Product values(49,'3','This is OnePlus 3 desc','image',25000,9,true);
insert into Product values(50,'3T','This is OnePlus 3T desc','image',29999,9,true);
insert into Product values(51,'One','This is OnePlus One desc','image',9999,9,true);


create table usertable (
	uid IDENTITY primary key,
	pno varchar(10) not null unique,
	email varchar(100) not null unique,
	pw varchar(20) not null,
	fname varchar(20) not null,
	lname varchar(20) not null,
	add1 varchar(100) not null,
	add2 varchar(100) not null,
	add3 varchar(100) not null,
	city varchar(100) not null,
	state varchar(100) not null,
	pincode number(6) not null,
	role varchar(15) not null,
	cartid number(10),
	is_active boolean not null
	
);

insert into usertable values (2,1122330055,'ww@dc.com','admin','wolly','west','hsdvh','hjasdvfhj','jhasdj','central city','US','666666','ADMIN',true);
insert into usertable values (1,9920188240,'mv@dc.com','mayur','Mayur','Vaity','hsdvh','hjasdvfhj','jhasdj','central city','US','666666','USER',true);

create table address (

	addid IDENTITY primary key,
	aid number(4) not null,
	add1 varchar(100) not null,
	add2 varchar(100) not null,
	add3 varchar(100) not null,
	city varchar(100) not null,
	state varchar(100) not null,
	pincode number(6) not null,
	is_active boolean not null
);

create table cart (

	cartid IDENTITY primary key,
	items number(5),
	totalcost number(15) ,
	is_active boolean not null
	
);

create table cartitem (

	itemid IDENTITY primary key,
	userid number(5) not null,
	pid number(5) not null,
	iprice number(9) not null,
	iquantity number(4) not null,
	itotal number(15) not null,
	oid number(6),
	is_active boolean not null,
	constraint fk_key_user foreign key (userid) references usertable(uid),
	constraint fk_key_product foreign key (pid) references product(pid)
	
	
);

insert into cartitem values (1,33,70,42999,2,85998,true);
insert into cartitem values (2,33,100,8000,3,24000,true);

create table ordertable (

	orderid IDENTITY primary key,
	uid number(6) not null,
	addid number(6),
	amount number(15) not null,
	is_active boolean not null,
	is_delivered boolean not null,
	constraint fk_key_userx foreign key (uid) references usertable(uid),
	constraint fk_key_addrs foreign key (addid) references address(addid)

);

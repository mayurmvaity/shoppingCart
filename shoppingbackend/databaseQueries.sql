create table category (

	id IDENTITY,
	name VARCHAR(50) not null,
	description VARCHAR(255) not null,
	image_url VARCHAR(50) not null,
	is_active BOOLEAN not null,
	
	constraint pk_category_id PRIMARY KEY (id)
	
);

create table product (

	pid IDENTITY primary key,
	pname VARCHAR(50) not null,
	pdesc VARCHAR(255) not null,
	pimage VARCHAR(50) not null,
	price number(9)not null,
	cid NUMBER(4) references category(id) on delete cascade,
	is_active BOOLEAN not null
	
);

create table supplier (
	
	sid IDENTITY primary key,
	sname VARCHAR(50) not null,
	sdesc VARCHAR(255) not null,
	is_active BOOLEAN not null

);

create table stock (
	
	stockid IDENTITY primary key,
	pid number(4) references product(pid) on delete cascade,
	sid number(4) references supplier(sid) on delete cascade,
	price number(9) not null,
	quantity number(9) not null,
	is_active boolean not null
	
);
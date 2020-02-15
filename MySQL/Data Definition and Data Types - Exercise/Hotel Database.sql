create table employees(
   id INT,
  first_name varchar(50) not null,
  last_name varchar(50),
  title varchar(50),
  notes blob
  ,PRIMARY KEY (id)
);
insert into employees(id,first_name)values(1,'dasd'),(2,'dasd'),(3,'dasd');

create table customers (
   account_number int not null,
   first_name varchar(50) not null, 
	last_name varchar(50),
	phone_number varchar(10),
	emergency_name varchar(50),
	emergency_number varchar(10),
	notes blob,
	primary key(account_number)
);
insert into customers(account_number,first_name)values(1,'dasd'),(2,'dasd'),(3,'dasd');
create table room_status (
   room_status int not null,
   notes blob,
   primary key(room_status)
);
insert into room_status(room_status)values(1),(2),(3);

create table room_types(
   room_type INT not null,
   notes blob not null,
   primary key(room_type)
);
insert into room_types(room_type,notes)values(1,'sasas'),(2,'sasas'),(3,'sasasa');

create table bed_types(
  bed_type INT not null,
  notes blob not null,
  primary key(bed_type)
);
insert into bed_types(bed_type,notes)values(1,'sasas'),(2,'sasas'),(3,'sasasa');

create table rooms(
   room_number int not null, 
   room_type varchar(50),
   bed_type varchar(50),
   rate varchar(50), 
   room_status varchar(50), 
   notes blob not null, 
   primary key(room_number)
);
insert into rooms(room_number,notes)values(1,'sasas'),(2,'sasas'),(3,'sasasa');

create table payments(
   id INT not null,
   employee_id int,
   payment_date datetime, 
   account_number varchar(10), 
   first_date_occupied datetime, 
   last_date_occupied datetime, 
   total_days INT, 
   amount_charged double(10,2), 
   tax_rate double(10,2), 
   tax_amount double(10,2), 
   payment_total double(10,2), 
   notes blob not null, 
   primary key(id)
);
insert into payments(id,notes)values(1,'sasas'),(2,'sasas'),(3,'sasasa');

create table occupancies(
  id int, 
  employee_id int ,
  date_occupied datetime,
  account_number varchar(10),
  room_number int,
  rate_applied varchar(10), 
  phone_charge varchar(10), 
  notes blob not null, 
  primary key(id)
);
insert into occupancies(id,notes)values(1,'sasas'),(2,'sasas'),(3,'sasasa');
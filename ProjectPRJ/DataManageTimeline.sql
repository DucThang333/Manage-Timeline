--create data base
create database ManageTimeline
	
--use database
go
	use ManageTimeline
go

go
	drop table Account
go

-- check data
go
	-- command table Account
	select * from Account
	select * from Account where idAccount = 022
	select * from Account where nameAccount = 'ABC'

	-- command table ItemsInfor
	select * from ItemsInfor
go 

--create table account
go 
	create table Account (IDAccount varchar(50) primary key ,
	NameAccount varchar(50) not null,usernameAccount varchar(50) not null unique,PasswordAccount varchar(50) not null,
	PhoneAccount int not null, IMGAccount varchar(100) not null,DateJoin date not null)
go

-- create table items information
go
	create table ItemsInfor(IDItems varchar(50) primary key , 
	IDAccount varchar(50) foreign key references Account(IDAccount),
	Title varchar(50) not null ,DateStart date not null,DateEnd date not null,Detail varchar(50))
go 


--example data
go 
	-- insert table account
	insert into Account
	values('02322','thang','thang1804','thang2001',0123456789,'jdbc.jbg','2000-12-3')
	insert into Account
	values('022','ABC','ABCtest','123456',01256789,'jdbc1.jbg','2010-09-13')
	insert into Account
	values('0234','hai','hai123','0123',012345,'jdbc2.jbg','2022-12-17')

	-- insert table ItemsInfor
	insert into ItemsInfor
	values('2222','022','game','2000-10-2','2001-12-3','Stream game 8h')
	insert into ItemsInfor
	values('2223','022','learning','2005-6-18','2007-10-3','learning 4h perday')
	insert into ItemsInfor
	values('2224','0234','cooking','2007-9-12','2008-11-13','cooking from teacher(david)')
	insert into ItemsInfor
	values('2225','02322','travel','2000-11-2','2009-12-3','travel to china , korea')
	insert into ItemsInfor
	values('2226','022','video','2000-10-2','2001-12-3','video')
	insert into ItemsInfor
	values('2227','022','SQL','2000-10-2','2001-12-3','SQL')
go


--create data base
create database ManageTimeline
	
--use database
go
	use ManageTimeline
go

-- check data
go
	select * from Account	
go 

--create table account
go 
	create table Account (IDAccount varchar(50) primary key ,
	NameAccount varchar(50) not null unique,PasswordAccount varchar(50) not null ,
	PhoneAccount int not null, IMGAccount varchar(100) not null)
go


--example data
go 
	insert into Account
	values('02322','thang','thang2001',0123456789,'jdbc.jbg')
	insert into Account
	values('022','ABC','123456',01256789,'jdbc1.jbg')
	insert into Account
	values('0234','123','0123',012345,'jdbc2.jbg')
go


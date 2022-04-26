s--create data base
create database ManageTimeline
drop database ManageTimeline
	
--use database
go
	use ManageTimeline
go

go
 drop table Account
 drop table ItemsInfor
 drop table settting
go

-- delete data
go
	-- delete from ItemsInfor where IDItems = '2228' 
go


-- check data
go
	-- command table Account
	select * from Account
	select * from Account where idAccount = '022'
	select * from Account where nameAccount = 'ABC'

	-- command table ItemsInfor
	select * from ItemsInfor where IDAccount = 'A456';
	select * from ItemsInfor where IDAccount = '022' and IDItems = '2222'
	select max(DateEnd)from ItemsInfor where IDAccount = '022'
	select * from ItemsInfor where IDAccount = '022' order by DateStart,dateEnd;
	delete from ItemsInfor where IDAccount = '022' and IDItems = '100011'
	select title , dateStart,idItems from ItemsInfor where IDAccount = '022' order by title ,dateStart;
	select * from ItemsInfor where IDAccount = '022' and title = 'learning' and dateStart = '2005-06-18'
	select * from ItemsInfor where IDAccount = '022' and title = 'game' and dateStart = '2000-10-02'

	Update ItemsInfor
	Set submit = 'false'
	where IDAccount = 'A456'

	UPDATE ItemsInfor
	SET		Title = 'abc' ,DateStart = '2000-12-03',DateEnd = '2001-01-01', Detail  = 'ab' ,Background = '111' 
	WHERE IDItems = '022.1650860715418' and IDAccount = '022';
	select * from ItemsInfor where IDAccount = '022'
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
	Title varchar(50) not null ,DateStart date not null,DateEnd date not null,Detail varchar(50),
	Background varchar(200) not null , submit bit not null)
	alter table ItemsInfor
	add typeItems varchar(50)
go 
select * from ItemsInfor where IDAccount = 'A456' order by DateStart,dateEnd

go 
	create table SubItemsInfor(IDSub varchar(50) primary key , 
	IDItems varchar(50) foreign key references  ItemsInfor(IDItems),
	Title varchar(50) not null ,DateStart date not null,DateEnd date not null,Detail varchar(50), submit bit not null)

go 

go
	create table scoreboard(idScore varchar(50) unique not null,
	submit bit, point int)
	alter table scoreboard
		ADD constraint FK_IDItems_idScore foreign key(idScore) references  ItemsInfor(IDItems)
go

select * from setting

go 
	create table setting(IDSetting varchar(50) unique not null)
	-----
	alter table setting
		add constraint FK_IDAccount_IDSetting foreign key(IDSetting) references Account(IDAccount)
go 



go 
	create table 
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
	insert into Account
	values('A456','thang','thang2001','123456',0123455,'jdbc2.jbg','2022-04-25') 
	insert into Account
	values('A456','thang','thang20011','1234561',01234551,'a','2022-04-25') 

	-- insert table ItemsInfor
	insert into ItemsInfor
	values('2222','022','game','2000-10-2','2001-12-3','Stream game 8h','#d6ecd6')
	insert into ItemsInfor
	values('2223','022','learning','2005-6-18','2007-10-3','learning 4h perday','#d6ecd6')
	insert into ItemsInfor
	values('2224','0234','cooking','2007-9-12','2008-11-13','cooking from teacher(david)' , '#d6ecd6')
	insert into ItemsInfor
	values('2225','02322','travel','2000-11-2','2009-12-3','travel to china , korea' , '#d6ecd6')
	insert into ItemsInfor
	values('2226','022','video','2000-10-2','2001-12-3','video', '#d6ecd6')
	insert into ItemsInfor
	values('2227','022','SQL','2000-10-2','2001-12-3','SQL', '#d6ecd6')
	insert into ItemsInfor
	values('2229','022','123','2000-10-2','2001-12-3','SQL', '#d6ecd6')
	insert into ItemsInfor
	values('A456.1650894020169','A456','game','2022-03-28','2022-04-30','','#b1ecb1')





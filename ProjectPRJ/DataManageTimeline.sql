--create data base
create database ManageTimeline
--drop database ManageTimeline
	
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
	select * from ItemsInfor where IDAccount = 'Apr271541332022';
	select * from ItemsInfor where IDAccount = '022' and IDItems = '2222'
	select max(DateEnd)from ItemsInfor where IDAccount = '022'
	select * from ItemsInfor where IDAccount = '022' order by DateStart,dateEnd;
	delete from ItemsInfor where IDAccount = '022' and IDItems = '100011'
	select title , dateStart,idItems from ItemsInfor where IDAccount = '022' order by title ,dateStart;
	select * from ItemsInfor where IDAccount = '022' and title = 'learning' and dateStart = '2005-06-18'
	select * from ItemsInfor where IDAccount = '022' and title = 'game' and dateStart = '2000-10-02'

	Update Account
	Set DateJoin = '2022-04-13'
	where IDAccount = 'Apr271541332022'

	UPDATE ItemsInfor
	SET		Title = 'abc' ,DateStart = '2000-12-03',DateEnd = '2001-01-01', Detail  = 'ab' ,Background = '111' 
	WHERE IDItems = '022.1650860715418' and IDAccount = '022';
	select * from ItemsInfor where IDAccount = '022'
go 

--create table account
go 
	create table Account (IDAccount varchar(250) primary key ,
	NameAccount varchar(250) not null,usernameAccount varchar(250) not null unique,PasswordAccount varchar(250) not null,
	PhoneAccount int not null, IMGAccount varchar(300) not null,DateJoin date not null)
go

-- create table items information
go
	create table ItemsInfor(IDItems varchar(250) primary key , 
	IDAccount varchar(250) foreign key references Account(IDAccount),
	Title varchar(250) not null ,DateStart date not null,DateEnd date not null,Detail varchar(250),
	Background varchar(200) not null ,typeItems varchar(250),submit bit not null)
	alter table ItemsInfor
		ADD FOREIGN KEY (typeItems) REFERENCES typeInfor(typeItems);
go 
select * from ItemsInfor where IDAccount = 'A456' order by DateStart,dateEnd


drop table typeInfor


go
	create table typeInfor( typeItems varchar(250) primary key , detail varchar(250))
go


go 
	create table SubItemsInfor(IDSub varchar(250) primary key , 
	IDItems varchar(250) foreign key references  ItemsInfor(IDItems),
	idScore varchar(250) foreign key references  scoreboard(idScore),
	Title varchar(350) not null ,DateStart date not null,DateEnd date not null,Detail varchar(350), submit bit not null)
go 

go
	create table scoreboard(idScore varchar(250) unique  not null,
	process int not null, point int) 
	alter table scoreboard
		add constraint FK_idScore_IDItems foreign key(idScore) references ItemsInfor(IDItems)
go

select * from setting
drop table setting

go 
	create table setting(IDSetting varchar(250) unique not null)
	-----
	alter table setting
		add constraint FK_IDAccount_IDSetting foreign key(IDSetting) references Account(IDAccount)
go 



go 
	create table 
go 


--example data
select * from ItemsInfor

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
	values('Apr271541332022.345','Apr271541332022','game','2022-04-12','2022-05-3','Stream game 8h','#d6ecd6','game','false')
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





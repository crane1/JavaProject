drop table Books;
create table Books(
     Id varchar(25) not null primary key,
     Name varchar(25),
     Author varchar(25),
     Publish varchar(25),
     TotalNum number(10),
     RemainderNum number(10),
     Type varchar(25)
);
commit;

select * from Books;

drop table Users;
create table Users(
     Id varchar(25) not null primary key,
     Pwd varchar(25),
     Name varchar(25)
);


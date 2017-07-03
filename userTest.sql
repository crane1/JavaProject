create table userTest(
id number(20),
pwd varchar(20)
)


insert into userTest values(1, '123');

select u.id, u.pwd from userTest u

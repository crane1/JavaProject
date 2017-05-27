select * from users;

insert into users values('1','123','李泽明')
insert into users values('crane1','LZztiove930531','李泽明')

select id, name from users where id=1

alter table users modify(id varchar(25))
alter table users add(qx number(5))

delete from users;

--删除一个表
drop table account;
--创建一个表
create table account(id varchar(20), pwd varchar(20), sex char(5), address varchar(30), telephone number(12));

--插入数据
insert into account values('admin', 'admin', '男', '电脑里', 186324239);
insert into account values('lizeming', 'lizeming', '男', '天坛西路', 1863545454);
insert into account values('了覅当', '附近的积分', '辅', '佛挡杀佛', 7454446464);
insert into account values('aaa', 'bbb', '女', '大家发动机', 1863545);
insert into account values('admin', 'admin', '男', '电脑里', 186324239);

--查询所有数据
select * from account;

--查询去重后的数据
select distinct * from account;

--查询几列数据
select id, pwd from account;

--根据条件删除数据
delete from account where id = '了覅当';

--链接列 ,重命名
select id || sex  as info from account;

--插入一列数据
alter table account add age number(5);

--修改数据，添加 age
update account set age = 18 where id = 'admin';
update account set age = 22 where id = 'lizeming';
update account set age = 67 where id = 'aaa';

-- + ,-, *, / 号，使用
select telephone, age, telephone + age as 和,
       telephone - age as 差,telephone * age as 积,
       telephone / age as 商 from account;

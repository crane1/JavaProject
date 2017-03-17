-- 创建表
create table employee(
       id number(4) not null,
       name varchar2(20) not null,
       gender char(1) default 'M',
       birth date,
       salary number(6,2),
       comm number(6,2),
       job varchar2(30),
       manager number(4),
       deptno number(2));

-- 查询表结构
desc employee;

--修改表名
rename employee to myemp;

--向表中插入一列
alter table myemp add(hiredate date default sysdate);

--修改表中列 长度
alter table myemp modify(job varchar2(40) default 'CLERK');

--删除一列
alter table myemp drop(hiredate);

--插入数据
insert into table myemp(id, name,)

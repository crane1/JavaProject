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
--desc employee;

--修改表名
rename employee to myemp;

--向表中插入一列
alter table myemp add(hiredate date default sysdate);

--修改表中列 长度
alter table myemp modify(job varchar2(40) default 'CLERK');

--删除一列
alter table myemp drop(hiredate);

--插入数据
insert into  myemp(id, name, job, salary)
       values(1001, 'rose', 'PROGRAMMER', 5500);
insert into  myemp(id, name, job, birth)
       values(1002, 'martha', 'ANALYST', '01-9月-89');    
insert into  myemp(id, name, job, birth)
       values(1003, 'DONNA', 'MANAGER', 
       to_date('1978-09-01', 'YYYY-MM-DD'));   

--删除表中所有记录
--delete from myemp; 

--将员工表中姓名为rose的员工的工资更改为8500
update myemp set salary = 8500 where name = 'rose';

--将员工表中id为1003的员工工资更改为6500，职位更改为‘ANALYST’
update myemp set salary = 6500, job = 'ANALYST' where id = 1003;


--删除员工表中职位为空的员工记录
delete from myemp where job is null; 

--删除员工表中名字为‘rose’的员工
delete from myemp where name = 'rose';
select * from myemp where name = 'rose';
select * from myemp;

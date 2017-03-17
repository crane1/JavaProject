-- 查看用户表
select * from tab;

-- 创建dept表
create table dept 
       (deptno number(2),
        dname varchar2(14),
        loc varchar2(13));

insert into dept values
       (10, 'ACCOUNTING', 'NEW YORK');   
insert into dept values
       (20, 'RESEARCH', 'DALLAS'); 
insert into dept values
       (30, 'SALES', 'CHICAGO'); 
insert into dept values
       (10, 'OPERATIONS', 'BOSTON');   
select * from dept;

-- 创建emp表
creat table emp
      (empno number(4),
       ename varchar2(10),
       job varchar2(9),
       mgr number(4),
       hiredate date,
       sal number(7,2),
       comm number(7,2),
       deptno number(2)
       );                               

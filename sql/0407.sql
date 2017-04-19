/*1.写出从emp表获取所有工资小于800或工资大于2000，各个部门的员工个数。
注意：少于或等于一个人不需要统计*/

select * from emp;
select * from (
    select deptno, count(deptno) as num 
    from emp 
    where sal < 800 or sal > 2000 group by deptno) 
where num > 1;

select * from emp where job = 'ANALYST'
or ename like 'J%';

select * from(
       select rownum ru, emp.* from emp where rownum < 11) ts 
where ts.ru > 5;

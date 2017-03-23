select * from employees;
insert into employees(
       employee_id, 
       last_name,
       email,
       hire_date,
       job_id)
values(510,
       'ZeMing',
       '820169813@qq.com',
       to_date('3ÔÂ 30, 2017','MON DD, YYYY'),
       'IT_PROG');
       
delete from employees where employees.department_id = 60; 

select deptno, ename, empno,
       row_number()
       over (partition by deptno order by empno)      
       as emp_id
       from emp;
       
select ename,job,sal from emp
where job = 'MANAGER'      
union ALL
select ename, job, sal from emp
where sal > 2500;

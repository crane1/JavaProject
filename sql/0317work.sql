
--1.查询员工表中第6到第12条数据
select em.* from
       (select 
            row_number() over(order by rowid) rank, 
            e.* 
        from employees e) em 
where rank >= 6 and rank <= 12;
select em.* from employees em;

--2.查询工资最高的第6到第12条员工

select em.* from
       (select 
            rank() over(order by salary desc) rank, 
            e.*
        from employees e) em 
where rank >= 6 and rank <= 12;

3.查询和149号员工同一个部门的其他员工

select e.*
from employees e
where
     e.department_id = (
     select department_id 
     from employees e1
     where e1.employee_id = 149)
4.查询员工编号，姓名，部门编号，工资，本部门的工资总和
select e.employee_id,
       e.first_name || e.last_name name,
       e.department_id,
       e.salary,
       nvl((select sum(salary)
             from employees e1
            where e.department_id = e1.department_id),
           e.salary) sum
  from employees e


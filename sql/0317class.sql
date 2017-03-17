select e.employee_id 员工编号, 
       e.first_name || e.last_name 姓名,
       e.department_id 部门编号,
       d.department_name 部门名称
from employees e, departments d
where e.department_id = d.department_id(+);

/*--笔记
 内连接 inner join  只查询出满足条件的记录
 外链接 outer join  
 左连接 left outer join
 右链接 right outer join
 满外链接 full outer join*/
select e.employee_id 员工编号, 
       e.first_name || e.last_name 姓名,
       e.department_id 部门编号,
       d.department_name 部门名称
from employees e 
     cross join departments d
where e.department_id = d.department_id;

-- 右链接
select e.employee_id 员工编号, 
       e.first_name || e.last_name 姓名,
       e.department_id 部门编号,
       d.department_name 部门名称
from employees e 
      right join departments d 
on e.department_id = d.department_id;

-- 左链接
select e.employee_id 员工编号, 
       e.first_name || e.last_name 姓名,
       e.department_id 部门编号,
       d.department_name 部门名称
from employees e 
      left join departments d 
on e.department_id = d.department_id;

-- 满链接
select e.employee_id 员工编号, 
       e.first_name || e.last_name 姓名,
       e.department_id 部门编号,
       d.department_name 部门名称
from employees e 
      full join departments d 
on e.department_id = d.department_id;
/*
count 返回列中不重复的记录*/

create table Student(id number(20), name varchar(25), sex char(5));
insert into Student values(1, '乐乐', '女');
insert into Student values(2, '豆豆', '母');
insert into Student values(3, '花花', '女');
insert into Student values(4, '欢欢', '男');
insert into Student values(5, '丹丹', '女');
select * from Student;

select sex,name, id from Student group by sex, name, id;

select e.last_name, e.salary from employees e 
where
       e.salary > (select salary from employees where last_name = 'Abel');
       
select e.last_name, e.salary from employees e
where 
       e.salary = (select salary from employees where employee_id = '101');
       
select * from employees;

select department_id, count(department_id )
from employees 
group by department_id;

select * from departments

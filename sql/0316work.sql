select * from employees;
select * from departments;
select * from jobs;
select * from locations;
select * from job_history;
select * from regions;
select * from job_grades;
create  table job_grade as 
select distinct * from job_grades order by grade_level;

select * from job_grade;

drop table job_grades;

alter table job_grade rename to job_grades;
--1.查询员工编号，姓名，部门编号,部门名称（表别名）

select e.employee_id 员工编号, 
        e.first_name || ' ' || e.last_name 姓名,
       e.department_id 部门编号,
       d.department_name 部门名称
from employees e, departments d
where e.department_id = d.department_id;

--2.查询员工编号，姓名，部门编号,部门名称，职务编号，职务名称

select e.employee_id 员工编号, 
       e.first_name || ' ' || e.last_name 姓名,
       e.department_id 部门编号,
       d.department_name 部门名称,
       j.job_id 职务编号,
       j.job_title 职务名称
from employees e, departments d, jobs j
where e.department_id = d.department_id 
      and e.job_id = j.job_id;
      
--3.查询所有部门的编号，部门名称，部门经理ID，部门经理姓名，部门所在的城市，国家，地区

select d.department_id 部门编号，
       d.department_name 部门名称,
       d.manager_id 部门经理ID,
       e.first_name || ' ' || e.last_name 部门经理姓名,
       l.city 部门所在的城市,
       c.country_name 国家,
       l.state_province 地区
from employees e, departments d, locations l, countries c
where d.manager_id = e.manager_id 
      and d.location_id = l.location_id
      and l.country_id = c.country_id;
      
--4.查看员工职务变更历史记录：员工编号，姓名，起始日期，终止日期，职务名称，部门名称

select e.employee_id 员工编号, 
       e.first_name || ' ' || e.last_name 姓名,
       e.hire_date 起始日期,
       jh.end_date 终止日期,
        j.job_title 职务名称,
       d.department_name 部门名称    
from employees e, departments d, jobs j, job_history jh
where e.department_id = d.department_id(+)
      and e.employee_id = jh.employee_id(+)
      and e.job_id = j.job_id(+);
      
--5.查询每个员工编号，姓名，工资，工资级别（非等值连接）

select e.employee_id 员工编号, 
       e.first_name || ' ' || e.last_name 姓名,
       e.salary 工资,
       jg.grade_level 工资级别
from employees e, job_grades jg
where e.salary 
      between jg.lowest_sal 
      and jg.highest_sal;
--6.查询员工编号，姓名，工资，奖金金额，实发工资（工资+奖金）

select e.employee_id 员工编号, 
       e.first_name || ' ' || e.last_name 姓名,
       e.salary 工资,
       e.commission_pct * e.salary 奖金金额,
       e.salary + e.commission_pct * e.salary 实发工资    
from employees e;

--7.查询10号，20号和没有部门的员工(不用is null is not null实现)

select e.employee_id 员工编号, 
       e.first_name || ' ' || e.last_name 姓名,
       d.department_id 部门编号,
       d.department_name 部门名称    
from employees e, departments d
where e.department_id = d.department_id(+)
     and  lnnvl(e.department_id > 20) ;

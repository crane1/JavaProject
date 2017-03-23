select * from user_tables;
select * from student;
alter table student drop (name, sex);
rollback;
comment on table student is '这是一个修改后的心机婊';
select * from recyclebin;

/*查询每个部门编号名称，员工人数，员工工资总和*/
create or replace view u 
as 
select department_id 部门编号,count(employee_id) 部门人数,sum(salary) 工资总额 from employees group by department_id;

select * from  u;
drop view u;

select * from employees;

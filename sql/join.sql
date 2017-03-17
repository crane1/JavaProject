select employees.employee_id, 
       employees.department_id, 
       departments.department_name
from employees, departments
where employees.department_id = departments.department_id;

select e.employee_id, 
       e.first_name, 
       d.department_id,
       d.department_name,
       j.job_id,
       j.job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id and
      e.job_id = j.job_id;

-- �����ӣ�+�ŵ�λ�ñ�ʾ������λ��
select e.employee_id, e.department_id,d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);

select * from departments;
select * from employees;

create table manager(manager_id number(20), manager_name varchar(20));
insert into manager values(200,'����');
insert into manager values(201,'����');
insert into manager values(124,'����');
insert into manager values(103,'����');
insert into manager values(149,'Ǯ��');
insert into manager values(100,'���');
insert into manager values(205,'�ܾ�');

select * from manager;

select e.*, m.employee_id nanage_id, m.first_name manage_name
from employees e,employees m
where e.manager_id = m.employee_id(+)
;


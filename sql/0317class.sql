select e.employee_id Ա�����, 
       e.first_name || e.last_name ����,
       e.department_id ���ű��,
       d.department_name ��������
from employees e, departments d
where e.department_id = d.department_id(+);

/*--�ʼ�
 ������ inner join  ֻ��ѯ�����������ļ�¼
 ������ outer join  
 ������ left outer join
 ������ right outer join
 �������� full outer join*/
select e.employee_id Ա�����, 
       e.first_name || e.last_name ����,
       e.department_id ���ű��,
       d.department_name ��������
from employees e 
     cross join departments d
where e.department_id = d.department_id;

-- ������
select e.employee_id Ա�����, 
       e.first_name || e.last_name ����,
       e.department_id ���ű��,
       d.department_name ��������
from employees e 
      right join departments d 
on e.department_id = d.department_id;

-- ������
select e.employee_id Ա�����, 
       e.first_name || e.last_name ����,
       e.department_id ���ű��,
       d.department_name ��������
from employees e 
      left join departments d 
on e.department_id = d.department_id;

-- ������
select e.employee_id Ա�����, 
       e.first_name || e.last_name ����,
       e.department_id ���ű��,
       d.department_name ��������
from employees e 
      full join departments d 
on e.department_id = d.department_id;
/*
count �������в��ظ��ļ�¼*/

create table Student(id number(20), name varchar(25), sex char(5));
insert into Student values(1, '����', 'Ů');
insert into Student values(2, '����', 'ĸ');
insert into Student values(3, '����', 'Ů');
insert into Student values(4, '����', '��');
insert into Student values(5, '����', 'Ů');
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

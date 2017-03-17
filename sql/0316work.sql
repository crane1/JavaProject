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
--1.��ѯԱ����ţ����������ű��,�������ƣ���������

select e.employee_id Ա�����, 
        e.first_name || ' ' || e.last_name ����,
       e.department_id ���ű��,
       d.department_name ��������
from employees e, departments d
where e.department_id = d.department_id;

--2.��ѯԱ����ţ����������ű��,�������ƣ�ְ���ţ�ְ������

select e.employee_id Ա�����, 
       e.first_name || ' ' || e.last_name ����,
       e.department_id ���ű��,
       d.department_name ��������,
       j.job_id ְ����,
       j.job_title ְ������
from employees e, departments d, jobs j
where e.department_id = d.department_id 
      and e.job_id = j.job_id;
      
--3.��ѯ���в��ŵı�ţ��������ƣ����ž���ID�����ž����������������ڵĳ��У����ң�����

select d.department_id ���ű�ţ�
       d.department_name ��������,
       d.manager_id ���ž���ID,
       e.first_name || ' ' || e.last_name ���ž�������,
       l.city �������ڵĳ���,
       c.country_name ����,
       l.state_province ����
from employees e, departments d, locations l, countries c
where d.manager_id = e.manager_id 
      and d.location_id = l.location_id
      and l.country_id = c.country_id;
      
--4.�鿴Ա��ְ������ʷ��¼��Ա����ţ���������ʼ���ڣ���ֹ���ڣ�ְ�����ƣ���������

select e.employee_id Ա�����, 
       e.first_name || ' ' || e.last_name ����,
       e.hire_date ��ʼ����,
       jh.end_date ��ֹ����,
        j.job_title ְ������,
       d.department_name ��������    
from employees e, departments d, jobs j, job_history jh
where e.department_id = d.department_id(+)
      and e.employee_id = jh.employee_id(+)
      and e.job_id = j.job_id(+);
      
--5.��ѯÿ��Ա����ţ����������ʣ����ʼ��𣨷ǵ�ֵ���ӣ�

select e.employee_id Ա�����, 
       e.first_name || ' ' || e.last_name ����,
       e.salary ����,
       jg.grade_level ���ʼ���
from employees e, job_grades jg
where e.salary 
      between jg.lowest_sal 
      and jg.highest_sal;
--6.��ѯԱ����ţ����������ʣ������ʵ�����ʣ�����+����

select e.employee_id Ա�����, 
       e.first_name || ' ' || e.last_name ����,
       e.salary ����,
       e.commission_pct * e.salary ������,
       e.salary + e.commission_pct * e.salary ʵ������    
from employees e;

--7.��ѯ10�ţ�20�ź�û�в��ŵ�Ա��(����is null is not nullʵ��)

select e.employee_id Ա�����, 
       e.first_name || ' ' || e.last_name ����,
       d.department_id ���ű��,
       d.department_name ��������    
from employees e, departments d
where e.department_id = d.department_id(+)
     and  lnnvl(e.department_id > 20) ;
select * from user_tables;
select * from student;
alter table student drop (name, sex);
rollback;
comment on table student is '����һ���޸ĺ���Ļ��';
select * from recyclebin;

/*��ѯÿ�����ű�����ƣ�Ա��������Ա�������ܺ�*/
create or replace view u 
as 
select department_id ���ű��,count(employee_id) ��������,sum(salary) �����ܶ� from employees group by department_id;

select * from  u;
drop view u;

select * from employees;

--1.��ѯԱ�����е�6����12������
select em.* from
       (select 
            row_number() over(order by rowid) rank, 
            e.* 
        from employees e) em 
where rank >= 6 and rank <= 12;
select em.* from employees em;

--2.��ѯ������ߵĵ�6����12��Ա��

select em.* from
       (select 
            rank() over(order by salary desc) rank, 
            e.*
        from employees e) em 
where rank >= 6 and rank <= 12;

3.��ѯ��149��Ա��ͬһ�����ŵ�����Ա��

select e.*
from employees e
where
     e.department_id = (
     select department_id 
     from employees e1
     where e1.employee_id = 149)
4.��ѯԱ����ţ����������ű�ţ����ʣ������ŵĹ����ܺ�
select e.employee_id,
       e.first_name || e.last_name name,
       e.department_id,
       e.salary,
       nvl((select sum(salary)
             from employees e1
            where e.department_id = e1.department_id),
           e.salary) sum
  from employees e

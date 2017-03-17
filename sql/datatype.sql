create table employees(
       id number(15), 
       name varchar(20), 
       sal number(20), 
       department_id number(15),
       address varchar(25),
       telphone number(25)
       );
insert into employees values(1, '����', 4500, 54, 'sxxa',18596587965);
insert into employees values(2, 'ȡǮ', 25400, 45, 'sxwn',18596587965);
insert into employees values(3, '����', 545400, 55, 'sxbj',18596587965);
insert into employees values(4, '����', 4500, 54, 'sxlt',18596587965);
insert into employees values(5, '����', 78700, 74, 'sxch',18596587965);
insert into employees values(6, 'ͷʹ', 225400, 75, 'sxsy',18596587965);
insert into employees values(7, '����', 545400, 245, 'sxmx',18596587965);
insert into employees values(8, 'ŶŶ', 75400, 42, 'sxtc',18596587965);
insert into employees values(9, 'ƥ��', 52500,42, 'sxqs',18596587965);
insert into employees values(10, '����', 52400, 542, 'sxbx',18596587965);
insert into employees values(11, '����', 5200, 52, 'sxdl',18596587965);
insert into employees values(12, '����', 54200, 55, 'sxya',18596587965);

select * from employees where sal > 2500 and name like '��%';
select * from employees order by sal;
select * from employees where department_id = 42 order by sal desc;

select e.* from employees e, employees e order by sal;

SELECT ROWID,employees.* FROM employees ORDER BY ROWID DESC;
SELECT ROWID, ROWNUM, employees.* FROM employees ORDER by ROWNUM DESC;

-- ��д��Сд��
select name, upper(address),lower(address) from employees;

-- ����
select count(name) from employees;

-- ȡ >= a ����С����
select ceil(15.36) from dual;

-- ȡ��
select mod(10,3) from dual;

-- ��
select power(10,3) from dual;

-- ��������
select round(4502.21, 1) from dual;

-- ƽ����
select avg(sal) from employees;

-- ��������ĸ��д
select initcap('hi, liqian') from dual;

-- �ַ�������
select concat('hello','liqian') from dual;

-- �ַ�����ȡ
select substr('sysnchea', -4) from dual;
select substr('sysnchea', 4) from dual;
select substr('sysnchea', 3,6) from dual;

-- ��ȡ�ַ�������
select length('jds�Ǻ�') from dual;

-- ��ȡ�ִ�λ��
select instr('fldsjfdjs', 'js') from dual;

select employees.* ,replace(sal, '00', 'ldl') from employees;

select add_months(sysdate, -3) from  dual;
select next_day(sysdate,1) from dual;

select '���֣�'||to_char(&input, 'fml999,999,999.0000') from dual;
                                                              

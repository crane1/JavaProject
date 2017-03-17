create table employees(
       id number(15), 
       name varchar(20), 
       sal number(20), 
       department_id number(15),
       address varchar(25),
       telphone number(25)
       );
insert into employees values(1, '哈哈', 4500, 54, 'sxxa',18596587965);
insert into employees values(2, '取钱', 25400, 45, 'sxwn',18596587965);
insert into employees values(3, '问问', 545400, 55, 'sxbj',18596587965);
insert into employees values(4, '恩恩', 4500, 54, 'sxlt',18596587965);
insert into employees values(5, '让人', 78700, 74, 'sxch',18596587965);
insert into employees values(6, '头痛', 225400, 75, 'sxsy',18596587965);
insert into employees values(7, '引用', 545400, 245, 'sxmx',18596587965);
insert into employees values(8, '哦哦', 75400, 42, 'sxtc',18596587965);
insert into employees values(9, '匹配', 52500,42, 'sxqs',18596587965);
insert into employees values(10, '啊啊', 52400, 542, 'sxbx',18596587965);
insert into employees values(11, '试试', 5200, 52, 'sxdl',18596587965);
insert into employees values(12, '订单', 54200, 55, 'sxya',18596587965);

select * from employees where sal > 2500 and name like '哈%';
select * from employees order by sal;
select * from employees where department_id = 42 order by sal desc;

select e.* from employees e, employees e order by sal;

SELECT ROWID,employees.* FROM employees ORDER BY ROWID DESC;
SELECT ROWID, ROWNUM, employees.* FROM employees ORDER by ROWNUM DESC;

-- 大写，小写。
select name, upper(address),lower(address) from employees;

-- 计数
select count(name) from employees;

-- 取 >= a 的最小整数
select ceil(15.36) from dual;

-- 取余
select mod(10,3) from dual;

-- 幂
select power(10,3) from dual;

-- 四舍五入
select round(4502.21, 1) from dual;

-- 平均数
select avg(sal) from employees;

-- 单词首字母大写
select initcap('hi, liqian') from dual;

-- 字符串连接
select concat('hello','liqian') from dual;

-- 字符串截取
select substr('sysnchea', -4) from dual;
select substr('sysnchea', 4) from dual;
select substr('sysnchea', 3,6) from dual;

-- 获取字符串长度
select length('jds呵呵') from dual;

-- 获取字串位置
select instr('fldsjfdjs', 'js') from dual;

select employees.* ,replace(sal, '00', 'ldl') from employees;

select add_months(sysdate, -3) from  dual;
select next_day(sysdate,1) from dual;

select '数字：'||to_char(&input, 'fml999,999,999.0000') from dual;
                                                              

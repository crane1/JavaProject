/*1.获取某部门的工资总和（函数），若员工不存在显示‘你要找的数据不存在’；
2.把第一个题用三种参数传递格式分别进行实现；
3.使用存储过程向departments表中插入数据；
4.计算制定部门的工资总和，并统计其中的职工数量*/

--1.获取某部门的工资总和（函数），若员工不存在显示‘你要找的数据不存在’；
select count(employee_id), sum(salary) from employees where department_id=00;
create or replace function get_add(p_did number) return number
is
v_sum number;
v_sql varchar2(1000);
begin
  v_sql:='select sum(salary) from employees1 where department_id='||p_did;
  execute immediate v_sql into v_sum;
  select salary into v_sum from employees where employee_id = p_did;
/*  
  if(v_sum is null) then
      dbms_output.put_line('你要找的数据不存在');
  end if;*/
  
  exception
  when NO_DATA_FOUND then
      dbms_output.put_line('你要找的数据不存在');
  return v_sum;
end;

begin
    dbms_output.put_line(get_add(00));
end;
2.把第一个题用三种参数传递格式分别进行实现；
--default默认值
create or replace function get_result8(p_did number default 50) return number
as 
 v_sum number;
 begin
   select sum(salary)
    into v_sum
    from employees
   where department_id = p_did;
  return v_sum;
   end;
   
   begin
     dbms_output.put_line(get_result8());
     end;
-- 名称命名法
create or replace function get_result9(p_did  number,v_resut number) return number
as 
 v_result number;
 begin
   select sum(salary)
    into v_result
    from employees
   where department_id = p_did;
  return v_result;
   end;
   
   declare
   v_result1 number(34);
   begin
     dbms_output.put_line(get_result9(p_did=>50,v_resut=>v_result1));
     end;     
--混合表示法
create or replace function get_result10(p_did  number default 50,v_resut number) return number as
v_result number;
begin
   select sum(salary)
    into v_result
    from employees
   where department_id = p_did;
  return v_result;
end;

declare
  v_result1 number(34);
  begin
    dbms_output.put_line(get_result10(v_resut=>v_result1));
    dbms_output.put_line(v_result1);
  end;   
--3.使用存储过程向departments表中插入数据；
select * from departments;
create or replace procedure procedure_name(p_did departments.department_id%type,p_name departments.department_name%type,
p_manager departments.manager_id%type,d_loc departments.location_id%type)
as 
begin
  insert into departments values(p_did,p_name,p_manager,d_loc);
  end;
begin 
  procedure_name(30,'小明',107,1800);
  end;
--4.计算指定部门的工资总和，并统计其中的职工数量
create or replace function get_result11(p_did departments.department_id%type,v_count out number) return number as
v_sum number;
v_sql varchar(1000);
begin
      select sum(salary),count(employee_id) into v_sum,v_count from employees where department_id= p_did;
      return v_sum;
end;
declare 
      v_sum number;
begin
      dbms_output.put_line(get_result11(50,v_sum));
      dbms_output.put_line('v_sum = ' || v_sum);
end;

SELECT  ename ,sal*12 as initcap("年工资") FROM  emp;

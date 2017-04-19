create or replace function adds(num1 number, num2 number, v_result1 out number)
return number 
as v_result number(4);
begin
    v_result := num1 + num2;
    v_result1 := num1 - num2;
    return v_result;
end;

declare
v_rsult1 number(4);
begin
    dbms_output.put_line(adds(2, 3, v_rsult1));
    dbms_output.put_line(v_rsult1);
end;

create or replace function get_result(p_id employees.employee_id%type)
return varchar 
as v_name employees.last_name%type;
begin
    select first_name||last_name into v_name from employees 
    where employee_id = p_id;
    return v_name;
end;

begin
    dbms_output.put_line(get_result(201));
end; 

create or replace function get_dept_name(detp_id employees.department_id%type)
return varchar
as v_names varchar(200);
cursor emp_names_cursor is select last_name from employees where department_id = detp_id;
begin
    for e in emp_names_cursor loop
        v_names := v_names ||',' || e.last_name;
    end loop;        
    return trim(',' from v_names);
end;

begin
    dbms_output.put_line(get_dept_name(50));
end; 


create or replace function add_emp_salary(p_empid number, p_sal number)
return number
as v_newsalary number(7);
begin
     update employees set salary = salary + p_sal where employee_id = p_empid
     returning salary into v_newsalary;
     return v_newsalary;
end;     

begin
    dbms_output.put_line(add_emp_salary(201, 100000));
end;

--输入一个部门编号，返回这个部门的所有员工数据，返回游标变量
create or replace function get_all_info(p_detp_id number, cursor)
return cursor
as 


create or replace package depk_pa
as
    info varchar(100):='我是一个包定义';
    procedure add_dept(p_depno dept.deptno%type,
         p_dname dept.dname%type,
         p_loc dept.loc%type);
end depk_pa;         

create or replace package body depk_pa
as
    info varchar(100):='我是一个包定义';
    procedure add_dept(p_depno dept.deptno%type,
         p_dname dept.dname%type,
         p_loc dept.loc%type)
    as v_result varchar(100);
    begin
        insert into dept values(p_depno, p_dname, p_loc);
        commit;
    end;
end;    
    

create or replace package test1
as
    i number := 100;
    procedure mys;
end;

create or replace package body test1
as
    j number := 200;
    
    procedure mys2
    as
    begin
        dbms_output.put_line('哈哈哈哈哈mys2');
    end;
    
    procedure mys
    as
    begin
        dbms_output.put_line('哈哈哈哈哈mys');
        mys2;
    end;  
end;    
    
begin
    test1.mys;
end;    

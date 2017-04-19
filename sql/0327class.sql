-- 单行动态查询
declare
    v_sql varchar(1000);
    e employees%rowtype;
begin
    v_sql:='select * from employees where employee_id = :empid';
    execute immediate v_sql into e using 206;
    dbms_output.put_line(e.employee_id || e.last_name);
end;    
    
-- 多行动态查询
declare
    v_sql varchar(1000);
    e employees%rowtype;
    emp_cursor sys_refcursor;
begin
    v_sql:='select * from employees';    
    open emp_cursor for v_sql;
    loop
        fetch emp_cursor into e;
        exit when emp_cursor%notfound;
        dbms_output.put_line(e.employee_id || e.last_name);
    end loop;
    close emp_cursor;
end;    

-- 多行动态查询有参       
declare
    v_sql varchar(1000);
    e employees%rowtype;
    emp_cursor sys_refcursor;
begin
    v_sql:='select * from employees depatment_id = :deptid';    
    open emp_cursor for v_sql using 50;
    loop
        fetch emp_cursor into e;
        exit when emp_cursor%notfound;
        dbms_output.put_line(e.employee_id || e.last_name);
    end loop;
    close emp_cursor;
end;

-- 异常处理
declare
    a number(5,2);
begin
    select 1/0 into a from dual;
    exception 
    when others then
        dbms_output.put_line('出现异常了' || SQLERRM);
end;
    
    

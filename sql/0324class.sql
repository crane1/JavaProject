-- 使用游标遍历employees表的内容
declare
    type emp_table_type is table of employees%rowtype
    index by binary_integer;
    cursor emp_cursor is select * from employees;
    a emp_table_type;
begin
    open emp_cursor;
    fetch emp_cursor bulk collect into a;
    for i in 1..a.count loop
        dbms_output.put_line(a(i).employee_id);
    end loop;
    close emp_cursor;
end;

declare
    v_de number(4):=&部门编号;
    v_lname varchar2(25):='&姓';
    
begin
   -- while v_lname <> 'exit' loop
        /*v_de:=&部门编号;
        v_lname:=&姓;*/
        update employees set last_name = v_lname 
        where department_id = v_de; 
        
        if SQL%found then
            dbms_output.put_line('更新成功，' || SQL%rowcount 
            ||'个员工被更新');
        else
            dbms_output.put_line('更新失败，无员工被更新'); 
        end if;
        v_de:=&部门编号;
        v_lname:='&姓';
   -- end loop;
end;   
    
select * from employees;  

--删除员工编号＞3的员工信息
declare 
    cursor s_cursor is select * from student for update;
begin
    for s in s_cursor loop
        if s.id >= 3 then
             delete from student where id = s.id;
        end if;
    end loop;
end;                                
    
select * from student;
rollback;
        

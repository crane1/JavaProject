-- ʹ���α����employees��������
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
    v_de number(4):=&���ű��;
    v_lname varchar2(25):='&��';
    
begin
   -- while v_lname <> 'exit' loop
        /*v_de:=&���ű��;
        v_lname:=&��;*/
        update employees set last_name = v_lname 
        where department_id = v_de; 
        
        if SQL%found then
            dbms_output.put_line('���³ɹ���' || SQL%rowcount 
            ||'��Ա��������');
        else
            dbms_output.put_line('����ʧ�ܣ���Ա��������'); 
        end if;
        v_de:=&���ű��;
        v_lname:='&��';
   -- end loop;
end;   
    
select * from employees;  

--ɾ��Ա����ţ�3��Ա����Ϣ
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
        
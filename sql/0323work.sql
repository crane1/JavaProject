--**************   ��ҵ   *********************
--1.����һ�������ж��ǲ�����1-100֮�䣬�Ƿ���i�����Ƿ���FALSE��
declare 
i number:=&input;
begin
  if i>0 and i<=100 then
    dbms_output.put_line(i);
    else dbms_output.put_line('false');
   end if;
   end;
   
--2.���ַ����ݼ�50-1
--loop
declare 
    i number:= 50;
begin
    loop
        if(i<=0) then
            exit;
        else
            dbms_output.put_line(i);
            i:= i - 1;
        end if;
     end loop;
end;

--for
begin
    for i in reverse 1..50 loop       
         dbms_output.put_line(i);
     end loop;
end;

--while
declare 
    i number:= 50;
begin
    while(i>0) loop
        dbms_output.put_line(i);
        i:= i - 1;
    end loop;
end;

-- 3.10~50Ӫ����  60-90�г���  90�����з��� ���ಿ�Ų�����   
select * from employees;
declare
    type emp_table_type is table of employees%rowtype;
    a emp_table_type;
    lv_txt varchar2(20);
    empno employees.department_id%type;
begin    
    select * bulk collect into a from employees;
    for i in 1..a.count loop
        empno := a(i).department_id;        
        if( empno >= 10 and empno <= 50) then
            lv_txt := 'Ӫ����';
        elsif( empno >= 60 and empno < 90) then
            lv_txt := '�г���';
        elsif( empno >= 90)  then
            lv_txt := '�з���';
        else
            lv_txt := '���Ų�����';
        end if;
        dbms_output.put_line(a(i).last_name || '��' || lv_txt);
     end loop;
end;   

--     4.�������ݣ�employees��
declare
    type emp_table_type is table of employees%rowtype;
    a emp_table_type;
begin    
    select * bulk collect into a from employees;
    for i in 1..a.count loop
        dbms_output.put_line('Ա��' || i || '��');
        dbms_output.put_line('��ţ�' || a(i).employee_id);     
        dbms_output.put_line('������' || a(i).first_name || ' ' || a(i).last_name);
        dbms_output.put_line('���䣺' || a(i).email);
        dbms_output.put_line('�绰��' || a(i).phone_number);
        dbms_output.put_line('��ְʱ�䣺' || a(i).hire_date);
        dbms_output.put_line('ְλ��ţ�' || a(i).job_id);
        dbms_output.put_line('нˮ��' || a(i).salary);
        dbms_output.put_line('��ɣ�' || nvl(to_char(a(i).commission_pct), '����̫���ˣ�û�����'));
        dbms_output.put_line('��˾��ţ�' || a(i).manager_id);
        dbms_output.put_line('���ű��' || a(i).department_id);
        dbms_output.put_line('****************************************');
        dbms_output.put_line('');
     end loop;
end;    
--     5.ȡ��7369��нˮ��<1000 low
--     <2000 middle   else high 
select * from emp;
declare 
    v_sal emp.sal%type;
    v_sal_txt varchar(15);
    v_name emp.ename%type;
begin
    select ename, sal into v_name,v_sal from emp where empno = 7369;
    if(v_sal < 1000) then
        v_sal_txt := 'Low';
    elsif(v_sal >= 1000 and v_sal <= 2000) then
        v_sal_txt := 'Middle';
    else
        v_sal_txt := 'High';
    end if;
    dbms_output.put_line(v_name || '�Ǹ�' || v_sal_txt || ' B');
end;    
       

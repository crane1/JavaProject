--**************   作业   *********************
--1.输入一个数，判断是不是在1-100之间，是返回i，不是返回FALSE、
declare 
i number:=&input;
begin
  if i>0 and i<=100 then
    dbms_output.put_line(i);
    else dbms_output.put_line('false');
   end if;
   end;
   
--2.三种方法递减50-1
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

-- 3.10~50营销部  60-90市场部  90以上研发部 其余部门不存在   
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
            lv_txt := '营销部';
        elsif( empno >= 60 and empno < 90) then
            lv_txt := '市场部';
        elsif( empno >= 90)  then
            lv_txt := '研发部';
        else
            lv_txt := '部门不存在';
        end if;
        dbms_output.put_line(a(i).last_name || '在' || lv_txt);
     end loop;
end;   

--     4.遍历数据（employees）
declare
    type emp_table_type is table of employees%rowtype;
    a emp_table_type;
begin    
    select * bulk collect into a from employees;
    for i in 1..a.count loop
        dbms_output.put_line('员工' || i || '：');
        dbms_output.put_line('编号：' || a(i).employee_id);     
        dbms_output.put_line('姓名：' || a(i).first_name || ' ' || a(i).last_name);
        dbms_output.put_line('邮箱：' || a(i).email);
        dbms_output.put_line('电话：' || a(i).phone_number);
        dbms_output.put_line('入职时间：' || a(i).hire_date);
        dbms_output.put_line('职位编号：' || a(i).job_id);
        dbms_output.put_line('薪水：' || a(i).salary);
        dbms_output.put_line('提成：' || nvl(to_char(a(i).commission_pct), '工作太烂了，没有提成'));
        dbms_output.put_line('上司编号：' || a(i).manager_id);
        dbms_output.put_line('部门编号' || a(i).department_id);
        dbms_output.put_line('****************************************');
        dbms_output.put_line('');
     end loop;
end;    
--     5.取出7369的薪水，<1000 low
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
    dbms_output.put_line(v_name || '是个' || v_sal_txt || ' B');
end;    
       

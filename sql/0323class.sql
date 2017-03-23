declare
  v_id number(20):=101;
  v_name varchar(25):='ٻٻ';
  v_sex char(5):='Ů';
  v_date date:=to_date('10:08:20,03 23,2017,', 'HH:MI:SS,MM DD,YYYY,');
begin
  dbms_output.put_line('hello ');
  dbms_output.put_line(v_name);
  dbms_output.put_line('��������' || to_char(v_date,'HH:MI:SS,MM DD,YYYY,'));
end;

select to_date('03 23,2017', 'MM DD,YYYY') from dual;

declare
    v_a number(5):=100;
    v_b number(5):=200;
    v_sum number(6):= v_a + v_b;
    v_multiply number(10):= v_a * v_b;
    v_divide number(7,2):= v_a / v_b;
begin
    dbms_output.put_line('a=' || v_a);
    dbms_output.put_line('b=' || v_b);
    dbms_output.put_line('a+b=' || v_sum);
    dbms_output.put_line('axb=' || v_multiply);
    dbms_output.put_line('a��b=' || v_divide);
end; 

select * from emp;
declare
    type emp_record_type is record(
         v_empno number(10),
         v_ename varchar(15),
         v_job varchar(15),
         v_mgr number(5),
         v_hiredate date,
         v_sal number(7,2),
         v_comm number(7,2),
         v_deptno number(3)
     );
     e emp_record_type;
begin
  select * into e from emp where emp.empno = 7654;
  dbms_output.put_line('Ա����ţ�' || e.v_empno ||
                       ' ������' || e.v_ename ||
                       ' ְλ��' || e.v_job ||
                       ' �����߱�ţ�' || e.v_mgr ||
                       ' ��ְ���ڣ�' || e.v_hiredate ||
                       ' н�ʣ�' || e.v_sal ||
                       ' ����' || e.v_comm ||
                       ' ���ű�ţ�' || e.v_deptno);
end;

select * from emp;

declare
    type emp_record_type is record(
         v_empno emp.empno%type,  --���ձ��е�������
         v_ename emp.ename%type,  --ͬ��       
         v_sal emp.sal%type  --ͬ��
     );
     e emp_record_type;
begin
  select emp.empno,emp.ename, emp.sal into e from emp where emp.empno = 7654;
  dbms_output.put_line('Ա����ţ�' || e.v_empno ||
                       ' ������' || e.v_ename ||                     
                       ' н�ʣ�' || e.v_sal 
                      );
end;

select rowid, student.* from student order by id;
alter table student add(name varchar(15), sex char(1));  
alter table student modify(sex char(2));

update student set name = '�����',sex = '��' where id = 1;
update student set name = '������',sex = '��' where id = 2;
update student set name = '��˽�',sex = '��' where id = 3;
update student set name = 'ɳ����',sex = '��' where id = 4;
update student set name = '������',sex = '��' where id = 5;

alter table student add constraint PK_STU_ID primary key(id);

create sequence stu_seq start with 6;
insert into student values(stu_seq.nextval,'�׹Ǿ�', 'Ů');

declare 
    d student%rowtype;
begin
    update student set name = 'Ů��������' where id = 6
    returning id, name, sex into d;
    dbms_output.put_line(d.id|| d.name|| d.sex);
end;    
    
    
--���ز���Ա���Ĺ��ʣ����ر����µ�Ա���������¹���
declare
  type emp_record_type is record(
    v_name employees.last_name%type,
    v_sal  employees.salary%type   
    );
  type emp_table_type is table of emp_record_type index by binary_integer;
  e emp_table_type;
begin
  --select * from employees;
  update employees
     set salary = salary + 1
   where employee_id = 206
  returning last_name, salary bulk collect into e;
  dbms_output.put_line('�¹��ʣ�' || e(1).v_sal);
end;


 

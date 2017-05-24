--����һ��emp_his��¼��
create table emp_his (
userName varchar(25),
operateTime date,
operateType varchar2(25),
empno number(4),
ename varchar(10)
);

alter table emp_his modify  operateType varchar2(25)

--����������¼log��emp_his;
create or replace trigger tr_dml
    --ɾ��,���£�����ǰ
    before delete or update or insert
    on scott.emp
    for each row

declare
    v_oprType varchar2(25);
begin
    --��¼��������
    if(deleting) then
        v_oprType:='delete';     
    elsif(updating) then
        v_oprType:='update';
    elsif(inserting) then
        v_oprType:='insert';        
    end if;
    
    --���������־ delete �� update ����oldֵ�� insert ����newֵ
    if(deleting or updating) then
        insert into emp_his values(USER, systimestamp,
        v_oprType, :old.empno, :old.ename);
    else
        insert into emp_his values(USER, systimestamp,
        v_oprType, :new.empno, :new.ename);
    end if
    
end tr_dml;    
    
    
select emp.empno, emp.ename from emp;
--����
insert into emp(empno, ename) values(1114, 'LIZEMING')
--����
update emp set ename='LIZEMING' where empno=1114;

--ɾ��
deletE emp where ename='LIZEMING';

--��ѯ��ʷ��¼
select * from emp_his;

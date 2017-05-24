--创建一个emp_his记录表
create table emp_his (
userName varchar(25),
operateTime date,
operateType varchar2(25),
empno number(4),
ename varchar(10)
);

alter table emp_his modify  operateType varchar2(25)

--触发器，记录log在emp_his;
create or replace trigger tr_dml
    --删除,更新，插入前
    before delete or update or insert
    on scott.emp
    for each row

declare
    v_oprType varchar2(25);
begin
    --记录操作类型
    if(deleting) then
        v_oprType:='delete';     
    elsif(updating) then
        v_oprType:='update';
    elsif(inserting) then
        v_oprType:='insert';        
    end if;
    
    --插入操作日志 delete 和 update 插入old值， insert 插入new值
    if(deleting or updating) then
        insert into emp_his values(USER, systimestamp,
        v_oprType, :old.empno, :old.ename);
    else
        insert into emp_his values(USER, systimestamp,
        v_oprType, :new.empno, :new.ename);
    end if
    
end tr_dml;    
    
    
select emp.empno, emp.ename from emp;
--插入
insert into emp(empno, ename) values(1114, 'LIZEMING')
--更新
update emp set ename='LIZEMING' where empno=1114;

--删除
deletE emp where ename='LIZEMING';

--查询历史记录
select * from emp_his;

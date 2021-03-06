create table journal(userName varchar(20),operType varchar(20),operNumber number(20),operDate date);
create or replace trigger tri_rt
after
       insert or update or delete
       on emp
       for each row
declare
           begin
             if inserting then
             insert into journal values(user,'insert',:new.empno,sysdate);
             elsif updating then
             insert into journal values(user,'insert',:new.empno,sysdate); 
             elsif deleting then
             insert into journal values(user,'insert',:old.empno,sysdate);
             end if;
             end;

insert into emp(empno, ename) values(1115, 'lizm');
update  emp set ename = 'liq' where emp.empno = 1115;
delete emp where emp.empno = 1115;

select * from journal;

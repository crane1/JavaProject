select * from aa where id=4 and name='444';
commit;

create or replace function getAvgSal(
    v_deptno number,
    v_avgSal out number 
    v_empCnt out number;
)
return number
as
nore
begin
    select avg(sal) into v_avgSal from emp where deptno=v_deptno;
    select count(sal) into v_empCnt from emp where deptno=v_deptno;
    return v_empCnt;
end;

create or replace procedure  getAvgSalPro(
    v_deptno number,
    v_avgSal out number 
)
as
v_empCnt number;
begin
    select avg(sal) into v_avgSal from emp where deptno=v_deptno;
    select count(sal) into v_empCnt from emp where deptno=v_deptno;
   
end;

create table xiewb(
id varchar(25),
name varchar(10)
)

select * from xiewb order by to_number(substr( id,12));

declare
i number(5):=1;
begin
    loop 
        insert into xiewb values('chinasofti-'||i, 'xiewb');
        i:= i+1;
        if i > 100 then 
            exit;
        end if;
    end loop;
end; 

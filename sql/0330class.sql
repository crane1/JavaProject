select * from student;
alter table student add age number(3);
update student set age = 18;

alter table student drop(sex);

alter table student add sex char(2);
update student set sex = 'Ñı';
commit;

declare
    type t_CharRecord is table of varchar2(20)
        index by binary_integer;
    v_Chars t_CharRecord;
    v_Counter number;
begin
    v_Chars(-6):='negative';
    v_Chars(0):='zero';
    v_Chars(4):='Plus';
    v_Chars(90):='ninety';
    

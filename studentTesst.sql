
select  c_id,c_name,c_monitor,c_man_teacher,c_teac_teacher  from SIMS_CLASS  where c_id='5'

select s_id, s_name from sims_student where s_classid='002'
select * from sims_student s where s.isleader=1

select * from sims_team where t_id='hehe'
select * from sims_class

select * from student where id='2';
drop table student;

create table student as select s.s_id id, s.s_name name  from sims_student s;

select * from student where id='lizeming';
alter table student add(age number, sex number, gradFrom varchar2(100))

insert into student values('lizeming','������',24,0,'����ʶž��˷�')

select s.s_id,s.s_pwd from sims_student s where s.s_id = '1';

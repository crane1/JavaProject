
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

update student set age=24,sex=0,gradfrom='����ʶž��˷�';

select s.s_id,s.s_pwd from sims_student s where s.s_id = '1';

select s_id, s_pwd from sims_student s where s.isnormadmin=1

select * from users order by to_number(id);
alter table users add(likes varchar2(50));
update users set conid=2;

CREATE SEQUENCE usersid_seq
MINVALUE 1
START WITH 8
NOMAXVALUE
INCREMENT BY 1
NOCYCLE
CACHE 30

CREATE TRIGGER tr1_users

BEFORE INSERT ON users

FOR EACH ROW

BEGIN

SELECT usersid_seq.NEXTVAL INTO :NEW.id FROM dual;

END;

insert into users values('10','123','��С��',1,'����Ϸ')


select * from contry;
create table contry(
  id number primary key not null,
  name varchar2(20)  
)

insert into contry values(1,'�й�');

insert into contry values(2,'����');

insert into contry values(3,'�ձ�');

alter table users add(conId number)

select      u.ID, u.NAME, u.PWD, u.QX, u.LIKES, u.CONID, c.ID AS CID, c.NAME AS CNAME     from USERS u, CONTRY c     where u.CONID=c.ID AND u.ID = '1'

select c.id, c.name, u.id as userid, u.name as username from contry c, users u where c.id = 1
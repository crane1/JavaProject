alter table s_student drop(pwd );

select s.s_id, s.s_name, s.s_sex, s.s_age, s.s_gradinst, s.s_pwd from s_student s where s.s_id = ;

update  s_student set s_pwd='123'

delete s_student where s_id is null;

select s_id, s_name, s_sex, s_age, s_gradInst from s_student where s_age between 23 and 25;

alter table s_student
  add constraint PK_s_student primary key (s_id)

delete from s_student where rownum <= 153

insert into s_student values('java020701', 'С�İ�01', '��', '24', '�����ʼҹ�ҵѧԺ'��'123')

select * from s_student;

update s_student set s_sex='��' where s_sex like '��%'
update s_student set s_sex='Ů' where s_sex like 'Ů%'


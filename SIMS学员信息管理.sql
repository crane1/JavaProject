--����ѧԱ��
create table sims_student(
    s_id varchar2(10),  -- ѧ��
    s_pwd varchar2(20), -- ����
    s_name varchar2(4 CHAR), --����
    s_sex varchar2(1 CHAR), --�Ա�
    s_age number(3),  --����
    s_gradFrom varchar2(50 CHAR), --��ҵԺУ
    s_tel number(15),  --�绰����
    s_addr varchar2(50 CHAR), --��ַ
    s_idcard varchar2(20),  --���֤����
    s_email varchar2(30), --����
    s_team varchar2(20), --��id
    s_class varchar2(20), --�༶id
    constraint pk_sims_student primary key(s_id) -- ����
);

--�����༶��
create table sims_class(
    c_id varchar2(10),  --�༶id
    c_name varchar2(5 CHAR), --�༶����
    c_monitor varchar2(10), --�೤
    c_man_teacher varchar2(10), --������
    c_teac_teacher varchar2(10), -- �ο���ʦ
    constraint pk_sims_class primary key(c_id) -- ����
);

--�������
create table sims_team(
    t_id varchar2(10), -- ��ID
    t_name varchar2(5 CHAR), -- ����
    t_leader varchar2(10), -- �鳤
    constraint pk_sims_team primary key(t_id) -- ����
);

--���ѧ�������
--ѧ��-�༶
alter table sims_student
 add constraint fk_sims_student_class 
 foreign key (s_class) references sims_class(c_id);
 --ѧ��-��
 alter table sims_student
 add constraint fk_sims_student_team
 foreign key (s_team) references sims_team(t_id);
 
--��Ӱ༶�����
--�೤-��Ա
  alter table sims_class
 add constraint fk_c_monitor_s_id
 foreign key (c_monitor) references sims_student(s_id);
 --������-��Ա
alter table sims_class
 add constraint fk_c_man_teacher_s_id
 foreign key (c_man_teacher) references sims_student(s_id);
 --�ο���ʦ-��Ա 
alter table sims_class
 add constraint fk_c_teac_teacher_s_id
 foreign key (c_teac_teacher) references sims_student(s_id);
 
 --���������
 alter table sims_team
 add constraint fk_t_leader_s_id
 foreign key (t_leader) references sims_student(s_id);
 
--�����ԱȨ����
alter table sims_student add (
      t_leader number(1),
      c_monitor number(1), 
      c_man_teacher number(1), 
      c_teac_teacher number(1), 
      normal_manager number(1) );
   
alter table sims_student modify(s_name varchar2(10 CHAR) );    --����
   
--��ѧ���������1000������
declare
v_sex varchar2(1 CHAR):='��';
v_int number(3):=1;
begin
    for i in 1..1000 loop
        if(i mod 2 = 0) then v_sex:='��'; else v_sex:='Ů'; end if;
        if(i mod 10 =0) then v_int := v_int + 1; end if;
        insert into sims_student values(i, 123, 'С�İ�'||i, v_sex, 20+mod(i,10), '�ʼ�����ѧԺ'||v_int, '18300450'||i, '������Դ'||i, 
        '98756684135684'||i, i||'@smis.com', null, null, 0, 0, 0, 0, 0);
    end loop;
end;

insert into sims_student values('admin', 123, null, null, null, null, null, null, 
        null, null, null, null, 0, 0, 0, 0, 0);

  
--���༶�������10������
declare
begin
    for i in 1..10 loop
        insert into sims_class values(i, '��ʶ'||i, null, null, null);
    end loop;
end;

--����������60������
declare
begin
    for i in 1..60 loop
        insert into sims_team values(i, '����'||i, null,null);
    end loop;
end;


--��ӱ�༶id��
alter table sims_team add (
      class_id varchar2(10)  --�༶id
       );
       
--select * from sims_student where s_id < 299;       
 
 --���������
 alter table sims_team
 add constraint fk_class_id_c_id
 foreign key (class_id) references sims_class(c_id);
 
-- Ϊѧ���ְ�
declare
begin
    for i in 1..299 loop
        dbms_output.put_line(mod(i,30)+1);
        update sims_student set s_class = mod(i,9)+1 where s_id = i;
    end loop;
end;

-- Ϊ����Ӱ೤,�����Σ��ο���ʦ
declare
begin
    for i in 1..9 loop
        --update sims_class set c_monitor = i-1 where c_id = i;
        update sims_class set c_man_teacher = 17+i where c_id = i;
        update sims_class set c_teac_teacher = 26+i where c_id = i;
    end loop;
end;

--select * from sims_class;
--select * from sims_student where s_id < 299;

select * from sims_student where s_id < 299;
select s.s_id,s.s_pwd,s.s_name,s.s_sex,s.s_age,s.s_gradfrom,s.s_tel,s.s_addr,s.s_idcard,s.s_email,s.s_team,s.s_class,s.t_leader,s.c_monitor,s.c_man_teacher,s.c_teac_teacher,s.normal_manager from sims_student s where s.s_class=1;

select * from sims_student where s_id = 413;

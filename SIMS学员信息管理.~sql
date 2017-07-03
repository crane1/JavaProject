--创建学员表
create table sims_student(
    s_id varchar2(10),  -- 学号
    s_pwd varchar2(20), -- 密码
    s_name varchar2(4 CHAR), --姓名
    s_sex varchar2(1 CHAR), --性别
    s_age number(3),  --年龄
    s_gradFrom varchar2(50 CHAR), --毕业院校
    s_tel number(15),  --电话号码
    s_addr varchar2(50 CHAR), --地址
    s_idcard varchar2(20),  --身份证号码
    s_email varchar2(30), --邮箱
    s_team varchar2(20), --组id
    s_class varchar2(20), --班级id
    constraint pk_sims_student primary key(s_id) -- 主键
);

--创建班级表
create table sims_class(
    c_id varchar2(10),  --班级id
    c_name varchar2(5 CHAR), --班级姓名
    c_monitor varchar2(10), --班长
    c_man_teacher varchar2(10), --班主任
    c_teac_teacher varchar2(10), -- 任课老师
    constraint pk_sims_class primary key(c_id) -- 主键
);

--创建组表
create table sims_team(
    t_id varchar2(10), -- 组ID
    t_name varchar2(5 CHAR), -- 组名
    t_leader varchar2(10), -- 组长
    constraint pk_sims_team primary key(t_id) -- 主键
);

--添加学生表外键
--学生-班级
alter table sims_student
 add constraint fk_sims_student_class 
 foreign key (s_class) references sims_class(c_id);
 --学生-组
 alter table sims_student
 add constraint fk_sims_student_team
 foreign key (s_team) references sims_team(t_id);
 
--添加班级表外键
--班长-组员
  alter table sims_class
 add constraint fk_c_monitor_s_id
 foreign key (c_monitor) references sims_student(s_id);
 --班主任-组员
alter table sims_class
 add constraint fk_c_man_teacher_s_id
 foreign key (c_man_teacher) references sims_student(s_id);
 --任课老师-组员 
alter table sims_class
 add constraint fk_c_teac_teacher_s_id
 foreign key (c_teac_teacher) references sims_student(s_id);
 
 --添加组表外键
 alter table sims_team
 add constraint fk_t_leader_s_id
 foreign key (t_leader) references sims_student(s_id);
 
--添加组员权限列
alter table sims_student add (
      t_leader number(1),
      c_monitor number(1), 
      c_man_teacher number(1), 
      c_teac_teacher number(1), 
      normal_manager number(1) );
   
alter table sims_student modify(s_name varchar2(10 CHAR) );    --姓名
   
--往学生表中添加1000条数据
declare
v_sex varchar2(1 CHAR):='男';
v_int number(3):=1;
begin
    for i in 1..1000 loop
        if(i mod 2 = 0) then v_sex:='男'; else v_sex:='女'; end if;
        if(i mod 10 =0) then v_int := v_int + 1; end if;
        insert into sims_student values(i, 123, '小四瓣'||i, v_sex, 20+mod(i,10), '皇家音乐学院'||v_int, '18300450'||i, '世外桃源'||i, 
        '98756684135684'||i, i||'@smis.com', null, null, 0, 0, 0, 0, 0);
    end loop;
end;

insert into sims_student values('admin', 123, null, null, null, null, null, null, 
        null, null, null, null, 0, 0, 0, 0, 0);

  
--往班级表中添加10条数据
declare
begin
    for i in 1..10 loop
        insert into sims_class values(i, '意识'||i, null, null, null);
    end loop;
end;

--往组表中添加60条数据
declare
begin
    for i in 1..60 loop
        insert into sims_team values(i, '开心'||i, null,null);
    end loop;
end;


--添加表班级id列
alter table sims_team add (
      class_id varchar2(10)  --班级id
       );
       
--select * from sims_student where s_id < 299;       
 
 --添加组表外键
 alter table sims_team
 add constraint fk_class_id_c_id
 foreign key (class_id) references sims_class(c_id);
 
-- 为学生分班
declare
begin
    for i in 1..299 loop
        dbms_output.put_line(mod(i,30)+1);
        update sims_student set s_class = mod(i,9)+1 where s_id = i;
    end loop;
end;

-- 为班添加班长,班主任，任课老师
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

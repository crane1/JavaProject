--作业1:Sqlplus运行，编写的文件（查询emp表，中文列名）
select * from emp;

--作业2：查询emp表，（ comm不能为空，sal大于1000，job不重复，升序）
select * from emp where comm  is not null and sal > 1000 order by sal asc;

--创建Flower表，（根据自己的学生管理系统创建表）
drop table Flower;
create table Flower(id varchar(25), 
                     name varchar(25), 
                     price number(15), 
                     materials varchar(25), 
                     package varchar(25), 
                     num number(15), 
                     type varchar(25), 
                     flowerWord varchar(100),
                     idDelete number(1)
                     );

insert into Flower values('rr001','情窦初开',442,'红玫瑰','礼盒',19,'创意礼盒','死生契阔,与子成说。执子之手，与子偕老。', 1);
insert into Flower values('rr002','爱到永久',412,'红玫瑰','单面',19,'精美花束','无论世界如何在改变，我都爱你每个日月年，牵你手直到幸福到永远。', 1);
select * from Flower;

--员工信息表 工号	姓名	年龄	工资

drop table employee;
create table employee(工号 varchar(15),
                       姓名 varchar(15),
                       年龄 number(5),
                       工资 number(20)
                       );
insert into employee values('CH_65', '李倩', 22, 8000);
insert into employee values('CH_48', '李茜', 18, 30000);
insert into employee values('CH_1024', '李谦', 32, 5000);
insert into employee values('CH_2048', '李乾', 40, 3000);
select * from employee;

--将以上员工信息表按照工号后的数值大小升序，工资降序输出所有信息
select * from employee order by to_number(substr(工号,4)), 工资 desc;

/*--作业1：自定义一个员工工资一览表，按照以下规则统计各自工资区间的员工个数。（分布各个sql分别都写出来）
1.至尊 25k以上
2.钻石 15k-25k
3.白金 8k-15k
4.黄金 6k-8k
5.青铜 6k以下*/
select count(工号) 至尊 from employee where 工资 >= 25000;
select count(工号) 钻石 from employee where 工资 between  15000 and 24999;
select count(工号) 白金 from employee where 工资 >= 8000 and 工资 < 15000;
select count(工号) 黄金 from employee where 工资 >= 6000 and 工资 < 8000;
select count(工号) 青铜 from employee where 工资 < 6000;

/*--作业2：将作业1的白金以上员工个数显示出来
基于昨天员工工资表，选出工资排行前5的员工信息*/
select count(工号) 白金以上 from employee where 工资 >= 8000;

select * from
(select * from employee  order by 工资 desc)
where rownum < 6;

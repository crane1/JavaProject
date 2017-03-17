--��ҵ1:Sqlplus���У���д���ļ�����ѯemp��������������
select * from emp;

--��ҵ2����ѯemp������ comm����Ϊ�գ�sal����1000��job���ظ�������
select * from emp where comm  is not null and sal > 1000 order by sal asc;

--����Flower�����������Լ���ѧ������ϵͳ��������
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

insert into Flower values('rr001','������',442,'��õ��','���',19,'�������','��������,���ӳ�˵��ִ��֮�֣��������ϡ�', 1);
insert into Flower values('rr002','��������',412,'��õ��','����',19,'��������','������������ڸı䣬�Ҷ�����ÿ�������꣬ǣ����ֱ���Ҹ�����Զ��', 1);
select * from Flower;

--Ա����Ϣ�� ����	����	����	����

drop table employee;
create table employee(���� varchar(15),
                       ���� varchar(15),
                       ���� number(5),
                       ���� number(20)
                       );
insert into employee values('CH_65', '��ٻ', 22, 8000);
insert into employee values('CH_48', '����', 18, 30000);
insert into employee values('CH_1024', '��ǫ', 32, 5000);
insert into employee values('CH_2048', '��Ǭ', 40, 3000);
select * from employee;

--������Ա����Ϣ�����չ��ź����ֵ��С���򣬹��ʽ������������Ϣ
select * from employee order by to_number(substr(����,4)), ���� desc;

/*--��ҵ1���Զ���һ��Ա������һ�������������¹���ͳ�Ƹ��Թ��������Ա�����������ֲ�����sql�ֱ�д������
1.���� 25k����
2.��ʯ 15k-25k
3.�׽� 8k-15k
4.�ƽ� 6k-8k
5.��ͭ 6k����*/
select count(����) ���� from employee where ���� >= 25000;
select count(����) ��ʯ from employee where ���� between  15000 and 24999;
select count(����) �׽� from employee where ���� >= 8000 and ���� < 15000;
select count(����) �ƽ� from employee where ���� >= 6000 and ���� < 8000;
select count(����) ��ͭ from employee where ���� < 6000;

/*--��ҵ2������ҵ1�İ׽�����Ա��������ʾ����
��������Ա�����ʱ���ѡ����������ǰ5��Ա����Ϣ*/
select count(����) �׽����� from employee where ���� >= 8000;

select * from
(select * from employee  order by ���� desc)
where rownum < 6;
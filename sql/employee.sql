-- ������
create table employee(
       id number(4) not null,
       name varchar2(20) not null,
       gender char(1) default 'M',
       birth date,
       salary number(6,2),
       comm number(6,2),
       job varchar2(30),
       manager number(4),
       deptno number(2));

-- ��ѯ��ṹ
desc employee;

--�޸ı���
rename employee to myemp;

--����в���һ��
alter table myemp add(hiredate date default sysdate);

--�޸ı����� ����
alter table myemp modify(job varchar2(40) default 'CLERK');

--ɾ��һ��
alter table myemp drop(hiredate);

--��������
insert into table myemp(id, name,)

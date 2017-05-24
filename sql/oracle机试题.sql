--******************** ��һ�� ***********************
--������  ��Ʒ��  ��Ʒ����  ��Ʒ����
/*1  ������˿  25.50  3
1  ��������  30.00  2
1  ˮ����Ƭ  32.50  1
2  �ع���	18.00	1
2	������	36.50	2*/

--������

create table foodMenu(
fId number(5),
fName varchar(25),
fPrice number(5,2),
fCnt number(5)
);

delete foodMenu;
insert into foodMenu values(1,  '������˿',  25.50,  3);
insert into foodMenu values(1,  '��������',  30.00,  2);
insert into foodMenu values(1,  'ˮ����Ƭ',  32.50, 1);
insert into foodMenu values(2,  '�ع���',	18.00,	1);
insert into foodMenu values(2,	'������',	36.50,	2);

--���дSQL����ѯ������Ϊ1�Ķ����ܼۡ�

select fId ������sum(fPrice * fCnt) �ܼ� from foodMenu where fId = 1 group by fId;

--******************** �ڶ��� ***********************
/*Oracle���дһ��Package������ֱ���һ��function��procedure�����ú�����ȡĳһ���ŵ���͹��ʣ��ڴ洢�����е��ú���ʵ�������߼��� 
�������͹��ʣ�����͹������200��
����ǻ�����������͹���200����400����,�������������100��
Ԥ�����Բ��ű�ţ���������Ա����ţ�Ա��������������Ϣһ������ʽ�����ء�Java����JDBC��ɶ�ȡ��ʵʩ���²�����
ע�⣺���ݿ��������ʱ���󣬲���������������ֱ���쳣��ֻ�ǽ������ź���Ϣ��ʾ������̨��*/

--�����
create or replace package sal_operation_pack as
    --���庯���ʹ洢����
    function getDeptMinSal(v_deptno emp.deptno%type,expt out varchar)return number;
    procedure addSal(v_deptno emp.deptno%type,cur_info out sys_refcursor, expt out varchar);
end sal_operation_pack;

create or replace package body sal_operation_pack as

  -- ʵ�ֺ���
  function getDeptMinSal(v_deptno emp.deptno%type, expt out varchar)
    return number as
    v_minSal emp.sal%type;
  begin
    select min(sal) into v_minSal from emp where emp.deptno = v_deptno;
    return v_minSal;
  exception
    when others then
      expt := sqlerrm;
  end getDeptMinSal;

  --ʵ�ִ洢����
  procedure addSal(v_deptno emp.deptno%type,
                   cur_info out sys_refcursor,
                   expt     out varchar) as
    v_minSal    emp.sal%type;
    v_expt_func varchar(25);
  
  begin
  
    v_minSal := getDeptMinsal(v_deptno, v_expt_func);
    open cur_info for
    --�����͹���
      select emp.deptno, dept.dname, emp.empno, emp.ename, 
          case when emp.sal = v_minSal then emp.sal + 200
               when emp.sal between v_minSal + 200 and v_minSal + 400 then emp.sal + 100
               else emp.sal
          end as new_sal
      from emp, dept
      where
          emp.deptno = v_deptno and
           emp.deptno = dept.deptno;
  exception
    when others then
      expt := sqlerrm || v_expt_func;
    
  end addSal;
end sal_operation_pack;


--���Դ���
declare
cur_info  sys_refcursor;
expt  varchar(25);
deptno emp.deptno%type; 
dname dept.dname%type;
empno emp.empno%type;
ename emp.ename%type;
sal   emp.sal%type;
begin
    sal_operation_pack.addSal(10, cur_info,expt);
    if(expt is null) then
        fetch cur_info into deptno, dname, empno, ename, sal;
        while (cur_info%found) loop
            dbms_output.put_line('deptno:'||deptno||',dname:'|| dname||',empno:'|| empno||',ename:'|| ename||',sal:'|| sal);
            fetch cur_info into deptno, dname, empno, ename, sal;
        end loop;
        
    end if;
end;

select    deptno,  empno, ename, sal from emp where deptno=20;
      


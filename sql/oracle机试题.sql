--******************** 第一题 ***********************
--订单号  菜品名  菜品单价  菜品数量
/*1  鱼香肉丝  25.50  3
1  宫保鸡丁  30.00  2
1  水煮肉片  32.50  1
2  回锅肉	18.00	1
2	沸腾鱼	36.50	2*/

--创建表

create table foodMenu(
fId number(5),
fName varchar(25),
fPrice number(5,2),
fCnt number(5)
);

delete foodMenu;
insert into foodMenu values(1,  '鱼香肉丝',  25.50,  3);
insert into foodMenu values(1,  '宫保鸡丁',  30.00,  2);
insert into foodMenu values(1,  '水煮肉片',  32.50, 1);
insert into foodMenu values(2,  '回锅肉',	18.00,	1);
insert into foodMenu values(2,	'沸腾鱼',	36.50,	2);

--请编写SQL语句查询订单号为1的订单总价。

select fId 订单，sum(fPrice * fCnt) 总价 from foodMenu where fId = 1 group by fId;

--******************** 第二题 ***********************
/*Oracle侧编写一个Package，里面分别有一个function和procedure，利用函数获取某一部门的最低工资，在存储过程中调用函数实现如下逻辑： 
如果是最低工资，将最低工资提高200；
如果是基本工资在最低工资200以上400以内,将基本工资提高100的
预算结果以部门编号，部门名，员工编号，员工姓名，工资信息一栏的形式做返回。Java采用JDBC完成读取并实施更新操作。
注意：数据库程序运行时错误，不允许程序崩溃或者直接异常，只是将错误编号和信息显示到控制台。*/

--定义包
create or replace package sal_operation_pack as
    --定义函数和存储过程
    function getDeptMinSal(v_deptno emp.deptno%type,expt out varchar)return number;
    procedure addSal(v_deptno emp.deptno%type,cur_info out sys_refcursor, expt out varchar);
end sal_operation_pack;

create or replace package body sal_operation_pack as

  -- 实现函数
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

  --实现存储过程
  procedure addSal(v_deptno emp.deptno%type,
                   cur_info out sys_refcursor,
                   expt     out varchar) as
    v_minSal    emp.sal%type;
    v_expt_func varchar(25);
  
  begin
  
    v_minSal := getDeptMinsal(v_deptno, v_expt_func);
    open cur_info for
    --提高最低工资
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


--测试代码
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
      


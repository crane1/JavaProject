/*1.д����emp���ȡ���й���С��800���ʴ���2000���������ŵ�Ա��������
ע�⣺���ڻ����һ���˲���Ҫͳ��*/

select * from emp;
select * from (
    select deptno, count(deptno) as num 
    from emp 
    where sal < 800 or sal > 2000 group by deptno) 
where num > 1;

select * from emp where job = 'ANALYST'
or ename like 'J%';

select * from(
       select rownum ru, emp.* from emp where rownum < 11) ts 
where ts.ru > 5;

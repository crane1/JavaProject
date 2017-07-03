create or replace function getSimsPageRows(
v_maxPageRows number,
v_curPageNo number,
v_attribute varchar2,  --需要查询的属性字符串
v_condition varchar2,  --需要查询的条件参数
v_countId varchar2,   --需要查询记录条数的id
v_maxRowNumber out number,
v_erro out varchar2
)
return sys_refcursor
as
cur_rows  sys_refcursor;
query_sql varchar2(1000 );  
begin
  query_sql:='select '
          ||v_attribute ||
          ' from
          (
              select
              case when mod(ss.lineno, v_maxPageRows)=0 then ss.lineno/v_maxPageRows
                   when mod(ss.lineno, v_maxPageRows)!=0 then trunc(ss.lineno/v_maxPageRows)+1 end as pageno, '
                    || v_attribute ||
              ' from
             
                  (select row_number() over(order by'|| v_countId ||') as lineno, '
                         || v_attribute ||
                          ' from ' || v_condition || ' ) ss
          ) sss where sss.pageno=v_curPageNo';
  
  open cur_rows for query_sql;
  
  query_sql:='select count( ' ||v_countId|| ' ) into ' || v_maxRowNumber || ' from ' || v_condition;

  return cur_rows;
  exception
    when others then
      v_erro:=Sqlerrm;
      return cur_rows;
end;
 --联合team表和student表查询所传班级id的所有学生

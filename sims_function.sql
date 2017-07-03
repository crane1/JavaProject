create or replace function getSimsPageRows(
v_maxPageRows number,
v_curPageNo number,
v_attribute varchar2,  --��Ҫ��ѯ�������ַ���
v_condition varchar2,  --��Ҫ��ѯ����������
v_countId varchar2,   --��Ҫ��ѯ��¼������id
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
 --����team���student���ѯ�����༶id������ѧ��

--sqlʵ�ִ洢���̵���ɾ�ģ� ���ҽ���jdbc���ã�2017.04.20��

--�������
--����һ����ʱ����books��ṹ��ͬ
create global temporary table temp_books on commit delete rows as select * from books;

select * from temp_books;

select * from books;


--�����洢���̣�����������޸�ԭʼ�����ݣ�������ʱ��������������ݣ�һ��ִ��һ������

-- v_type ��������
create or replace procedure operateBooks( v_operate_type varchar) 
as
cur_temp_books sys_refcursor;  --��ȡ��ʱ����α�
--����ÿһ�еı���������������ʱ�������
v_id books.id%type;
v_name books.name%type;
v_author books.author%type;
v_publish books.publish%type;
v_totalnum books.totalnum%type;
v_remaindernum books.remaindernum%type;
v_type books.type%type;

v_oldrows number(5):=0;
v_newrows number(5):=0
begin
/*    select count(books.id) v_oldrows from books; --��ȡԭʼ��������*/
    open cur_temp_books for select * from temp_books; --��ȡ��ʱ������
    
    if(v_operate_type = 'insert') then
        fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --��ȡ��ʱ������
        while(cur_temp_books%found) loop
            --�����ȡ����ÿһ������
            insert into books values(v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type);
            fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --��ȡ��ʱ������
        end loop;
        commit;
        
    elsif (v_operate_type = 'update') then
        fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --��ȡ��ʱ������
        while(cur_temp_books%found) loop
            --���»�ȡ����ÿһ������
            update books set books.name = v_name, books.author = v_author, books.publish = v_publish,
                books.totalnum = v_totalnum, books.remaindernum = v_remaindernum, books.type = v_type
            where books.id = v_id;
            fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --��ȡ��ʱ������
        end loop;
        commit;
    elsif(v_operate_type = 'delete') then
        fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --��ȡ��ʱ������
        while(cur_temp_books%found) loop
            --ɾ����ȡ����ÿһ������
            delete books where books.id = v_id;     
            fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --��ȡ��ʱ������
        end loop;
        commit;
    end if;
/*    select count(books.id) v_newrows from books;   --��ȡ���º���������
    v_result:=v_oldrows - v_newrows*/
end operateBooks;

insert into books values('12342','��¥��', '��ѩ��', '���ճ�����', 12, 12, 'С˵');

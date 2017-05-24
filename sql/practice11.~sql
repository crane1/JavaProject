--sql实现存储过程的增删改， 并且进行jdbc调用（2017.04.20）

--创表语句
--创建一个临时表，和books表结构相同
create global temporary table temp_books on commit delete rows as select * from books;

select * from temp_books;

select * from books;


--创建存储过程，在这个里面修改原始表数据，根据临时表数据里面的数据，一次执行一个操作

-- v_type 操作类型
create or replace procedure operateBooks( v_operate_type varchar) 
as
cur_temp_books sys_refcursor;  --获取临时表的游标
--设置每一列的变量，用来接收临时表的数据
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
/*    select count(books.id) v_oldrows from books; --获取原始数据数量*/
    open cur_temp_books for select * from temp_books; --获取临时表数据
    
    if(v_operate_type = 'insert') then
        fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --提取临时表内容
        while(cur_temp_books%found) loop
            --插入获取到的每一条数据
            insert into books values(v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type);
            fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --提取临时表内容
        end loop;
        commit;
        
    elsif (v_operate_type = 'update') then
        fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --提取临时表内容
        while(cur_temp_books%found) loop
            --更新获取到的每一条数据
            update books set books.name = v_name, books.author = v_author, books.publish = v_publish,
                books.totalnum = v_totalnum, books.remaindernum = v_remaindernum, books.type = v_type
            where books.id = v_id;
            fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --提取临时表内容
        end loop;
        commit;
    elsif(v_operate_type = 'delete') then
        fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --提取临时表内容
        while(cur_temp_books%found) loop
            --删除获取到的每一条数据
            delete books where books.id = v_id;     
            fetch cur_temp_books into v_id, v_name, v_author, v_publish, v_totalnum, v_remaindernum, v_type; --提取临时表内容
        end loop;
        commit;
    end if;
/*    select count(books.id) v_newrows from books;   --获取更新后数据数量
    v_result:=v_oldrows - v_newrows*/
end operateBooks;

insert into books values('12342','红楼梦', '曹雪芹', '文艺出版社', 12, 12, '小说');

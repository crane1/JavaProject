
        
create table accounts(
    id varchar(15) primary key not null,
    pwd varchar(20) not null,
    name varchar(25),
    address varchar(50),
    telephone varchar(20),
    type number(1),
    balance number(10,2),
    isonline number(1)
     );
     
select * from accounts; 
commit;
commit;

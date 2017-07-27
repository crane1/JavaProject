create table s_student(
       s_id varchar(25),
       s_name varchar(25),
       s_sex varchar(6),
       s_age number(6),
       s_gradinst varchar(50)
);
prompt PL/SQL Developer import file
prompt Created on 2017��6��2�� by lizem
set feedback off
set define off
prompt Disabling triggers for S_STUDENT...
alter table S_STUDENT disable all triggers;
prompt Deleting S_STUDENT...
delete from S_STUDENT;
commit;
prompt Loading S_STUDENT...
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020701', 'С�İ�01', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020702', 'С�İ�02', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020703', 'С�İ�03', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020704', 'С�İ�04', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020705', 'С�İ�05', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020706', 'С�İ�06', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020707', 'С�İ�07', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020708', 'С�İ�08', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020709', 'С�İ�09', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020710', 'С�İ�10', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020711', 'С�İ�11', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020712', 'С�İ�12', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020713', 'С�İ�13', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020714', 'С�İ�14', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020715', 'С�İ�15', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020716', 'С�İ�16', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020717', 'С�İ�17', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020718', 'С�İ�18', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020719', 'С�İ�19', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020720', 'С�İ�20', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020721', 'С�İ�21', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020722', 'С�İ�22', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020723', 'С�İ�23', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020724', 'С�İ�24', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020725', 'С�İ�25', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020726', 'С�İ�26', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020727', 'С�İ�27', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020728', 'С�İ�28', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020729', 'С�İ�29', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020730', 'С�İ�30', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020731', 'С�İ�31', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020732', 'С�İ�32', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020733', 'С�İ�33', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020734', 'С�İ�34', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020735', 'С�İ�35', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020736', 'С�İ�36', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020737', 'С�İ�37', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020738', 'С�İ�38', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020739', 'С�İ�39', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020740', 'С�İ�40', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020741', 'С�İ�41', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020742', 'С�İ�42', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020743', 'С�İ�43', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020744', 'С�İ�44', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020745', 'С�İ�45', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020746', 'С�İ�46', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020747', 'С�İ�47', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020748', 'С�İ�48', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020749', 'С�İ�49', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020750', 'С�İ�50', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020751', 'С�İ�51', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020752', 'С�İ�52', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020753', 'С�İ�53', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020754', 'С�İ�54', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020755', 'С�İ�55', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020756', 'С�İ�56', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020757', 'С�İ�57', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020758', 'С�İ�58', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020759', 'С�İ�59', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020760', 'С�İ�60', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020761', 'С�İ�61', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020762', 'С�İ�62', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020763', 'С�İ�63', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020764', 'С�İ�64', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020765', 'С�İ�65', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020766', 'С�İ�66', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020767', 'С�İ�67', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020768', 'С�İ�68', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020769', 'С�İ�69', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020770', 'С�İ�70', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020771', 'С�İ�71', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020772', 'С�İ�72', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020773', 'С�İ�73', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020774', 'С�İ�74', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020775', 'С�İ�75', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020776', 'С�İ�76', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020777', 'С�İ�77', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020778', 'С�İ�78', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020779', 'С�İ�79', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020780', 'С�İ�80', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020781', 'С�İ�81', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020782', 'С�İ�82', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020783', 'С�İ�83', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020784', 'С�İ�84', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020785', 'С�İ�85', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020786', 'С�İ�86', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020787', 'С�İ�87', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020788', 'С�İ�88', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020789', 'С�İ�89', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020790', 'С�İ�90', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020791', 'С�İ�91', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020792', 'С�İ�92', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020793', 'С�İ�93', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020794', 'С�İ�94', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020795', 'С�İ�95', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020796', 'С�İ�96', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020797', 'С�İ�97', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020798', 'С�İ�98', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020799', 'С�İ�99', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020800', 'С�İ�100', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
commit;
prompt 100 records committed...
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020801', 'С�İ�101', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020802', 'С�İ�102', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020803', 'С�İ�103', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020804', 'С�İ�104', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020805', 'С�İ�105', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020806', 'С�İ�106', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020807', 'С�İ�107', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020808', 'С�İ�108', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020809', 'С�İ�109', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020810', 'С�İ�110', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020811', 'С�İ�111', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020812', 'С�İ�112', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020813', 'С�İ�113', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020814', 'С�İ�114', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020815', 'С�İ�115', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020816', 'С�İ�116', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020817', 'С�İ�117', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020818', 'С�İ�118', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020819', 'С�İ�119', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020820', 'С�İ�120', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020821', 'С�İ�121', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020822', 'С�İ�122', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020823', 'С�İ�123', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020824', 'С�İ�124', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020825', 'С�İ�125', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020826', 'С�İ�126', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020827', 'С�İ�127', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020828', 'С�İ�128', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020829', 'С�İ�129', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020830', 'С�İ�130', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020831', 'С�İ�131', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020832', 'С�İ�132', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020833', 'С�İ�133', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020834', 'С�İ�134', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020835', 'С�İ�135', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020836', 'С�İ�136', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020837', 'С�İ�137', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020838', 'С�İ�138', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020839', 'С�İ�139', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020840', 'С�İ�140', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020841', 'С�İ�141', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020842', 'С�İ�142', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020843', 'С�İ�143', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020844', 'С�İ�144', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020845', 'С�İ�145', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020846', 'С�İ�146', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020847', 'С�İ�147', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020848', 'С�İ�148', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020849', 'С�İ�149', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020850', 'С�İ�150', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020851', 'С�İ�151', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020852', 'С�İ�152', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020853', 'С�İ�153', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020854', 'С�İ�154', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020855', 'С�İ�155', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020856', 'С�İ�156', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020857', 'С�İ�157', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020701', 'С�İ�01', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020702', 'С�İ�02', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020703', 'С�İ�03', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020704', 'С�İ�04', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020705', 'С�İ�05', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020706', 'С�İ�06', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020707', 'С�İ�07', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020708', 'С�İ�08', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020709', 'С�İ�09', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020710', 'С�İ�10', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020711', 'С�İ�11', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020712', 'С�İ�12', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020713', 'С�İ�13', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020714', 'С�İ�14', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020715', 'С�İ�15', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020716', 'С�İ�16', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020717', 'С�İ�17', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020718', 'С�İ�18', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020719', 'С�İ�19', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020720', 'С�İ�20', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020721', 'С�İ�21', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020722', 'С�İ�22', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020723', 'С�İ�23', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020724', 'С�İ�24', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020725', 'С�İ�25', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020726', 'С�İ�26', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020727', 'С�İ�27', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020728', 'С�İ�28', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020729', 'С�İ�29', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020730', 'С�İ�30', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020731', 'С�İ�31', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020732', 'С�İ�32', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020733', 'С�İ�33', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020734', 'С�İ�34', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020735', 'С�İ�35', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020736', 'С�İ�36', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020737', 'С�İ�37', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020738', 'С�İ�38', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020739', 'С�İ�39', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020740', 'С�İ�40', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020741', 'С�İ�41', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020742', 'С�İ�42', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020743', 'С�İ�43', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
commit;
prompt 200 records committed...
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020744', 'С�İ�44', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020745', 'С�İ�45', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020746', 'С�İ�46', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020747', 'С�İ�47', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020748', 'С�İ�48', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020749', 'С�İ�49', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020750', 'С�İ�50', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020751', 'С�İ�51', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020752', 'С�İ�52', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020753', 'С�İ�53', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020754', 'С�İ�54', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020755', 'С�İ�55', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020756', 'С�İ�56', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020757', 'С�İ�57', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020758', 'С�İ�58', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020759', 'С�İ�59', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020760', 'С�İ�60', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020761', 'С�İ�61', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020762', 'С�İ�62', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020763', 'С�İ�63', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020764', 'С�İ�64', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020765', 'С�İ�65', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020766', 'С�İ�66', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020767', 'С�İ�67', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020768', 'С�İ�68', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020769', 'С�İ�69', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020770', 'С�İ�70', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020771', 'С�İ�71', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020772', 'С�İ�72', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020773', 'С�İ�73', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020774', 'С�İ�74', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020775', 'С�İ�75', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020776', 'С�İ�76', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020777', 'С�İ�77', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020778', 'С�İ�78', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020779', 'С�İ�79', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020780', 'С�İ�80', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020781', 'С�İ�81', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020782', 'С�İ�82', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020783', 'С�İ�83', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020784', 'С�İ�84', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020785', 'С�İ�85', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020786', 'С�İ�86', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020787', 'С�İ�87', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020788', 'С�İ�88', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020789', 'С�İ�89', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020790', 'С�İ�90', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020791', 'С�İ�91', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020792', 'С�İ�92', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020793', 'С�İ�93', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020794', 'С�İ�94', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020795', 'С�İ�95', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020796', 'С�İ�96', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020797', 'С�İ�97', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020798', 'С�İ�98', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020799', 'С�İ�99', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020800', 'С�İ�100', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020801', 'С�İ�101', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020802', 'С�İ�102', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020803', 'С�İ�103', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020804', 'С�İ�104', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020805', 'С�İ�105', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020806', 'С�İ�106', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020807', 'С�İ�107', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020808', 'С�İ�108', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020809', 'С�İ�109', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020810', 'С�İ�110', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020811', 'С�İ�111', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020812', 'С�İ�112', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020813', 'С�İ�113', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020814', 'С�İ�114', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020815', 'С�İ�115', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020816', 'С�İ�116', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020817', 'С�İ�117', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020818', 'С�İ�118', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020819', 'С�İ�119', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020820', 'С�İ�120', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020821', 'С�İ�121', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020822', 'С�İ�122', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020823', 'С�İ�123', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020824', 'С�İ�124', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020825', 'С�İ�125', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020826', 'С�İ�126', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020827', 'С�İ�127', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020828', 'С�İ�128', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020829', 'С�İ�129', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020830', 'С�İ�130', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020831', 'С�İ�131', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020832', 'С�İ�132', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020833', 'С�İ�133', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020834', 'С�İ�134', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020835', 'С�İ�135', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020836', 'С�İ�136', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020837', 'С�İ�137', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020838', 'С�İ�138', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020839', 'С�İ�139', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020840', 'С�İ�140', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020841', 'С�İ�141', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020842', 'С�İ�142', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020843', 'С�İ�143', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
commit;
prompt 300 records committed...
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020844', 'С�İ�144', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020845', 'С�İ�145', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020846', 'С�İ�146', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020847', 'С�İ�147', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020848', 'С�İ�148', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020849', 'С�İ�149', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020850', 'С�İ�150', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020851', 'С�İ�151', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020852', 'С�İ�152', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020853', 'С�İ�153', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020854', 'С�İ�154', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020855', 'С�İ�155', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020856', 'С�İ�156', 'Ů   ', 22, '������̲�ʼҹ�ҵѧԺ');
insert into S_STUDENT (S_ID, S_NAME, S_SEX, S_AGE, S_GRADINST)
values ('java020857', 'С�İ�157', '��   ', 23, '������̲�ʼҹ�ҵѧԺ');
commit;
prompt 314 records loaded
prompt Enabling triggers for S_STUDENT...
alter table S_STUDENT enable all triggers;
set feedback on
set define on
prompt Done.
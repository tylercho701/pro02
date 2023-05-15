create table notice(idx int,
                    title varchar2(100) not null,
                    content varchar2(1000),
                    author varchar2(20),
                    file1 varchar2(200),
                    resdate date default sysdate,
                    primary key(idx));
                    
create sequence noti_seq;

select * from notice;
desc notice;
update notice set file1 = 'data/null';

select * from user1;
insert into user1 values ('admin', '1234', '관리자', '010-1234-1234', '고양시 일산서구', 'admin@daiso.com', default, default);
desc user1;
commit;

alter table user1 add visited int default 0;
update user1 set point = 0 where id = 'admin';

update user1 set pw = 'Artdp3nEb5PqAsZvf5MJuzxM0ZVQXE6K0HvLecTf5a3v30c+vDLfcHSJhATnRWNREGRTFg==' where id = 'tyler';
update user1 set pw = 'Artdp3nEb5PqAsZvf5MJuzxM0ZVQXE6K0HvLecTf5a3v30c+vDLfcHSJhATnRWNREGRTFg==' where id = 'admin';
update user1 set pw = 'wKsfl1hIWS1W93fSVhBBNQmQm4AwvP4RNk4ftO3vt3Lc10dUv7pZmTNg1uxcPEEYofjDuQ==' where id = 'choi';
update user1 set pw = 'PRROS7MCou10EgRCOM52L1CgTCc5EvItm31l4DiREviBsijldBdLwssUQ2m7kg4+RRfAeQ==' where id = 'kim';
update user1 set pw = 'XRbVarg2mW2A0PdnK/bx9+0Y91yr8ZnRQoa73JS4OcLKcWyPazlapQ679axySbwjzWt20w==' where id = 'park';
update user1 set pw = 'gzwaSygqT2hXl6TlJ84OUBRN1/J6EWR9eSFJJQf5wLLAG3js0yBQApnoRDsSCClzGrNc9A==' where id = 'lee';
update user1 set pw = '' where id = '';
update user1 set pw = '' where id = '';


insert into notice 
    values (noti_seq.nextval, '테스트 게시글 제목1', '테스트 게시글 내용입니다.1', '관리자', '', default);
insert into notice 
    values (noti_seq.nextval, '테스트 게시글 제목2', '테스트 게시글 내용입니다.2', '관리자', '', default);
insert into notice 
    values (noti_seq.nextval, '테스트 게시글 제목3', '테스트 게시글 내용입니다.3', '관리자', '', default);
alter table notice add readcnt int default 0;

create table category(catecode varchar2(6),
                      categroup varchar2(50),
                      catename varchar2(50),
                      primary key(catecode));
insert into category values ('0101', '보관/정리/수납', '리빙박스(플라스틱)');
insert into category values ('0102', '보관/정리/수납', '정리함');
insert into category values ('0103', '보관/정리/수납', '옷걸이/헹거');
insert into category values ('0104', '보관/정리/수납', '공구함/약통');
insert into category values ('0105', '보관/정리/수납', '서랍장/서류함');
                      
insert into category values ('0201', '청소', '휴지통');
insert into category values ('0202', '청소', '걸레/솔');
insert into category values ('0203', '청소', '매직블럭');
insert into category values ('0204', '청소', '롤크리너');
insert into category values ('0205', '청소', '빗자루/쓰레받이');

insert into category values ('0301', '거실/잡화', '거실화/슬리퍼');
insert into category values ('0302', '거실/잡화', '발매트');
insert into category values ('0303', '거실/잡화', '휴지/물티슈');
insert into category values ('0304', '거실/잡화', '우산/우비');
insert into category values ('0305', '거실/잡화', '돗자리/생활매트');

insert into category values ('0401', '욕실', '비누받침/양치컵');
insert into category values ('0402', '욕실', '발매트');
insert into category values ('0403', '욕실', '변기세척');
insert into category values ('0404', '욕실', '샤워용품');
insert into category values ('0405', '욕실', '칫솔/치실');


alter table product add category varchar2(6);
select * from product;
update product set category = '0102' where pcode = '36080';
update product set category = '0203' where pcode = '1019714';
update product set category = '0303' where pcode = '1000865';
update product set category = '0203' where pcode = '51719';
update product set category = '0403' where pcode = '1019185';
update product set category = '0103' where pcode = '1036976';

desc product;
desc category;
desc basket;
desc order1;
desc payment;

select * from user1;
select * from notice;
select * from basket;
select * from product;
select * from payment;
select * from order1;

delete from payment where pnum = '96547';
delete from order1 where onum = '10006';

select basket.bnum as bnum, basket.id as id, user1.uname as uname, basket.pcode as pcode, product.pname as pname, basket.amount as amount, product.price as price from basket, user1, product where basket.id=user1.id and basket.pcode=product.pcode;
select basket.bnum as bnum, basket.id as id, user1.uname as uname, basket.pcode as pcode, product.pname as pname, basket.amount as amount, product.price as price from basket, user1, product where basket.id=user1.id and basket.pcode=product.pcode and basket.id='tyler';

select * from product where category like '01%';
select * from product where category like '01'||'%';
select * from product where category like concat('01', '%');
select * from category;

update product set pic1 = './images/1020102_main.gif' where pcode = '1020102';
update product set pic2 = './images/1020102_sub2.jpg' where pcode = '1020102';
update product set pic3 = './images/1020102_sub3.jpg' where pcode = '1020102';

update product set pic3 = './images/1019185_sub3.jpg' where pcode = '1019185';

commit;

alter table order1 drop constraint FK_ORPC;

select * from basket;
select * from category;
select * from notice;
select * from order1;
update order1 set dstatus='배송완료' where onum='10008';
select * from payment;
select * from product;
select * from review;
select * from user1

select review.rnum as rnum, review.id as id, review.onum as onum, review.writtendate as writtendate, review.rcom as rcom, order1.pcode as pcode, order1.odate as odate, order1.dstatus as dstatus from review, order1 where review.id = order1.id and order1.pcode = '1000865' order by review.rnum desc;
select distinct review.rnum as rnum, review.id as id, review.onum as onum, review.writtendate as writtendate, review.rcom as rcom, order1.pcode as pcode, order1.odate as odate, order1.dstatus as dstatus from review, order1 where review.id = order1.id and order1.pcode = '1000865' order by review.rnum desc;
select rnum from (select * from review order by rnum desc) where rownum = 1;
desc basket;
desc category;
desc notice;
desc order1;
desc payment;
desc product;
desc review;
desc user1;
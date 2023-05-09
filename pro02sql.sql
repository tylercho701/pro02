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
commit;
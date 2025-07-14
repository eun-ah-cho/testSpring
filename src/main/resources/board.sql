---  시퀀스 객체 생성
create sequence seq_board1;

-- 시퀀스 삭제(차후에 활용)
drop sequence seq_board1;

create table tbl_board1(
   bno number(10,0),            --게시물 번호
   title varchar2(200) not null,   -- 제목
   content varchar2(2000) not null,-- 내용
   writer varchar2(50) not null,   -- 작성자
   regdate date default sysdate,   --작성일(자동으로 db가 입력)
   updatedate date default sysdate   -- 수정인(자동으로 db가 입력)
); -- 테이블 생성

alter table tbl_board1 add constraint pk_board1 primary key (bno);


--더미데이터 입력
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목1', '테스트내용1', 'user01');
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목2', '테스트내용2', 'user02');
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목3', '테스트내용3', 'user03');
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목4', '테스트내용4', 'user04');
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목5', '테스트내용5', 'user05');
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목6', '테스트내용6', 'user06');
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목7', '테스트내용7', 'user07');
insert into tbl_board1(bno, title, content, writer)
values (seq_board1.nextval, '테스트제목8', '테스트내용8', 'user08');

select * from tbl_board1;
SELECT * FROM tbl_board1 ORDER BY bno DESC;


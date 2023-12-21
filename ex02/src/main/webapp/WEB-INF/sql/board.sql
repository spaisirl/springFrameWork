create table tbl_board(
    bno number primary key, -- 글번호
    title varchar2(200) not null, -- 글제목
    content varchar2(2000) not null, -- 글내용
    writer varchar2(50) not null, -- 작성자
    regdate date default sysdate, -- 작성일
    updatedate date default sysdate -- 수정일
);

create sequence seq_board;

select * from tbl_board;
commit;
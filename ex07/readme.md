#DB
create table tbl_reply(
    rno number(10,0),
    bno number(10,0) not null,
    reply varchar2(1000) not null,
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
);
--sequence 생성
create SEQUENCE seq_reply;
--기본키 생성(rno)
alter table tbl_reply add constraint pk_reply primary key(rno);
--외래키 생성(bno => tbl_board)
alter table tbl_reply add constraint fk_reply_board 
    foreign key(bno) references tbl_board(bno);
    
--파일 업로드
create table tbl_attach(
	uuid varchar2(100) not null,
	uploadPath varchar2(200) not null,
	fileName varchar2(100) not null,
	filetype char(1) default 'I',
	bno number(10,0)
);
alter table tbl_attach add constraint pk_attach primary key(uuid);
alter table tbl_attach add constraint fk_board_attach foreign key(bno) references tbl_board(bno);


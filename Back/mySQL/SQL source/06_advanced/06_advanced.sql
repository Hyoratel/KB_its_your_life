-- 1.sqldb에서 usertbl 테이블에서 다음 내용들을 확인하세요
use sqldb;
-- 1)usertbl 내용 확인
select * from usertbl;
-- 2)usertbl 인덱스 목록 확인
show index from usertbl;
-- 3)usertbl 데이터 와 인덱스 크기 확인
show table status like 'usertbl';

-- 2.usertbl의 addr 컬럼에 대해 idx_usertbl_addr이름으로 인덱스를 만들고, 인덱스 목록을 확인하세요.
create index idx_usertbl_addr
on usertbl(addr);

show index from usertbl;

-- 사용할 database 지정
USE employees;
-- database 조회
SHOW DATABASES;
-- 테이블 상태 조회
SHOW TABLE STATUS;
-- 특정 테이블 명세 조회
DESC employees;
-- 데이터 추출
SELECT first_name, last_name, birth_date
FROM employees;

-- 결과집합의 컬럼명 변경
SELECT first_name AS '나의 이름',
       last_name AS '성',
       birth_date AS '생년월일'
FROM employees;

-- 조건절이 없으면 모듵 데이터를 가져온다
-- 조건절
SELECT *
FROM usertbl
WHERE name = '김경호';

-- 1970년 이후 출생, 신장이 182이상인 사람의 아이디와 이름 조회
SELECT userid, name
FROM usertbl
WHERE (birthYear >= 1970) AND (height >=182);

-- 키가 180에서 183인 사람의 이름과 아이디 조회
SELECT userid, name
FROM usertbl
WHERE height BETWEEN 180 AND 183;

-- 지역이 경남, 전남, 경북 인 사람의 이름과 지역 조회
SELECT name, addr
FROM usertbl
WHERE addr = '경남' OR addr = '전남' OR addr = '경북';

SELECT name, addr
FROM usertbl
WHERE addr IN('경남', '전남', '경북');

-- 패턴 매칭
-- 김씨 성을 가진 사람들의 이름과 키를 조회
SELECT name, height
FROM usertbl
WHERE name LIKE '김%' ;







 
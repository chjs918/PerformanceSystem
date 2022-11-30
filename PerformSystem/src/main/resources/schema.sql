DROP SEQUENCE Sequence_211;

CREATE SEQUENCE Sequence_211
	INCREMENT BY 1
	START WITH 1;

DROP TABLE Recommend CASCADE CONSTRAINTS PURGE;

DROP TABLE Review CASCADE CONSTRAINTS PURGE;

DROP TABLE MyPerformanceList CASCADE CONSTRAINTS PURGE;

DROP TABLE Member CASCADE CONSTRAINTS PURGE;

DROP TABLE Performance CASCADE CONSTRAINTS PURGE;

CREATE TABLE Member
(
	member_id            INT  NOT NULL ,
	id                   CHAR(15)  NULL ,
	password             CHAR(20)  NULL ,
	name		CHAR(50)  NULL ,
    gender               CHAR(1)  DEFAULT 'F' CONSTRAINT  Gender_Rule_247234452 CHECK (gender IN ('M', 'F')),
	birth                DATE  NULL ,
	email                VARCHAR2(20)  NULL ,
	area                 CHAR(1)  NULL ,
	strength             CHAR(1)  NULL ,
	types                 CHAR(1)  NULL ,
	views                 CHAR(1)  NULL ,
	stable               CHAR(1)  NULL 
);

CREATE UNIQUE INDEX XPKMember ON Member
(member_id   ASC);

ALTER TABLE Member
	ADD CONSTRAINT  XPKMember PRIMARY KEY (member_id);

CREATE TABLE Performance
(
    performance_id       INT  NOT NULL ,
	name                 VARCHAR2(100)  NULL ,
	startDate            DATE  NULL ,
	endDate              DATE  NULL ,
	ageGroup             CHAR(2)  NULL ,
	runTime              VARCHAR2(50)  NULL ,
	cast                 VARCHAR2(150)  NULL ,
	price                NUMBER  NULL ,
	category             VARCHAR2(50)  NULL ,
	site_link            VARCHAR2(100)  NULL ,
	performance_img      VARCHAR2(100)  NULL ,
	rank                 INTEGER  NULL ,
	venue                VARCHAR2(50)  NULL 
);

CREATE UNIQUE INDEX XPKPerformance ON Performance
(performance_id   ASC);

ALTER TABLE Performance
	ADD CONSTRAINT  XPKPerformance PRIMARY KEY (performance_id);

CREATE TABLE Recommend
(
	recommend_id         INT  NOT NULL ,
	recommend_img        VARCHAR2(100)  NULL ,
	performance_id       INT  NOT NULL ,
	recommend_seat       VARCHAR2(100)  NULL ,
	area                 CHAR(1)  NULL ,
	strength             CHAR(1)  NULL ,
	types                 CHAR(1)  NULL ,
	views                 CHAR(1)  NULL ,
	stable               CHAR(1)  NULL 
);

CREATE UNIQUE INDEX XPKRecommend ON Recommend
(recommend_id   ASC);

ALTER TABLE Recommend
	ADD CONSTRAINT  XPKRecommend PRIMARY KEY (recommend_id);

CREATE TABLE Review
(
	review_id            CHAR(18)  NOT NULL ,
	title                VARCHAR2(100)  NULL ,
	performance_id       INT  NOT NULL ,
	member_id            INT  NOT NULL ,
	content              VARCHAR2(500)  NULL 
);

CREATE UNIQUE INDEX XPKReview ON Review
(review_id   ASC);

ALTER TABLE Review
	ADD CONSTRAINT  XPKReview PRIMARY KEY (review_id);

CREATE TABLE MyPerformanceList
(
	performance_id       INT  NOT NULL ,
	member_id            INT  NOT NULL 
);

CREATE UNIQUE INDEX XPKMyPerformanceList ON MyPerformanceList
(performance_id   ASC,member_id   ASC);

ALTER TABLE MyPerformanceList
	ADD CONSTRAINT  XPKMyPerformanceList PRIMARY KEY (performance_id,member_id);

CREATE VIEW Performance_View ( category,runTime,ageGroup,cast ) 
	 AS  SELECT Performance.category,Performance.runTime,Performance.ageGroup,Performance.cast
		FROM Performance ;

ALTER TABLE Recommend
	ADD (
CONSTRAINT R_10 FOREIGN KEY (performance_id) REFERENCES Performance (performance_id));

ALTER TABLE Review
	ADD (
CONSTRAINT R_8 FOREIGN KEY (performance_id) REFERENCES Performance (performance_id));

ALTER TABLE Review
	ADD (
CONSTRAINT R_9 FOREIGN KEY (member_id) REFERENCES Member (member_id));

ALTER TABLE MyPerformanceList
	ADD (
CONSTRAINT R_1 FOREIGN KEY (performance_id) REFERENCES Performance (performance_id));

ALTER TABLE MyPerformanceList
	ADD (
CONSTRAINT R_3 FOREIGN KEY (member_id) REFERENCES Member (member_id));

INSERT INTO Performance VALUES (Sequence_211.nextval, '2022 서울그린아트페스티벌', '2022-12-07', '2022-12-08', '00', '90', '웅산/이주미/유사랑/이대원/박라온/마리아킴/김효정/박재홍/김민희/조정희/남예지'
	, 20000, '콘서트', 'http://ticket.yes24.com/Perf/44021?Gcode=009_308', 'http://tkfile.yes24.com/upload2/PerfBlog/202211/20221104/20221104-44021.jpg'
	, 0, '노들섬 라이브하우스');
	
INSERT INTO Performance VALUES (Sequence_211.nextval, '해리 스타일스 첫 내한공연（HARRY STYLES LOVE ON TOUR 2023 - Live in Seoul', '2023-03-20', '2023-03-20', '00', '75', '해리 스타일스 (Harry Styles)'
	, 88000, '콘서트', 'http://ticket.yes24.com/Special/44112', 'http://tkfile.yes24.com/upload2/PerfBlog/202211/20221116/20221116-44112.jpg'
	, 0, '올림픽체조경기장');

INSERT INTO Performance VALUES (Sequence_211.nextval, '[서울] 2022년 ‘Dream 55’ 나훈아 앵콜 콘서트', '2022-12-17', '2022-12-18', '10', '120', '나훈아'
	, 121000, '콘서트', 'http://ticket.yes24.com/Special/44018', 'http://tkfile.yes24.com/upload2/PerfBlog/202211/20221107/20221107-44018.jpg'
	, 0, '올림픽체조경기장');
	
INSERT INTO Performance VALUES (Sequence_211.nextval, '[성남] 2022 멜로망스 콘서트 〈Festival〉', '2023-02-11', '2023-02-12', '07', '120', '멜로망스'
	, 110000, '콘서트', 'http://ticket.yes24.com/Perf/44158', 'http://tkfile.yes24.com/upload2/PerfBlog/202211/20221116/20221116-44158.jpg'
	, 0, '성남아트센터 오페라하우스');
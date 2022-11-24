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
	gender               CHAR(1)  DEFAULT female  NULL  CONSTRAINT  Gender_Rule_247234452 CHECK (gender IN ('male', 'female')),
	birth                DATE  NULL ,
	email                VARCHAR2(20)  NULL ,
	area                 CHAR(1)  NULL ,
	strength             CHAR(1)  NULL ,
	type                 CHAR(1)  NULL ,
	view                 CHAR(1)  NULL ,
	stable               CHAR(1)  NULL 
);

CREATE UNIQUE INDEX XPKMember ON Member
(member_id   ASC);

ALTER TABLE Member
	ADD CONSTRAINT  XPKMember PRIMARY KEY (member_id);

CREATE TABLE Performance
(
	name                 VARCHAR2()  NULL ,
	startDate            DATE  NULL ,
	endDate              DATE  NULL ,
	performance_id       INT  NOT NULL ,
	ageGroup             CHAR(2)  NULL ,
	runTime              VARCHAR2()  NULL ,
	cast                 VARCHAR2(50)  NULL ,
	price                NUMBER  NULL ,
	category             VARCHAR2()  NULL ,
	site_link            VARCHAR2()  NULL ,
	performance_img      VARCHAR2()  NULL ,
	rank                 INTEGER  NULL ,
	venue                VARCHAR2()  NULL 
);

CREATE UNIQUE INDEX XPKPerformance ON Performance
(performance_id   ASC);

ALTER TABLE Performance
	ADD CONSTRAINT  XPKPerformance PRIMARY KEY (performance_id);

CREATE TABLE Recommend
(
	recommend_id         INT  NOT NULL ,
	recommend_img        VARCHAR2()  NULL ,
	performance_id       INT  NOT NULL ,
	recommend_seat       VARCHAR2()  NULL ,
	area                 CHAR(1)  NULL ,
	strength             CHAR(1)  NULL ,
	type                 CHAR(1)  NULL ,
	view                 CHAR(1)  NULL ,
	stable               CHAR(1)  NULL 
);

CREATE UNIQUE INDEX XPKRecommend ON Recommend
(recommend_id   ASC);

ALTER TABLE Recommend
	ADD CONSTRAINT  XPKRecommend PRIMARY KEY (recommend_id);

CREATE TABLE Review
(
	review_id            CHAR(18)  NOT NULL ,
	title                VARCHAR2()  NULL ,
	performance_id       INT  NOT NULL ,
	member_id            INT  NOT NULL ,
	content              VARCHAR2()  NULL 
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
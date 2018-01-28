create schema srecom;

drop table SRECOM.ARTICLE;
create table SRECOM.ARTICLE(
	ID INTEGER NOT NULL,
	TEST_COLUMN VARCHAR(128)
);

create table SRECOM.ARTICLE_CATEGORY(
	ID INTEGER NOT NULL
);

SELECT * FROM sys.systables where TABLETYPE = 'T';

SELECT * FROM SYS.SYSCOLUMNS where REFERENCEID = (select tableid from SYS.SYSTABLES where TABLENAME = 'ARTICLE');
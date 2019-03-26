--create user table 
--DDL 

CREATE TABLE DEMO_USER(
	U_ID NUMBER(10) PRIMARY KEY,
	USERNAME VARCHAR2(36) UNIQUE NOT NULL,
	PASSWORD VARCHAR2(36) NOT NULL,
	BIO VARCHAR2(300) 
);

--SEQUENCESS - set of integers that are generated in order on demand
-- usually used for autoincrementing primary keys 
CREATE SEQUENCE DEMO_USER_SEQ;

--DUAL TABLE -- dummy table to maintain syntax 
SELECT SYSDATE FROM DUAL;
select * from dual;

/*    TRIGGERS
  a trigger is a special type of stored procedure that automatically executes when an 
  event occurs in the database server. DML triggers execute when a user tries to
  modify data through a DML event. We will use them BEFORE each INSERT on a table
  to get the next value of our sequence and assign it to the PK value
*/

CREATE OR REPLACE TRIGGER DEMO_USER_TRIG -- declare the name 
BEFORE INSERT ON DEMO_USER -- when will trigger execute
FOR EACH ROW -- necessary to change value in table 
BEGIN
	-- SQL statements we want to happen in trigger
	SELECT DEMO_USER_SEQ.NEXTVAL INTO :NEW.U_ID FROM DUAL;
END;
/

select * from demo_user; 
insert into demo_user(username, password, bio)
values('genesisb', '123', 'trainer who trains people in things');

commit; 



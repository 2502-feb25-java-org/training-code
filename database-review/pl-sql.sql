/*
PL/SQL - procedural language extension of/for structured query language
oracle SQL procedural langauge, allows us to write blocks of code in our db
*/

/*
STORED PROCEDURES
- blocks of code compiled and stored in db 
- can take in/out parameters
- do not have return type 
- full DML and TCL capabilities 
*/
CREATE OR REPLACE PROCEDURE helloWorld
AS -- delcare any parameters, can also be IS
BEGIN
  -- here is where procedural code goes
  dbms_output.put_line('a.ziuhgltisurhygtiushgieajgoij!');
END;
/
execute helloWorld;

-- get artist by id 
CREATE OR REPLACE PROCEDURE get_artist_by_id(
  a_id IN number, 
  a_name OUT varchar2)
is
begin
  select name INTO a_name 
  from artist where artistid = a_id;
end;
/

-- non compiled block of pl/sql code to run procedure
declare 
  art_name varchar2(100);
begin
  get_artist_by_id(100, art_name);
  dbms_output.put_line(art_name);
end;
  /
  
      -- a peek into explicit cursors; here we will return all artists in a cursor 
  create or replace procedure get_all_artists(
      cursorParam OUT SYS_REFCURSOR)
      is
    begin
      open cursorParam for select * from artist;
    end;
    /
    
  declare 
  my_cursor sys_refcursor; --name for outparam from procedure
  art_id number;
  art_name varchar2(100);
begin
 get_all_artists(my_cursor);
 loop --iterate through every row in cursor
    Fetch my_cursor into art_id, art_name;
    EXIT when my_cursor%NOTFOUND;
    dbms_output.put_line(art_name);
 end loop;
end;
  /
  
  select * from artist;
  
      --- functions 
    /* Functions are blocks of code we can 
	execute that must return 1 value
   They may take in 0 or more parameters
   Invoke statements using ()
   Can only use DQL(SELECT) statements, not INSERT, 
   UPDATE, or DELETE
*/
--get total number of artists 
create or replace function get_num_artists
  return number 
is -- OR as, where we give return variable a name
  total number;
begin
  select count(*) into total from artist; --  total = select count(*) from artist
  return total;
end;

/
select get_num_artists() from dual;
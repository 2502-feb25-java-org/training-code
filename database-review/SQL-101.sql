--Structured Query Language
/*
- sublanguages: 
    -> Data Control Language -- give/restrict access to db fields
        - GRANT, REVOKE
    -> Data Definition Language -- defines the schema of our db
        - CREATE, ALTER, DROP, TRUNCATE
    -> Data Manipulation Language -- (CRUD) manipulate data in tables 
        - INSERT, SELECT, UPDATE, DELETE
    -> Data Query Language - query data
        - SELECT
    -> Transaction Control Language - allows us to manage ACID compliant transactions
        - COMMIT, SAVEPOINT, ROLLBACK
        
- column level contraints - NN, U, PK, FK, Default, Check
- candidate key - something that CAN be a PK (NN, U)
- two types of PK - natural keys, surrogate
- domain integrity - maintain integrity of constraints 
- referential integrity - maintain integrity of foreign key relationships 
- schema 
- ERD - entity relationship diagram 
- normalizing databases - the process of organizing your tables to increase 
efficiency and reduce redundancy 
   - this is done in normal forms we typically go up to third normal form (3NF)
   - "the key, the whole key, and nothing but the key"
   - 1NF - every table must have PK
            atomic values for columns (broken down into small units)
   - 2NF - every column in table is dependent on entire PK (no partial dependencies)
          also must be in 1NF
   - 3NF - every column must depend directly on PK, not on another column that does (no transitive dependencies)
          also must be in 2NF
- joins 
- set operators - must be used with result sets with same # and type of columns
      UNION (A + B - AB) , UNION ALL ( A + B), MINUS (A - B),  INTERSECT (AB)
- multiplicity 
*/
-- JOINS
select tr.name as jams, al.title as "Album Title", g.name as genre
from track tr 
join album al on tr.albumid = al.albumid
join genre g on g.genreid = tr.genreid
where length(tr.name) =  
(select max(length(track.name)) from track);

--- self join!
select manager.lastname as MANAGER, worker.lastname as EMPLOYEE
from employee manager
full outer join employee worker
on manager.employeeid = worker.reportsto;

select max(length(name)) from track;

--natural join
-- where oracle attemps to match columns based on names 
select track.name, album.title from track natural join album;

--cross joins - cartesian product of two tables
select album.title, artist.name 
from album, artist;



--- fun queries 

--find numbre of songs by genre
select genre.name as "GENRE", count(track.trackid) as "NUM SONGS"
from track 
inner join genre on 
genre.genreid = track.genreid
group by genre.name
order by genre.name;

--find the longest song on each album

--what about subqueries that return more than one result? use IN, not =
select * from track where albumid IN
(select albumid from album where title like 'A%');

-------- set operators
select * from employee;

select * from employee where city = 'Calgary' minus
select * from employee where employeeid >5;

--intersect
select * from employee where city = 'Calgary' AND employeeid >5;

--union
select * from employee where city = 'Calgary' OR employeeid >5;

---minus
select * from employee where city = 'Calgary' AND NOT employeeid >5;
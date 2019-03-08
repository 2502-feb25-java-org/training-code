--Stored Procedure : functional prograaming in SQL
sp_help 'Music.Artist'
sp_rename '[Music].[Music.Album]', 'Album'
sp_helptext 'sp_rename'


create proc sp_getArtistDetailsById
@id int
as
begin
select ar.artistName,ar.age, al.albumName, al.numofSongs
from Music.Artist as ar
left join  Music.Album as al
on ar.artistId=al.artistId
end

execute [dbo].[sp_getArtistDetailsById] 1 --execute the procedure


sp_helptext '[dbo].[sp_getArtistDetailsById]'

alter proc sp_getArtistDetailsById
@id int --parameter
with encryption --will not allow sp-helptext to view the defination
as
begin
select ar.artistName,ar.age, al.albumName, al.numofSongs
from Music.Artist as ar
left join  Music.Album as al
on ar.artistId=al.artistId  --returns the table
end
select * from Music.Artist

alter proc sp_getArtistCountByAge
@age int,--input
@count int out--output
as 
begin
select @count = count(Artistname)
from Music.Artist 
where age>@age
end

declare @count int;
exec sp_getArtistCountByAge 40, @count out;
select @count;


--- Functions
--Scalar functions (input-> output): string functions , datetime, Math
--Aggregrate functions: work on columns/rows
--Table valued functions
-- UDF- user defined functions (scalar, mutlivalued function, Table-valued function)
--scalar built in functions
select concat('hello', ' ', 'world')
select lower('HELLO')
select Year(getdate())
select SQUARE(9)

--UDF
create function getFullname
(@firstname varchar(50),
@lastname varchar(50))
returns varchar(100)--text, ntext, image
as
begin
    declare @name varchar(100);
	set @name=concat(@firstname,' ' , @lastname);
	return @name;
end

select [dbo].[getFullname]('Pushpinder','Kaur')

select Title,EmailPromotion,dbo.getfullname(firstname,lastname) as Name
from Person.Person

create function getDob
(@dob date)
returns int
as
begin
declare @age int;
set @age=datediff(year,@dob,getdate()) -
	case
		when(month(@dob)>month(getdate()) or 
		    MONTH(@dob)=MONTH(getdate()) and day(@dob)>day(getdate()))
		then 1
		else 0
end
	return @age;
end

select e.BusinessEntityID, e.HireDate, dbo.getDob(BirthDate) as age
from HumanResources.Employee as e
where dbo.getDob(BirthDate)>30 and  dbo.getDob(BirthDate)<45

---TRIGGERS: DML(insert Update and delete), DDL, Login Triggers.
--After or For Trigger (Insert, delete, update)
--instead trigger (which runs instaed of command specified)

insert into Music.Artist
values('Jennifer Lopez',45,'01/01/1990',1)

select * from Music.Artist

create table tblAudit(
id int identity(1,1) not null,
ModifiedDate date default getdate(),
msg varchar(max)
)


create trigger tr_tblArtist_update
on Music.Artist
for update
as
begin
declare @id int
select @id=artistId from inserted --temp table 
insert into tblAudit
values(getdate(), 'inserted by Pushpinder')
end

select * from tblAudit



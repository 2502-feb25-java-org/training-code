drop database tsql
create database tsql

RESTORE database [tsql] FROM URL = 
   'https://tsqlstoragefile.blob.core.windows.net/testcontainer/TSQL.bak'

use TSQL
/*
Numeric data types such as int, tinyint, bigint, float, real etc.
Date and Time data types such as Date, Time, Datetime etc.
Character and String data types such as char, varchar, text etc.
Unicode character string data types, for example nchar, nvarchar, ntext etc.
Binary data types such as binary, varbinary etc.
Miscellaneous data types – blob, xml, cursor, table etc.*/
*/
--This create an alias type from an existing type. DEMO
--CREATE TYPE phonenum FROM nchar(12) NOT NULL;

--drop TYPE phonenum;

--CAST and CONVERT DEMO
--select cast (postalcode As decimal(10,3)) from HR.Employees;

--select convert (decimal(10,4), postalcode) from hr.employees;

--Some Precedence DEMO
	--DECLARE @x as int = 4;
	--Declare @y as decimal(10,1) = 5;
	--select @x * 2;
	--select @x + @y;

--RTRIM, LTRIM, and TRIM DEMO
--Declare @helloworld AS nvarchar(50) = '                  .!Hello World!!!       .                   ';
--Select @helloworld;
--SELECT RTRIM(@Helloworld);
--select ltrim(@helloworld);
--select trim(@helloworld);
--select trim('.H ' from @helloworld);
--select trim('.H !' from @helloworld);

--RIGHT and LEFT DEMO
DECLARE @hi AS nvarchar(20) = 'Hi Everybody!';
select LEFT(@hi, 4);
select right(@hi, 5);

--LEN AND DATALENGTH DEMO
DECLARE @length_test AS varchar(30) = 'Twelve chars ';
DECLARE @length_test2 AS nvarchar(30) = 'Twelve chars ';
SELECT LEN(@length_test);
SELECT LEN(@length_test2);
SELECT DATALENGTH(@length_test);
SELECT DATALENGTH(@length_test2);

--PATINDEX DEMO
DECLARE @mark AS nvarchar(30) = 'Is Mark here?';
SELECT PATINDEX('%Mark%', @mark);

--REPLICATE DEMO
SELECT REPLICATE('he', 6);

--REPLACE and TRANSLATE DEMO
DECLARE @pets AS nvarchar(30) = 'I pet the adorable dogs.';
SELECT @pets;
SELECT REPLACE(@pets, 'dog', 'cat');
SELECT TRANSLATE(@pets, 'dg', 'ct');

--SUBSTRING DEMO
SELECT SUBSTRING('Have a nice day', 8, 4);

--STUFF DEMO
SELECT STUFF('I hate the weather outside.', 3, 6, 'like');

select * from HR.Employees
SELECT titleofcourtesy + ' ' + lastname AS Name, REPLACE(title, 'Sales', 'Accounts') AS Title from HR.Employees;


SELECT firstname AS RegularName, 
	STUFF(firstname, 1, 1, 'bob') AS BobbedName from HR.Employees;

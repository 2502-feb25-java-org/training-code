--Converting to Binary Data Type
--convert vs cast

SELECT CAST(12345 AS binary(4)) AS Result;

--Creating GUIDs for the uniqueidentifier Data Type

SELECT NEWID() AS GUID_from_NEWID, CAST('1C0E3B5C-EA7A-41DC-8E1C-D0A302B5E58B' AS
uniqueidentifier) AS GUID_cast_from_string;

--Implicit Conversion Example - Integer Data Types
DECLARE @myTinyInt AS tinyint = 25;
DECLARE @myInt as int = 9999;
SELECT @myTinyInt + @myInt;

--Implicit Conversion Example - Integer and Character Data Types
DECLARE @myChar AS char(5) = '6';
DECLARE @myInt AS int = 1;
SELECT @myChar + @myInt;

--Failing Implicit Conversion Example
DECLARE @myChar AS char(5) = 'six';
DECLARE @myInt AS int = 1;
SELECT @myChar + @myInt;

declare @name as char(10)=N'Hello';
select @name;

select ASCII('zello')
select char(100)
select nchar(501)
select CHARINDEX('1','revature')
select right('Dwayne',4)
select SUBSTRING('United States of America', 5,4)
select len('United States of America')
select ltrim('    states')
select replace('United States of America',' ', '')

declare @test as char(60)='United States of America| ';
select REPLACE(@test,'|','$')

select SOUNDEX('rise'), SOUNDEX('rice')
select 'Demi' +space(5)+ 'Lovato'
select STUFF('ping' ,2,2,'oo')
select str(195.456,6,2)
select unicode('Z')
select QUOTENAME('Hello','')
declare @testdate as datetime = getdate();
select FORMAT(@testdate,'d','de-de')

DECLARE @DateOnly AS datetime2 = '20160112';
SELECT @DateOnly AS Result;

DECLARE @time AS time = '12:34:56';
SELECT CAST(@time AS datetime2) AS Result;

--comments by developer 
--author Pushpinder Kaur 03/05/2019
--start sql
/*
Welcome to Learn SQL :
	SQL have 5 set of queries:
		1. DDL
		2. DML
		3. DCL
		4. TCL
		5. DQL
*/
--end sql
--DQL: no modification only readings
select 'Pushpinder Kaur is a trainer for java batch'
--Alias
select 'Pushpinder' As 'FirstName', 'Kaur' As 'LastName'


-- the table
-- columns
select distinct AddressLine2 from SalesLT.Address
select count(AddressLine2) from SalesLT.Address
select AddressID, (AddressLine1+' '+City+' '+CountryRegion+' '+PostalCode) As fullAddress
from SalesLT.Address

SELECT * FROM SalesLT.Customer;

-- only the columns we want
SeLeCt FirstName, LastName
from SalesLT.Customer;

-- only the columns i want, only the rows i want
SELECT FirstName, LastName
FROM SalesLT.Customer
WHERE LastName = 'Adams';

SELECT FirstName, LastName
FROM SalesLT.Customer
WHERE LastName >= 'A' and LastName < 'D'
order by lastname asc;
-- 
SELECT FirstName, LastName
FROM SalesLT.Customer
WHERE LastName like '[AB]%';

SELECT COUNT(*) AS 'AllAdams'
FROM SalesLT.Customer
WHERE LastName = 'Adams';

SELECT * FROM SalesLT.SalesOrderDetail
order by ProductID desc;

-- total number of product 779 ordered ever
SELECT *
FROM SalesLT.SalesOrderDetail
WHERE ProductID = 779;

select avg(LineTotal) As 'Total'
from SalesLT.SalesOrderDetail


SELECT avg(OrderQty) As 'CountOrderQty'
FROM SalesLT.SalesOrderDetail
WHERE ProductID = 779;

SELECT (sum(OrderQty)/count(orderqty)) As 'CountOrderQty'
FROM SalesLT.SalesOrderDetail
WHERE ProductID = 779;

SELECT COUNT(FirstName) as [dupe-count], FirstName, LastName
FROM SalesLT.Customer
WHERE LastName < 'B'
GROUP BY LastName, FirstName
HAVING COUNT(FirstName) > 1;

-- SELECT statement execution order
-- from
-- where
-- group by
-- having
-- select
-- order by

SELECT *
FROM SalesLT.Customer
ORDER BY LastName DESC;

SELECT *
FROM SalesLT.Address
WHERE countryregion !='United States';


/*
Numeric data types such as int, tinyint, bigint, float, real etc.
Date and Time data types such as Date, Time, Datetime etc.
Character and String data types such as char, varchar, text etc.
Unicode character string data types, for example nchar, nvarchar, ntext etc.
Binary data types such as binary, varbinary etc.
Miscellaneous data types – blob, xml, cursor, table etc.*/
*/
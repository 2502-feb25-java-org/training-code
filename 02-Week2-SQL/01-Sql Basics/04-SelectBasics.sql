--schema : Grouping of tables of related types
sp_help 'HumanResources.Department'

select [DepartmentID],[Name],[GroupName],[ModifiedDate] from HumanResources.Department

select * from HumanResources.Department-- not recommended for optimization reasons

create table #tempTable(
  [dept id] int not null)

  insert into #tempTable 
  values (1)

  select [dept id] from #tempTable

  sp_help 'Production.Product'

select ProductID as Id,Name,Color,'Batch 1' as Batch,StandardCost as cost, Style from Production.Product

select SCHEMA_NAME(SCHEMA_ID) as 'schema', name
 from sys.tables
 order by 'schema'

select SCHEMA_NAME(SCHEMA_ID) as 'schema', name
 from sys.views
 order by 'schema'

 sp_help 'sales.vStoreWithAddresses' --alt + F1

select BusinessEntityID, Name, (AddressLine1 +' '+ AddressLine2+' '+City+' '+StateProvinceName+' '+PostalCode+' '+CountryRegionName) as  'Address' from sales.vStoreWithAddresses 


sp_help 'Sales.SalesOrderDetail'

select sod.ProductID, sod.UnitPrice as p, sod.OrderQty as q, (sod.UnitPrice*sod.OrderQty)as Total
from Sales.SalesOrderDetail as sod-- table aliases

-- local variables
declare @name varchar(max);
set @name ='Pushpinder Kaur';
select @name as Name;

declare @table table (
id int not null,
name varchar(max) null)

insert into @table
values(1, 'Pushpinde Kaur')
--go 
select id, name from @table-- to run this it should run in  a batch 

select JobTitle,BusinessEntityID,HireDate from [HumanResources].[Employee]
where (HireDate <' 2009-05-14' and HireDate > '2009-01-12') and JobTitle='Research and Development Manager'

select JobTitle,BusinessEntityID, HireDate 
from  HumanResources.Employee
where not  JobTitle = 'Research and Development Manager' --<>

select JobTitle
from  HumanResources.Employee
order by JobTitle

select AddressLine1,AddressLine2,City,StateProvinceID,PostalCode from [Person].[Address]
select count(AddressLine2) from Person.Address
select count(*) from Person.Address

--find second highest salary using subquery
select top(1) * from [HumanResources].[EmployeePayHistory]
where  Rate <>
(select top(1) [Rate] from [HumanResources].[EmployeePayHistory]
order by Rate asc)
order by rate asc

select rate from [HumanResources].[EmployeePayHistory]
order by rate 


select  FirstName+' '+LastName as Name,Department,StartDate from [HumanResources].[vEmployeeDepartmentHistory]
where StartDate='2009-01-02'
order by StartDate

select top(2) FirstName+' '+LastName as Name,Department,StartDate from [HumanResources].[vEmployeeDepartmentHistory]
where StartDate='2009-01-02'
order by StartDate

select top(2) with ties FirstName+' '+LastName as Name,Department,StartDate from [HumanResources].[vEmployeeDepartmentHistory]
where StartDate='2009-01-02'
order by StartDate


-- GROUP BY CLAUSE

select ProductID, specialofferid,OrderQty
from Sales.SalesOrderDetail
where ProductID=779

select ProductID,sum(OrderQty) as totalQty from [Sales].[SalesOrderDetail]
group by ProductID
order by ProductID

select ProductID, SpecialOfferID, sum(OrderQty) as totalByOrderQty
from Sales.SalesOrderDetail as sod
--where sum(OrderQty)>100
group by SpecialOfferID, ProductID
having sum(OrderQty)>100
order by SpecialOfferID, ProductID

sp_help 'sales.salesorderdetail'
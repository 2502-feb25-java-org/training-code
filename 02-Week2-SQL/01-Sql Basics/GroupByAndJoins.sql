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

select * from [Production].[Product]--504 row
select * from [Sales].[SalesOrderDetail]--121317 rows

select p.ProductID,sod.SalesOrderDetailID, sod.CarrierTrackingNumber, sod.OrderQty
from Production.Product as p
inner join Sales.SalesOrderDetail sod
on p.ProductID=sod.ProductID --121317 rows 

select p.ProductID,sod.SalesOrderDetailID, sod.CarrierTrackingNumber, sod.OrderQty
from Production.Product as p
left join Sales.SalesOrderDetail sod
on p.ProductID=sod.ProductID --121555

--see thedifference with nulls
select p.ProductID,sod.SalesOrderDetailID, sod.CarrierTrackingNumber, sod.OrderQty
from Production.Product as p
left join Sales.SalesOrderDetail sod
on p.ProductID=sod.ProductID --238 rows
where sod.ProductID is null
order by sod.SalesOrderDetailID

---predicate placement is ON which takes Null into account
select p.ProductID,sod.SalesOrderDetailID,  sod.OrderQty
from Production.Product as p
left join Sales.SalesOrderDetail sod
on p.ProductID=sod.ProductID and 
 sod.OrderQty>2
order by sod.SalesOrderDetailID --32418

---predicate placement is WHERE which donot takes Null into account
select p.ProductID,sod.SalesOrderDetailID,  sod.OrderQty
from Production.Product as p
left join Sales.SalesOrderDetail sod
on p.ProductID=sod.ProductID  --238 rows
 where sod.OrderQty>2
order by sod.SalesOrderDetailID --32163

--cross join-> multiplications of tables 
select count(*) from [HumanResources].[Employee]
select count(*) from [HumanResources].[EmployeeDepartmentHistory]


select e.BusinessEntityID, edh.StartDate, e.JobTitle
from [HumanResources].[Employee] as e
cross join [HumanResources].[EmployeeDepartmentHistory] as edh --85840

select (290*296) as Math

--self join
select * from [HumanResources].[Employee]

alter table [HumanResources].[Employee]
add ManagerId int null
go

update [HumanResources].[Employee] 
set Managerid=1
where BusinessEntityID <> 1

select e.BusinessEntityID, m.JobTitle,e.ManagerId,e.HireDate
from [HumanResources].[Employee] as e
left outer join [HumanResources].[Employee] as m
on e.ManagerId=m.ManagerId

--clean up
alter table [HumanResources].[Employee]
drop column managerId

--union and union all
select s1.productid, s1.unitprice from [Sales].[SalesOrderDetail] as s1
where s1.ProductID between 1 and 799
union 
select s2.productid, s2.unitprice from [Sales].[SalesOrderDetail] as s2
where s2.ProductID between 800 and 1000


select s1.productid, s1.unitprice from [Sales].[SalesOrderDetail] as s1
where s1.ProductID between 1 and 799
union all
select s2.productid, s2.unitprice from [Sales].[SalesOrderDetail] as s2
where s2.ProductID between 800 and 1000

--intersect and except
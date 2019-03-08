create table Product(
productId int identity(1,1) primary key,
productName varchar(50) not null,
unitPrice money not null,
qtyAvailable smallInt,
dateAdded date default getdate()
)
go
create table SalesProduct(
salesId smallint identity(1,1) primary key,
productid int,
qtySold smallint,
dateSold date default getdate()
)
insert into Product(productName,unitPrice,qtyAvailable)
values ('dell laptop',799.00,100),
('dell desktop',499.00,90),
('surface',1399.00,40)

select * from Product

insert into SalesProduct(productid,qtySold)
values (1,10)

create procedure sp_UpdateOnSol
@id int, @qtysold int
as 
begin
	begin try		
		begin transaction
			update Product
			set qtyAvailable=qtyAvailable-@qtysold
			where productId=@id

			insert into SalesProduct (productid,qtysold,dateSold)
			values (@id,@qtysold,getdate())
			
		commit transaction;
	end try
	begin catch 
		rollback transaction;
	end catch
end

exec sp_UpdateOnSol 1, 10000000000000000000000000000
select * from Product
select * from SalesProduct






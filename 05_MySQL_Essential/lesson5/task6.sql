-- Задание 6. Используя вложенные запросы и ShopDB получить имена покупателей и имена сотрудников у которых TotalPrice товара больше 1000
select o.OrderID, 
		(select sum(od.TotalPrice) from orderdetails od where od.orderid = o.orderid) "Сума_заказу",
        (select concat(e.FName, ' ', e.MName , ' ', e.LName) from employees e where e.EmployeeID = o.EmployeeID) "Продавець",
        (select concat(c.FName, ' ', c.MName , ' ', c.LName) from customers c where c.CustomerNo = o.CustomerNo) "Покупець",
        (select group_concat(concat(p.Description, ' ', od.unitprice , 'грн. ', od.Qty, 'шт. ') SEPARATOR ', ')
			from  orderdetails od 
			join products p on p.ProdID = od.prodid
			where od.OrderID = o.orderid) "Що" 
from orders o
where (select sum(od.TotalPrice) from orderdetails od where od.orderid = o.orderid) > 1000;

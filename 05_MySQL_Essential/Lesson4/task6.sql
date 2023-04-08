/*
  Задание 6. Используя JOIN’s и ShopDB получить имена покупателей и имена сотрудников у которых TotalPrice товара больше 1000

	Если под этой формулировкой понимается "Найти заказы, сумма которых больше 1000 и вывести их сотрудникоа и покупателей, то решение ниже
	Также в исх. данных имеется ошибка:  для Orderid = 2, LineItem = 2 : TotalPrice !=  Qty * UnitPrice. Т.е. 15 * 20 = 300. Но TotalPrice = 100
    Поэтом сумма заказа подсчитывается по UnitPrice
*/
with s1 as (
SELECT od.orderid, sum(od.QTY * od.UnitPrice) OrderSum   -- sum(od.TotalPrice)
from orderdetails od
group by od.orderid
having sum(od.QTY * od.UnitPrice) > 1000
)
select o.OrderID, o.OrderDate, s1.orderSum "Сумма заказа", concat (c.FName, ' ',  c.MName, ' ', c.LName, '. ', c.City, ', ', c.Address1) "Покупатель",  concat (e.FName, ' ',  e.MName, ' ', e.LName) "Продавец"
from s1 
inner join orders o on o.OrderID = s1.orderid
inner join employees e on e.EmployeeID = o.EmployeeID
inner join customers c on c.CustomerNo = o.CustomerNo;

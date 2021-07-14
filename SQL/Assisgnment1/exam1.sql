drop database if exists ThucTapSinh;
create database if not exists ThucTapSinh;
use ThucTapSinh;
drop table if exists Country;
create table if not exists Country(
	country_id tinyint primary key auto_increment,
    country_name varchar(50)
    );
drop table if exists Location;
create table if not exists Location(
	Location_id tinyint primary key auto_increment,
    street_addrees varchar(50),
    postal_code tinyint,
    country_id tinyint
    #constraint fk_location foreign key(country_id) references  Country(country_id)
    );
drop table if exists employee;
create table if not exists employee(
	employee_id tinyint primary key auto_increment,
    full_name varchar(50),
    Email varchar(50) unique key,
    location_id tinyint
    #foreign key (location_id) references location(location_id)
    );

#1.Tạo table
INSERT INTO `thuctapsinh`.`country` (`country_id`, `country_name`) VALUES ('1', 'Vietnam');
INSERT INTO `thuctapsinh`.`country` (`country_id`, `country_name`) VALUES ('2', 'Anh');
INSERT INTO `thuctapsinh`.`country` (`country_id`, `country_name`) VALUES ('3', 'Italia');

insert into thuctapsinh.location( street_addrees, postal_code, country_id)  
value 	('ha noi', '12', '1'),
		('ha nam', '13', '1'),
        ('london', '2' , '2'),
        ('rome', '3', '3');

INSERT INTO `thuctapsinh`.`employee` (`employee_id`, `full_name`, `Email`, `location_id`) VALUES ('1', 'masonmount', 'nn03@gmail.com', '1');
INSERT INTO `thuctapsinh`.`employee` (`employee_id`, `full_name`, `Email`, `location_id`) VALUES ('2', 'van_toan', 'van_toan@mail', '3');
INSERT INTO `thuctapsinh`.`employee` (`employee_id`, `full_name`, `Email`, `location_id`) VALUES ('3', 'jorinho', 'jorinho@mail', '4');

#2.1 Lấy tất cả các nhân viên thuộc Việt nam
select E.full_name,L.country_id, C.country_name 
from `employee` E 
join location L
on E.location_id= L.location_id
join country C on C.country_id = L.Country_id
having L.country_id = 1;

#2.2 Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
select e.full_name,e.Email, C.country_name 
from employee E
join Location L on E.Location_id = L.location_id
join country C on C.country_id = L.country_id
having E.email like 'nn03@gmail.com';

#2.3 Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc
select C.country_ID, C.country_name, count(L.country_ID) as 'so employee'
from country C join location L
on C.country_ID = L.country_Id
join employee E on L.location_id = E.location_id
group by L.country_id;

select L.*, count(E.location_Id) as'so employee' from location L
join Employee E on E.location_id = L.location_ID
group by E.location_ID;

#3.Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
drop trigger if exists checkemployee;
delimiter $$
create trigger checkemployee
before insert on `employee` 
for each row 
begin
	declare _numEp Int;
	select count(*) into _numEp 
	from employee E 
    join location L on L.location_id = E.location_id
	join country C on C.country_ID = L.country_Id
    Where  E.location_id = NEW.location_ID
	group by L.country_id;
    if (_numEp >=8) then 
		signal sqlstate '12364'
        set message_text = 'toi da 10 nguoi';
	end if;
end $$
delimiter ;

#4: cau hinh khi xoa location -> location cua employee = null
alter table employee drop constraint fk_locationid;
alter table employee add constraint fk_locationid foreign key (location_id) references location(location_id) on delete set null;


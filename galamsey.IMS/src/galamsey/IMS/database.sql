create schema test;
use test;
create table Monitoring(
id int primary key auto_increment,
obs_name varchar(100),
country varchar(50),
year_started date,
area_covered double
);

create table Observatory(
id int primary key auto_increment,
veg_color varchar(50),
position varchar(20),
col_value int,
year date
); 




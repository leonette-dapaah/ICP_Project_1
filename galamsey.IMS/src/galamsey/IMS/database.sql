create schema test;
use test;
create table Monitoring(
id int primary key auto_increment,
obs_name varchar(100) not null,
country varchar(50) not null,
year_started date,
area_covered double
);

create table Observatory(
id int primary key auto_increment,
veg_color varchar(50) not null,
position varchar(20),
col_value enum ('1', '2', '3'),
year date
); 




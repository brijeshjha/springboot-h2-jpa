/*create table persons
(
  id integer primary key,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp
);*/

insert into persons(id,name,location,birth_date,created_date,updated_date) values (100,'raj','mumbai',sysdate,sysdate,sysdate),
(101,'jack','new york',sysdate,sysdate,sysdate),
(102,'sam','canada',sysdate,sysdate,sysdate);
CREATE SCHEMA IF NOT EXISTS internet_shop;

/*MySQL*/
create table internet_shop.customer
(
  id int auto_increment primary key,
  last_name    varchar(50) not null,
  first_name   varchar(50) not null,
  birthday     date        not null,
  mail_address varchar(50) not null unique,
  password     varchar(50) not null
);


/*PostgreSQL*/
create table internet_shop.customer
(
  id SERIAL primary key,
  last_name    varchar(50) not null,
  first_name   varchar(50) not null,
  birthday     date        not null,
  mail_address varchar(50) not null unique,
  password     varchar(50) not null
);
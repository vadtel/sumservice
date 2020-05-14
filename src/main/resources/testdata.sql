drop schema if exists `sum-service`;

create schema `sum-service`
    character set `utf8`;

use `sum-service`;

create table `map`
(
    `name`  varchar(24) primary key not null,
    `value` integer not null 
);

-- ---
-- Test Data
-- ---
insert into `map` (`name`, `value`) values
('one', 1);
insert into `map` (`name`, `value`) values
('two', 2);
insert into `map` (`name`, `value`) values
('three', 3);
insert into `map` (`name`, `value`) values
('four', 4);
insert into `map` (`name`, `value`) values
('five', 5);
insert into `map` (`name`, `value`) values
('six', 6);
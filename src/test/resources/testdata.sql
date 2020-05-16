create table map
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name  varchar(24) not null unique,
    value integer not null
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
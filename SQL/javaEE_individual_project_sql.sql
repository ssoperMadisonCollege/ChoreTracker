-------------------------
-- Create the database --
-------------------------
CREATE DATABASE ChoreTracker;

-----------------------
-- Create the tables --
-----------------------

-- create users table
create table users (
    userId        int(11) NOT NULL auto_increment,
    first_name    varchar(30) NOT NULL,
    last_name     varchar(30) NOT NULL,
    user_password varchar(30) NOT NULL,
    user_email    varchar(30) NOT NULL,
    user_phone    varchar(30) NOT NULL,
    user_name     varchar(30) NOT NULL,
    PRIMARY KEY (userId)
 );

-- populate the users table with sample data
insert into users values (1, 'Joe', 'Coyne', 'password', 'email@email.com', '123-456-7890', 'JCoyne');
insert into users values (2, 'Fred', 'Hensen', 'password', 'email@hotmail.com', '111-111-1111', 'FHensen');
insert into users values (3, 'Barney', 'Curry', 'password', 'email@gmail.com', '222-222-2222', 'BCurry');
insert into users values (4, 'Karen', 'Mack', 'password', 'fake@yahoo.com', '333-333-3333', 'KMack');
insert into users values (5, 'Dianne', 'Klein', 'password', 'this@mailapp.com', '444-444-4444', 'DKlein');
insert into users values (6, 'Dawn', 'Tillman', 'password', 'sample@email.com', '555-555-5555', 'DTillman');

-- create user_roles table
create table user_roles (
    user_name         varchar(15) not null,
    role_name         varchar(15) not null
);

-- create a user so that tomcat can access the user_roles table
CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'tomcat';

-- give the tomcat user privelages to read
GRANT SELECT ON ChoreTracker.* TO 'tomcat'@'localhost';

-- insert an admin user to the users table
insert into users values (8, 'admin', 'admin', 'password', 'admin@admin.admin', '0987-654-321', 'admin');

-- Add a role for the admin user
insert into user_roles values ('admin', 'administrator');

-- create chores table
create table chores (
    choreId                 int(11) NOT NULL auto_increment,
    chore_name              varchar(30) NOT NULL,
    chore_start_date        date,
    chore_time_interval     varchar(30),
    assigned_to_user        varchar(30),
    PRIMARY KEY (choreId)
);

-- populate chores table with sample data
insert into chores values (1, 'mow the lawn', 2017-10-17 , '', '');
insert into chores values (2, 'add salt to water softener', 2017-10-18 , '', '');
insert into chores values (3, 'go grocery shopping', 2017-10-19 , '', '');
insert into chores values (4, 'pick up the CSA', 2017-10-20 , '', '');
insert into chores values (5, 'fix leaky garage door', 2017-10-21 , '', '');

-- create house table
create table houses (
    houseId int(11) NOT NULL auto_increment,
    house_name varchar(30) NOT NULL,
    PRIMARY KEY (houseId)
);

-- populate houses table with sample data
insert into houses values (1, 'Soper House');
insert into houses values (2, 'Pelton House');
insert into houses values (3, 'Animal House');
insert into houses values (4, 'House of Cards');

create database bankingSystem;
use bankingSystem;

create table signup(form_id varchar(30), name varchar(30), account varchar(30), dob varchar(30), gender varchar(30), email varchar(60), marital_status varchar(30), address varchar(100), city varchar(30), province varchar(60), password varchar(120));

select * from signup;

create table signup_second(form_id varchar(30), citizen_id varchar(30), religion varchar(30), date_of_issue varchar(30), place_of_issue varchar(30), education varchar(30));

select * from signup_second;

create table signup_third(form_id varchar(30), account_type varchar(60), card_number varchar(30), pin varchar(120), services varchar(120));

select * from signup_third;

create table login(form_id varchar(30), card_number varchar(30), pin varchar(120));

select * from login;

create table bank(pin varchar(120), date varchar(50), type varchar(20), amount varchar(20));

select * from bank;

drop database if exists java_3_db;
create database java_3_db;

use java_3_db;

drop table if exists insured_member_insurance_policies;
drop table if exists insurance_policies;
drop table if exists insured_members;
drop table if exists companies;

create table companies (
                           id int(9) unsigned auto_increment primary key,
                           name varchar(255) not null
);

create table insured_members (
                                 id int(9) unsigned auto_increment primary key,
                                 first_name varchar(255) not null,
                                 last_name varchar(255) not null,
                                 company_id int(9) unsigned not null
);

create table insurance_policies (
                                    id int(9) unsigned auto_increment primary key,
                                    company_id int(9) unsigned not null,
                                    type varchar(30) not null
);

create table insured_member_insurance_policies (
                                                     id int(9) unsigned auto_increment primary key,
                                                     insured_member_id int(9) unsigned not null,
                                                     insurance_policy_id int(9) unsigned not null
);

alter table insured_members add foreign key (company_id) references companies(id);
alter table insurance_policies add foreign key (company_id) references companies(id);
alter table insured_member_insurance_policies add foreign key (insured_member_id) references insured_members(id);
alter table insured_member_insurance_policies add foreign key (insurance_policy_id) references insurance_policies(id);

-- companies
insert into companies (name) values ('Book and Cookie');
insert into companies (name) values ("Winter's Wonderland");
insert into companies (name) values ("Bouncy Castle Playland");

-- policies
insert into insurance_policies (company_id, type)
values (1, 'dental');

insert into insurance_policies (company_id, type)
values (1, 'life');

insert into insurance_policies (company_id, type)
values (1, 'vision');

insert into insurance_policies (company_id, type)
values (2, 'dental');

insert into insurance_policies (company_id, type)
values (2, 'life');

insert into insurance_policies (company_id, type)
values (3, 'vision');

-- members
insert into insured_members (company_id, first_name, last_name)
values (1, 'Sarah', 'Gilbert');

insert into insured_members (company_id, first_name, last_name)
values (1, 'Lacy', 'Dickson');

insert into insured_members (company_id, first_name, last_name)
values (1, 'Deloras', 'Durgan');

insert into insured_members (company_id, first_name, last_name)
values (2, 'Bibi', 'Hills');

insert into insured_members (company_id, first_name, last_name)
values (2, 'Shad', 'Toy');

insert into insured_members (company_id, first_name, last_name)
values (3, 'Everett', 'Morrison');

insert into insured_members (company_id, first_name, last_name)
values (3, 'Anton', 'Wolff');

insert into insured_member_insurance_policies(insured_member_id, insurance_policy_id)
values (1, 1);

insert into insured_member_insurance_policies(insured_member_id, insurance_policy_id)
values (1, 2);

insert into insured_member_insurance_policies(insured_member_id, insurance_policy_id)
values (1, 3);
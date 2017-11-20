-- REFERENCE TABLES
create table ref_user_type(id int primary key,
user_type varchar(50) unique not null);

insert into ref_user_type(id, user_type) values (0, 'ADMIN');
insert into ref_user_type(id, user_type) values (1, 'TEACHER');
insert into ref_user_type(id, user_type) values (2, 'PARENT');

create table ref_gender(id int primary key,
gender varchar(50) unique not null);

insert into ref_gender(id, gender) values (0,'FEMALE');
insert into ref_gender(id, gender) values (1, 'MALE');

create table ref_grade_level(id int primary key,
grade_level varchar(50) unique not null);

insert into ref_grade_level(id, grade_level) values(0, 'NURSERY');
insert into ref_grade_level(id, grade_level) values(1, 'GRADE 1');
insert into ref_grade_level(id, grade_level) values(2, 'GRADE 2');
insert into ref_grade_level(id, grade_level) values(3, 'GRADE 3');
insert into ref_grade_level(id, grade_level) values(4, 'GRADE 4');
insert into ref_grade_level(id, grade_level) values(5, 'GRADE 5');
insert into ref_grade_level(id, grade_level) values(6, 'GRADE 6');
insert into ref_grade_level(id, grade_level) values(7, 'GRADE 7');
insert into ref_grade_level(id, grade_level) values(8, 'GRADE 8');
insert into ref_grade_level(id, grade_level) values(9, 'GRADE 9');
insert into ref_grade_level(id, grade_level) values(10, 'GRADE 10');
insert into ref_grade_level(id, grade_level) values(11, 'GRADE 11');
insert into ref_grade_level(id, grade_level) values(12, 'GRADE 12');
-- DATA TABLES
create table data_users(id varchar(36) primary key,
username varchar(50) not null unique,
password varchar(36) not null,
user_type_id int not null,
reference_id varchar(36) not null,
email varchar(100) not null unique,
last_login timestamp,
is_locked boolean,
created_on timestamp default now(),
updated_on timestamp,
created_by varchar(50),
updated_by varchar(50),
foreign key(user_type_id) references ref_user_type(id));

create table data_emergency_contact(id varchar(36) primary key,
contact_of varchar(36),
contact_name varchar(100) not null,
relationship varchar(50),
contact_no varchar(20),
address varchar(250),
created_on timestamp default now(),
updated_on timestamp,
created_by varchar(50),
updated_by varchar(50),
foreign key(contact_of) references data_students(id),
foreign key(created_by) references data_users(username),
foreign key(updated_by) references data_users(username));

create table data_students(id varchar(36) primary key,
first_name varchar(50),
last_name varchar(50),
middle_name varchar(50),
birth_date date,
place varchar(50),
gender int,
citizenship varchar(50),
address varchar(250),
contact_no varchar(20),
emergency_contact varchar(50),
grade_level_id int,
school_year int,
section varchar(50),
is_old_student boolean default false,
is_transferee boolean default false,
is_enrolled boolean default false,
created_by varchar(50),
updated_by varchar(50),
foreign key(grade_level_id) references ref_grade_level(id),
foreign key(gender) references ref_gender(id),
foreign key(created_by) references data_users(username),
foreign key(updated_by) references data_users(username));

create table data_parents(id varchar(36) primary key,
parent_of varchar(36),
relationship varchar(50),
parent_name varchar(100),
occupation varchar(100),
office_no varchar(20),
created_on timestamp default now(),
updated_on timestamp,
created_by varchar(50),
updated_by varchar(50),
foreign key(created_by) references data_users(username),
foreign key(updated_by) references data_users(username),
foreign key(parent_of) references data_students(id));

create table data_teachers(id varchar(36) primary key,
teacher_fname varchar(50),
teacher_lname varchar(50),
position varchar(100),
contact_no varchar(20),
created_on timestamp default now(),
updated_on timestamp,
created_by varchar(50),
updated_by varchar(50),
foreign key(created_by) references data_users(username),
foreign key(updated_by) references data_users(username));

create table data_messages(id int identity(1,1) primary key,


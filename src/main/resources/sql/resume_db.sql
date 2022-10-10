CREATE DATABASE IF NOT EXISTS RESUME;
USE RESUME;

CREATE TABLE IF NOT EXISTS SKILL(
	id integer auto_increment primary key,
	title varchar(30),
    rating integer check(4 < rating < 10)
) auto_increment=1000;

CREATE TABLE IF NOT EXISTS EXPERIENCE(
	id integer primary key auto_increment,
    company varchar(100),
    job_title varchar(40),
    date_from date,
    date_to date,
    description text,
    years_of_experience int,
    experience_id int,
    foreign key(experience_id) references EXPERIENCE(id)
) auto_increment=1000;


CREATE TABLE IF NOT EXISTS EDUCATION(
	id integer primary key auto_increment,
    college varchar(100),
    degree varchar(100),
    date_from date,
    date_to date,
    description text
) auto_increment=1000;

CREATE TABLE IF NOT EXISTS PROJECT(
	id integer primary key auto_increment,
    title varchar(100),
    type_id integer,
    date_from date,
    date_to date,
    description text
) auto_increment=1000;

CREATE TABLE IF NOT EXISTS PROJECT_TYPE(
    type_id integer primary key auto_increment,
    project_description varchar(100),
    company_id integer default null,
    college_id integer default null,
    foreign key(company_id) references EXPERIENCE(id),
    foreign key(college_id) references EDUCATION(id)
) auto_increment=1000;

CREATE USER IF NOT EXISTS 'legends' IDENTIFIED BY 'resume';
GRANT ALL ON RESUME.* TO 'legends';

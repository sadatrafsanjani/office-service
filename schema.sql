
DROP TABLE office.public.employees;
DROP TABLE office.public.departments;

CREATE TABLE office.public.departments (
   	ID SERIAL PRIMARY KEY,
   	DEPARTMENT_CODE VARCHAR(5),
   	NAME VARCHAR(30) NOT NULL,
   	ACTIVE BOOLEAN DEFAULT TRUE
);

CREATE TABLE office.public.employees (
   	ID SERIAL PRIMARY KEY,
   	DEPARTMENT_ID INTEGER,
   	NAME VARCHAR(30) NOT NULL,
   	PHOTO VARCHAR(30) NOT NULL,
   	JOINING_DATE VARCHAR(30) NOT NULL,
   	DATE_OF_BIRTH VARCHAR(30) NOT NULL,
   	DESIGNATION VARCHAR(20) NOT NULL,
   	BASIC_SALARY REAL,
   	GENDER VARCHAR(10),
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES office.public.departments (ID) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO public.departments (ID, ACTIVE, DEPARTMENT_CODE, NAME) VALUES (1, true, 101, 'Accounts');
INSERT INTO public.departments (ID, ACTIVE, DEPARTMENT_CODE, NAME) VALUES (2, true, 102, 'Administration');
INSERT INTO public.departments (ID, ACTIVE, DEPARTMENT_CODE, NAME) VALUES (3, true, 103, 'Human Resource');
INSERT INTO public.departments (ID, ACTIVE, DEPARTMENT_CODE, NAME) VALUES (4, true, 104, 'Development');
INSERT INTO public.departments (ID, ACTIVE, DEPARTMENT_CODE, NAME) VALUES (5, true, 105, 'Research');

INSERT INTO public.employees (ID, DEPARTMENT_ID, NAME, PHOTO, JOINING_DATE, DATE_OF_BIRTH, DESIGNATION, BASIC_SALARY, GENDER)
VALUES (1, 1, 'Michael Man','./uploads/xxx.jpg', '1/1/2001', '5/12/1981', 'Manager', 19870, 'MALE');
INSERT INTO public.employees (ID, DEPARTMENT_ID, NAME, PHOTO, JOINING_DATE, DATE_OF_BIRTH, DESIGNATION, BASIC_SALARY, GENDER)
VALUES (2, 3, 'Christina Jordan','./uploads/yyy.jpg', '5/9/1998', '3/2/1967', 'Director', 25720, 'FEMALE');
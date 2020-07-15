DROP DATABASE IF EXISTS score;
CREATE DATABASE score DEFAULT CHARACTER SET utf8;
USE score;
CREATE TABLE score(
	studentId char(10),
    teacherId char(10),
    subject char(10),
    score float
);

insert into score (studentId,teacherId,subject,score) values ('171006101','10001','高数',75);

CREATE TABLE student(
	studentId char(10),
    name char(20),
    password char(20),
    phone char(20),
    email char(20)
);
insert into student (studentId,name,password,phone,email) values ('171006101','张三','171006101','17523421234','231sf2@qq.com');


CREATE TABLE teacher(
	teacherId char(10),
    name char(20),
    password char(20),
    phone char(20),
    email char(20)
);

insert into teacher (teacherId,name,password,phone,email) values ('10001','李四','10001','17523423251','17523423251@qq.com');


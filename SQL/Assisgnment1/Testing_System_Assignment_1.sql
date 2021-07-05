drop database if exists `Testing_System_Assignment_1`;
create database if not exists `Testing_System_Assignment_1`;

use `Testing_System_Assignment_1`;

drop table if exists `Department`;
create table if not exists `Department`(
	`DepartmentID` tinyint primary key auto_increment,
    `Departmentname` varchar(50)
);

drop table if exists `Position`;
create table if not exists `Position`(
	`PositionID` tinyint primary key auto_increment,
    `PositionName` varchar(50)
);

drop table if exists `Account`;
create table if not exists `Account`(
	`AccountID` tinyint primary key auto_increment,
    `Email` varchar(50) unique key,
    `Username` varchar(50) unique key,
    `Fullname` varchar(100),
    `DepartmentID` tinyint unique key,
    `PositionID` tinyint unique key,
    `CreateDate` date
);

drop table if exists `Group`;
create table if not exists `Group`(
	`GroupID` tinyint primary key auto_increment,
    `GroupName` varchar(50),
    `CreatorID` tinyint unique key,
    `CreateDate` date
);

drop table if exists `GroupAccount`;
create table if not exists `GroupAccount`(
	`GroupID` tinyint primary key auto_increment,
    `AccountID` tinyint unique key,
    `JoinDate` date
);

drop table if exists `TypeQuestion`;
create table if not exists `TypeQuestion`(
	`TypeID` tinyint primary key auto_increment,
    `TypeName` varchar(50)
);

drop table if exists `CategoryQuestion`;
create table if not exists `CategoryQuestion`(
	`CategoryID` tinyint primary key auto_increment,
    `CategoryName` varchar(50)
);

drop table if exists `Question`;
create table if not exists `Question`(
	`QuestionID` tinyint primary key auto_increment,
    `Content` varchar(500) unique key,
    `CategoryID` tinyint unique key,
    `TypeID` tinyint unique key,
    `CreatorID` tinyint unique key,
    `CreateDate` date
);

drop table if exists `Answer`;
create table if not exists `Answer`(
	`AnswerID` tinyint primary key auto_increment,
    `content` varchar(500),
    `QuestionID` tinyint unique key,
    `isCorrect` enum('dung', 'sai')
);

drop table if exists `Exam`;
create table if not exists `Exam`(
	`ExamID` tinyint primary key auto_increment,
    `code` varchar(50) unique key,
    `Title` varchar(50) unique key,
    `CategoryID` tinyint unique key,
    `Duration` tinyint,
    `CreatorID` tinyint unique key,
    `CreateDate` date
);

drop table if exists `ExamQuestion`;
create table if not exists `ExamQuestion`(
	`ExamID` tinyint primary key auto_increment,
    `QuestionID` tinyint unique key
);

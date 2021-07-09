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
    `DepartmentID` tinyint ,
    `PositionID` tinyint ,
    `CreateDate` date,
    foreign key (`DepartmentID`) references `Department`(`DepartmentID`)
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
	`GroupID` tinyint primary key,
    `AccountID` tinyint unique key,
    `JoinDate` date,
    foreign key (`GroupID`) references `Group`(`GroupID`),
    foreign key (`AccountID`) references `Account`(`AccountID`)
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
    `Content` varchar(500),
    `CategoryID` tinyint ,
    `TypeID` tinyint ,
    `CreatorID` tinyint ,
    `CreateDate` date,
    foreign key(`CategoryID`) references CategoryQuestion(`CategoryID`),
    foreign key(TypeID) references TypeQuestion(TypeID)
);

drop table if exists `Answer`;
create table if not exists `Answer`(
	`AnswerID` tinyint primary key auto_increment,
    `content` varchar(500),
    `QuestionID` tinyint,
    `isCorrect` enum('dung', 'sai'),
    foreign key (`QuestionID`) references `Question`(`QuestionID`)
);

drop table if exists `Exam`;
create table if not exists `Exam`(
	`ExamID` tinyint primary key auto_increment,
    `code` varchar(50),
    `Title` varchar(50),
    `CategoryID` tinyint,
    `Duration` tinyint,
    `CreatorID` tinyint,
    `CreateDate` date
);

drop table if exists `ExamQuestion`;
create table if not exists `ExamQuestion`(
	`ExamID` tinyint primary key auto_increment,
    `QuestionID` tinyint ,
    foreign key (`QuestionID`) references `Question`(`QuestionID`)
);

-- add data vào table
insert into Department(DepartmentID, DepartmentName)
value 		
				(1,		"Maketing"		),
                (2,		"Sale"			),
                (3,		"Bảo vệ"		),
                (4, 	"Kỹ thuật" 		),
                (5, 	"Giám đốc" 		);

insert into `Position`(PositionID, PositionName)
value 		
				(1,		"Nhân viên"		),
                (2,		"Test"			),
                (3,		"PM"			),
                (4, 	"Dev" 			),
                (5, 	"Scrum master" 	);
INSERT INTO `account` ( `Email`, `Username`, `Fullname`, `DepartmentID`, `PositionID`, `CreateDate`) VALUES ( 'hfis@gmail', 'hungas', 'hugdu', '2', '2', '2017-05-11'),
( 'hfi5s@gmail', 'hungas1', 'hugdu', '5', '2', '2017-05-11'),
( 'hf7is@gmail', 'hungas2', 'hugdu', '3', '2', '2017-05-11'),
( 'hfưis@gmail', 'hunga3s', 'hugdu', '2', '2', '2017-05-11'),
( 'hfijis@gmail', 'hung4as', 'hugdu', '2', '3', '2017-05-11'),
( 'hf2is@gmail', 'hunegas', 'hugdu', '2', '4', '2017-05-11'),
( 'h1fis@gmail', 'hung5as', 'hugdu', '2', '5', '2017-05-11'),
( 'hfi2s@gmail', 'hungafs', 'hugdu', '2', '2', '2017-05-11'),
( 'hf8is@gmail', 'hunga6s', 'hugdu', '2', '2', '2017-05-11'),
( 'hfsdvis@gmail', 'hunga34s', 'hugdu', '5', '2', '2017-05-11');
insert into `Group`(GroupName, CreatorID, CreateDate)
value 	('nhom1', '1', '2017-03-21'),
		('nhom2', '2', '2017-03-21'),
        ('nhom3', '3', '2017-03-21'),
        ('nhom4', '4', '2017-03-26'),
        ('nhom5', '5', '2017-03-21'),
        ('nhom6', '6', '2017-03-21'),
        ('nhom7', '7', '2017-03-21'),
        ('nhom8', '8', '2017-03-11'),
        ('nhom9', '9', '2017-03-30'),
        ('nhom10', '10', '2017-03-21');
insert into `GroupAccount`(GroupID, AccountID, JoinDate)
value 
		('1', '1', '2018-02-11'),
        ('2', '2', '2018-02-11'),
        ('3', '3', '2018-02-11'),
        ('4', '4', '2018-02-11'),
        ('5', '5', '2018-02-11'),
        ('6', '6', '2018-02-11'),
        ('7', '7', '2018-02-11'),
        ('8', '8', '2018-02-11');
insert into `TypeQuestion`(TypeID, TypeName)
value 
		('1', 'kieu1'),
        ('2', 'kieu2'),
        ('3', 'kieu3'),
        ('4', 'kieu4'),
        ('5', 'kieu5');
insert into `CategoryQuestion`(categoryname)
value
		('java'),
        ('c++'),
        ('c#'),
        ('mysql'),
        ('.net');
insert into `question`(content, categoryid, typeid, creatorid, createdate)
value 
		('a', 1, '2', '10', '2021-02-21'),
        ('a2', 2, '1', '11', '2021-02-21'),
        ('a', 3, '1', '12', '2021-02-21'),
        ('a4', 4, '4', '13', '2021-02-21'),
        ('a5', 1, '2', '14', '2021-02-21'),
        ('a', 2, '2', '15', '2021-02-21'),
        ('a7', 3, '3', '16', '2021-02-21'),
        ('a', 1, '4', '17', '2021-02-21');
insert into `answer`(content, questionid, iscorrect)
value 
		('aa', 3, 'sai'),
        ('aa2', 5, 'sai'),
        ('aa1', 3, 'sai'),
        ('aa', 3, 'sai'),
        ('aa3', 4, 'dung'),
        ('aa', 5, 'sai'),
        ('aa', 6, 'sai');
insert into `exam`(`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
value
		('vt1','ex1', 1, '60', 1, now()),
        ('vt2','ex2', 2, '60', 2, now()),
        ('vt3','ex1', 1, '90', 1, now()),
        ('vt4','ex2', 1, '120', 2, now()),
        ('vt5','ex1', 1, '60', 1, now()),
        ('vt6','ex2', 1, '30', 2, '2021-02-11');
insert into `examquestion`(examid,questionid)
value 
		(1, 3),
        (2, 4),
        (3, 7),
        (4, 4),
        (5, 6),
        (6, 3);
        
-- testing 3--
#question2:
select * from department;
#question3:
select departmentid from department where departmentname = "sale";
#queston4:
select * from `account` where character_length(fullname)=( select max(character_length(fullname)) from `account`);
#question5:
select * from `account` where character_length(fullname)=(select max(character_length(fullname)) from `account` where departmentid=3)and departmentid = 3;
#question6:
select groupname from `group` where createdate <='2019-12-20';
#question7:
select questionid, count(questionid) as 'so cau hoi'
from answer group by questionid 
having 'so cau hoi'>=4;
#question8:

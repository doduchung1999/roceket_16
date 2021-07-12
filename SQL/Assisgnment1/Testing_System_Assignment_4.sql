/* Create database `TestingSystem` */
DROP DATABASE IF EXISTS `Testing_System`;
CREATE DATABASE IF NOT EXISTS `Testing_System`;
-- forcus database use
USE `Testing_System`;

/* Create table */

# CREATE TABLE Phòng Ban
DROP TABLE IF EXISTS `Department`;
CREATE TABLE IF NOT EXISTS `Department`
(
    `DepartmentID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `DepartmentName` VARCHAR(50) NOT NULL
);

# CREATE TABLE Chức vụ
DROP TABLE IF EXISTS `Position`;
CREATE TABLE IF NOT EXISTS `Position`
(
    `PositionID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `PositionName` ENUM ('Dev 1', 'Dev 2', 'Tester', 'PM', 'Mentor', 'Scrum Master', 'Giám đốc', 'Thư ký', 'Developer')
);

# CREATE TABLE Tài khoản
DROP TABLE IF EXISTS `Account`;
CREATE TABLE IF NOT EXISTS `Account`
(
    `AccountId`    TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Email`        VARCHAR(50) UNIQUE KEY,
    `UserName`     VARCHAR(50) NOT NULL UNIQUE KEY,
    `FullName`     VARCHAR(50),
    `DepartmentId` TINYINT,
    `PositionID`   TINYINT,
    `CreateDate`   DATETIME DEFAULT NOW()
#     CONSTRAINT pk PRIMARY KEY (AccountId)
);

# CREATE TABLE Nhóm
DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group`
(
    `GroupID`    TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `GroupName`  VARCHAR(50),
    `CreatorID`  TINYINT UNSIGNED,
    `CreateDate` DATETIME DEFAULT NOW()
);

# CREATE TABLE Nhóm Tài Khoản
DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE IF NOT EXISTS `GroupAccount`
(
    `GroupID`   TINYINT UNSIGNED,
    `AccountID` TINYINT UNSIGNED,
    `JoinDate`  DATETIME DEFAULT NOW()
);

# CREATE TABLE Loại câu hỏi
DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE IF NOT EXISTS `TypeQuestion`
(
    `TypeID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `TypeName` VARCHAR(50)
);

# CREATE TABLE loại câu hỏi
DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE IF NOT EXISTS `CategoryQuestion`
(
    `CategoryID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `CategoryName` VARCHAR(50) NOT NULL UNIQUE KEY
);

# CREATE TABLE Câu hỏi
DROP TABLE IF EXISTS `Question`;
CREATE TABLE IF NOT EXISTS `Question`
(
    `QuestionID` TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Content`    VARCHAR(100),
    `CategoryID` TINYINT UNSIGNED,
    `TypeID`     TINYINT UNSIGNED,
    `CreatorID`  TINYINT UNSIGNED NOT NULL,
    `CreateDate` DATETIME DEFAULT NOW()
);

# CREATE TABLE Câu trả lời
DROP TABLE IF EXISTS `Answer`;
CREATE TABLE IF NOT EXISTS `Answer`
(
    `AnswerID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Content`    VARCHAR(100),
    `QuestionID` TINYINT UNSIGNED NOT NULL,
    `isCorrect`  BIT,
    CONSTRAINT fk_question FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

# CREATE TABLE Đề thi
DROP TABLE IF EXISTS `Exam`;
CREATE TABLE IF NOT EXISTS `Exam`
(
    `ExamID`     TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Code`       VARCHAR(50) UNIQUE,
    `Title`      VARCHAR(50),
    `CategoryID` TINYINT UNSIGNED,
    `Duration`   TINYINT,
    `CreatorID`  TINYINT UNSIGNED,
    `CreateDate` DATETIME DEFAULT NOW()
#     ,CONSTRAINT fk_create_id FOREIGN KEY (CategoryID) REFERENCES Account (AccountId),
#     CONSTRAINT fk_category_id FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID)
);

# CREATE TABLE Bộ câu hỏi
DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE IF NOT EXISTS `ExamQuestion`
(
    `ExamID`     TINYINT,
    `QuestionID` TINYINT
);


/*---------------- INSERT DATA ------------------*/
######Insert data bảng `Department`
# cách 1 điền đầy đủ cả thông tin
# cách này dễ bị lỗi [1062] nếu `DepartmentId` insert đã tồn tại trong bảng vì đây là khóa chính ko được trùng lập
INSERT INTO Department(DepartmentID, DepartmentName)
VALUES (1, 'Phòng marketing');

#Cách 2 chỉ điền tên phòng ban, để ID tự tăng
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Sale');
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Dev 1');
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Dev 2');

#Cách 3 insert nhiều data cùng 1 lúc
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Bảo vệ'),
       ('Phòng Nhân sự'),
       ('Phòng Giám Đốc'),
       ('Phòng Kỹ thuật'),
       ('Phòng Thư ký'),
       ('Phòng Tạp vụ'),
       ('Phòng Phó Giám Đốc');

##### INSERT data bảng `position`
#Giá trị `PositionName` chỉ nhận các giá trị được gắn trong Enum vì đây là kiểu tự định nghĩa.
#`PositionName` ENUM ('Dev 1', 'Dev 2', 'Tester', 'PM', 'Mentor', 'Scrum Master', 'Giám đốc', 'Thư ký')
# ALTER TABLE `Position` CHANGE COLUMN `PositionName` `PositionName` ENUM ('Dev 1', 'Dev 2', 'Tester', 'PM', 'Mentor', 'Scrum Master', 'Giám đốc', 'Thư ký', 'Developer');

INSERT INTO `Position`(PositionName)
VALUES ('Dev 1'),
       ('Dev 2'),
       ('Giám đốc'),
       ('Tester'),
       ('PM'),
       ('Mentor'),
       ('Developer'),
       ('Scrum Master');

##### INSERT DATA bảng `Account`
INSERT INTO `Account`(Email, UserName, FullName, DepartmentId, PositionID, CreateDate)
VALUES ('email_vti1@gmail.com', 'acountvti1', 'Nguyễn Văn A', 4, 1, NOW()),
       ('email_vti2@gmail.com', 'acountvti2', 'Trinh Hoai Lam', 2, 1, '2021-02-26'),
       ('email_vti3@gmail.com', 'acountvti3', 'Nguyễn Thu Hoai', 4, 2, '2021-01-01'),
       ('email4@gmail.com', 'acountvti4', 'Trương Văn Bình', 2, 5, '2021-06-30'),
       ('email_vti5@gmail.com', 'acountvti5', 'Dương Chi Tai', 3, 3, '2021-01-01'),
       ('email6@gmail.com', 'acountvti6', 'Nguyễn Thế Hải', 9, 3, '2021-01-02'),
       ('email7@gmail.com', 'acountvti7', 'Dương Chí Dũng', 7, 1, NOW()),
       ('email8@gmail.com', 'acountvti8', 'Cao Hữu Đạt', 4, 2, NOW()),
       ('email9@gmail.com', 'acountvti9', 'Nguyễn văn B', 4, 4, '2021-05-01'),
       ('email10@gmail.com', 'acountvti10', 'Mai Anh Tài', 3, 5, '2021-06-06');
INSERT INTO `Account` (Email, UserName, FullName, DepartmentId, PositionID, CreateDate)
VALUES ('email11@gmail.com', 'acountvti11', 'Dao Van Bo', 1, 2, '2021-05-05');

INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES ('Testing System', 1, '2019-03-05'),
       ('Development', 9, '2020-03-07'),
       ('VTI Sale 01', 2, '2020-03-09'),
       ('VTI Sale 02', 9, '2020-03-10'),
       ('VTI Development', 3, '2021-01-10'),
       ('VTI Sale 05', 1, '2021-03-10'),
       ('VTI Sale 03', 9, '2020-03-28'),
       ('VTI Creator', 6, '2020-04-06'),
       ('VTI Marketing 01', 5, '2020-04-07'),
       ('Management', 5, '2020-04-08'),
       ('Chat with love', 1, '2020-04-09'),
       ('Vi Ti Ai', 10, '2020-04-10');

/* DELETE FROM GroupAccount; */
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate)
VALUES (1, 1, '2019-03-05'),
       (1, 2, '2020-03-07'),
       (1, 10, '2020-03-07'),
       (1, 8, '2020-03-07'),
       (3, 3, '2020-03-09'),
       (3, 4, '2020-03-10'),
       (5, 5, '2020-03-28'),
       (1, 3, '2020-04-06'),
       (1, 9, NOW()),
       (8, 3, NOW()),
       (1, 7, '2020-04-09'),
       (10, 10, '2020-04-10');

INSERT INTO TypeQuestion (TypeName)
VALUES ('Essay'),
       ('Multiple-Choice');

INSERT INTO CategoryQuestion (CategoryName)
VALUES ('Java'),
       ('ASP.NET'),
       ('ADO.NET'),
       ('SQL'),
       ('Postman'),
       ('Ruby'),
       ('Python'),
       ('C++'),
       ('C Sharp'),
       ('PHP');

INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES (N'Câu hỏi về Java', 1, '1', '2', '2020-04-05'),
       (N'Câu Hỏi về PHP', 10, '2', '2', '2020-04-05'),
       (N'Hỏi về C#', 9, '2', '3', '2020-04-06'),
       (N'Hỏi về Ruby', 6, '1', '4', '2020-04-06'),
       (N'Hỏi về Postman', 5, '1', '5', '2020-04-06'),
       (N'Hỏi về ADO.NET', 3, '2', '6', '2020-04-06'),
       (N'Hỏi về ASP.NET', 2, '1', '7', '2020-04-06'),
       (N'Hỏi về C++', 8, '1', '8', '2020-04-07'),
       (N'Hỏi về SQL', 4, '2', '9', '2020-04-07'),
       (N'Hỏi về Python', 7, '1', '10', '2020-04-07');
/* DELETE FROM Answer; */
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES (N'Trả lời 01', 1, 0),
       (N'Trả lời 02', 1, 1),
       (N'Trả lời 03', 1, 0),
       (N'Trả lời 04', 1, 1),
       (N'Trả lời 05', 2, 1),
       (N'Trả lời 06', 3, 1),
       (N'Trả lời 07', 4, 0),
       (N'Trả lời 08', 8, 0),
       (N'Trả lời 09', 9, 1),
       ('Trả lời 10', 10, 1),
       ('Trả lời 11', 2, 0),
       ('Trả lời 12', 2, 0),
       ('Trả lời 13', 2, 1),
       ('Trả lời 14', 3, 1),
       ('Trả lời 15', 3, 1);

INSERT INTO Exam (`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES ('VTIQ001', N'Đề thi C#', 1, 60, '5', '2019-04-05'),
       ('VTIQ002', N'Đề thi PHP', 10, 60, '2', '2019-04-05'),
       ('VTIQ003', N'Đề thi C++', 9, 120, '2', '2019-04-07'),
       ('VTIQ004', N'Đề thi Java', 6, 60, '3', '2020-04-08'),
       ('VTIQ005', N'Đề thi Ruby', 5, 120, '4', '2020-04-10'),
       ('VTIQ006', N'Đề thi Postman', 3, 60, '6', '2020-04-05'),
       ('VTIQ007', N'Đề thi SQL', 2, 60, '7', '2020-04-05'),
       ('VTIQ008', N'Đề thi Python', 8, 60, '8', '2020-04-07'),
       ('VTIQ009', N'Đề thi ADO.NET', 4, 90, '9', '2020-04-07'),
       ('VTIQ010', N'Đề thi ASP.NET', 7, 90, '10', '2020-04-08');


INSERT INTO ExamQuestion(ExamID, QuestionID)
VALUES (1, 5),
       (2, 10),
       (3, 4),
       (4, 3),
       (5, 7),
       (6, 10),
       (7, 2),
       (8, 10),
       (9, 9),
       (10, 8);

#question1:Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
select A.* , D.DepartmentName
from
`account` A join department D 
on A.DepartmentId = D.DepartmentId;

#question2:Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
select * from `account` where CreateDate > (2010-12-20);

#question3:Viết lệnh để lấy ra tất cả các developer
select A.*, P.PositionID 
from
`account` A join position P 
on A.PositionID = P.PositionID
where A.PositionID in(1,2);
#question4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
select departmentname, count(*)
from `department` D 
join `account` A on D.DepartmentId =A.DepartmentId
group by D.DepartmentId
having count(*) >3;

#question5:Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
 select EX.QuestionID , Q.Content, count(EX.QuestionID) as 'so cau hoi'
 from question Q 
 join examquestion EX on Q.QuestionID = EX.QuestionID 
 group by ex.QuestionID 
 order by EX.QuestionID desc limit 1;
 
 #question6:Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
select  CategoryID,count(CategoryID) as 'so lan'
from question
group by CategoryID;

#question7:Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
select Q.questionid, count(Q.QuestionID) as 'so exam'
from question Q join examquestion EX on Q.QuestionID = ex.QuestionID
join exam E on EX.ExamID = E.ExamID
group by QuestionID;

#question8:Lấy ra Question có nhiều câu trả lời nhất
select Q.* , count(AW.questionid) as 'so cau tra loi'
from question Q join answer AW on Q.QuestionID = aw.QuestionID
group by aw.QuestionID 
order by 'so cau tra loi' desc limit 2;

#question9:Thống kê số lượng account trong mỗi group
select G.groupName, count(GA.groupid) as 'so account'
from `group` G join groupaccount GA 
on G.GroupID = GA.GroupID 
group by ga.GroupID;

#question10:Tìm chức vụ có ít người nhất
select P.positionName , count(A.positionid) as 'so luog'
from `position` P join `account` A 
on P.PositionID = a.PositionID
group by A.PositionID
having count(A.PositionID) = (select PositionID 
from `account` 
group by PositionID
order by PositionID asc limit 1);

#question11:Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
select D.departmentName, P.positionName, count(A.positionid) as 'so luong'
from department D join `account` A 
on D.DepartmentId = A.DepartmentId 
join position P 
on A.PositionID = P.PositionID
group by D.DepartmentName, P.PositionName;

#question12:Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì
/*SELECT Q.QuestionID, Q.Content, A.FullName, TQ.TypeName AS Author, ANS.Content FROM question Q
INNER JOIN categoryquestion CQ ON Q.CategoryID = CQ.CategoryID
INNER JOIN typequestion TQ ON Q.TypeID = TQ.TypeID
INNER JOIN account A ON A.AccountID = Q.CreatorID
INNER JOIN Answer AS ANS ON Q.QuestionID = ANS.QuestionID
ORDER BY Q.QuestionID ASC;*/

select Q.questionid, Q.content, A.fullName, TQ.typename as 'do kho', AW.content as 'cau tra loi'
from question Q
join categoryquestion CQ on Q.CategoryID =CQ.CategoryID
join  typequestion TQ on Q.TypeID = TQ.TypeID
join `account` A on Q.CreatorID = A.AccountId
join answer AW on Q.QuestionID = AW.QuestionID;

#question13:Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
select T.typeName, count(Q.typeid)
from typequestion T join question Q
on T.TypeID = Q.TypeID
group by Q.TypeID;

#question14+15:Lấy ra group không có account nào
select G.groupname 
from `group` G
where G.GroupID not in
(select GA.GroupID from groupaccount GA);

#question16:Lấy ra question không có answer nào
select * from question 
where QuestionID not in 
(select QuestionID from answer);

#question17:
#a)Lấy các account thuộc nhóm thứ 1
select * from `account` A
join groupaccount GA
on A.AccountId = GA.AccountID
where groupid = 1;

#b)Lấy các account thuộc nhóm thứ 3
select * from `account` A
join groupaccount GA
on A.AccountId = GA.AccountID
where groupid = 3;

#c)Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
(select * from `account` A
join groupaccount GA
on A.AccountId = GA.AccountID
where groupid = 1)
union
(select * from `account` A
join groupaccount GA
on A.AccountId = GA.AccountID
where groupid = 3);

#question18:
#a)Lấy các group có lớn hơn 5 thành viên
select G.GroupName, count(G.GroupID) as 'soluong'
from groupaccount GA join `group` G
on Ga.GroupID = G.GroupID
group by G.GroupID
having 'soluong' > 5;

#b)Lấy các group có nhỏ hơn 7 thành viên
select G.GroupName, count(G.GroupID) as 'soluong'
from groupaccount GA join `group` G
on Ga.GroupID = G.GroupID
group by G.GroupID
having 'soluong' < 7;

#c)
(select G.GroupName, count(G.GroupID) as 'soluong'
from groupaccount GA join `group` G
on Ga.GroupID = G.GroupID
group by G.GroupID
having 'soluong' > 5)
union
(select G.GroupName, count(G.GroupID) as 'soluong'
from groupaccount GA join `group` G
on Ga.GroupID = G.GroupID
group by G.GroupID
having 'soluong' < 7);

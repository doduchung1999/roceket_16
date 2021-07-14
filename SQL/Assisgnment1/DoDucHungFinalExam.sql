drop database if exists `QuanLiDiem`;
create database if not exists `Quanlidiem`;
use `quanlidiem`;

-- 1. tao table va them ban ghi
drop table if exists `Student`;
create table if not exists `Student`(
	`id` int primary key auto_increment,
    `name` varchar(50),
    `age` tinyint,
    `gender` enum('nam', 'nu')
);

drop table if exists `Subject`;
create table if not exists `Subject`(
	`id` int primary key auto_increment,
    `name` varchar(50)
);

drop table if exists `StudentSubject`;
create table if not exists `StudentSubject`(
	`Studentid` int,
    `Subjectid` int,
    `Mark` float,
    `date` date,
    primary key (`Studentid`,`Subjectid`)
);
-- student
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van a', '21', 'nam');
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van g', '22', 'nam');
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van f', '19', 'nu');
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van e', '18', 'nu');
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van d', '19', 'nu');
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van c', '22', 'nu');
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van b', '26', 'nu');
INSERT INTO `quanlidiem`.`student` (`name`, `age`, `gender`) VALUES ('nguyen van df', '27', 'nam');
INSERT INTO `quanlidiem`.`student` (`name`, `age`) VALUES ('nu4f', '22');
-- subject
INSERT INTO `quanlidiem`.`subject` (`name`) VALUES ('van');
INSERT INTO `quanlidiem`.`subject` (`name`) VALUES ('toan');
INSERT INTO `quanlidiem`.`subject` (`name`) VALUES ('anh');
INSERT INTO `quanlidiem`.`subject` (`name`) VALUES ('hoa');
INSERT INTO `quanlidiem`.`subject` (`name`) VALUES ('ly');
-- StudentSubject
INSERT INTO `quanlidiem`.`studentsubject` (`Studentid`, `Subjectid`, `Mark`, `date`) VALUES ('1', '2', '8', '2021-04-24');
INSERT INTO `quanlidiem`.`studentsubject` (`Studentid`, `Subjectid`, `Mark`, `date`) VALUES ('2', '2', '9', '2021-04-24');
INSERT INTO `quanlidiem`.`studentsubject` (`Studentid`, `Subjectid`, `Mark`, `date`) VALUES ('3', '5', '9', '2021-04-24');
INSERT INTO `quanlidiem`.`studentsubject` (`Studentid`, `Subjectid`, `Mark`, `date`) VALUES ('4', '3', '7.5', '2021-04-24');
INSERT INTO `quanlidiem`.`studentsubject` (`Studentid`, `Subjectid`, `Mark`, `date`) VALUES ('6', '1', '10', '2021-03-27');

-- 2.a Lấy tất cả các môn học không có bất kì điểm nào
select Sj.*, ss.Subjectid from `subject` SJ 
	left join `StudentSubject` SS on Sj.id= ss.Subjectid
    where ss.Subjectid is null;

-- 2.b Lấy danh sách các môn học có ít nhất 2 điểm
select Sj.*, ss.*, count(SS.subjectid) as 'so diem' from `subject` sj
	join `StudentSubject` ss on Sj.`id` = ss.`subjectid`
    group by ss.subjectid
    order by 'so diem' desc limit 1;

-- 3. tao view studentinfo
create or replace view `Studentinfo` as
	select ss.Studentid, ss.subjectid, St.`name` as 'studenname', st.age as 'studentage', Sj.name as 'subjectname', mark, `date`,
    case when st.gender = 'nam' then st.gender = 'male' 
		when st.gender = 'nu' then st.gender = 'female'
		when st.gender is null then st.gender = 'unknow'
		end
    from `Student` ST left join `StudentSubject` SS on ST.id = SS.studentid
    left join `Subject` SJ on SS.Subjectid=sj.id ;
select * from `studentinfo`;

-- 4.a Tạo trigger cho table Subject có tên là SubjectUpdateID:Khi thay đổi data của cột ID của table Subject, thì giá trị tươngứng với cột SubjectID của table StudentSubject cũng thay đổitheo
drop trigger if exists SubjectUpdateID;
delimiter $$
create trigger SubjectUpdateID
    before delete
    on `subject`
    for each row
begin
    delete from StudentSubject where `StudentSubject`.`subjectid` = OLD.`id`;
end$$
delimiter ;
select * from StudentSubject;

-- 4.b Tạo trigger cho table Student có tên là StudentDeleteID:Khi xóa data của cột ID của table Student, thì giá trị tương ứng với cột SubjectID của table StudentSubject cũng bị xóa theo
drop trigger if exists StudentDeleteID;
delimiter $$
create trigger StudentDeleteID
    before delete
    on `student`
    for each row
begin
    delete from StudentSubject where `StudentSubject`.`subjectid` = OLD.`id`;
end$$
delimiter ;
select* from StudentSubject;

-- 5. Viết 1 store procedure (có 2 parameters: student name) sẽ xóa tất cả cácthông tin liên quan tới học sinh có cùng tên như parameterTrong trường hợp nhập vào student name = "*" thì procedure sẽ xóa tất cảcác học sinh
/*drop procedure if exists cau5;
delimiter $$
create procedure cau5(in studentname varchar(50) )
begin 
	select st.*, ss.* from Student s 
		join StudentSubject on st.id=ss.studenid;
end$$
delimiter ;*/

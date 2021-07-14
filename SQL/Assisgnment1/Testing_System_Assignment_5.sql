use testing_system;
#question1:Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
create or replace view v_cau1 as
	select A.*, D.departmentname
	from `account` A 
	join department D
	on A.DepartmentId=D.DepartmentID
    where A.DepartmentId=2;
select * from cau1;

#question2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
create or replace view v_cau2 as
	select A.*, GA.groupid 
		from `account` A 
		join groupaccount GA 
		on GA.AccountId = A.AccountID
        group by GA.AccountId
    having count(GA.AccountId) = (select
                MAX(Temp)
            from
                (select 
                    AccountID, COUNT(AccountID) as Temp
                from
                    GroupAccount
                group by AccountID) as A1);
select * from v_cau2;

##question3: Tạo view có chứa câu hỏi có những content quá dài (content quá 16 từ được coi là quá dài) và xóa nó đi
create or replace view V_cau3 as
	select * from question 
    where length(content) > 16;
select * from v_cau3;
delete from v_cau3;

#cau 3 lam chua ra dc ket qua*/

#question4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
create or replace view v_cau4 as
    select 
        A.*, GA.GroupID
    from
        GroupAccount GA
            join
        `Account` A on GA.AccountID = A.AccountID
    group by GA.GroupID
    having COUNT(GA.GroupID) = (select 
            MAX(Temp)
        from
            (select 
                GroupID, COUNT(GroupID) as Temp
            from
                GroupAccount
           group by GroupID) as Ao);
                
select 
    *
from
    v_cau4;

# Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo --
select * from Question;
select * from `Account`;
create or replace view v_cau5 as
    select 
        A.FullName, Q.Content
    from
        Question Q
            join
        `Account` A on A.AccountID = Q.CreatorID
    where
        A.FullName like 'Nguyễn %';
        
select 
    *
from
    v_cau5;
drop database if exists ThucTap;
create database if not exists ThucTap;
use thuctap;
drop table if exists GiangVien;
create table GiangVien(
	magv int primary key auto_increment,
    hoten varchar(50),
    luong int 
);
drop table if exists SinhVien;
create table if not exists SinhVien(
	masv int primary key auto_increment,
    hoten varchar(50),
    namsinh int,
    quequan varchar(50)
);
drop table if exists DeTai;
create table if not exists DeTai(
	madt tinyint primary key auto_increment,
    tendt varchar(50),
    kinhphi bigint,
    NoiThuctap varchar(50)
);
drop table if exists HuongDan;
create table if not exists HuongDan(
	ID tinyint primary key auto_increment,
    masv tinyint,
    madt tinyint,
    magv tinyint,
    ketqua enum('1', '0')
);
#insert vào bảng giangvien
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('anh', '2000000');
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('abc', '2449000');
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('dok', '3900000');
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('ekd', '1580000');
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('kocd', '1260000');
INSERT INTO `thuctap`.`giangvien` (`hoten`, `luong`) VALUES ('kcouv', '1000000');
# bang detai
INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThuctap`) VALUES ('tao database', '150000', 'vti1');
INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThuctap`) VALUES ('insert data', '200000', 'vti2');
INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThuctap`) VALUES ('change data', '300000', 'vti3');
INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThuctap`) VALUES ('sql', '2000000', 'vti4');
INSERT INTO `thuctap`.`detai` (`tendt`, `kinhphi`, `NoiThuctap`) VALUES ('java', '100000', 'vti5');
# bang huong dan
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('2', '2', '1', '1');
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('3', '1', '3', '0');
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('1', '4', '4', '1');
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('2', '3', '2', '1');
INSERT INTO `thuctap`.`huongdan` (`masv`, `madt`, `magv`, `ketqua`) VALUES ('3', '2', '1', '1');
# bang sinh vien
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('van a', 1999, 'bg');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('can b', 1998, 'bg');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('van c', 1997, 'dn');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('bói', 1999, 'hb');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('ksock', 2000, 'hna');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('kịcf', 2001, 'nb');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('lsoce', 2002, 'nd');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('skcji', 2002, 'hn');
INSERT INTO `thuctap`.`sinhvien` (`hoten`, `namsinh`, `quequan`) VALUES ('sckol', 2000, 'hn');


#2.a Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
select S.* from sinhvien S
	left join huongdan H on S.masv=H.masv
    where H.ID is null;
#b Lấy ra số sinh viên làm đề tài ‘sql’
select S.*, D.tendt from sinhvien S
	join huongdan H on S.masv = H.masv
    join detai D on H.madt=D.madt
    where tendt like 'sql';
    
#3.Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: mã số, họ tên và tên đề tài
create or replace view SinhVienInfo( maso, hoten, tendt) as
select S.masv, S.hoten,case when D.tendt is null then 'ko co de tai' else D.tendt end
from sinhvien S  left join huongdan H on S.masv=H.masv
left join Detai D on H.madt=D.madt;
select*from sinhvieninfo;

#4. trigger them sv, namsinh phai > 1900
drop trigger if exists dknamsinh;
delimiter $$
create trigger dknamsinh
	before insert on sinhvien
    for each row 
		begin
			if new.namsinh<= 1900 then
            signal sqlstate '13567'
				set message_text = 'nam sinh ko hop le';
            end if;
        end$$
delimiter ;
#INSERT INTO `thuctap`.`sinhvien` (`masv`, `hoten`, `namsinh`, `quequan`) VALUES ('12', 'ryu', 1899, 'fr');

#5 xoa 1 sv -> xoa thong tin lien quan trong table huong dan
drop trigger if exists xoasinhvien;
delimiter $$
create trigger xoasinhvien
	before delete on sinhvien
    for each row
		begin
			delete from huongdan where huongdan.masv=old.masv;
        end$$
delimiter ;

#test xoasinhvien
begin work;
select* from huongdan;
delete from sinhvien where masv = 1;
select* from huongdan;
rollback;

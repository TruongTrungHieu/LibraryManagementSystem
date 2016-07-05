USE master
GO

IF(EXISTS(SELECT name FROM Sys.databases WHERE name ='QLTV'))
	DROP DATABASE QLTV

CREATE DATABASE QLTV
GO

USE QLTV
GO

CREATE TABLE Reader
(
	ReaderID varchar(30) primary key,
	ReaderName nvarchar(50),
	PhoneNumber varchar(15),
	UserName varchar(50) unique,
	[Password] varchar(150)
)
GO
sp_readerrorlog 0,1,'server is listening on'

CREATE TABLE Issue
(
	IssueID varchar(30) primary key,
	ReaderID varchar(30),
	EmployeeID varchar(30),
	IssueDate datetime,
	DueDate datetime,
	ReturnDate datetime,
	TotalFine money,
	[Status] int
)
GO

CREATE TABLE Issue_detail
(
	IssueID varchar(30) not null,
	BookID varchar(30) not null,
	FineID varchar(30),
	primary key (IssueID,BookID),
	Number int
)
GO

CREATE TABLE Fine
(
	FineID varchar(30) primary key,
	FineName text,
	[Description] text,
	Cost money
)
GO

CREATE TABLE Employees
(
	EmployeeID varchar(30) primary key,
	Emp_Name nvarchar(50),
	[Address] varchar(200),
	PhoneNumber varchar(15),
	Email varchar(50),
	PerID varchar(30),
	Username varchar(50) unique,
	[Password] varchar(150) default '123456',	
)
GO

CREATE TABLE Permission
(
	PerID varchar(30) primary key,
	Pername nvarchar(50),
)
GO

CREATE TABLE Categories
(
	CateID varchar(30) primary key,
	CateName nvarchar(50)
)
GO


CREATE TABLE Publishers
(
	PubID varchar(30) primary key,
	PubName nvarchar(50) 
)
GO

CREATE TABLE Books
(
	BookID varchar(30) primary key,
	--CallNumber varchar(50) unique,
	Title nvarchar(100),
	AuthorName nvarchar(50),
	CategoryID varchar(30),
	PublisherID varchar(30),
	Numberofcopies int,
	[Description] text
)
GO

ALTER TABLE Issue ADD
	CONSTRAINT FK_Issue_Readers FOREIGN KEY (ReaderID) REFERENCES Reader(ReaderID),
	CONSTRAINT FK_Issue_Employees FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
GO

ALTER TABLE Books ADD
	CONSTRAINT FK_Books_Categories FOREIGN KEY (CategoryID) REFERENCES Categories(CateID),
	CONSTRAINT FK_Books_Publishers FOREIGN KEY (PublisherID) REFERENCES Publishers(PubID)
GO 

ALTER TABLE Employees ADD
	CONSTRAINT FK_PerID FOREIGN KEY (PerID) REFERENCES Permission(PerID)
GO
	
ALTER TABLE Issue_detail ADD
	CONSTRAINT FK_Fine FOREIGN KEY (FineID) REFERENCES Fine(FineID),
	CONSTRAINT FK_Issue FOREIGN KEY (IssueID) REFERENCES Issue(IssueID),
	CONSTRAINT FK_Books FOREIGN KEY (BookID) REFERENCES Books(BookID)
GO

ALTER TABLE Reader 
	ALTER COLUMN [Password] varchar(150) default '123456'

-- INSERT
-- Permission
INSERT INTO Permission VALUES ('1', N'Admin')
INSERT INTO Permission VALUES ('2', N'Employee')

INSERT INTO Employees VALUES ('employee1', N'Quản trị viên - Boss', N'Không có', '0356895642', 'admin@lms.edu.vn', '1', 'admin', '123456')
INSERT INTO Reader VALUES ('reader1', N'Cảnh Cảnh', '0986523521', 'reader1', '123456')
INSERT INTO Reader VALUES ('reader2', N'Sieeu nhaan', '0986523521', 'reader2', '123456')
INSERT INTO Reader VALUES ('reader2', N'Sieeu nhaan', '0986523521', 'reader2')
SELECT ReaderID, ReaderName, PhoneNumber, UserName  FROM Reader

SELECT * FROM Employees

INSERT INTO Categories VALUES ('cat1', N'Ngôn tình')
INSERT INTO Categories VALUES ('cat2', N'Truyện cổ tích')

INSERT INTO Publishers VALUES ('pub1', N'Nhà xuất bản Giáo dục')
INSERT INTO Publishers VALUES ('pub2', N'Nhà xuất bản Tuổi trẻ')

INSERT INTO Books VALUES ('book1', N'Thất tịch không mưa', N'Lâu Vũ Tình', 'cat1', 'pub1', 20, N'Từ nhỏ cô đã thầm yêu anh, như số kiếp không thể thay đổi
Tình  yêu trong sáng ấy, như lần đầu được nếm mùi vị của quả khế mới chín.
Sau đó cô và anh xa nhau, gặp lại đều cách nhau ba năm.')

INSERT INTO Books VALUES ('book2', N'Clean Code: A Handbook of Agile Software Craftsmanship', N'Robert C. Martin', 'cat1', 'pub2', 20, 'Even bad code can function. But if code is not clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it does not have to be that way.')

INSERT INTO Books VALUES ('book3', N'Da Vinci code', N'Dan Brown', 'cat2', 'pub1', 5, 'Simbolog Robert Langdon menerima telepon misterius yang mengundangnya ke Museum Louvre Paris pada tengah malam.')

SELECT Issue.IssueID, Issue.ReaderID, Reader.ReaderName, Reader.PhoneNumber, Issue.EmployeeID, Employees.Emp_name, Employees.Address, Employees.PhoneNumber, Employees.Email, Employees.PerID, Issue.IssueDate, Issue.DueDate, Issue.ReturnDate, Issue.TotalFine, Issue.Status FROM Issue INNER JOIN Employees ON Issue.EmployeeID = Employees.EmployeeID INNER JOIN Reader ON Issue.ReaderID = Reader.ReaderID WHERE Issue.Status = 1

select * from Issue
select * from Issue_detail

insert into Fine Values ('2', N'Cong, nhàu sách', '', 10000)
insert into Fine Values ('3', N'Rách giấy', '', 20000)
insert into Fine Values ('4', N'Mất sách', '', 500000)
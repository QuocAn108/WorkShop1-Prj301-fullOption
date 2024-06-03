Create database MobileManagement

use MobileManagement

CREATE TABLE tbl_Mobile (
    mobileId varchar(10) PRIMARY KEY,
    Description varchar(250) not null,
    Price float,
    mobileName varchar(20) not null,
    yearOfProduction int,
    Quantity int,
    notSale bit
);

drop table tbl_Mobile

CREATE TABLE tbl_User (
    userID varchar(20) PRIMARY KEY,
    password int NOT NULL,
    fullName varchar(50) not null,
    role int CHECK (role IN (0, 1, 2))
);

drop table tbl_User
INSERT INTO tbl_User (userID, password, fullName, role)
VALUES
    ('an', 1, 'Hoang Quoc An', 2),
    ('binh', 1, 'Nguyen Pham Thanh Binh', 0),
	('minh', 1, 'Vo Quang Minh', 0),
	('tu', 1, 'Nguyen Ngo Anh Tu',0),
	('suon', 1,'Nguyen Hoang Duc Minh',0);

INSERT INTO tbl_Mobile (mobileId, Description, Price, mobileName, yearOfProduction, Quantity, notSale)
VALUES
    ('M001', 'Sample Description 1', 299.99, 'Iphone X', 2020, 100, 0),
    ('M002', 'Sample Description 2', 399.99, 'Iphone 11', 2021, 150, 1),
    ('M003', 'Sample Description 3', 199.99, 'Iphone 12', 2019, 50, 1),
    ('M004', 'Sample Description 4', 499.99, 'Iphone 13', 2022, 200, 1),
    ('M005', 'Sample Description 5', 599.99, 'Iphone 14', 2023, 180, 0),
    ('M006', 'Sample Description 6', 349.99, 'Iphone 15', 2021, 120, 1),
    ('M007', 'Sample Description 7', 249.99, 'Iphone 8', 2020, 80, 0),
    ('M008', 'Sample Description 8', 449.99, 'Samsung S8', 2022, 170, 0),
    ('M009', 'Sample Description 9', 299.99, 'Samsung Zflip', 2018, 60, 1);




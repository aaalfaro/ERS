--CREATE USER projectOne IDENTIFIED BY password;
--GRANT CREATE SEQUENCE TO projectOne;
--GRANT CREATE PROCEDURE TO projectOne;
--GRANT CREATE TRIGGER TO projectOne;
--GRANT UNLIMITED TABLESPACE TO projectOne;
--GRANT CREATE SESSION TO projectOne;
--GRANT CREATE TABLE TO projectOne;

CREATE TABLE employee(
    e_id NUMBER PRIMARY KEY,
    title VARCHAR(20)NOT NULL,
    username VARCHAR(30) UNIQUE,
    password VARCHAR(200)NOT NULL
);

CREATE TABLE information(
    e_id NUMBER PRIMARY KEY,
    f_name VARCHAR2(30) NOT NULL,
    l_name VARCHAR2(30) NOT NULL,
    telephone VARCHAR2(30),
    address VARCHAR2(60) NOT NULL,
    CONSTRAINT FK_employee FOREIGN KEY(e_id) REFERENCES employee(e_id)
);

CREATE TABLE reimbursement(
    r_id NUMBER PRIMARY KEY,
    request_id NUMBER NOT NULL,
    manager_id NUMBER,
    recieved DATE DEFAULT CURRENT_TIMESTAMP,
    resolved DATE,
    CONSTRAINT FK_request FOREIGN KEY(request_id) REFERENCES employee(e_id),
    CONSTRAINT FK_manager FOREIGN KEY(manager_id) REFERENCES employee(e_id)
);

CREATE TABLE reimbursement_info(
    r_id NUMBER UNIQUE,
    category VARCHAR2(30) NOT NULL,
    status VARCHAR2(10) DEFAULT('pending'),
    amount float NOT NULL,
    image blob,
    CONSTRAINT FK_reimbursement FOREIGN KEY(r_id) REFERENCES reimbursement(r_id)
);

--Populate our DB
INSERT INTO EMPLOYEE(title,username,password) VALUES('Associate', 'bg2000','password');
INSERT INTO EMPLOYEE(title,username,password) VALUES('Financial Manager', 'andy1991','boss');
INSERT INTO employee(title,username,password) VALUES('Trainer','pokeMaster','charizard');
INSERT INTO EMPLOYEE(title,username,password) VALUES('Financial Manager', 'pheonix2005', 'boss');

INSERT INTO information(e_id,f_name,l_name,telephone,address) VALUES(1,'Bryan','Grayson','202-331-9786','120 makebelieve avenue');
INSERT INTO information(e_id,f_name,l_name,telephone,address) VALUES(2,'Andy','Alfaro','241-717-7491','Somewhere in Dulles Greene');
INSERT INTO information(e_id,f_name,l_name,telephone,address) VALUES(4,'William','Gentry','123-456-7890','404 Pallet Town');
INSERT INTO information(e_id,f_name,l_name,telephone,address) VALUES(5,'Ben','Anderson','241-404-0912','In your database');
commit;
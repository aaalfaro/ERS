--Sequence for incrementing employee id
CREATE SEQUENCE employee_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NOCACHE;
    
CREATE OR REPLACE TRIGGER before_employee_insert
    BEFORE INSERT
    ON employee
    FOR EACH ROW
    BEGIN
        IF :new.e_id is NULL THEN
            SELECT employee_id_sequence.nextval INTO :new.e_id FROM DUAL;
        END IF;
        SELECT GET_EMPLOYEE_HASH(:new.username,:new.password)INTO :new.password FROM DUAL;
    END;
    /
    
CREATE SEQUENCE reimbursement_id_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NOCACHE;
    
CREATE SEQUENCE reimbursement_info_sequence
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    NOCACHE;

    
CREATE OR REPLACE TRIGGER before_reimbursement_insert
    BEFORE INSERT
    ON reimbursement
    FOR EACH ROW
    BEGIN
        IF :new.r_id is NULL THEN
            SELECT reimbursement_id_sequence.nextval INTO :new.r_id FROM DUAL;
        END IF;
    END;
    /
    
CREATE OR REPLACE TRIGGER before_r_Info_insert
    BEFORE INSERT
    ON reimbursement_info
    FOR EACH ROW
    BEGIN
        IF :new.r_id is NULL THEN
            SELECT reimbursement_info_sequence.nextval INTO :new.r_id FROM DUAL;
        END IF;
    END;
    /
    
CREATE OR REPLACE FUNCTION GET_EMPLOYEE_HASH(USERNAME VARCHAR2, PASSWORD VARCHAR2) RETURN VARCHAR2
IS
EXTRA VARCHAR2(10) := 'SALT';
BEGIN
  RETURN TO_CHAR(DBMS_OBFUSCATION_TOOLKIT.MD5(
  INPUT => UTL_I18N.STRING_TO_RAW(DATA => USERNAME || PASSWORD || EXTRA)));
END;
/

CREATE OR REPLACE PROCEDURE insert_reimbursement(e_id IN NUMBER)
AS
BEGIN
    INSERT INTO reimbursement(request_id) VALUES(e_id);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE insert_r_info(cat IN VARCHAR2,money IN float, img IN blob)
AS
BEGIN
    INSERT INTO reimbursement_info(category,amount, image)VALUES(cat,money,img);
    COMMIT;
END;
/
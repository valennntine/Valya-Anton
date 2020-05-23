CREATE TABLE DRIVER (
    ID NUMBER GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL,
    NAME VARCHAR2(200),
    WINS NUMBER,
    CONSTRAINT PK_DRIVER PRIMARY KEY (ID) ENABLE
);


COMMENT ON COLUMN DRIVER.ID IS 'Unique identifier';
COMMENT ON COLUMN DRIVER.NAME IS 'Driver name';
COMMENT ON COLUMN DRIVER.WINS IS 'Number of wins';
CREATE TABLE CIRCUIT (
    ID NUMBER GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL,
    NAME VARCHAR2(100),
    DISTANCE NUMBER,
    LATITUDE NUMBER,
    LONGITUDE NUMBER,
    COUNTRY VARCHAR2(100),
    CITY VARCHAR2(100),
    CONSTRAINT PK_TRACK PRIMARY KEY (ID) ENABLE
);

COMMENT ON COLUMN CIRCUIT.EMPLOYEE_ROLE.ID IS 'Unique identifier';
COMMENT ON COLUMN CIRCUIT.NAME IS 'Circuit name';
COMMENT ON COLUMN CIRCUIT.DISTANCE IS 'Circuit distance';
COMMENT ON COLUMN CIRCUIT.LATITUDE IS 'Circuit latitude';
COMMENT ON COLUMN CIRCUIT.LONGITUDE IS 'Circuit longitude';
COMMENT ON COLUMN CIRCUIT.COUNTRY IS 'Contry where circuit is located';
COMMENT ON COLUMN CIRCUIT.CITY IS 'City where circuit is located';

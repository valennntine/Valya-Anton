create table driver (
    id number generated always as identity increment by 1 start with 1 minvalue 1 not null,
    name varchar2(200),
    POLES NUMBER,
    SEASONS NUMBER,
    wins number,
    CONSTRAINT PK_DRIVER PRIMARY KEY (ID) ENABLE
);


COMMENT ON COLUMN DRIVER.ID IS 'Unique identifier';
COMMENT ON COLUMN DRIVER.NAME IS 'Driver name';
COMMENT ON COLUMN DRIVER.POLES IS 'Number of driver poles';
COMMENT ON COLUMN DRIVER.SEASONS IS 'Number of driver seasons';
COMMENT ON COLUMN DRIVER.WINS IS 'Number of driver wins';
CREATE TABLE EVENT_DRIVER (
    ID NUMBER GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL,
    EVENT_ID NUMBER,
    DRIVER_ID NUMBER,
    CONSTRUCTOR_ID NUMBER,
    START_POSITION NUMBER,
    POINTS NUMBER,
    TIME VARCHAR2(100),
    CONSTRAINT PK_EVENT_DRIVER PRIMARY KEY (ID) ENABLE
);


COMMENT ON COLUMN EVENT_DRIVER.ID IS 'Unique identifier';
COMMENT ON COLUMN EVENT_DRIVER.EVENT_ID IS 'Reference on event table';
COMMENT ON COLUMN EVENT_DRIVER.DRIVER_ID IS 'Reference on driver table';
COMMENT ON COLUMN EVENT_DRIVER.CONSTRUCTOR_ID IS 'Reference on constructor table';
COMMENT ON COLUMN EVENT_DRIVER.START_POSITION IS 'The digit of position on circuit';
COMMENT ON COLUMN EVENT_DRIVER.POINTS IS 'The number of points driver got';
COMMENT ON COLUMN EVENT_DRIVER.TIME IS 'Time offset on finish';
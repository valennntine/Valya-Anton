CREATE TABLE EVENT (
    ID NUMBER GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL,
    NAME VARCHAR2(100),
    LAPS NUMBER,
    DATETIME VARCHAR2(100),
    CIRCUIT_ID NUMBER,
    POLE_POSITION_ID NUMBER,
    WINNER_ID NUMBER,
    SEASON_ID NUMBER,
    CONSTRAINT PK_EVENT PRIMARY KEY (ID) ENABLE
);

COMMENT ON COLUMN EVENT.ID IS 'Unique identifier';
COMMENT ON COLUMN EVENT.NAME IS 'Event name';
COMMENT ON COLUMN EVENT.LAPS IS 'A number of laps';
COMMENT ON COLUMN EVENT.DATETIME IS 'Event date';
COMMENT ON COLUMN EVENT.CIRCUIT_ID IS 'Reference to circuit table';
COMMENT ON COLUMN EVENT.POLE_POSITION_ID IS 'Reference to driver table';
COMMENT ON COLUMN EVENT.WINNER_ID IS 'Reference to driver table';
COMMENT ON COLUMN EVENT.SEASON_ID IS 'Reference to season table';
CREATE TABLE SEASON_EVENT (
    ID NUMBER GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL,
    SEASON_ID NUMBER,
    EVENT_ID NUMBER,
    circuit_id number,
    fastest_lap timestamp,
    CONSTRAINT PK_SEASON_EVENT PRIMARY KEY(ID) ENABLE
);

COMMENT ON COLUMN SEASON_EVENT.ID IS 'Unique identifier';
COMMENT ON COLUMN SEASON_EVENT.SEASON_ID IS 'Reference to season table';
COMMENT ON COLUMN SEASON_EVENT.EVENT_ID IS 'Reference to event table';
comment on column SEASON_EVENT.circuit_id is 'reference to circuit table';
comment on column SEASON_EVENT.fastest_lap is 'time of the shortest lap per event';
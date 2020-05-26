CREATE TABLE EVENT (
    ID NUMBER GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 1 MINVALUE 1 NOT NULL,
    name varchar2(100),
    e_date timestamp,
    constraint PK_event primary key (id) enable
);
COMMENT ON COLUMN EVENT.ID IS 'Unique identifier';
COMMENT ON COLUMN EVENT.NAME IS 'Event name';
COMMENT ON COLUMN EVENT.e_date IS 'Event date';
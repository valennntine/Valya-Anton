CREATE TABLE CONSTRUCTOR (
    id number generated always as identity increment by 1 start with 1 minvalue 1 not null,
    name varchar2(200),
    wins number,
    constraint PK_construcotr primary key (id) enable
);

COMMENT ON COLUMN CONSTRUCTOR.ID IS 'Unique identifier';
COMMENT ON COLUMN CONSTRUCTOR.NAME IS 'Constructor team name';
COMMENT ON COLUMN CONSTRUCTOR.WINS IS 'Number of wins';


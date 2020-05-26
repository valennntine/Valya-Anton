create table driver_statistic (
    id number generated always as identity increment by 1 start with 1 minvalue 1 not null,
    driver_id number not null,
    constructor_id number not null,
    season_id number not null,
    constraint PK_driver_statistic primary key (id) enable
);

comment on column driver_statistic.id is 'unique identifier';
comment on column driver_statistic.driver_id is 'reference to driver table';
comment on column driver_statistic.constructor_id is 'reference to constructor table';
comment on column driver_statistic.season_id is 'reference to season table';
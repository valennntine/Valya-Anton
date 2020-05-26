create table constructor_statistic (
    id number generated always as identity increment by 1 start with 1 minvalue 1 not null,
    season_id number not null,
    constructor_id number not null,
    wins number,
    constraint PK_construcotr_statistic primary key (id) enable
);

comment on column constructor_statistic.id is 'unique identifier';
comment on column constructor_statistic.season_id is 'reference to season in which a team has took a part';
comment on column constructor_statistic.wins is 'number of wins by team per season';
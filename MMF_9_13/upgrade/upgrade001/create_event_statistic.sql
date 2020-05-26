create table event_statistic (
    id number generated always as identity increment by 1 start with 1 minvalue 1 not null,
    event_id number not null,
    season_id number not null,
    winner_id number,
    pole_position_id number,
    laps number,
    constraint PK_event_statistic primary key (id) enable
);

comment on column event_statistic.id is 'unique identifier';
comment on column event_statistic.event_id is 'reference to event';
comment on column event_statistic.season_id is 'reference to season';
comment on column event_statistic.winner_id is 'reference to driver-winner';
comment on column event_statistic.pole_position_id is 'reference to driver who took a pole pos';
comment on column event_statistic.laps is 'number of laps per event';
DEFINE USER_NAME = &&1
DEFINE INDEX_TABLESPACE = '&&USER_NAME._IDX'

alter table driver_statistic add constraint FK_driver_statistic_driver foreign key (driver_id) references driver(id) on delete cascade;
alter table driver_statistic add constraint FK_driver_statistic_constructor foreign key (constructor_id) references constructor(id) on delete cascade;
alter table driver_statistic add constraint FK_driver_statistic_season foreign key (season_id) references season(id) on delete cascade;
create index FK_driver_statistic_driver_IDX on driver_statistic(driver_id) tablespace &&INDEX_TABLESPACE;
create index FK_driver_statistic_constructor_IDX on driver_statistic(constructor_id) tablespace &&INDEX_TABLESPACE;
create index FK_driver_statistic_season_IDX on driver_statistic(season_id) tablespace &&INDEX_TABLESPACE;

alter table constructor_statistic add constraint FK_constructor_statistic_constructor foreign key (constructor_id) references constructor(id) on delete cascade;
alter table constructor_statistic add constraint FK_constructor_statistic_season foreign key (season_id) references season(id) on delete cascade;
create index FK_constructor_statistic_constructor_IDX on constructor_statistic(constructor_id) tablespace &&INDEX_TABLESPACE;
create index FK_constructor_statistic_season_IDX on constructor_statistic(season_id) tablespace &&INDEX_TABLESPACE;

alter table season_event add constraint FK_season_event_season foreign key (season_id) references season(id) on delete cascade;
alter table season_event add constraint FK_season_event_event foreign key (event_id) references event(id) on delete cascade;
alter table season_event add constraint FK_season_event_circuit foreign key (circuit_id) references circuit(id) on delete set null;
create index FK_season_event_season_IDX on season_event(season_id) tablespace &&INDEX_TABLESPACE;
create index FK_season_event_event_IDX on season_event(event_id) tablespace &&INDEX_TABLESPACE;
create index FK_season_event_circuit_IDX on season_event(circuit_id) tablespace &&INDEX_TABLESPACE;

alter table event_driver add constraint FK_event_driver_event foreign key (event_id) references event(id) on delete cascade;
alter table event_driver add constraint FK_event_driver_driver foreign key (driver_id) references driver(id) on delete cascade;
alter table event_driver add constraint FK_event_driver_constructor foreign key (constructor_id) references constructor(id) on delete cascade;
create index FK_event_driver_event_IDX on event_driver(event_id) tablespace &&INDEX_TABLESPACE;
create index FK_event_driver_driver_IDX on event_driver(driver_id) tablespace &&INDEX_TABLESPACE;
create index FK_event_driver_constructor_IDX on event_driver(constructor_id) tablespace &&INDEX_TABLESPACE;

alter table event_statistic add constraint FK_event_statistic_event foreign key (event_id) references event(id) on delete cascade;
alter table event_statistic add constraint FK_event_statistic_season foreign key (season_id) references season(id) on delete cascade;
alter table event_statistic add constraint FK_event_statistic_winner foreign key (winner_id) references driver(id) on delete cascade;
alter table event_statistic add constraint FK_event_statistic_pole foreign key (pole_position_id) references driver(id) on delete cascade;
create index FK_event_statistic_event_IDX on event_statistic(event_id) tablespace &&INDEX_TABLESPACE;
create index FK_event_statistic_season_IDX on event_statistic(season_id) tablespace &&INDEX_TABLESPACE;
create index FK_event_statistic_winner_IDX on event_statistic(winner_id) tablespace &&INDEX_TABLESPACE;
create index FK_event_statistic_pole_IDX on event_statistic(pole_position_id) tablespace &&INDEX_TABLESPACE;

UNDEFINE USER_NAME
UNDEFINE INDEX_TABLESPACE

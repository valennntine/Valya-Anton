SET TIMING ON
SPOOL UPGRADE_FILE.LOG
DEFINE USER_NAME = &&1

CONNECT &&USER_NAME/oracle;

@./upgrade001/create_circuit_table.sql
@./upgrade001/create_constructor.sql
@./upgrade001/create_constructor_statistic.sql
@./upgrade001/create_driver.sql
@./upgrade001/create_driver_statistic.sql
@./upgrade001/create_event_driver.sql
@./upgrade001/create_event.sql
@./upgrade001/create_event_statistic.sql
@./upgrade001/create_season_event.sql
@./upgrade001/create_season.sql
@./upgrade001/create_fk.sql &&USER_NAME

-- UNDEFINE USER_NAME
SPOOL OFF
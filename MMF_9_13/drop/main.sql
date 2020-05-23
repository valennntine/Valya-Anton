SET TIMING ON
SPOOL DROP_FILE.LOG

DEFINE USER_NAME = &&1

PROMPT 'run drop_schema with param user_name = &&USER_NAME'
@drop_schema.sql &&USER_NAME

PROMPT 'run drop_tablespace.sql with param user_name = &&USER_NAME'
@drop_tablespace.sql &&USER_NAME

UNDEFINE USER_NAME
SPOOL OFF
SET TIMING ON
SPOOL INSTALL_FILE.LOG

DEFINE USER_NAME = &&1
DEFINE TBS_LOCATION = &&2

PROMPT  "execute create_tablespace.sql for data tablespace"
PROMPT  "user_name = &&USER_NAME"
PROMPT  "file location = &&TBS_LOCATION"

@create_tablespace.sql &&USER_NAME &&TBS_LOCATION DATA

PROMPT  "execute create_tablespace.sql for index tablespace"
PROMPT  "user_name = &&USER_NAME"
PROMPT  "file location = &&TBS_LOCATION"

@create_tablespace.sql &&USER_NAME &&TBS_LOCATION IDX

@create_schema.sql &&USER_NAME

@privilege_schema.sql &&USER_NAME


UNDEFINE USER_NAME
UNDEFINE TBS_LOCATION
SPOOL OFF
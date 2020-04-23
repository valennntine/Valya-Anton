
SET TIME ON
SET TIMING ON
SET APPINFO ON
PROMPT Enter username
DEFINE USER_NAME = &&1
PROMPT tbs_location
DEFINE TBS_LOCATION =  &&2
PROMPT Enter schema_name
DEFINE SCHEMA_NAME = &&3
PROMPT Enter schema password
DEFINE SCHEMA_PASSWORD = &&4;

SPOOL INSTALL_SCHEMA.LOG
 
SET SERVEROUTPUT ON

PROMPT Script info:
select sys_context('USERENV', 'MODULE') from dual; 
PROMPT
PROMPT Username to create: &&USER_NAME
PROMPT Path of datafile location: &&TBS_LOCATION
PROMPT
PROMPT Calling create_tablespace.sql for data tablespace
PROMPT
@create_tablespaces.sql &&USER_NAME &&TBS_LOCATION DATA 
PROMPT



PROMPT Calling create_tablespace.sql for index tablespace
PROMPT
@create_tablespace.sql &&USER_NAME &&TBS_LOCATION IDX 
PROMPT

PROMPT

PROMPT Calling create_schema.sql for index tablespace
PROMPT

@create_schema.sql &&SCHEMA_NAME &&SCHEMA_PASSWORD '&&USER_NAME'||'_DATA' 

PROMPT

PROMPT Calling privilege_schema.sql for index tablespace
PROMPT

@privilege_schema.sql &&SCHEMA_NAME

SET SERVEROUTPUT OFF

UNDEFINE USER_NAME
UNDEFINE TBS_LOCATION 
UNDEFINE SCHEMA_NAME
UNDEFINE SCHEMA_PASSWORD


SPOOL OFF
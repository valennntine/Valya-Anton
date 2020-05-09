SET TIME ON
SET TIMING ON
SET APPINFO ON


PROMPT Enter username
DEFINE USER_NAME = &&1
PROMPT Enter tablespace location
DEFINE TBS_LOCATION =  &&2
 
SPOOL INSTALL_SCHEMA.LOG

SET SERVEROUTPUT ON
PROMPT *********
PROMPT Username to create: &&USER_NAME
PROMPT
PROMPT Path of datafile location: &&TBS_LOCATION
PROMPT 
PROMPT Calling create_tablespace.sql for data tablespace
PROMPT *********

@create_tablespace.sql &&USER_NAME &&TBS_LOCATION  
PROMPT

PROMPT *********
PROMPT Calling create_user.sql 
PROMPT *********

@create_user.sql &&USER_NAME '&&USER_NAME._DATA' 

PROMPT *********
PROMPT Calling grant.sql for &&USER_NAME
PROMPT *********

@grants.sql &&USER_NAME

SET SERVEROUTPUT OFF

UNDEFINE USER_NAME;
UNDEFINE TBS_LOCATION;


SPOOL OFF
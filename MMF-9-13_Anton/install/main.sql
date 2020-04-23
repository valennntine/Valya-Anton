SET TIMING ON
SET APPINFO ON

PROMPT Enter schema name:
DEFINE SCHEMA_NAME = &&1
PROMPT Enter password:
DEFINE SCHEMA_PASSWORD = &&2
PROMPT Enter DB location:
DEFINE TABLESPACE_LOCATION = &&3

SPOOL INSTALL_LOG.LOG
SET SERVEROUTPUT ON

alter session set "_ORACLE_SCRIPT"=true;

PROMPT ___
PROMPT Executing create_tablespace.sql
PROMPT ___

@create_tablespace.sql &&SCHEMA_NAME &&TABLESPACE_LOCATION

PROMPT ___
PROMPT Executing create_schema.sql
PROMPT ___

@create_schema.sql &&SCHEMA_NAME &&SCHEMA_PASSWORD '&&SCHEMA_NAME._DATA' 

PROMPT ___
PROMPT Executing privilege_schema.sql
PROMPT ___

@privilege_schema.sql &&SCHEMA_NAME

SET SERVEROUTPUT OFF
SPOOL OFF

UNDEFINE SCHEMA_NAME;
UNDEFINE SCHEMA_PASSWORD;

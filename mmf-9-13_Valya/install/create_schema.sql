prompt**************
prompt Script: create_schema.sql
prompt**************

define SCHEMA_NAME = &&1
define SCHEMA_PASSWORD = &&2
define DEFAULT_TBS = &&3

CREATE USER &&SCHEMA_NAME
  IDENTIFIED BY &&SCHEMA_PASSWORD
  DEFAULT TABLESPACE &&DEFAULT_TBS
  TEMPORARY TABLESPACE temp
    QUOTA 20M on &&DEFAULT_TBS;



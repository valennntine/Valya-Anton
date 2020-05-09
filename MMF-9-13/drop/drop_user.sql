DEFINE USER_NAME = &&1

alter session set "_oracle_script"=true;

DROP USER "&&USER_NAME" CASCADE;
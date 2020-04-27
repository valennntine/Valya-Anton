DEFINE USER_NAME_DROP = &&1;

alter session set "_oracle_script"=true;

DROP USER &&USER_NAME_DROP CASCADE; 

UNDEFINE USER_NAME_DROP;
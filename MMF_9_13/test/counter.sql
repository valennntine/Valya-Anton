set serveroutput on size 30000;
declare
    num NUMBER;    
begin
    select count(id) into num from circuit;
    dbms_output.put_line('circuit: rows: ' || num);
    select count(id) into num from constructor;
    dbms_output.put_line('constructor: rows: ' || num);
    select count(id) into num from constructor_statistic;
    dbms_output.put_line('constructor_statistic: rows: ' || num);
    select count(id) into num from driver;
    dbms_output.put_line('driver: rows: ' || num);
    select count(id) into num from driver_statistic;
    dbms_output.put_line('driver_statistic: rows: ' || num);
    select count(id) into num from event_driver;
    dbms_output.put_line('event_driver: rows: ' || num);
    select count(id) into num from event;
    dbms_output.put_line('event: rows: ' || num);
    select count(id) into num from event_statistic;
    dbms_output.put_line('event_statistic: rows: ' || num);
    select count(id) into num from season_event;
    dbms_output.put_line('season_event: rows: ' || num);
    select count(id) into num from season;
    dbms_output.put_line('season: rows: ' || num);
end;
/
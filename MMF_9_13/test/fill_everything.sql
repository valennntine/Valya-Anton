merge into driver
    using (
        select distinct
        dt.driver d_name,
        dt.driver_wins d_win
        from data_table dt
    ) tmp
    on (
    tmp.d_name = driver.name and
    tmp.d_win = driver.wins
    )
when not matched then 
    insert (
    driver.name,
    driver.wins
    ) values (
    tmp.d_name,
    tmp.d_win
    );
    


merge into constructor 
    using (
        select distinct
        dt.constructor con_name,
        dt.constructor_wins con_win
        from data_table dt
    ) tmp
    on (
    tmp.con_name = constructor.name and
    tmp.con_win = constructor.wins
    )
when not matched then
    insert (
    constructor.name,
    constructor.wins
    ) values (
    tmp.con_name, 
    tmp.con_win
    );
    
merge into season
    using (
        select distinct
        dt.season name
        from data_table dt
    ) tmp
    on (
    season.name = tmp.name
    )
when not matched then
    insert (
    season.name
    ) values (
    tmp.name
    );

merge into circuit 
    using (
        select distinct
        dt.circuit c_name
        from data_table dt
    ) tmp
    on (
    circuit.name = tmp.c_name
    )
when not matched then
    insert (
    circuit.name
    ) values (
    tmp.c_name
    );


merge into event
    using (
        select distinct
        dt."Date" e_date,
        dt.event e_name
        from data_table dt
    ) tmp 
    on (
    event.name = tmp.e_name and
    event.e_date = to_date(tmp.e_date,'mm/dd/yyyy')
    )
when not matched then
    insert (
    event.name,
    event.e_date
    ) values (
    tmp.e_name,
    to_date(tmp.e_date,'mm/dd/yyyy')
    );
    
    

merge into event_statistic
    using (
        select distinct
        e.id e_id,
        d.id d_id,
        pole.id p_id,
        dt.laps laps,
        s.id s_id
        from data_table dt
        left join event e
        on e.name = dt.event and to_date(dt."Date",'mm/dd/yyyy') = e.e_date
        left join driver d
        on d.name = dt.winner
        left join driver pole
        on pole.name = dt.pole_position
        left join season s
        on s.name = dt.season
    ) tmp
    on (
    event_statistic.event_id = tmp.e_id and
    event_statistic.season_id = tmp.s_id and
    event_statistic.winner_id = tmp.d_id and
    event_statistic.pole_position_id = tmp.p_id and
    event_statistic.laps = tmp.laps
    ) 
when not matched then
    insert (
    event_statistic.event_id,
    event_statistic.season_id,
    event_statistic.winner_id,
    event_statistic.pole_position_id,
    event_statistic.laps
    ) values (
    tmp.e_id,
    tmp.s_id,
    tmp.d_id,
    tmp.p_id,
    tmp.laps
    );

delete from event_statistic

merge into event_driver 
    using (
        select distinct
        dt.start_driver_place s_pos,
        d.id d_id,
        dt.points pts,
        dt.time d_time,
        c.id c_id,
        e.id e_id
        from data_table dt
        left join driver d
        on d.name = dt.driver
        left join constructor c
        on c.name = dt.constructor
        left join event e
        on e.name = dt.event and to_date(dt."Date", 'mm/dd/yyyy') = e.e_date
    ) tmp
    on (
    event_driver.event_id = tmp.e_id and
    event_driver.driver_id = tmp.d_id and
    event_driver.constructor_id = tmp.c_id and
    event_driver.start_position = tmp.s_pos and
    event_driver.points = tmp.pts and
    event_driver.time = tmp.d_time 
    )
when not matched then
    insert (
    event_driver.event_id,
    event_driver.driver_id,
    event_driver.constructor_id,
    event_driver.start_position,
    event_driver.points,
    event_driver.time
    ) values (
    tmp.e_id,
    tmp.d_id,
    tmp.c_id,
    tmp.s_pos,
    tmp.pts,
    tmp.d_time
    );
    
merge into season_event 
    using (
        select distinct
        s.id s_id,
        e.id e_id,
        circ.id c_id
        from data_table dt
        left join event e
        on e.name = dt.event and to_date(dt."Date", 'mm/dd/yyyy') = e.e_date
        left join season s
        on s.name = dt.season
        left join circuit circ
        on circ.name = dt.circuit
    ) tmp
    on (
    season_event.season_id = tmp.s_id and
    season_event.event_id = tmp.e_id and
    season_event.circuit_id = tmp.c_id 
    )
when not matched then
    insert (
    season_event.season_id,
    season_event.event_id,
    season_event.circuit_id
    ) values (
    tmp.s_id,
    tmp.e_id,
    tmp.c_id
    );

commit;
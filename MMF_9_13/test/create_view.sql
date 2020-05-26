create view test_view as 
select 
ses.name Season,
to_char(e.e_date, 'mm-dd-yyyy') "Date",
e.name Event,
circ.name Circuit,
d.name Driver,
c.name Constructor,
es.laps Laps,
ed.time Time,
ed.points Points,
ed.start_position Start_driver_place,
pole.name Pole_position,
win.name Winner,
d.wins Driver_Wins,
c.wins Constructor_Wins
from event_driver ed
left join driver d
on d.id = ed.driver_id
left join constructor c
on c.id = ed.constructor_id
left join event e
on e.id = ed.event_id
left join season_event se
on se.event_id = e.id
left join circuit circ
on circ.id = se.circuit_id
left join season ses
on ses.id = se.season_id
left join event_statistic es
on es.event_id = e.id
left join driver pole
on pole.id = es.pole_position_id
left join driver win
on win.id = es.winner_id;
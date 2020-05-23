DEFINE VIEW_NAME = &&1;

CREATE VIEW &&VIEW_NAME AS 
SELECT
SEASON.NAME Season,
EVENT.DATETIME Datetime,
EVENT.NAME Event,
CIRC.NAME Circuit,
DRIVER.NAME Driver,
CONSTRUCTOR.NAME Constructor,
EVENT.LAPS Laps,
ED.TIME Time,
ED.POINTS Points,
ED.START_POSITION Start_driver_place,
POLE.NAME Pole_position,
WINNER.NAME Winner,
DRIVER.WINS Driver_Wins,
CONSTRUCTOR.WINS Constructor_Wins
FROM EVENT_DRIVER ED
LEFT JOIN EVENT
ON ED.EVENT_ID = EVENT.ID
LEFT JOIN DRIVER POLE
ON POLE.ID = EVENT.POLE_POSITION_ID
LEFT JOIN DRIVER WINNER
ON WINNER.ID = EVENT.WINNER_ID
LEFT JOIN DRIVER
ON DRIVER.ID = ED.DRIVER_ID
LEFT JOIN CONSTRUCTOR
ON CONSTRUCTOR.ID = ED.CONSTRUCTOR_ID
LEFT JOIN CIRCUIT CIRC
ON CIRC.ID = EVENT.CIRCUIT_ID
LEFT JOIN SEASON
ON EVENT.SEASON_ID = SEASON.ID;
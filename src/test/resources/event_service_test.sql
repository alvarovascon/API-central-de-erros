delete
from event;

INSERT INTO event (id, description, event_date, level, log, origin)
	VALUES (1, 'description', CURRENT_DATE, 'level', 'log', 'origin');

INSERT INTO event(
	id, description, event_date, level, log, origin)
	VALUES (2, 'description2', CURRENT_DATE, 'level2', 'log2', 'origin2');

INSERT INTO event(
	id, description, event_date, level, log, origin)
	VALUES (3, 'description3', CURRENT_DATE, 'level3', 'log3', 'origin3');

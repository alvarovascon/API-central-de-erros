delete
from event;

INSERT INTO event (id, description, event_date, level, log, origin)
	VALUES (1, 'description', CURRENT_DATE, 'warning', 'log', 'origin');

INSERT INTO event(
	id, description, event_date, level, log, origin)
	VALUES (2, 'description2', CURRENT_DATE, 'warning', 'log2', 'origin2');

INSERT INTO event(
	id, description, event_date, level, log, origin)
	VALUES (3, 'description3', CURRENT_DATE, 'info', 'log3', 'origin3');

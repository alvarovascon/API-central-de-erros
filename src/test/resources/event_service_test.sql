delete
from event;

INSERT INTO event (id, description, event_date, level, log, origin)
	VALUES (1, 'description', parsedatetime('2011-10-02 18:48:05', 'yyyy-MM-dd hh:mm:ss'), 'warning', 'log', 'origin2');

INSERT INTO event(
	id, description, event_date, level, log, origin)
	VALUES (2, 'description2', parsedatetime('2011-10-02 18:48:05', 'yyyy-MM-dd hh:mm:ss'), 'warning', 'log', 'origin');

INSERT INTO event(
	id, description, event_date, level, log, origin)
	VALUES (3, 'description3', parsedatetime('2010-10-02 18:48:05', 'yyyy-MM-dd hh:mm:ss'), 'info', 'log', 'origin');

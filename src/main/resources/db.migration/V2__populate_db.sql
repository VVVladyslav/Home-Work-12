INSERT INTO Client (name) VALUES
('John'),
('Jane'),
('Jim'),
('Joe'),
('Jocker'),
('Jamal'),
('Janister'),
('Jupiter'),
('Jimison'),
('Jared');

INSERT INTO Planet (id, name) VALUES
('MARS', 'Mars'),
('VEN', 'Venus'),
('KIE', 'Kiev'),
('HAM', 'Hamburg'),
('USA', 'UsaDemoctracy');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'MARS', 'VEN'),
(2, 'VEN', 'MARS'),
(3, 'KIE', 'HAM'),
(4, 'HAM', 'USA'),
(5, 'USA', 'MARS'),
(6, 'MARS', 'USA'),
(7, 'USA', 'VEN'),
(8, 'VEN', 'KIE'),
(9, 'KIE', 'MARS'),
(10, 'MARS', 'USA');

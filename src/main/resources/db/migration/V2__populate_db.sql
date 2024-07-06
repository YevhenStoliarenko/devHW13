INSERT INTO spacetravel.client (name)
VALUES ('Bill'),
       ('Rick'),
       ('Tim'),
       ('Tom'),
       ('Laura'),
       ('Bea'),
       ('Michael'),
       ('Patrick'),
       ('Leo'),
       ('Kir');


INSERT INTO spacetravel.planet(id, name)
VALUES
('JPT1','Jupiter'),
('JPT2','Jupiter'),
('MRS','Mars'),
('URN','Uranus'),
('VEN','Venus');


INSERT INTO spacetravel.ticket(created_at, client_id, from_planet_id, to_planet_id)
VALUES
('2024-06-29 12:15:32', 1, 'JPT1', 'VEN'),
('2024-06-29 12:15:00', 1, 'JPT2', 'MRS'),
('2024-06-29 12:15:54', 5, 'JPT2', 'VEN'),
('2024-06-29 13:15:50', 2, 'MRS', 'JPT2'),
('2024-07-01 07:16:00', 3, 'URN', 'JPT2'),
('2023-01-09 07:15:51', 6, 'JPT1', 'VEN'),
('2022-04-19 17:17:04', 7, 'JPT2', 'MRS'),
('2020-12-30 18:19:34', 9, 'JPT1', 'URN'),
('2025-09-28 14:26:38', 4, 'MRS', 'URN'),
('2020-02-12 10:15:32', 1, 'JPT1', 'VEN');




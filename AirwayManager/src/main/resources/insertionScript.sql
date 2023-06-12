-- insert of routes
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA1A2', 1, 2);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA2A1', 2, 1);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA3A4', 3, 4);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA4A5', 4, 5);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA5A3', 5, 3);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA1A4', 1, 4);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA2A5', 2, 5);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA3A2', 3, 2);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA4A3', 4, 3);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RouteA5A1', 5, 1);

-- Intermediate table insert linking airways with routes
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (1, 1);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (2, 2);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (3, 3);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (4, 4);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (5, 5);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (6, 6);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (6, 7);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (7, 8);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (7, 9);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (8, 10);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (8, 11);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (9, 12);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (9, 13);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (10, 14);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (10, 15);

-- Insert of Geographical References of Destinations (Airport) and Air Points (Reference)
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -27.033056, -19.243056, 'R1' );
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -19.033056, -40.243056, 'R2' );
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -30.033056, -50.243056, 'A1' );
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -15.033056, -27.243056, 'A2' );
INSERT INTO ref_geo( latitude, longitude, nome) VALUES (  20.033056,  10.243056, 'A3' );
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -70.033056, -50.243056, 'A4' );
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -42.033056, -12.243056, 'A5' );

-- Insertion of the airways Where the name A indicates Airport and R refers to
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA5A3', 650, 5, 3);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA1R1', 300, 1, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayR1A4', 600, 6, 4);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA1A2', 800, 1, 2);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA2A1', 800, 2, 1);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA3A4', 500, 3, 4);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA4A5', 200, 4, 5);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA2R2', 700, 2, 7);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayR1A3', 150, 6, 3);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA3R1', 200, 3, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayR1A2', 400, 6, 2);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA4R1', 200, 4, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayR2A5', 1000, 7, 5);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayA5R2', 1000, 5, 7);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AirwayR2A1', 860, 7, 1);

-- Insertion of Airway Occupancy slots
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 33000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 34000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 1);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 2);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 28000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 3);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 4);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 5);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 6);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 7);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 8);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 19);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 20);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 21);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 26000, 10);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 26000, 5);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 26000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 27000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 12);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 12);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 13);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 14);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 14);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 22);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 22);

-- Insertion of Flight Plans
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (34000, '2022-10-19', 18, 800, 1);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 12, 200, 8);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 14, 600, 8);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 18, 600, 8);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 22, 850, 8);
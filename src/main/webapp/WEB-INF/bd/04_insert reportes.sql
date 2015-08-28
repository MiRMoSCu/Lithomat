USE lithomat_artiffex;

INSERT INTO fecha_prensista_maquina (id_fecha_prensista_maquina, id_prensista, id_turno_laboral, id_maquina, id_pliego, fecha, id_prensista_ayudante, numero_millar_impreso, numero_cambio_placas, activo) VALUES (1,1,1,1,1,'2013-09-22',1,834,8,true);
INSERT INTO fecha_prensista_maquina (id_fecha_prensista_maquina, id_prensista, id_turno_laboral, id_maquina, id_pliego, fecha, id_prensista_ayudante, numero_millar_impreso, numero_cambio_placas, activo) VALUES (2,1,1,1,2,'2013-09-27',1,5000,10,true);
INSERT INTO fecha_prensista_maquina (id_fecha_prensista_maquina, id_prensista, id_turno_laboral, id_maquina, id_pliego, fecha, id_prensista_ayudante, numero_millar_impreso, numero_cambio_placas, activo) VALUES (3,1,2,1,3,'2013-09-27',1,5000,10,true);
INSERT INTO fecha_prensista_maquina (id_fecha_prensista_maquina, id_prensista, id_turno_laboral, id_maquina, id_pliego, fecha, id_prensista_ayudante, numero_millar_impreso, numero_cambio_placas, activo) VALUES (4,1,1,1,4,'2013-09-28',1,5000,10,true);
INSERT INTO fecha_prensista_maquina (id_fecha_prensista_maquina, id_prensista, id_turno_laboral, id_maquina, id_pliego, fecha, id_prensista_ayudante, numero_millar_impreso, numero_cambio_placas, activo) VALUES (5,1,2,1,5,'2013-09-28',1,1250,10,true);
INSERT INTO fecha_prensista_maquina (id_fecha_prensista_maquina, id_prensista, id_turno_laboral, id_maquina, id_pliego, fecha, id_prensista_ayudante, numero_millar_impreso, numero_cambio_placas, activo) VALUES (6,1,1,1,6,'2013-09-29',1,1250,8,true);




INSERT INTO calendario_orden_produccion (id_calendario_orden_produccion, id_pliego, id_maquina, apuntador_pliego_produccion, siguiente_pliego_realizar, esta_eliminado, activo) VALUES (1,1,1,1,2,false,true);
INSERT INTO calendario_orden_produccion (id_calendario_orden_produccion, id_pliego, id_maquina, apuntador_pliego_produccion, siguiente_pliego_realizar, esta_eliminado, activo) VALUES (2,2,1,NULL,3,false,true);
INSERT INTO calendario_orden_produccion (id_calendario_orden_produccion, id_pliego, id_maquina, apuntador_pliego_produccion, siguiente_pliego_realizar, esta_eliminado, activo) VALUES (3,3,1,NULL,4,false,true);
INSERT INTO calendario_orden_produccion (id_calendario_orden_produccion, id_pliego, id_maquina, apuntador_pliego_produccion, siguiente_pliego_realizar, esta_eliminado, activo) VALUES (4,4,1,NULL,5,false,true);
INSERT INTO calendario_orden_produccion (id_calendario_orden_produccion, id_pliego, id_maquina, apuntador_pliego_produccion, siguiente_pliego_realizar, esta_eliminado, activo) VALUES (5,5,1,NULL,6,false,true);
INSERT INTO calendario_orden_produccion (id_calendario_orden_produccion, id_pliego, id_maquina, apuntador_pliego_produccion, siguiente_pliego_realizar, esta_eliminado, activo) VALUES (6,6,1,NULL,NULL,false,true);




INSERT INTO cobranza (id_cobranza, id_orden_produccion, fecha, pendiente, cargo, abono, saldo, activo) VALUES (1,1,'2013-10-22',true,NULL,100,4900,true);
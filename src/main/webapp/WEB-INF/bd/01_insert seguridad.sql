USE artiffex_lithomat;

INSERT INTO usuario (id_usuario, nombre, ap_paterno, ap_materno, usuario, contrasenia, activo) VALUES (1,'Gerardo','Nieto','López','gnieto','gnieto',true);
INSERT INTO usuario (id_usuario, nombre, ap_paterno, ap_materno, usuario, contrasenia, activo) VALUES (2,'José','Tovar','Ortega','jtovar','jtovar',true);
INSERT INTO usuario (id_usuario, nombre, ap_paterno, ap_materno, usuario, contrasenia, activo) VALUES (3,'Yolanda','Tovar','Ortega','ytovar','ytovaro',true);
INSERT INTO usuario (id_usuario, nombre, ap_paterno, ap_materno, usuario, contrasenia, activo) VALUES (4,'Ivonne','Torres',NULL,'itorres','itorrres10',true);




INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (1,'ROLE_ROOT','Acceso a todo el sistema',true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (2,'ROLE_ADMIN','Tiene acceso a cotizador, produccion y todos los catalogos',true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (3,'ROLE_COTIZADOR','Tiene acceso a cotizador, produccion y algunos catalogos',true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (4,'ROLE_PRODUCCION','Tiene acceso a los procesos de produccion',true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (5,'ROLE_DISEÑO','Tiene acceso al proceso diseño',true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (6,'ROLE_PREPRENSA','Tiene acceso a sus reportes en pdf',true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (7,'ROLE_TRANSPORTE',NULL,true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (8,'ROLE_PROCESO_EXTERNO',NULL,true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (9,'ROLE_ACABADO',NULL,true);
INSERT INTO perfil (id_perfil, nombre, descripcion, activo) VALUES (10,'ROLE_CLIENTE','Tiene acceso a su informacion',true);




INSERT INTO perfil_x_usuario (id_perfil_x_usuario, id_usuario, id_perfil, activo) VALUES (1,1,1,true);
INSERT INTO perfil_x_usuario (id_perfil_x_usuario, id_usuario, id_perfil, activo) VALUES (2,2,1,true);
INSERT INTO perfil_x_usuario (id_perfil_x_usuario, id_usuario, id_perfil, activo) VALUES (3,3,2,true);
INSERT INTO perfil_x_usuario (id_perfil_x_usuario, id_usuario, id_perfil, activo) VALUES (4,4,3,true);
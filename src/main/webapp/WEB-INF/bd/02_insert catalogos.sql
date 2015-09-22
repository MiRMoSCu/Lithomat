USE lithomat_artiffex;

INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (1,4,'CMYK',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (2,3,'CMY',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (3,3,'CMK',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (4,3,'CYK',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (5,3,'MYK',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (6,2,'CM',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (7,2,'CY',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (8,2,'CK',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (9,2,'MY',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (10,2,'MK',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (11,2,'YK',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (12,1,'C',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (13,1,'M',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (14,1,'Y',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (15,1,'K',true);
INSERT INTO combinacion_tintas (id_combinacion_tintas, num_tintas, descripcion, activo) VALUES (16,0,'-',true);




INSERT INTO tamanio_publicacion (id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez, activo) VALUES (1,'No aplica','-',0,0,0,true);
INSERT INTO tamanio_publicacion (id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez, activo) VALUES (2,'8 cartas - 8 oficios','1',2,1,0,true);
INSERT INTO tamanio_publicacion (id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez, activo) VALUES (3,'4 cartas - 4 oficios','1/2',4,0.5,1,true);
INSERT INTO tamanio_publicacion (id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez, activo) VALUES (4,'Doble carta - Doble oficio','1/4',8,0.25,2,true);
INSERT INTO tamanio_publicacion (id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez, activo) VALUES (5,'Carta - Oficio','1/8',16,0.125,3,true);
INSERT INTO tamanio_publicacion (id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez, activo) VALUES (6,'Media carta - Medio oficio','1/16',32,0.0625,4,true);
INSERT INTO tamanio_publicacion (id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez, activo) VALUES (7,'Cuarto de carta - Cuarto de oficio','1/32',64,0.03125,5,true);




INSERT INTO tipo_precio (id_tipo_precio, nombre, descripcion, factor_divisor, activo) VALUES (1,'No aplica','No aplica',1,true);
INSERT INTO tipo_precio (id_tipo_precio, nombre, descripcion, factor_divisor, activo) VALUES (2,'Unidad','Precio de una sola unidad',1,true);
INSERT INTO tipo_precio (id_tipo_precio, nombre, descripcion, factor_divisor, activo) VALUES (3,'Ciento','Precio por ciento',100,true);
INSERT INTO tipo_precio (id_tipo_precio, nombre, descripcion, factor_divisor, activo) VALUES (4,'Millar','Precio por millares',1000,true);
INSERT INTO tipo_precio (id_tipo_precio, nombre, descripcion, factor_divisor, activo) VALUES (5,'Hora','Precio por hora',60,true);
INSERT INTO tipo_precio (id_tipo_precio, nombre, descripcion, factor_divisor, activo) VALUES (6,'Porcentaje','Precio por porcentaje',100,true);
INSERT INTO tipo_precio (id_tipo_precio, nombre, descripcion, factor_divisor, activo) VALUES (7,'Centímetro cuadrado','Precio por centímetro cuadrado',1,true);




INSERT INTO tinta_especial (id_tinta_especial, precio, id_tipo_precio, activo) VALUES (1,100,6,true);




INSERT INTO costo_extra (id_costo_extra, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (1,'Tiempo extra máquina',NULL,30,5,true);
INSERT INTO costo_extra (id_costo_extra, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (2,'Cartulina sulfatada',NULL,15,6,true);
INSERT INTO costo_extra (id_costo_extra, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (3,'Sustratos especiales',NULL,100,6,true);
INSERT INTO costo_extra (id_costo_extra, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (4,'Suspensión de trabajos',NULL,1000,5,true);
INSERT INTO costo_extra (id_costo_extra, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (5,'Tiempo muerto',NULL,700,5,true);
INSERT INTO costo_extra (id_costo_extra, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (6,'Bajada de corte',NULL,3,3,true);





INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (1,'Cotizacion',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (2,'En espera',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (3,'Cancelado',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (4,'Disenio',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (5,'Preprensa',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (6,'Transporte',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (7,'Offset',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (8,'Acabado',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (9,'Proceso externo',NULL,true);
INSERT INTO estatus_orden (id_estatus_orden, nombre, descripcion, activo) VALUES (10,'Finalizado',NULL,true);




INSERT INTO maquina (id_maquina, nombre, descripcion, num_colores, ancho_placa, alto_placa, ancho_max_papel, alto_max_papel, ancho_min_papel, alto_min_papel, activo) VALUES (1,'Heidelberg Speed Master 6',NULL,6,102,72,102,72,47.5,35,true);
INSERT INTO maquina (id_maquina, nombre, descripcion, num_colores, ancho_placa, alto_placa, ancho_max_papel, alto_max_papel, ancho_min_papel, alto_min_papel, activo) VALUES (2,'Komori',NULL,4,102,72,102,72,47.5,35,true);
INSERT INTO maquina (id_maquina, nombre, descripcion, num_colores, ancho_placa, alto_placa, ancho_max_papel, alto_max_papel, ancho_min_papel, alto_min_papel, activo) VALUES (3,'Heidelberg Speed Master 2',NULL,6,102,72,102,72,47.5,35,true);




INSERT INTO responsable_insumo (id_responsable_insumo, nombre, descripcion, activo) VALUES (1,'Cliente',NULL,true);
INSERT INTO responsable_insumo (id_responsable_insumo, nombre, descripcion, activo) VALUES (2,'Lithomat',NULL,true);
INSERT INTO responsable_insumo (id_responsable_insumo, nombre, descripcion, activo) VALUES (3,'Otro',NULL,true);




INSERT INTO material_ayuda (id_material_ayuda, nombre, descripcion, activo) VALUES (1,'Dummy',NULL,true);
INSERT INTO material_ayuda (id_material_ayuda, nombre, descripcion, activo) VALUES (2,'Match print',NULL,true);
INSERT INTO material_ayuda (id_material_ayuda, nombre, descripcion, activo) VALUES (3,'Prueba de color',NULL,true);
INSERT INTO material_ayuda (id_material_ayuda, nombre, descripcion, activo) VALUES (4,'Archivo electrónico',NULL,true);
INSERT INTO material_ayuda (id_material_ayuda, nombre, descripcion, activo) VALUES (5,'Negativos',NULL,true);




INSERT INTO prensista (id_prensista, nombre, ap_paterno, ap_materno, activo) VALUES (1,'Ruben','Hernández','Lopez',true);




INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (1,'Tipografia',NULL,0,1,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (2,'Diseño nuevo',NULL,250,5,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (3,'Rediseño',NULL,250,5,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (4,'Revisión de archivo',NULL,0,1,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (5,'Original mecánico',NULL,10,2,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (6,'Dummy',NULL,15,2,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (7,'Correcciones',NULL,250,5,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (8,'Escaneo',NULL,250,5,true);
INSERT INTO proceso_disenio (id_proceso_disenio, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (9,'Retoque de imagen',NULL,250,5,true);




INSERT INTO proceso_preprensa (id_proceso_preprensa, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (1,'Salida positivo tamaño carta',NULL,25,2,true);
INSERT INTO proceso_preprensa (id_proceso_preprensa, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (2,'Salida negativo placa',NULL,140,2,true);




INSERT INTO proveedor_externo (id_proveedor_externo, razon_social, calle, num_exterior, num_interior, colonia, delegacion_municipio, estado, codigo_postal, pais, telefono, observaciones, activo) VALUES (1,'Lithomat','5 de febrero','494-B',NULL,'Algarín',NULL,'D.F.','06880','México',NULL,NULL,true);
INSERT INTO proveedor_externo (id_proveedor_externo, razon_social, calle, num_exterior, num_interior, colonia, delegacion_municipio, estado, codigo_postal, pais, telefono, observaciones, activo) VALUES (2,'Empresa ABC','Emiliano Zapata',189,NULL,'Narvarte','Venustiano Carrenza','D.F.','55089','México','58963478',NULL,true);




INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (1,1,'Corte',NULL,3,2,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (2,2,'Doblez',NULL,40,4,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (3,2,'UV',NULL,0.9,7,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (4,2,'Alce',NULL,40,4,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (5,2,'Plastificado',NULL,3.9,7,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (6,2,'Engrapado',NULL,100,4,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (7,2,'Pegado',NULL,50,4,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (8,2,'Suaje',NULL,4,7,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (9,2,'Suajado',NULL,250,4,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (10,2,'Hot-melt',NULL,250,4,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (11,2,'Caballo a grapa',NULL,100,4,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (12,2,'Empacado en papel',NULL,10,2,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (13,2,'Empacado en cajas',NULL,15,2,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (14,2,'Envío foráneo aéreo',NULL,0,1,true);
INSERT INTO proceso_externo (id_proceso_externo, id_proveedor_externo, nombre_proceso, observaciones, precio, id_tipo_precio, activo) VALUES (15,2,'Envío foráneo terrestre',NULL,300,2,true);




INSERT INTO proceso_transporte (id_proceso_transporte, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (1,'Revisión de negativos',NULL,0,1,true);
INSERT INTO proceso_transporte (id_proceso_transporte, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (2,'Revisión de láminas',NULL,0,1,true);
INSERT INTO proceso_transporte (id_proceso_transporte, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (3,'Elaboración de láminas',NULL,0,1,true);
INSERT INTO proceso_transporte (id_proceso_transporte, nombre_proceso, descripcion, precio, id_tipo_precio, activo) VALUES (4,'Revisar papel para pinza',NULL,0,1,true);




INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (1,1,'Millar impresión por color',NULL,1,1000,300,300,300,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (2,1,'Millar impresión por color',NULL,1001,2000,250,250,250,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (3,1,'Millar impresión por color',NULL,2001,3000,220,220,220,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (4,1,'Millar impresión por color',NULL,3001,4000,180,180,180,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (5,1,'Millar impresión por color',NULL,4001,5000,160,160,160,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (6,1,'Millar impresión por color',NULL,5001,6000,155,155,155,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (7,1,'Millar impresión por color',NULL,6001,7000,150,150,150,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (8,1,'Millar impresión por color',NULL,7001,8000,140,140,140,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (9,1,'Millar impresión por color',NULL,8001,9000,130,130,130,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (10,1,'Millar impresión por color',NULL,9001,10000,115,115,115,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (11,1,'Millar impresión por color',NULL,10001,19000,110,110,110,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (12,1,'Millar impresión por color',NULL,19001,39000,100,100,100,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (13,1,'Millar impresión por color',NULL,39001,49000,90,90,90,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (14,1,'Millar impresión por color',NULL,49001,1000000,85,85,85,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (15,2,'Millar impresión por color',NULL,1,1000,200,200,200,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (16,2,'Millar impresión por color',NULL,1001,2000,180,180,180,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (17,2,'Millar impresión por color',NULL,2001,3000,150,150,150,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (18,2,'Millar impresión por color',NULL,3001,4000,120,120,120,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (19,2,'Millar impresión por color',NULL,4001,5000,110,110,110,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (20,2,'Millar impresión por color',NULL,5001,9000,100,100,100,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (21,2,'Millar impresión por color',NULL,9001,15000,80,80,80,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (22,2,'Millar impresión por color',NULL,15001,19000,75,75,75,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (23,2,'Millar impresión por color',NULL,19001,39000,70,70,70,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (24,2,'Millar impresión por color',NULL,39001,49000,65,65,65,4,true);
INSERT INTO tabulador_precios (id_tabulador_precios, id_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla,  precio_complejidad_regular, precio_complejidad_dificil, id_tipo_precio, activo) VALUES (25,2,'Millar impresión por color',NULL,49001,1000000,60,60,60,4,true);




INSERT INTO tipo_barniz (id_tipo_barniz, descripcion, num_entradas_maquina, num_placas, precio, id_tipo_precio, activo) VALUES (1,'Sin barniz',0,0,0,1,true);
INSERT INTO tipo_barniz (id_tipo_barniz, descripcion, num_entradas_maquina, num_placas, precio, id_tipo_precio, activo) VALUES (2,'Barniz maquina mate',1,0,50,6,true);
INSERT INTO tipo_barniz (id_tipo_barniz, descripcion, num_entradas_maquina, num_placas, precio, id_tipo_precio, activo) VALUES (3,'Barniz maquina brillante',1,0,50,6,true);
INSERT INTO tipo_barniz (id_tipo_barniz, descripcion, num_entradas_maquina, num_placas, precio, id_tipo_precio, activo) VALUES (4,'Barniz registro mate',1,1,50,6,true);
INSERT INTO tipo_barniz (id_tipo_barniz, descripcion, num_entradas_maquina, num_placas, precio, id_tipo_precio, activo) VALUES (5,'Barniz registro brillante',1,1,50,6,true);




INSERT INTO tipo_cliente (id_tipo_cliente, clave, descripcion, precio, id_tipo_precio, activo) VALUES (1,'M','Maquilador',0,6,true);
INSERT INTO tipo_cliente (id_tipo_cliente, clave, descripcion, precio, id_tipo_precio, activo) VALUES (2,'ME','Maquilador con extras',12,6,true);
INSERT INTO tipo_cliente (id_tipo_cliente, clave, descripcion, precio, id_tipo_precio, activo) VALUES (3,'D','Diseñador',15,6,true);
INSERT INTO tipo_cliente (id_tipo_cliente, clave, descripcion, precio, id_tipo_precio, activo) VALUES (4,'CDCO','Cliente directo contado con anticipo IP',20,6,true);
INSERT INTO tipo_cliente (id_tipo_cliente, clave, descripcion, precio, id_tipo_precio, activo) VALUES (5,'CDCR','Cliente directo crédito IP',30,6,true);
INSERT INTO tipo_cliente (id_tipo_cliente, clave, descripcion, precio, id_tipo_precio, activo) VALUES (6,'G','Cliente directo gobierno',38,6,true);
INSERT INTO tipo_cliente (id_tipo_cliente, clave, descripcion, precio, id_tipo_precio, activo) VALUES (7,'GE','Cliente directo gobierno especial',48,6,true);




INSERT INTO tipo_complejidad (id_tipo_complejidad, nombre, descripcion, activo) VALUES (1,'Sencilla','La tinta que se aplica es poca',true);
INSERT INTO tipo_complejidad (id_tipo_complejidad, nombre, descripcion, activo) VALUES (2,'Regular','La tinta que se aplica es regular',true);
INSERT INTO tipo_complejidad (id_tipo_complejidad, nombre, descripcion, activo) VALUES (3,'Difícil','La tinta que se aplica es bastante',true);




INSERT INTO tipo_comprobante_fiscal (id_tipo_comprobante_fiscal, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (1,'Nota de Remisión',NULL,0,1,true);
INSERT INTO tipo_comprobante_fiscal (id_tipo_comprobante_fiscal, nombre, descripcion, precio, id_tipo_precio, activo) VALUES (2,'Nota de Factura',NULL,16,6,true);




INSERT INTO proveedor_papel (id_proveedor_papel, razon_social, calle, num_exterior, num_interior, colonia, delegacion_municipio, estado, codigo_postal, pais, telefono, email, observaciones, activo) VALUES (1,'Papelera progreso','5 de Febrero',34,NULL,'Algarín','Gustavo A. Madero','D.F.','65779','México',NULL,'aaa@aaa.com',NULL,true);




INSERT INTO tipo_forma_trabajo (id_tipo_forma_trabajo, nombre, descripcion, activo) VALUES (1,'No aplica','No importa formacion',true);
INSERT INTO tipo_forma_trabajo (id_tipo_forma_trabajo, nombre, descripcion, activo) VALUES (2,'Montado a caballo con grapa','Publicación de hasta 52 paginas, por grapa',true);
INSERT INTO tipo_forma_trabajo (id_tipo_forma_trabajo, nombre, descripcion, activo) VALUES (3,'Hotmealt','Publicación de màs de 52 páginas',true);
INSERT INTO tipo_forma_trabajo (id_tipo_forma_trabajo, nombre, descripcion, activo) VALUES (4,'Formacion Z','Sirve para aprovechar el papel, son 12 páginas',true);




INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (1,1,'Unibond Blanco',75,37,57,87,NULL,1205,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (2,1,'Unibond Blanco',90,44.5,57,87,NULL,1469,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (3,1,'Unibond Blanco',105,52,57,87,NULL,1779,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (4,1,'Unibond Blanco',120,59.5,57,87,NULL,2052,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (5,1,'Unibond Blanco',75,41,61,90,NULL,1338,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (6,1,'Unibond Blanco',90,49.5,61,90,NULL,1601,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (7,1,'Unibond Blanco',105,57.6,61,90,NULL,1970,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (8,1,'Unibond Blanco',120,66,61,90,NULL,2276,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (9,1,'Unibond Blanco',75,50,70,95,NULL,1631,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (10,1,'Unibond Blanco',90,60,70,95,NULL,1958,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (11,1,'Unibond Blanco',105,70,70,95,NULL,2397,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (12,1,'Unibond Blanco',120,80,70,95,NULL,2741,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (13,1,'Unibond Marfil',75,37,57,87,NULL,1458,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (14,1,'Unibond Marfil',90,44.5,57,87,NULL,1772,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (15,1,'Unibond Marfil',75,50,70,95,NULL,1970,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (16,1,'Unibond Marfil',90,60,70,95,NULL,2363,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (17,1,'Couché Brillante/Mate',90,44.5,57,87,NULL,1445,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (18,1,'Couché Brillante/Mate',100,49.5,57,87,NULL,1560,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (19,1,'Couché Brillante/Mate',115,57,57,87,NULL,1793,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (20,1,'Couché Brillante/Mate',130,64.5,57,87,NULL,2025,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (21,1,'Couché Brillante/Mate',150,76.5,58,88,NULL,2406,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (22,1,'Couché Brillante/Mate',200,102,58,88,NULL,3209,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (23,1,'Couché Brillante/Mate',250,130,58,88,NULL,4096,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (24,1,'Couché Brillante/Mate',300,153,58,88,NULL,4915,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (25,1,'Couché Brillante/Mate',90,49.5,61,90,NULL,1599,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (26,1,'Couché Brillante/Mate',100,55,61,90,NULL,1726,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (27,1,'Couché Brillante/Mate',115,63,61,90,NULL,1986,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (28,1,'Couché Brillante/Mate',130,71.4,61,90,NULL,2245,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (29,1,'Couché Brillante/Mate',150,82.5,61,90,NULL,2589,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (30,1,'Couché Brillante/Mate',200,110,61,90,NULL,3452,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (31,1,'Couché Brillante/Mate',250,140,61,90,NULL,4405,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (32,1,'Couché Brillante/Mate',300,165,61,90,NULL,5287,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (33,1,'Couché Brillante/Mate',90,60,70,95,NULL,1940,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (34,1,'Couché Brillante/Mate',100,66.5,70,95,NULL,2091,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (35,1,'Couché Brillante/Mate',115,76.5,70,95,NULL,2404,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (36,1,'Couché Brillante/Mate',130,86.5,70,95,NULL,2718,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (37,1,'Couché Brillante/Mate',150,100,70,95,NULL,3137,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (38,1,'Couché Brillante/Mate',200,133,70,95,NULL,4183,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (39,1,'Couché Brillante/Mate',250,169.5,70,95,NULL,5336,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (40,1,'Couché Brillante/Mate',300,199,70,95,NULL,6406,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (41,1,'Couché Brillante/Mate',100,73,72,102,NULL,2309,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (42,1,'Couché Brillante/Mate',115,84.5,72,102,NULL,2656,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (43,1,'Couché Brillante/Mate',130,95.5,72,102,NULL,3004,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (44,1,'Couché Brillante/Mate',150,110,72,102,NULL,3464,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (45,1,'Couché Brillante/Mate',200,147,72,102,NULL,4619,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (46,1,'Couché Brillante/Mate',250,184,72,102,NULL,5893,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (47,1,'Sulfadata 1/cara',10,0,58,88,NULL,4542,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (48,1,'Sulfadata 1/cara',10,0,61,90,NULL,4808,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (49,1,'Sulfadata 1/cara',10,0,70,95,NULL,5922,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (50,1,'Sulfadata 1/cara',10,0,71,125,NULL,7903,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (51,1,'Sulfadata 1/cara',10,0,90,125,NULL,10020,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (52,1,'Sulfadata 1/cara',12,0,58,88,NULL,4983,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (53,1,'Sulfadata 1/cara',12,0,61,90,NULL,5274,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (54,1,'Sulfadata 1/cara',12,0,70,95,NULL,6495,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (55,1,'Sulfadata 1/cara',12,0,71,125,NULL,8667,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (56,1,'Sulfadata 1/cara',12,0,90,125,NULL,10986,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (57,1,'Sulfadata 1/cara',14,0,58,88,NULL,5478,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (58,1,'Sulfadata 1/cara',14,0,61,90,NULL,5797,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (59,1,'Sulfadata 1/cara',14,0,70,95,NULL,7138,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (60,1,'Sulfadata 1/cara',14,0,71,125,NULL,9528,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (61,1,'Sulfadata 1/cara',14,0,90,125,NULL,12076,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (62,1,'Sulfadata 1/cara',16,0,58,88,NULL,6138,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (63,1,'Sulfadata 1/cara',16,0,61,90,NULL,6495,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (64,1,'Sulfadata 1/cara',16,0,70,95,NULL,7998,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (65,1,'Sulfadata 1/cara',16,0,71,125,NULL,10673,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (66,1,'Sulfadata 1/cara',16,0,90,125,NULL,13529,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (67,1,'Sulfadata 2/cara',10,0,58,88,NULL,5116,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (68,1,'Sulfadata 2/cara',10,0,61,90,NULL,5685,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (69,1,'Sulfadata 2/cara',10,0,70,95,NULL,6899,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (70,1,'Sulfadata 2/cara',10,0,71,125,NULL,8802,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (71,1,'Sulfadata 2/cara',10,0,90,125,NULL,11157,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (72,1,'Sulfadata 2/cara',12,0,58,88,NULL,5677,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (73,1,'Sulfadata 2/cara',12,0,61,90,NULL,6100,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (74,1,'Sulfadata 2/cara',12,0,70,95,NULL,7389,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (75,1,'Sulfadata 2/cara',12,0,71,125,NULL,9874,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (76,1,'Sulfadata 2/cara',12,0,90,125,NULL,12511,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (77,1,'Sulfadata 2/cara',14,0,58,88,NULL,6450,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (78,1,'Sulfadata 2/cara',14,0,61,90,NULL,6937,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (79,1,'Sulfadata 2/cara',14,0,70,95,NULL,8395,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (80,1,'Sulfadata 2/cara',14,0,71,125,NULL,11214,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (81,1,'Sulfadata 2/cara',14,0,90,125,NULL,14214,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (82,1,'Sulfadata 2/cara',16,0,58,88,NULL,6500,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (83,1,'Sulfadata 2/cara',16,0,61,90,NULL,7467,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (84,1,'Sulfadata 2/cara',16,0,70,95,NULL,9050,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (85,1,'Sulfadata 2/cara',16,0,71,125,NULL,11836,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (86,1,'Sulfadata 2/cara',16,0,90,125,NULL,15315,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (87,1,'Opalina blanca',125,62,57,87,NULL,3489,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (88,1,'Opalina blanca',125,83,70,95,NULL,4672,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (89,1,'Opalina blanca',225,92,57,72,NULL,5178,4,true);
INSERT INTO tipo_papel_extendido (id_tipo_papel_extendido, id_proveedor_papel, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, id_tipo_precio, activo) VALUES (90,1,'Opalina blanca',225,112,57,87,NULL,6304,4,true);




INSERT INTO tipo_placa (id_tipo_placa, id_maquina, descripcion, precio, id_tipo_precio, activo) VALUES (1,1,'Placa CTP',280,2,true);
INSERT INTO tipo_placa (id_tipo_placa, id_maquina, descripcion, precio, id_tipo_precio, activo) VALUES (2,1,'Lámina presensibilizada',140,2,true);
INSERT INTO tipo_placa (id_tipo_placa, id_maquina, descripcion, precio, id_tipo_precio, activo) VALUES (3,2,'Placa CTP',115,2,true);
INSERT INTO tipo_placa (id_tipo_placa, id_maquina, descripcion, precio, id_tipo_precio, activo) VALUES (4,2,'Lámina presensibilizada',80,2,true);
INSERT INTO tipo_placa (id_tipo_placa, id_maquina, descripcion, precio, id_tipo_precio, activo) VALUES (5,3,'Placa CTP',105,2,true);
INSERT INTO tipo_placa (id_tipo_placa, id_maquina, descripcion, precio, id_tipo_precio, activo) VALUES (6,3,'Lámina presensibilizada',70,2,true);




INSERT INTO tipo_trabajo (id_tipo_trabajo, nombre, activo) VALUES (1,'Flyer/Póster',true);
INSERT INTO tipo_trabajo (id_tipo_trabajo, nombre, activo) VALUES (2,'Publicación/Revista/Libro',true);
INSERT INTO tipo_trabajo (id_tipo_trabajo, nombre, activo) VALUES (3,'Otro',true);




INSERT INTO tipo_vuelta (id_tipo_vuelta, nombre, descripcion, activo) VALUES (1,'No aplica','no aplica, láminas diferentes',true);
INSERT INTO tipo_vuelta (id_tipo_vuelta, nombre, descripcion, activo) VALUES (2,'Normal','eje de simetría es vertical, a lo alto',true);
INSERT INTO tipo_vuelta (id_tipo_vuelta, nombre, descripcion, activo) VALUES (3,'Campana','eje de simetría es horizontal, a lo ancho',true);




INSERT INTO turno_laboral (id_turno_laboral, descripcion, hora_inicio, hora_fin, activo) VALUES (1,'Matutino','06:00','14:00',true);
INSERT INTO turno_laboral (id_turno_laboral, descripcion, hora_inicio, hora_fin, activo) VALUES (2,'Vespertino','14:00','22:00',true);
INSERT INTO turno_laboral (id_turno_laboral, descripcion, hora_inicio, hora_fin, activo) VALUES (3,'Nocturno','22:00','06:00',true);




INSERT INTO parametros_config (id_parametros_config, nombre, descripcion, filler_varchar_1, filler_varchar_2, filler_int_1, filler_int_2, filler_numeric_1, filler_numeric_2, filler_bool_1, filler_bool_2, id_tipo_precio, activo) VALUES (1,'Qwerty','Ejemplo de qwerty',NULL,NULL,16,NULL,NULL,NULL,NULL,NULL,5,true);




INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (1,0,1000,1,0,false,100,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (2,0,1000,1,1,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (3,0,1000,4,0,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (4,0,1000,4,4,false,250,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (5,0,1000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (6,0,1000,1,1,true,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (7,0,1000,4,0,true,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (8,0,1000,4,4,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (9,1001,2000,1,0,false,100,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (10,1001,2000,1,1,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (11,1001,2000,4,0,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (12,1001,2000,4,4,false,250,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (13,1001,2000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (14,1001,2000,1,1,true,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (15,1001,2000,4,0,true,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (16,1001,2000,4,4,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (17,2001,3000,1,0,false,100,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (18,2001,3000,1,1,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (19,2001,3000,4,0,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (20,2001,3000,4,4,false,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (21,2001,3000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (22,2001,3000,1,1,true,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (23,2001,3000,4,0,true,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (24,2001,3000,4,4,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (25,3001,4000,1,0,false,100,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (26,3001,4000,1,1,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (27,3001,4000,4,0,false,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (28,3001,4000,4,4,false,350,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (29,3001,4000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (30,3001,4000,1,1,true,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (31,3001,4000,4,0,true,450,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (32,3001,4000,4,4,true,600,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (33,4001,5000,1,0,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (34,4001,5000,1,1,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (35,4001,5000,4,0,false,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (36,4001,5000,4,4,false,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (37,4001,5000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (38,4001,5000,1,1,true,350,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (39,4001,5000,4,0,true,450,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (40,4001,5000,4,4,true,600,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (41,5001,6000,1,0,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (42,5001,6000,1,1,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (43,5001,6000,4,0,false,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (44,5001,6000,4,4,false,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (45,5001,6000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (46,5001,6000,1,1,true,350,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (47,5001,6000,4,0,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (48,5001,6000,4,4,true,700,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (49,6001,7000,1,0,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (50,6001,7000,1,1,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (51,6001,7000,4,0,false,350,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (52,6001,7000,4,4,false,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (53,6001,7000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (54,6001,7000,1,1,true,350,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (55,6001,7000,4,0,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (56,6001,7000,4,4,true,700,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (57,7001,8000,1,0,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (58,7001,8000,1,1,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (59,7001,8000,4,0,false,350,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (60,7001,8000,4,4,false,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (61,7001,8000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (62,7001,8000,1,1,true,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (63,7001,8000,4,0,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (64,7001,8000,4,4,true,800,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (65,8001,9000,1,0,false,150,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (66,8001,9000,1,1,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (67,8001,9000,4,0,false,350,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (68,8001,9000,4,4,false,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (69,8001,9000,1,0,true,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (70,8001,9000,1,1,true,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (71,8001,9000,4,0,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (72,8001,9000,4,4,true,800,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (73,9001,10000,1,0,false,200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (74,9001,10000,1,1,false,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (75,9001,10000,4,0,false,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (76,9001,10000,4,4,false,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (77,9001,10000,1,0,true,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (78,9001,10000,1,1,true,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (79,9001,10000,4,0,true,700,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (80,9001,10000,4,4,true,800,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (81,10001,20000,1,0,false,300,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (82,10001,20000,1,1,false,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (83,10001,20000,4,0,false,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (84,10001,20000,4,4,false,800,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (85,10001,20000,1,0,true,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (86,10001,20000,1,1,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (87,10001,20000,4,0,true,1000,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (88,10001,20000,4,4,true,1500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (89,20001,30000,1,0,false,400,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (90,20001,30000,1,1,false,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (91,20001,30000,4,0,false,1000,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (92,20001,30000,4,4,false,1500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (93,20001,30000,1,0,true,500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (94,20001,30000,1,1,true,600,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (95,20001,30000,4,0,true,1000,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (96,20001,30000,4,4,true,1500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (97,30001,50000,1,0,false,5000,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (98,30001,50000,1,1,false,1000,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (99,30001,50000,4,0,false,1200,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (100,30001,50000,4,4,false,1500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (101,30001,50000,1,0,true,600,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (102,30001,50000,1,1,true,700,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (103,30001,50000,4,0,true,1500,true);
INSERT INTO papel_sobrante (id_papel_sobrante, inicio_tabulador, fin_tabulador, frente_num_tinta, vuelta_num_tinta, tinta_especial, hojas_sobrante, activo) VALUES (104,30001,50000,4,4,true,2000,true);
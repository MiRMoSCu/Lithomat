USE lithomat_artiffex;

INSERT INTO cliente (id_cliente, id_tipo_cliente, nombre_moral, nombre_representante, puesto, calle, num_exterior, num_interior, colonia, delegacion_municipio, estado, codigo_postal, pais, rfc, telefono_particular, telefono_movil, email, observaciones, activo) VALUES (1,1,'Maquila',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',NULL,true);
INSERT INTO cliente (id_cliente, id_tipo_cliente, nombre_moral, nombre_representante, puesto, calle, num_exterior, num_interior, colonia, delegacion_municipio, estado, codigo_postal, pais, rfc, telefono_particular, telefono_movil, email, observaciones, activo) VALUES (2,2,'Editores Buena Onda S.A. De C.V.','Eduardo Ruíz Noriega','Director','Suiza',14,NULL,'Portales Oriente','Benito Juárez','Distrito Federal','03570','México','EBO981030HL7','55320880','0445555087783','aaa@aaa.com',NULL,true);




INSERT INTO orden_produccion (id_orden_produccion, id_usuario, id_cliente, id_tipo_comprobante_fiscal, nut, nombre, descripcion, fecha_cotizacion, fecha_prometida_entrega, fecha_inicio, fecha_fin, fecha_entrega, fecha_generacion, activo) VALUES (1,3,1,1,'201400100019','Orden de produccion','Orden de produccion','2013-09-19','2013-09-19',NULL,NULL,NULL,'2013-09-19 03:14:07',true);




INSERT INTO historial_estatus (id_historial_estatus, id_orden_produccion, id_estatus_orden, fecha, observaciones, activo) VALUES (1,1,1,'2013-09-19',NULL,true);




INSERT INTO partida (id_partida, id_orden_produccion, id_tipo_trabajo, nombre_partida, id_tipo_forma_trabajo, cantidad, descripcion_partida, diagrama_formacion, observaciones_generales, observaciones_aprobacion, fecha_generacion, activo) VALUES (1,1,1,'Partida flyer',1,10000,'Flyer monster high',NULL,NULL,'Necesita VoBo','2013-09-19 03:15:17',true);
INSERT INTO partida (id_partida, id_orden_produccion, id_tipo_trabajo, nombre_partida, id_tipo_forma_trabajo, cantidad, descripcion_partida, diagrama_formacion, observaciones_generales, observaciones_aprobacion, fecha_generacion, activo) VALUES (2,1,2,'Partida publicacion',3,5000,'Libro El Chapopote',NULL,NULL,'Necesita rúbrica de aprobación','2013-09-19 03:21:17',true);




INSERT INTO tipo_trabajo_detalle (id_tipo_trabajo_detalle, id_partida, descripcion, ancho, alto, ancho_extendido, alto_extendido, cliente_proporciona_papel, cliente_proporciona_tinta, cliente_proporciona_tinta_especial, cliente_proporciona_barniz, cliente_proporciona_placas, id_tipo_papel_extendido, repeticiones_x_pliego, numero_paginas_publicacion, id_tamanio_publicacion, frente_id_combinacion_tintas, frente_num_tinta_especial, frente_descripcion_tinta_especial, frente_id_tipo_barniz, vuelta_id_combinacion_tintas, vuelta_num_tinta_especial, vuelta_descripcion_tinta_especial, vuelta_id_tipo_barniz, id_maquina, id_tipo_placa, id_tipo_complejidad, observaciones, fecha_generacion, activo) VALUES (1,1,'Flyer monster high',20,15,NULL,NULL,true,false,false,false,false,6,12,NULL,1,1,0,NULL,1,2,0,NULL,1,1,2,1,'Ninguna','2013-09-19 03:16:17',true);
INSERT INTO tipo_trabajo_detalle (id_tipo_trabajo_detalle, id_partida, descripcion, ancho, alto, ancho_extendido, alto_extendido, cliente_proporciona_papel, cliente_proporciona_tinta, cliente_proporciona_tinta_especial, cliente_proporciona_barniz, cliente_proporciona_placas, id_tipo_papel_extendido, repeticiones_x_pliego, numero_paginas_publicacion, id_tamanio_publicacion, frente_id_combinacion_tintas, frente_num_tinta_especial, frente_descripcion_tinta_especial, frente_id_tipo_barniz, vuelta_id_combinacion_tintas, vuelta_num_tinta_especial, vuelta_descripcion_tinta_especial, vuelta_id_tipo_barniz, id_maquina, id_tipo_placa, id_tipo_complejidad, observaciones, fecha_generacion, activo) VALUES (2,2,'Contenido interior revista',20,15,20,30,false,false,false,false,false,1,NULL,52,5,1,1,'Dorada',1,1,1,'Dorada',1,1,2,1,'Ninguna','2013-09-19 03:22:17',true);
INSERT INTO tipo_trabajo_detalle (id_tipo_trabajo_detalle, id_partida, descripcion, ancho, alto, ancho_extendido, alto_extendido, cliente_proporciona_papel, cliente_proporciona_tinta, cliente_proporciona_tinta_especial, cliente_proporciona_barniz, cliente_proporciona_placas, id_tipo_papel_extendido, repeticiones_x_pliego, numero_paginas_publicacion, id_tamanio_publicacion, frente_id_combinacion_tintas, frente_num_tinta_especial, frente_descripcion_tinta_especial, frente_id_tipo_barniz, vuelta_id_combinacion_tintas, vuelta_num_tinta_especial, vuelta_descripcion_tinta_especial, vuelta_id_tipo_barniz, id_maquina, id_tipo_placa, id_tipo_complejidad, observaciones, fecha_generacion, activo) VALUES (3,2,'Portada revista',20,15,20,30,false,false,false,false,false,9,NULL,4,5,1,0,NULL,2,4,0,NULL,2,1,2,1,'Ninguna','2013-09-19 03:23:17',true);




INSERT INTO pliego (id_pliego, id_tipo_trabajo_detalle, rebase_en_milimetros, medianiles_en_milimetros, pinzas_en_centimetros, observaciones, numero_decimal, hojas_requeridas, hojas_sobrantes, hojas_totales, frente_num_entradas_maquina_tinta, frente_num_entradas_maquina_tinta_especial, frente_num_entradas_maquina_barniz, frente_num_total_placas, vuelta_num_entradas_maquina_tinta, vuelta_num_entradas_maquina_tinta_especial, vuelta_num_entradas_maquina_barniz, vuelta_mismas_placas, vuelta_num_total_placas, id_tipo_vuelta, activo) VALUES (1,1,5,5,1,'Ninguna',1,834,250,1084,4,0,0,4,3,0,0,false,3,1,true);
INSERT INTO pliego (id_pliego, id_tipo_trabajo_detalle, rebase_en_milimetros, medianiles_en_milimetros, pinzas_en_centimetros, observaciones, numero_decimal, hojas_requeridas, hojas_sobrantes, hojas_totales, frente_num_entradas_maquina_tinta, frente_num_entradas_maquina_tinta_especial, frente_num_entradas_maquina_barniz, frente_num_total_placas, vuelta_num_entradas_maquina_tinta, vuelta_num_entradas_maquina_tinta_especial, vuelta_num_entradas_maquina_barniz, vuelta_mismas_placas, vuelta_num_total_placas, id_tipo_vuelta, activo) VALUES (2,2,5,5,1,'pàgina 1-16',1,5000,600,5600,4,1,0,5,4,1,0,false,5,1,true);
INSERT INTO pliego (id_pliego, id_tipo_trabajo_detalle, rebase_en_milimetros, medianiles_en_milimetros, pinzas_en_centimetros, observaciones, numero_decimal, hojas_requeridas, hojas_sobrantes, hojas_totales, frente_num_entradas_maquina_tinta, frente_num_entradas_maquina_tinta_especial, frente_num_entradas_maquina_barniz, frente_num_total_placas, vuelta_num_entradas_maquina_tinta, vuelta_num_entradas_maquina_tinta_especial, vuelta_num_entradas_maquina_barniz, vuelta_mismas_placas, vuelta_num_total_placas, id_tipo_vuelta, activo) VALUES (3,2,5,5,1,'página 17-32',1,5000,600,5600,4,1,0,5,4,1,0,false,5,1,true);
INSERT INTO pliego (id_pliego, id_tipo_trabajo_detalle, rebase_en_milimetros, medianiles_en_milimetros, pinzas_en_centimetros, observaciones, numero_decimal, hojas_requeridas, hojas_sobrantes, hojas_totales, frente_num_entradas_maquina_tinta, frente_num_entradas_maquina_tinta_especial, frente_num_entradas_maquina_barniz, frente_num_total_placas, vuelta_num_entradas_maquina_tinta, vuelta_num_entradas_maquina_tinta_especial, vuelta_num_entradas_maquina_barniz, vuelta_mismas_placas, vuelta_num_total_placas, id_tipo_vuelta, activo) VALUES (4,2,5,5,1,'página 33-48',1,5000,600,5600,4,1,0,5,4,1,0,false,5,1,true);
INSERT INTO pliego (id_pliego, id_tipo_trabajo_detalle, rebase_en_milimetros, medianiles_en_milimetros, pinzas_en_centimetros, observaciones, numero_decimal, hojas_requeridas, hojas_sobrantes, hojas_totales, frente_num_entradas_maquina_tinta, frente_num_entradas_maquina_tinta_especial, frente_num_entradas_maquina_barniz, frente_num_total_placas, vuelta_num_entradas_maquina_tinta, vuelta_num_entradas_maquina_tinta_especial, vuelta_num_entradas_maquina_barniz, vuelta_mismas_placas, vuelta_num_total_placas, id_tipo_vuelta, activo) VALUES (5,2,5,5,1,'página 49-52',0.25,1250,500,1750,4,1,0,5,0,0,0,true,0,2,true);
INSERT INTO pliego (id_pliego, id_tipo_trabajo_detalle, rebase_en_milimetros, medianiles_en_milimetros, pinzas_en_centimetros, observaciones, numero_decimal, hojas_requeridas, hojas_sobrantes, hojas_totales, frente_num_entradas_maquina_tinta, frente_num_entradas_maquina_tinta_especial, frente_num_entradas_maquina_barniz, frente_num_total_placas, vuelta_num_entradas_maquina_tinta, vuelta_num_entradas_maquina_tinta_especial, vuelta_num_entradas_maquina_barniz, vuelta_mismas_placas, vuelta_num_total_placas, id_tipo_vuelta, activo) VALUES (6,3,5,5,1,'portada',0.25,1250,250,1500,4,0,1,4,0,0,0,false,0,1,true);




INSERT INTO material_ayuda_x_partida (id_material_ayuda_x_partida, id_partida, id_material_ayuda, id_responsable_insumo, observaciones, activo) VALUES (1,1,3,1,'Se debe regresar al cliente',true);
INSERT INTO material_ayuda_x_partida (id_material_ayuda_x_partida, id_partida, id_material_ayuda, id_responsable_insumo, observaciones, activo) VALUES (2,1,4,1,'Muestra flyer',true);
INSERT INTO material_ayuda_x_partida (id_material_ayuda_x_partida, id_partida, id_material_ayuda, id_responsable_insumo, observaciones, activo) VALUES (3,2,3,1,'Regresar al finalizar trabajo',true);




INSERT INTO costo_extra_detalle (id_costo_extra_detalle, id_tipo_trabajo_detalle, id_responsable_insumo, id_costo_extra, especificacion, precio_total_pesos, cantidad, activo) VALUES (1,1,1,1,' Porque cliente equivoco prueba de color',100.1,1,true);
INSERT INTO costo_extra_detalle (id_costo_extra_detalle, id_tipo_trabajo_detalle, id_responsable_insumo, id_costo_extra, especificacion, precio_total_pesos, cantidad, activo) VALUES (2,1,1,5,' Porque cliente equivoco prueba de color',215.25,1,true);




INSERT INTO disenio (id_disenio, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (1,1,'Hacer diseño de volante media carta (14x21.5) y escaneo de imagen',NULL,'Dummy y archivo electrónico',NULL,'2013-09-19','2013-09-20','2013-09-20',true);
INSERT INTO disenio (id_disenio, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (2,2,'Hacer diseño de libro',NULL,NULL,NULL,'2013-09-20','2013-09-25','2013-09-20',true);




INSERT INTO disenio_detalle (id_disenio_detalle, id_disenio, id_proceso_disenio, cantidad, especificaciones, precio_total_pesos, activo) VALUES (1,1,2,1,'Con colores bonitos',100.12,true);
INSERT INTO disenio_detalle (id_disenio_detalle, id_disenio, id_proceso_disenio, cantidad, especificaciones, precio_total_pesos, activo) VALUES (2,1,8,3,'Son imágenes del logotipo',50.25,true);
INSERT INTO disenio_detalle (id_disenio_detalle, id_disenio, id_proceso_disenio, cantidad, especificaciones, precio_total_pesos, activo) VALUES (3,2,2,15,'Con los colores de google',0,true);
INSERT INTO disenio_detalle (id_disenio_detalle, id_disenio, id_proceso_disenio, cantidad, especificaciones, precio_total_pesos, activo) VALUES (4,2,6,1,'Para mostrar al cliente',12.45,true);
INSERT INTO disenio_detalle (id_disenio_detalle, id_disenio, id_proceso_disenio, cantidad, especificaciones, precio_total_pesos, activo) VALUES (5,2,7,5,'Hechas por el cliente',45.67,true);




INSERT INTO preprensa (id_preprensa, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (1,1,'Dar salida de placas',NULL,NULL,NULL,'2013-09-20','2013-09-20','2013-09-20',true);
INSERT INTO preprensa (id_preprensa, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (2,2,'Dar salida de placas',NULL,NULL,NULL,'2013-09-25','2013-09-25','2013-09-20',true);




INSERT INTO preprensa_detalle (id_preprensa_detalle, id_preprensa, id_proceso_preprensa, cantidad, especificaciones, precio_total_pesos, activo) VALUES (1,1,1,1,NULL,120.22,true);
INSERT INTO preprensa_detalle (id_preprensa_detalle, id_preprensa, id_proceso_preprensa, cantidad, especificaciones, precio_total_pesos, activo) VALUES (2,2,2,1,NULL,45.08,true);




INSERT INTO transporte (id_transporte, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (1,1,'Revisar las placas, revelar y elaborar negativos',NULL,NULL,NULL,'2013-09-20','2013-09-21','2013-09-20',true);
INSERT INTO transporte (id_transporte, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (2,2,'Revisar las placas, revelar y elaborar negativos',NULL,NULL,NULL,'2013-09-25','2013-09-25','2013-09-20',true);




INSERT INTO transporte_detalle (id_transporte_detalle, id_transporte, id_proceso_transporte, cantidad, especificaciones, precio_total_pesos, activo) VALUES (1,1,3,1,NULL,100.11,true);
INSERT INTO transporte_detalle (id_transporte_detalle, id_transporte, id_proceso_transporte, cantidad, especificaciones, precio_total_pesos, activo) VALUES (2,2,3,1,NULL,23.98,true);




INSERT INTO _offset (id_offset, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (1,1,'Imprimr a 4x4 tintas',NULL,NULL,NULL,'2013-09-21','2013-09-22','2013-09-20',true);
INSERT INTO _offset (id_offset, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (2,2,'Imprimr a 5x5 tintas',NULL,NULL,NULL,'2013-09-25','2013-09-27','2013-09-20',true);




INSERT INTO offset_detalle (id_offset_detalle, id_pliego, hojas_buenas, hojas_malas, hojas_limpias, hojas_adicionales, laminas_extras, activo) VALUES (1,1,1000,34,0,0,0,true);
INSERT INTO offset_detalle (id_offset_detalle, id_pliego, hojas_buenas, hojas_malas, hojas_limpias, hojas_adicionales, laminas_extras, activo) VALUES (2,2,5200,100,200,0,0,true);
INSERT INTO offset_detalle (id_offset_detalle, id_pliego, hojas_buenas, hojas_malas, hojas_limpias, hojas_adicionales, laminas_extras, activo) VALUES (3,3,5100,50,350,0,0,true);
INSERT INTO offset_detalle (id_offset_detalle, id_pliego, hojas_buenas, hojas_malas, hojas_limpias, hojas_adicionales, laminas_extras, activo) VALUES (4,4,5000,500,0,0,0,true);
INSERT INTO offset_detalle (id_offset_detalle, id_pliego, hojas_buenas, hojas_malas, hojas_limpias, hojas_adicionales, laminas_extras, activo) VALUES (5,5,5158,140,212,0,0,true);
INSERT INTO offset_detalle (id_offset_detalle, id_pliego, hojas_buenas, hojas_malas, hojas_limpias, hojas_adicionales, laminas_extras, activo) VALUES (6,6,5229,264,7,0,0,true);




INSERT INTO acabado (id_acabado, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (1,1,'Realizar corte',NULL,'Hojas',NULL,'2013-09-22','2013-09-25','2013-09-20',true);
INSERT INTO acabado (id_acabado, id_partida, indicacion_tarea_realizar, resumen_entendido_realizar, materiales_recibe, observaciones, fecha_inicio, fecha_fin, fecha_generacion, activo) VALUES (2,2,'Convertir en libro',NULL,'Hojas',NULL,'2013-09-29','2013-10-05','2013-09-20',true);




INSERT INTO acabado_detalle (id_acabado_detalle, id_acabado, id_proceso_externo, ancho, alto, cantidad_proceso_externo, especificaciones, precio_total_pesos, fecha_envio, fecha_entrega, activo) VALUES (1,1,1,NULL,NULL,2,NULL,100.11,'2013-09-25','2013-09-26',true);
INSERT INTO acabado_detalle (id_acabado_detalle, id_acabado, id_proceso_externo, ancho, alto, cantidad_proceso_externo, especificaciones, precio_total_pesos, fecha_envio, fecha_entrega, activo) VALUES (2,2,1,NULL,NULL,8,NULL,200.22,'2013-09-29','2013-09-29',true);
INSERT INTO acabado_detalle (id_acabado_detalle, id_acabado, id_proceso_externo, ancho, alto, cantidad_proceso_externo, especificaciones, precio_total_pesos, fecha_envio, fecha_entrega, activo) VALUES (3,2,5,NULL,NULL,5000,NULL,300.33,'2013-09-29','2013-09-30',true);
INSERT INTO acabado_detalle (id_acabado_detalle, id_acabado, id_proceso_externo, ancho, alto, cantidad_proceso_externo, especificaciones, precio_total_pesos, fecha_envio, fecha_entrega, activo) VALUES (4,2,6,NULL,NULL,5000,NULL,400.44,'2013-09-30','2013-10-01',true);
INSERT INTO acabado_detalle (id_acabado_detalle, id_acabado, id_proceso_externo, ancho, alto, cantidad_proceso_externo, especificaciones, precio_total_pesos, fecha_envio, fecha_entrega, activo) VALUES (5,2,10,NULL,NULL,5000,NULL,500.55,'2013-10-01','2013-10-05',true);




INSERT INTO calificacion_trabajo_detalle (id_calificacion_trabajo_detalle, id_tipo_trabajo_detalle, coste_total_tipo_trabajo_detalle, cantidad_original, cantidad_redondeada, precio_unitario_tabulador, papel_cantidad_total, papel_precio_unitario, papel_coste_total, placas_num_placas, placas_precio_unitario, placas_coste_total, tinta_num_ent_maq, tinta_precio_unitario, tinta_coste_total, tinta_especial_num_ent_maq, tinta_especial_precio_unitario, tinta_especial_coste_total, frente_barniz_num_ent_maq, frente_barniz_precio_unitario, frente_barniz_coste_total, vuelta_barniz_num_ent_maq, vuelta_barniz_precio_unitario, vuelta_barniz_coste_total, activo) VALUES (1,1,1,53350,54000,0.085,18550,1.601,29698.55,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,true);




INSERT INTO calificacion_procesos_partida (id_calificacion_procesos_partida, id_partida, coste_total_procesos_partida, subpartidas_coste_total, disenio_coste_total, preprensa_coste_total, transporte_coste_total, acabado_coste_total, offset_coste_total, costo_extra_total, activo) VALUES (1,1,1,1,1,1,1,1,1,1,true);




INSERT INTO calificacion_orden_produccion (id_calificacion_orden_produccion, id_orden_produccion, precio_bruto, tipo_cliente_precio, tipo_cliente_factor_divisor, precio_cliente, porcentaje_descuento, precio_bruto_con_descuento, precio_neto, observaciones, condiciones_produccion, fecha_generacion, activo) VALUES (1,1,1,1,1,1,1,1,1,1,'Ninguna','2013-09-19 03:14:07',true);
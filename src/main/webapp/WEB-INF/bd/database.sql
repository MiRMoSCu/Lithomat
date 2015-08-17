-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema artiffex_lithomat
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema artiffex_lithomat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `artiffex_lithomat` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `artiffex_lithomat` ;

-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`perfil` (
  `id_perfil` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`usuario` (
  `id_usuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `ap_paterno` VARCHAR(45) NULL,
  `ap_materno` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `contrasenia` VARCHAR(45) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_precio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_precio` (
  `id_tipo_precio` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `factor_divisor` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_precio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_cliente` (
  `id_tipo_cliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `clave` VARCHAR(10) NULL,
  `descripcion` VARCHAR(80) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_cliente`),
  INDEX `fk_tipo_cliente_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_tipo_cliente_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`cliente` (
  `id_cliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_tipo_cliente` INT UNSIGNED NOT NULL,
  `nombre_moral` VARCHAR(80) NULL,
  `nombre_representante` VARCHAR(80) NULL,
  `puesto` VARCHAR(200) NULL,
  `calle` VARCHAR(45) NULL,
  `num_exterior` VARCHAR(15) NULL,
  `num_interior` VARCHAR(15) NULL,
  `colonia` VARCHAR(45) NULL,
  `delegacion_municipio` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `codigo_postal` VARCHAR(10) NULL,
  `pais` VARCHAR(45) NULL,
  `rfc` VARCHAR(25) NULL,
  `telefono_particular` VARCHAR(20) NULL,
  `telefono_movil` VARCHAR(20) NULL,
  `email` VARCHAR(120) NULL,
  `observaciones` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_tipo_cliente1_idx` (`id_tipo_cliente` ASC),
  CONSTRAINT `fk_cliente_tipo_cliente1`
    FOREIGN KEY (`id_tipo_cliente`)
    REFERENCES `artiffex_lithomat`.`tipo_cliente` (`id_tipo_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_comprobante_fiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_comprobante_fiscal` (
  `id_tipo_comprobante_fiscal` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_comprobante_fiscal`),
  INDEX `fk_tipo_comprobamte_fiscal_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_tipo_comprobamte_fiscal_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`orden_produccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`orden_produccion` (
  `id_orden_produccion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_usuario` INT UNSIGNED NOT NULL,
  `id_cliente` INT UNSIGNED NOT NULL,
  `id_tipo_comprobante_fiscal` INT UNSIGNED NOT NULL,
  `nut` VARCHAR(12) NULL,
  `nombre` VARCHAR(120) NULL,
  `descripcion` VARCHAR(500) NULL,
  `fecha_cotizacion` TIMESTAMP NULL,
  `fecha_prometida_entrega` TIMESTAMP NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_fin` TIMESTAMP NULL,
  `fecha_entrega` TIMESTAMP NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_orden_produccion`),
  INDEX `fk_orden_produccion_usuario1_idx` (`id_usuario` ASC),
  INDEX `fk_orden_produccion_cliente1_idx` (`id_cliente` ASC),
  INDEX `fk_orden_produccion_tipo_comprobamte_fiscal1_idx` (`id_tipo_comprobante_fiscal` ASC),
  CONSTRAINT `fk_orden_produccion_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `artiffex_lithomat`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_produccion_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `artiffex_lithomat`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_produccion_tipo_comprobamte_fiscal1`
    FOREIGN KEY (`id_tipo_comprobante_fiscal`)
    REFERENCES `artiffex_lithomat`.`tipo_comprobante_fiscal` (`id_tipo_comprobante_fiscal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`estatus_orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`estatus_orden` (
  `id_estatus_orden` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_estatus_orden`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`historial_estatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`historial_estatus` (
  `id_historial_estatus` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_orden_produccion` INT UNSIGNED NOT NULL,
  `id_estatus_orden` INT UNSIGNED NOT NULL,
  `fecha` TIMESTAMP NULL,
  `observaciones` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_historial_estatus`),
  INDEX `fk_historial_estatus_orden_produccion1_idx` (`id_orden_produccion` ASC),
  INDEX `fk_historial_estatus_estatus_orden1_idx` (`id_estatus_orden` ASC),
  CONSTRAINT `fk_historial_estatus_orden_produccion1`
    FOREIGN KEY (`id_orden_produccion`)
    REFERENCES `artiffex_lithomat`.`orden_produccion` (`id_orden_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historial_estatus_estatus_orden1`
    FOREIGN KEY (`id_estatus_orden`)
    REFERENCES `artiffex_lithomat`.`estatus_orden` (`id_estatus_orden`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`cobranza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`cobranza` (
  `id_cobranza` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_orden_produccion` INT UNSIGNED NOT NULL,
  `fecha` DATE NULL,
  `pendiente` TINYINT(1) NULL,
  `cargo` DECIMAL(9,2) NULL,
  `abono` DECIMAL(9,2) NULL,
  `saldo` DECIMAL(9,2) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_cobranza`),
  INDEX `fk_cobranza_orden_produccion1_idx` (`id_orden_produccion` ASC),
  CONSTRAINT `fk_cobranza_orden_produccion1`
    FOREIGN KEY (`id_orden_produccion`)
    REFERENCES `artiffex_lithomat`.`orden_produccion` (`id_orden_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_trabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_trabajo` (
  `id_tipo_trabajo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_trabajo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_forma_trabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_forma_trabajo` (
  `id_tipo_forma_trabajo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_forma_trabajo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`partida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`partida` (
  `id_partida` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_orden_produccion` INT UNSIGNED NOT NULL,
  `id_tipo_trabajo` INT UNSIGNED NOT NULL,
  `id_tipo_forma_trabajo` INT UNSIGNED NOT NULL,
  `nombre_partida` VARCHAR(80) NULL,
  `cantidad` INT NULL,
  `descripcion_partida` VARCHAR(250) NULL,
  `diagrama_formacion` LONGBLOB NULL,
  `observaciones_generales` VARCHAR(350) NULL,
  `observaciones_aprobacion` VARCHAR(350) NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_partida`),
  INDEX `fk_partida_orden_produccion1_idx` (`id_orden_produccion` ASC),
  INDEX `fk_partida_tipo_trabajo1_idx` (`id_tipo_trabajo` ASC),
  INDEX `fk_partida_tipo_forma_trabajo1_idx` (`id_tipo_forma_trabajo` ASC),
  CONSTRAINT `fk_partida_orden_produccion1`
    FOREIGN KEY (`id_orden_produccion`)
    REFERENCES `artiffex_lithomat`.`orden_produccion` (`id_orden_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partida_tipo_trabajo1`
    FOREIGN KEY (`id_tipo_trabajo`)
    REFERENCES `artiffex_lithomat`.`tipo_trabajo` (`id_tipo_trabajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partida_tipo_forma_trabajo1`
    FOREIGN KEY (`id_tipo_forma_trabajo`)
    REFERENCES `artiffex_lithomat`.`tipo_forma_trabajo` (`id_tipo_forma_trabajo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`maquina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`maquina` (
  `id_maquina` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `num_colores` INT NULL,
  `ancho_placa` INT NULL,
  `alto_placa` INT NULL,
  `ancho_max_papel` INT NULL,
  `alto_max_papel` INT NULL,
  `ancho_min_papel` INT NULL,
  `alto_min_papel` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_maquina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`costos_extras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`costos_extras` (
  `id_costos_extras` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NULL,
  `descripcion` VARCHAR(250) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_costos_extras`),
  INDEX `fk_costos_extras_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_costos_extras_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`costos_extras_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`costos_extras_detalle` (
  `id_costos_extras_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `id_costos_extras` INT UNSIGNED NOT NULL,
  `cantidad` INT NULL,
  `especificaciones` VARCHAR(200) NULL,
  `precio_total_pesos` FLOAT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_costos_extras_detalle`),
  INDEX `fk_costos_extras_detalle_partida1_idx` (`id_partida` ASC),
  INDEX `fk_costos_extras_detalle_costos_extras1_idx` (`id_costos_extras` ASC),
  CONSTRAINT `fk_costos_extras_detalle_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_costos_extras_detalle_costos_extras1`
    FOREIGN KEY (`id_costos_extras`)
    REFERENCES `artiffex_lithomat`.`costos_extras` (`id_costos_extras`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`proveedor_papel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`proveedor_papel` (
  `id_proveedor_papel` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(80) NULL,
  `calle` VARCHAR(45) NULL,
  `num_exterior` VARCHAR(15) NULL,
  `num_interior` VARCHAR(15) NULL,
  `colonia` VARCHAR(45) NULL,
  `delegacion_municipio` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `codigo_postal` VARCHAR(10) NULL,
  `pais` VARCHAR(45) NULL,
  `telefono` VARCHAR(20) NULL,
  `email` VARCHAR(120) NULL,
  `observaciones` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_proveedor_papel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_papel_extendido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_papel_extendido` (
  `id_tipo_papel_extendido` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_proveedor_papel` INT UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `gramaje` INT NULL,
  `kilogramos` FLOAT NULL,
  `ancho` DECIMAL(5,2) NULL,
  `alto` DECIMAL(5,2) NULL,
  `descripcion` VARCHAR(80) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_papel_extendido`),
  INDEX `fk_tipo_papel_extendido_proveedor_papel1_idx` (`id_proveedor_papel` ASC),
  INDEX `fk_tipo_papel_extendido_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_tipo_papel_extendido_proveedor_papel1`
    FOREIGN KEY (`id_proveedor_papel`)
    REFERENCES `artiffex_lithomat`.`proveedor_papel` (`id_proveedor_papel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_papel_extendido_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tamanio_publicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tamanio_publicacion` (
  `id_tamanio_publicacion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `tamanio_fraccion` VARCHAR(15) NULL,
  `numero_paginas` INT NULL,
  `numero_decimal` FLOAT NULL,
  `numero_doblez` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tamanio_publicacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`combinacion_tintas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`combinacion_tintas` (
  `id_combinacion_tintas` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `num_tintas` INT NULL,
  `descripcion` VARCHAR(10) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_combinacion_tintas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_barniz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_barniz` (
  `id_tipo_barniz` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `num_entradas_maquina` INT NULL,
  `num_placas` INT NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_barniz`),
  INDEX `fk_tipo_barniz_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_tipo_barniz_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_placa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_placa` (
  `id_tipo_placa` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_maquina` INT UNSIGNED NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_placa`),
  INDEX `fk_tipo_placa_maquina1_idx` (`id_maquina` ASC),
  INDEX `fk_tipo_placa_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_tipo_placa_maquina1`
    FOREIGN KEY (`id_maquina`)
    REFERENCES `artiffex_lithomat`.`maquina` (`id_maquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_placa_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_trabajo_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_trabajo_detalle` (
  `id_tipo_trabajo_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `descripcion` VARCHAR(350) NULL,
  `ancho` FLOAT NULL,
  `alto` FLOAT NULL,
  `ancho_extendido` FLOAT NULL,
  `alto_extendido` FLOAT NULL,
  `cliente_proporciona_papel` TINYINT(1) NULL,
  `cliente_proporciona_tinta` TINYINT(1) NULL,
  `cliente_proporciona_tinta_especial` TINYINT(1) NULL,
  `cliente_proporciona_barniz` TINYINT(1) NULL,
  `cliente_proporciona_placas` TINYINT(1) NULL,
  `id_tipo_papel_extendido` INT UNSIGNED NOT NULL,
  `repeticiones_x_pliego` INT NULL,
  `numero_paginas_publicacion` INT NULL,
  `id_tamanio_publicacion` INT UNSIGNED NOT NULL,
  `frente_id_combinacion_tintas` INT UNSIGNED NOT NULL,
  `frente_num_tinta_especial` INT NULL,
  `frente_descripcion_tinta_especial` VARCHAR(250) NULL,
  `frente_id_tipo_barniz` INT UNSIGNED NOT NULL,
  `vuelta_id_combinacion_tintas` INT NULL,
  `vuelta_num_tinta_especial` INT NULL,
  `vuelta_descripcion_tinta_especial` VARCHAR(250) NULL,
  `vuelta_id_tipo_barniz` INT NULL,
  `id_maquina` INT UNSIGNED NOT NULL,
  `id_tipo_placa` INT UNSIGNED NOT NULL,
  `observaciones` VARCHAR(250) NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_trabajo_detalle`),
  INDEX `fk_tipo_trabajo_detalle_partida1_idx` (`id_partida` ASC),
  INDEX `fk_tipo_trabajo_detalle_tipo_papel_extendido1_idx` (`id_tipo_papel_extendido` ASC),
  INDEX `fk_tipo_trabajo_detalle_tamanio_publicacion1_idx` (`id_tamanio_publicacion` ASC),
  INDEX `fk_tipo_trabajo_detalle_combinacion_tintas1_idx` (`frente_id_combinacion_tintas` ASC),
  INDEX `fk_tipo_trabajo_detalle_tipo_barniz1_idx` (`frente_id_tipo_barniz` ASC),
  INDEX `fk_tipo_trabajo_detalle_tipo_placa1_idx` (`id_tipo_placa` ASC),
  INDEX `fk_tipo_trabajo_detalle_maquina1_idx` (`id_maquina` ASC),
  CONSTRAINT `fk_tipo_trabajo_detalle_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_trabajo_detalle_tipo_papel_extendido1`
    FOREIGN KEY (`id_tipo_papel_extendido`)
    REFERENCES `artiffex_lithomat`.`tipo_papel_extendido` (`id_tipo_papel_extendido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_trabajo_detalle_tamanio_publicacion1`
    FOREIGN KEY (`id_tamanio_publicacion`)
    REFERENCES `artiffex_lithomat`.`tamanio_publicacion` (`id_tamanio_publicacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_trabajo_detalle_combinacion_tintas1`
    FOREIGN KEY (`frente_id_combinacion_tintas`)
    REFERENCES `artiffex_lithomat`.`combinacion_tintas` (`id_combinacion_tintas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_trabajo_detalle_tipo_barniz1`
    FOREIGN KEY (`frente_id_tipo_barniz`)
    REFERENCES `artiffex_lithomat`.`tipo_barniz` (`id_tipo_barniz`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_trabajo_detalle_tipo_placa1`
    FOREIGN KEY (`id_tipo_placa`)
    REFERENCES `artiffex_lithomat`.`tipo_placa` (`id_tipo_placa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_trabajo_detalle_maquina1`
    FOREIGN KEY (`id_maquina`)
    REFERENCES `artiffex_lithomat`.`maquina` (`id_maquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tinta_especial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tinta_especial` (
  `id_tinta_especial` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tinta_especial`),
  INDEX `fk_tinta_especial_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_tinta_especial_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_vuelta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_vuelta` (
  `id_tipo_vuelta` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_vuelta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tabulador_precios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tabulador_precios` (
  `id_tabulador_precios` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_maquina` INT UNSIGNED NOT NULL,
  `nombre_insumo` VARCHAR(80) NULL,
  `descripcion` VARCHAR(250) NULL,
  `inicio_tabulador` INT NULL,
  `fin_tabulador` INT NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  `filler_varchar_1` VARCHAR(250) NULL,
  `filler_varchar_2` VARCHAR(250) NULL,
  `filler_int_1` INT NULL,
  `filler_int_2` INT NULL,
  `filler_numeric_1` DECIMAL(9,2) NULL,
  `filler_numeric_2` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id_tabulador_precios`),
  INDEX `fk_tabulador_precios_maquina1_idx` (`id_maquina` ASC),
  INDEX `fk_tabulador_precios_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_tabulador_precios_maquina1`
    FOREIGN KEY (`id_maquina`)
    REFERENCES `artiffex_lithomat`.`maquina` (`id_maquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tabulador_precios_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`prensista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`prensista` (
  `id_prensista` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `ap_paterno` VARCHAR(45) NULL,
  `ap_materno` VARCHAR(45) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_prensista`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`turno_laboral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`turno_laboral` (
  `id_turno_laboral` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `hora_inicio` TIME NULL,
  `hora_fin` TIME NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_turno_laboral`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`pliego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`pliego` (
  `id_pliego` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_tipo_trabajo_detalle` INT UNSIGNED NOT NULL,
  `rebase_en_milimetros` INT NULL,
  `medianiles_en_milimetros` INT NULL,
  `pinzas_en_centimetros` INT NULL,
  `observaciones` VARCHAR(250) NULL,
  `numero_decimal` FLOAT NULL,
  `hojas_requeridas` INT NULL,
  `hojas_sobrantes` INT NULL,
  `hojas_totales` INT NULL,
  `frente_num_entradas_maquina_tinta` INT NULL,
  `frente_num_entradas_maquina_tinta_especial` VARCHAR(45) NULL,
  `frente_num_entradas_maquina_barniz` VARCHAR(45) NULL,
  `frente_num_total_placas` INT NULL,
  `vuelta_num_entradas_maquina_tinta` INT NULL,
  `vuelta_num_entradas_maquina_tinta_especial` VARCHAR(45) NULL,
  `vuelta_num_entradas_maquina_barniz` VARCHAR(45) NULL,
  `vuelta_mismas_placas` TINYINT(1) NULL,
  `vuelta_num_total_placas` INT NULL,
  `id_tipo_vuelta` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_pliego`),
  INDEX `fk_pliego_tipo_trabajo_detalle1_idx` (`id_tipo_trabajo_detalle` ASC),
  INDEX `fk_pliego_tipo_vuelta1_idx` (`id_tipo_vuelta` ASC),
  CONSTRAINT `fk_pliego_tipo_trabajo_detalle1`
    FOREIGN KEY (`id_tipo_trabajo_detalle`)
    REFERENCES `artiffex_lithomat`.`tipo_trabajo_detalle` (`id_tipo_trabajo_detalle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pliego_tipo_vuelta1`
    FOREIGN KEY (`id_tipo_vuelta`)
    REFERENCES `artiffex_lithomat`.`tipo_vuelta` (`id_tipo_vuelta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`fecha_prensista_maquina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`fecha_prensista_maquina` (
  `id_fecha_prensista_maquina` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_prensista` INT UNSIGNED NOT NULL,
  `id_turno_laboral` INT UNSIGNED NOT NULL,
  `id_maquina` INT UNSIGNED NOT NULL,
  `id_pliego` INT UNSIGNED NOT NULL,
  `fecha` DATE NULL,
  `id_prensista_ayudante` INT NULL,
  `numero_millar_impreso` INT NULL,
  `numero_cambio_placas` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_fecha_prensista_maquina`),
  INDEX `fk_fecha_prensista_maquina_prensista1_idx` (`id_prensista` ASC),
  INDEX `fk_fecha_prensista_maquina_turno_laboral1_idx` (`id_turno_laboral` ASC),
  INDEX `fk_fecha_prensista_maquina_maquina1_idx` (`id_maquina` ASC),
  INDEX `fk_fecha_prensista_maquina_pliego1_idx` (`id_pliego` ASC),
  CONSTRAINT `fk_fecha_prensista_maquina_prensista1`
    FOREIGN KEY (`id_prensista`)
    REFERENCES `artiffex_lithomat`.`prensista` (`id_prensista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fecha_prensista_maquina_turno_laboral1`
    FOREIGN KEY (`id_turno_laboral`)
    REFERENCES `artiffex_lithomat`.`turno_laboral` (`id_turno_laboral`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fecha_prensista_maquina_maquina1`
    FOREIGN KEY (`id_maquina`)
    REFERENCES `artiffex_lithomat`.`maquina` (`id_maquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fecha_prensista_maquina_pliego1`
    FOREIGN KEY (`id_pliego`)
    REFERENCES `artiffex_lithomat`.`pliego` (`id_pliego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`calendario_orden_produccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`calendario_orden_produccion` (
  `id_calendario_orden_produccion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_pliego` INT UNSIGNED NOT NULL,
  `id_maquina` INT UNSIGNED NOT NULL,
  `apuntador_pliego_produccion` INT NULL,
  `siguiente_pliego_realizar` INT NULL,
  `esta_eliminado` TINYINT(1) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_calendario_orden_produccion`),
  INDEX `fk_calendario_orden_produccion_pliego1_idx` (`id_pliego` ASC),
  INDEX `fk_calendario_orden_produccion_maquina1_idx` (`id_maquina` ASC),
  CONSTRAINT `fk_calendario_orden_produccion_pliego1`
    FOREIGN KEY (`id_pliego`)
    REFERENCES `artiffex_lithomat`.`pliego` (`id_pliego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_calendario_orden_produccion_maquina1`
    FOREIGN KEY (`id_maquina`)
    REFERENCES `artiffex_lithomat`.`maquina` (`id_maquina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`_offset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`_offset` (
  `id_offset` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `indicacion_tarea_realizar` VARCHAR(500) NULL,
  `resumen_entendido_realizar` VARCHAR(500) NULL,
  `materiales_recibe` VARCHAR(500) NULL,
  `observaciones` VARCHAR(500) NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_fin` TIMESTAMP NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_offset`),
  INDEX `fk__offset_partida1_idx` (`id_partida` ASC),
  CONSTRAINT `fk__offset_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`offset_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`offset_detalle` (
  `id_offset_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_pliego` INT UNSIGNED NOT NULL,
  `hojas_buenas` INT NULL,
  `hojas_malas` INT NULL,
  `hojas_limpias` INT NULL,
  `hojas_adicionales` INT NULL,
  `laminas_extras` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_offset_detalle`),
  INDEX `fk_offset_detalle_pliego1_idx` (`id_pliego` ASC),
  CONSTRAINT `fk_offset_detalle_pliego1`
    FOREIGN KEY (`id_pliego`)
    REFERENCES `artiffex_lithomat`.`pliego` (`id_pliego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`material_ayuda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`material_ayuda` (
  `id_material_ayuda` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_material_ayuda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`responsable_insumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`responsable_insumo` (
  `id_responsable_insumo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_responsable_insumo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`material_ayuda_x_partida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`material_ayuda_x_partida` (
  `id_material_ayuda_x_partida` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `id_material_ayuda` INT UNSIGNED NOT NULL,
  `id_responsable_insumo` INT UNSIGNED NOT NULL,
  `observaciones` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_material_ayuda_x_partida`),
  INDEX `fk_material_ayuda_x_partida_partida1_idx` (`id_partida` ASC),
  INDEX `fk_material_ayuda_x_partida_material_ayuda1_idx` (`id_material_ayuda` ASC),
  INDEX `fk_material_ayuda_x_partida_responsable_insumo1_idx` (`id_responsable_insumo` ASC),
  CONSTRAINT `fk_material_ayuda_x_partida_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_material_ayuda_x_partida_material_ayuda1`
    FOREIGN KEY (`id_material_ayuda`)
    REFERENCES `artiffex_lithomat`.`material_ayuda` (`id_material_ayuda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_material_ayuda_x_partida_responsable_insumo1`
    FOREIGN KEY (`id_responsable_insumo`)
    REFERENCES `artiffex_lithomat`.`responsable_insumo` (`id_responsable_insumo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`disenio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`disenio` (
  `id_disenio` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `indicacion_tarea_realizar` VARCHAR(250) NULL,
  `resumen_entendido_realizar` VARCHAR(250) NULL,
  `materiales_recibe` VARCHAR(250) NULL,
  `observaciones` VARCHAR(250) NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_fin` TIMESTAMP NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_disenio`),
  INDEX `fk_disenio_partida1_idx` (`id_partida` ASC),
  CONSTRAINT `fk_disenio_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`proceso_disenio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`proceso_disenio` (
  `id_proceso_disenio` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_proceso` VARCHAR(45) NULL,
  `descripcion` VARCHAR(250) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_proceso_disenio`),
  INDEX `fk_proceso_disenio_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_proceso_disenio_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`disenio_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`disenio_detalle` (
  `id_disenio_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_disenio` INT UNSIGNED NOT NULL,
  `id_proceso_disenio` INT UNSIGNED NOT NULL,
  `cantidad` INT NULL,
  `especificaciones` VARCHAR(250) NULL,
  `precio_total_pesos` FLOAT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_disenio_detalle`),
  INDEX `fk_disenio_detalle_disenio1_idx` (`id_disenio` ASC),
  INDEX `fk_disenio_detalle_proceso_disenio1_idx` (`id_proceso_disenio` ASC),
  CONSTRAINT `fk_disenio_detalle_disenio1`
    FOREIGN KEY (`id_disenio`)
    REFERENCES `artiffex_lithomat`.`disenio` (`id_disenio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disenio_detalle_proceso_disenio1`
    FOREIGN KEY (`id_proceso_disenio`)
    REFERENCES `artiffex_lithomat`.`proceso_disenio` (`id_proceso_disenio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`preprensa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`preprensa` (
  `id_preprensa` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `indicacion_tarea_realizar` VARCHAR(250) NULL,
  `resumen_entendido_realizar` VARCHAR(250) NULL,
  `materiales_recibe` VARCHAR(250) NULL,
  `observaciones` VARCHAR(250) NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_fin` TIMESTAMP NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_preprensa`),
  INDEX `fk_preprensa_partida1_idx` (`id_partida` ASC),
  CONSTRAINT `fk_preprensa_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`transporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`transporte` (
  `id_transporte` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `indicacion_tarea_realizar` VARCHAR(250) NULL,
  `resumen_entendido_realizar` VARCHAR(250) NULL,
  `materiales_recibe` VARCHAR(250) NULL,
  `observaciones` VARCHAR(250) NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_fin` TIMESTAMP NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_transporte`),
  INDEX `fk_transporte_partida1_idx` (`id_partida` ASC),
  CONSTRAINT `fk_transporte_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`proceso_transporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`proceso_transporte` (
  `id_proceso_transporte` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_proceso` VARCHAR(45) NULL,
  `descripcion` VARCHAR(250) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_proceso_transporte`),
  INDEX `fk_proceso_transporte_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_proceso_transporte_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`transporte_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`transporte_detalle` (
  `id_transporte_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_transporte` INT UNSIGNED NOT NULL,
  `id_proceso_transporte` INT UNSIGNED NOT NULL,
  `cantidad` INT NULL,
  `especificaciones` VARCHAR(250) NULL,
  `precio_total_pesos` FLOAT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_transporte_detalle`),
  INDEX `fk_transporte_detalle_transporte1_idx` (`id_transporte` ASC),
  INDEX `fk_transporte_detalle_proceso_transporte1_idx` (`id_proceso_transporte` ASC),
  CONSTRAINT `fk_transporte_detalle_transporte1`
    FOREIGN KEY (`id_transporte`)
    REFERENCES `artiffex_lithomat`.`transporte` (`id_transporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transporte_detalle_proceso_transporte1`
    FOREIGN KEY (`id_proceso_transporte`)
    REFERENCES `artiffex_lithomat`.`proceso_transporte` (`id_proceso_transporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`acabado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`acabado` (
  `id_acabado` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `indicacion_tarea_realizar` VARCHAR(250) NULL,
  `resumen_entendido_realizar` VARCHAR(250) NULL,
  `materiales_recibe` VARCHAR(250) NULL,
  `observaciones` VARCHAR(250) NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_fin` TIMESTAMP NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_acabado`),
  INDEX `fk_acabado_partida1_idx` (`id_partida` ASC),
  CONSTRAINT `fk_acabado_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`proveedor_externo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`proveedor_externo` (
  `id_proveedor_externo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(80) NULL,
  `calle` VARCHAR(45) NULL,
  `num_exterior` VARCHAR(15) NULL,
  `num_interior` VARCHAR(15) NULL,
  `colonia` VARCHAR(45) NULL,
  `delegacion_municipio` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `codigo_postal` VARCHAR(10) NULL,
  `pais` VARCHAR(45) NULL,
  `telefono` VARCHAR(20) NULL,
  `email` VARCHAR(120) NULL,
  `observaciones` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_proveedor_externo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`proceso_externo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`proceso_externo` (
  `id_proceso_externo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_proveedor_externo` INT UNSIGNED NOT NULL,
  `nombre_proceso` VARCHAR(45) NULL,
  `observaciones` VARCHAR(250) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_proceso_externo`),
  INDEX `fk_proceso_externo_proveedor_externo1_idx` (`id_proveedor_externo` ASC),
  INDEX `fk_proceso_externo_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_proceso_externo_proveedor_externo1`
    FOREIGN KEY (`id_proveedor_externo`)
    REFERENCES `artiffex_lithomat`.`proveedor_externo` (`id_proveedor_externo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proceso_externo_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`acabado_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`acabado_detalle` (
  `id_acabado_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_acabado` INT UNSIGNED NOT NULL,
  `id_proceso_externo` INT UNSIGNED NOT NULL,
  `ancho` FLOAT NULL,
  `alto` FLOAT NULL,
  `cantidad_proceso_externo` INT NULL,
  `especificaciones` VARCHAR(250) NULL,
  `precio_total_pesos` FLOAT NULL,
  `fecha_envio` DATE NULL,
  `fecha_entrega` DATE NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_acabado_detalle`),
  INDEX `fk_acabado_detalle_acabado1_idx` (`id_acabado` ASC),
  INDEX `fk_acabado_detalle_proceso_externo1_idx` (`id_proceso_externo` ASC),
  CONSTRAINT `fk_acabado_detalle_acabado1`
    FOREIGN KEY (`id_acabado`)
    REFERENCES `artiffex_lithomat`.`acabado` (`id_acabado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acabado_detalle_proceso_externo1`
    FOREIGN KEY (`id_proceso_externo`)
    REFERENCES `artiffex_lithomat`.`proceso_externo` (`id_proceso_externo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tiempo_orden_produccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tiempo_orden_produccion` (
  `id_tiempo_orden_produccion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_orden_produccion` INT NULL,
  `fecha_recepcion` TIMESTAMP NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_termino` TIMESTAMP NULL,
  `fecha_entrega` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tiempo_orden_produccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`unidad_medida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`unidad_medida` (
  `id_unidad_medida` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_unidad_medida`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`tipo_formacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`tipo_formacion` (
  `id_tipo_formacion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(250) NULL,
  `num_multiplo` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_tipo_formacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`insumo_calificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`insumo_calificacion` (
  `id_insumo_calificacion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_orden_produccion` INT NULL,
  `id_disenio` INT NULL,
  `id_preprensa` INT NULL,
  `id_transporte` INT NULL,
  `id_acabado` INT NULL,
  `id_offset` INT NULL,
  `id_proceso_externo` INT NULL,
  `cantidad` INT NULL,
  `concepto` VARCHAR(250) NULL,
  `precio_unitario` DECIMAL(9,2) NULL,
  `sub_total` DECIMAL(9,2) NULL,
  `iva` INT NULL,
  `total` DECIMAL(9,2) NULL,
  `id_cargo_insumo` INT NULL,
  `observaciones` VARCHAR(250) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_insumo_calificacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`historico_produccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`historico_produccion` (
  `id_historico_produccion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `punto_equilibrio` DECIMAL(12,2) NULL,
  `offset` DECIMAL(12,2) NULL,
  `perdida` DECIMAL(12,2) NULL,
  `ganancia` DECIMAL(12,2) NULL,
  `disenio` DECIMAL(12,2) NULL,
  `preprensa` DECIMAL(12,2) NULL,
  `transporte` DECIMAL(12,2) NULL,
  `corte` DECIMAL(12,2) NULL,
  `otros` DECIMAL(12,2) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_historico_produccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`aviso_mantenimiento_maquina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`aviso_mantenimiento_maquina` (
  `id_aviso_mantenimiento_maquina` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NULL,
  `aviso` VARCHAR(250) NULL,
  `id_usuario` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_aviso_mantenimiento_maquina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`parametros_config`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`parametros_config` (
  `id_parametros_config` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(80) NULL,
  `filler_varchar_1` VARCHAR(250) NULL,
  `filler_varchar_2` VARCHAR(250) NULL,
  `filler_int_1` INT NULL,
  `filler_int_2` INT NULL,
  `filler_numeric_1` DECIMAL(12,2) NULL,
  `filler_numeric_2` DECIMAL(12,2) NULL,
  `filler_bool_1` TINYINT(1) NULL,
  `filler_bool_2` TINYINT(1) NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_parametros_config`),
  INDEX `fk_parametros_config_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_parametros_config_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`datos_facturacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`datos_facturacion` (
  `id_datos_facturacion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_datos_facturacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`calificacion_trabajo_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`calificacion_trabajo_detalle` (
  `id_calificacion_trabajo_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_tipo_trabajo_detalle` INT UNSIGNED NOT NULL,
  `coste_total_tipo_trabajo_detalle` DECIMAL(12,2) NULL,
  `cantidad_original` INT NULL,
  `cantidad_redondeada` INT NULL,
  `precio_unitario_tabulador` FLOAT NULL,
  `papel_cantidad_total` INT NULL,
  `papel_precio_unitario` FLOAT NULL,
  `papel_coste_total` DECIMAL(12,2) NULL,
  `placas_num_placas` INT NULL,
  `placas_precio_unitario` FLOAT NULL,
  `placas_coste_total` DECIMAL(12,2) NULL,
  `tinta_num_ent_maq` INT NULL,
  `tinta_precio_unitario` FLOAT NULL,
  `tinta_coste_total` DECIMAL(12,2) NULL,
  `tinta_especial_num_ent_maq` INT NULL,
  `tinta_especial_precio_unitario` FLOAT NULL,
  `tinta_especial_coste_total` DECIMAL(12,2) NULL,
  `frente_barniz_num_ent_maq` INT NULL,
  `frente_barniz_precio_unitario` FLOAT NULL,
  `frente_barniz_coste_total` DECIMAL(12,2) NULL,
  `vuelta_barniz_num_ent_maq` INT NULL,
  `vuelta_barniz_precio_unitario` FLOAT NULL,
  `vuelta_barniz_coste_total` DECIMAL(12,2) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_calificacion_trabajo_detalle`),
  INDEX `fk_resumen_calificacion_trabajo_detalle_tipo_trabajo_detall_idx` (`id_tipo_trabajo_detalle` ASC),
  CONSTRAINT `fk_resumen_calificacion_trabajo_detalle_tipo_trabajo_detalle1`
    FOREIGN KEY (`id_tipo_trabajo_detalle`)
    REFERENCES `artiffex_lithomat`.`tipo_trabajo_detalle` (`id_tipo_trabajo_detalle`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`papel_sobrante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`papel_sobrante` (
  `id_papel_sobrante` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `inicio_tabulador` INT NULL,
  `fin_tabulador` INT NULL,
  `frente_num_tinta` INT NULL,
  `vuelta_num_tinta` INT NULL,
  `tinta_especial` TINYINT(1) NULL,
  `hojas_sobrante` INT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_papel_sobrante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`proceso_preprensa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`proceso_preprensa` (
  `id_proceso_preprensa` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_proceso` VARCHAR(45) NULL,
  `descripcion` VARCHAR(250) NULL,
  `precio` FLOAT NULL,
  `id_tipo_precio` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_proceso_preprensa`),
  INDEX `fk_proceso_preprensa_tipo_precio1_idx` (`id_tipo_precio` ASC),
  CONSTRAINT `fk_proceso_preprensa_tipo_precio1`
    FOREIGN KEY (`id_tipo_precio`)
    REFERENCES `artiffex_lithomat`.`tipo_precio` (`id_tipo_precio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`preprensa_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`preprensa_detalle` (
  `id_preprensa_detalle` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_preprensa` INT UNSIGNED NOT NULL,
  `id_proceso_preprensa` INT UNSIGNED NOT NULL,
  `cantidad` INT NULL,
  `especificaciones` VARCHAR(250) NULL,
  `precio_total_pesos` FLOAT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_preprensa_detalle`),
  INDEX `fk_preprensa_detalle_preprensa1_idx` (`id_preprensa` ASC),
  INDEX `fk_preprensa_detalle_proceso_preprensa1_idx` (`id_proceso_preprensa` ASC),
  CONSTRAINT `fk_preprensa_detalle_preprensa1`
    FOREIGN KEY (`id_preprensa`)
    REFERENCES `artiffex_lithomat`.`preprensa` (`id_preprensa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_preprensa_detalle_proceso_preprensa1`
    FOREIGN KEY (`id_proceso_preprensa`)
    REFERENCES `artiffex_lithomat`.`proceso_preprensa` (`id_proceso_preprensa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`calificacion_procesos_partida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`calificacion_procesos_partida` (
  `id_calificacion_procesos_partida` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_partida` INT UNSIGNED NOT NULL,
  `coste_total_procesos_partida` DECIMAL(12,2) NULL,
  `subpartidas_coste_total` DECIMAL(12,2) NULL,
  `disenio_coste_total` DECIMAL(12,2) NULL,
  `preprensa_coste_total` DECIMAL(12,2) NULL,
  `transporte_coste_total` DECIMAL(12,2) NULL,
  `acabado_coste_total` DECIMAL(12,2) NULL,
  `offset_coste_total` DECIMAL(12,2) NULL,
  `costo_extra_total` DECIMAL(12,2) NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_calificacion_procesos_partida`),
  INDEX `fk_resumen_calificacion_partida_partida1_idx` (`id_partida` ASC),
  CONSTRAINT `fk_resumen_calificacion_partida_partida1`
    FOREIGN KEY (`id_partida`)
    REFERENCES `artiffex_lithomat`.`partida` (`id_partida`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`calificacion_orden_produccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`calificacion_orden_produccion` (
  `id_calificacion_orden_produccion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_orden_produccion` INT UNSIGNED NOT NULL,
  `precio_bruto` DECIMAL(12,2) NULL,
  `tipo_cliente_precio` FLOAT NULL,
  `tipo_cliente_id_tipo_precio` INT NULL,
  `precio_cliente` DECIMAL(12,2) NULL,
  `porcentaje_descuento` INT NULL,
  `precio_bruto_con_descuento` DECIMAL(12,2) NULL,
  `precio_neto` DECIMAL(12,2) NULL,
  `observaciones` VARCHAR(200) NULL,
  `condiciones_produccion` VARCHAR(1000) NULL,
  `fecha_generacion` TIMESTAMP NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_calificacion_orden_produccion`),
  INDEX `fk_resumen_calificacion_orden_produccion_orden_produccion1_idx` (`id_orden_produccion` ASC),
  CONSTRAINT `fk_resumen_calificacion_orden_produccion_orden_produccion1`
    FOREIGN KEY (`id_orden_produccion`)
    REFERENCES `artiffex_lithomat`.`orden_produccion` (`id_orden_produccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`costo_real_orden_produccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`costo_real_orden_produccion` (
  `id_costo_real_orden_produccion` INT NOT NULL,
  PRIMARY KEY (`id_costo_real_orden_produccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `artiffex_lithomat`.`perfil_x_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artiffex_lithomat`.`perfil_x_usuario` (
  `id_perfil_x_usuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_usuario` INT UNSIGNED NOT NULL,
  `id_perfil` INT UNSIGNED NOT NULL,
  `activo` TINYINT(1) NULL,
  PRIMARY KEY (`id_perfil_x_usuario`),
  INDEX `fk_perfil_x_usuario_usuario1_idx` (`id_usuario` ASC),
  INDEX `fk_perfil_x_usuario_perfil1_idx` (`id_perfil` ASC),
  CONSTRAINT `fk_perfil_x_usuario_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `artiffex_lithomat`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_perfil_x_usuario_perfil1`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `artiffex_lithomat`.`perfil` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

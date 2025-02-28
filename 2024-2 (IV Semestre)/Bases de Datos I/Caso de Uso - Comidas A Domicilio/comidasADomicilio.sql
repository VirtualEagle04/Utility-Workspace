CREATE TABLE ClaseArticulos (
    articulo VARCHAR2(10) NOT NULL,
    t_art CHAR(1) NOT NULL,
    CONSTRAINT pk_ClaseArticulos PRIMARY KEY (articulo),
    CONSTRAINT ck_art CHECK (articulo = INITCAP(articulo)),
    CONSTRAINT ck_tar CHECK (t_art IN ('P', 'B', 'C'))
);

CREATE TABLE Articulos (
    articulo VARCHAR2(10) NOT NULL,
    tamano CHAR(1) NOT NULL,
    precio_articulo NUMBER(4) NOT NULL,
    CONSTRAINT pk_Articulos PRIMARY KEY (articulo, tamano),
    CONSTRAINT ck_par CHECK (precio_articulo > = 0),
    CONSTRAINT ck_tam CHECK (tamano IN ('P', 'M', 'G')) 
);

CREATE TABLE Pizzas (
    articulo VARCHAR2(10) NOT NULL,
    tamano CHAR(1) NOT NULL,
    precio_ingrediente NUMBER(3),
    CONSTRAINT pk_Pizzas PRIMARY KEY (articulo, tamano),
    CONSTRAINT fk_piz_art FOREIGN KEY (articulo, tamano) REFERENCES Articulos(articulo, tamano) ON DELETE CASCADE,
    CONSTRAINT ck_pin CHECK (precio_ingrediente > = 0)
);

CREATE TABLE Ingredientes (
    ingrediente VARCHAR2 (4) NOT NULL,
    nombre_ingrediente VARCHAR2 (10) NOT NULL,
    CONSTRAINT pk_Ingredientes PRIMARY KEY (ingrediente),
    CONSTRAINT un_ing UNIQUE (nombre_ingrediente),
    CONSTRAINT ck_nin CHECK (nombre_ingrediente = INITCAP(nombre_ingrediente ))
);

CREATE TABLE PizzasBase (
    articulo VARCHAR2(10) NOT NULL,
    ingrediente VARCHAR2(4) NOT NULL,
    CONSTRAINT pk_PizzasBase PRIMARY KEY (articulo, ingrediente),
    CONSTRAINT fk_pba_car FOREIGN KEY (articulo) REFERENCES ClaseArticulos(articulo) ON DELETE CASCADE,
    CONSTRAINT fk_pba_ing FOREIGN KEY (ingrediente) REFERENCES Ingredientes(ingrediente) ON DELETE CASCADE
);

CREATE TABLE RecetasPizzas (
    articulo VARCHAR2(10) NOT NULL,
    ingrediente VARCHAR2(4) NOT NULL,
    CONSTRAINT pk_RecetasPizzas PRIMARY KEY (articulo, ingrediente),
    CONSTRAINT fk_rpi_car FOREIGN KEY (articulo) REFERENCES ClaseArticulos(articulo) ON DELETE CASCADE,
    CONSTRAINT fk_rpi_ing FOREIGN KEY (ingrediente) REFERENCES Ingredientes(ingrediente) ON DELETE CASCADE
);

CREATE TABLE RecetasBocadillos (
    articulo VARCHAR2(10) NOT NULL,
    tamano CHAR(1) NOT NULL,
    ingrediente VARCHAR2(4) NOT NULL,
    precio_ingrediente NUMBER(3),
    CONSTRAINT pk_RecetasBocadillos PRIMARY KEY (articulo, tamano, ingrediente),
    CONSTRAINT fk_rbo_art FOREIGN KEY (articulo, tamano) REFERENCES Articulos(articulo, tamano) ON DELETE CASCADE,
    CONSTRAINT fk_rbo_ing FOREIGN KEY (ingrediente) REFERENCES INgredientes(ingrediente) ON DELETE CASCADE,
    CONSTRAINT ck_prin CHECK (precio_ingrediente > = 0)
);

CREATE TABLE ProductosEstrella (
    nombre_comercial VARCHAR2(15) NOT NULL,
    articulo VARCHAR2(10) NOT NULL,
    CONSTRAINT pk_ProductosEstrella PRIMARY KEY (nombre_comercial),
    CONSTRAINT fk_pes_art FOREIGN KEY (articulo) REFERENCES ClaseArticulos(articulo) ON DELETE CASCADE,
    CONSTRAINT ck_nco CHECK (nombre_comercial = INITCAP(nombre_comercial))
);

CREATE TABLE RecetasEstrella (
    nombre_comercial VARCHAR2(15) NOT NULL,
    ingrediente VARCHAR2(4) NOT NULL,
    CONSTRAINT pk_RecetasEstrella PRIMARY KEY (nombre_comercial, ingrediente),
    CONSTRAINT fk_res_pes FOREIGN KEY (nombre_comercial) REFERENCES ProductosEstrella(nombre_comercial),
    CONSTRAINT fk_res_ing FOREIGN KEY (ingrediente) REFERENCES Ingredientes(ingrediente) ON DELETE CASCADE
);

CREATE TABLE Clientes (
    cliente NUMBER(5) NOT NULL,
    nombre_cliente VARCHAR2(20) NOT NULL,
    apellidos_cliente VARCHAR2(40) NOT NULL,
    direccion_cliente VARCHAR2(30),
    telf_cliente NUMBER(9),
    consumo_p NUMBER(3),
    consumo_b NUMBER(3),
    consumo_c NUMBER(3),
    CONSTRAINT pk_Clientes PRIMARY KEY (cliente),
    CONSTRAINT ck_ncl CHECK (nombre_cliente = INITCAP(nombre_cliente)),
    CONSTRAINT ck_acl CHECK (apellidos_cliente = INITCAP(apellidos_cliente)),
    CONSTRAINT ck_cop CHECK (consumo_p > = 0),
    CONSTRAINT ck_cob CHECK (consumo_b > = 0),
    CONSTRAINT ck_coc CHECK (consumo_c > = 0)
);

CREATE TABLE Scooters (
    scooter VARCHAR2(6) NOT NULL,
    ano_scooter NUMBER(4),
    CONSTRAINT pk_Scooters PRIMARY KEY (scooter)
);

CREATE TABLE Repartidores (
    dni_repartidor VARCHAR2(9) NOT NULL,
    nombrec_repartidor VARCHAR2(30) NOT NULL,
    scooter VARCHAR2(6) NOT NULL,
    CONSTRAINT pk_Repartidores PRIMARY KEY (dni_repartidor),
    CONSTRAINT fk_rep_sco FOREIGN KEY (scooter) REFERENCES Scooters(scooter) ON DELETE CASCADE,
    CONSTRAINT ck_nre CHECK (nombrec_repartidor = INITCAP(nombrec_repartidor))
);

CREATE TABLE Repostajes (
    scooter VARCHAR2(6) NOT NULL,
    fecha_repostaje DATE NOT NULL,
    coste_repostaje NUMBER(3) NOT NULL,
    CONSTRAINT pk_Repostajes PRIMARY KEY (scooter, fecha_repostaje),
    CONSTRAINT fk_res_sco FOREIGN KEY (scooter) REFERENCES Scooters(scooter),
    CONSTRAINT ck_cre CHECK (coste_repostaje > = 0)
);

CREATE TABLE TiposPedidos (
    clase_pedido VARCHAR2(10) NOT NULL,
    incremento NUMBER(3),
    minimo NUMBER(4) NOT NULL,
    CONSTRAINT pk_TiposPedidos PRIMARY KEY (clase_pedido),
    CONSTRAINT ck_cla CHECK (clase_pedido IN ('L', 'R', 'D')),
    CONSTRAINT ck_inc CHECK (incremento > 0),
    CONSTRAINT ck_min CHECK (minimo > 0)
);

CREATE TABLE Pedidos (
    fecha_pedido DATE NOT NULL,
    pedido NUMBER(3) NOT NULL,
    clase_pedido VARCHAR2(10) NOT NULL,
    total_pedido NUMBER(4) NOT NULL,
    cliente NUMBER(5),
    dni_repartidor VARCHAR2(9),
    valor_receta NUMBER(4) NOT NULL,
    incremento NUMBER(3) NOT NULL,
    CONSTRAINT pk_Pedidos PRIMARY KEY (fecha_pedido, pedido),
    CONSTRAINT fK_ped_cli FOREIGN KEY (cliente) REFERENCES Clientes(cliente) ON DELETE CASCADE,
    CONSTRAINT fk_ped_rep FOREIGN KEY (dni_repartidor) REFERENCES Repartidores(dni_repartidor),
    CONSTRAINT fK_ped_tpe FOREIGN KEY (clase_pedido) REFERENCES TiposPedidos(clase_pedido) ON DELETE CASCADE,
    CONSTRAINT ck_vre CHECK (valor_receta > = 0),
    CONSTRAINT ck_int CHECK (incremento > = 0)
);

CREATE TABLE Regalos (
    regalo NUMBER(4) NOT NULL,
    motivo CHAR(1) NOT NULL,
    limite NUMBER(2) NOT NULL,
    CONSTRAINT pk_Regalos PRIMARY KEY (regalo, motivo),
    CONSTRAINT ck_mot CHECK (motivo IN ('C', 'P'))
);

CREATE TABLE ObsequiosC (
    regalo NUMBER(4) NOT NULL,
    motivo CHAR(1) NOT NULL,
    cliente NUMBER(5) NOT NULL,
    fecha_obsequio DATE NOT NULL,
    CONSTRAINT pk_ObsequiosC PRIMARY KEY (regalo, motivo, cliente, fecha_obsequio),
    CONSTRAINT fk_obsC_reg FOREIGN KEY (regalo, motivo) REFERENCES Regalos(regalo, motivo) ON DELETE CASCADE,
    CONSTRAINT fk_obsC_cli FOREIGN KEY (cliente) REFERENCES Clientes(cliente) ON DELETE CASCADE,
    CONSTRAINT ck_obsC_mot CHECK (motivo = 'C')
);

CREATE TABLE ObsequiosP (
    fecha_pedido DATE NOT NULL,
    pedido NUMBER(3) NOT NULL,
    regalo NUMBER(4) NOT NULL,
    motivo CHAR(1) NULL,
    CONSTRAINT pk_ObsequiosP PRIMARY KEY (fecha_pedido, pedido),
    CONSTRAINT fk_obsP_reg FOREIGN KEY (regalo, motivo) REFERENCES Regalos(regalo, motivo) ON DELETE CASCADE, 
    CONSTRAINT fk_obsP_ped FOREIGN KEY (fecha_pedido, pedido) REFERENCES Pedidos(fecha_pedido, pedido) ON DELETE CASCADE,
    CONSTRAINT ck_obsP_mot CHECK (motivo = 'P')
);

CREATE TABLE VentasProductos (
    fecha_pedido DATE NOT NULL,
    pedido NUMBER(3) NOT NULL,
    venta NUMBER(3) NOT NULL,
    articulo VARCHAR2(10) NOT NULL,
    tamano CHAR(1),
    unidades NUMBER(2),
    valor_venta NUMBER(4),
    CONSTRAINT pk_VentasProductos PRIMARY KEY (fecha_pedido, pedido, venta),
    CONSTRAINT fk_ven_ped FOREIGN KEY (fecha_pedido, pedido) REFERENCES Pedidos(fecha_pedido, pedido) ON DELETE CASCADE,
    CONSTRAINT fk_ven_art FOREIGN KEY (articulo, tamano) REFERENCES Articulos(articulo, tamano)
);

CREATE TABLE RecetasVenta (
    fecha_pedido DATE NOT NULL,
    pedido NUMBER(3) NOT NULL,
    venta NUMBER(3) NOT NULL,
    ingrediente VARCHAR2(4) NOT NULL,
    CONSTRAINT pk_RecetasVenta PRIMARY KEY (fecha_pedido, pedido, venta, ingrediente),
    CONSTRAINT fk_rve_ven FOREIGN KEY (fecha_pedido, pedido, venta) REFERENCES VentasProductos(fecha_pedido, pedido, venta) ON DELETE CASCADE,
    CONSTRAINT fk_rve_ing FOREIGN KEY (ingrediente) REFERENCES Ingredientes (ingrediente)
);
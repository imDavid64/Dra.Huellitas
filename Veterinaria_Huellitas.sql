-- 1. Creación tabla cliente: almacena info sobre los clientes.
create table cliente (
    id_cliente number generated as identity primary key, -- para que sea incremental
    nombre varchar2(50) not null,
    apellido varchar2(50) not null,
    telefono varchar2(20),
    email varchar2(50),
    direccion varchar2(255) -- podría ser solo ciudad
);

-- 2. Creación tabla mascota: almacena info sobre las mascotas de los clientes.
create table mascota (
    id_mascota number generated as identity primary key,
    nombre varchar2(50) not null,
    tipo varchar2(50) not null, -- (perro, gato, conejo, etc...)
    raza varchar2(50), -- agregar n/a si no aplica
    edad number, -- o será que lo modificamos a fecha nacimiento?
    peso number,
    sexo varchar2(10), -- Hembra, macho
    id_cliente number,
    constraint fk_mascota_cliente foreign key (id_cliente) references cliente (id_cliente)
);

-- 3. Creación tabla historial mascota: mantiene un historial sobre situaciones importantes de cada mascota
create table historial_mascota (
    id_historial number generated as identity primary key,
    id_mascota number,
    situacion varchar2(100), -- ejemplo consulta médica, vacunas, 
    descripcion varchar2(255), -- datos adicionales
    fecha date,
    constraint fk_hmascota_mascota foreign key (id_mascota) references mascota(id_mascota)
);

-- 4. Creación tabla empleado: almacena info sobre los empleados de la veterinaria.
create table empleado (
    id_empleado number generated as identity primary key,
    nombre varchar2(100) not null,
    apellido varchar2(100) not null,
    rol varchar2(50) check (rol in ('Veterinario', 'Administrativo')), -- ver que otros roles aplican para incluirlos
    telefono varchar2(20),
    email varchar2(50),
    salario number -- debería usar money? 
);

-- 5. Creación tabla consulta: almacena info sobre las consultas al veterinario de cada mascota.
create table consulta (
    id_consulta number generated as identity primary key,
    id_mascota number,
    id_empleado number,
    fecha date,
    motivo varchar2(255),
    diagnostico varchar2(255),
    tratamiento varchar2(255),
    constraint fk_consulta_mascota foreign key (id_mascota) references mascota(id_mascota),
    constraint fk_consulta_empleado foreign key (id_empleado) references empleado(id_empleado)
);

/* 6. Creación tabla tratamiento: en caso de que alguna mascota deba seguir algún tratamiento, 
almacena info relevante sobre esto.*/
create table tratamiento (
    id_tratamiento number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    id_consulta number,
    constraint fk_tratamiento_consulta foreign key (id_consulta) references consulta(id_consulta)
);

-- 7. Creación tabla medicamento: almacena info sobre las medicinas de acuerdo al tratamiento indicado.
create table medicamento (
    id_medicamento number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    dosis varchar2(50),
    id_tratamiento number,
    constraint fk_medicamento_tratamiento foreign key (id_tratamiento) references tratamiento(id_tratamiento)
);

-- 8. Creación tabla Cita: almacena info sobre las citas (ya sea que estén programadas, que hayan sido confirmadas, etc).
create table cita (
    id_cita number generated as identity primary key,
    id_cliente number,
    id_empleado number,
    fecha date,
    hora varchar2(10),
    estado varchar2(50) check (estado in ('Pendiente', 'Confirmada', 'Cancelada', 'No se presentó')), -- definir si lo dejamos con estados preestablecidos o mejor dejarlo abierto
    constraint fk_cita_cliente foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_cita_empleado foreign key (id_empleado) references empleado(id_empleado)
);


-- 9. Creación tabla producto: almacena info sobre los productos disponibles para la venta en la veterinaria.
create table producto (
    id_producto number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    precio number not null,
    stock number not null,
    tipo varchar2(50)
);

-- 10. Creación tabla servicio: almacena info sobre los servicios que tienen disponibles en la veterinaria (ejm: grooming, cirugías, etc).
create table servicio (
    id_servicio number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    precio number not null
);

-- 11. Creación tabla factura: almacena info de las facturas de los clientes.
create table factura (
    id_factura number generated as identity primary key,
    id_cliente number,
    fecha date,
    total number not null,
    id_metodo_pago number,
    estado_pago varchar2(50), -- será que mejor generamos un check? 
    constraint fk_factura_cliente foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_factura_metodo_pago foreign key (id_metodo_pago) references metodo_pago(id_metodo_pago)
);

-- 12. Creación tabla detalle factura: almacena info relevante sobre las facturas de los clientes.
create table detalle_factura (
    id_detalle number generated as identity primary key,
    id_factura number,
    id_producto number,
    id_servicio number,
    cantidad number not null, 
    precio_unitario number not null,
    subtotal number, -- mejorarlo para tener el total por medio de multiplicación
    constraint fk_detalle_factura_factura foreign key (id_factura) references factura(id_factura),
    constraint fk_detalle_factura_producto foreign key (id_producto) references producto(id_producto),
    constraint fk_detalle_factura_servicio foreign key (id_servicio) references servicio(id_servicio)
);

-- 13. Creación tabla proveedor: almacena info sobre los proveedores de los productos disponibles para la venta en la veterinaria.
create table proveedor (
    id_proveedor number generated as identity primary key,
    nombre varchar2(100) not null,
    telefono varchar2(20),
    email varchar2(100),
    direccion varchar2(100)
);

-- 14. Creación tabla orden compra: almacena info sobre las compras de productos que realiza la veterinaria.
create table orden_compra (
    id_orden_compra number generated as identity primary key,
    id_proveedor number,
    fecha date not null,
    total number not null,
    constraint fk_orden_compra_proveedor foreign key (id_proveedor) references proveedor(id_proveedor)
);

/* 15. Creación tabla producto orden compra: es una tabla intermedia entre productos y orden_compra, para llevar un registro
de los productos comprados a los proveedores */
create table producto_orden_compra (
    id_poc number generated as identity primary key,
    id_producto number,
    id_orden_compra number,
    cantidad number not null,
    costo number not null,
    constraint fk_producto_orden_compra_producto foreign key (id_producto) references producto(id_producto),
    constraint fk_producto_orden_compra_orden_compra foreign key (id_orden_compra) references orden_compra(id_orden_compra)
);

-- 16. Creación metodo de pago: almacena info sobre el método de pago.
create table metodo_pago (
    id_metodo_pago number generated as identity primary key,
    nombre varchar2(50) not null
);

-- 17. Creación tabla pago: almacena info sobre el pago, para tener conocimiento sobre los montos.
create table pago (
    id_pago number generated as identity primary key,
    id_factura number,
    monto number not null,
    fecha date,
    id_metodo_pago number,
    constraint fk_pago_factura foreign key (id_factura) references factura(id_factura),
    constraint fk_pago_metodo_pago foreign key (id_metodo_pago) references metodo_pago(id_metodo_pago)
);

-- 18. Creación tabla historial compra: almacena info el historial de compra de los clientes.
create table historial_compra (
    id_historial_compra number generated as identity primary key,
    id_cliente number not null,
    id_factura number not null,
    fecha date not null,
    total number not null,
    constraint fk_historial_compra_cliente foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_historial_compra_factura foreign key (id_factura) references factura(id_factura)
);

-- 19. Creación tabla historial servicia: almacena info del historial de servicios adquiridos por los clientes.
create table historial_servicio (
    id_historial_servicio number generated as identity primary key,
    id_cliente number,
    id_factura number,
    id_servicio number,
    fecha date not null,
    total number not null,
    constraint fk_historial_servicio_cliente foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_historial_servicio_factura foreign key (id_factura) references factura(id_factura),
    constraint fk_historial_servicio_servicio foreign key (id_servicio) references servicio(id_servicio)
);


-- 20. Creación tabla incidente: almacena info de incidentes ocurridos en la veterinaria
create table incidente (
    id_incidente number generated as identity primary key,
    id_mascota number null,
    id_empleado number null,
    descripcion varchar2(255),
    fecha date,
    estado varchar2(50),
    constraint fk_incidente_mascota foreign key (id_mascota) references mascota(id_mascota),
    constraint fk_incidente_empleado foreign key (id_empleado) references empleado(id_empleado)
);

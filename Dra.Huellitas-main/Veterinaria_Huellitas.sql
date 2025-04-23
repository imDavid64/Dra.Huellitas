-- 1. Creaci�n tabla cliente: almacena info sobre los clientes.
create table cliente (
    id_cliente number generated as identity primary key, -- para que sea incremental
    nombre varchar2(50) not null,
    apellido varchar2(50) not null,
    telefono varchar2(20),
    email varchar2(50),
    direccion varchar2(255) -- podr�a ser solo ciudad
);

-- 2. Creaci�n tabla mascota: almacena info sobre las mascotas de los clientes.
create table mascota (
    id_mascota number generated as identity primary key,
    nombre varchar2(50) not null,
    tipo varchar2(50) not null, -- (perro, gato, conejo, etc...)
    raza varchar2(50), -- agregar n/a si no aplica
    fecha_nacimiento date, -- o ser� que lo modificamos a fecha nacimiento?
    peso number,
    sexo varchar2(10), -- Hembra, macho
    id_cliente number,
    constraint fk_mascota_cliente foreign key (id_cliente) references cliente (id_cliente)
);

-- 3. Creaci�n tabla historial mascota: mantiene un historial sobre situaciones importantes de cada mascota
create table historial_mascota (
    id_historial number generated as identity primary key,
    id_mascota number,
    situacion varchar2(100), -- ejemplo consulta m�dica, vacunas, 
    descripcion varchar2(255), -- datos adicionales
    fecha date,
    constraint fk_hmascota_mascota foreign key (id_mascota) references mascota(id_mascota)
);

-- 4. Creaci�n tabla empleado: almacena info sobre los empleados de la veterinaria.
create table empleado (
    id_empleado number generated as identity primary key,
    nombre varchar2(100) not null,
    apellido varchar2(100) not null,
    rol varchar2(50) check (rol in ('Veterinario', 'Administrativo')), -- ver que otros roles aplican para incluirlos
    telefono varchar2(20),
    email varchar2(50),
    salario number -- deber�a usar money? 
);

-- 5. Creaci�n tabla consulta: almacena info sobre las consultas al veterinario de cada mascota.
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

/* 6. Creaci�n tabla tratamiento: en caso de que alguna mascota deba seguir alg�n tratamiento, 
almacena info relevante sobre esto.*/
create table tratamiento (
    id_tratamiento number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    id_consulta number,
    constraint fk_tratamiento_consulta foreign key (id_consulta) references consulta(id_consulta)
);

-- 7. Creaci�n tabla medicamento: almacena info sobre las medicinas de acuerdo al tratamiento indicado.
create table medicamento (
    id_medicamento number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    dosis varchar2(50),
    id_tratamiento number,
    constraint fk_medicamento_tratamiento foreign key (id_tratamiento) references tratamiento(id_tratamiento)
);

-- 8. Creaci�n tabla Cita: almacena info sobre las citas (ya sea que est�n programadas, que hayan sido confirmadas, etc).
create table cita (
    id_cita number generated as identity primary key,
    id_cliente number,
    id_empleado number,
    fecha date,
    hora varchar2(10),
    estado varchar2(50) check (estado in ('Pendiente', 'Confirmada', 'Cancelada', 'No se present�')), -- definir si lo dejamos con estados preestablecidos o mejor dejarlo abierto
    constraint fk_cita_cliente foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_cita_empleado foreign key (id_empleado) references empleado(id_empleado)
);


-- 9. Creaci�n tabla producto: almacena info sobre los productos disponibles para la venta en la veterinaria.
create table producto (
    id_producto number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    precio number not null,
    stock number not null,
    tipo varchar2(50)
);

-- 10. Creaci�n tabla servicio: almacena info sobre los servicios que tienen disponibles en la veterinaria (ejm: grooming, cirug�as, etc).
create table servicio (
    id_servicio number generated as identity primary key,
    nombre varchar2(100) not null,
    descripcion varchar2(255),
    precio number not null
);

-- 11. Creaci�n tabla factura: almacena info de las facturas de los clientes.
create table factura (
    id_factura number generated as identity primary key,
    id_cliente number,
    fecha date,
    total number not null,
    id_metodo_pago number,
    estado_pago varchar2(50), -- ser� que mejor generamos un check? 
    constraint fk_factura_cliente foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_factura_metodo_pago foreign key (id_metodo_pago) references metodo_pago(id_metodo_pago)
);

-- 12. Creaci�n tabla detalle producto: almacena info relevante sobre las facturas de los clientes.
CREATE TABLE detalle_producto (
    id_detalle_producto NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    id_factura NUMBER,
    id_producto NUMBER, -- Relación con el producto
    cantidad NUMBER NOT NULL,
    precio_unitario NUMBER NOT NULL,
    CONSTRAINT fk_detalle_producto_factura FOREIGN KEY (id_factura) REFERENCES factura(id_factura),
    CONSTRAINT fk_detalle_producto_producto FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- 13. Creaci�n tabla detalle producto: almacena info relevante sobre las facturas de los clientes.
CREATE TABLE detalle_servicio (
    id_detalle_servicio NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    id_factura NUMBER,
    id_servicio NUMBER, -- Relación con el servicio
    cantidad NUMBER NOT NULL,
    precio_unitario NUMBER NOT NULL,
    CONSTRAINT fk_detalle_servicio_factura FOREIGN KEY (id_factura) REFERENCES factura(id_factura),
    CONSTRAINT fk_detalle_servicio_servicio FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
);

-- 13. Creaci�n tabla proveedor: almacena info sobre los proveedores de los productos disponibles para la venta en la veterinaria.
create table proveedor (
    id_proveedor number generated as identity primary key,
    nombre varchar2(100) not null,
    telefono varchar2(20),
    email varchar2(100),
    direccion varchar2(100)
);

-- 14. Creaci�n tabla orden compra: almacena info sobre las compras de productos que realiza la veterinaria.
create table orden_compra (
    id_orden_compra number generated as identity primary key,
    id_proveedor number,
    fecha date not null,
    total number not null,
    constraint fk_orden_compra_proveedor foreign key (id_proveedor) references proveedor(id_proveedor)
);

/* 15. Creaci�n tabla producto orden compra: es una tabla intermedia entre productos y orden_compra, para llevar un registro
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

-- 16. Creaci�n metodo de pago: almacena info sobre el m�todo de pago.
create table metodo_pago (
    id_metodo_pago number generated as identity primary key,
    nombre varchar2(50) not null
);

-- 17. Creaci�n tabla pago: almacena info sobre el pago, para tener conocimiento sobre los montos.
create table pago (
    id_pago number generated as identity primary key,
    id_factura number,
    monto number not null,
    fecha date,
    id_metodo_pago number,
    constraint fk_pago_factura foreign key (id_factura) references factura(id_factura),
    constraint fk_pago_metodo_pago foreign key (id_metodo_pago) references metodo_pago(id_metodo_pago)
);

-- 18. Creaci�n tabla historial compra: almacena info el historial de compra de los clientes.
create table historial_compra (
    id_historial_compra number generated as identity primary key,
    id_cliente number not null,
    id_factura number not null,
    fecha date not null,
    total number not null,
    constraint fk_historial_compra_cliente foreign key (id_cliente) references cliente(id_cliente),
    constraint fk_historial_compra_factura foreign key (id_factura) references factura(id_factura)
);

-- 19. Creaci�n tabla historial servicia: almacena info del historial de servicios adquiridos por los clientes.
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


-- 20. Creaci�n tabla incidente: almacena info de incidentes ocurridos en la veterinaria
create table incidente (
    id_incidente number generated as identity primary key,
    id_mascota number null,
    id_empleado number null,
    id_cliente number null,
    descripcion varchar2(255),
    fecha date,
    estado varchar2(50),
    constraint fk_incidente_mascota foreign key (id_mascota) references mascota(id_mascota),
    constraint fk_incidente_empleado foreign key (id_empleado) references empleado(id_empleado),
    constraint fk_incidente_cliente foreign key (id_cliente) references cliente(id_cliente)
);





--------------------PROCEDIMEINTOS ALMACENADOS--------------------

-----1. AGREGAR CLIENTE-----
CREATE OR REPLACE PROCEDURE AGREGAR_CLIENTE (
    P_nombre IN VARCHAR2,
    P_apellido IN VARCHAR2,
    P_telefono IN NUMBER,
    P_email IN VARCHAR2,
    P_direccion IN VARCHAR2
) IS
BEGIN
    INSERT INTO CLIENTE (
        NOMBRE, APELLIDO, TELEFONO, EMAIL, DIRECCION
    ) VALUES (
        P_nombre, P_apellido, P_telefono, P_email, P_direccion
    );
END AGREGAR_CLIENTE;


-----2. AGREGAR MASCOTA-----
CREATE OR REPLACE PROCEDURE agregar_mascota (
    p_nombre IN VARCHAR2,
    p_tipo IN VARCHAR2,
    p_raza IN VARCHAR2,
    p_edad IN NUMBER,
    p_peso IN NUMBER,
    p_sexo IN VARCHAR2,
    p_id_cliente IN NUMBER
) IS
BEGIN
    INSERT INTO mascota (
        nombre, tipo, raza, edad, peso, sexo, id_cliente
    ) VALUES (
        p_nombre, p_tipo, p_raza, p_edad, p_peso, p_sexo, p_id_cliente
    );
END agregar_mascota;


-----3. AGREGAR HISTORIAL DE LA MASCOTA-----
CREATE OR REPLACE PROCEDURE AGREGAR_HISTORIAL_MASCOTA (
    P_id_mascota IN NUMBER,
    P_situacion IN VARCHAR2,
    P_descripcion IN VARCHAR2,
    P_fecha IN DATE
)IS
BEGIN
    INSERT INTO HISTORIAL_MASCOTA (
        ID_MASCOTA, SITUACION, DESCRIPCION, FECHA
    ) VALUES (
        P_id_mascota, P_situacion, P_descripcion, P_fecha
    );
END AGREGAR_HISTORIAL_MASCOTA;


-----4. AGREGAR CONSULTA-----
CREATE OR REPLACE PROCEDURE AGREGAR_CONSULTA (
    P_id_consulta IN NUMBER,
    P_id_mascota IN NUMBER,
    P_id_empleado IN NUMBER,
    P_id_cliente IN NUMBER,
    P_fecha IN DATE,
    P_motivo IN VARCHAR2,
    P_diagnostico IN VARCHAR2,
    P_tratamiento IN VARCHAR2
) IS
BEGIN
    INSERT INTO CONSULTA (
        FECHA, MOTIVO, diagnostico, ID_MASCOTA, ID_CLIENTE,ID_EMPLEADO
    ) VALUES (
        P_fecha, P_motivo, P_diagnostico, P_id_mascota, P_id_cliente, P_id_empleado
    );
END agregar_consulta;


-----5. AGREGAR TRATAMIENTO-----
CREATE OR REPLACE PROCEDURE AGREGAR_TRATAMIENTO (
    P_id_empleado IN NUMBER,
    P_nombre IN VARCHAR2,
    P_descripcion IN VARCHAR2,
    P_id_consulta IN NUMBER
) IS
BEGIN
    INSERT INTO TRATAMIENTO (
        ID_EMPLEADO, NOMBRE, DESCRIPCION, ID_CONSULTA
    )VALUES (
        P_id_empleado, P_nombre, P_descripcion, P_id_consulta
    );
END AGREGAR_TRATAMIENTO;


-----6. AGREGAR EMPLEADO-----
CREATE OR REPLACE PROCEDURE AGREGAR_EMPLEADO (
    P_nombre IN NUMBER,
    P_apellido IN VARCHAR2,
    P_rol IN VARCHAR2,
    P_telefono IN NUMBER,
    P_email IN VARCHAR2,
    P_salario IN NUMBER
)IS
BEGIN
    INSERT INTO EMPLEADO (
        NOMBRE, APELLIDO, ROL, TELEFONO, EMAIL, SALARIO
    ) VALUES (
        P_nombre, P_apellido, P_rol,  P_telefono, P_email, P_salario
    );
END AGREGAR_EMPLEADO;


-----7. AGREGAR MEDICAMIENTO-----
CREATE OR REPLACE PROCEDURE AGREGAR_MEDICAMENTO (
    P_NOMBRE IN VARCHAR2,
    P_DESCRIPCION IN VARCHAR2,
    P_DOSIS IN VARCHAR2,
    P_ID_TRATAMIENTO IN NUMBER
) IS
BEGIN
    INSERT INTO MEDICAMENTO (
        NOMBRE, DESCRIPCION, DOSIS, ID_TRATAMIENTO
    ) VALUES (
        P_NOMBRE, P_DESCRIPCION, P_DOSIS, P_ID_TRATAMIENTO
    );
END AGREGAR_MEDICAMENTO;

    
-----8. AGREGAR CITA-----
CREATE OR REPLACE PROCEDURE AGREGAR_CITA (
    P_ID_CLIENTE IN NUMBER,
    P_ID_EMPLEADO IN NUMBER,
    P_FECHA IN DATE,
    P_HORA IN VARCHAR2,
    P_ESTADO IN VARCHAR2
) IS
BEGIN
    INSERT INTO CITA (
        ID_CLIENTE, ID_EMPLEADO, FECHA, HORA, ESTADO
    ) VALUES (
        P_ID_CLIENTE, P_ID_EMPLEADO, P_FECHA, P_HORA, P_ESTADO
    );
END AGREGAR_CITA;


-----9. AGREGAR PRODUCTO-----
CREATE  OR REPLACE PROCEDURE AGREGAR_PRODUCTO (
    P_ID_PROVEEDOR IN NUMBER,
    P_NOMBRE IN VARCHAR2,
    P_DESCRIPCION IN VARCHAR2,
    P_PRECIO IN NUMBER,
    P_STOCK IN NUMBER,
    P_TIPO IN VARCHAR2
)IS
BEGIN
    INSERT INTO PRODUCTO (
        ID_PROVEEDOR, NOMBRE, DESCRIPCION, PRECIO, STOCK, TIPO
    ) VALUES (
        P_ID_PROVEEDOR, P_NOMBRE, P_DESCRIPCION, P_PRECIO, P_STOCK, P_TIPO
    );
END AGREGAR_PRODUCTO;


-----10. AGREGAR SERVICIO-----
CREATE  OR REPLACE PROCEDURE AGREGAR_SERVICIO (
    P_NOMBRE IN VARCHAR2,
    P_DESCRIPCION IN VARCHAR2,
    P_PRECIO IN NUMBER
)IS
BEGIN
    INSERT INTO SERVICIO (
        NOMBRE, DESCRIPCION, PRECIO
    ) VALUES (
        P_NOMBRE, P_DESCRIPCION, P_PRECIO
    );

END AGREGAR_SERVICIO;


-----11. AGREGAR PROVEEDOR-----
CREATE  OR REPLACE PROCEDURE AGREGAR_PROVEEDOR (
    P_NOMBRE IN VARCHAR2,
    P_TELEFONO IN NUMBER,
    P_EMAIL IN VARCHAR2,
    P_DIRECCION IN VARCHAR2
)IS
BEGIN
    INSERT INTO PROVEEDOR (
        NOMBRE, TELEFONO, EMAIL, DIRECCION
    ) VALUES (
        P_NOMBRE, P_TELEFONO, P_EMAIL, P_DIRECCION
    );
END AGREGAR_PROVEEDOR;


-----12. AGREGAR INCIDENTE-----
CREATE OR REPLACE PROCEDURE AGREGAR_INCIDENTE (
    P_ID_MASCOTA IN NUMBER,
    P_ID_EMPLEADO IN NUMBER,
    P_ID_CLIENTE IN NUMBER,
    P_DESCRIPCION IN VARCHAR2,
    P_FECHA DATE,
    P_ESTADO VARCHAR2
)IS
BEGIN
    INSERT INTO INCIDENTE(
        ID_MASCOTA, ID_EMPLEADO, ID_CLIENTE, DESCRIPCION, FECHA, ESTADO
    ) VALUES (
        P_ID_MASCOTA, P_ID_EMPLEADO, P_ID_CLIENTE, P_DESCRIPCION, P_FECHA, P_ESTADO
    );
END AGREGAR_INCIDENTE;


----13. Cursor Cliente Mascota-----
CREATE OR REPLACE PROCEDURE obtener_cliente_mascotas AS
    CURSOR c_clientes_mascotas IS 
        SELECT c.id_cliente, c.nombre AS nombre_cliente, m.nombre AS mascota, m.tipo
        FROM cliente c
        JOIN mascota m ON c.id_cliente = m.id_cliente;
BEGIN
    FOR r IN c_clientes_mascotas LOOP
        DBMS_OUTPUT.PUT_LINE('ID Cliente: ' || r.id_cliente || 
                             ', Nombre Cliente: ' || r.nombre_cliente || 
                             ', Mascota: ' || r.mascota || 
                             ', Tipo: ' || r.tipo);
    END LOOP;
END obtener_cliente_mascotas;

----14. Cursor Obtner consulta----
CREATE OR REPLACE PROCEDURE obtener_consulta AS
    CURSOR o_obtener_consulta IS 
        SELECT id_consulta, id_mascota, id_empleado, id_cliente, fecha, motivo, diagnostico, 
               'Tratamiento pendiente' AS tratamiento
        FROM consulta;
BEGIN
    FOR r IN o_obtener_consulta LOOP
        DBMS_OUTPUT.PUT_LINE('ID Consulta: ' || r.id_consulta || 
                             ', ID Mascota: ' || r.id_mascota || 
                             ', ID Empleado: ' || r.id_empleado || 
                             ', ID Cliente: ' || r.id_cliente || 
                             ', Fecha: ' || TO_CHAR(r.fecha, 'YYYY-MM-DD') || 
                             ', Motivo: ' || r.motivo || 
                             ', Diagnóstico: ' || r.diagnostico || 
                             ', Tratamiento: ' || r.tratamiento);
    END LOOP;
END obtener_consulta;

---15. Cursor Obtener medicamento----
CREATE OR REPLACE PROCEDURE obtener_medicamento AS
    CURSOR o_obtener_medicamento IS 
        SELECT id_medicamento, nombre, descripcion, dosis, id_tratamiento
        FROM medicamento;
BEGIN
    FOR r IN o_obtener_medicamento LOOP
        DBMS_OUTPUT.PUT_LINE('ID Medicamento: ' || r.id_medicamento || 
                             ', Nombre: ' || r.nombre || 
                             ', Descripción: ' || r.descripcion || 
                             ', Dosis: ' || r.dosis || 
                             ', ID Tratamiento: ' || r.id_tratamiento);
    END LOOP;
END obtener_medicamento;
/
---16. Cursor Obtener Productos---
CREATE OR REPLACE PROCEDURE obtener_producto AS
    CURSOR o_obtener_producto IS 
        SELECT id_producto, id_proveedor, nombre, descripcion, precio, stock, tipo
        FROM producto;
BEGIN
    FOR r IN o_obtener_producto LOOP
        DBMS_OUTPUT.PUT_LINE('ID Producto: ' || r.id_producto || 
                             ', ID Proveedor: ' || r.id_proveedor|| 
                             ', Nombre: ' || r.nombre || 
                             ', Descripción: ' || r.descripcion || 
                             ', Precio: ' || r.precio || 
                             ', Stock: ' || r.stock || 
                             ', Tipo: ' || r.tipo);
    END LOOP;
END obtener_producto;

---17. Cursor Obtener Servicios---
CREATE OR REPLACE PROCEDURE obtener_servicio AS
    CURSOR o_obtener_servicio IS 
        SELECT id_servicio, nombre, descripcion, precio
        FROM servicio;
BEGIN
    FOR r IN o_obtener_servicio LOOP
        DBMS_OUTPUT.PUT_LINE('ID Servicio: ' || r.id_servicio || 
                             ', Nombre: ' || r.nombre || 
                             ', Descripción: ' || r.descripcion || 
                             ', Precio: ' || r.precio);
    END LOOP;
END obtener_servicio;

---18. Cursosr obtener factura---
CREATE OR REPLACE PROCEDURE obtener_factura AS
    CURSOR o_obtener_factura IS 
        SELECT id_factura, id_cliente, fecha, total, id_metodo_pago, estado_pago
        FROM factura;
BEGIN
    FOR r IN o_obtener_factura LOOP
        DBMS_OUTPUT.PUT_LINE('ID Factura: ' || r.id_factura || 
                             ', ID Cliente: ' || r.id_cliente || 
                             ', Fecha: ' || r.fecha || 
                             ', Total: ' || r.total || 
                             ', ID Método de Pago: ' || r.id_metodo_pago || 
                             ', Estado de Pago: ' || r.estado_pago);
    END LOOP;
END obtener_factura;



---19. Cursosr Obtener provedores--
CREATE OR REPLACE PROCEDURE obtener_proveedor AS
    CURSOR o_obtener_proveedor IS 
        SELECT id_proveedor, nombre, telefono, email, direccion
        FROM proveedor;
BEGIN
    FOR r IN o_obtener_proveedor LOOP
        DBMS_OUTPUT.PUT_LINE('ID Proveedor: ' || r.id_proveedor || 
                             ', Nombre: ' || r.nombre || 
                             ', Teléfono: ' || r.telefono || 
                             ', Email: ' || r.email || 
                             ', Dirección: ' ||r.direccion);
    END LOOP;
END obtener_proveedor;



---20. Cursor factura y detalle producto---
CREATE OR REPLACE PROCEDURE obtener_factura_productos AS
    CURSOR c_factura_productos IS 
        SELECT f.id_factura, f.fecha, f.total, f.estado_pago, 
               dp.id_producto, cantidad, dp.precio_unitario
        FROM factura f
        JOIN detalle_producto dp ON f.id_factura = dp.id_factura;
BEGIN
    FOR r IN c_factura_productos LOOP
        DBMS_OUTPUT.PUT_LINE('ID Factura: ' || r.id_factura || 
                             ', Fecha: ' || r.fecha || 
                             ', Total: ' || r.total || 
                             ', Estado de Pago: ' || r.estado_pago || 
                             ', ID Producto: ' || r.id_producto || 
                             ', Cantidad: ' || r.cantidad || 
                             ', Precio Unitario: ' || r.precio_unitario);
    END LOOP;
END obtener_factura_productos;



---21. Cursor factura y detalle Servicio---
CREATE OR REPLACE PROCEDURE obtener_factura_servicios AS
    CURSOR c_factura_servicios IS 
        SELECT f.id_factura, f.fecha, f.total, f.estado_pago, 
               ds.id_servicio, ds.cantidad, ds.precio_unitario
        FROM factura f
        JOIN detalle_servicio ds ON f.id_factura = ds.id_factura;
BEGIN
    FOR r IN c_factura_servicios LOOP
        DBMS_OUTPUT.PUT_LINE('ID Factura: ' || r.id_factura || 
                             ', Fecha: ' || r.fecha || 
                             ', Total: ' || r.total || 
                             ', Estado de Pago: ' || r.estado_pago || 
                             ', ID Servicio: ' || r.id_servicio || 
                             ', Cantidad: ' || r.cantidad || 
                             ', Precio Unitario: ' || r.precio_unitario);
    END LOOP;
END obtener_factura_servicios;


---22. Cursor Buscar Cliente---
CREATE OR REPLACE PROCEDURE BUSCAR_CLIENTE (
    P_NOMBRE IN VARCHAR2,
    P_APELLIDO IN VARCHAR2,
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT ID_CLIENTE, NOMBRE, APELLIDO, TELEFONO, EMAIL, DIRECCION
        FROM CLIENTE
        WHERE NOMBRE LIKE '%' || P_NOMBRE || '%' 
           OR APELLIDO LIKE '%' || P_APELLIDO || '%';
END BUSCAR_CLIENTE;


---23. Cursor Buscar Mascota---
CREATE OR REPLACE PROCEDURE BUSCAR_MASCOTA (
    P_NOMBRE IN VARCHAR2,
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT ID_MASCOTA, NOMBRE, TIPO, RAZA, EDAD, PESO, SEXO, ID_CLIENTE
        FROM MASCOTA
        WHERE NOMBRE LIKE '%' || P_NOMBRE || '%';  -- BÚSQUEDA POR NOMBRE
END BUSCAR_MASCOTA;


---24. Cursor Buscar Empleado---
CREATE OR REPLACE PROCEDURE BUSCAR_EMPLEADO (
    P_NOMBRE IN VARCHAR2,
    P_APELLIDO IN VARCHAR2,
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT ID_EMPLEADO, NOMBRE, APELLIDO, ROL, TELEFONO, EMAIL, SALARIO
        FROM EMPLEADO
        WHERE NOMBRE LIKE '%' || P_NOMBRE || '%'
           OR APELLIDO LIKE '%' || P_APELLIDO || '%';
END BUSCAR_EMPLEADO;


---25. Cursor Buscar Medicamento---
CREATE OR REPLACE PROCEDURE BUSCAR_MEDICAMENTO (
    P_NOMBRE IN VARCHAR2,
    P_DESCRIPCION IN VARCHAR2,
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT ID_MEDICAMENTO, NOMBRE, DESCRIPCION, DOSIS, ID_TRATAMIENTO
        FROM MEDICAMENTO
        WHERE NOMBRE LIKE '%' || P_NOMBRE || '%'
           OR DESCRIPCION LIKE '%' || P_DESCRIPCION || '%';
END BUSCAR_MEDICAMENTO;


---26. Cursor Buscar Citas---
CREATE OR REPLACE PROCEDURE BUSCAR_CITAS (
    P_FECHA IN DATE,
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT ID_CITA, ID_CLIENTE, ID_EMPLEADO, FECHA, HORA, ESTADO
        FROM CITA
        WHERE FECHA = P_FECHA;  -- BÚSQUEDA EXACTA POR FECHA
END BUSCAR_CITAS;

---27. Cursor Buscar Productos---
CREATE OR REPLACE PROCEDURE BUSCAR_PRODUCTO (
    P_NOMBRE IN VARCHAR2,
    P_DESCRIPCION IN VARCHAR2,
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT ID_PRODUCTO, ID_PROVEEDOR, NOMBRE, DESCRIPCION, PRECIO, STOCK, TIPO
        FROM PRODUCTO
        WHERE NOMBRE LIKE '%' || P_NOMBRE || '%'
           OR DESCRIPCION LIKE '%' || P_DESCRIPCION || '%';
END BUSCAR_PRODUCTO;

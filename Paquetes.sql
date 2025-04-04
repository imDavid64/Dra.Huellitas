--------------------PAQUETES--------------------
-- 1. Paquete de clientes
CREATE OR REPLACE PACKAGE pkg_cliente AS
    PROCEDURE AGREGAR_CLIENTE (
        P_nombre IN VARCHAR2,
        P_apellido IN VARCHAR2,
        P_telefono IN NUMBER,
        P_email IN VARCHAR2,
        P_direccion IN VARCHAR2
    );

    PROCEDURE BUSCAR_CLIENTE (
        P_NOMBRE IN VARCHAR2,
        P_APELLIDO IN VARCHAR2,
        P_CURSOR OUT SYS_REFCURSOR
    );
END pkg_cliente;

CREATE OR REPLACE PACKAGE BODY pkg_cliente AS
    PROCEDURE AGREGAR_CLIENTE (
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

    PROCEDURE BUSCAR_CLIENTE (
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
END pkg_cliente;

-- 2. Paquete de mascotas
CREATE OR REPLACE PACKAGE pkg_mascota AS
    PROCEDURE agregar_mascota (
        p_nombre IN VARCHAR2,
        p_tipo IN VARCHAR2,
        p_raza IN VARCHAR2,
        p_fecha_nacimiento IN DATE,
        p_peso IN NUMBER,
        p_sexo IN VARCHAR2,
        p_id_cliente IN NUMBER
    );

    PROCEDURE BUSCAR_MASCOTA (
        P_NOMBRE IN VARCHAR2,
        P_CURSOR OUT SYS_REFCURSOR
    );
END pkg_mascota;

CREATE OR REPLACE PACKAGE BODY pkg_mascota AS
    PROCEDURE agregar_mascota (
        p_nombre IN VARCHAR2,
        p_tipo IN VARCHAR2,
        p_raza IN VARCHAR2,
        p_fecha_nacimiento IN DATE,
        p_peso IN NUMBER,
        p_sexo IN VARCHAR2,
        p_id_cliente IN NUMBER
    ) IS
    BEGIN
        INSERT INTO mascota (
            nombre, tipo, raza, fecha_nacimiento, peso, sexo, id_cliente
        ) VALUES (
            p_nombre, p_tipo, p_raza, p_fecha_nacimiento, p_peso, p_sexo, p_id_cliente
        );
END agregar_mascota;

    PROCEDURE BUSCAR_MASCOTA (
        P_NOMBRE IN VARCHAR2,
        P_CURSOR OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN P_CURSOR FOR
            SELECT ID_MASCOTA, NOMBRE, TIPO, RAZA, FECHA_NACIMIENTO, PESO, SEXO, ID_CLIENTE
            FROM MASCOTA
            WHERE NOMBRE LIKE '%' || P_NOMBRE || '%';
    END BUSCAR_MASCOTA;
END pkg_mascota;

-- 3. Paquete de empleados
CREATE OR REPLACE PACKAGE pkg_empleado AS
    PROCEDURE AGREGAR_EMPLEADO (
        P_nombre IN NUMBER,
        P_apellido IN VARCHAR2,
        P_rol IN VARCHAR2,
        P_telefono IN NUMBER,
        P_email IN VARCHAR2,
        P_salario IN NUMBER
    );

    PROCEDURE BUSCAR_EMPLEADO (
        P_NOMBRE IN VARCHAR2,
        P_APELLIDO IN VARCHAR2,
        P_CURSOR OUT SYS_REFCURSOR
    );
END pkg_empleado;

CREATE OR REPLACE PACKAGE BODY pkg_empleado AS
    PROCEDURE AGREGAR_EMPLEADO (
        P_nombre IN NUMBER,
        P_apellido IN VARCHAR2,
        P_rol IN VARCHAR2,
        P_telefono IN NUMBER,
        P_email IN VARCHAR2,
        P_salario IN NUMBER
    ) IS
    BEGIN
        INSERT INTO EMPLEADO (
            NOMBRE, APELLIDO, ROL, TELEFONO, EMAIL, SALARIO
        ) VALUES (
            P_nombre, P_apellido, P_rol,  P_telefono, P_email, P_salario
        );
    END AGREGAR_EMPLEADO;
    
    PROCEDURE BUSCAR_EMPLEADO (
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
END pkg_empleado;

-- 4. Paquete de consultas veterinarias
CREATE OR REPLACE PACKAGE pkg_consulta AS
    PROCEDURE AGREGAR_CONSULTA (
        P_id_consulta IN NUMBER,
        P_id_mascota IN NUMBER,
        P_id_empleado IN NUMBER,
        P_id_cliente IN NUMBER,
        P_fecha IN DATE,
        P_motivo IN VARCHAR2,
        P_diagnostico IN VARCHAR2,
        P_tratamiento IN VARCHAR2
    );
END pkg_consulta;

CREATE OR REPLACE PACKAGE BODY pkg_consulta AS
    PROCEDURE AGREGAR_CONSULTA (
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
END pkg_consulta;

-- 5. Paquete de tratamientos
CREATE OR REPLACE PACKAGE pkg_tratamiento AS
    PROCEDURE AGREGAR_TRATAMIENTO (
        P_id_empleado IN NUMBER,
        P_nombre IN VARCHAR2,
        P_descripcion IN VARCHAR2,
        P_id_consulta IN NUMBER
    );
END pkg_tratamiento;

CREATE OR REPLACE PACKAGE BODY pkg_tratamiento AS
    PROCEDURE AGREGAR_TRATAMIENTO (
        P_id_empleado IN NUMBER,
        P_nombre IN VARCHAR2,
        P_descripcion IN VARCHAR2,
        P_id_consulta IN NUMBER
    ) IS
    BEGIN
        INSERT INTO TRATAMIENTO (
            ID_EMPLEADO, NOMBRE, DESCRIPCION, ID_CONSULTA
        ) VALUES (
            P_id_empleado, P_nombre, P_descripcion, P_id_consulta
        );
    END AGREGAR_TRATAMIENTO;
END pkg_tratamiento;

-- 6. Paquete de medicamentos
CREATE OR REPLACE PACKAGE pkg_medicamento AS
    PROCEDURE AGREGAR_MEDICAMENTO (
        P_NOMBRE IN VARCHAR2,
        P_DESCRIPCION IN VARCHAR2,
        P_DOSIS IN VARCHAR2,
        P_ID_TRATAMIENTO IN NUMBER
    );
END pkg_medicamento;

CREATE OR REPLACE PACKAGE BODY pkg_medicamento AS
    PROCEDURE AGREGAR_MEDICAMENTO (
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
END pkg_medicamento;

-- 7. Paquete de citas
CREATE OR REPLACE PACKAGE pkg_citas AS
    PROCEDURE AGREGAR_CITA (
        P_ID_CLIENTE IN NUMBER,
        P_ID_EMPLEADO IN NUMBER,
        P_FECHA IN DATE,
        P_HORA IN VARCHAR2,
        P_ESTADO IN VARCHAR2
    );
END pkg_citas;

CREATE OR REPLACE PACKAGE BODY pkg_citas AS
    PROCEDURE AGREGAR_CITA (
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
END pkg_citas;

-- 8. Paquete de facturas y pagos
CREATE OR REPLACE PACKAGE pkg_factura AS
    PROCEDURE obtener_factura;
    PROCEDURE obtener_factura_productos;
    PROCEDURE obtener_factura_servicios;
END pkg_factura;

CREATE OR REPLACE PACKAGE BODY pkg_factura AS
    PROCEDURE obtener_factura AS
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

    PROCEDURE obtener_factura_productos AS
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

    PROCEDURE obtener_factura_servicios AS
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
END pkg_factura;

-- 9. Paquete de productos
CREATE OR REPLACE PACKAGE pkg_productos AS
    PROCEDURE BUSCAR_PRODUCTO (
        P_NOMBRE IN VARCHAR2,
        P_DESCRIPCION IN VARCHAR2,
        P_CURSOR OUT SYS_REFCURSOR
    );
END pkg_productos;

CREATE OR REPLACE PACKAGE BODY pkg_productos AS
    PROCEDURE BUSCAR_PRODUCTO (
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
END pkg_productos;


-- 10. Paquete de historial de consultas y de compras
CREATE OR REPLACE PACKAGE pkg_historial AS
    PROCEDURE obtener_historial_consultas;
    PROCEDURE obtener_historial_compras;
END pkg_historial;

CREATE OR REPLACE PACKAGE BODY pkg_historial AS
    PROCEDURE obtener_historial_consultas IS
        CURSOR c_historial_consultas IS
            SELECT h.id_historial, m.nombre as Mascota, h.situacion, h.descripcion, h.fecha
            FROM historial_mascota h
            JOIN mascota m ON h.id_mascota = m.id_mascota;
    BEGIN
        FOR r IN c_historial_consultas LOOP
            DBMS_OUTPUT.PUT_LINE('ID Historial: ' || r.id_historial ||
                                 ', Mascota: ' || r.mascota ||
                                 ', Situación: ' || R.SITUACION ||
                                 ', Descripción: ' || r.descripcion ||
                                 ', Fecha: ' || TO_CHAR(r.fecha, 'YYYY-MM-DD'));
        END LOOP;
    END obtener_historial_consultas;

    PROCEDURE obtener_historial_compras IS
        CURSOR c_historial_compras IS
            SELECT h.id_historial_compra, c.nombre as Cliente, h.fecha, h.total
            FROM historial_compra h
            JOIN cliente c ON h.id_cliente = c.id_cliente;
    BEGIN
        FOR r IN c_historial_compras LOOP
            DBMS_OUTPUT.PUT_LINE('ID Historial Compra: ' || r.id_historial_compra ||
                                 ', Cliente: ' || r.cliente ||
                                 ', Fecha: ' || TO_CHAR(r.fecha, 'YYYY-MM-DD') ||
                                 ', Total: ' || r.total);
        END LOOP;
    END obtener_historial_compras;
END pkg_historial;

-- 11. Paquete de proveedores
CREATE OR REPLACE PACKAGE pkg_proveedor AS
    PROCEDURE BUSCAR_PROVEEDOR (
        P_NOMBRE IN VARCHAR2,
        P_CURSOR OUT SYS_REFCURSOR
    );
END pkg_proveedor;

CREATE OR REPLACE PACKAGE BODY pkg_proveedor AS
    PROCEDURE buscar_proveedor (
        p_nombre IN VARCHAR2,
        p_cursor OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN p_cursor FOR
            select id_proveedor, nombre, telefono, email, direccion
            from proveedor
            where nombre like '%' || p_nombre || '%';
    END buscar_proveedor;
END pkg_proveedor;

-- 12. Paquete de incidentes
CREATE OR REPLACE PACKAGE pkg_incidentes AS
    PROCEDURE AGREGAR_INCIDENTE (
        P_ID_MASCOTA IN NUMBER,
        P_ID_EMPLEADO IN NUMBER,
        P_ID_CLIENTE IN NUMBER,
        P_DESCRIPCION IN VARCHAR2,
        P_FECHA IN DATE,
        P_ESTADO IN VARCHAR2
    );
END pkg_incidentes;

CREATE OR REPLACE PACKAGE BODY pkg_incidentes AS
    PROCEDURE AGREGAR_INCIDENTE (
        P_ID_MASCOTA IN NUMBER,
        P_ID_EMPLEADO IN NUMBER,
        P_ID_CLIENTE IN NUMBER,
        P_DESCRIPCION IN VARCHAR2,
        P_FECHA IN DATE,
        P_ESTADO IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO INCIDENTE(
            ID_MASCOTA, ID_EMPLEADO, ID_CLIENTE, DESCRIPCION, FECHA, ESTADO
        ) VALUES (
            P_ID_MASCOTA, P_ID_EMPLEADO, P_ID_CLIENTE, P_DESCRIPCION, P_FECHA, P_ESTADO
        );
    END AGREGAR_INCIDENTE;
END pkg_incidentes;


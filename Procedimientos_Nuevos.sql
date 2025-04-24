-- Crear Factura
CREATE OR REPLACE PROCEDURE CREAR_FACTURA (
    P_ID_CLIENTE IN NUMBER,
    P_TOTAL_A_CANCELAR IN NUMBER,
    P_ID_METODO_PAGO IN NUMBER,
    P_ESTADO_PAGO IN VARCHAR2,
    P_ID_FACTURA OUT NUMBER
) IS
BEGIN
    INSERT INTO factura (
        id_cliente, 
        fecha, 
        total_a_cancelar, 
        id_metodo_pago, 
        estado_pago,
        total_cancelado,
        total_pendiente
    ) VALUES (
        P_ID_CLIENTE,
        SYSDATE,
        P_TOTAL_A_CANCELAR,
        P_ID_METODO_PAGO,
        P_ESTADO_PAGO,
        0, -- total_cancelado inicial en 0
        P_TOTAL_A_CANCELAR -- al principio, todo est� pendiente
    )
    RETURNING id_factura INTO P_ID_FACTURA;
END;

-- Agregar detalle producto
CREATE OR REPLACE PROCEDURE AGREGAR_DETALLE_PRODUCTO (
    P_ID_FACTURA IN NUMBER,
    P_ID_PRODUCTO IN NUMBER,
    P_CANTIDAD IN NUMBER,
    P_PRECIO_UNITARIO IN NUMBER
) IS
BEGIN
    INSERT INTO detalle_producto (id_factura, id_producto, cantidad, precio_unitario)
    VALUES (P_ID_FACTURA, P_ID_PRODUCTO, P_CANTIDAD, P_PRECIO_UNITARIO);
END;

-- Actualizar el stock en producto
CREATE OR REPLACE PROCEDURE ACTUALIZAR_STOCK_PRODUCTO (
    P_ID_PRODUCTO IN NUMBER,
    P_CANTIDAD_VENDIDA IN NUMBER
) IS
BEGIN
    UPDATE producto
    SET stock = stock - P_CANTIDAD_VENDIDA
    WHERE id_producto = P_ID_PRODUCTO;
END;

-- registrar pago
CREATE OR REPLACE PROCEDURE REGISTRAR_PAGO (
    P_ID_FACTURA IN NUMBER,
    P_MONTO IN NUMBER,
    P_ID_METODO_PAGO IN NUMBER
) IS
BEGIN
    INSERT INTO pago (id_factura, monto, fecha, id_metodo_pago)
    VALUES (P_ID_FACTURA, P_MONTO, SYSDATE, P_ID_METODO_PAGO);
END;

-- insertar en historial compra
CREATE OR REPLACE PROCEDURE INSERTAR_HISTORIAL_COMPRA (
    P_ID_CLIENTE IN NUMBER,
    P_ID_FACTURA IN NUMBER,
    P_TOTAL IN NUMBER
) IS
BEGIN
    INSERT INTO historial_compra (id_cliente, id_factura, fecha, total)
    VALUES (P_ID_CLIENTE, P_ID_FACTURA, SYSDATE, P_TOTAL);
END;


-- Tabla de Factura
ALTER TABLE FACTURA RENAME COLUMN TOTAL TO TOTAL_A_CANCELAR;

-- Tabla de Factur
ALTER TABLE FACTURA ADD (
    TOTAL_CANCELADO NUMBER DEFAULT 0,
    TOTAL_PENDIENTE NUMBER DEFAULT 0
);

-- Obtener los m�todos de pago que tenemos
CREATE OR REPLACE PROCEDURE OBTENER_METODOS_PAGO (
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT id_metodo_pago, nombre FROM metodo_pago;
END;

-- Obtener los ids de factura
CREATE OR REPLACE PROCEDURE OBTENER_IDS_FACTURA (
    P_CURSOR OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN P_CURSOR FOR
        SELECT id_factura FROM factura;
END;

-- obtener el total a cancelar
CREATE OR REPLACE PROCEDURE OBTENER_MONTO_TOTAL (
    P_ID_FACTURA IN NUMBER,
    P_MONTO OUT NUMBER
) IS
BEGIN
    SELECT TOTAL_A_CANCELAR INTO P_MONTO
    FROM FACTURA
    WHERE ID_FACTURA = P_ID_FACTURA;
END;


-- actualizar estado pago
CREATE OR REPLACE TRIGGER trg_actualizar_estado_pago
BEFORE UPDATE OF total_cancelado ON factura
FOR EACH ROW
BEGIN
    -- Calcular el nuevo total pendiente
    :NEW.total_pendiente := :NEW.total_a_cancelar - :NEW.total_cancelado;

    -- Si ya se pag� todo, actualizar el estado
    IF :NEW.total_pendiente = 0 THEN
        :NEW.estado_pago := 'Pagado';
    END IF;
END;

-- Actualizar el monto en la factura
CREATE OR REPLACE NONEDITIONABLE PROCEDURE ACTUALIZAR_MONTO_FACTURA (
    P_ID_FACTURA IN NUMBER,
    P_MONTO_CANCELADO IN NUMBER,
    P_ID_METODO_PAGO IN NUMBER
)
IS
    V_ESTADO VARCHAR2(20);
BEGIN
    -- Obtener el estado actual de la factura
    SELECT estado_pago INTO V_ESTADO
    FROM factura
    WHERE id_factura = P_ID_FACTURA;

    -- Validar si ya est� pagada
    IF V_ESTADO = 'Pagado' THEN
        -- Opcional: lanzar un error personalizado
        RAISE_APPLICATION_ERROR(-20001, 'La factura ya est� cancelada.');
    ELSE
        -- Si no est� pagada, actualizar monto y m�todo
        UPDATE factura
        SET total_cancelado = P_MONTO_CANCELADO,
            id_metodo_pago = P_ID_METODO_PAGO
        WHERE id_factura = P_ID_FACTURA;
    END IF;
END;

INSERT INTO METODO_PAGO (NOMBRE) VALUES ('TARJETA DE CREDITO');
INSERT INTO METODO_PAGO (NOMBRE) VALUES ('EFECTIVO');


GRANT CREATE TRIGGER TO DraHuellitas;

GRANT CONNECT, RESOURCE TO DraHuellitas;
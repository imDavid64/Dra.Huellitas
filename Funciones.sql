--Obtener el nombre de una mascota por su ID
CREATE OR REPLACE FUNCTION obtener_nombre_mascota(p_id_mascota NUMBER) RETURN VARCHAR2 IS
    v_nombre_mascota VARCHAR2(50);
BEGIN
    SELECT nombre INTO v_nombre_mascota
    FROM mascota
    WHERE id_mascota = p_id_mascota;

    RETURN v_nombre_mascota;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Mascota no encontrada';
END;

--Calcular el total facturado de un cliente
CREATE OR REPLACE FUNCTION total_facturado_cliente(p_id_cliente NUMBER) RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT NVL(SUM(total), 0) INTO v_total
    FROM factura
    WHERE id_cliente = p_id_cliente;

    RETURN v_total;
END;

--Obtener el número de citas de un veterinario
CREATE OR REPLACE FUNCTION cantidad_citas_veterinario(p_id_empleado NUMBER) RETURN NUMBER IS
    v_cantidad NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_cantidad
    FROM cita
    WHERE id_empleado = p_id_empleado;

    RETURN v_cantidad;
END;

--Verificar si un cliente ha comprado un medicamento específico
CREATE OR REPLACE FUNCTION verificar_compra_medicamento(p_id_cliente NUMBER, p_id_medicamento NUMBER) RETURN VARCHAR2 IS
    v_resultado VARCHAR2(3);
BEGIN
    SELECT CASE
             WHEN COUNT(*) > 0 THEN 'Sí'
             ELSE 'No'
           END INTO v_resultado
    FROM factura f
    JOIN consulta c ON f.id_cliente = c.id_cliente
    JOIN tratamiento t ON c.id_consulta = t.id_consulta
    JOIN medicamento m ON t.id_tratamiento = m.id_tratamiento
    WHERE f.id_cliente = p_id_cliente
      AND m.id_medicamento = p_id_medicamento;

    RETURN v_resultado;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No';
END;

--Calcular el total de citas en un rango de fechas
CREATE OR REPLACE FUNCTION total_citas_rango_fechas(p_fecha_inicio DATE, p_fecha_fin DATE) RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total
    FROM cita
    WHERE fecha BETWEEN p_fecha_inicio AND p_fecha_fin;

    RETURN v_total;
END;

--Obtener la próxima cita de un cliente
CREATE OR REPLACE FUNCTION obtener_proxima_cita_cliente(p_id_cliente NUMBER) RETURN DATE IS
    v_fecha DATE;
BEGIN
    SELECT MIN(fecha) INTO v_fecha
    FROM cita
    WHERE id_cliente = p_id_cliente
      AND estado = 'Confirmada';

    RETURN v_fecha;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END;

--Calcular el total de productos en inventario
CREATE OR REPLACE FUNCTION total_productos_inventario RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT NVL(SUM(stock), 0) INTO v_total
    FROM producto;

    RETURN v_total;
END;

--Determinar el medicamento más vendido
CREATE OR REPLACE FUNCTION medicamento_mas_vendido RETURN VARCHAR2 IS
    v_nombre VARCHAR2(100);
BEGIN
    SELECT m.nombre INTO v_nombre
    FROM medicamento m
    GROUP BY m.nombre
    ORDER BY COUNT(*) DESC
    FETCH FIRST 1 ROWS ONLY;

    RETURN v_nombre;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No disponible';
END;

--Obtener el nombre del proveedor de un producto
CREATE OR REPLACE FUNCTION obtener_proveedor_producto(p_id_producto NUMBER) RETURN VARCHAR2 IS
    v_nombre VARCHAR2(100);
BEGIN
    SELECT pr.nombre INTO v_nombre
    FROM proveedor pr
    JOIN producto p ON pr.id_proveedor = p.id_proveedor
    WHERE p.id_producto = p_id_producto;

    RETURN v_nombre;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Proveedor no encontrado';
END;

--Calcular el total de servicios brindados en un mes
CREATE OR REPLACE FUNCTION total_servicios_mes(p_mes NUMBER, p_ano NUMBER) RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total
    FROM detalle_servicio ds
    JOIN factura f ON ds.id_factura = f.id_factura
    WHERE EXTRACT(MONTH FROM f.fecha) = p_mes
      AND EXTRACT(YEAR FROM f.fecha) = p_ano;

    RETURN v_total;
END;

--Obtener la cantidad de citas de un cliente
CREATE OR REPLACE FUNCTION cantidad_citas_cliente(p_id_cliente NUMBER) RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total
    FROM cita
    WHERE id_cliente = p_id_cliente;

    RETURN v_total;
END;


--Calcular el total de ventas en un mes específico
CREATE OR REPLACE FUNCTION total_ventas_mes(p_mes NUMBER, p_ano NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
    v_prod NUMBER := 0;
    v_serv NUMBER := 0;
BEGIN
    SELECT NVL(SUM(dp.cantidad * dp.precio_unitario), 0)
    INTO v_prod
    FROM detalle_producto dp
    JOIN factura f ON dp.id_factura = f.id_factura
    WHERE EXTRACT(MONTH FROM f.fecha) = p_mes
      AND EXTRACT(YEAR FROM f.fecha) = p_ano;

    SELECT NVL(SUM(ds.cantidad * ds.precio_unitario), 0)
    INTO v_serv
    FROM detalle_servicio ds
    JOIN factura f ON ds.id_factura = f.id_factura
    WHERE EXTRACT(MONTH FROM f.fecha) = p_mes
      AND EXTRACT(YEAR FROM f.fecha) = p_ano;

    v_total := v_prod + v_serv;
    RETURN v_total;
END;

--Obtener el cliente con más citas
CREATE OR REPLACE FUNCTION cliente_con_mas_citas RETURN VARCHAR2 IS
    v_nombre VARCHAR2(100);
BEGIN
    SELECT c.nombre || ' ' || c.apellido INTO v_nombre
    FROM cliente c
    JOIN cita ci ON c.id_cliente = ci.id_cliente
    GROUP BY c.id_cliente, c.nombre, c.apellido
    ORDER BY COUNT(ci.id_cita) DESC
    FETCH FIRST 1 ROWS ONLY;

    RETURN v_nombre;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No disponible';
END;

--Calcular la edad de una mascota
CREATE OR REPLACE FUNCTION calcular_edad_mascota(p_id_mascota NUMBER) RETURN NUMBER IS
    v_fecha DATE;
    v_edad NUMBER;
BEGIN
    SELECT fecha_nacimiento INTO v_fecha
    FROM mascota
    WHERE id_mascota = p_id_mascota;

    v_edad := FLOOR(MONTHS_BETWEEN(SYSDATE, v_fecha) / 12);
    RETURN v_edad;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;

--Verificar disponibilidad de citas en una fecha
CREATE OR REPLACE FUNCTION verificar_disponibilidad_citas(p_fecha DATE) RETURN VARCHAR2 IS
    v_total NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total
    FROM cita
    WHERE fecha = p_fecha;

    IF v_total < 10 THEN
        RETURN 'Disponible';
    ELSE
        RETURN 'No Disponible';
    END IF;
END;
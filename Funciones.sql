create table metodo_pago (
    id_metodo_pago number generated as identity primary key,
    nombre varchar2(50) not null
);

+--Obtener el nombre de una mascota por su ID**
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
    v_total_facturado NUMBER;
BEGIN
    SELECT SUM(f.total) INTO v_total_facturado
    FROM factura f
    WHERE f.id_cliente = p_id_cliente;
    RETURN v_total_facturado;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;


--Obtener el número de citas de un veterinario
CREATE OR REPLACE FUNCTION cantidad_citas_veterinario(p_id_empleado NUMBER) RETURN NUMBER IS
    v_cantidad_citas NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_cantidad_citas
    FROM cita
    WHERE id_empleado = p_id_empleado;
    RETURN v_cantidad_citas;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;

--Verificar si un cliente ha comprado un medicamento específico
CREATE OR REPLACE FUNCTION verificar_compra_medicamento(p_id_cliente NUMBER, p_id_medicamento NUMBER) RETURN VARCHAR2 IS
    v_resultado VARCHAR2(3);
BEGIN
    SELECT CASE
               WHEN COUNT(*) > 0 THEN 'Sí'
               ELSE 'No'
           END INTO v_resultado
    FROM detalle_factura df
    JOIN factura f ON df.id_factura = f.id_factura
    JOIN medicamento m ON df.id_producto = m.id_medicamento
    WHERE f.id_cliente = p_id_cliente
    AND m.id_medicamento = p_id_medicamento;
    RETURN v_resultado;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No';
END;


--Calcular el total de citas en un rango de fechas
CREATE OR REPLACE FUNCTION total_citas_rango_fechas(p_fecha_inicio DATE, p_fecha_fin DATE) RETURN NUMBER IS
    v_total_citas NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total_citas
    FROM cita
    WHERE fecha BETWEEN p_fecha_inicio AND p_fecha_fin;
    RETURN v_total_citas;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;


### 6️⃣ **Obtener la próxima cita de un cliente**
```sql
CREATE OR REPLACE FUNCTION obtener_proxima_cita_cliente(p_id_cliente NUMBER) RETURN DATE IS
    v_fecha_proxima_cita DATE;
BEGIN
    SELECT MIN(fecha) INTO v_fecha_proxima_cita
    FROM cita
    WHERE id_cliente = p_id_cliente
    AND estado = 'Confirmada';
    RETURN v_fecha_proxima_cita;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END;

--Calcular el total de productos en inventario
CREATE OR REPLACE FUNCTION total_productos_inventario RETURN NUMBER IS
    v_total_productos NUMBER;
BEGIN
    SELECT SUM(stock) INTO v_total_productos
    FROM producto;
    RETURN v_total_productos;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;


--Determinar el medicamento más vendido
CREATE OR REPLACE FUNCTION medicamento_mas_vendido RETURN VARCHAR2 IS
    v_nombre_medicamento VARCHAR2(100);
BEGIN
    SELECT m.nombre INTO v_nombre_medicamento
    FROM medicamento m
    JOIN detalle_factura df ON m.id_medicamento = df.id_producto
    GROUP BY m.nombre
    ORDER BY SUM(df.cantidad) DESC
    FETCH FIRST 1 ROWS ONLY;
    RETURN v_nombre_medicamento;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No disponible';
END;


--Obtener el nombre del proveedor de un producto**
CREATE OR REPLACE FUNCTION obtener_proveedor_producto(p_id_producto NUMBER) RETURN VARCHAR2 IS
    v_nombre_proveedor VARCHAR2(100);
BEGIN
    SELECT p.nombre INTO v_nombre_proveedor
    FROM proveedor p
    JOIN producto pr ON p.id_proveedor = pr.id_producto
    WHERE pr.id_producto = p_id_producto;
    RETURN v_nombre_proveedor;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Proveedor no encontrado';
END;


--Calcular el total de servicios brindados en un mes
CREATE OR REPLACE FUNCTION total_servicios_mes(p_mes NUMBER, p_ano NUMBER) RETURN NUMBER IS
    v_total_servicios NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total_servicios
    FROM historial_servicio hs
    JOIN factura f ON hs.id_factura = f.id_factura
    WHERE EXTRACT(MONTH FROM f.fecha) = p_mes
    AND EXTRACT(YEAR FROM f.fecha) = p_ano;
    RETURN v_total_servicios;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;


--Obtener la cantidad de citas de un cliente**
CREATE OR REPLACE FUNCTION cantidad_citas_cliente(p_id_cliente NUMBER) RETURN NUMBER IS
    v_cantidad_citas NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_cantidad_citas
    FROM cita
    WHERE id_cliente = p_id_cliente;
    RETURN v_cantidad_citas;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;


--Calcular el total de ventas en un mes específico

CREATE OR REPLACE FUNCTION total_ventas_mes(p_mes NUMBER, p_ano NUMBER) RETURN NUMBER IS
    v_total_ventas NUMBER;
BEGIN
    SELECT SUM(df.subtotal) INTO v_total_ventas
    FROM detalle_factura df
    JOIN factura f ON df.id_factura = f.id_factura
    WHERE EXTRACT(MONTH FROM f.fecha) = p_mes
      AND EXTRACT(YEAR FROM f.fecha) = p_ano;
    RETURN v_total_ventas;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;


--Obtener el cliente con más citas
CREATE OR REPLACE FUNCTION cliente_con_mas_citas RETURN VARCHAR2 IS
    v_nombre_cliente VARCHAR2(100);
BEGIN
    SELECT c.nombre || ' ' || c.apellido INTO v_nombre_cliente
    FROM cliente c
    JOIN cita ci ON c.id_cliente = ci.id_cliente
    GROUP BY c.id_cliente
    ORDER BY COUNT(ci.id_cita) DESC
    FETCH FIRST 1 ROWS ONLY;
    RETURN v_nombre_cliente;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No disponible';
END;


--Calcular la edad de una mascota
CREATE OR REPLACE FUNCTION calcular_edad_mascota(p_id_mascota NUMBER) RETURN NUMBER IS
    v_edad NUMBER;
BEGIN
    SELECT edad INTO v_edad
    FROM mascota
    WHERE id_mascota = p_id_mascota;
    RETURN v_edad;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;


--Verificar disponibilidad de citas en una fecha
CREATE OR REPLACE FUNCTION verificar_disponibilidad_citas(p_fecha DATE) RETURN VARCHAR2 IS
    v_disponibilidad VARCHAR2(20);
BEGIN
    SELECT CASE
               WHEN COUNT(*) < 10 THEN 'Disponible'
               ELSE 'No Disponible'
           END
    INTO v_disponibilidad
    FROM cita
    WHERE fecha = p_fecha;
    RETURN v_disponibilidad;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Disponible';
END;

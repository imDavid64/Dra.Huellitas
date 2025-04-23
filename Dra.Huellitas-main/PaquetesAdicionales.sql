
-- Paquete Búsquedas
CREATE OR REPLACE PACKAGE pkg_busquedas AS
    PROCEDURE buscar_cliente_por_nombre(p_nombre VARCHAR2);
END pkg_busquedas;

CREATE OR REPLACE PACKAGE BODY pkg_busquedas AS
    PROCEDURE buscar_cliente_por_nombre(p_nombre VARCHAR2) IS
    BEGIN
        FOR cli IN (SELECT id_cliente, nombre, apellido FROM cliente WHERE nombre LIKE '%' || p_nombre || '%') LOOP
            DBMS_OUTPUT.PUT_LINE(cli.id_cliente || ' - ' || cli.nombre || ' ' || cli.apellido);
        END LOOP;
    END buscar_cliente_por_nombre;
END pkg_busquedas;

-- Paquete Servicios
CREATE OR REPLACE PACKAGE pkg_servicios AS
    PROCEDURE obtener_info_servicio(p_id_servicio NUMBER);
END pkg_servicios;

CREATE OR REPLACE PACKAGE BODY pkg_servicios AS
    PROCEDURE obtener_info_servicio(p_id_servicio NUMBER) IS
        v_nombre servicio.nombre%TYPE;
        v_precio servicio.precio%TYPE;
    BEGIN
        SELECT nombre, precio INTO v_nombre, v_precio FROM servicio WHERE id_servicio = p_id_servicio;
        DBMS_OUTPUT.PUT_LINE('Servicio: ' || v_nombre || ', Precio: ' || v_precio);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontró el servicio con ID ' || p_id_servicio);
    END obtener_info_servicio;
END pkg_servicios;

-- Paquete Reportes
CREATE OR REPLACE PACKAGE pkg_reportes AS
    PROCEDURE generar_reporte_facturacion(p_mes NUMBER, p_anio NUMBER);
END pkg_reportes;

CREATE OR REPLACE PACKAGE BODY pkg_reportes AS
    PROCEDURE generar_reporte_facturacion(p_mes NUMBER, p_anio NUMBER) IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(total) INTO v_total FROM factura
        WHERE EXTRACT(MONTH FROM fecha) = p_mes AND EXTRACT(YEAR FROM fecha) = p_anio;
        DBMS_OUTPUT.PUT_LINE('Total facturación ' || p_mes || '/' || p_anio || ': ' || v_total);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('No se encontraron facturas en ese periodo.');
    END generar_reporte_facturacion;
END pkg_reportes;

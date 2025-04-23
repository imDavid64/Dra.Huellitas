--------------------Vistas--------------------

-- 1. Vista de clientes con sus mascotas
create or replace view vw_clientes_mascotas AS
select c.id_cliente, c.nombre AS cliente, c.apellido, m.id_mascota, m.nombre AS mascota, m.tipo, m.raza
from cliente c
LEFT JOIN mascota m ON c.id_cliente = m.id_cliente; -- para que me lance todos los clientes aunque no tengan mascotas

select * from cliente;
select * from mascota;


-- 2. Vista de empleados con sus respectivos roles
create or replace view vw_empleados_roles AS
select id_empleado, nombre, apellido, rol 
from empleado;

-- 3. Vista del Historial de consultas por mascota
create or replace view vw_historial_consultas AS
select h.id_historial, m.nombre AS mascota, h.situacion, h.descripcion, h.fecha
from historial_mascota h
join mascota m ON h.id_mascota = m.id_mascota;

-- 4. Vista de las citas
create or replace view vw_citas_detalle AS
select c.id_cita, cl.nombre AS cliente, e.nombre AS veterinario, c.fecha, c.hora, c.estado
from cita c
join cliente cl ON c.id_cliente = cl.id_cliente
join empleado e ON c.id_empleado = e.id_empleado;

-- 5. Vista de los productos que tenemos en stock
create or replace view vw_productos_disponibles AS
select id_producto, nombre, descripcion, precio, stock 
from producto WHERE stock > 0;

-- 6. Vista de todas las facturas 
create or replace view vw_facturas_totales AS
select f.id_factura, c.nombre AS cliente, f.fecha, f.total, f.estado_pago
from factura f
join cliente c ON f.id_cliente = c.id_cliente;

-- 7. Vista sobre el historial de los servicios adquiridos
create or replace view vw_historial_servicios AS
select h.id_historial_servicio, c.nombre AS cliente, s.nombre AS servicio, h.fecha, h.total
from historial_servicio h
join cliente c ON h.id_cliente = c.id_cliente
join servicio s ON h.id_servicio = s.id_servicio;

-- 8. Vista de los medicamentos recetados en los tratamientos
create or replace view vw_medicamentos_tratamientos AS
select m.id_medicamento, m.nombre, m.dosis, t.nombre AS tratamiento
from medicamento m
join tratamiento t ON m.id_tratamiento = t.id_tratamiento;

-- 9. Vista sobre las compras hechas a proveedores
create or replace view vw_compras_proveedores AS
select o.id_orden_compra, p.nombre AS proveedor, o.fecha, o.total
from orden_compra o
join proveedor p ON o.id_proveedor = p.id_proveedor;

-- 10. Vista de los pagos recibidos por los clientes
create or replace view vw_pagos_clientes AS
select p.id_pago, c.nombre AS cliente, p.monto, p.fecha, m.nombre AS metodo_pago
from pago p
join cliente c ON p.id_factura = c.id_cliente
join metodo_pago m ON p.id_metodo_pago = m.id_metodo_pago;

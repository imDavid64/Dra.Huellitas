--Agregar servicio

CREATE OR REPLACE PROCEDURE agregar_servicio(
    p_nombre IN servicio.nombre%TYPE,
    p_descripcion IN servicio.descripcion%TYPE,
    p_precio IN servicio.precio%TYPE
) IS
BEGIN
    INSERT INTO servicio(nombre, descripcion, precio)
    VALUES (p_nombre, p_descripcion, p_precio);
    dbms_output.put_line('Servicio agregado correctamente.');
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Error al agregar servicio: ' || SQLERRM);
END;
/

--Para probar
EXECUTE agregar_servicio('Baño y corte', 'Incluye baño completo, secado y corte de pelo', 15000);

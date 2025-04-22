--Agendar Cita

CREATE OR REPLACE PROCEDURE agendar_cita(
    p_id_cliente IN cita.id_cliente%TYPE,
    p_id_empleado IN cita.id_empleado%TYPE,
    p_fecha IN cita.fecha%TYPE,
    p_hora IN cita.hora%TYPE
) IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM cita
    WHERE id_empleado = p_id_empleado
      AND fecha = p_fecha
      AND hora = p_hora
      AND estado IN ('Pendiente', 'Confirmada');

    IF v_count > 0 THEN
        dbms_output.put_line('Ya existe una cita agendada para ese empleado en esa fecha y hora.');
    ELSE
        INSERT INTO cita(id_cliente, id_empleado, fecha, hora, estado)
        VALUES (p_id_cliente, p_id_empleado, p_fecha, p_hora, 'Pendiente');

        dbms_output.put_line('Cita agendada correctamente.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Error al agendar cita: ' || SQLERRM);
END;
/

--Para probar

EXECUTE agendar_cita(1, 2, TO_DATE('2025-04-25', 'YYYY-MM-DD'), '14:00');

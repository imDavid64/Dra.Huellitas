--Modificar cita

CREATE OR REPLACE PROCEDURE modificar_cita(
    p_id_cita IN cita.id_cita%TYPE,
    p_fecha IN cita.fecha%TYPE,
    p_hora IN cita.hora%TYPE,
    p_estado IN cita.estado%TYPE
) IS
BEGIN
    UPDATE cita
    SET fecha = p_fecha,
        hora = p_hora,
        estado = p_estado
    WHERE id_cita = p_id_cita;

    IF SQL%ROWCOUNT = 0 THEN
        dbms_output.put_line('No se encontró la cita para modificar.');
    ELSE
        dbms_output.put_line('Cita modificada correctamente.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line('Error al modificar cita: ' || SQLERRM);
END;
/

--Para probar(suponiendo que hay cita con ID 1

EXECUTE modificar_cita(1, TO_DATE('2025-04-23', 'YYYY-MM-DD'), '10:30', 'Confirmada');


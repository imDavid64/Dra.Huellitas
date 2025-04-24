package Model;

import Util.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class ConsultaDAO {

    public boolean insertarConsulta(Consulta consulta) {
        String sql = "{ call PKG_CONSULTA.AGREGAR_CONSULTA(?, ?, ?, ?, ?, ?) }";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, consulta.getIdMascota());
            stmt.setInt(2, consulta.getIdEmpleado()); // Seleccionado en comboBox o fijo
            stmt.setDate(3, new java.sql.Date(consulta.getFecha().getTime()));
            stmt.setString(4, consulta.getMotivo());
            stmt.setString(5, consulta.getDiagnostico());
            stmt.setString(6, consulta.getTratamiento());

            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Consulta> obtenerConsultasPorMascota(int idMascota) {
        List<Consulta> lista = new ArrayList<>();
        String sql = "{ call PKG_CONSULTA.OBTENER_CONSULTAS_POR_MASCOTA(?, ?) }";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idMascota);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();

            ResultSet rs = (ResultSet) stmt.getObject(2);

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setIdConsulta(rs.getInt("id_consulta"));
                c.setFecha(rs.getDate("fecha"));
                c.setMotivo(rs.getString("motivo"));
                c.setDiagnostico(rs.getString("diagnostico"));
                c.setTratamiento(rs.getString("tratamiento"));
                c.setNombreDoctor(rs.getString("nombre_doctor"));
                lista.add(c);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Consulta obtenerDetalleConsulta(int idConsulta) {
        Consulta consulta = null;
        String sql = "{ call PKG_CONSULTA.OBTENER_DETALLE_CONSULTA(?, ?) }";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idConsulta);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();

            ResultSet rs = (ResultSet) stmt.getObject(2);

            if (rs.next()) {
                consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setFecha(rs.getDate("fecha"));
                consulta.setMotivo(rs.getString("motivo"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setTratamiento(rs.getString("tratamiento"));
                consulta.setNombreDoctor(rs.getString("nombre_doctor"));
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return consulta;
    }

    public boolean actualizarConsulta(Consulta consulta) {
        boolean exito = false;
        
        String sql = "{ call PKG_CONSULTA.ACTUALIZAR_CONSULTA(?, ?, ?, ?, ?) }";
        
        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {
        
            stmt.setInt(1, consulta.getIdConsulta());
            stmt.setDate(2, new java.sql.Date(consulta.getFecha().getTime()));
            stmt.setString(3, consulta.getMotivo());
            stmt.setString(4, consulta.getDiagnostico());
            stmt.setString(5, consulta.getTratamiento());
            stmt.execute();
            exito = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

    public boolean eliminarConsulta(int idConsulta) {
        boolean exito = false;

        String sql = "{ call PKG_CONSULTA.ELIMINAR_CONSULTA(?) }";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, idConsulta);
            stmt.execute();
            exito = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exito;
    }

}

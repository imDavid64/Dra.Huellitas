package Model;

import Util.ConexionOracle;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class ClienteMascotaDAO {

    public List<ClienteMascota> obtenerClienteMascota() {
        List<ClienteMascota> lista = new ArrayList<>();

        String sql = "{ call PKG_CLIENTE_MASCOTA.OBTENER_CLIENTE_MASCOTA(?) }";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();

            ResultSet rs = (ResultSet) stmt.getObject(1);

            while (rs.next()) {
                ClienteMascota cm = new ClienteMascota();
                cm.setIdCliente(rs.getInt("ID_CLIENTE"));
                cm.setIdMascota(rs.getInt("ID_MASCOTA"));
                cm.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                cm.setApellidoCliente(rs.getString("APELLIDO_CLIENTE"));
                cm.setNombreMascota(rs.getString("NOMBRE_MASCOTA"));
                lista.add(cm);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public ClienteMascota obtenerDetalleExpediente(int idCliente, int idMascota) {
        ClienteMascota cm = null;

        String sql = "{ call PKG_CLIENTE_MASCOTA.OBTENER_DETALLE_EXPEDIENTE(?, ?, ?) }";

        try (Connection conn = ConexionOracle.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idCliente);
            stmt.setInt(2, idMascota);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();

            ResultSet rs = (ResultSet) stmt.getObject(3);

            if (rs.next()) {
                cm = new ClienteMascota();
                cm.setIdCliente(rs.getInt("ID_CLIENTE"));
                cm.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                cm.setApellidoCliente(rs.getString("APELLIDO"));
                cm.setTelefono(rs.getString("TELEFONO"));
                cm.setEmail(rs.getString("EMAIL"));
                cm.setDireccion(rs.getString("DIRECCION"));
                cm.setIdMascota(rs.getInt("ID_MASCOTA"));
                cm.setNombreMascota(rs.getString("NOMBRE_MASCOTA"));
                cm.setTipo(rs.getString("TIPO"));
                cm.setRaza(rs.getString("RAZA"));
                cm.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                cm.setPeso(rs.getDouble("PESO"));
                cm.setSexo(rs.getString("SEXO"));
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cm;
    }

}

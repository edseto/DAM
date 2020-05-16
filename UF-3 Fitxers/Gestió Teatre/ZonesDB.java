import java.sql.*;
public final class ZonesDB {

    public static void insertarZones(Connection conDB, Zones espais) throws SQLException {
        String query = "insert into zones(id_zona, preu) values (?, ?)";
        PreparedStatement insertar = conDB.prepareStatement(query);

        for (int i = 0; i < espais.zones.size(); i++) {
            insertar.setInt(1, espais.zones.get(i).getId());
            insertar.setDouble(2, espais.zones.get(i).getPreu());
            insertar.execute();
        }
    }

    public static void eliminarZona(Connection conDB, int idZona) throws SQLException {
        String borrar = "DELETE FROM zones WHERE id_zona = "+idZona;
        Statement delete = conDB.createStatement();

        delete.executeUpdate(borrar);
    }

    public static ResultSet obtenirZones(Connection conDB) throws SQLException {
        String consulta = "SELECT * FROM zones";

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }
}
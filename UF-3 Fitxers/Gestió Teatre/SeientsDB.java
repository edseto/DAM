import java.sql.*;
public final class SeientsDB {
    public static void insertarSeients(Connection conDB, Zones espais) throws SQLException {
        String query = "insert into seients(id_seient, id_zona) values (?, ?)";
        PreparedStatement insertar = conDB.prepareStatement(query);

        for (int i = 0; i < espais.zones.size(); i++) {
            for (int j = 0; j < espais.zones.get(i).getSeients().seients.size(); j++) {
                insertar.setString(1, espais.zones.get(i).getSeients().seients.get(j).getId());
                insertar.setInt(2, espais.zones.get(i).getId());
                insertar.execute();
            }
        }
    }

    public static void eliminarSeient(Connection conDB, String idSeient) throws SQLException {
        String borrar = "DELETE FROM seients WHERE id_Seient LIKE '"+idSeient+"'";
        Statement delete = conDB.createStatement();

        delete.executeUpdate(borrar);
    }

    public static ResultSet obtenirSeients(Connection conDB) throws SQLException {
        String consulta = "SELECT * FROM seients";

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static ResultSet obtenirSeientsZona(Connection conDB, int idZona) throws SQLException {
        String consulta = "SELECT * FROM seients WHERE id_zona = "+idZona;

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static ResultSet obtenirUnicSeient(Connection conDB, String idSeient) throws SQLException {
        String consulta = "SELECT * FROM seients WHERE id_seient LIKE '"+idSeient+"'";
        
        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static ResultSet obtenirSeientsPlens(Connection conDB) throws SQLException {
        String consulta = "SELECT id_seient, data_reservat FROM reserva"; 

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static ResultSet obtenirSeientsBuits(Connection conDB) throws SQLException {
        String consulta = "SELECT * FROM seients WHERE id_seient NOT IN (SELECT id_seient FROM reserva)";

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static ResultSet obtenirSeientsBuitsZona(Connection conDB, int idZona) throws SQLException {
        String consulta = "SELECT * FROM seients WHERE id_seient NOT IN"+
                        "(SELECT id_seient FROM reserva WHERE id_zona = "+idZona+") AND id_zona ="+idZona;

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }
}
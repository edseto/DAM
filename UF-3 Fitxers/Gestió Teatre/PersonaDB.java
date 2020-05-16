import java.sql.*;
public final class PersonaDB {
    
    public static void afegirEspectador(Connection conDB, Persona espectador) throws SQLException {
        String query = "insert into espectadors(dni, nom) values (?, ?)";
        PreparedStatement insertar = conDB.prepareStatement(query);

        insertar.setString(1, espectador.getDni());
        insertar.setString(2, espectador.getNom());
        insertar.execute();
    }

    public static void eliminarEspectador(Connection conDB, Persona espectador) throws SQLException {
        borrarEspectador(conDB, espectador.getDni());
    }

    public static void eliminarEspectador(Connection conDB, String dniEspectador) throws SQLException {
        borrarEspectador(conDB, dniEspectador);
    }

    private static void borrarEspectador(Connection conDB, String espectador) throws SQLException {
        String borrar = "DELETE FROM espectadors WHERE dni LIKE '"+espectador+"'";
        Statement delete = conDB.createStatement();

        delete.executeUpdate(borrar);
    }

    public static ResultSet buscarEspectador(Connection conDB, String dniEspectador) throws SQLException {
        String consulta = "SELECT * FROM espectadors WHERE dni LIKE '"+dniEspectador+"'";

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static ResultSet obtenirEspectadors(Connection conDB) throws SQLException {
        String consulta = "SELECT * FROM espectadors";

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }
}
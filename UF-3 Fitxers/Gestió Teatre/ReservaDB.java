import java.sql.*;
public final class ReservaDB {
    public static void afegirReserva(Connection conDB, Reserva reserva) throws Exception{
        String query = "insert into reserva(id_seient, dni_espectador, data_reservat) values (?, ?, ?)";
        String data = reserva.getData().toString();
        PreparedStatement insertar = conDB.prepareStatement(query);
        
        if(reservaNoValida(conDB, reserva)) throw new Exception("La reserva no es valida. Esculli un altre seient o un altre dia.\n Disculpi les molesties");

        insertar.setString(1, reserva.getSeient().getId());
        insertar.setString(2, reserva.getEspectador().getDni());
        insertar.setString(3, data); 
        //El setData no és compatible amb LocalDate i el passo com String(ja ho converteix bé)
        insertar.execute();
    }
    
    private static boolean reservaNoValida(Connection conDB, Reserva reserva) throws SQLException {
        String consulta = "SELECT * FROM reserva WHERE '"+
                        reserva.getSeient().getId()+"' LIKE id_seient AND data_reservat = '"+reserva.getData()+"'";
        ResultSet query = null;

        query = MySQL.consultaPersonalitzada(conDB, consulta);

        return query.next(); //true = hi ha algun resultat; false = no hi ha cap resultat
    }

    public static int idUltimaReserva(Connection conDB) throws SQLException {
        String consulta = "SELECT id_reserva FROM reserva ORDER BY id_reserva DESC LIMIT 1;";
        ResultSet query = null;

        query = MySQL.consultaPersonalitzada(conDB, consulta);
        return query.getInt("id_reserva");
    }

    public static void anularReserva(Connection conDB, Reserva reserva) throws SQLException {
        String anular = "DELETE FROM reserva WHERE id_reserva = "+reserva.getId()+" AND dni_espectador LIKE '"+reserva.getEspectador().getDni()+"'";
        Statement delete = conDB.createStatement();

        delete.executeUpdate(anular);
    }

    public static ResultSet obtenirReserves(Connection conDB) throws SQLException {
        String consulta = "SELECT * FROM reserva";

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static ResultSet obtenirReserva(Connection conDB, int idReserva) throws SQLException {
        String consulta = "SELECT * FROM reserva WHERE id_reserva = "+idReserva;

        return MySQL.consultaPersonalitzada(conDB, consulta);
    }

    public static double preuTotalEspectador(Connection conDB, String dniEspectador) throws SQLException {
        String consulta = "SELECT sum(preu_total) AS total FROM reserva WHERE dni_espectador LIKE '"+dniEspectador+"'";
        ResultSet query = null;
        double total=0;

        query = MySQL.consultaPersonalitzada(conDB, consulta);

        while (query.next()) {
            total = query.getDouble("total");
        }
        return total;
    }
}
import java.sql.*;
import java.time.LocalDate;

import org.json.*;

public class TestBdd {
    public static void main(String[] args) throws JSONException, SQLException {
        Connection conDB = null;
        Statement statement = null;
        ResultSet query = null;

        try {
            // Connect to DataBase
            conDB = MySQL.conectarBaseDades();

            // Retrieving some values from table test
            statement = conDB.createStatement();
            query = statement.executeQuery("Select * from zones");
            while (query.next()) {
                System.out.println(query.getInt("id_zona") + "\t\t" + query.getDouble("preu"));
            }
            // How to insert data
            // String sql = "insert into animal(idA, nom, dataE, descriptiu, idE) values(4,
            // 'Pep', '2020-05-15', 'Menja cabres', 1)";
            // statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        String fitxer = "Zones.json";
        Zones zones = new Zones(8, fitxer);
        System.out.println(zones.zones.get(0).toString());

        try {
            ZonesDB.insertarZones(conDB, zones);
            SeientsDB.insertarSeients(conDB, zones);
        } catch (Exception e) {
            // Do nothing (Pot petar perquè potser ja s'han insertat a la base de dades)
        }

        String consulta = "SELECT * FROM seients WHERE id_zona = 1 OR id_zona = 2";
        query = MySQL.consultaPersonalitzada(conDB, consulta);

        while (query.next()) {
            System.out.println(query.getString("id_seient") + " -> " + query.getInt("id_zona"));
        }

        // Test afegir reserva
        consulta = "insert into reserva(id_seient, dni_espectador, data_reservat) values (?, ?, ?)";
        PreparedStatement insertar = conDB.prepareStatement(consulta);

        insertar.setString(1, "Z1 - 0");
        insertar.setString(2, "12345678A");
        insertar.setString(3, "2020-05-14");
        insertar.execute();

        // Test validar reserva
        Seient seient = zones.zones.get(0).getSeients().seients.get(0);
        LocalDate time = LocalDate.of(2020, 05, 22);
        Persona espectador = new Persona("12345678B", "Edgar");

        Reserva reserva = new Reserva(14, seient, espectador, time);

        try {
            ReservaDB.afegirReserva(conDB, reserva);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test anular reserva
        try {
            ReservaDB.anularReserva(conDB, reserva);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test llistar seients buits
        query = SeientsDB.obtenirSeientsBuits(conDB);
        System.out.println("SEIENTS BUITS:");
        while (query.next()) {
            System.out.println(query.getString("id_seient")+" -> "+query.getInt("id_zona"));
        }

        // Test llistar seients plens
        System.out.println("***************************");
        query = SeientsDB.obtenirSeientsPlens(conDB);
        System.out.println("SEIENTS PLENS:");
        while (query.next()) {
            System.out.println(query.getString("id_seient")+" -> "+query.getDate("data_reservat"));
        }
        
        System.out.println("***************************");
        // Test preu total reserva
        System.out.println(ReservaDB.preuTotalEspectador(conDB, "12345678A"));

        try {
            query.close();
        } catch (Exception e) {
            // Do nothing
        }
        try {
            statement.close();
        } catch (Exception e) {
            // Do nothing
        }
        try {
            conDB.close();
        } catch (Exception e) {
            // Do nothing
        }
    }
}
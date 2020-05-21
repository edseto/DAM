import java.util.Scanner;
import org.json.*;
import java.sql.*;
import java.time.LocalDate;

public class Main {
    private static Connection conDB = MySQL.conectarBaseDades();
    private static ResultSet query = null;
    private static Zones espais;
    private static Scanner sc = new Scanner(System.in);
    private static int totalZones;

    public static void generarSeients() {
        String fitxer;

        System.out.print("Introdueixi el nom del fitxer: ");
        fitxer = sc.next();
        
        try {
            totalZones = FuncionsJSON.numZones(fitxer);
            espais = new Zones(totalZones, fitxer);
            ZonesDB.insertarZones(conDB, espais);
            SeientsDB.insertarSeients(conDB, espais);
            System.out.println("Seients generats a la base de dades amb exit!");
        } catch (JSONException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void reservarSeient() {
        int zona;
        char sortir = 'N';
        boolean finish = false;
        String idSeient;
        LocalDate data;
        Persona espectador;
        Seient seient;
        
        do {
            try {
                System.out.println("En el nostre teatre hi ha les següents zones:");
                query = ZonesDB.obtenirZones(conDB);
                while (query.next()) {
                    System.out.println("Zona "+query.getInt("id_zona")+": "+query.getDouble("preu"));
                }
        
                System.out.print("A quina zona prefereix seure? (1-" + totalZones + ") ");
                zona = sc.nextInt();
        
                System.out.println("A la zona " + zona + " hi ha els següents seients:");
                query = SeientsDB.obtenirSeientsZona(conDB, zona);
                while (query.next()) {
                    System.out.println(query.getString("id_seient"));
                }
                System.out.print("Introdueixi l'identificador del seient: ");
                idSeient = sc.next();
    
                seient = buscarSeient(idSeient, zona);
                
                espectador = crearPersona();
                data = demanarData();
                
                seient.getReserves().reservar(seient, espectador, data, conDB);
                
                System.out.println("El seient " + idSeient + " ha sigut reservat correctament pel dia " + data.toString());
                System.out.println("El preu total a abonar es: "+ReservaDB.preuTotalEspectador(conDB, espectador.getDni()));

                do {
                    System.out.print("Vol realitzar una altra reserva (Y/N)? ");
                    sortir = sc.next().charAt(0);
                    if(sortir!='Y'&&sortir!='N') System.out.println("Caracter incorrecte. Introdueixi un caracter valid!");
                } while (sortir!='Y'&&sortir!='N');

                if(sortir == 'Y') finish = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!finish);

    }

    private static Seient buscarSeient(String idSeient, int zona) throws SQLException {
        Seient seient;
        String id;
        
        query = SeientsDB.obtenirUnicSeient(conDB, idSeient);
        id = query.getString("id_seient");
        seient = new Seient(id);

        return seient; 
    }

    private static Persona crearPersona() throws SQLException {
        Persona espectador;
        String dni, nom;

        System.out.print("Introdueixi el seu DNI: ");
        dni = sc.next();

        System.out.print("Introdueixi el seu nom: ");
        nom = sc.next();

        espectador = new Persona(dni, nom);
        if(!PersonaDB.buscarEspectador(conDB, dni).next()) PersonaDB.afegirEspectador(conDB, espectador);
        //Si l'espectador ja existeix no cal tornar a afegir-lo a la Base de Dades

        return espectador;
    }

    private static LocalDate demanarData() {
        LocalDate data;
        sc.nextLine();

        System.out.print("Per a quin dia vol reservar (any-mes-dia)? ");
        data = LocalDate.parse(sc.nextLine());
        
        return data;
    }

    public static void llistarSeients() {
        int opcio;
        boolean finish = false;

        do {
            System.out.println();
            System.out.println("1- Llistar tots els seients");
            System.out.println("2- Llistar els seients plens");
            System.out.println("3- Llistar els seients buits");
            System.out.println("4- Tornar al menu principal");
            System.out.print("Escull una opcio (1-4): ");
            opcio = sc.nextInt();

            if(opcio<1 || opcio>4) System.out.println("Opcio incorrecte! Sius plau introdueixi una opcio correcte");
            else if (opcio == 4) finish = true;
            else{
                try {
                    opcionsLlistar(opcio);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } while (!finish);
    }

    private static void opcionsLlistar(int opcio) throws SQLException {
        switch (opcio) {
            case 1: query = SeientsDB.obtenirSeients(conDB);
                break;
            case 2: query = SeientsDB.obtenirSeientsPlens(conDB);
                break;
            default: query = seientsBuitsZona();
                break;
        }
        if(opcio==2) mostrarSeientsOcupats(query);
        else mostrarSeients(query);
    }

    private static ResultSet seientsBuitsZona() throws SQLException {
        int zona;

        do {
            System.out.print("De quina zona vols veure els seients disponibles? (Si vols veure totes les zones introdueixi 0) ");
            zona = sc.nextInt();
        } while (zona<0||zona>totalZones);

        if(zona==0) return SeientsDB.obtenirSeientsBuits(conDB);
        else return SeientsDB.obtenirSeientsBuitsZona(conDB, zona);
    }

    private static void mostrarSeients(ResultSet query) throws SQLException {
        while (query.next()) {
            System.out.println(query.getString("id_seient"));
        }
    }

    private static void mostrarSeientsOcupats(ResultSet query) throws SQLException {
        while (query.next()) {
            System.out.println(query.getString("id_seient")+" -> "+query.getDate("data_reservat"));
        }
    }
    public static void main(String[] args) {
        int opcio;
        boolean finish = false;

        do {
            System.out.println();
            System.out.println("Benvingut al menu del 'Valdez Theater'");
            System.out.println("**************************************");
            System.out.println("1- Generar Seients");
            System.out.println("2- Reservar Seient"); 
            System.out.println("3- Llistar Seients");
            System.out.println("4- Finalitzar programa");
            System.out.print("Introdueixi una opcio (1-4): ");
            opcio = sc.nextInt();
            if(opcio<1 || opcio>4) System.out.println("Opcio incorrecte. Sius plau introdueixi una opcio correcte");
            else{
                switch (opcio) {
                    case 1: generarSeients();
                        break;
                    case 2: reservarSeient();
                        break;
                    case 3: llistarSeients();
                        break;
                    default: finish = true;
                        break;
                }
            }
        } while (!finish);

        System.out.println("Gracies per utilitzar el meu programa :D");
    }
}
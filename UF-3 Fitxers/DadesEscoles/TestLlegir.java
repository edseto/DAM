import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestLlegir {
    public static void main(String[] args) throws FileNotFoundException {
        // En els fitxers poso aquesta ruta perquè només posant el nom del fitxer no em funciona
        FileReader file029 = new FileReader("DAM\\UF-3 Fitxers\\DadesEscoles\\ccd_sch_029_1718_w_1a_083118.csv");
        FileReader file059 = new FileReader("DAM\\UF-3 Fitxers\\DadesEscoles\\ccd_sch_059_1718_l_1a_083118.csv");

        // Test crear Estats
        try {
            System.out.println("Creant fitxer per Estats... Esperi un moment");
            Funcions.fitxerPerEstats(file029, file059);
            System.out.println("Fitxer per Estats creat correctament");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Creant fitxer per Nivell... Esperi un moment");
            Funcions.fitxerPerNivell(file029, file059);
            System.out.println("Fitxer per Nivell creat correctament");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
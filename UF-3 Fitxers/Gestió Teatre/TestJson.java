import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TestJson {
    public static void main(String[] args) throws JSONException, FileNotFoundException {
        /*
         *  // Escriure un fitxer JSON
         * 
         *  // Crear Objecte JSON JSONObject object = new JSONObject();
         * 
         * // Afegim dades [ {zona: id, totalseients: número, preu: número } ]
         * object.put("zona", 1); object.put("totalseients", 20); object.put("preu",
         * 79);
         * 
         * // Escriure les dades de l'objecte en un fitxer PrintWriter pw = new
         * PrintWriter("Zones.json"); pw.write("["); // "Iniciar" fitxer json
         * pw.write(object.toString());
         * 
         * pw.write(",\n"); // Separació entre objectes json
         * 
         * object.put("zona", 2); object.put("totalseients", 40); object.put("preu",
         * 67);
         * 
         * pw.write(object.toString()); pw.write("]"); // "Finalitzar" fitxer json
         * 
         * pw.flush(); pw.close();
         */

        // Llegir un fitxer JSON
        InputStream is = TestJson.class.getResourceAsStream("Zones.json");
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jarray = new JSONArray(tokener);
        for (int i = 0; i < jarray.length(); i++) {
            JSONObject jb = (JSONObject) jarray.get(i);
            int zona = jb.getInt("zona");
            int seients = jb.getInt("totalseients");
            int preu = jb.getInt("preu");
            System.out.println("Zona: " + zona + ", seients: " + seients + ", preu: " + preu);
        }

        // Llegir un fitxer xml
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            File file = new File("DAM\\UF-3 Fitxers\\Gestió Teatre\\infobdd.xml");
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            String base = document.getElementsByTagName("baseDades").item(0).getTextContent();
            String usr = document.getElementsByTagName("nomUser").item(0).getTextContent();
            String pwd = document.getElementsByTagName("password").item(0).getTextContent();

            System.out.println(base+": "+usr+" -> "+pwd);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        // Test data
        LocalDate time;
        time = LocalDate.of(2020, 05, 16);
        System.out.println(time);
        System.out.println(time.toString());

        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix data: ");
        time = LocalDate.parse(sc.nextLine());

        System.out.println(time);
        sc.close();
    }
}
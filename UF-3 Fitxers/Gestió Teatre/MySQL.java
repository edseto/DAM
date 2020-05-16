import java.io.*;
import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public final class MySQL {
    public static Connection conectarBaseDades() {
        Connection conDB = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            File file = new File("DAM\\UF-3 Fitxers\\Gestió Teatre\\infobdd.xml");
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            String base = document.getElementsByTagName("baseDades").item(0).getTextContent();
            String user = document.getElementsByTagName("nomUser").item(0).getTextContent();
            String password = document.getElementsByTagName("password").item(0).getTextContent();

            conDB = DriverManager.getConnection(base, user, password);

        } catch (ParserConfigurationException | IOException | SAXException | SQLException e) {
            e.printStackTrace();
        }
        return conDB;
    }
    
    /*
        La consulta la poso aqui i no en un gestor de persistència de dades perquè és el mateix codi a cada un
        Aquesta funció serà per si es vol fer una consulta diferent a les predefinides a cada classe
    */
    public static ResultSet consultaPersonalitzada(Connection conDB, String consulta) throws SQLException {
        Statement statement = conDB.createStatement();
        return statement.executeQuery(consulta);
    }
}
import java.io.*;
public class High extends Nivell implements NivellBase{

    //Constructors
    public High() {  }
    
    public High(String estat, FileReader file029, FileReader file059) throws Exception {
        setNivell("High");
        setSchools(new Escoles());
        // schools = new Escoles(estat, file029, file059);
    }
}
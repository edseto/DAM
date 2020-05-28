import java.io.*;
public class Elementary extends Nivell implements NivellBase{

    //Constructors
    public Elementary() {  }
    
    public Elementary(String estat, FileReader file029, FileReader file059) throws Exception {
        setNivell("Elementary");
        setSchools(new Escoles());
        //schools = new Escoles(estat, file029, file059);
    }
}
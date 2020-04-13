import java.util.Random;

public class Password {
    private String password;
    private String ultimPassword;
    private int longitud;

    // Getters
    public String getPassword() { return this.password; }
    public String getUltimPassword() { return this.ultimPassword; }
    public int getLongitud() { return this.longitud; }

    // Setters
    public void setUltimPassword(String ultimPassword) { this.ultimPassword = ultimPassword; }
    public void setLongitud(int longitud) { this.longitud = longitud; }
    protected void setPassword(String password) throws Exception{
        this.ultimPassword = this.password;
        this.password = encriptar(password);
    }
    
    //Constructors
    public Password() {
        //Default
    }

    public Password(int longitud) throws Exception{
        this.longitud = longitud;
        crearPassword();
    }

    public Password(int longitud, String passwd) throws Exception{
        if(longitud>passwd.length()) throw new Exception("La contrasenya no te la longitud minima especificada!");

        this.longitud = longitud;
        setPassword(passwd);
    }

    //Mètodes
    public String crearPassword() throws Exception{
        Random r = new Random();
        String passwd="";
        char caracter;
        int i, num, maxim = 126-33;

        if (this.getLongitud() == 0) setLongitud(4);
        //Per si la longitud no s'han inicialitzat
        
        for (i = 0; i < this.getLongitud(); i++) {
            num = (r.nextInt(maxim))+33;
            caracter = (char) num;
            passwd = passwd + caracter;
        }
        setPassword(passwd);

        return passwd; //Passo la contrasenya sense encriptar
    }

    public void canviarPassword(String passwd1, String passwd2) throws Exception{
        
        if(passwd1.length()<this.getLongitud()) throw new Exception("La contrasenya no te la longitud minima");
        else if(!passwd1.equals(passwd2)) throw new Exception("Les contrasenyes no coincideixen");
        
        setPassword(passwd1);
    }

    protected String encriptar(String passwd) throws Exception{
        String encriptat="";
        char caracter;
        int i;

        for (i = 0; i < passwd.length(); i++) {
            caracter = passwd.charAt(i);
            if(caracter<33 || caracter>126) throw new Exception("El caracter a la posicio (començant per 0) "+i+" no es valid");
            else if(caracter==126) caracter = 33;
            else caracter += 1;
            
            encriptat = encriptat + caracter;
        }

        return encriptat;
    }
}
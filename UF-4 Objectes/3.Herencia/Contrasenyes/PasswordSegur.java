import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PasswordSegur extends Password {
    private LocalDate ultimCanvi;
    private int diesVigencia;
    private int longitudMaxima;
    Random r = new Random();

    // Getters
    public LocalDate getUltimCanvi() { return this.ultimCanvi; }
    public int getDiesVigencia() { return this.diesVigencia; }
    public int getLongitudMaxima() { return this.longitudMaxima; }

    // Setters
    public void setUltimCanvi(LocalDate ultimCanvi) { this.ultimCanvi = ultimCanvi; }
    public void setDiesVigencia(int diesVigencia) { this.diesVigencia = diesVigencia; }
    public void setLongitudMaxima(int longitudMaxima) { this.longitudMaxima = longitudMaxima; }

    // Constructors
    public PasswordSegur() {
        // Default
    }

    public PasswordSegur(int longitud, int longitudMaxima) throws Exception {
        if (longitud < 4)
            throw new Exception("La longitud ha de ser 4 o superior per ser segura!");
        if (longitud > longitudMaxima)
            throw new Exception("La longitud maxima ha de ser superior a la minima!");
        this.longitudMaxima = longitudMaxima;
        super.setLongitud(longitud);
        crearPassword();
    }

    public PasswordSegur(int longitud, int longitudMaxima, String contrasenya) throws Exception {
        if (longitud < 4)
            throw new Exception("La longitud ha de ser 4 o superior per ser segura!");
        if (longitud > longitudMaxima)
            throw new Exception("La longitud maxima ha de ser superior a la minima!");
        this.longitudMaxima = longitudMaxima;
        super.setLongitud(longitud);
        posarPassword(contrasenya);
    }

    // Mètodes
    @Override
    public String crearPassword() throws Exception {
        ArrayList<String> contrasenya = new ArrayList<String>();
        int i, index = 0;
        String passwd;
        String[] metodes = { "SpecialChars", "Majus", "Minus", "Nums" };
        char caracter = 'a'; // L'inicialitzo per a què no doni error més avall

        if (super.getLongitud() == 0) setLongitud(4);
        if (this.getLongitudMaxima() == 0) setLongitudMaxima(super.getLongitud());
        //Per si les longituds no s'han inicialitzat

        for (i = 0; i < super.getLongitud(); i++) {
            switch (metodes[index]) {
                case "SpecialChars":
                    caracter = randomSpecialChar();
                    break;
                case "Majus":
                    caracter = randomMajus();
                    break;
                case "Minus":
                    caracter = randomMinus();
                    break;
                case "Nums":
                    caracter = randomNum();
                    break;
            }

            contrasenya.add(caracter + "");
            if (index == metodes.length - 1)
                index = 0;
            else
                index++;
        }
        Collections.shuffle(contrasenya); // Barrejo la contrasenya perquè sino quedaria aixi per exemple: /Ab1*Fy3
        passwd = String.join("", contrasenya); // Passo l'ArrayList de la contrasenya a String

        posarPassword(passwd);

        return passwd;
    }

    private void posarPassword(String passwd) {
        try {
            super.setPassword(passwd);
            setUltimCanvi(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Caracter especial random
    private char randomSpecialChar(){
        int max=126-33, num;
        char caracter;

        do {
            num = (r.nextInt(max))+33;
            caracter = (char)num;
        } while (majuscula(caracter)||minuscula(caracter)||numero(caracter));

        return (char) num;
    }

    private boolean majuscula(char caracter){ return Character.isUpperCase(caracter); }
    private boolean minuscula(char caracter){ return Character.isLowerCase(caracter); }
    private boolean numero(char caracter){ return Character.isDigit(caracter); }

    //Lletra majuscula random
    private char randomMajus(){
        int max=90-65;
        return (char) ((r.nextInt(max))+65);
    }

    //Lletra minusucla random
    private char randomMinus(){
        int max=122-97;
        return (char) ((r.nextInt(max))+97);
    }

    //Numero random
    private char randomNum(){
        int max=57-48;
        return (char) ((r.nextInt(max))+48);
    }

    @Override
    public void canviarPassword(String passwd1, String passwd2) throws Exception{
        
        if(!segura(passwd1)) throw new Exception("La contrasenya no es segura");
        else if(passwd1.length()>this.getLongitudMaxima()) throw new Exception("La longitud supera el maxim permes!");
        else if(this.getPassword() !=null){
            if(!contarDiferentChar(passwd1)) throw new Exception("La contrasenya te menys de 3 caracters diferents");
        }
        
        super.canviarPassword(passwd1, passwd2);
        this.setUltimCanvi(LocalDate.now());
    }

    private boolean contarDiferentChar(String passwd){
        int contador=0, i=0, j=0, num;
        boolean trobat;
        char caracter;

        while (contador<3 && i<passwd.length()) {
            trobat = false;j=0;
            num = passwd.charAt(i);

            if(num==126) num = 33;
            else num += 1;

            caracter = (char) num;
            while (!trobat&&j<super.getPassword().length()) {
                if(!(caracter==super.getPassword().charAt(j))){
                    j++;
                }else{
                    trobat = true;
                }
            }
            if(!trobat) contador++;
            i++;
        }
        if(contador<3) return false;
        return true;
    }

    private boolean segura(String passwd){
        boolean segura = false;

        if(majus(passwd)){
            if (minus(passwd)) {
                if (num(passwd)) {
                    if (specialChar(passwd)) {
                        segura = true;
                    }
                }
            }
        }
        return segura;
    }

    private boolean majus(String passwd){
        boolean trobat = false;
        int i=0;
        char caracter;

        while (!trobat&&i<passwd.length()) {
            caracter = passwd.charAt(i);
            if(majuscula(caracter)) trobat = true;
            else i++;
        }

        return trobat;
    }

    private boolean minus(String passwd){
        boolean trobat = false;
        int i=0;
        char caracter;

        while (!trobat&&i<passwd.length()) {
            caracter = passwd.charAt(i);
            if(minuscula(caracter)) trobat = true;
            else i++;
        }

        return trobat;
    }

    private boolean num(String passwd){
        boolean trobat = false;
        int i=0;
        char caracter;

        while (!trobat&&i<passwd.length()) {
            caracter = passwd.charAt(i);
            if(numero(caracter)) trobat = true;
            else i++;
        }

        return trobat;
    }

    private boolean specialChar(String passwd){
        boolean trobat = false;
        int i=0;
        char caracter;

        while (!trobat&&i<passwd.length()) {
            caracter = passwd.charAt(i);
            if(!Character.isLetterOrDigit(caracter)&&(caracter>32 && caracter<127)) trobat = true;
            else i++;
        }

        if(!trobat) return false;
        return true;
    }

    public boolean precisaCanvi(){
        LocalDate dataFi = this.ultimCanvi.plusDays(this.diesVigencia);

        //Si es més petit que 0 significa que dataFi és abans que la data d'avui
        if(dataFi.compareTo(LocalDate.now())<0) return true; 
        return false;
    }
}
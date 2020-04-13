import java.time.LocalDate;

public class Usuari {
    protected String nom;
    protected LocalDate dataRegistre;
    protected PasswordSegur password;

    // Getters
    public String getNom() { return this.nom; }
    public LocalDate getDataRegistre() { return this.dataRegistre; }
    public PasswordSegur getPassword() { return this.password; }

    // Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setDataRegistre(LocalDate dataRegistre) { this.dataRegistre = dataRegistre; }
    public void setPassword(PasswordSegur password) { this.password = password; }

    // Constructors
    public Usuari() {
        // Default
    }

    public Usuari(String nom, LocalDate dataRegistre, PasswordSegur password) {
        this.nom = nom;
        this.dataRegistre = dataRegistre;
        this.password = password;
    }

    public Usuari(String nom, PasswordSegur password) {
        this.nom = nom;
        this.dataRegistre = LocalDate.now();
        this.password = password;
    }

    public Usuari(String nom, LocalDate dataRegistre, String passwd) {
        registrar(nom, dataRegistre, passwd);
    }

    public Usuari(String nom, LocalDate dataRegistre) {
        this.nom = nom;
        this.dataRegistre = dataRegistre;
        password = new PasswordSegur();

        try {
            password.crearPassword();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuari(String nom) {
        this.nom = nom;
        this.dataRegistre = LocalDate.now();
        password = new PasswordSegur();
        try {
            password.crearPassword();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuari(String nom, String passwd) {
        registrar(nom, passwd);
    }

    // Mètodes
    public boolean autentificar(String nom, String contrasenya) {
        PasswordSegur p1 = new PasswordSegur();
        try {
            p1.setPassword(contrasenya);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nom.equals(this.getNom()) && p1.getPassword().equals(this.password.getPassword());
    }

    public boolean canviarPassword(String passwd1, String passwd2) throws Exception{
        
        if(utilitzat(passwd1)) throw new Exception("La contrasenya ja ha estat utilitzada anteriorment");

        password.canviarPassword(passwd1, passwd2);
        return true;
    }

    private boolean utilitzat(String passwd){
        PasswordSegur p1 = new PasswordSegur();
        try {
            p1.setPassword(passwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if(p1.getPassword().equals(password.getPassword())||p1.getPassword().equals(password.getUltimPassword())) return true;
        return false;
    }

    public void registrar(String nom, LocalDate dataRegistre, String passwd) {
        this.password = new PasswordSegur();
        this.nom = nom;
        this.dataRegistre = dataRegistre;
        this.password.setLongitudMaxima(passwd.length()); //Ho faig perquè després no doni errors, en cas de voler-ho canviar ho pot fer amb els setter

        try {
           canviarPassword(passwd, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrar(String nom, String passwd) {
        this.password = new PasswordSegur();
        this.nom = nom;
        this.dataRegistre = LocalDate.now();
        this.password.setLongitudMaxima(passwd.length()); //Ho faig perquè després no doni errors, en cas de voler-ho canviar ho pot fer amb els setter

        try {
            canviarPassword(passwd, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return nom+" "+dataRegistre+" "+password.getPassword();
    }
}
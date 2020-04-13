import java.time.LocalDate;
import java.util.ArrayList;

public class UsuariSegur extends Usuari {
    private ArrayList<String> passwords = new ArrayList<String>();

    // Constructors
    public UsuariSegur() {
        // Default
    }

    public UsuariSegur(String nom, LocalDate dataRegistre, PasswordSegur password) {
        setNom(nom);
        setDataRegistre(dataRegistre);
        setPassword(password);
    }

    public UsuariSegur(String nom, PasswordSegur password) {
        setNom(nom);
        setDataRegistre(LocalDate.now());
        setPassword(password);
    }

    public UsuariSegur(String nom, LocalDate dataRegistre, String passwd) {
        registrar(nom, dataRegistre, passwd);
    }

    public UsuariSegur(String nom, LocalDate dataRegistre) {
        setNom(nom);
        setDataRegistre(dataRegistre);
        this.password = new PasswordSegur();

        try {
            this.password.crearPassword();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public UsuariSegur(String nom) {
        setNom(nom);
        setDataRegistre(LocalDate.now());
        this.password = new PasswordSegur();

        try {
            this.password.crearPassword();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public UsuariSegur(String nom, String passwd) {
        registrar(nom, passwd);
    }

    // Mètodes
    @Override
    public boolean canviarPassword(String passwd1, String passwd2) throws Exception {
        if (utilitzat(passwd1)) throw new Exception("La contrasenya ja ha estat utilitzada anteriorment");

        super.canviarPassword(passwd1, passwd2);
        passwords.add(super.password.getPassword());
        return true;
    }

    private boolean utilitzat(String passwd) {
        PasswordSegur p1 = new PasswordSegur();
        try {
            p1.setPassword(passwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if(passwords.indexOf(p1.getPassword())!=-1) return true;
        return false;
    }
}
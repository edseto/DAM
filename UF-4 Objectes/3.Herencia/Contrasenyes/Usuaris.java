import java.util.ArrayList;

public class Usuaris {
    // private ArrayList<Usuari> usuaris = new ArrayList<Usuari>();
    private ArrayList<UsuariSegur> usuariSegurs = new ArrayList<UsuariSegur>();
    private int posicio;
    private Password passwordAdmin;

    // Getters
    public Password getPasswordAdmin() {
        return this.passwordAdmin;
    }

    // Setters
    public void setPassswordAdmin(String passwordActual, String nouPassword) throws Exception {
        Password p1 = new Password();
        p1.setPassword(passwordActual);

        if (!p1.getPassword().equals(passwordAdmin.getPassword())) throw new Exception("Contrasenya erronia!");
        passwordAdmin.setPassword(nouPassword);
    }

    // Constructors
    public Usuaris() {
        // Default
        try { //Això no petarà perquè és correcte
            passwordAdmin = new Password(1, "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Mètodes
        //Amb usuaris pre-creats (Objectes)
    public void registrar(UsuariSegur user){ usuariSegurs.add(user); } 
    public void baixa(UsuariSegur user){ usuariSegurs.remove(user); }

        //Usuaris no creats o només passa el nom (String)
    public void registrar(String nom, String password) throws Exception{
        if(userTrobat(nom)) throw new Exception("L'usuari ja existex");
        usuariSegurs.add(new UsuariSegur(nom, password));
    }

    public void baixa(String nom) throws Exception{
        if(!userTrobat(nom)) throw new Exception("L'usuari no esta donat d'alta");
        usuariSegurs.remove(usuariSegurs.get(posicio)); 
    }

        //Llistar tots els usuaris
    public void llistar(){
        for (UsuariSegur usuariSegur : usuariSegurs) System.out.println(usuariSegur);
    }

        //Canviar la contrasenya d'un usuari
    public boolean canviarPassword(String nom, String passwordActual, String passwd1, String passwd2) throws Exception{
        Password p1 = new Password();
        p1.setPassword(passwordActual);

        if(!userTrobat(nom)) throw new Exception("L'usuari no esta donat d'alta");

        if(!p1.getPassword().equals(passwordAdmin.getPassword())){ //Per saber si ho fa amb root
            if(!autentificar(nom, passwordActual)) throw new Exception("Contrasenya erronia, no s'ha pogut autentificar l'usuari!");
        }

        if(!usuariSegurs.get(posicio).canviarPassword(passwd1, passwd2)) throw new Exception("Error al canviar la contrasenya, revisa que tot estigui correcte i contacta amb el soport tecnic!");
        
        return true;
    }

        //Autentificar un usuari
    public boolean autentificar(String nom, String passwd) throws Exception{
        PasswordSegur p1 = new PasswordSegur();
        p1.setPassword(passwd);
        if(!userTrobat(nom)) throw new Exception("L'usuari no existeix");
        
        if(!(usuariSegurs.get(posicio).password.getPassword().equals(p1.getPassword()))) throw new Exception("Contrasenya erronia!");

        return true;
    }

        //Canviar dies vigencia
    public boolean canviarVigencia(String nom, int diesVigencia) throws Exception{
        if(!userTrobat(nom)) throw new Exception("L'usuari no existeix");

        usuariSegurs.get(posicio).password.setDiesVigencia(diesVigencia);
        return true;
    }
    
        //Usuaris que necessiten canviar la contrasenya
    public void precisenCanvi(){
        for (int i = 0; i < usuariSegurs.size(); i++) {
            if(usuariSegurs.get(i).password.precisaCanvi()) System.out.println(usuariSegurs.get(i));
        }
    }

        //Buscar si un usuari existeix a partir del nom
    private boolean userTrobat(String nom){
        boolean trobat = false;
        posicio = 0;

        while (!trobat&&posicio<usuariSegurs.size()) {
            if(usuariSegurs.get(posicio).getNom().equals(nom)) trobat=true;
            else posicio++;
        }

        return trobat;
    }
}
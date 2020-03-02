/*
    2. Cartes
    Una carta ve determinada per un pal oros, bastos, copes i espases i un número, del 1 fins al 12.
    Per a referenciar el pal de la carta, utilitzarem la primera lletra (O,B,C,E) o les seves equivalents
    en minúscula.
    Una carta pertany a un jugador, que numerarem a partir del número 1 (no imposem límit de
    jugadors, tot i que serà un nombre reduït), o bé està a la baralla (no repartida). En aquest últim
    cas, utilitzarem el valor 0.
    La informació introduïda sempre serà correcte. NO cal validar, per exemple, si s'assigna el
    número 13 a una carta, o el pal 'X'.
    La funcionalitat que volem associar a les cartes són (només amb cartes correctes):
        a) toString : cal assignar aquest nom al mètode. Retorna el pal (Oros, Bastos, Copes,
            Espases) i el número de la carta amb el següent format: pal - número. Exemple: Copes - 10.
        b) equals: dues cartes són iguals si són del mateix pal i tenen el mateix número.
        c) pal: dues cartes tenen el mateix pal.
        d) escala: dues cartes formen escala si la diferència entre els dos números és d'una unitat.
            Per exemple, les cartes número 3 i 4, la 6 i 5 o la 12 i 1 totes formen escala.
        e) escala color: apart de formar escala, les dues cartes són del mateix pal.
        f) guanya : la carta c1 guanya a la carta c2 si la carta c1 i c2 són de diferent pal. Si tenen el
            mateix pal, l'as (carta número 1) sempre és la guanyadora. La resta de casos les cartes s'ordenen segons el seu número. La carta número 8 guanya a la número 7 (sempre i quan
            siguin del mateix pal). No hi poden haver dos cartes iguals!
    Apart d'implementar aquesta funcionalitat, cal implementar tots els "getters" i "setters".
    Implementa el programa principal per a comprovar que els teus mètodes són correctes.
*/
public class Carta{
    private String pal;
    private int numero;
    private int jugador;

    //Getters
    public String getPal() { return this.pal; }
    public int getNumero() { return this.numero; }
    public int getJugador() { return this.jugador; }

    //Setters
    public void setPal(String pal) { 
        switch (pal){
            case "O": 
            case "o": pal = "Oros";
                break;
            case "B":
            case "b": pal = "Bastos";
                break;
            case "C":
            case "c": pal = "Copes";
                break;
            case "E":
            case "e": pal = "Espases";
                break;
        }
        this.pal = pal; 
    }
    public void setNumero(int numero) { this.numero = numero; }
    public void setJugador(int jugador) { this.jugador = jugador;}

    //Constructor
    public Carta(String pal, int numero) {
        this.iniciar(pal, numero);
    }

    //Mètodes
    private void iniciar(String pal, int numero){
        int jugador = 0;
        this.setJugador(jugador);
        this.setNumero(numero);
        this.setPal(pal);
    }
    public String toString(){
        return this.getPal()+" - "+this.getNumero();
    }
    public boolean equals(Carta c){
        return c.getPal() == this.getPal() && c.getNumero() == this.getNumero();
    }
    public boolean pal(Carta c){
        return c.getPal() == this.getPal();
    }
    public boolean escala(Carta c){
        boolean escala = false;
        int result;

        result = Math.abs(c.getNumero()-this.getNumero());
        if(this.getNumero()==12&&c.getNumero()==1){
            escala = true;
        }else if(result==1){
            escala = true;
        }

        return escala;
    }
    public boolean escalaColor(Carta c){
        return escala(c) && pal(c);
    }
    public boolean guanya(Carta c){
        boolean guanya = false;

        if(c.pal(this)){
            if(this.getNumero()==1){
                guanya = true;
            }else if(c.getNumero()==1){
                guanya = false;
            }else if(this.getNumero()>c.getNumero()){
                guanya = true;
            }
        }else{
            guanya = true;
        }

        return guanya;
    }
}
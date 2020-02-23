/*
    6. Joc dels escuradents
    "En un juego para dos jugadores, se colocan 23 palillos sobre una mesa y cada contrincante
    cogerá alternativamente, uno, dos o tres palillos por vez, según prefiera. perderá el jugador que
    se vea forzado a coger el último palillo.
    Es proposa fer una modificació del joc amb les següents característiques.
    1. Es mostrarà un menú que tindrà les següents opcions
        a) Introduir nombre de jugadors (mínim 2 i màxim 5). Cal validar la dada.
        b) Introduir nom jugadors. Si no s'han introduït el nombre de jugadors, es consideren
            2 jugadors.
        c) Introduir número d'escuradents amb què jugar ( mínim 23 ). El número
            d'escuradents introduït ha de ser primer (només divisible per ell mateix i per 1). El
            nombre màxim serà de 101 escuradents.
        d) Jugar. Si no s'han inicialitzat el nombre de jugadors i el número d'escuradents, els
            valors que s'utilitzaran seran 2 jugadors i 23 escuradents. Si no s'han introduït els
            noms dels jugadors, s'utilitzarà els números 1, 2 , 3 , 4 i 5 per a determinar cada
            jugador.
        e) Veure partida. Mostra l'historial de tota la partida i qui ha estat el perdedor. En
            aquest joc, hi ha un perdedor i la resta són tots guanayadors.
        f) Sortir

    En la següent imatge es mostra un exemple d’historial entre una partida de 2 jugadors jugada per en
    Miquel i la Maria. Si no s’haguessin introduït els noms dels jugadors, el jugador Miquel seria el
    número 1 i la jugadora Maria seria el nombre 2.
*/
import java.util.Scanner;
public class Escuradents{
    public static int NumeroJugadors(){
        Scanner sc = new Scanner(System.in);
        int numJugadors;

        do {
            System.out.print("Introdueix el numero de jugadors (minim 2 i maxim 5): ");
            numJugadors = sc.nextInt();
        } while (numJugadors<2 || numJugadors>5);

        return numJugadors;
    }
    public static void NomJugadors(String[] nomJugadors, int numJugadors){
        Scanner sc = new Scanner(System.in);
        int i;

        for(i=1;i<=numJugadors;i++){
            System.out.print("Introdueix el nom del jugador"+i+": ");
            nomJugadors[i] = sc.next();
        }
    }
    public static int DemanarEscuradents(){
        Scanner sc = new Scanner(System.in);
        int escuradents = 0;
        boolean correcte = false;

        do {
            System.out.print("Introdueix el numero de escuradents (minim 23 i maxim 101, ha de ser un nombre primer): ");
            escuradents = sc.nextInt();

            if(escuradents>22 && escuradents<102){
                correcte = EsPrimer(escuradents, 2);
            }else{
                System.out.println("Introdueixi un numero de escuradents correcte.");
            }
        } while (!correcte);

        return escuradents;
    }
    public static boolean EsPrimer(int num, int divisor){
        boolean esPrimer;

        if(num/2 < divisor && num!=1){
            esPrimer = true;
        }else{
            if(num%divisor==0 || num==1){
                esPrimer = false;
            }else{
                return EsPrimer(num, divisor+1);
            }
        }
        return esPrimer;
    }
    public static void Jugar(String[] nomJugadors, int numEscuradents, int numJugadors, String[] historial){
        Scanner sc = new Scanner(System.in);
        int nMoves = 0, index = 0, accio, min=-3, max=-1;

        if(nomJugadors[index+1]==null){
            for(int i=1;i<=numJugadors;i++){
                nomJugadors[i] = "Jugador"+i;
            }
        }

        do {
            nMoves++;index++;
            if(index == numJugadors+1){
                index = 1;
            }
            do {
                System.out.print("Moviment: "+nMoves+" Jugador: "+nomJugadors[index]+" Accio: ");
                accio = sc.nextInt();
            } while (accio<min || accio>max);
            numEscuradents += accio;
            historial[nMoves] = "Moviment: "+nMoves+" Jugador: "+nomJugadors[index]+" Accio: "+accio+" Escuradents restants: "+numEscuradents;
            if(numEscuradents<3){
                max = numEscuradents*-1;
            }
            System.out.println("Escuradents restants: "+numEscuradents);
            
        } while (numEscuradents>0);

        System.out.println("Ha perdut el jugador: "+nomJugadors[index]);
        historial[nMoves+1] = "Ha perdut el jugador: "+nomJugadors[index];
        System.out.println();

    }
    public static void Historial(String[] historial){
        int index=1;

        while(historial[index]!=null){
            System.out.println(historial[index]);
            index++;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean finish = false;
        char opcio;
        String[] nomJugadors = new String[6]; //La faig de 6 perquè començo per index 1
        String[] historial = new String[103]; 
        /*La faig de 103 perquè restan d'un en un són 101 moviments més un espai 
        per guardar el perdedor i un més perque sóc especial i començo per index 1
        */
        int numJugadors = 2, numEscuradents = 23;

        do {
            System.out.println("JOC DELS ESCURADENTS:");
            System.out.println("a) Introduir nombre de jugadors (minim 2 i maxim 5).");
            System.out.println("b) Introduir nom jugadors.");
            System.out.println("c) Introduir numero escuradents.");
            System.out.println("d) Jugar.");
            System.out.println("e) Veure historial de la partida");
            System.out.println("f) Sortir.");
            System.out.print("Introdueixi una opcio valida (a-f): ");
            opcio = sc.next().charAt(0);
            switch (opcio){
                case 'a': numJugadors = NumeroJugadors();
                    break;
                case 'b': NomJugadors(nomJugadors, numJugadors);
                    break;
                case 'c': numEscuradents = DemanarEscuradents();
                    break;
                case 'd': Jugar(nomJugadors, numEscuradents, numJugadors, historial);
                    break;
                case 'e': Historial(historial);
                    break;
                case 'f': finish = true;
                    break;
            }
        } while (!finish);
    }
}
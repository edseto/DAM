/*
    7. Es tracta de fer un programa on l’ordinador genera un número entre 0 i 100. L’usuari també
    introdueix un número entre 0 i 100. Cal validar la introducció del número. Tant l’usuari com
    l’ordinador han d’intentar endevinar el número del rival. L’única informació que disposaran
    l’ordinador i l’usuari per a endevinar el número és si el número que han d’endevinar és més
    petit o més gran.
*/
import java.util.Scanner;
import java.util.Random;
public class Endevinat{
    public static boolean GranOPetit(int numPC, int valor){
        boolean gran;

        if(numPC>valor){
            gran = true;
        }else{
            gran = false;
        }

        return gran;
    }
    public static boolean haGuanyat(String player, int numPC, int numPlayer){
        boolean endevinat=false;

        if(numPC==numPlayer){
            endevinat = true;
        }
        return endevinat;
    }
    public static int IntroduirValors(int petit, int gran){
        Scanner sc = new Scanner(System.in);
        int numPlayer;
        do {
            System.out.print("Introdueix un numero entre " +petit +" i " +gran+": ");
            numPlayer = sc.nextInt();
        } while (numPlayer<petit||numPlayer>gran);

        return numPlayer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int numPC, numeros, valor, numPlayer, petit=0, gran=100, contador=1;
        boolean endevinat=false, mesGran=true;

        numPC = r.nextInt(101);
        numPlayer = IntroduirValors(petit, gran);
        
        System.out.println("Intent numero: "+contador);
        endevinat = haGuanyat("Jugador", numPC, numPlayer);
        
        if(!endevinat){
            do {
                numeros = r.nextInt(101);
                valor = IntroduirValors(petit, gran);
                
                contador++;
                mesGran = GranOPetit(numPC, valor);

                if(mesGran){
                    petit = valor;
                    System.out.println("El numero es mes gran");
                }else{
                    gran = valor;
                    System.out.println("El numero es mes petit");
                }

                if(!haGuanyat("PC", numeros, numPlayer)&&!haGuanyat("Jugador", numPC, valor)){
                    System.out.println("Intent numero: "+contador);
                }
            } while (!haGuanyat("PC", numeros, numPlayer)&&!haGuanyat("Jugador", numPC, valor));

            if(haGuanyat("Jugador", numPC, valor)){
                System.out.println("Has guanyat!");
            }else{
                System.out.println("Has perdut. El numero era "+numPC);
            }
            
        }else{

            if(haGuanyat("Jugador", numPC, numPlayer)){
                System.out.println("Has guanyat!");
            }else{
                System.out.println("Has perdut. El numero era "+numPC);
            }
        }

    }
}
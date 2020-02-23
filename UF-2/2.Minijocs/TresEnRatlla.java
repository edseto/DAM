/*
    1. Implementa el joc de tres en ratlla a partir del següent codi. Primer tirarà el jugador X i
    després tirarà el jugador Z. La funció tira demana al jugador que entri una fila i una columna
    que és on vol ubicar la peça. Es van ubicant peces fins que un dels dos jugadors aconsegueix
    alinear tres peces en línia o bé no queden caselles buides per a ubicar peces.
*/
import java.util.Scanner;
public class TresEnRatlla{
    public static void imprimirTauler(char[][] tauler){
        System.out.println("Jugador Z: Rodones O");
        System.out.println("Jugador X: Creus X");
        System.out.println();
        System.out.println("  1   "+"2   "+"3");
        System.out.println(1+" "+tauler[0][0] + " | " + tauler[0][1] + " | " + tauler[0][2]);
        System.out.println("  ---------");
        System.out.println(2+" "+tauler[1][0] + " | " + tauler[1][1] + " | " + tauler[1][2]);
        System.out.println("  ---------");
        System.out.println(3+" "+tauler[2][0] + " | " + tauler[2][1] + " | " + tauler[2][2] + "\n");
    }
    public static boolean ComprovarLinia(char[][] tauler, boolean guanyat, char fitxa){
        int i=0, j;
        boolean esFitxa=true;

        while(!guanyat&&i<3){
            j=0;
            // esFitxa = true;
            while(esFitxa&&j<3){
                if(tauler[i][j]==fitxa){
                    esFitxa = true;
                }else{
                    esFitxa = false;
                }
                j++;
            }
            if(esFitxa){
                guanyat = true;
            }else{
                guanyat = false;
            }
            i++;
        }
        return guanyat;
    }
    public static boolean ComprovarDiagonal(char[][] tauler, boolean guanyat, char fitxa){
        int i, j;
        boolean esFitxa;

        if(!guanyat){
            esFitxa = true;
            i=0;j=0;
            while(esFitxa&&j<3){
                if(tauler[i][j]==fitxa){
                    esFitxa = true;
                }else{
                    esFitxa = false;
                }
                i++;j++;
            }
            if(esFitxa){
                guanyat = true;
            }
        }
        if(!guanyat){
            esFitxa = true;
            i=2;j=0;
            while(esFitxa&&j<3&&i>=0){
                if(tauler[i][j]==fitxa){
                    esFitxa = true;
                }else{
                    esFitxa = false;
                }
                i--;j++;
            }
            if(esFitxa){
                guanyat = true;
            }
        }
        return guanyat;
    }
    public static boolean ComprovarColumna(char[][] tauler, boolean guanyat, char fitxa){
        int i=0, j=0;
        boolean esFitxa=true;

        while(!guanyat&&j<3){
            i=0;
            esFitxa = true;
            while(esFitxa&&i<3){
                if(tauler[i][j]==fitxa){
                    esFitxa = true;
                }else{
                    esFitxa = false;
                }
                i++;
            }
            if(esFitxa){
                guanyat = true;
            }else{
                guanyat = false;
            }
            j++;
        }
        return guanyat;
    }
    public static boolean haGuanyat(char jugador, char[][] tauler){
        boolean guanyat=false;
        char fitxa;

        if(jugador=='Z'){
            fitxa = 'O';
        }else{
            fitxa = 'X';
        }
        //Comprovar en línia
        guanyat = ComprovarLinia(tauler, guanyat, fitxa);
        //Comprovar en columna
        if(!guanyat){
            guanyat = ComprovarColumna(tauler, guanyat, fitxa);
        }
        //Comprovar en diagonal
        if(!guanyat){
            guanyat = ComprovarDiagonal(tauler, guanyat, fitxa);
        }

        return guanyat;
    }
    public static boolean potTirar(char[][] tauler){
        boolean tirar = false;
        int i=0, j;
        
        while(!tirar&&i<3){
            j=0;
            while(!tirar&&j<3){
                if(tauler[i][j]=='X'||tauler[i][j]=='O'){
                    tirar = false;
                }else{
                    tirar = true;
                }
                j++;
            }
            i++;
        }

        return tirar;
    }
    public static boolean ComprovarPosicio(char[][] tauler, int fila, int columna){
        boolean posicioCorrecte = true;

        if(fila<0&&fila>2){
            posicioCorrecte = false;
        }else if(columna>=0&&columna<3){
            if(tauler[fila][columna]=='X'||tauler[fila][columna]=='O'){
                posicioCorrecte = false;
            }else{
                posicioCorrecte = true;
            }
        }

        return posicioCorrecte;
    }
    public static void tira(char jugador, char[][] tauler){
        Scanner sc = new Scanner(System.in);
        int fila, columna;
        boolean posicioCorrecte;
        char fitxa;

        if(jugador=='Z'){
            fitxa = 'O';
        }else{
            fitxa = 'X';
        }
        do {
            System.out.println("Jugador "+ jugador);
            System.out.print("Introdueix les coordenades (ex. 1 1): ");
            fila = sc.nextInt()-1;
            columna = sc.nextInt()-1;
            posicioCorrecte = ComprovarPosicio(tauler, fila, columna);
            if(!posicioCorrecte){
                System.out.println("Introdueixi una posicio correcta");
            }
        } while (!posicioCorrecte);
        tauler[fila][columna] = fitxa;
    }
    public static void main(String[] args) {
        char [][]tauler = new char[3][3];

        System.out.println("Benvingut al 3 en ratlla!! Les normes son simples:");
        System.out.println("Aconsegueix alinear 3 de les teves fitxes abans que el rival per guanyar!!");
        System.out.println("Molta sort jugadors!!");
        System.out.println();
        imprimirTauler(tauler);
        
        while(!haGuanyat('Z',tauler) && !haGuanyat('X',tauler) && potTirar(tauler)){
            if(!haGuanyat('Z',tauler) && potTirar(tauler)){
                tira('X',tauler);
                imprimirTauler(tauler);
            }

            if (!haGuanyat('X',tauler) && potTirar(tauler)){
                tira('Z',tauler);
                imprimirTauler(tauler);
            } 
        }
        
        if (haGuanyat('X',tauler)){
            System.out.println("Guanyador jugador X");
        }else if (haGuanyat('Z',tauler)){
            System.out.println("Guanyador jugador Z");
        }else{
            System.out.println("Empat!!");
        }
    }
}
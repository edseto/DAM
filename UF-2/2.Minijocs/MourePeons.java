/*
    2. En el nostre cas el peó només podrà avançar endavant, 1 casella a cada torn. Primer tiren les
    blanques i després mouen les negres. Primer es selecciona el peó que es vol moure i s'indica a
    quina casella es vol moure. La partida acaba quan s'introdueix la casella 9I .
*/
import java.util.Scanner;
public class MourePeons{
    public static void IniciTauler(char [][]tauler, char[][] colors){
        int i, j;
        char blanc='B', negre='N';
        
        for(i=0;i<8;i++){ 
            for(j=0;j<8;j++){
                if(i==0||i==1){
                    colors[i][j] = blanc;
                }else if(i==6||i==7){
                    colors[i][j] = negre;
                }
                if(i%2==j%2){
                    tauler[i][j] = blanc;
                }else{
                    tauler[i][j] = negre;
                }
            }
        }
    }
    public static void PosarPeces(char [][]tauler){
        int i;
        String peces = "TCADRACT";
        char peo = 'P';

        for(i=0;i<peces.length();i++){
            tauler[0][i] = peces.charAt(i);
            tauler[7][i] = peces.charAt(i);
        }
        for(i=0;i<8;i++){
            tauler[1][i] = peo;
            tauler[6][i] = peo;
        }
    }
    public static void ImprimirTauler(char [][]tauler){
        int i, j, index=1;
        String abecedari="ABCDEFGH";

        for(i=0;i<abecedari.length();i++){
            System.out.print("  "+abecedari.charAt(i));
        }
        System.out.println();
        for(i=0;i<8;i++){
            System.out.print(index+" ");
            for(j=0;j<8;j++){
               System.out.print(tauler[i][j]+"  ");
            }
            System.out.print("\n");
            index++;
        }
    }
    public static boolean Finalitzar(int fila, char columna){
        boolean finish;
        
        if(fila==9&&columna=='I'){
            finish = true;
        }else{
            finish = false;
        }

        return finish;
    }
    public static boolean ComprovarDesti(char[][] tauler, int filaDesti, char columnaDesti, int fila, char columna){
        boolean movimentCorrecte;
        int resultatFila;
        columnaDesti-=64; //Per obtenir el numero de la columna
        columna-=64; //Per obtenir el numero de la columna
        resultatFila = Math.abs(filaDesti-fila);

        if(resultatFila==1&&(columnaDesti==columna)){
            movimentCorrecte = true;
        }else{
            movimentCorrecte = false;
        }

        return movimentCorrecte;
    }
    public static void MourePeo(char[][] tauler, int fila, int filaDesti, char columna, char[][] colors, char color){
        columna-=65; //Per obtenir el numero de la columna
        filaDesti--;fila--;

        if(fila%2==columna%2){
            tauler[fila][columna] = 'B';
        }else{
            tauler[fila][columna] = 'N';
        }
        tauler[filaDesti][columna] = 'P';
        colors[filaDesti][columna] = color;

    }
    public static boolean ComprovarPeo(char[][] tauler, int fila, char columna, char color, char[][] colors){
        boolean esPeo;
        fila--;
        columna-=65; //Per obtenir el numero de la columna

        if(tauler[fila][columna]=='P'&&color==colors[fila][columna]){
            esPeo = true;
        }else{
            esPeo = false;
        }
        return esPeo;
    }
    public static int DemanarFila(){
        int fila;
        Scanner sc = new Scanner(System.in);

        System.out.print("Entra la fila: ");
        fila = sc.nextInt();

        return fila;
    }
    public static char DemanarColumna(){
        char columna;
        Scanner sc = new Scanner(System.in);

        System.out.print("Entra la columna: ");
        columna = sc.next().charAt(0);
        return columna;
    }
    public static boolean DemanarDades(char[][] tauler, char[][] colors, char color){
        int fila;
        char columna;
        boolean esPeo = true;

        do {
            System.out.println("Seleccioni la peça que vol desplaçar");
            
            fila = DemanarFila();
            columna = DemanarColumna();

            if(!Finalitzar(fila, columna)){
                if(!ComprovarPeo(tauler, fila, columna, color, colors)){
                    System.out.println("En aquesta casella no hi ha un peo o es del color contrari. Seleccioni un peo");
                    esPeo = false;
                }else{
                    DestiPeo(fila, columna, tauler, colors, color);
                    esPeo = true;
                }
            }
        } while (!Finalitzar(fila, columna)&&!esPeo);

        return Finalitzar(fila, columna);
    }
    public static void DestiPeo(int fila, char columna, char[][] tauler, char[][] colors, char color){
        int filaDesti;
        char columnaDesti;

        if(!Finalitzar(fila, columna)){
            do {
                System.out.println("Seleccioni la casella desti de la peça");
                filaDesti = DemanarFila();
                columnaDesti = DemanarColumna();

                if(!ComprovarDesti(tauler, filaDesti, columnaDesti, fila, columna)){
                    System.out.println("Introdueixi una casella correcta. Recorda que nomes pots moure una casella");
                }
            } while (!ComprovarDesti(tauler, filaDesti, columnaDesti, fila, columna));
            
            MourePeo(tauler, fila, filaDesti, columna, colors, color);
        }
    }
    public static void main(String[] args) {
        char[][] tauler = new char[8][8];
        char[][] colors = new char[8][8];
        char color = 'B', abans='N', aux;
        boolean finish=false;

        IniciTauler(tauler, colors);
        PosarPeces(tauler);

        do {
            ImprimirTauler(tauler);
            finish = DemanarDades(tauler, colors, color);
            aux = abans;
            abans = color;
            color = aux;
        } while (!finish);
    }
}
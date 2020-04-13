import java.util.Scanner;
import java.util.Random;
public class Vaixells{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        char tauler[][] = new char[Constants.FILES][Constants.COLUMNES];
        char columna;
        int i, j, numFila, numColumna, numVaixell=0, moviment, total, colDesti;
        int[][] vaixellSelect = new int[8][2];
        boolean vaixell=false, pedra=false, filaCorrecte=true, colCorrecte=true, movimentCorrecte=false;
        String posicioVaixell;
        String[] barcos= new String[7];
/*
Per guardar la fila i columna introduida crearé dos variables
tinc la variable columna per guardar la lletra i buscar a quin index 
de l'abecedari està, aixi sé el número de columna i per la fila
simplement amb una variable de tipus int que es diu numFila
I guardaré les dades introduides en una array de tipus String anomenada
barcos
*/
        //Tauler Buit
        for(i=0;i<Constants.FILES;i++){
            for(j=0;j<Constants.COLUMNES;j++){
                tauler[i][j] = 'O';
            }
        }
        //Colocació vaixells i pedres
        for(i=0;i<Constants.TOTAL_VAIXELLS;i++){
            do {
                numFila = r.nextInt(10);
                numColumna = r.nextInt(10);
                if(tauler[numFila][numColumna]=='V'){
                    vaixell = true;
                }else{
                    tauler[numFila][numColumna]='V';
                    vaixell = false;
                }
            } while (vaixell==true);
        }
        for(i=0;i<Constants.TOTAL_PEDRES;i++){
            do {
                numFila = r.nextInt(10);
                numColumna = r.nextInt(10);
                if(tauler[numFila][numColumna]=='X'){
                    pedra = true;
                }else{
                    tauler[numFila][numColumna]='X';
                    pedra = false;
                }
            } while (pedra==true);
        }
        //Imprimir Tauler
        System.out.print("   "+Constants.ABECEDARI.charAt(0));
        for(i=1;i<Constants.COLUMNES;i++){
            System.out.print(" "+Constants.ABECEDARI.charAt(i));
        }
        System.out.println();
        for(i=0;i<Constants.FILES;i++){
            System.out.print(i+"  ");
            for(j=0;j<Constants.COLUMNES;j++){
                System.out.print(tauler[i][j]+" ");
            }
            System.out.println();
        }
        //Seleccionar Vaixell
        do {
            System.out.print("Seleccioni un vaixell: ");
            posicioVaixell = sc.next();
            barcos[numVaixell] = posicioVaixell;
            if(!(posicioVaixell.equals("FI"))){
                numFila = posicioVaixell.charAt(0)-48;
                if(numFila>0&&numFila<Constants.FILES){
                    filaCorrecte=true;
                    vaixellSelect[numVaixell][0] = numFila;
                }else filaCorrecte=false;
                columna = posicioVaixell.charAt(1);
                numColumna = Constants.ABECEDARI.indexOf(columna);
                if(tauler[numFila][numColumna]=='V') vaixell=true; else vaixell=false;
                if((numColumna>0&&numColumna<Constants.COLUMNES)&&vaixell==true){
                    colCorrecte=true;
                    vaixellSelect[numVaixell][1] = numColumna;
                    numVaixell++;
                }else colCorrecte=false;
            }else{break;}
            System.out.println();
        } while (posicioVaixell!="FI"||!filaCorrecte||!colCorrecte||numVaixell<Constants.TOTAL_VAIXELLS);
        barcos[numVaixell+1]="-1";
        //Ensenyar vaixells seleccionats
        System.out.println("VAIXELLS SELECCIONATS");
        i=0;
        do {
            if(!(barcos[i].equals("-1"))&&(!(barcos[i].equals("FI")))){
                vaixell=true;
                i++;
                System.out.println(i+" - "+barcos[i-1]);
            }else{
                vaixell=false;
            }
        } while (vaixell==true);
        //Seleccionar vaixell a desplaçar
        System.out.print("Seleccioni un vaixell del llistat anterior: ");
        numVaixell = sc.nextInt();
        do {
            System.out.print("Introdueixi el desplaçament horitzontal: ");
            moviment = sc.nextInt();
            total = Constants.COLUMNES-moviment;
            if(total>0){
                movimentCorrecte=true;
            }else{
                movimentCorrecte=false;
            }
        } while (movimentCorrecte==false||moviment==0);
        numVaixell-=1;
        numFila = vaixellSelect[numVaixell][0];
        numColumna = vaixellSelect[numVaixell][1];
        colDesti = numColumna+moviment;
        i=1;vaixell=false;pedra=false;
        do {
            if(tauler[numFila][numColumna+i]=='V'){
                vaixell=true;
                tauler[numFila][numColumna]='O';
                tauler[numFila][numColumna+i]='O';
            }else if(tauler[numFila][numColumna+i]=='X'){
                tauler[numFila][numColumna]='O';
                tauler[numFila][colDesti]='O';
                pedra=true;
            }else{
                tauler[numFila][colDesti]='V';
                tauler[numFila][numColumna]='O';
            }
            i++;
        } while (!pedra&&!vaixell&&i<=moviment);
        //Imprimir resultat
        if(pedra==true){
            System.out.println("XAFXAF!");
        }else if(vaixell==true){
            System.out.println("CRASHCRASH!");
        }else{
            System.out.println("MOVIMENT SENSE PROBLEMES!");
        }
        //Imprimir tauler
        System.out.print("   "+Constants.ABECEDARI.charAt(0));
        for(i=1;i<Constants.COLUMNES;i++){
            System.out.print(" "+Constants.ABECEDARI.charAt(i));
        }
        System.out.println();
        for(i=0;i<Constants.FILES;i++){
            System.out.print(i+"  ");
            for(j=0;j<Constants.COLUMNES;j++){
                System.out.print(tauler[i][j]+" ");
            }
            System.out.println();
        }
    }
}
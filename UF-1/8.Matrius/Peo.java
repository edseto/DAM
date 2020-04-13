import java.util.Scanner;
public class Peo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean columnExist=false, correcte=false;
        int i, j, filaInici, filaFI, ncolumna=1;
        String abecedari=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros=" 123456789";
        char blanc='B', negre='N', torre='T', rei='R', peo='P', dama='D', cavall='C', alfil='A', columna;
        char[][] tauler = new char[9][9];

        for(i=0;i<9;i++){
            for(j=1;j<9;j++){
                tauler[i][j] = abecedari.charAt(j);
            } 
        }
        for(i=1;i<9;i++){
            tauler[i][0] = numeros.charAt(i);
        }
        for(i=1;i<9;i++){
            for(j=1;j<9;j++){
                if(i%2==j%2){
                    tauler[i][j] = blanc;
                }else{
                    tauler[i][j] = negre;
                }
            }
        }
        for(i=1;i<9;i++){
            if(i==1||i==8){
                tauler[1][i] = torre;
                tauler[8][i] = torre;
            }else if(i==2||i==7){
                tauler[1][i] = cavall;
                tauler[8][i] = cavall;
            }else if(i==3||i==6){
                tauler[1][i] = alfil;
                tauler[8][i] = alfil;
            }else if(i==4){
                tauler[1][i] = dama;
                tauler[8][i] = dama;
            }else{
                tauler[1][i] = rei;
                tauler[8][i] = rei;
            }
        }
        for(i=1;i<9;i++){
            tauler[2][i] = peo;
            tauler[7][i] = peo;
        }
        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
               System.out.print(tauler[i][j]+" ");
            }
            System.out.print("\n");
        }
        //Demanar moviment Peó
        do {
            System.out.print("Seleccioni la peça a moure. Introdueixi la fila (1-8): ");
            filaInici = sc.nextInt();
        } while (filaInici<1||filaInici>8);
        do {
            System.out.print("Introdueixi la columna (A-H): ");
            columna = sc.next().charAt(0);
            for(j=1;j<11;j++){
                if(columna==tauler[0][j]){
                    columnExist = true;
                    ncolumna = j;
                    break;
                }else{
                    columnExist = false;
                }
            }
        } while (!columnExist);
        do {
            System.out.print("Seleccioni la fila on vol moure la peça. Introdueixi la fila (1-8): ");
            filaFI = sc.nextInt();
        } while (filaFI<1||filaFI>8);
        //Moviment Peó
        if(filaFI-filaInici<3){
            tauler[filaFI][ncolumna] = peo;
            if(filaInici%2==ncolumna%2){
                tauler[filaInici][ncolumna] = blanc;
            }else{
                tauler[filaInici][ncolumna] = negre;
            }
        }
        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
               System.out.print(tauler[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
/*
    5. Fes una funció que donada una fila i una columna
    em retorni si la casella és blanca o negra. Recorda
    que si la fila i columna són imparells o parells, a la
    casella li correspon el color blanc (B) , en cas
    contrari, cal que retorni que és negra (N). La fila i
    columna introduïda sempre seran valors vàlids.
*/
import java.util.Scanner;
public class ColorTauler{
    public static void IniciTauler(char [][]tauler){
        int i, j;
        String abecedari=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros=" 123456789";
        char blanc='B', negre='N', torre='T', rei='R', peo='P', dama='D', cavall='C', alfil='A';

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
    }
    public static void ImprimirTauler(char [][]tauler){
        int i, j;

        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
               System.out.print(tauler[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public static char ComprovarColor(char columna, int fila){
        char color;
        columna-=64;

        if(fila%2==columna%2){
            color='B';
        }else{
            color='N';
        }

        return color;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fila;
        char[][] tauler = new char[9][9];
        char columna, color;

        IniciTauler(tauler);
        ImprimirTauler(tauler);
        System.out.println();

        //Demanar posicio
        System.out.print("Entra la columna: ");
        columna = sc.next().charAt(0);
        System.out.print("Entra la fila: ");
        fila = sc.nextInt();
        
        color = ComprovarColor(columna, fila);
        System.out.println(color);
    }
}
/*
    8. Per a poder implementar el joc és imprescindible saber
    si una peça és blanca o negra. En aquest cas, tindrem
    una segona matriu que ens dirà cada peça si és de color
    blanc o negre. Utilitzarem la lletra B per a blanc i N per
    a negre. Modifica les funcions anteriors per tal que
    quan s’ubiquin les peces es mantingui la segona matriu.
*/
public class ColorPieza{
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
            if(i>2&&i<7){
                System.out.print(i);
            }else{
                for(j=0;j<9;j++){
                    System.out.print(tauler[i][j]+" ");
                }
            }
            System.out.print("\n");
        }
    }
    public static void ColorPeces(char [][]tauler){
        int i, j;
        char blanc = 'B', negre = 'N';

        for(i=1;i<9;i++){
            for(j=1;j<9;j++){
                if(i==1||i==2){
                    tauler[i][j] = blanc;
                }else if(i==7||i==8){
                    tauler[i][j] = negre;
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] tauler = new char[9][9];

        IniciTauler(tauler);
        ImprimirTauler(tauler);
        System.out.println();
        System.out.println("Tauler amb els colors de les peces:");
        ColorPeces(tauler);
        ImprimirTauler(tauler);
    }
}
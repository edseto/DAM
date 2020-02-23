/*
    6. Per a crear el fitxer d’escacs crearem tres funcions «principals». La primera funció
    inicialitzarem el tauler pintant cada casella de color blanc o negre (utilitza la funció creada
    anteriorment per a determinar el color de la casella). La segona funció serà per a ubicar les
    peces blanques i negres en el taulell en la seva posició inicial. La tercera funció serà la que
    imprimirà el tauler d’escacs i que ens permet saber si les nostres funcions són correctes.
    Tingueu en compte que dins de les funcions podem crear altres funcions.
*/
public class TaulerInicialitzat{
    public static void IniciTauler(char [][]tauler){
        int i, j;
        String numeros=" 123456789";
        String abecedari=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char blanc='B', negre='N';
        
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
        
    }
    public static void PosarPeces(char [][]tauler){
        int i, j;
        char torre='T', rei='R', peo='P', dama='D', cavall='C', alfil='A';

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
    public static void main(String[] args) {
        char[][] tauler = new char[9][9];

        IniciTauler(tauler);
        PosarPeces(tauler);
        ImprimirTauler(tauler);
    }
}
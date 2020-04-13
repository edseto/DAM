public class Peces{
    public static void main(String[] args) {
        int i, j;
        String abecedari=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros=" 123456789";
        char blanc='B', negre='N', torre='T', rei='R', peo='P', dama='D', cavall='C', alfil='A';
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
    }
}
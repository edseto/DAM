public class Escacs{
    public static void main(String[] args) {
        int i, j;
        String abecedari=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros=" 123456789";
        char blanc = 'B', negre = 'N';
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
        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
               System.out.print(tauler[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
import java.util.Random;
public class Arbre{
    public static void main(String[] args) {
        Random r = new Random();
        int i, j, max=1, espaimax=12;
        String caracter="O*";
        char bola;
        for(i=1;i<=10;i++){
            for(j=1;j<=espaimax;j++){
                System.out.print(" ");
            }
            for(j=1;j<=max;j++){
                bola = caracter.charAt(r.nextInt(caracter.length()));
                //Aixo genera un caracter aleatori dels que he afegit al String caracter
                if((j%2==0)&&(bola=='O')){
                    System.out.print('*');
                }else{
                    System.out.print(bola);
                }
            }
            espaimax--;max+=2;
            System.out.print("\n");
        }
        //Tronc
        for(i=1;i<=3;i++){
            System.out.print("\t");
            for(j=1;j<=9;j++){
                System.out.print("*"); 
            }
            System.out.print("\n");
        }
    }
}
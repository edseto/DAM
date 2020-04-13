import java.util.Scanner;
public class Consonancia{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paraula;
        boolean esVocal, relacio=true;
        int i, curta;
        int[] coincidencia;
        char[] paraula1;
        char[] paraula2;
        char La='a', Le='e', Li='i', Lo='o', Lu='u';

        System.out.print("Entra la primera paraula: ");
        paraula = sc.next();
        paraula1 = new char[paraula.length()];
        coincidencia = new int[paraula.length()];
        paraula = paraula.toLowerCase();
        paraula1 = paraula.toCharArray();

        System.out.print("Entra la segona paraula: ");
        paraula = sc.next();
        paraula = paraula.toLowerCase();
        paraula2 = paraula.toCharArray();
        if(paraula1.length<paraula2.length){
            curta=paraula1.length;
        }else{
            curta=paraula2.length;
        }

        for(i=0;i<curta;i++){
            if((paraula1[i]|paraula2[i])==(La|Le|Li|Lo|Lu)){
                esVocal=true;
            }else{
                esVocal=false;
            }
            if(!esVocal && paraula1[i]==paraula2[i]){
                coincidencia[i]=1;
            }else if(!esVocal){
                coincidencia[i]=2;
            }
        }
        i=0;
        while(i<curta&&relacio){
            if(coincidencia[i]==2){
                relacio=false;
                break;
            }else{
                relacio=true;
            }
            i++;
        }
        if(relacio){
            System.out.println("Les dues paraules estan en consonancia");
        }else{
            System.out.println("Les dues paraules no estan en consonancia");
        }
    }
}
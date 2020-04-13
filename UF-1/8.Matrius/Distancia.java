import java.util.Scanner;
public class Distancia{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paraula1, paraula2;
        boolean esVocal, relacio=true;
        int i;
        int[] coincidencia;
        char[][] paraules;
        char La='a', Le='e', Li='i', Lo='o', Lu='u';

        System.out.print("Entra la primera paraula: ");
        paraula1 = sc.next();
        paraules = new char[3][paraula1.length()];
        coincidencia = new int[paraula1.length()];
        paraula1 = paraula1.toLowerCase();
        paraules[0] = paraula1.toCharArray();
        
        System.out.print("Entra la segona paraula: ");
        paraula2 = sc.next();
        paraula2 = paraula2.toLowerCase();
        paraules[1] = paraula2.toCharArray();
        
        if(paraula1.length()==paraula2.length()){
            for(i=0;i<paraula1.length();i++){
                if((paraules[0][i]|paraules[1][i])==(La|Le|Li|Lo|Lu)){
                    esVocal=true;
                }else{
                    esVocal=false;
                }
                if(!esVocal && paraules[0][i]==paraules[1][i]){
                    coincidencia[i]=1;
                }else if(!esVocal){
                    coincidencia[i]=2;
                }
            }
            i=0;
            while(i<paraula1.length()&&relacio){
                if(coincidencia[i]==2){
                    relacio=false;
                    break;
                }else{
                    relacio=true;
                }
                i++;
            }
        }else{
            System.out.println("Les paraules han de tenir la mateixa longitud");
        }
        if(relacio){
            System.out.println("Les dues paraules mantenen una distancia minima");
        }else{
            System.out.println("Les dues paraules no mantenen una distancia minima");
        }
    }
}
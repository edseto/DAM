import java.util.Scanner;
public class MissatgesPart3{
    public static String Codifica(String paraula){
        char[] lletres = new char[paraula.length()];
        int i, j, numChars, longitud, unitats;

        longitud = paraula.length();
        lletres = paraula.toCharArray();
        paraula = "";

        for(i=0;i<longitud;i++){
            numChars = lletres[i];
            unitats = numChars%10;
            numChars /=10;
            for(j=0;j<numChars;j++){
                paraula = paraula+"i";
            }
            for(j=0;j<unitats;j++){
                paraula = paraula+"*";
            }
            if(i!=longitud-1){
                paraula = paraula+"_";
            }
        }
        return paraula;
    }
    public static String Descodifica (String paraula){
        int contador = 0, index = 0;
        String resultat="";

        while(index<paraula.length()-1){
            contador = 0;
            while(paraula.charAt(index)=='i' && index<paraula.length()-1){
                contador++;
                index++;
            }
            contador*=10;
            while(paraula.charAt(index)=='*' && index<paraula.length()-1){
                contador++;
                index++;
            }
            if(index==paraula.length()-1){
                contador++;
            }
            index++;
            resultat = resultat + (char)contador;
        }

        return resultat;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paraula;

        System.out.print("Introdueixi una paraula: ");
        paraula = sc.next();

        if(paraula.charAt(0)=='i' || paraula.charAt(0) == '*'){
            paraula = Descodifica(paraula);
        }else{
            paraula = Codifica(paraula);
        }
        System.out.println(paraula);
    }
}
import java.util.Scanner;
public class Zerafina{
    public static void main(String[] args) {
        char lletra;
        int i=0;
        Scanner sc = new Scanner(System.in);
        do {
            if(i==0){
                System.out.print("Entra una lletra: ");
                lletra = sc.next().charAt(0);
            }else{
                System.out.print("Entra una altra lletra: ");
                lletra = sc.next().charAt(0);
            }
            if(lletra=='s'){
                System.out.println("-> z");
            }else if(lletra=='S'){
                System.out.println("-> Z");
            }else if((lletra=='z')||(lletra=='Z')){
                System.out.print("");
            }else{
                System.out.println("-> "+lletra);
            }
            i++;
        } while ((lletra!='z')&&(lletra!='Z'));
    }
}
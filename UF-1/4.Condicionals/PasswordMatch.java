import java.util.Scanner;
public class PasswordMatch {
    public static void main(String args[]) {
    String passwd1, passwd2;
    boolean var;
    Scanner sc = new Scanner(System.in);
    System.out.print("Introdueix la contrassenya: ");
        passwd1 = sc.nextLine();
    System.out.print("Torna a introduir la contrassenya: ");
        passwd2 = sc.nextLine();
    var = passwd1.equals(passwd2);
    if(var == true){
        System.out.println("Iguals");
    }else{
        System.out.println("Diferents");
    }
    }
}

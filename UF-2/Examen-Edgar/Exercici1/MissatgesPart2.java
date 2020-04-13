import java.util.Scanner;
public class MissatgesPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n=" ";

        while(n!=""){
            n = scanner.nextLine();
            if(n.charAt(0)=='/'){
                n = MissatgesPart1.Descodifica(n);
            }else{
                n = MissatgesPart1.Codifica(n);
            }
            System.out.println(n);
        }
    }
}
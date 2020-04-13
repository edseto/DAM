import java.util.Random;
public class Translator {
    public static void main(String[] args)	{ 
        int num1;
        Random r = new Random();
        num1 = r.nextInt(10);            
        while(num1<5){
            num1 = r.nextInt(10);            
        } 
        System.out.println("Progessa adecuadament!");
    }
}

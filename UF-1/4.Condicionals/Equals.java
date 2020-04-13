public class Equals {
    public static void main(String args[]) {
    String str1 = "hola", str2 = "adeu", str3 = "hola"; 
    boolean var;
    System.out.println("\n str1=hola , str2=adeu, str3=hola \n"); var = "hola".equals( "hola" );
    System.out.println("hola == hola -> " + var);
    
    
    var = "adeu".equals( "hola" ); System.out.println("adeu == hola -> " + var);
    
    var = str1.equals( "hola" );
    System.out.println(str1 + "(str1) == hola -> " + var);
    
    
    var = str1.equals( str2 );
    System.out.println(str1 + "(str1) == " + str2 + " (str2) -> " + var);
    
    
    var = str1.equals( str3 );
    System.out.println(str1 + " (str1) == " +	str3 + " (str3) -> " + var + "\n" );
    }
}
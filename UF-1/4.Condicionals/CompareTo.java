public class CompareTo{
    public static void main(String[] args) {
        String str1 ="hola", str2 ="adeu", str3 ="hola";
        int var;

        var = str1.compareTo(str2);
        System.out.println(str1 + ">" + str2 + "->" + var);
        
        var = str2.compareTo(str1);
        System.out.println(str2 + ">" + str1 + "->" + var);
        
        var = str1.compareTo(str3);
        System.out.println(str1 + ">" + str3 + "->" + var);
        
        var = str2.compareTo("adeu");
        System.out.println(str2 + " == adeu" + "->" + var);

    }
}
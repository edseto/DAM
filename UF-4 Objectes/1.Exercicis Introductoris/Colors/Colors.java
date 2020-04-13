/*
    1. Color
    Implementa una classe de nom Color. Un color ve determinat per les següents característiques:
    una tonalitat vermella, una tonalitat verda i una tonalitat blava (RGB). Cada tonalitat s’expressa
    utilitzant un valor enter entre 0 i 255, ambdós compresos. La classe Color implementa les
    següents funcionalitats:
        • Convertir a hexadecimal: donat un color ens retorna el seu valor hexadecimal.
        • Convertir a RGB. Donat un valor hexadecimal ens retorna un objecte de la classe Color.
    Crea dos constructors , un per a crear objectes Color a partir de les components RGB i un altre
    per a crear un objecte Color a partir d’un color hexadecimal.
*/
public class Colors{
    private String hexadecimal;
    private int red;
    private int green;
    private int blue;

    //Getters
    public String getHexadecimal() { return this.hexadecimal; }
    public int getRed() { return this.red; }
    public int getGreen() { return this.green; }
    public int getBlue() { return this.blue; }

    //Setters
	public void setHexadecimal(String hexadecimal) { this.hexadecimal = hexadecimal; }    
    public void setRed(int red) { this.red = red; }
    public void setGreen(int green) { this.green = green; }
    public void setBlue(int blue) { this.blue = blue; }

    //Constructors
    public Colors(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public Colors(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    //Mètodes
    private char numToLletra(int num){
        char[] lletres = {'A','B','C','D','E','F'};

        switch (num){
            case 10: return lletres[0];
            case 11: return lletres[1];
            case 12: return lletres[2];
            case 13: return lletres[3];
            case 14: return lletres[4];
            case 15: return lletres[5];
        }
        return 'A';
    }

    private int lletraToNum(char lletra){
        int[] numeros = {10,11,12,13,14,15};

        switch(lletra){
            case 'A': return numeros[0];
            case 'B': return numeros[1];
            case 'C': return numeros[2];
            case 'D': return numeros[3];
            case 'E': return numeros[4];
            case 'F': return numeros[5];
        }

        return 0;
    }
    public String toString(){
        if(this.hexadecimal==null){
            return "RGB: "+this.red+", "+this.green+", "+this.blue;
        }else{
            return "Hexadecimal: #"+this.hexadecimal;
        }
    }
    public String rgbToHex(){
        String hexadecimal="";
        char lletra;
        int result, color, red = this.red, green = this.green, blue = this.blue, aux;
        int[] colors = {red, green, blue};
        
        for (int i = 0; i < colors.length; i++) {
            color = colors[i];
            result = color%16;
            color /= 16;

            if(color>9){
                aux = color;
                color = result;
                result = aux;
            }

            if(result>9){
                lletra = numToLletra(result);
                if(color == 0){
                    hexadecimal = hexadecimal + color + lletra;
                }else{
                    hexadecimal = hexadecimal + lletra + color;
                }
            }else if(color>=0 && color<10){
                    hexadecimal = hexadecimal + color + result;
            }else{
                hexadecimal = hexadecimal + result;
            }
        }

        return "#"+hexadecimal;
    }

    public String hexToRgb(){
        String rgb="", hexadecimal = this.hexadecimal;
        int color, numero;
        char caracter;

        if(hexadecimal.charAt(0)=='#'){
            hexadecimal = hexadecimal.substring(1);
        }
        
        for (int i = 0; i < 6; i+=2) {
            caracter = hexadecimal.charAt(i);
            if(esLletra(caracter)){
                numero = lletraToNum(caracter);
            }else{
                numero = caracter - 48;
            }
            color = numero * 16;

            caracter = hexadecimal.charAt(i+1);
            if(esLletra(caracter)){
                numero = lletraToNum(caracter);
            }else{
                numero = caracter - 48;
            }
            color += numero;

            if(i<4){
                rgb = rgb + color + ", ";
            }else{
                rgb = rgb + color + "";
            }
        }

        return rgb;
    }
    public boolean esLletra(char caracter){
        if(caracter>= 'A' && caracter <= 'F') return true;
        else return false;
    }
}
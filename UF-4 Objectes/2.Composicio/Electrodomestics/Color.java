public class Color{
    private String hexadecimal;
    private String color;
    private short red;
    private short green;
    private short blue;

    //Getters
    public String getHexadecimal() { return this.hexadecimal; }
    public String getColor() { return this.color; }
    public short getRed() { return this.red; }
    public short getGreen() { return this.green; }
    public short getBlue() { return this.blue; }

    //Setters
	public void setHexadecimal(String hexadecimal) { this.hexadecimal = hexadecimal; }    
    public void setRed(short red) { this.red = red; }
    public void setGreen(short green) { this.green = green; }
    public void setBlue(short blue) { this.blue = blue; }
    public void setColor(String color) { this.color = color; }

    //Constructors
    public Color() {
        this.red = 255;
        this.green = 255;
        this.blue = 255;
    }

    public Color(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public Color(int red, int green, int blue) { //Ho poso int perque sino no em deixa introduir els numeros
        /* Ho trec per si el programador vol posar "marques"
        if(red>255) red = 255;
            else if(red<0) red = 0;

        if(green>255) green = 255;
            else if(green<0) green = 0;
            
        if(blue>255) blue = 255;
            else if(blue<0) blue = 0;
        */
        
        this.red = (short) red;
        this.green = (short) green;
        this.blue = (short) blue;
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

    @Override
    public String toString(){
        if(this.hexadecimal==null){
            return "RGB: "+this.red+", "+this.green+", "+this.blue + " Color: "+color();
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
            if(caracter == 'A' || caracter == 'B' || caracter == 'C'|| caracter == 'D'|| caracter == 'E'|| caracter == 'F'){
                numero = lletraToNum(caracter);
            }else{
                numero = caracter - 48;
            }
            color = numero * 16;

            caracter = hexadecimal.charAt(i+1);
            if(caracter == 'A' || caracter == 'B' || caracter == 'C'|| caracter == 'D'|| caracter == 'E'|| caracter == 'F'){
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

    //Retornar color dominant
    private boolean redMax(short red, short green, short blue){
        return red>green && red>blue;
    }

    private boolean greenMax(short red, short green, short blue){
        return green>red && green>blue;
    }

    private boolean blueMax(short red, short green, short blue){
        return blue>red && blue>green;
    }

    private boolean blanc(short red, short green, short blue){
        return red == 255 && green == red && blue == red;
    }

    private boolean negre(short red, short green, short blue){
        return red == 0 && green == red && blue == red;
    }

    private boolean gris(short red, short green, short blue){
        return red == green && blue == red;
    }

    public String color(){
        String color = "indefinit";
        short red = this.red, green = this.green, blue = this.blue;  
        
        if(redMax(red, green, blue)){
            color = "vermell";
        }else if(greenMax(red, green, blue)){
            color = "verd";
        }else if(blueMax(red, green, blue)){
            color = "blau";
        }else if(negre(red, green, blue)){
            color = "negre";
        }else if(blanc(red, green, blue)){
            color = "blanc";
        }else if(gris(red, green, blue)){
            color = "gris";
        }
        this.color = color;
        return color;
    }
}
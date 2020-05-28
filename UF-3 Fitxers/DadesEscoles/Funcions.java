import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public final class Funcions {

    public static String[] mySplit(String linia, char separador){
        ArrayList<String> dividit = new ArrayList<String>();
        String paraula="";
        int i=0;

        for (i = 0; i < linia.length(); i++) {
            if(linia.charAt(i)!=separador) paraula = paraula+linia.charAt(i);
            else{ dividit.add(paraula); paraula="";}
        }
        
        if(linia.charAt(linia.length()-1)!=separador) dividit.add(paraula);

        return dividit.toArray(new String[0]);
    }

    public static int indexOf(String[] array, String search){
        int index = -1, i=0;
        
        while (i<array.length && index==-1) {
            if(array[i].equals(search)) index = i;
            else i++;
        }

        return index;
    }

    public static void fitxerPerEstats(FileReader file029, FileReader file059) throws Exception {
        BufferedReader bf1 = new BufferedReader(file029);
        Estats estats = new Estats();

        estats = crearEstats(estats, bf1, file059);
        crearFitxerEstats(estats);
    }

    public static void fitxerPerNivell(FileReader file029, FileReader file059) throws Exception {
        BufferedReader bf1 = new BufferedReader(file029);
        Estats estats = new Estats();

        estats = crearEstats(estats, bf1, file059);
        crearFitxerNivell(estats);
    }

    private static Estats crearEstats(Estats estats, BufferedReader bf, FileReader file059) throws Exception{
        int idEstat, posEstat, posId, posProf;
        String nomEstat="", info, infoProf;
        String[] columnFitxer1, escola, columnaProfes;
        BufferedReader bf2 = new BufferedReader(file059);
        
        info = bf.readLine();
        columnFitxer1 = mySplit(info, ',');
        infoProf = bf2.readLine();
        columnaProfes = mySplit(infoProf, ',');

        posProf = indexOf(columnaProfes, "TEACHERS");
        posEstat = indexOf(columnFitxer1, "STATENAME");
        posId = indexOf(columnFitxer1, "FIPST");

        while (((info=bf.readLine())!=null)&&((infoProf=bf2.readLine())!=null)){
            escola = mySplit(info, ',');
            columnaProfes = mySplit(infoProf, ',');
            if(!nomEstat.equals(escola[posEstat])){
                nomEstat = escola[posEstat];
                idEstat = stringToInt(escola[posId]);
                estats.afegirEstat(idEstat, nomEstat);
            }
            crearEscola(escola, columnFitxer1, columnaProfes, posProf, estats);
        }

        return estats;
    }

    private static void crearEscola(String[] escola, String[] columnes, String[] columnaProfes, int posProfes, Estats estats) throws Exception {
        int posIdEscola, posAgrupacio, posLevel, posEstat, colEstat, colLevel;
        int nProfes, idEscola;
        double profes;

        posIdEscola = indexOf(columnes, "LEAID");
        posAgrupacio = indexOf(columnes, "ST_LEAID");
        posLevel = indexOf(columnes, "LEVEL");
        colEstat = indexOf(columnes, "STATENAME");
        posEstat = estats.buscarEstat(escola[colEstat]);
        

        profes = stringToDouble(columnaProfes[posProfes-1]);
        nProfes = (int) profes;
        idEscola = stringToInt(escola[posIdEscola]);

        colLevel = estats.estats.get(posEstat).getNivells().buscarLevel(escola[posLevel]);
        // Si és -1 significa que és un nivell diferent a Middle, High o Elementary
        if(colLevel!=-1){
            estats.estats.get(posEstat).getNivells().nivells.get(colLevel).getSchools().afegirEscola(idEscola, nProfes, escola[posAgrupacio]);
        }
    }

    private static int stringToInt(String paraula){
        return Integer.parseInt(paraula.trim());
    }

    private static double stringToDouble(String paraula){
        return Double.parseDouble(paraula);
    }

    private static void crearFitxerEstats(Estats estats) throws Exception {
        String rutaFitxer = "DAM\\UF-3 Fitxers\\DadesEscoles\\FitxerPerEstats\\";
        String nomEstat;
        int middle, high, elementary;
        BufferedWriter bw = null;
        FileWriter fw = null;
        
        for (int i = 0; i < estats.estats.size(); i++) {
            nomEstat = estats.estats.get(i).getNom();
            middle = estats.estats.get(i).getNivells().nivells.get(0).calcularProfes();
            high = estats.estats.get(i).getNivells().nivells.get(1).calcularProfes();
            elementary = estats.estats.get(i).getNivells().nivells.get(2).calcularProfes();

            fw = new FileWriter(rutaFitxer+nomEstat+".txt");
            bw = new BufferedWriter(fw);
            bw.write(nomEstat+";Middle;"+middle);
            bw.newLine();
            bw.write(nomEstat+";High;"+high);
            bw.newLine();
            bw.write(nomEstat+";Elementary;"+elementary);

            if (bw != null) bw.close();
            if (fw != null) fw.close();
        }
    }

    private static void crearFitxerNivell(Estats estats) throws Exception {
        String rutaFitxer = "DAM\\UF-3 Fitxers\\DadesEscoles\\FitxerPerNivell\\";
        String nomEstat;
        Escoles middle, high, elementary;
        
        for (int i = 0; i < estats.estats.size(); i++) {
            nomEstat = estats.estats.get(i).getNom();
            middle = estats.estats.get(i).getNivells().nivells.get(0).getSchools();
            high = estats.estats.get(i).getNivells().nivells.get(1).getSchools();
            elementary = estats.estats.get(i).getNivells().nivells.get(2).getSchools();
            
            crearMiddle(middle, nomEstat, rutaFitxer);
            crearHigh(high, nomEstat, rutaFitxer);
            crearElementary(elementary, nomEstat, rutaFitxer);
        }
    }

    private static void crearMiddle(Escoles middle, String nomEstat, String rutaFitxer) throws Exception {
        String agrupacio;
        int teachers = 0;
        TreeMap<String, Integer> mid = new TreeMap<>();
        FileWriter fw = new FileWriter(rutaFitxer+nomEstat+"-Middle.txt");;

        for (int j = 0; j < middle.escoles.size(); j++) {
            agrupacio = middle.escoles.get(j).getSt_leaid();
            
            if(mid.get(agrupacio)==null) teachers = middle.escoles.get(j).getProfes();
            else teachers = mid.get(agrupacio) + middle.escoles.get(j).getProfes();
            
            mid.put(agrupacio, teachers);
        }

        crearFitxer(mid, fw, nomEstat);
    }

    private static void crearHigh(Escoles high, String nomEstat, String rutaFitxer) throws Exception {
        String agrupacio;
        int teachers = 0;
        TreeMap<String, Integer> hig = new TreeMap<>();
        FileWriter fw = new FileWriter(rutaFitxer+nomEstat+"-High.txt");;

        for (int j = 0; j < high.escoles.size(); j++) {
            agrupacio = high.escoles.get(j).getSt_leaid();
            
            if(hig.get(agrupacio)==null) teachers = high.escoles.get(j).getProfes();
            else teachers = hig.get(agrupacio) + high.escoles.get(j).getProfes();
            
            hig.put(agrupacio, teachers);
        }

        crearFitxer(hig, fw, nomEstat);
    }

    private static void crearElementary(Escoles elementary, String nomEstat, String rutaFitxer) throws Exception{
        String agrupacio;
        int teachers = 0;
        TreeMap<String, Integer> elem = new TreeMap<>();
        FileWriter fw = new FileWriter(rutaFitxer+nomEstat+"-Elementary.txt");;

        for (int j = 0; j < elementary.escoles.size(); j++) {
            agrupacio = elementary.escoles.get(j).getSt_leaid();
            
            if(elem.get(agrupacio)==null) teachers = elementary.escoles.get(j).getProfes();
            else teachers = elem.get(agrupacio) + elementary.escoles.get(j).getProfes();
            
            elem.put(agrupacio, teachers);
        }

        crearFitxer(elem, fw, nomEstat);
    }

    private static void crearFitxer(TreeMap<String, Integer> map, FileWriter fw, String nomEstat) throws Exception {
        String agrupacio;
        int nEscoles = map.size(), teachers;
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < nEscoles; i++) {
            agrupacio = map.firstKey();
            teachers = map.get(agrupacio);

            bw.write(nomEstat+";"+ agrupacio +";"+teachers);
            bw.newLine();

            map.remove(agrupacio);
        }
        if (bw != null) bw.close();
    }
}
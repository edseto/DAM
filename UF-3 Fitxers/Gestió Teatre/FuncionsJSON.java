import java.io.*;
import org.json.*;
public final class FuncionsJSON {

    public static JSONObject infoZona(int zona, String fitxer) throws JSONException {
        InputStream is = FuncionsJSON.class.getResourceAsStream(fitxer);
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jarray = new JSONArray(tokener);
        return (JSONObject) jarray.get(zona - 1);
    }

    public static int numeroSeients(int zona, String fitxer) throws JSONException {
        return infoZona(zona, fitxer).getInt("totalseients");
    }

    public static int numZones(String fitxer) throws JSONException {
        InputStream is = FuncionsJSON.class.getResourceAsStream(fitxer);
        JSONTokener tokener = new JSONTokener(is);
        JSONArray jarray = new JSONArray(tokener);
        return jarray.length();
    }
}
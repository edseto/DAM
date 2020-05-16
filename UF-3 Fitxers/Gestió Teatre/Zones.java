import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class Zones {
    ArrayList<Zona> zones = new ArrayList<Zona>();

    // Constructors
    public Zones() { }

    public Zones(int totalZones, String fitxer) throws JSONException {
        int id;
        double preu;
        JSONObject zona = new JSONObject();

        for (int i = 0; i < totalZones; i++) {
            zona = FuncionsJSON.infoZona(i+1, fitxer);
            id = zona.getInt("zona");
            preu = zona.getDouble("preu");
            zones.add(new Zona(id, preu, fitxer));
        }
    }
}
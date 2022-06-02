import java.util.ArrayList;

public class MapaModel {
    public static int X;
    public static int Y;
    public static final int OBJECTS = 10;
    public static Player player;
    public static ArrayList<Mapeable> objetosMapeables;
    public static MapaView mapa;
    
    public MapaModel() {
        mapa = new MapaView();
    }
}

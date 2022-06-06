import java.util.ArrayList;

public class MapaModel {
    public static int X; // se utiliza para la verificacion de las posiciones
    public static int Y; // de los mapeables
    public static final int OBJECTS = 20;
    public static Player player;
    public static ArrayList<Mapeable> objetosMapeables;
    public static MapaView mapa;
    public static int turno;
    
    public MapaModel() {
        turno = 0;
        mapa = new MapaView();
    }
}

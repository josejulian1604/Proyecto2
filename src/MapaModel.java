import java.util.ArrayList;

public class MapaModel {
    public static int X;
    public static int Y;
    public static final int OBJECTS = 10;
    public static Player player;
    public static ArrayList<Mapeable> objetosMapeables;
    public static MapaView mapa;
    public static int turno;
    public static int aliados;
    
    public MapaModel() {
        turno = 0;
        aliados = 0;
        mapa = new MapaView();
    }
}

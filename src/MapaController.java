import java.util.ArrayList;
import java.util.Random;

public class MapaController {
    static MapeableFactory factory;
    static MapaModel data;

    MapaController(int x, int y) {
        factory = new MapeableFactory();
        createPlayer(x, y);
        spawnMapeables();
        //printPositions();
        data = new MapaModel();
    }
    
    // CREATION METHODS ####################################################
    public void createPlayer(int x, int y) {
        MapaModel.player = factory.createPlayer(x, y);
        MapaModel.objetosMapeables = factory.createArrayList();
    }

    public void spawnMapeables() {
        for(int i = 0; i < MapaModel.OBJECTS; i++) {
            if(i < MapaModel.OBJECTS / 2) {
                createMapeable(0, "" + i);
            }else {
                createMapeable(1, "" + i);
            }
        }
    }

    public static void createMapeable(int typeMapeable, String name) {
        verifyPositions();
        Mapeable m = factory.createMapeable(typeMapeable, MapaModel.X, MapaModel.Y, name);
        MapaModel.objetosMapeables.add(m);
        MapaModel.player.agregarObservador(m);
    }

    public static void addMapeable() {
        if(MapaModel.turno % 5 == 0) { // ENEMIGO
            createMapeable(1, "x");
            MapaModel.mapa.addMapeable();
        }
    }

    // POSITION VERIFICATION #######################################################################
    public static void verifyPositions() {
        int x = new Random().nextInt(MapaView.CASILLAS - 1); // NECESITA CAMBIOS: FORMAR EL RANDOM Y VERIFICAR QUE LA POSICION NO
        int y = new Random().nextInt(MapaView.CASILLAS - 1); // HAYA SIDO TOMADA

        if(x == MapaModel.player.xPos & y == MapaModel.player.yPos) {
            verifyPositions();
            return;
        }
        for (Mapeable m : MapaModel.objetosMapeables) {
            if(x == m.xPos & y == m.yPos) {
                verifyPositions();
                return;
            }
        }
        MapaModel.X = x;
        MapaModel.Y = y;
    }

    // MOVING METHODS #####################################################################
    public static ArrayList<Integer> movePlayer(boolean upDown, int moveSize, int direction) {
        ArrayList<Integer> indices;
        MapaModel.turno++;
        if(upDown) {
            indices = interactuar();
            MapaModel.player.yPos += moveSize;
            MapaModel.player.notificarObservadores();
            addMapeable();
        }else{
            indices = interactuar();
            MapaModel.player.xPos += moveSize;
            MapaModel.player.notificarObservadores();
            addMapeable();
        }
        MapaModel.player.direction = direction;
        return indices;
    }

    public static ArrayList<Integer> interactuar() {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < MapaModel.objetosMapeables.size(); i++) {
            Mapeable m = MapaModel.objetosMapeables.get(i);
            if(m.interactuar(MapaModel.player)) {
                MapaModel.player.eliminarObservador(m);
                MapaModel.objetosMapeables.remove(m);
                MapaModel.mapa.removeButton(i);
                indices.add(i);
            }
        }
        return indices;
    }

    public static int atacarEnemigo() {
        MapaModel.player.atacar();
        for(int i = 0; i < MapaModel.objetosMapeables.size(); i++) {
            if(MapaModel.objetosMapeables.get(i).vida == 0) {
                MapaModel.objetosMapeables.remove(MapaModel.objetosMapeables.get(i));
                return i;
            }
        }return -1;
    }

    public static void printPositions() {
        System.out.println("Player:  X: " + MapaModel.player.xPos + " Y: " + MapaModel.player.yPos);
        for(Mapeable m : MapaModel.objetosMapeables) {
            System.out.println(m.name + " X: " + m.xPos + " Y: " + m.yPos);
        }
    }
}

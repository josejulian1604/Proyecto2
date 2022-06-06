import java.util.Random;

public class MapaController {
    static MapeableFactory factory;
    static MapaModel data;

    MapaController(int x, int y) {
        factory = new MapeableFactory();
        createPlayer(x, y, 15);
        spawnMapeables();
        data = new MapaModel();
    }
    
    // CREATION METHODS ####################################################
    public void createPlayer(int x, int y, int vida) {
        MapaModel.player = factory.createPlayer(x, y, vida);
        MapaModel.objetosMapeables = factory.createArrayList();
    }

    public void spawnMapeables() {
        for(int i = 0; i < MapaModel.OBJECTS; i++) {
            if(i < MapaModel.OBJECTS / 2) {
                createMapeable(0, "A");
            }else {
                createMapeable(1, "E");
            }
        }
    }

    // utiliza el metodo factory para crear mapeables a lo largo de la partida
    public static void createMapeable(int typeMapeable, String name) {
        verifyPositions();
        Mapeable m = factory.createMapeable(typeMapeable, MapaModel.X, MapaModel.Y, name);
        MapaModel.objetosMapeables.add(m);
        MapaModel.player.agregarObservador(m);
        
    }
    
    // Agrega objetos mapeables despues de cierta cantidad de turnos
    public static void addMapeable() {
        if(MapaModel.turno % 7 == 0) { // ENEMIGO
            createMapeable(1, "E");
            MapaModel.mapa.addMapeable();
            if(countAliados() < MapaModel.OBJECTS / 2) {
                createMapeable(0, "A");
                MapaModel.mapa.addMapeable();
            }
        }
    }

    // POSITION VERIFICATION #######################################################################
    
    // verifica que el mapeable por crear no aparezca encima de otro ya creado
    public static void verifyPositions() {
        int x = new Random().nextInt(MapaView.CASILLAS - 1); 
        int y = new Random().nextInt(MapaView.CASILLAS - 1); 

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

    // Llama al metodo de hacer visible a los aliados cuando corresponde
    public static void verifyAliados() {
        for(int i = 0; i < MapaModel.objetosMapeables.size(); i++) {
            if(MapaModel.objetosMapeables.get(i).getClass().getName() == "Aliado") {
                Aliado aliado = (Aliado)MapaModel.objetosMapeables.get(i);
                if(aliado.closePlayer()) {
                    MapaModel.mapa.setVisibilityTrue(i);
                }else if(!aliado.closePlayer() & MapaModel.mapa.botonesMapeables.get(i).isVisible()) {
                    MapaModel.mapa.setVisibilityFalse(i);
                }
            }
        }
    }
    
    //Cuenta cuantos aliados hay en partida
    public static int countAliados() {
        int counter = 0;
        for(int i = 0; i < MapaModel.objetosMapeables.size(); i++) {
            if(MapaModel.objetosMapeables.get(i).getClass().getName() == "Aliado") counter++;
        }return counter;
    }

    // MOVING METHODS #####################################################################
    public static void movePlayer(boolean upDown, int moveSize, int direction) {
        if(MapaModel.player.vida <= 0) MapaModel.mapa.closeWindow();
        MapaModel.turno++;
        if(upDown) {
            interactuar();
            MapaModel.player.yPos += moveSize;
            MapaModel.player.notificarObservadores();
            addMapeable();
        }else{
            interactuar();
            MapaModel.player.xPos += moveSize;
            MapaModel.player.notificarObservadores();
            addMapeable();
        }
        verifyAliados(); 
        MapaModel.player.direction = direction;
    }

    // elimina los objetos que lleguen a la misma posicion que la del jugador
    public static void interactuar() {
        for(int i = 0; i < MapaModel.objetosMapeables.size(); i++) {
            Mapeable m = MapaModel.objetosMapeables.get(i);
            if(m.interactuar(MapaModel.player)) {
                MapaModel.player.eliminarObservador(m);
                MapaModel.objetosMapeables.remove(m);
                MapaModel.mapa.removeButton(i);
            }
        }
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
}

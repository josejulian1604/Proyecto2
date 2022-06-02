import java.util.Random;

public class MapaController {
    MapeableFactory factory;
    MapaModel data;

    MapaController(int x, int y) {
        factory = new MapeableFactory();
        createPlayer(x, y);
        spawnMapeables();
        printPositions();
        data = new MapaModel();
    }
    
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

    public void createMapeable(int typeMapeable, String name) {
        verifyPositions();
        MapaModel.objetosMapeables.add(factory.createMapeable(typeMapeable, MapaModel.X, MapaModel.Y, name));
    }

    public void verifyPositions() {
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

    public void move() {
        for(Mapeable m : MapaModel.objetosMapeables) {
            m.move();
        }
    }

    public void printPositions() {
        System.out.println("Player:  X: " + MapaModel.player.xPos + " Y: " + MapaModel.player.yPos);
        for(Mapeable m : MapaModel.objetosMapeables) {
            System.out.println(m.name + " X: " + m.xPos + " Y: " + m.yPos);
        }
    }
}

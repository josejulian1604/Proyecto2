public class Aliado extends Mapeable {
    public Aliado(int x, int y, String name) {
        xPos = x;
        yPos = y;
        this.name = name;
    }
    
    public void move(){}

    @Override
    public void actualizar(int newX, int newY) {
        playerX = newX;
        playerY = newY;
    }
}

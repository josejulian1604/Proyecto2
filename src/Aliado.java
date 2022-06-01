public class Aliado extends Mapeable {
    private int playerX;
    private int playerY;

    public Aliado(int x, int y) {
        xPos = x;
        yPos = y;
    }
    
    public void move(){}

    @Override
    public void actualizar(int newX, int newY) {
        playerX = newX;
        playerY = newY;
    }
}

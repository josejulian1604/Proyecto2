public abstract class Mapeable implements IObservador{
    protected int xPos;
    protected int yPos;
    protected String name;
    protected int playerX;
    protected int playerY;

    public abstract void move();
}

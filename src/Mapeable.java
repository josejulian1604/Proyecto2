public abstract class Mapeable implements IObservador{
    protected int xPos;
    protected int yPos;
    protected String name;
    protected int playerX;
    protected int playerY;
    protected int vida;

    public abstract void move();
    public abstract boolean interactuar(Player p);
}

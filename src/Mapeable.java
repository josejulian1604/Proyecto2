public abstract class Mapeable implements IObservador{
    protected int xPos;
    protected int yPos;
    protected String name;
    protected int playerX; // contiene la posicion del jugador
    protected int playerY; // contiene la posicion del jugador
    protected int vida;

    public abstract void move();
    public abstract boolean interactuar(Player p);
}

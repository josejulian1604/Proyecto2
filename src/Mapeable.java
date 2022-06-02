public abstract class Mapeable implements IObservador{
    protected int xPos;
    protected int yPos;
    protected String name;

    public abstract void move();
}

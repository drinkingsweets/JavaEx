package Task.old;

public interface Moveable {
    public static int speed=0;
    abstract void move();
    default void currentSpeed(){
        System.out.println("speed is" + speed);
    }
}

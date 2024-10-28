package Task.old;

public interface Flyable {
    public final int speed = 0;
    abstract void fly();
    default void currentSpeed(){
        System.out.println("flying speed is " + speed);
    }
}

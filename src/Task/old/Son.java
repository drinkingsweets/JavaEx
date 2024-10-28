package Task.old;

public class Son extends Parent{
    @Override
    public void method(){
        System.out.println("hello2");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.method();
    }
}

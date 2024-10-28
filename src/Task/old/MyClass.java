package Task.old;

public class MyClass {
    public MyClass(){
        System.out.print("Constructor");
    }
    public void myMethod(){
        System.out.println("Method ");
    }
    {
        System.out.println("Instance_block");
    }
    static {
        System.out.println("Static_block");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.myMethod();
    }
}
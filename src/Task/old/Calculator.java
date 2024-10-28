package Task.old;

import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        String b = s.next();
        int c = s.nextInt();

        switch(b){
            case "+":
                System.out.println(a + c);
                break;
            case "-":
                System.out.println(a - c);
                break;
            case "*":
                System.out.println(a * c);
                break;
            case "/":
                System.out.println(a / c);
                break;
            default:
                System.out.println("unnamed operation");
        }


    }
}

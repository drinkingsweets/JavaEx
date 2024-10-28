package Task.old;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Months month = Months.AUGUST;
        System.out.println(month);
        Scanner sc = new Scanner(System.in);
        month = Months.valueOf(sc.next());
        System.out.println(Months.JANUARY);
    }
}

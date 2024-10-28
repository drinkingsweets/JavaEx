package Task4;

import java.util.Scanner;

public class Member {
    String name;
    int fromWhere;
    {
        System.out.println("Введите имя и фамилию человека");
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        System.out.println("Введите 1, если человек местный/из близлежащего города, 2, если из дальнего");
        fromWhere = s.nextInt();
    }
    public Member(){
        this.name = name;
        this.fromWhere = fromWhere;
    }

    @Override
    public String toString() {
        return this.name + ", приоритет: " + this.fromWhere;
    }
}

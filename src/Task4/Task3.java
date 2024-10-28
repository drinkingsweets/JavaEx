package Task4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task3 {
    /*
    используйте класс PriorityQueue и интерфейс Comparator для создания программы,
    организующей очередь клиентов в компании. Программа упорядочивает клиентов в порядке их
    прибытия, но клиенты, прибывающие из дальних городов, имеют более высокий приоритет, чем местные
    жители или близлежащие города. Ваша программа должна позволять оператору вводить информацию о клиентах и
    вызвать клиентов в правильном порядке для их обслуживания.
     */
    public static void main(String[] args) {
         PriorityQueue<Member> queue = new PriorityQueue<>(Comparator.comparingInt(m -> -m.fromWhere));

        while (true){
            System.out.println("Выберите действие:\n1. Добавить клиента\n2. Вывести очередь\n3. Вывести " +
                    "следующего клиента\n4. Удалить первого в очереди");
            Scanner s = new Scanner(System.in);
            int chosen = s.nextInt();
            switch (chosen){
                case 1:
                    queue.add(new Member());
                    System.out.println();
                    break;
                case 2:
                    for (Member member: queue){
                        System.out.println(member.toString());
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println(queue.peek().toString());
                    System.out.println();
                    break;
                case 4:
                    System.out.println(queue.poll().toString());
                    System.out.println();
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
    }
    }

}

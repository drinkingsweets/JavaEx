package Task.old;

import java.util.Scanner;
//import Task.*;
//
//public class Task.old.Main {
//    public static void main(String[] args) {
//        Employers Task.old.test = new Employers();
//        Task.old.test.add(new Employee(1, "John", "Doe", 1985, "New York", 50000, "Single"));
//        Task.old.test.add(new Employee(2, "Jane", "Smith", 1990, "Los Angeles", 60000, "Married"));
//        Task.old.test.add(new Employee(3, "Sam", "Brown", 1988, "Chicago", 55000, "Single"));
//        Task.old.test.add(new Employee(4, "Emily", "Johnson", 1995, "Houston", 48000, "Married"));
//        Task.old.test.add(new Employee(5, "Michael", "Williams", 1988, "Phoenix", 70000, "Single"));
//        Task.old.test.add(new Employee(6, "Jessica", "Davis", 1992, "San Antonio", 62000, "Married"));
//        Task.old.test.add(new Employee(7, "David", "Miller", 1988, "Philadelphia", 53000, "Single"));
//        Task.old.test.add(new Employee(8, "Linda", "Garcia", 1983, "San Diego", 75000, "Married"));
//        Task.old.test.add(new Employee(9, "Sam", "Martinez", 1991, "Dallas", 58000, "Single"));
//        Task.old.test.add(new Employee(10, "Sophia", "Hernandez", 1984, "San Jose", 67000, "Married"));
//
////        for (int i = 0; i < Task.old.test.size(); i++) {
////            System.out.println(Task.old.test.get(i));
////        }
//
//
//        System.out.println(Task.old.test.sumSalary());
//        Task.old.test.find(3);
//        System.out.println();
//        Task.old.test.findName("Sam");
//        System.out.println();
//        Task.old.test.findYear(1988);
//    }
//}


public class Main {
    public static void main(String[] args) {
        Days day=Days.SATAURDAY;
        System.out.println(day);
        Scanner sc = new Scanner(System.in);
        day=Days.valueOf(sc.next());
    }
}

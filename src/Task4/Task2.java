package Task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Task2 {
    /*
    Напишите простую программу-словарь, которая считывает информацию из файла и сохраняет ее в HashMap.
    Пользователь должен иметь возможность искать слово с помощью меню, которое постоянно отображается.
    Текстовый файл должен иметь следующую структуру:
    Слово1: Значение1
    Слово2 : Значение2
     */

    public static void main(String[] args) {
        File file = new File("/Users/mvl/IdeaProjects/STP/src/Task4/test.txt");
        HashMap<String, String> data = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(":");
                data.put(line[0].strip(), line[1].strip());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        while (true){
            System.out.println("Введите слово для считывания");
            Scanner s = new Scanner(System.in);
            String word = s.nextLine();
            System.out.println(data.get(word));
        }
    }
}

package Task3;

import java.util.Scanner;

public class LibrarySystem {
    public static void showRoles() {
        System.out.println("Выберите пользователя:\n1.Менеджер\n2.Сотрудник библиотеки\n3.Читатель");
    }
    public static void showManager(){
        System.out.println("Выберите команду:\n1. Добавить книгу\n2. Удалить книгу\n3. Посмотреть статистику" +
                "\n4. Добавить читателя\n5. Удалить читателя\n6. Добавить сотрудника\n7. Удалить сотрудник" +
                "\n8. Посмотреть количество книг в категории");
    }

    public static void showLibrarian(){
        System.out.println("Выберите команду:\n1. Посмотреть наличие книги по названию\n2. Выдать книгу\n3. Принять книгу");
    }

    public static void showReader(){
        System.out.println("Выберите команду:\n1. Взять книгу\n2. Вернуть книгу");
    }

    public static void main(String[] args) {
        Library library = new Library();
        while (true) {
            showRoles();
            Scanner s = new Scanner(System.in);
            String role = s.nextLine();
            switch (role){
                case "1":
                    System.out.println("Введите фамилию сотрудника:");
                    String sur = s.nextLine();

                    System.out.println("Введите ключевое слово:");
                    String key = s.nextLine();

                    if (library.authenticationCheck(key, sur) == 1){
                        showManager();
                        String choose = s.nextLine();
                        switch (choose){
                            case "1":
                                library.add();
                                System.out.println(library.getBooks().toString());
                                break;
                            case "2":
                                library.remove();
                                System.out.println(library.getBooks().toString());
                                break;
                            case "3":
                                System.out.println("Всего книг: " + library.books.size() + "\nКниг взято: " +
                                        library.booksTaken());
                                break;
                            case "4":
                                library.addReader();
                                break;
                            case "5":
                                System.out.println("ID читателя: ");
                                int idToDelete = s.nextInt();
                                library.removeReader(idToDelete);
                                break;
                            case "6":
                                library.addEmployee();
                                break;
                            case "7":
                                System.out.println("ID сотрудника: ");
                                int idEmployee = s.nextInt();
                                library.removeEmployee(idEmployee);
                                break;
                            case "8":
                                System.out.println("Введите категорию для вывода количества книг");
                                String category = s.nextLine();
                                System.out.println(String.format("В категории \"%s\" найдено %d книг",
                                        category, library.booksInCategory(category)));
                                break;
                            default:
                                System.out.println("Введена неизвестная команда");
                                break;
                        }
                        break;
                    }
                case "2":
                    System.out.println("Введите фамилию сотрудника:");
                    String sur2 = s.nextLine();

                    System.out.println("Введите ключевое слово:");
                    String key2 = s.nextLine();
                    if (library.authenticationCheck(key2, sur2) == 0){
                        showLibrarian();
                        String chosen = s.nextLine();
                        switch (chosen){
                            case "1":
                                System.out.println("Введите название для поиска");
                                String nameToFind = s.nextLine();
                                int result = library.findBook(nameToFind);
                                if (result != -1)
                                    System.out.println("Книга найдена, id: " + result);
                                else System.out.println("Книга не найдена или занята");
                                break;
                            case "2":
                                System.out.println("Введите название книги для поиска, в следующей строке введите" +
                                        " ID читателя");

                                String nameBook = s.nextLine();
                                int idReader = s.nextInt();

                                library.giveBook(library.findBookObject(library.findBook(nameBook)),
                                        library.findReader(idReader));
                                break;
                            case "3":
                                System.out.println("Введите название книги для сдачи, в следующей строке введите ID" +
                                        " читателя");
                                String nameBook2 = s.nextLine();
                                int idReader2 = s.nextInt();

                                library.takeBook(library.findBookObject(library.findBook(nameBook2)),
                                        library.findReader(idReader2));
                                break;
                            default:
                                System.out.println("Введена неизвестная команда");
                                break;
                        }
                    }
                case "3":
                    showReader();
                    String chosen2 = s.nextLine();
                    switch (chosen2){
                        case "1":
                            System.out.println("Введите название книги, которую вы хотите взять");
                            String nameTake = s.nextLine();
                            System.out.println("Введите свой ID читателя");
                            int idReader = s.nextInt();

                            library.giveBook(library.findBookObject(library.findBook(nameTake)),
                                        library.findReader(idReader));
                            break;
                        case "2":
                            System.out.println("Введите название книги для сдачи и в следующей строке ваш ID");
                            String nameReturn = s.nextLine();
                            int idReader2 = s.nextInt();

                            library.takeBook(library.findBookObject(library.findBook(nameReturn)),
                                        library.findReader(idReader2));
                            break;
                        default:
                            System.out.println("Неизвестная команда");
                            break;
                    }
                default:
                    System.out.println("\nВведено неизвестное значение\n");
                }

            }
        }
    }


package Task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
   ArrayList<Book> books;
   ArrayList<Employee> employees;
   ArrayList<Reader> readers;

    public Library() {
        this.books = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.employees.add(new Employee(0, "Иван", "Иванов", "",
                "адрес", 1, "баранка"));
        this.employees.add(new Employee(0, "Иван", "библио", "",
                "адрес", 0, "бар"));

        this.books.add(new Book(2, "Война и мир", "Толстой", "Паб",
                1900, "Драма", false));
        this.books.add(new Book(1, "Война и мир", "Толстой", "Паб",
                1902, "Драма", true));

        this.readers.add(new Reader(1, "a", "b", "c", "a"));
    }

    public void add() {
        System.out.println("Введите название книги");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        System.out.println("Введите автора");
        String author = s.nextLine();
        System.out.println("Введите год издания");
        String year = s.nextLine();
        System.out.println("Введите категорию");
        String category = s.nextLine();

        books.add(new Book(this.books.size() + 1, name, author, "Pub",
                Integer.parseInt(year), category, false));

    }

    public void remove() {
        Scanner s = new Scanner(System.in);
        int id = s.nextInt();
        books.remove(id);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int booksLeft(){
        int counter = 0;
        for(Book book: this.books) {
            if (!book.isTaken){
                counter++;
            }
        }
        return counter;
    }

    public int booksTaken(){
        return this.books.size() - this.booksLeft();
    }

    public int booksInCategory(String category){
            int counter = 0;
            for (Book book : this.books) {
                if (book.category.equals(category)) {
                    counter++;
                }
            }
            return counter;
    }

    public int findBook(String name){
        for(Book book: this.books){
            if (book.name.equals(name) && !book.isTaken){
                return book.id;
            }
        }
        return -1;
    }

    public Book findBookObject(int id){
        for(Book book: this.books){
            if (book.id == id){
                return book;
            }
        }
        return null;
    }

    public Reader findReader(int id){
        for(Reader reader: this.readers){
            if (reader.id == id){
                return reader;
            }
        }
        return null;
    }

    public void giveBook(Book book, Reader reader){
        try {
            book.isTaken = false;
            reader.borrowedBooks.add(book);
            System.out.println("Книга выдана");
        } catch (Exception e) {
            System.out.println("Книга не выдана");
        }
    }

    public void takeBook(Book book, Reader reader){
        if (reader.borrowedBooks.contains(book)){
            book.isTaken = false;
            System.out.println("Книга принята обратно");
        }
    }


    public void addEmployee(){
        Scanner s = new Scanner(System.in);

        System.out.println("Введите: имя, фамилию, отчество, роль(менеджер = 1, сотрудник = 0) " +
                "адрес, ключевое слово. Каждый параметр с новой строки");

        String name = s.nextLine();
        String surname = s.nextLine();
        String patronymic = s.nextLine();
        String role = s.nextLine();
        String address = s.nextLine();
        String keyWord = s.nextLine();

        this.employees.add(new Employee(this.employees.size(), name, surname, patronymic,
                address, Integer.parseInt(role), keyWord));
    }

    public void addReader(){
        Scanner s = new Scanner(System.in);

        System.out.println("Введите: имя, фамилию, отчество, адрес читателя. Каждый параметр с новой строки");
        String name = s.nextLine();
        String surname = s.nextLine();
        String patronymic = s.nextLine();
        String address = s.nextLine();

        this.readers.add(new Reader(this.readers.size(), name, surname, patronymic, address));

    }

    public void removeReader(int id){
        for(Reader reader: this.readers){
            if (reader.id == id){
                this.readers.remove(reader);
            }
        }
    }
    public int authenticationCheck(String keyWord, String surname){
        for(Employee employee: this.employees){
            if (employee.keyWord.equals(keyWord) && employee.surname.equals(surname)){
                return employee.role;
            }
        }
        return -1;
    }
    public void removeEmployee(int id){
        for(Employee employee: this.employees){
            if (employee.id == id){
                this.employees.remove(employee);
            }
        }
    }
}

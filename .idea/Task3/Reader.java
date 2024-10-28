package Task3;

import java.util.ArrayList;

public class Reader {
    int id;
    String firstName;
    String lastName;
    String patronymic;
    String address;
    ArrayList<Book> borrowedBooks;

    public Reader(int id, String firstName, String lastName, String patronymic, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.borrowedBooks = new ArrayList<>();
    }

    public String borrowBook(Book book){
        if (!book.isTaken){
            book.isTaken = true;
            return "Вы взяли книгу";
        }
        return "Книга уже взята";
    }

    public String returnBook(Book book) {
        if (book.isTaken) {
            book.isTaken = false;
            return "Вы вернули книгу";
        }
        return "Книга не была взята";
    }
}

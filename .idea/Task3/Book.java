package Task3;

public class Book {
    public int id;
    public String name;
    public String author;
    public String publisher;
    public int year;
    public String category;
    public boolean isTaken;

    public Book(int id, String name, String author, String publisher, int year, String category, boolean isTaken) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.category = category;
        this.isTaken = isTaken;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", category='" + category + '\'' +
                '}';
    }
}

package Task3;

public class Employee {
    public int id;
    public String name;
    public String surname;
    public String patronymic;
    public String address;
    public int role; // 0 - usual, 1 - manager
    public String keyWord;

    public Employee(int id, String name, String surname, String patronymic, String address, int role, String keyWord) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.role = role;
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", role=" + role +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

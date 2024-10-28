package Task;

public class Employee {
    int id;
    String name, surname;
    int birthYear;
    String birthPlace;
    int salary;
    String familyPosition;


    public Employee(int id, String name, String surname, int birthYear, String birthPlace, int salary, String familyPosition) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.salary = salary;
        this.familyPosition = familyPosition;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                ", birthPlace='" + birthPlace + '\'' +
                ", salary=" + salary +
                ", familyPosition='" + familyPosition + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public int getSalary() {
        return salary;
    }

    public String getFamilyPosition() {
        return familyPosition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setFamilyPosition(String familyPosition) {
        this.familyPosition = familyPosition;
    }
}

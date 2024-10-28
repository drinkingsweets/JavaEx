package Task;

import java.util.Arrays;

public class Employers {
    Employee[] all = new Employee[100];
    int size = 0;

    public boolean add(Employee employee) {

        for (int i = 0; i < all.length - 1; i++) {
                if (all[i] != null && all[i].getId() == employee.getId()) {
                    return false;
                }
            } // check on unique id

            int free = 0;
            while (true){
                if (all[free] == null){
                    break;
                }
                else {
                    if (free < 99) {
                        free++;
                    }
                    else {
                        break;
                    }
                }
            } // find first free cell

            all[free] = employee;
            size++;

        return true;
    }

    public Employee get(int index){
        return all[index];
    }
    public int size(){
        return size;
    }
    public void find(int idToFind) {
        for (int i = 0; i < all.length; i++) {
            if (all[i] != null && all[i].getId() == idToFind) {
                System.out.println(all[i]);
                break;
            }
        }
    }

    public void findName(String nameToFind) {
        for (int i = 0; i < all.length; i++) {
            if (all[i] != null && all[i].getName().equals(nameToFind)) {
                System.out.println(all[i]);
            }
        }
    }

    public void findYear(int yearToFind) {
        for (int i = 0; i < all.length; i++) {
            if (all[i] != null && all[i].getBirthYear() == yearToFind) {
                System.out.println(all[i]);
            }
        }
    }

    public int sumSalary(){
        int sum = 0;
        for (int i = 0; i < all.length; i++) {

            if (all[i] != null) sum += all[i].getSalary();
        }
        return sum;
    }
}
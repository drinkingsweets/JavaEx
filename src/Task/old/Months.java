package Task.old;

public enum Months {
    JANUARY(31) {
        @Override
        public void doSomething() {
            System.out.println("January has 31 days");
        }
    },
    FEBRUARY(28) { // For simplicity, assuming non-leap year
        @Override
        public void doSomething() {
            System.out.println("February has 28 days");
        }
    },
    MARCH(31) {
        @Override
        public void doSomething() {
            System.out.println("March has 31 days");
        }
    },
    APRIL(30) {
        @Override
        public void doSomething() {
            System.out.println("April has 30 days");
        }
    },
    MAY(31) {
        @Override
        public void doSomething() {
            System.out.println("May has 31 days");
        }
    },
    JUNE(30) {
        @Override
        public void doSomething() {
            System.out.println("June has 30 days");
        }
    },
    JULY(31) {
        @Override
        public void doSomething() {
            System.out.println("July has 31 days");
        }
    },
    AUGUST(31) {
        @Override
        public void doSomething() {
            System.out.println("August has 31 days");
        }
    },
    SEPTEMBER(30) {
        @Override
        public void doSomething() {
            System.out.println("September has 30 days");
        }
    },
    OCTOBER(31) {
        @Override
        public void doSomething() {
            System.out.println("October has 31 days");
        }
    },
    NOVEMBER(30) {
        @Override
        public void doSomething() {
            System.out.println("November has 30 days");
        }
    },
    DECEMBER(31) {
        @Override
        public void doSomething() {
            System.out.println("December has 31 days");
        }
    };

    private final int days;

    Months(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public abstract void doSomething();
}

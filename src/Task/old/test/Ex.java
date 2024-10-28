package Task.old.test;

public class Ex {
    int attr;

    public Ex(){

    }

    public Ex(int attr){
        this.attr = attr;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "Ex{" +
                "attr=" + attr +
                '}';
    }
}

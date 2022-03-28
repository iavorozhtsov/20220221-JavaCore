package HomeWork_01;

public class Member {
    String name;
    double maxHeight;
    double speed;
    int stamina;
    boolean completeCourse;
    double result;

    public Member(String name, double maxHeight, double speed, int stamina) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.speed = speed;
        this.stamina = stamina;
    }

    public void setCompleteCourse(boolean completeCourse) {
        this.completeCourse = completeCourse;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public boolean isCompleteCourse() {
        return completeCourse;
    }

    public double getResult() {
        return result;
    }
}

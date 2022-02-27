package HomeWork_01;

import java.util.Random;

public class Course {
    private double[] barriers;
    private int courseLength;
    private Random rnd = new Random();
    private int barrierCount = 5 + rnd.nextInt(5);

    public Course(int courseLength) {
        this.barrierCount = barrierCount;
        this.courseLength = courseLength;

        this.createCourse(barrierCount);
    }

    public void createCourse(int count){
        barriers = new double[count];

        for (int i = 0; i < barriers.length; i++) {
            barriers[i] = 1 + rnd.nextDouble(0.7);
        }
    }

    public String getAllBarriers(){
        String s = "Course length:\t" + courseLength + "\n";

        for (int i = 0; i < barriers.length; i++) {
            s += i + ": \t" + barriers[i] + "\n";
        }
        return s;
    }

    public void doIt(Team team){
        int penalty = 0;

        for (int i = 0; i < team.getMembersCount(); i++) {
            for (int j = 0; j < barrierCount; j++) {
                if (team.getMemberMaxHeight(i) < barriers[j]){
                    penalty += 10;
                }

                if ((team.getMemberStamina(i) - penalty) < courseLength){
                    team.setMemberCompleteCourse(i, false);
                    break;
                }
                else {
                    team.setMemberCompleteCourse(i, true);
                }
            }
            if (team.isMemberCompleteCourse(i)){
                team.setMemberResult(i, courseLength / team.getMemberSpeed(i));
            }
            penalty = 0;
        }
    }
}

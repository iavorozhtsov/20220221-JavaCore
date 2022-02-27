package HomeWork_01;

import java.util.Random;

public class MainApp {
    private static Random rnd = new Random();

    public static void main (String[] args){

        Team team = new Team("Crabs", 5);
        team.createMembers();

//        System.out.println(team.getAllMembers());

        Course course = new Course(250 + rnd.nextInt(60));
        System.out.println(course.getAllBarriers());

        course.doIt(team);
        System.out.println(team.getAllMembers());

        System.out.println(team.getWinnerChart());
    }
}

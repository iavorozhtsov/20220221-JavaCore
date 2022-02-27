package HomeWork_01;

public class Team {
    private String name;
    private Member[] members;

    public Team(String name, int membersCount) {
        this.name = name;
        this.members = new Member[membersCount];
    }

    public void createMembers(){
        members[0] = new Member("Ivan", 1.50, 8.0, 300);
        members[1] = new Member("Alexandr", 1.75, 7.0, 270);
        members[2] = new Member("Roman", 1.45, 9.0, 300);
        members[3] = new Member("Oleg", 1.68, 6.5, 280);
        members[4] = new Member("Vladimir", 1.40, 9.5, 310);
    }
    public String getAllMembers(){
        String s = "";

        for (int i = 0; i < members.length; i++) {
            s += "Name: \t" + members[i].getName() + "\nMax height:\t" + members[i].getMaxHeight() +
                    "\nSpeed:\t" + members[i].getSpeed() + "\nStamina:\t" + members[i].getStamina() +
                    "\nCompl. course:\t" + members[i].isCompleteCourse() + "\nResult:\t" + members[i].getResult() +
                    "\n***********\n";
        }
        return s;
    }

    public String getWinnerChart(){
        String s1 = "This members are finished course:\n";
        String s2 = "";
        double minRes = 9999.0;

        for (int i = 0; i < members.length; i++) {
            if (members[i].isCompleteCourse()){
                s1 += members[i].getName() + "\n";
                if (members[i].getResult() <= minRes){
                    minRes = members[i].getResult();
                    s2 = "\nThe winner is:\t" + members[i].getName();
                }
            }
        }

        if (s2.length() < 5){
            s2 = "No one!";
        }

        return s1 + s2;
    }

    public void setMemberCompleteCourse(int memberId, boolean memberResult){
        members[memberId].setCompleteCourse(memberResult);
    }

    public int getMembersCount(){
        return members.length;
    }

    public double getMemberMaxHeight(int memberId){
        return members[memberId].getMaxHeight();
    }

    public int getMemberStamina(int memberId){
        return members[memberId].getStamina();
    }

    public boolean isMemberCompleteCourse(int memberId){
        return members[memberId].isCompleteCourse();
    }

    public void setMemberResult(int memberId, double res){
        members[memberId].setResult(res);
    }

    public double getMemberSpeed(int memberId){
        return members[memberId].getSpeed();
    }
}

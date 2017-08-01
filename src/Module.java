import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alan on 28.01.16.
 */
public class Module implements Serializable{
    private String name;
    private int assignmentMark1,
                    assignmentMark2;
    private int finalExamMark;
    public static final int COUNT = 1;

    public Module(String name) {
        this.name = name;
    }

    public Module(String name, int assignmentMark1, int assignmentMark2, int finalExamMark) {
        this.name = name;
        this.assignmentMark1 = assignmentMark1;
        this.assignmentMark2 = assignmentMark2;
        this.finalExamMark = finalExamMark;
    }

    public String convertMarks(int mark) {
        String s;
        if (mark > 90) {
            s = "A+";
            return s;
        } else if (mark > 80) {
            s = "A";
            return s;
        }
        else if (mark > 75) {
            s = "B+";
            return s;
        }
        else if (mark > 70) {
            s = "B";
            return s;
        }
        else if (mark > 65) {
            s = "B-";
            return s;
        }
        else if (mark > 60) {
            s = "C+";
            return s;
        }
        else if (mark > 55) {
            s = "C";
            return s;
        }
        else if (mark > 50) {
            s = "C-";
            return s;
        }
        else if (mark > 45) {
            s = "D";
            return s;
        }
        else if (mark > 40) {
            s = "D-";
            return s;
        }
        else if (mark > 35) {
            s = "F+";
            return s;
        }
        else if (mark > 30) {
            s = "F";
            return s;
        }
        else if (mark > 25) {
            s = "F-";
            return s;
        }

        return null;
    }

    private String countOverall() {
        int a2 = (this.assignmentMark1 + this.assignmentMark2)/2;
        int overall = (a2 + this.finalExamMark)/2;

        return convertMarks(overall);
    }

    public void showMarks(Module module) {
        String assignment1 = convertMarks(module.assignmentMark1);
        String assignment2 = convertMarks(module.assignmentMark2);
        String finalEx = convertMarks(module.finalExamMark);

        if (assignment1 == null || assignment2 == null || finalEx == null) {
            System.out.println("First assignment mark is not available");
            System.out.println("Second assignment mark is not available");
            System.out.println("Final exam mark is not available");
            System.out.println("Overall module mark is not available");
        } else {
            System.out.println("First assignment mark: " + assignment1);
            System.out.println("Second assignment mark: " + assignment2);
            System.out.println("Final exam mark: " + finalEx);
            System.out.println("Overall module mark: " + countOverall());
        }
    }

    public void deleteAssignmentMark1(Module module) {
        module.assignmentMark1 = -1;
    }

    public void deleteAssignmentMark2(Module module) {
        module.assignmentMark2 = -1;
    }

    public void deleteFinalExamMark(Module module) {
        module.finalExamMark = -1;
    }

    @Override
    public String toString() {
        return name;
    }
}

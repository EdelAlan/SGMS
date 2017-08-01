import java.io.*;

/**
 * Created by alan on 28.01.16.
 */
public class Student extends Administrator implements Serializable {
    private String identCardNum;
    private String studentId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String nationality;
    private String dateJoined;
    private String faculty;
    private Module module1,
                    module2,
                    module3;
    private String mobileNumber;
    private String email;

    public Student(String identCardNum, String studentId, String name, String gender,
                   String dateOfBirth, String nationality,
                   String dateJoined, String faculty,
                   Module module1,Module module2,Module module3, String mobileNumber, String email) {
        this.identCardNum = identCardNum;
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.dateJoined = dateJoined;
        this.faculty = faculty;
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    @Override
    public  void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Logged as " + this.studentId);
        System.out.println();
        System.out.println("1.View results");
        System.out.println("2.Logout");

        try {
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                view();
            } else if (choose == 2) {
                logout();
            } else {
                System.out.println("Wrong input!");
                menu();
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
            menu();
        }

    }

    public String getName() {
        return name;
    }

    public Module getModule1() {
        return module1;
    }

    public Module getModule2() {
        return module2;
    }

    public Module getModule3() {
        return module3;
    }

    public void setModule1(Module module1) {
        this.module1 = module1;
    }

    public void setModule2(Module module2) {
        this.module2 = module2;
    }

    public void setModule3(Module module3) {
        this.module3 = module3;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getIdentCardNum() {
        return identCardNum;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String getLogin() {
        return studentId;
    }

    @Override
    public String getPassword() {
        return identCardNum;
    }

    @Override
    public void view() {
        System.out.println(this.getModule1().toString());
        this.getModule1().showMarks(this.getModule1());
        System.out.println();
        System.out.println(this.getModule2().toString());
        this.getModule2().showMarks(this.getModule2());
        System.out.println();
        System.out.println(this.getModule3().toString());
        this.getModule3().showMarks(this.getModule3());
        System.out.println();
    }

    @Override
    public void logout() {
        super.logout();
    }

    @Override
    public String toString() {
        return "Student's NIC number: " + identCardNum + '\n' +
                "ID number: " + studentId + '\n' +
                "Name: " + name + '\n' +
                "Phone number: " + mobileNumber + '\n' +
                "Email: " + email + '\n' +
                "Gender: " + gender + '\n' +
                "Date of Birth: " + dateOfBirth + '\n' +
                "Nationality: " + nationality + '\n' +
                "Date joined: " + dateJoined + '\n' +
                "Faculty: " + faculty + '\n' +
                "Module 1: " + module1 + '\n' +
                "Module 2: " + module2 + '\n' +
                "Module 3: " + module3 + '\n';
    }

}

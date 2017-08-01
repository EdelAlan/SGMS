import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * Created by alan on 28.01.16.
 */
public class AdministrativeStaff extends Administrator implements Serializable {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;

    public AdministrativeStaff() {

    }

    public AdministrativeStaff(String id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    AdministrativeStaff aidos = new AdministrativeStaff();

    AdministrativeStaff alan = new AdministrativeStaff("123", "Alan", "01124234", "pidar@mail.ru");

    @Override
    public  void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println();
            System.out.println("Logged as " + this.getName());
            System.out.println();
            System.out.println("1.Search student");
            System.out.println("2.Logout");

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
            System.out.println();
            menu();
        }
    }

    @Override
    public String getLogin() {
        return id;
    }


    @Override
    public String getPassword() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void logout() {
        super.logout();
    }

    @Override
    public void view() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter 0 to exit to main menu");
            System.out.print("Enter student's name: ");
            String name = reader.readLine();
            int found = searchStudent(name);
            if (found == -1) {
                System.out.println("No student with such information");
                view();
            } else if (name.equals("0")) {
                menu();
            }
            for (int i=0;i<Data.getStudents().size();i++) {
                System.out.println(Data.getStudents().get(found).toString());
                System.out.println(Data.getStudents().get(found).getModule1().toString());
                Data.getStudents().get(found).getModule1().showMarks(Data.getStudents().get(found).getModule1());
                System.out.println();
                System.out.println(Data.getStudents().get(found).getModule2().toString());
                Data.getStudents().get(found).getModule2().showMarks(Data.getStudents().get(found).getModule2());
                System.out.println();
                System.out.println(Data.getStudents().get(found).getModule3().toString());
                Data.getStudents().get(found).getModule3().showMarks(Data.getStudents().get(found).getModule2());
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
            view();
        }
    }

    @Override
    public int searchStudent(String input) {
        return super.searchStudent(input);
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Phone number: " + phoneNumber + '\n' +
                "Email: " + email + '\n' +
                "ID: " + id + '\n';
    }
}

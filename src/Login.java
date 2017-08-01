import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alan on 28.01.16.
 */
public class Login {
    private String login;
    private String password;
    public static boolean access = false;
    Administrator administrator = new Administrator();


    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public static Login askLogin() throws IOException{
        Login login;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter login: ");
        String loginName = reader.readLine();
        System.out.print("Enter password: ");
        String password = reader.readLine();
        login=new Login(loginName, password);
        return login;
    }

    public void checkLogin() {

        Start start = new Start();

        if (this.getLogin().equals(Administrator.LOGIN) && this.getPassword().equals(Administrator.PASSWORD)) {
            access=true;
            while (access) {
                administrator.menu();
            }
            if (!access) {
                start.start();
            }
        } else {
            for (int i=0;i<Data.getStudents().size();i++) {
                if (this.getLogin().equals(Data.getStudents().get(i).getLogin()) && this.getPassword().equals(Data.getStudents().get(i).getPassword())) {
                    access=true;
                    while (access) {
                        Data.getStudents().get(i).menu();
                    }
                    if (!access) {
                        start.start();
                    }
                }
            }

            for (int i=0;i<Data.getLecturers().size();i++) {
                if (this.getLogin().equals(Data.getLecturers().get(i).getLogin()) && this.getPassword().equals(Data.getLecturers().get(i).getPassword())) {
                    access=true;
                    while (access) {
                        Data.getLecturers().get(i).menu();
                    }
                    if (!access) {
                        start.start();
                    }
                }
            }

            for (int i=0;i<Data.getAdministrativeStaffs().size();i++) {
                if (this.getLogin().equals(Data.getAdministrativeStaffs().get(i).getLogin()) && this.getPassword().equals(Data.getAdministrativeStaffs().get(i).getPassword())) {
                    access=true;
                    while (access) {
                        Data.getAdministrativeStaffs().get(i).menu();
                    }
                    if (!access) {
                        start.start();
                    }
                }
            }

            System.out.println("Wrong input! Please try again");
            start.start();
        }

    }
}

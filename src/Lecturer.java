import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alan on 28.01.16.
 */

public class Lecturer extends Administrator implements Serializable {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private Module module;
    public Lecturer(String id, String name, Module module, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.module = module;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public Module getModule() {
        return module;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public  void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("1.Edit or Add new records");
        System.out.println("2.Delete records");
        System.out.println("3.View records");
        System.out.println("4.Logout");

        try {
            int i = Integer.parseInt(reader.readLine());
            if (i == 1) {
                addRecord();
            } else if (i ==2) {
                deleteRecord();
            } else if (i ==3) {
                view();
            } else if (i ==4) {
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

    @Override
    public  void addRecord() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
        int count = Module.COUNT;
        try {
            for (int i=0;i<Data.getStudents().size();i++) {
                if (this.getModule().toString().equals(Data.getStudents().get(i).getModule1().toString())) {
                    System.out.println(count++ +"."+ Data.getStudents().get(i).getName());
                    System.out.println();
                    names.add(Data.getStudents().get(i).getName());
                } else if (this.getModule().toString().equals(Data.getStudents().get(i).getModule2().toString())) {
                    System.out.println(count++ +"."+ Data.getStudents().get(i).getName());
                    System.out.println();
                    names.add(Data.getStudents().get(i).getName());
                } else if (this.getModule().toString().equals(Data.getStudents().get(i).getModule3().toString())) {
                    System.out.println(count++ +"."+ Data.getStudents().get(i).getName());
                    System.out.println();
                    names.add(Data.getStudents().get(i).getName());
                }
            }
            System.out.println("Enter 0 to exit to main menu");
            System.out.println("Enter student's name, ID number, or NIC number: ");
            String chooseName = reader.readLine();
            int i = searchStudent(chooseName);
            if (i == -1) {
                System.out.println("No student with such information");
                addRecord();
            } else if (chooseName.equals("0")) {
                menu();
            }
            for (int k=0;k<names.size();k++) {
                if (chooseName.equals(names.get(k)) && this.getModule().toString().equals(Data.getStudents().get(i).getModule1().toString())) {
                    System.out.println(names.get(k));
                    System.out.print("First assignment marks: ");
                    int assignment1 = Integer.parseInt(reader.readLine());
                    System.out.print("Second assignment marks: ");
                    int assignment2 = Integer.parseInt(reader.readLine());
                    System.out.println("Final exam marks: ");
                    int finalExam = Integer.parseInt(reader.readLine());
                    Module module = new Module(Data.getStudents().get(i).getModule1().toString(), assignment1, assignment2, finalExam);
                    Data.getStudents().get(i).setModule1(module);
                    System.out.println("Marks have been saved");
                    menu();
                }else if (chooseName.equals(names.get(k)) && this.getModule().toString().equals(Data.getStudents().get(i).getModule2().toString())) {
                    System.out.println(names.get(k));
                    System.out.print("First assignment marks: ");
                    int assignment1 = Integer.parseInt(reader.readLine());
                    System.out.print("Second assignment marks: ");
                    int assignment2 = Integer.parseInt(reader.readLine());
                    System.out.println("Final exam marks: ");
                    int finalExam = Integer.parseInt(reader.readLine());
                    Module module = new Module(Data.getStudents().get(i).getModule2().toString(), assignment1, assignment2, finalExam);
                    Data.getStudents().get(i).setModule2(module);
                    System.out.println("Marks have been saved");
                    menu();
                } else if (chooseName.equals(names.get(k)) && this.getModule().toString().equals(Data.getStudents().get(i).getModule3().toString())) {
                    System.out.println(names.get(k));
                    System.out.print("First assignment marks: ");
                    int assignment1 = Integer.parseInt(reader.readLine());
                    System.out.print("Second assignment marks: ");
                    int assignment2 = Integer.parseInt(reader.readLine());
                    System.out.println("Final exam marks: ");
                    int finalExam = Integer.parseInt(reader.readLine());
                    Module module = new Module(Data.getStudents().get(i).getModule3().toString(), assignment1, assignment2, finalExam);
                    Data.getStudents().get(i).setModule3(module);
                    System.out.println("Marks have been saved");
                    menu();
                } else {
                    System.out.println("No student with such information");
                    addRecord();
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
            addRecord();
        }
    }

    @Override
    public void deleteRecord() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
        int count = Module.COUNT;
        try {
            for (int i = 0; i < Data.getStudents().size(); i++) {
                if (this.getModule().toString().equals(Data.getStudents().get(i).getModule1().toString())) {
                    System.out.println(count++ + "." + Data.getStudents().get(i).getName());
                    System.out.println();
                    names.add(Data.getStudents().get(i).getName());
                } else if (this.getModule().toString().equals(Data.getStudents().get(i).getModule2().toString())) {
                    System.out.println(count++ + "." + Data.getStudents().get(i).getName());
                    System.out.println();
                    names.add(Data.getStudents().get(i).getName());
                } else if (this.getModule().toString().equals(Data.getStudents().get(i).getModule3().toString())) {
                    System.out.println(count++ + "." + Data.getStudents().get(i).getName());
                    System.out.println();
                    names.add(Data.getStudents().get(i).getName());
                }
            }
            System.out.println("Enter 0 to exit to main menu");
            System.out.println("Enter student's name, ID number, or NIC number: ");
            String chooseName = reader.readLine();
            int i = searchStudent(chooseName);
            if (i == -1) {
                System.out.println("No student with such information");
                deleteRecord();
            } else if (chooseName.equals("0")) {
                menu();
            }
            for (int k=0;k<names.size();k++) {
                if (chooseName.equals(names.get(k)) && this.getModule().toString().equals(Data.getStudents().get(i).getModule1().toString())) {
                    System.out.println("1.Delete record for first assignment");
                    System.out.println("2.Delete record for second assignment");
                    System.out.println("3.Delete record for final exam");
                    System.out.println("0.Exit to main menu");
                    int j = Integer.parseInt(reader.readLine());
                    if (j == 1) {
                        Data.getStudents().get(i).getModule1().deleteAssignmentMark1(Data.getStudents().get(i).getModule1());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 2) {
                        Data.getStudents().get(i).getModule1().deleteAssignmentMark2(Data.getStudents().get(i).getModule1());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 3) {
                        Data.getStudents().get(i).getModule1().deleteFinalExamMark(Data.getStudents().get(i).getModule1());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 0) {
                        menu();
                    } else {
                        System.out.println("Wrong input!");
                        deleteRecord();
                    }
                } else if (chooseName.equals(names.get(k)) && this.getModule().toString().equals(Data.getStudents().get(i).getModule2().toString())) {
                    System.out.println("1.Delete record for first assignment");
                    System.out.println("2.Delete record for second assignment");
                    System.out.println("3.Delete record for final exam");
                    System.out.println("0.Exit to main menu");
                    int j = Integer.parseInt(reader.readLine());
                    if (j == 1) {
                        Data.getStudents().get(i).getModule2().deleteAssignmentMark1(Data.getStudents().get(i).getModule2());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 2) {
                        Data.getStudents().get(i).getModule2().deleteAssignmentMark2(Data.getStudents().get(i).getModule2());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 3) {
                        Data.getStudents().get(i).getModule2().deleteFinalExamMark(Data.getStudents().get(i).getModule2());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 0) {
                        menu();
                    } else {
                        System.out.println("Wrong input!");
                        deleteRecord();
                    }
                } else if (chooseName.equals(names.get(k)) && this.getModule().toString().equals(Data.getStudents().get(i).getModule3().toString())) {
                    System.out.println("1.Delete record for first assignment");
                    System.out.println("2.Delete record for second assignment");
                    System.out.println("3.Delete record for final exam");
                    System.out.println("0.Exit to main menu");
                    int j = Integer.parseInt(reader.readLine());
                    if (j == 1) {
                        Data.getStudents().get(i).getModule3().deleteAssignmentMark1(Data.getStudents().get(i).getModule3());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 2) {
                        Data.getStudents().get(i).getModule3().deleteAssignmentMark2(Data.getStudents().get(i).getModule3());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 3) {
                        Data.getStudents().get(i).getModule3().deleteFinalExamMark(Data.getStudents().get(i).getModule3());
                        System.out.println("Marks have been deleted");
                        menu();
                    } else if (j == 0) {
                        menu();
                    } else {
                        System.out.println("Wrong input!");
                        deleteRecord();
                    }
                } else {
                    System.out.println("No student with such information");
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
            deleteRecord();
        }
    }

    @Override
    public int searchStudent(String input) {
        return super.searchStudent(input);
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
    public void logout() {
        super.logout();
    }

    @Override
    public String toString() {
        return "Lecturer" +
                "Module: "+ module + '\n' +
                "ID: " + id + '\n' +
                "Name: " + name+ '\n' +
                "Phone number: " + phoneNumber + '\n' +
                "Email: " + email + '\n';
    }
}

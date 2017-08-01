import java.io.*;


/**
 * Created by alan on 28.01.16.
 */
public class Administrator {
    public static final String LOGIN = "Admin";
    public static final String PASSWORD = "123456";

    public String getLogin() {
        return LOGIN;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public void menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println();
            System.out.println("Logged as ADMIN");
            System.out.println();
            System.out.println("1.Register new user");
            System.out.println("2.Edit user");
            System.out.println("3.Delete user");
            System.out.println("4.Add new record");
            System.out.println("5.Edit record");
            System.out.println("6.Delete record");
            System.out.println("7.Add new module");
            System.out.println("8.Delete module");
            System.out.println("9.Search");
            System.out.println("0.Logout");

            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                toRegister();
            } else if (choose == 2) {
                editUser();
            } else if (choose == 3) {
                deleteUser();
            } else if (choose == 4) {
                addRecord();
            } else if (choose == 5) {
                addRecord();
            } else if (choose == 6) {
                deleteRecord();
            } else if (choose == 7) {
                addModule();
            } else if (choose == 8) {
                deleteModule();
            } else if (choose == 9) {
                view();
            } else if (choose == 0) {
                logout();
            } else {
                System.out.println("Wrong input!");
                menu();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            menu();
        }
    }

    public  void deleteStudent() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit to main menu");
        System.out.print("Enter student's name, ID number, or NIC number: ");
        try {
            String input = reader.readLine();
            int i = searchStudent(input);
            if (i == -1) {
                System.out.println("No student with such information");
                deleteStudent();
            } else if (input.equals("0")) {
                menu();
            }
            System.out.println(Data.getStudents().get(i).toString());
            System.out.println("1.Delete student");
            System.out.println("2.Search over");
            System.out.println("3.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Student with ID " + Data.getStudents().get(i).getLogin() + " has been deleted");
                Data.getStudents().remove(i);
                menu();
            } else if (choose == 2) {
                deleteStudent();
            } else if (choose == 3) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteStudent();
        }
    }

    public  void deleteLecturer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit to main menu");
        System.out.print("Enter lecturer's name or ID number: ");
        try {
            String input = reader.readLine();
            int i = searchLecturer(input);
            if (i == -1) {
                System.out.println("No student with such information");
                deleteLecturer();
            } else if (input.equals("0")) {
                menu();
            }
            System.out.println(Data.getLecturers().get(i).toString());
            System.out.println("1.Delete lecturer");
            System.out.println("2.Search over");
            System.out.println("3.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Lecturer with ID " + Data.getLecturers().get(i).getLogin() + " has been deleted");
                Data.getLecturers().remove(i);
                deleteLecturer();
                menu();
            } else if (choose == 2) {
                deleteLecturer();
            } else if (choose == 3) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteLecturer();
        }
    }

    public  void deleteStaff() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 0 to exit to main menu");
        System.out.print("Enter staff's name or ID number: ");
        try {
            String input = reader.readLine();
            int i = searchStaff(input);
            if (i == -1) {
                System.out.println("No student with such information");
                deleteStaff();
            } else if (input.equals("0")) {
                menu();
            }
            System.out.println(Data.getAdministrativeStaffs().get(i).toString());
            System.out.println("1.Delete lecturer");
            System.out.println("2.Search over");
            System.out.println("3.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.println("Administrative staff with ID " + Data.getAdministrativeStaffs().get(i).getLogin() + " has been deleted");
                Data.getAdministrativeStaffs().remove(i);
                deleteStaff();
                menu();
            } else if (choose == 2) {
                deleteStaff();
            } else if (choose == 3) {
                menu();
            } else {
                System.out.println("Wrong input!");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteStaff();
        }
    }

    public  void deleteUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("1.Delete student");
            System.out.println("2.Delete lecturer");
            System.out.println("3.Delete administrative staff");
            System.out.println("0.Exit to menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                deleteStudent();
            } else if (choose == 2) {
                deleteLecturer();
            } else if (choose == 3) {
                deleteStaff();
            } else if (choose == 0) {
                menu();
            } else {
                System.out.println("Wrong input");
                deleteUser();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            deleteUser();
        }
    }

    public  void addModule() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("1.Add new module");
            System.out.println("0.Exit to main menu");
            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
                System.out.print("Enter module's name: ");
                try {
                    String name = reader.readLine();
                    for (int i = 0; i < Data.getModules().size(); i++) {
                        if (name.equals(Data.getModules().get(i).toString())) {
                            System.out.println("Module with this name already exists");
                            throw new IOException();
                        }
                    }
                    Data.getModules().add(new Module(name));
                } catch (IOException e) {
                    addModule();
                }
            } else if (choose == 0) {
                menu();
            } else {
                addModule();
            }
        } catch (Exception e) {
            System.out.println("Wrong input! Please try again");
            addModule();
        }
    }

    public  void deleteModule() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose module to be deleted:");
        int count = Module.COUNT;
        for (Object o : Data.getModules()) {
            System.out.println(count++ + "." + o.toString());
        }
        System.out.println("Press 0 to exit to main menu");

        try {
            int choose = Integer.parseInt(reader.readLine());
            for (int i=0;i<Data.getModules().size();i++) {
                if (choose == i+1) {
                    System.out.println("Module \"" + Data.getModules().get(i).toString() + "\" has been removed.");
                    Data.getModules().remove(i);
                    menu();
                    break;
                } else if (choose == 0) {
                    menu();
                    break;
                } else {
                    System.out.println("Wrong input! Please try again.");
                    deleteModule();
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
            deleteModule();
        }
    }

    public  void addRecord() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter student's ID number: ");
            String in = reader.readLine();
            int i = searchStudent(in);
            if (i==-1) {
                System.out.println("No student with such ID");
                menu();
            }
            System.out.println("Student's name: " + Data.getStudents().get(i).getName());
            System.out.println("Student's ID number: " + Data.getStudents().get(i).getIdentCardNum());
            System.out.println("Module 1: " + Data.getStudents().get(i).getModule1());
            System.out.println("Module 2: " + Data.getStudents().get(i).getModule2());
            System.out.println("Module 3: " + Data.getStudents().get(i).getModule3());
            System.out.println();
            System.out.println("Module 1 marks: ");
            Data.getStudents().get(i).getModule1().showMarks(Data.getStudents().get(i).getModule1());
            System.out.println();
            System.out.println("Module 2 marks: ");
            Data.getStudents().get(i).getModule1().showMarks(Data.getStudents().get(i).getModule2());
            System.out.println();
            System.out.println("Module 3 marks: ");
            Data.getStudents().get(i).getModule1().showMarks(Data.getStudents().get(i).getModule3());
            System.out.println();
            System.out.println("1.Add record for module 1");
            System.out.println("2.Add record for module 2");
            System.out.println("3.Add record for module 3");
            System.out.println("0.Exit to main menu");

            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
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
            } else if (choose == 2) {
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
            } else if (choose == 3) {
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
            } else if (choose == 0) {
                menu();
            } else {
                System.out.println("Wrong input");
                addRecord();
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
            addRecord();
        }

    }

    public  void deleteRecord() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter student's ID number: ");
            String in = reader.readLine();
            int i = searchStudent(in);
            if (i==-1) {
                System.out.println("No student with such ID");
                menu();
            }
            System.out.println("Student's name: " + Data.getStudents().get(i).getName());
            System.out.println("Student's ID number: " + Data.getStudents().get(i).getIdentCardNum());
            System.out.println("Module 1: " + Data.getStudents().get(i).getModule1());
            System.out.println("Module 2: " + Data.getStudents().get(i).getModule2());
            System.out.println("Module 3: " + Data.getStudents().get(i).getModule3());
            System.out.println();
            System.out.println("Module 1 marks: ");
            Data.getStudents().get(i).getModule1().showMarks(Data.getStudents().get(i).getModule1());
            System.out.println();
            System.out.println("Module 2 marks: ");
            Data.getStudents().get(i).getModule1().showMarks(Data.getStudents().get(i).getModule2());
            System.out.println();
            System.out.println("Module 3 marks: ");
            Data.getStudents().get(i).getModule1().showMarks(Data.getStudents().get(i).getModule3());
            System.out.println();
            System.out.println("1.Delete record for module 1");
            System.out.println("2.Delete record for module 2");
            System.out.println("3.Delete record for module 3");
            System.out.println("0.Exit to main menu");

            int choose = Integer.parseInt(reader.readLine());
            if (choose == 1) {
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
            } else if (choose == 2) {
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
            } else if (choose == 3) {
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
            } else if (choose == 0) {
                menu();
            } else {
                System.out.println("Wrong input");
                addRecord();
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
            deleteRecord();
        }
    }

    public  void editUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Edit student's information");
        System.out.println("2.Edit lecture's information");
        System.out.println("3.Edit staff's information");
        System.out.println("4.Exit to main menu");

        try {
            int i = Integer.parseInt(reader.readLine());
            if (i == 1) {
                System.out.print("Enter student's name, ID number, or NIC number: ");
                String input = reader.readLine();
                int j = searchStudent(input);
                if (j == -1) {
                    System.out.println("No student with such information");
                    editUser();
                }
                System.out.println(Data.getStudents().get(j).toString());
                System.out.println("1.Edit student's phone number");
                System.out.println("2.Edit student's email");
                System.out.println("3.Search over");
                System.out.println("4.Exit to main menu");
                int choose = Integer.parseInt(reader.readLine());
                if (choose == 1) {
                    System.out.println("Enter new phone number: ");
                    String phoneNumber = reader.readLine();
                    Data.getStudents().get(j).setMobileNumber(phoneNumber);
                    System.out.println("New phone number has been saved");
                    menu();
                } else if (choose == 2) {
                    System.out.println("Enter new email: ");
                    String email = reader.readLine();
                    Data.getStudents().get(j).setEmail(email);
                    System.out.println("New email has been saved");
                    menu();
                } else if (choose == 3) {
                    editUser();
                } else if (choose == 4) {
                    menu();
                } else {
                    System.out.println("Wrong input");
                    editUser();
                }
            } else if (i == 2) {
                System.out.print("Enter lecture's name or ID number: ");
                String input = reader.readLine();
                int j = searchLecturer(input);
                if (j == -1) {
                    System.out.println("No lecturer with such information");
                    editUser();
                }
                System.out.println(Data.getLecturers().get(j).toString());
                System.out.println("1.Edit lecture's phone number");
                System.out.println("2.Edit lecture's email");
                System.out.println("3.Search over");
                System.out.println("4.Exit to main menu");
                int choose = Integer.parseInt(reader.readLine());
                if (choose == 1) {
                    System.out.println("Enter new phone number: ");
                    String phoneNumber = reader.readLine();
                    Data.getLecturers().get(j).setPhoneNumber(phoneNumber);
                    System.out.println("New phone number has been saved");
                    menu();
                } else if (choose == 2) {
                    System.out.println("Enter new email: ");
                    String email = reader.readLine();
                    Data.getLecturers().get(j).setEmail(email);
                    System.out.println("New email has been saved");
                    menu();
                } else if (choose == 3) {
                    editUser();
                } else if (choose == 4) {
                    menu();
                } else {
                    System.out.println("Wrong input");
                    editUser();
                }
            } else if (i == 3) {
                System.out.print("Enter staff's name or ID number: ");
                String input = reader.readLine();
                int j = searchStaff(input);
                if (j == -1) {
                    System.out.println("No staff with such information");
                    editUser();
                }
                System.out.println(Data.getLecturers().get(j).toString());
                System.out.println("1.Edit staff's phone number");
                System.out.println("2.Edit staff's email");
                System.out.println("3.Search over");
                System.out.println("4.Exit to main menu");
                int choose = Integer.parseInt(reader.readLine());
                if (choose == 1) {
                    System.out.println("Enter new phone number: ");
                    String phoneNumber = reader.readLine();
                    Data.getAdministrativeStaffs().get(j).setPhoneNumber(phoneNumber);
                    System.out.println("New phone number has been saved");
                    menu();
                } else if (choose == 2) {
                    System.out.println("Enter new email: ");
                    String email = reader.readLine();
                    Data.getAdministrativeStaffs().get(j).setEmail(email);
                    System.out.println("New email has been saved");
                    menu();
                } else if (choose == 3) {
                    editUser();
                } else if (choose == 4) {
                    menu();
                } else {
                    System.out.println("Wrong input");
                    editUser();
                }
            } else if (i == 4) {
                menu();
            } else {
                System.out.println("Wrong input!");
                editUser();
            }
        }catch(Exception e){
            System.out.println("Wrong input! Please try again");
            editUser();
        }
    }

    public  int searchStudent(String input) {
        for (int i=0;i<Data.getStudents().size();i++) {
            if (input.equals(Data.getStudents().get(i).getLogin())) {
                return i;
            } else if (input.equals(Data.getStudents().get(i).getIdentCardNum())) {
                return i;
            } else if (input.equals(Data.getStudents().get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public  int searchLecturer(String input) {
        for (int i=0;i<Data.getLecturers().size();i++) {
            if (input.equals(Data.getLecturers().get(i).getLogin())) {
                return i;
            } else if (input.equals(Data.getLecturers().get(i).getName())) {
                return i;
            } else {
                System.out.println("Wrong input!");
            }
        }
        return -1;
    }

    public  int searchStaff(String input) {
        for (int i=0;i<Data.getAdministrativeStaffs().size();i++) {
            if (input.equals(Data.getAdministrativeStaffs().get(i).getLogin())) {
                return i;
            } else if (input.equals(Data.getAdministrativeStaffs().get(i).getName())) {
                return i;
            } else {
                System.out.println("Wrong input!");
            }
        }
        return -1;
    }

    public  void toRegister() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Register new student");
        System.out.println("2.Register new lecturer");
        System.out.println("3.Register new admin staff");
        System.out.println("0.Exit to main menu");
        try {
            int s = Integer.parseInt(reader.readLine());
            if (s == 1) {
                registerStudent();
            } else if (s == 2) {
                registerLecturer();
            } else if (s == 3) {
                registerStaff();
            } else if (s == 0) {
                menu();
            } else {
                System.out.println("Wrong input");
                toRegister();
            }
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            toRegister();
        }
    }

    private  void registerLecturer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter lecturer's name: ");
            String name = reader.readLine();
            System.out.println("Choose lecturer's module:");
            Module module = chooseModule();
            System.out.print("Enter lecturer's phone number: ");
            String phoneNumber = reader.readLine();
            System.out.print("Enter lecturer' email: ");
            String email = reader.readLine();
            String id;
            if (Data.getLecturerCountWrite().get(0) < 10) id = "L000" + Data.getLecturerCountWrite().get(0)+1;
            else if (Data.getLecturerCountWrite().get(0) < 100) id = "L00" + Data.getLecturerCountWrite().get(0)+1;
            else if (Data.getLecturerCountWrite().get(0) < 1000) id = "L0" + Data.getLecturerCountWrite().get(0)+1;
            else id = "L" + Data.getLecturerCountWrite().get(0)+1;

            System.out.println("Lecturer's ID number is " + id);
            Data.getLecturers().add(new Lecturer(id, name, module, phoneNumber, email));
            menu();
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            toRegister();
        }
    }

    private  void registerStaff() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter administrative staff's name: ");
            String name = reader.readLine();
            System.out.print("Enter administrative staff's phone number: ");
            String phoneNumber = reader.readLine();
            System.out.print("Enter administrative staff's email: ");
            String email = reader.readLine();
            String id;
            if (Data.getStaffCountWrite().get(0) < 10) id = "A000" + Data.getStaffCountWrite().get(0)+1;
            else if (Data.getStaffCountWrite().get(0) < 100) id = "A00" + Data.getStaffCountWrite().get(0)+1;
            else if (Data.getStaffCountWrite().get(0) < 1000) id = "A0" + Data.getStaffCountWrite().get(0)+1;
            else id = "A" + Data.getStaffCountWrite().get(0)+1;

            System.out.println("Staff's ID is " + id);
            Data.getAdministrativeStaffs().add(new AdministrativeStaff(id, name, phoneNumber, email));
            menu();
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            toRegister();
        }
    }

    private  void registerStudent() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Student registration");
            System.out.print("Enter NIC number: ");
            String identCardNum = reader.readLine();
            String studentId;
            System.out.print("Enter student's name: ");
            String name = reader.readLine();
            System.out.print("Enter student's gender: ");
            String gender = reader.readLine();
            System.out.print("Enter student's date of birth: ");
            String dateOfBirth = reader.readLine();
            System.out.print("Enter student's nationality: ");
            String nationality = reader.readLine();
            System.out.print("Enter student's joined date: ");
            String dateJoined = reader.readLine();
            System.out.print("Enter student's batch: ");
            String faculty = reader.readLine();
            Module module1 = chooseModule();
            Module module2 = chooseModule();
            while (module1.equals(module2)) {
                System.out.println("This module has already been chosen. Please try again.");
                module2 = chooseModule();
            }
            Module module3 = chooseModule();
            while (module3.equals(module1) || module3.equals(module2)) {
                System.out.println("This module has already been chosen. Please try again.");
                module3 = chooseModule();
            }
            System.out.print("Enter student's phone number: ");
            String mobileNumber = reader.readLine();
            System.out.print("Enter student's email: ");
            String email = reader.readLine();

            if (Data.getStudentCountWrite().get(0) < 10) studentId = "S00000" + Data.getStudentCountWrite().get(0)+1;
            else if (Data.getStudentCountWrite().get(0) < 100) studentId = "S0000" + Data.getStudentCountWrite().get(0)+1;
            else if (Data.getStudentCountWrite().get(0) < 1000) studentId = "S000" + Data.getStudentCountWrite().get(0)+1;
            else if (Data.getStudentCountWrite().get(0) < 10000) studentId = "S00" + Data.getStudentCountWrite().get(0)+1;
            else if (Data.getStudentCountWrite().get(0) < 100000) studentId = "S0)" + Data.getStudentCountWrite().get(0)+1;
            else studentId = "S" + Data.getStudentCountWrite().get(0)+1;

            Student student = new Student(identCardNum, studentId, name, gender, dateOfBirth,
                    nationality, dateJoined, faculty, module1, module2, module3, mobileNumber, email);

            Data.getStudents().add(student);
            System.out.println("Student was registered. ID number is " + studentId);
            menu();
        } catch (Exception e) {
            System.out.println("Wrong Input! Please try again");
            toRegister();
        }
    }

    private  Module chooseModule() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Module.COUNT;
        for (Object o : Data.getModules()) {
            System.out.println(count++ + "." + o.toString() + "\n");
        }
        Module module;
        try {
            int chooseModule = Integer.parseInt(reader.readLine());
            for (int i=0;i<Data.getModules().size(); i++) {
                if (chooseModule == i) {
                    module = Data.getModules().get(chooseModule-1);
                    return module;
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
            chooseModule();
        }
        return null;
    }

    public void logout() {
        try {
            Data.writeStaff();
            Data.writeModule();
            Data.writeLecturer();
            Data.writeStudent();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Login.access = false;
    }

    public void view() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.Search for a student");
        System.out.println("2.Search for a lecturer");
        System.out.println("3.Search for a staff");
        System.out.println("4.Exit to main menu");

        try {
            int i = Integer.parseInt(reader.readLine());
            if (i == 1) {
                System.out.print("Enter student's name: ");
                String s = reader.readLine();
                int j = searchStudent(s);
                System.out.println(Data.getStudents().get(j).toString());
                Data.getStudents().get(j).getModule1().showMarks(Data.getStudents().get(j).getModule1());
                Data.getStudents().get(j).getModule2().showMarks(Data.getStudents().get(j).getModule2());
                Data.getStudents().get(j).getModule3().showMarks(Data.getStudents().get(j).getModule3());
            } else if (i == 2) {
                System.out.print("Enter lecture's name: ");
                String s = reader.readLine();
                int j = searchLecturer(s);
                System.out.println(Data.getLecturers().get(j).toString());
            } else if (i == 3) {
                System.out.print("Enter staff's name: ");
                String s = reader.readLine();
                int j = searchStaff(s);
                System.out.println(Data.getAdministrativeStaffs().get(j).toString());
            } else if (i == 4) {
                menu();
            } else {
                System.out.println("Wrong input!");
                view();
            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
            view();
        }

    }

}

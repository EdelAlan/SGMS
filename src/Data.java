import java.io.*;
import java.util.ArrayList;

/**
 * Created by alan on 01.02.16.
 */
public class Data {
    private static int studentCount=1;
    private static int lecturerCount=1;
    private static int staffCount=1;

    private static ArrayList<Lecturer> lecturersRead = new ArrayList<>();
    private static ArrayList<Student> studentsRead = new ArrayList<>();
    private static ArrayList<AdministrativeStaff> administrativeStaffsRead = new ArrayList<>();
    private static ArrayList<Module> modulesRead = new ArrayList<>();
    private static ArrayList<Integer> studentCountRead = new ArrayList<>();
    private static ArrayList<Integer> lecturerCountRead = new ArrayList<>();
    private static ArrayList<Integer> staffCountRead = new ArrayList<>();

    private static ArrayList<Lecturer> lecturersWrite = new ArrayList<>();
    private static ArrayList<Student> studentsWrite = new ArrayList<>();
    private static ArrayList<AdministrativeStaff> administrativeStaffsWrite = new ArrayList<>();
    private static ArrayList<Module> modulesWrite = new ArrayList<>();
    private static ArrayList<Integer> studentCountWrite = new ArrayList<>();
    private static ArrayList<Integer> lecturerCountWrite = new ArrayList<>();
    private static ArrayList<Integer> staffCountWrite = new ArrayList<>();

    static {
        try {
            Data.readLecturerCount();
            Data.readStudentCount();
            Data.readStaffCount();
            Data.readStudent();
            Data.readModule();
            Data.readLecturer();
            Data.readStaff();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getStudentCountWrite().add(0,studentCount);
        getLecturerCountWrite().add(0, lecturerCount);
        getStaffCountWrite().add(0, staffCount);
        studentCountWrite = studentCountRead;
        lecturerCountWrite = lecturerCountRead;
        staffCountWrite = staffCountRead;
        lecturersWrite = lecturersRead;
        studentsWrite = studentsRead;
        modulesWrite = modulesRead;
        administrativeStaffsWrite = administrativeStaffsRead;
    }

    /*private static Module oodj = new Module("Object Oriented Development with Java");
    private static Module ipeli = new Module("Intellectual Property, Ethics and Legal Issues");
    private static Module psmod = new Module("Probability and Statistical Modelling");
    private static Module pdt = new Module("Professional Enterprise Development");
    private static Module spcc =new Module("System Programming and Computer Control");
    private static Module sdm = new Module("System Development Methods");

    static {
        modulesRead.add(oodj);
        modulesRead.add(ipeli);
        modulesRead.add(psmod);
        modulesRead.add(pdt);
        modulesRead.add(spcc);
        modulesRead.add(sdm);
    }*/

    public static  ArrayList<Lecturer> getLecturers() {
        return lecturersWrite;
    }

    public static void setLecturers(ArrayList<Lecturer> lecturers) {
        lecturersRead = lecturers;
    }

    public static ArrayList<Student> getStudents() {
        return studentsWrite;
    }

    public static void setStudents(ArrayList<Student> students) {
        studentsRead = students;
    }

    public static ArrayList<AdministrativeStaff> getAdministrativeStaffs() {
        return administrativeStaffsWrite;
    }

    public static void setAdministrativeStaffs(ArrayList<AdministrativeStaff> administrativeStaffs) {
        administrativeStaffsRead = administrativeStaffs;
    }

    public static ArrayList<Module> getModules() {
        return modulesWrite;
    }

    public static void setModules(ArrayList<Module> modules) {
        modulesRead = modules;
    }

    public static ArrayList<Integer> getLecturerCountWrite() {
        return lecturerCountWrite;
    }

    public static ArrayList<Integer> getStaffCountWrite() {
        return staffCountWrite;
    }

    public static ArrayList<Integer> getStudentCountWrite() {
        return studentCountWrite;
    }

    public static void setStudentCountRead(ArrayList<Integer> studentCountRead) {
        Data.studentCountRead = studentCountRead;
    }

    public static void setLecturerCountRead(ArrayList<Integer> lecturerCountRead) {
        Data.lecturerCountRead = lecturerCountRead;
    }

    public static void setStaffCountRead(ArrayList<Integer> staffCountRead) {
        Data.staffCountRead = staffCountRead;
    }

    public static void writeStudent() throws IOException {
        FileOutputStream fos = new FileOutputStream("studentData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getStudents());
        oos.close();
    }

    public static void readStudent() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("studentData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
        setStudents(students);
        ois.close();
    }

    public static void writeLecturer() throws IOException {
        FileOutputStream fos = new FileOutputStream("lecturerData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getLecturers());
        oos.close();
    }

    public static void readLecturer() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("lecturerData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Lecturer> lecturers = (ArrayList<Lecturer>) ois.readObject();
        setLecturers(lecturers);
        ois.close();
    }

    public static void writeStaff() throws IOException {
        FileOutputStream fos = new FileOutputStream("staffData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getAdministrativeStaffs());
        oos.close();
    }

    public static void readStaff() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("staffData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<AdministrativeStaff> administrativeStaffs = (ArrayList<AdministrativeStaff>) ois.readObject();
        setAdministrativeStaffs(administrativeStaffs);
        ois.close();
    }

    public static void writeModule() throws IOException {
        FileOutputStream fos = new FileOutputStream("moduleData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getModules());
        oos.close();
    }

    public static void readModule() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("moduleData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Module> modules = (ArrayList<Module>) ois.readObject();
        setModules(modules);
        ois.close();
    }

    public static void writeStudentCount() throws IOException {
        FileOutputStream fos = new FileOutputStream("moduleData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getStudentCountWrite());
        oos.close();
    }

    public static void readStudentCount() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("moduleData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Integer> studentCount = (ArrayList<Integer>) ois.readObject();
        setStudentCountRead(studentCount);
        ois.close();
    }

    public static void writeLecturerCount() throws IOException {
        FileOutputStream fos = new FileOutputStream("moduleData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getLecturerCountWrite());
        oos.close();
    }

    public static void readLecturerCount() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("moduleData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Integer> lecturerCount = (ArrayList<Integer>) ois.readObject();
        setLecturerCountRead(lecturerCount);
        ois.close();
    }

    public static void writeStaffCount() throws IOException {
        FileOutputStream fos = new FileOutputStream("moduleData.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(getStaffCountWrite());
        oos.close();
    }

    public static void readStaffCount() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("moduleData.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Integer> staffCount = (ArrayList<Integer>) ois.readObject();
        setStaffCountRead(staffCount);
        ois.close();
    }
}
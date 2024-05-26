import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    private static ArrayList<Student> students;

    public static void main(String[] args) {

        take_no_of_students();

        calculate_grades();


    }

    /*
    This method takes the no of students required to calculate grades of students
     */
    public static void take_no_of_students() {

        students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students: ");

        int noOfStudents = 0;

        try {

            noOfStudents = scanner.nextInt();

        } catch (Exception e) {

            System.out.println("Should be in numbers only");

            take_no_of_students();
        }

        for (int i = 0; i < noOfStudents; i++) {

            String studentName = take_studentName();

            System.out.println(studentName);

            int studentMarks = take_studentMarks(studentName);

            Student student = new Student(studentName, studentMarks);

            students.add(student);
        }
    }

/*
This method helps to take student name from the user
 */
    public static String take_studentName() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name: ");

        String studentName = null;

        try {

            studentName = scanner.nextLine();

            if (studentName.matches("^[a-zA-Z]{1,}")) {

                return studentName;
            }
            throw new RuntimeException();

        } catch (Exception e) {

            System.out.println("Student name should be in alphabets and cannot be empty");

            studentName = take_studentName();

        }

        return studentName;
    }

    /*
    This method helps to take student marks from the user
     */
    public static int take_studentMarks(String studentName) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter " + studentName + " marks: ");

        int marks = 0;

        try {
            marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                throw new RuntimeException();
            }

        } catch (Exception e) {
            System.out.println("marks should be in numbers, cannot be empty and between 0 and 100 only");

            marks = take_studentMarks(studentName);
        }

        return marks;

    }


    /*
    This method helps calculate the highest, lowest and average scores
     */
    public static void calculate_grades() {

        Student topper = students.get(0);

        Student duller = students.get(0);

        double avgMarks = 0;

        for (Student student : students) {

            if (student.getMarks() > topper.getMarks()) {

                topper = student;
            }

            if (student.getMarks() < duller.getMarks()) {
                duller = student;
            }

            avgMarks += student.getMarks();

        }

        System.out.println();
        System.out.println("Highest grade scored by " + topper.getName() + " with score " + topper.getMarks());
        System.out.println();
        System.out.println("Lowest grade scored by " + duller.getName() + " with score " + duller.getMarks());
        System.out.println();
        System.out.println("Average grade: " + avgMarks / students.size());
    }


}

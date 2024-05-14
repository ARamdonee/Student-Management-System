import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int inputByUser;

        //starting the program in a do while loop
        do {
            System.out.println("Warm Welcome");
            System.out.println();
            System.out.println("How can I help you?");
            System.out.println("1. Add new course" +
                    "\n2. Add new student" +
                    "\n3. Enroll students" +
                    "\n4. Assign Grade" +
                    "\n5. Calculate overall grade" +
                    "\n6. To end");
            inputByUser = userInput();
            choiceByUser(inputByUser);

        }while (inputByUser != 6);

    }

    //input validation
    public static int userInput(){
        int userInput = 0;
        Scanner UserInput = new Scanner(System.in);
        try {
            System.out.println("Please enter a number from 1 to 5 to choose");
            userInput = UserInput.nextInt();

        }catch (java.util.InputMismatchException error){
            System.out.println("Invalid number entered!");
            UserInput.nextLine();

        }
        return userInput;
    }

    //switch case for the action the user wish to perform

    public static void choiceByUser(int inputByUser){
        switch (inputByUser) {
            case 1: {
                System.out.println("you chose to add new course");
                Scanner courseObject = new Scanner(System.in);
                System.out.println("PLease enter the course code");
                String courseCode = courseObject.nextLine();
                System.out.println("PLease enter the course name");
                String courseName = courseObject.nextLine();
                System.out.println("Please enter the maximum available seats");
                int maxNumSeats = courseObject.nextInt();
                Course course = new Course(courseCode, courseName, maxNumSeats);
                courseList.courseList.addLast(course);
                System.out.println("The course was successfully added");
            }
                break;
            case 2: {
                System.out.println("you chose to add a student");
                Scanner studentObject = new Scanner(System.in);
                System.out.println("PLease enter the student's ID");
                String studentID = studentObject.nextLine();
                System.out.println("PLease enter the student's name");
                String studentName = studentObject.nextLine();
                System.out.println("Please enter the student's surname");
                String studentSurname = studentObject.nextLine();
                Student student = new Student(studentName, studentSurname, studentID);
                StudentList.studentDetails.addLast(student);
                System.out.println("The student was successfully added");
            }
                break;
            //to enrol student
            //look if the student is enrolled in one course and add new course to it with default grade = 0
            // if not
            // create a new studentCourseGrade instance
            // create a new studentCourseObj (student studentDetails, StudentCourseGrade courseGradeList) instance
            //add the new instance to the arraylist studentCourseList
            case 3: {
                final double defaultGrade = 0.0;
                System.out.println("you chose to enroll a student to a course");
                Scanner StudentCourseObj = new Scanner(System.in);
                System.out.println("Please enter the student's ID");
                String StudentID = StudentCourseObj.nextLine();
                System.out.println("Please enter the course code");
                String CourseCode = StudentCourseObj.nextLine();
                boolean studentFound = false;
                for (studentCourseObj object : studentCourseObj.studentCourseList) {
                    Student studentObjCase3 = object.getStudentDetails();
                    String studentIDCase3 = studentObjCase3.getStudentID();
                    if (StudentID.equals(studentIDCase3)) {
                        studentFound = true;
                        //iterate over the arrayList of course list
                        //retrieve the course details
                        // create a new studentCourseGrade obj
                        //add it to arrayList in the student object
                        for (Course objectCase3 : courseList.courseList) {
                            String courseCodeCase3 = objectCase3.getCourseCode();
                            if (CourseCode.equals(courseCodeCase3)) {
                                if (studentCourseObj.numberOfSeats(courseCodeCase3) > 0) {
                                    StudentCourseGrade studentCourseGrade = new StudentCourseGrade(objectCase3, defaultGrade);
                                    //update the arrayList inside the studentCourseObj
                                    object.setCourseGradeList(studentCourseGrade);
                                    System.out.println("The enrollment was successful");
                                }else {
                                    System.out.println("The maximum capacity have been reached");
                                }

                            } else {
                                System.out.println("The course code is not valid");

                            }
                            break;
                        }
                    }
                }
                if (!studentFound) {
                    System.out.println("The student is not enrolled in any course" +
                            "\n The student is being added to the enrolment list");
                    //a new object to be created
                    for (Student InStudentList : StudentList.studentDetails) {
                        if (StudentID.equals(InStudentList.getStudentID())) {
                            for (Course InCourseList : courseList.courseList) {
                                if (CourseCode.equals(InCourseList.getCourseCode())) {
                                    StudentCourseGrade studentCourseGrade = new StudentCourseGrade(InCourseList, defaultGrade);
                                    ArrayList<StudentCourseGrade> studentCourseGradesArray = new ArrayList<>();
                                    studentCourseGradesArray.addLast(studentCourseGrade);
                                    studentCourseObj studentCourseObj = new studentCourseObj(InStudentList, studentCourseGradesArray);
                                    System.out.println("The student has added to the list and was successfully enrolled");
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            break;
            case 4: {

                System.out.println("you chose to assign grade");
                Scanner StudentCourseObj = new Scanner(System.in);
                System.out.println("Please enter the student's ID");
                String StudentID = StudentCourseObj.nextLine();
                System.out.println("Please enter the course code");
                String CourseCode = StudentCourseObj.nextLine();
                try{
                System.out.println("Enter the grade for the course");
                    String gradeTest = StudentCourseObj.nextLine();
                    double grade = Double.parseDouble(gradeTest);
                    Student.gradeAssignment(StudentID, CourseCode, grade);
                }catch (NumberFormatException error){
                    System.out.println("Invalid input for grade");
                }catch (Exception error){
                    System.out.println("An error occurred :" + error.getMessage());
                }
            }



                break;
            case 5: {
                System.out.println("you chose to calculate grade");
                Scanner StudentCourseObj = new Scanner(System.in);
                System.out.println("Please enter the student's ID");
                String StudentID = StudentCourseObj.nextLine();
                studentCourseObj.averageGrade(StudentID);
            }

                break;
            case 6:
                System.out.println("Ending program");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                break;
        }
    }

}
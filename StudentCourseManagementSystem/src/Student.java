import java.util.ArrayList;

public class Student {

    private String studentName;
    private String studentSurname;
    private String studentID;

    public Student(String studentName, String studentSurname, String studentID) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentID = studentID;

    }

    //getter methods


    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentID() {
        return studentID;
    }
    //setter method -> to edit details if needed


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /*
    public void updateCourseEnrolled(String ID, String courseCode, double grade) {
        for (Course elements : courseList.courseList) {
            String courseID = elements.getCourseCode();
            //check for capacity
            int capacity = elements.getMaximumCapacity();
            int seatOccupied = studentCourseObj.numberOfSeats(courseCode);
            if (capacity - seatOccupied > 0) {
                if (courseCode.equals(courseID)) {
                    StudentCourseGrade studentCourseGrade = new StudentCourseGrade(elements, grade);
                    for (studentCourseObj element : studentCourseObj.studentCourseList) {
                        Student studentDetails = element.getStudentDetails();
                        String studentIDSearch = studentDetails.getStudentID();
                        if (ID.equals(studentIDSearch)) {
                            studentCourseObj.CourseGradeList.add(studentCourseGrade);
                        } else {
                            System.out.println("The student ID was found! Please make a new entry for the student");
                        }
                    }

                } else {
                    System.out.println("The course was not found! check if the course is registered");
                }
            } else {
                System.out.println("No more seats available!");
            }

        }
    }

     */


    public static void gradeAssignment(String StudentID, String CourseCode, double studentGrade) {
        for (studentCourseObj element : studentCourseObj.studentCourseList) {
            Student studentDetails = element.getStudentDetails();
            String studentIDSearch = studentDetails.getStudentID();
            if (StudentID.equals(studentIDSearch)) {
                ArrayList<StudentCourseGrade> CourseGradeList = element.getCourseGradeList();
                for (StudentCourseGrade courseElement:CourseGradeList){
                    Course courseDetails = courseElement.getCourseDetails();
                    String coursecode = courseDetails.getCourseCode();
                    if (coursecode.equals(CourseCode)){
                        courseElement.setStudentGrade(studentGrade);
                        System.out.println("The student grade was update to: " + courseElement.getStudentGrade());
                        break;
                    }else {
                        System.out.println("The course code was not found!");
                    break;}
                }

            }else {
                System.out.println("The student ID was not found!");
                break;
            }
        }

    }
}


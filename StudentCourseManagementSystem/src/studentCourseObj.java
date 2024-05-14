import java.util.ArrayList;

public class studentCourseObj {

    private Student studentDetails;
    //private StudentCourseGrade courseEnrolled;

    //each time a studentCourseObj is created the totalEnrollment will be incremented
    public static int totalEnrollment = 0;
    //arrayList to store the list of course enrolled and the grade
   private ArrayList<StudentCourseGrade> CourseGradeList = new ArrayList<>();

    //test
    //public static ArrayList<StudentCourseGrade> CourseGradeList = new ArrayList<>();

    public studentCourseObj(Student studentDetails, ArrayList<StudentCourseGrade> CourseGradeList) {
        this.studentDetails = studentDetails;
        this.CourseGradeList = CourseGradeList;
        totalEnrollment++;

    }

    public Student getStudentDetails() {
        return studentDetails;
    }

    public ArrayList<StudentCourseGrade> getCourseGradeList() {
        return CourseGradeList;
    }

    //test


    //test


    //to add course to the arrayList in the studentCourseObject
    public void setCourseGradeList(StudentCourseGrade studentCourseGrade) {
        CourseGradeList.addLast(studentCourseGrade);
    }

    public void setStudentDetails(Student studentDetails) {
        this.studentDetails = studentDetails;
    }

    //to update arrayList CourseGradeList


    //public static void updateCourseGradeList(StudentCourseGrade courseEnrolled) {
       // CourseGradeList.addLast(courseEnrolled);
    //}

    public int getTotalEnrollment() {
        return totalEnrollment;
    }

    //arrayList to store the studentCourse details
   public static ArrayList<studentCourseObj> studentCourseList = new ArrayList<>();

    public void addToStudentCourseList(studentCourseObj studentCourseDetails) {
        studentCourseList.add(studentCourseDetails);
    }

    //to add course enrolment


    //calculate the average grade
    public static double averageGrade(String studentID) {
        double averageGrade = 0;
        //keep track of total grade during iteration
        double totalGrade = 0.0;
        int courseCount = 0;
        //if the ID is not found, the program will print "ID not found"
        boolean isFound = false;
        for (studentCourseObj object : studentCourseList) {
            Student studentDetails = object.getStudentDetails();
            String StudentIDSearch = studentDetails.getStudentID();
            if (studentID.equals(StudentIDSearch)) {
                ArrayList<StudentCourseGrade> courseGradeArrayList = object.getCourseGradeList();
                for (StudentCourseGrade element : courseGradeArrayList) {
                    double grade = element.getStudentGrade();
                    totalGrade += grade;
                    isFound = true;
                    courseCount++;
                    //continue to the next iteration
                }
            }


        }
        if (!isFound) {
            System.out.println("The student ID was not found");
        } else {
            averageGrade = totalGrade / courseCount;
            System.out.println("the average grade is fo the student " + studentID + " is " + averageGrade);
        }
        return averageGrade;
    }


    //method to return the amount of student enrolled in a course
    public static int numberOfSeats(String courseCode) {
        int seatcount = 0;
        for(studentCourseObj element: studentCourseList){
            ArrayList<StudentCourseGrade> CourseGradeList = element.getCourseGradeList();
            for (StudentCourseGrade courseElement : CourseGradeList){
                Course courseDetails  = courseElement.getCourseDetails();
                String coursecode = courseDetails.getCourseCode();
                if (courseCode.equals(coursecode)){
                    seatcount ++;
                }else{
                    System.out.println("No student was enrolled in the course");
                }
                System.out.println("The number of seats occupied is: "+ seatcount);


            }
        }
        for (Course element : courseList.courseList){
            int seatOccupied = element.getMaximumCapacity();
            seatcount = seatOccupied - seatcount;
            System.out.println("The number of seats left is " + seatcount);

        }
        return seatcount;
    }
}

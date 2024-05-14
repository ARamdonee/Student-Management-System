public class StudentCourseGrade {
    //to store the student grade and course inside an object
    // this object will be encapsulated inside the studentCourseObj
    private Course courseDetails;

    private double studentGrade = 0;

    public StudentCourseGrade(Course courseDetails, double studentGrade){
        this.courseDetails = courseDetails;
        this.studentGrade = studentGrade;

    }

    public Course getCourseDetails() {
        return courseDetails;
    }

    public double getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(double studentGrade) {
        this.studentGrade = studentGrade;
    }

    public void setCourseDetails(Course courseDetails) {
        this.courseDetails = courseDetails;
    }


}

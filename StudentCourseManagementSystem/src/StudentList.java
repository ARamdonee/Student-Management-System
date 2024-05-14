import java.util.ArrayList;

public class StudentList {

   public static ArrayList<Student> studentDetails = new ArrayList<>();

    public void addStudentToList (Student student){

        studentDetails.addLast(student);
    }
}

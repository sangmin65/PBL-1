import java.util.Scanner;
/**
 * Student
 *
 * @author (2022320029_이상민), (2023320023_이현회), (2023320035_윤효준)
 * @version (2026.05.14)
 */
public class Student
{
    private String studId;
    private String name;
    
    /**
     * Student 클래스의 객체 생성자
     */
    public Student(String studId, String name){
        this.studId = studId;
        this.name = name;
    }

    public String getStudId(){
        return studId;
    }
    
    public String getName(){
        return name;
    }
    
    public String getStudents(){
        return studId + " " + name;    
    }
    /**
     * registerStudent - 학생의 정보를 입력받는 메소드
     *
     * @param  String sutdId, String name   학번, 이름
     * @return student 객체.
     */
    public static Student registerStudent(Scanner sc){
        System.out.print("학번 입력 : ");
        String studId = sc.nextLine();
        
        System.out.print("이름 입력 : ");
        String name = sc.nextLine();
        
        Student student = new Student(studId, name);
        
        return student;
    }
}

import java.util.Scanner;
/**
 * Student
 *
 * @author (2022320029_이상민), (2023320023_이현회), (2023320035_윤효준), (2025320062_이진혁)
 * @version (2026.05.14)
 */
public class Student
{
    private String studId; //학생 학번
    private String name; // 학생 이름
    
    /**
     * Student 클래스의 객체 생성자
     */
    public Student(String studId, String name){
        this.studId = studId;
        this.name = name;
    }
    
    /**
     * getStudId - 학생의 학번을 반환하는 메소드
     * 
     * @return studId 학생 학번
     */
    public String getStudId(){
        return studId;
        // 학생 학번 반환
    }
    
    /**
     * getName - 학생의 이름을 반환하는 메소드
     * 
     * @return name 학생 이름
     */
    public String getName(){
        return name;
        //학생 이름 반환
    }
    
    /**
     * getStudents - 학생과 이름을 반환하는 메소드
     * 
     * @return studId + " " + name 학번과 이름
     */
    public String getStudents(){
        return studId + " " + name; 
        // 학번과 이름을 하나로 뭉쳐 반환
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
        // 학번과 이름으로 student객체 생성
        
        return student;
    }
}

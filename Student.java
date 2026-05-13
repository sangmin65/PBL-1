import java.util.Scanner;
/**
 * Student
 *
 * @author (작성자 이름)
 * @version (2026.05.10)
 */
public class Student
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String studId;
    private String name;
    
    Scanner sc = new Scanner(System.in);
    
    /**
     * Student 클래스의 객체 생성자
     */
    public Student(String studId, String name)
    {
        // 인스턴스 변수 초기화
        this.studId = studId;
        this.name = name;
    }

    public String getStudId()
    {
        return studId;
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * registerStudent - 학생의 정보를 입력받는 메소드
     *
     * @param  String sutdId, String name   학번, 이름
     * @return    학생의 학번과 이름.
     */
    public static Student registerStudent(Scanner sc)
    {
        // 여기에 코드를 작성하세요.
        System.out.print("학번 입력 : ");
        String studId = sc.next();
        
        System.out.print("이름 입력 : ");
        String name = sc.next();
        
        Student student = new Student(studId, name);
        
        return student;
    }
}
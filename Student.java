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

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public String getStudId()
    {
        return studId;
    }
    
    public String getName()
    {
        return name;
    }
    
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
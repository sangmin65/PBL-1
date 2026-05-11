import java.util.Scanner;
/**
 * Subject
 *
 * @author (작성자 이름)
 * @version (2026.05.10)
 */
public class Subject
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String subjectId;
    private String subjectName;
    private int credit;
    
    Scanner sc = new Scanner(System.in);
    
    /**
     * Subject 클래스의 객체 생성자
     */
    public Subject(String subjectId, String subjectName, int credit)
    {
        // 인스턴스 변수 초기화
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public String getSubjectId()
    {
        // 여기에 코드를 작성하세요.
        return subjectId;
    }
    
    public String getSubjectName()
    {
        // 여기에 코드를 작성하세요.
        return subjectName;
    }
    
    public int getCredit()
    {
        // 여기에 코드를 작성하세요.
        return credit;
    }
    
    public static Subject registerSubject(Scanner sc)
    {
        // 여기에 코드를 작성하세요.
        System.out.print("과목 아이디 입력 : ");
        String subjectId = sc.next();
        
        System.out.print("과목명 입력 : ");
        String subjectName = sc.next();
        
        System.out.print("이수 학점 입력 : ");
        int credit = sc.nextInt();
        
        Subject subject = new Subject(subjectId, subjectName, credit);
        
        return subject;
    }
}
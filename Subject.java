import java.util.Scanner;
/**
 * Subject 클래스 
 *
 * @author (2022320029 이상민)
 * @version (2026.05.10)
 */
public class Subject
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String subjectCode;
    private String subjectName;
    private int credit;
    
    /**
     * Subject 클래스의 객체 생성자
     */
    public Subject(String subjectCode, String subjectName, int credit){
        // 인스턴스 변수 초기화
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    public String getSubjectCode(){
        // 여기에 코드를 작성하세요.
        return subjectCode;
    }
    
    public String getSubjectName(){
        // 여기에 코드를 작성하세요.
        return subjectName;
    }
    
    public int getCredit(){
        // 여기에 코드를 작성하세요.
        return credit;
    }
    
    public String toString(){
        return subjectCode + " " + subjectName + " " + credit + "학점";
    }
    
    /**
     * registerSubject - 과목을 입력 받는 메소드
     *
     * @param  String subjectCode, String subjectName, int credit     과목 코드, 과목명, 이수학점
     * @return    x 더하기 y의 결과값을 반환
     */
    public static Subject registerSubject(Scanner sc){
        // 여기에 코드를 작성하세요.
        System.out.print("과목 아이디 입력 : ");
        String subjectCode = sc.nextLine();
        
        System.out.print("과목명 입력 : ");
        String subjectName = sc.nextLine();
        
        System.out.print("이수 학점 입력 : ");
        int credit = Integer.parseInt(sc.nextLine());
        
        Subject subject = new Subject(subjectCode, subjectName, credit);
        
        return subject;
    }
}
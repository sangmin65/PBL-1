import java.util.Scanner;
/**
 * Subject 클래스 
 *
 * @author (2022320029_이상민), (2023320023_이현회), (2023320035_윤효준), (2025320062_이진혁)
 * @version (2026.05.14)
 */
public class Subject
{
    private String subjectCode; // 과목 코드
    private String subjectName; // 과목명
    private int credit; // 이수 학점
    
    /**
     * Subject 클래스의 객체 생성자
     */
    public Subject(String subjectCode, String subjectName, int credit){
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    /**
     * getSubjectCode - 과목 코드를 반환하는 메소드
     * 
     * @return subjectCode 과목 코드
     */
    public String getSubjectCode(){
        return subjectCode;
        // 과목 코드 반환
    }
    
    /**
     * getSubjectName - 과목명을 반환하는 메소드
     * 
     * @return subjectName 과목명
     */
    public String getSubjectName(){
        return subjectName;
        // 과목명 반환
    }
    
    /**
     * getCredit 이수 학점을 반환하는 메소드
     * 
     * @return credit 이수 학점
     */
    public int getCredit(){
        return credit;
        // 이수 학점 반환
    }
    
    /**
     * getSubjects 과목 코드, 과목명, 이수학점을 반환하는 메소드
     * 
     * @return subjectCode + " " + subjectName + " " + credit + "학점"  과목 코드, 과목명, 이수학점
     */
    public String getSubjects(){
        return subjectCode + " " + subjectName + " " + credit + "학점";
        // 과목 코드, 과목명, 이수학점을 한번에 뭉쳐 반환
    }
    
    /**
     * registerSubject - 과목 정보를 입력 받는 메소드
     *
     * @param  String subjectCode, String subjectName, int credit     과목 코드, 과목명, 이수학점
     * @return subject 객체
     */
    public static Subject registerSubject(Scanner sc){
        System.out.print("과목 아이디 입력 : ");
        String subjectCode = sc.nextLine();
        
        System.out.print("과목명 입력 : ");
        String subjectName = sc.nextLine();
        
        System.out.print("이수 학점 입력 : ");
        int credit = Integer.parseInt(sc.nextLine());
        
        Subject subject = new Subject(subjectCode, subjectName, credit);
        // 과목 코드, 과목명, 이수학점으로 subject 객체 생성
        
        return subject;
    }
}

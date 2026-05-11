import java.util.Scanner;
/**
 * Grade 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (2026.05.10)
 */
public class Grade
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private Student student;
    private Subject subject;
    private int attendance;
    private int middleExam;
    private int assignment;
    private int finalExam;
    private double totalScore;
    private GradeLetter letter;

    Scanner sc = new Scanner(System.in);

    /**
     * Grade 클래스의 객체 생성자
     */
    public Grade(Student student, Subject subject, int attendance, int middleExam, 
    int assignment, int finalExam)
    {
        // 인스턴스 변수 초기화
        this.student = student;
        this.subject = subject;
        this.attendance = attendance;
        this.middleExam = middleExam;
        this.assignment = assignment;
        this.finalExam = finalExam;
        this.totalScore = calculateTotal();
        this.letter = null;
    }
    
    public int getMiddleExam()
    {
        // 여기에 코드를 작성하세요
        return middleExam;
    }
    
    public int getFinalExam()
    {
        // 여기에 코드를 작성하세요
        return finalExam;
    }
    
    public int getAssignment()
    {
        // 여기에 코드를 작성하세요
        return assignment;
    }
    public int getAttendance()
    {
        // 여기에 코드를 작성하세요
        return attendance;
    }
    public double getTotalScore()
    {
        // 여기에 코드를 작성하세요
        return totalScore;
    }
    /**
     * calculateTotal 메소드 - 총점을 계산해주는 메소드
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public double calculateTotal()
    {
        // 여기에 코드를 작성하세요.
        totalScore = attendance + middleExam + assignment + finalExam;
        return totalScore;
    }

    public GradeLetter calculateLetter()
    {
        // 여기에 코드를 작성하세요.
        return letter;
    }

    public static Grade registerGrade(Scanner sc, Student student, Subject subject)
    {
        // 여기에 코드를 작성하세요.
        System.out.print("출석 점수 입력 : ");
        int attendance = sc.nextInt();

        System.out.print("과제 점수 입력 : ");
        int assignment = sc.nextInt();

        System.out.print("중간 점수 입력 : ");
        int middleExam = sc.nextInt();

        System.out.print("기말 점수 입력 : ");
        int finalExam = sc.nextInt();

        Grade grade = new Grade(student, subject, attendance, middleExam, assignment, finalExam);

        return grade;
    }
}
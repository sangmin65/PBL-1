import java.util.Scanner;
/**
 * GradeManage 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class GradeManage
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private Student[] students;
    private Subject[] subjects;
    private Grade[][] grades;
    private int studentCount;
    private int subjectCount;

    /**
     * GrandManage 클래스의 객체 생성자
     */
    public GradeManage()
    {
        // 인스턴스 변수 초기화
        this.students = new Student[100];
        this.subjects = new Subject[100];
        this.grades = new Grade[100][100];
        this.studentCount = 0;
        this.subjectCount = 0;
    }
    
    public Grade[][] getGrades()
    {
        // 여기에 코드를 작성하세요.
        return grades;
    }
    
    public Student[] getStudents()
    {
        // 여기에 코드를 작성하세요.
        return students;
    }
    
    public Subject[] getSubject()
    {
        // 여기에 코드를 작성하세요.
        return subjects;
    }
    
    public void registerStudent(Scanner sc)
    {
        // 여기에 코드를 작성하세요.
        Student student = Student.registerStudent(sc);
        for(int i = 0; i < students.length; i++){
            students[i] = student;
        }
    }
    
    public void registerSubject(Scanner sc)
    {
        // 여기에 코드를 작성하세요.
        Subject subject = Subject.registerSubject(sc);
        for(int i = 0; i < subjects.length; i++){
            subjects[i] = subject;
        }
    }
    
    public void registerGrade(Scanner sc)
    {
        // 여기에 코드를 작성하세요.
        Grade grade = Grade.registerGrade(sc);
    }

}
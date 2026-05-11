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


    Scanner sc = new Scanner(System.in);

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
        this.studentCount = 0;
        this.subjectCount = 0;
    }

    public int getStudentCount()
    {
        // 여기에 코드를 작성하세요.
        return studentCount;
    }
    
    public int getSubjectCount()
    {
        // 여기에 코드를 작성하세요.
        return subjectCount;
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
    
    public void addStudent(Student student)
    {
        // 여기에 코드를 작성하세요.
        students[studentCount] = student;
        studentCount++;
    }

    public void addSubject(Subject subject)
    {
        // 여기에 코드를 작성하세요.
        subjects[subjectCount] = subject;
        subjectCount++;
    }

    public void inputGrade(Scanner sc)
    {
        // 여기에 코드를 작성하세요.

        System.out.print("학생 학번 입력 : ");
        int studId = sc.nextInt();
        int studentIndex = -1;
        
        for(int i = 0; i < studentCount; i++){
            if(students[i].getStudId().equals(studId)){
                studentIndex = i;
            }
        }
        
        System.out.print("과목 코드 입력 : ");
        int subjectCode = sc.nextInt() - 1;
        int subjectIndex = -1;
        
        for(int i = 0; i < subjectCount; i++){
            if(subjects[i].getSubjectCode().equals(subjectCode)){
                subjectIndex = i;
            }
        }
        
        Grade grade = Grade.registerGrade(sc, students[studentIndex], subjects[subjectIndex]);
        grades[studentIndex][subjectIndex] = grade;
        System.out.println("성적 등록 완료");
    }
}
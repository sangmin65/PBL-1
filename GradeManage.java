import java.util.Scanner;
/**
 * GradeManage 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */

public class GradeManage {

    private Student[] students;
    private Subject[] subjects;
    private Grade[][] grades;
    private int studentCount;
    private int subjectCount;

    public GradeManage() {
        this.students     = new Student[100];
        this.subjects     = new Subject[100];
        this.grades       = new Grade[100][100];
        this.studentCount = 0;
        this.subjectCount = 0;
    }
    
    public Grade[][] getAllGrades(){
        return grades; 
    }
    
    public Student[] getStudents(){
        return students;
    }
    
    public Subject[] getSubjects(){
        return subjects;
    }
    
    public int getStudentCount() {
        return studentCount; 
    }
    
    public int getSubjectCount() {
        return subjectCount; 
    }

    public void registerStudent(Scanner sc) {
        students[studentCount++] = Student.registerStudent(sc);
        System.out.println("  학생 등록 완료.");
    }

    public void registerSubject(Scanner sc) {
        subjects[subjectCount++] = Subject.registerSubject(sc);
        System.out.println("  과목 등록 완료.");
    }

    public void registerGrade(Scanner sc) {
        // 학번으로 학생 검색
        int sIdx = -1;
        while (true) {
            System.out.print("학번 입력: ");
            String inputId = sc.nextLine().trim();
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getStudId().equals(inputId)) {
                    sIdx = i;
                    break;
                }
            }
            if (sIdx != -1) break;
            System.out.println("  등록되지 않은 학번입니다.");
        }

        // 과목 목록 출력 후 번호로 선택
        System.out.println("[ 과목 목록 ]");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("  " + i + ": " + subjects[i].toString());
        }
        int subIdx = -1;
        while (true) {
            System.out.print("과목 번호 선택: ");
            try {
                subIdx = Integer.parseInt(sc.nextLine().trim());
                if (subIdx >= 0 && subIdx < subjectCount) break;
                System.out.println("  올바른 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("  숫자를 입력해주세요.");
            }
        }

        grades[sIdx][subIdx] = Grade.registerGrade(sc, students[sIdx], subjects[subIdx]);
        System.out.println("  성적 등록 완료.");
    }
}
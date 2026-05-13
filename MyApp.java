import java.util.Scanner;
/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (2022320029_이상민)
 * @version (2026.05.11)
 */
public class MyApp
{
    public static Grade[][] grades = new Grade[20000][20000];
    public static Subject[] subjects = new Subject[20000];
    public static Student[] students = new Student[20000];
    private int studentCount = 0;
    private int subjectCount = 0;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. 학생 등록");
            System.out.println("2. 과목 등록");
            System.out.println("3. 성적 입력");
            System.out.println("4. 성적 출력");
            System.out.println("0. 종료");
            System.out.println("숫자를 입력해주세요.");
            int menu = sc.nextInt();

            switch(menu){
                case 1:
                    Student.registerStudent(sc);
                    break;
                case 2:
                    Subject.registerSubject(sc);
                    break;
                case 3:
                    Grade.registerGrade(sc, studId, subjectCode);
                    break;
                case 4:
                    Grade.calculateRelativeGrade();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;

                    
            }
        }
    }
}
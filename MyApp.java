import java.util.Scanner;
/**
 * MyApp 클래스의 설명을 작성하세요.
 *
 * @author (2022320029_이상민)
 * @version (2026.05.11)
 */
public class MyApp
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GradeManage manage = new GradeManage();
        
        int choice = -1;
        
        do {
            System.out.println("1. 학생 등록");
            System.out.println("2. 과목 등록");
            System.out.println("3. 성적 입력");
            System.out.println("4. 성적 출력");
            System.out.println("0. 종료");
            
            try{
                choice = Integer.parseInt(sc.nextLine().trim());
            }
            catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
            }
            
            switch (choice){
                case 1:
                    manage.registerStudent(sc);
                    break;
                case 2:
                    manage.registerSubject(sc);
                    break;
                case 3:
                    manage.registerGrade(sc);
                    break;
                case 4:
                    GradeCalculator.calculateRelativeAllGrades(
                    manage.getAllGrades(),
                    manage.getSubject(),
                    manage.getStudentCount(),
                    manage.getSubjectCount()
                    );
                    Print.printAllGrades(
                    manage.getAllGrades(),
                    manage.getStudents(),
                    manage.getSubject(),
                    manage.getStudentCount(),
                    manage.getSubjectCount()
                    );
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                defalut:
                    System.out.println("올바른 번호를 입력해주세요.");
            }
        }
        while (choice != 0);
        sc.close();
    }
}
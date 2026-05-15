import java.util.Scanner;
/**
 * MyApp
 *
 * @author (2022320029_이상민), (2023320023_이현회), (2023320035_윤효준)
 * @version (2026.05.14)
 */
public class MyApp
{
    public static Grade[][] grades = new Grade[20000][1000];
    public static Subject[] subjects = new Subject[1000];
    public static Student[] students = new Student[20000];
    public static int studentCount = 0;
    public static int subjectCount = 0;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int menu = -1;
        do{
            System.out.println("1. 학생 등록");
            System.out.println("2. 과목 등록");
            System.out.println("3. 성적 입력");
            System.out.println("4. 성적 출력");
            System.out.println("0. 종료");
            System.out.println("숫자를 입력해주세요.");
            
            try{
                menu = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
                menu = -1;
            }

            switch(menu){
                case 1:
                    students[studentCount] = Student.registerStudent(sc);
                    studentCount++;
                    System.out.println("학생 등록 완료.");
                    break;
                case 2:
                    subjects[subjectCount] = Subject.registerSubject(sc);
                    subjectCount++;
                    System.out.println("과목 등록 완료.");
                    break;
                case 3:
                    Grade.registerGrade(sc, studentCount, subjectCount, students, subjects, grades);
                    break;
                case 4:
                    Grade.calculateRelativeGrade(grades, subjects, studentCount, subjectCount);
                    printAllGrades();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("올바른 번호를 입력해주세요.");
            }
        } while (menu != 0);
        
        sc.close();
    }
    
    private static void printAllGrades(){
        printHeader();
        for(int i = 0; i < studentCount; i++){
            printRow(i);
        }
    }
    
    private static void printHeader(){
        String header = String.format("%-15s %-10s", "학번", "이름");
        for (int i = 0; i < subjectCount; i++){
            header = header + subjects[i].getSubjectName() + " ";
        }
        System.out.println(header);
    }
    
    private static void printRow(int studentIndex){
        String row = String.format("%-15s %-10s", students[studentIndex].getStudId(), students[studentIndex].getName());
        
        for (int j = 0; j < subjectCount; j++){
            if(grades[studentIndex][j] != null){
                String cell = (int) grades[studentIndex][j].getTotalScore() + "(" + grades[studentIndex][j].calculateLetter() + ") ";
                row = row + String.format("%-15s", cell);
            }
            else{
                row = row + String.format("%-15s", "-");
            }
        }
        System.out.println(row);
    }
}

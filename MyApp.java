import java.util.Scanner;
/**
 * MyApp
 *
 * @author (2022320029_이상민), (2023320023_이현회), (2023320035_윤효준), (2025320062_이진혁)
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
                // 숫자를 입력하지 않을 경우
            }

            switch(menu){
                case 1:
                    students[studentCount] = Student.registerStudent(sc);
                    // 학생 정보를 받아 students배열에 저장
                    studentCount++;
                    System.out.println("학생 등록 완료.");
                    break;
                case 2:
                    subjects[subjectCount] = Subject.registerSubject(sc);
                    // 과목 정보를 받아 subjects배열에 저장
                    subjectCount++;
                    System.out.println("과목 등록 완료.");
                    break;
                case 3:
                    Grade.registerGrade(sc, studentCount, subjectCount, students, subjects, grades);
                    // 등록되어있는 학생과 과목을 선택하여 성적을 받아 저장
                    break;
                case 4:
                    for(int j = 0; j < subjectCount ; j++){
                    Grade.calculateRelativeGrade(grades, subjects, studentCount, j);
                    // 과목의 등급을 계산
                }
                    // 전체 학생의 성적들을 출력
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
            // 모든 학생의 성적을 출력
        }
    }
    
    private static void printHeader(){
        String header = String.format("%-15s %-10s", "학번", "이름");
        for (int i = 0; i < subjectCount; i++){
            header = header + String.format("%-15s", subjects[i].getSubjectName());
            // 모든 과목명을 header에 추가
        }
        System.out.println(header);
    }
    
    private static void printRow(int studentIndex){
        String row = String.format("%-15s %-10s", students[studentIndex].getStudId(), students[studentIndex].getName());
        // row에 학생 정보 저장
        for (int j = 0; j < subjectCount; j++){
            if(grades[studentIndex][j] != null){
                String cell = (int) grades[studentIndex][j].getTotalScore() + "(" + grades[studentIndex][j].calculateLetter() + ") ";
                row = row + String.format("%-15s", cell);
                // 해당과목의 성적이 존재할 시 row에 해당 과목의 성적의 총점과 등급 추가
            }
            else{
                row = row + String.format("%-15s", "-");
                // 해당과목의 성적이 존재하지 않을 시 row에 "-" 추가
            }
        }
        System.out.println(row);
    }
}

import java.util.Scanner;
/**
 * Grade 클래스의 설명을 작성하세요.
 *
 * @author (2022320029_이상민), (2023320023_이현회), (2023320035_윤효준)
 * @version (2026.05.14)
 */
public class Grade
{
    public static final String A_Plus = "A+";
    public static final String A_Zero = "A0";
    public static final String B_Plus = "B+";
    public static final String B_Zero = "B0";
    public static final String C_Plus = "C+";
    public static final String C_Zero = "C0";
    public static final String D_Plus = "D+";
    public static final String D_Zero = "D0";
    
    private Student student;
    private Subject subject;
    private int attendance;
    private int middleExam;
    private int assignment;
    private int finalExam;
    private double totalScore;
    private String letter;

    /**
     * Grade 클래스의 객체 생성자
     */
    public Grade(Student student, Subject subject, int attendance, int middleExam, 
    int assignment, int finalExam)
    {
        this.student = student;
        this.subject = subject;
        this.attendance = attendance;
        this.middleExam = middleExam;
        this.assignment = assignment;
        this.finalExam = finalExam;
        this.totalScore = calculateTotal();
        this.letter = null;
    }
    
    public void setLetter(String letter){
        this.letter = letter;
    }

    public int getMiddleExam(){
        return middleExam;
    }
    
    public int getFinalExam(){
        return finalExam;
    }
    
    public int getAssignment(){
        return assignment;
    }
    
    public int getAttendance(){
        return attendance;
    }
    
    public double getTotalScore(){
        return totalScore;
    }

    public double calculateTotal(){
        totalScore = attendance + middleExam + assignment + finalExam;
        return totalScore;
    }

    public String calculateLetter(){

        if(letter != null){
            return letter;   
        }
        else{
            return "미산출";
        }
    }
    
    /**
     * inputGrade - 학생 한 과목의 성적을 입력하는 메소드
     *
     * @param  int attendace, int assigment, int middleExam, int fianlExam     출석 점수, 과제 점수, 중간 점수, 기말 점수 
     *           
     * @return 성적 반환.         
     */
    public static Grade inputGrade(Scanner sc, Student student, Subject subject){
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
    
    /**
     * register - 등급을 계산해주는 메소드
     *
     * @param  int studentCount, int subjectCount, Student students[], Subject subjects[], Grade grades[][]
     *         학생 수, 과목 수, 학생 배열, 과목 배열, 성적 배열
     *         
     * 
     */
    public static void registerGrade(Scanner sc, int studentCount, int subjectCount, Student students[], Subject subjects[], Grade grades[][]) {
        int studentIndex = -1;
        while (true) {
            System.out.print("학번 입력: ");
            String inputId = sc.nextLine().trim();
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getStudId().equals(inputId)) {
                    studentIndex = i;
                    break;
                }
            }
            if (studentIndex != -1)
            break;
            System.out.println("등록되지 않은 학번입니다.");
        }

        System.out.println("[ 과목 목록 ]");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("  " + i + ": " + subjects[i].toString());
        }
        int subjectIndex = -1;
        while (true) {
            System.out.print("과목 번호 선택: ");
            try {
                subjectIndex = Integer.parseInt(sc.nextLine().trim());
                if (subjectIndex >= 0 && subjectIndex < subjectCount) break;
                System.out.println("올바른 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }

        grades [studentIndex][subjectIndex] = Grade.inputGrade(sc, students[studentIndex], subjects[subjectIndex]);
        System.out.println("성적 등록 완료.");
    }
    
    /**
     * claculateRelativeGrade - 등급을 계산해주는 메소드
     *
     * @param  Grade[][] grades, Subject[] subjects, int studentCount, int subjectIndex   성적 배열, 과목 배열, 학생 수, 과목배열 인덱스값.
     *           
     * 
     */
    public static void calculateRelativeGrade(Grade[][] grades, Subject[] subjects, int studentCount, int subjectIndex){
        int count = 0;

        for(int i = 0 ; i < studentCount; i++){
            if(grades[i][subjectIndex] != null){
                count++;
            }
        }
        int[] indexArray = new int[count];
        int position = 0;

        for(int i = 0; i < studentCount; i++){
            if(grades[i][subjectIndex] != null){
                indexArray[position++] = i;
            }
        }

        for(int i = 0; i < count; i++){
            double myScore = grades[indexArray[i]][subjectIndex].getTotalScore();
            int rank = 1;
            for(int j = 0; j < count; j++){
                if(i != j){
                    if(grades[indexArray[j]][subjectIndex].getTotalScore() > myScore){
                        rank++;
                    }
                }
            }
            double ratio = (double)rank/count;
            String letter;
            if(ratio <= 0.175){
                letter = A_Plus;
            }
            else if(ratio <= 0.35){
                letter = A_Zero;
            }
            else if(ratio <= 0.525){
                letter = B_Plus;
            }
            else if(ratio <= 0.70){
                letter = B_Zero;
            }
            else if(ratio <= 0.76){
                letter = C_Plus;
            }
            else if(ratio <= 0.82){
                letter = C_Zero;
            }
            else if(ratio <= 0.88){
                letter = D_Plus;
            }
            else {
                letter = D_Zero;
            }
            grades[indexArray[i]][subjectIndex].setLetter(letter);
        }
    }
}

    

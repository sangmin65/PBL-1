import java.util.Scanner;
/**
 * Grade 클래스의 설명을 작성하세요.
 *
 * @author (2022320029_이상민), (2023320023_이현회), (2023320035_윤효준), (2025320062_이진혁)
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
    
    private Student student; // 성적 받을 학생 정보
    private Subject subject; // 성적 받을 과목 정보
    private int attendance; // 출석 점수
    private int middleExam; // 중간고사 점수
    private int assignment; // 과제 점수
    private int finalExam; // 기말 점수
    private double totalScore; // 출석, 중간고사, 과제, 기말고사 점수들을 합친 총점
    private String letter; // 등급

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
    
    /**
     * setLetter - 등급을 반환하는 메소드
     * 
     * @return letter 등급
     */
    public void setLetter(String letter){
        this.letter = letter;
        // 등급 반환
    }
    
    /**
     * getMiddleExam - 중간고사 점수를 반환하는 메소드
     * 
     * @return middleExam 중간고사 점수
     */
    public int getMiddleExam(){
        return middleExam;
        // 중간고사 점수 반환
    }
    
    /**
     * getFinnalExam - 기말고사 점수를 반환하는 메소드
     * 
     * @return finalExam 기말고사 점수
     */
    public int getFinalExam(){
        return finalExam;
        // 기말고사 점수 반환
    }
    
    /**
     * getAssignment - 과제 점수를 반환하는 메소드
     * 
     * @return assignment 과제 점수
     */
    public int getAssignment(){
        return assignment;
        // 과제 점수 반환
    }
    
    /**
     * getAttendance - 출석 점수를 반환하는 메소드
     * 
     * @return attendance 출석 점수
     */
    public int getAttendance(){
        return attendance;
        // 출석 점수 반환
    }
    
    /**
     * getTotalScore - 총점을 반환하는 메소드
     * 
     * @return totalScore 총점
     */
    public double getTotalScore(){
        return totalScore;
        // 총점 반환
    }

    /**
     * calculateTotal - 출석, 중간고사, 과제, 기말고사를 합산하여 계산 후 총점을 반환하는 메소드
     * 
     * @return totalScore 총점
     */
    public double calculateTotal(){
        totalScore = attendance + middleExam + assignment + finalExam;
        // 총점을 계산 후 반환
        return totalScore;
    }
    
    /**
     * calculateLetter - 계산된 성적의 등급을 반환하는 메소드
     * 
     * @return letter 등급, "미산출"
     */
    public String calculateLetter(){

        if(letter != null){
            return letter;   
        }
        else{
            return "미산출";
        }
        // 성적의 등급이 계산되어 있다면 그 등급을 반환하고 아니라면 "미산출"을 반환
    }
    
    /**
     * inputGrade - 학생 한 과목의 성적 정보를 입력하는 메소드
     *
     * @param  int attendace, int assigment, int middleExam, int fianlExam     출석 점수, 과제 점수, 중간 점수, 기말 점수 
     *           
     * @return grade 객체 반환.         
     */
    public static Grade inputGrade(Scanner sc, Student student, Subject subject){
        System.out.print("출석 점수: ");
        int attendance = Integer.parseInt(sc.nextLine());

        System.out.print("과제 점수: ");
        int assignment = Integer.parseInt(sc.nextLine());

        System.out.print("중간 점수: ");
        int middleExam = Integer.parseInt(sc.nextLine());

        System.out.print("기말 점수: ");
        int finalExam = Integer.parseInt(sc.nextLine());

        Grade grade = new Grade(student, subject, attendance, middleExam, assignment, finalExam);
        // 입력받은 학생정보, 과목정보, 점수들로 Grade객체 생성
        
        return grade;
    }
    
    /**
     * registerGrade - 한 학생의 과목에 대한 성적을 성적 배열에 등록해주는 메소드
     *
     * @param  int studentCount, int subjectCount, Student students[], Subject subjects[], Grade grades[][]
     *         학생 수, 과목 수, 학생 배열, 과목 배열, 성적 배열
     *         
     * 
     */
    public static void registerGrade(Scanner sc, int studentCount, int subjectCount, Student students[], Subject subjects[], Grade grades[][]) {
        System.out.println("[ 학생 목록 ]");
        for (int i = 0; i < studentCount; i++){
            System.out.println(" " + i + ": " + students[i].getStudents());
            // 등록된 학생목록을 출력
        }
        int studentIndex = -1;
        while (true) {
            System.out.print("학생 번호 선택: ");
            try {
                studentIndex = Integer.parseInt(sc.nextLine().trim());
                if (studentIndex >= 0 && studentIndex < studentCount) 
                break;
                System.out.println("올바른 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
            // 선택한 학생의 정보를 학생인덱스에 저장
            // 올바른 번호가 입력될 때 까지 반복 
        }

        System.out.println("[ 과목 목록 ]");
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("  " + i + ": " + subjects[i].getSubjects());
        }
        int subjectIndex = -1;
        while (true) {
            System.out.print("과목 번호 선택: ");
            try {
                subjectIndex = Integer.parseInt(sc.nextLine().trim());
                if (subjectIndex >= 0 && subjectIndex < subjectCount) 
                break;
                System.out.println("올바른 번호를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
            // 선택한 과목의 정보를 과목인덱스에 저장
            // 올바른 번호가 입력될 때 까지 반복 
        }

        grades [studentIndex][subjectIndex] = Grade.inputGrade(sc, students[studentIndex], subjects[subjectIndex]);
        // 선택한 학생과 과목의 위치에 성적을 저장
        System.out.println("성적 등록 완료.");
    }
    
    /**
     * claculateRelativeGrade - 성정 비율을 계산해주는 메소드
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
                // 해당과목의 성적이 있는 학생 수 구하기
            }
        }
        int[] indexArray = new int[count];
        // 수강하는 학생의 인덱스 값 수집
        int position = 0;
        // indexArray의 값 위치
        for(int i = 0; i < studentCount; i++){
            if(grades[i][subjectIndex] != null){
                indexArray[position++] = i;
                // 성적이 입력된 학생들을 indexArray에 저장
            }
        }

        for(int i = 0; i < count; i++){
            double myScore = grades[indexArray[i]][subjectIndex].getTotalScore();
            // 현재 학생의 총점
            int rank = 1;
            // 순위
            for(int j = 0; j < count; j++){
                if(i != j){
                    if(grades[indexArray[j]][subjectIndex].getTotalScore() > myScore){
                        rank++;
                        // 총점이 높은 학생이 있는지 비교 후 있다면 순위 1증가
                    }
                }
            }
            
            double ratio = (double)rank/count;
            // 비율 = 자신의 순위 / 수강하는 총 학생 수
            String letter;
            if(ratio <= 0.175){
                letter = A_Plus;
                // 비율이 0.175 이하일 시 A+
            }
            else if(ratio <= 0.35){
                letter = A_Zero;
                // 비율이 0.35 이하일 시 A+
            }
            else if(ratio <= 0.525){
                letter = B_Plus;
                // 비율이 0.525 이하일 시 B+
            }
            else if(ratio <= 0.70){
                letter = B_Zero;
                // 비율이 0.70 이하일 시 B0
            }
            else if(ratio <= 0.76){
                letter = C_Plus;
                // 비율이 0.76 이하일 시 C+
            }
            else if(ratio <= 0.82){
                letter = C_Zero;
                // 비율이 0.82 이하일 시 C0
            }
            else if(ratio <= 0.88){
                letter = D_Plus;
                // 비율이 0.88 이하일 시 D+
            }
            else {
                letter = D_Zero;
                // 비율이 0.88 초과일 시 D0
            }
            grades[indexArray[i]][subjectIndex].setLetter(letter);
            // 계산한 등급을 해당학생의 과목성적에 저장
        }
    }
}

    

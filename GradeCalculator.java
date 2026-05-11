
/**
 * GradeCalculator 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class GradeCalculator
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private int x;

    /**
     * GradeCalculator 클래스의 객체 생성자
     */
    public GradeCalculator(Grade[][] grades, Subject[] subjects, 
    int studentCount, int subjectCount)
    {
        // 인스턴스 변수 초기화
        x = 0;
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void calculateRelativeAllGrade(Grade[][] grades, Subject[] subjects, 
    int studentCount, int subjectCount)
    {
        // 여기에 코드를 작성하세요.

    }

    private static void calculateRelativeGrade(Grade[][] grades, Subject[] subjects, 
    int studentCount, int subjectIndex)
    {
        // 여기에 코드를 작성하세요.
        int count = 0;

        for(Grade[] studentGrades: grades){
            if(grades[i][subjectIndex] != null){
                count++;
            }
        }
        int[] indexArray = new int[count];
        int position = 0;

        for(Grade[] studentGrades : grades){
            if(grades[i][subjectIndex] != null){
                indexArray[position++] = i;
            }
        }

        for(int i = 0; i < count; i++){
            double myScore = grades[indexArray[i]][subjectIndex].getTotalScore();
            int rank = 1;
            for(int j = 0; j < count; j++){
                if(i == j){
                    if(grades[indexArray[j]][subjectIndex].getTotalScore() > myScore){
                        rank++;
                    }
                }
            }
            double ratio = (double)rank/count;

            if(ratio <= 0.175){
                letter = Gradeletter.A_Plus;
            }else if(ratio <= 0.35){
                letter = Gradeletter.A_zero;
            }else if(ratio <= 0.525){
                letter = Gradeletter.B_Plus;
            }else if(ratio <= 0.70){
                letter = Gradeletter.B_zero;
            }else if(ratio <= 0.76){
                letter = Gradeletter.C_Plus;
            }else if(ratio <= 0.82){
                letter = Gradeletter.C_zero;
            }else if(ratio <= 0.88){
                letter = Gradeletter.D_Plus;
            }else if(ratio <= 0.94){
                letter = Gradeletter.D_zero;
            }
            
            switch(ratio){
                case (ratio <= 0.175):
                    letter = Gradeletter.A_Plus;
                    break;
                case (ratio <= 0.35):
                    letter = Gradeletter.A_zero;
                    break;
                case (ratio <= 0.525):
                    letter = Gradeletter.B_Plus;
                    break;
                case (ratio <= 0.70):
                    letter = Gradeletter.B_zero;
                    break;
                case (ratio <= 0.76):
                    letter = Gradeletter.C_Plus;
                    break;
                case (ratio <= 0.82):
                    letter = Gradeletter.C_zero;
                    break;
                case (ratio <= 0.88):
                    letter = Gradeletter.D_Plus;
                    break;
                case (ratio <= 0.94):
                    letter = Gradeletter.D_zero;
                    break;
            }
            }
        }

        
    }


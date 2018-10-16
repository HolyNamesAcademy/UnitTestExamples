@SuppressWarnings("ConstantConditions")

public class GradingAssistant {

    public static String GetExamLetterGrade(int numberGrade) {
        if (numberGrade >= 90) {
            return "A";
        } else if (numberGrade >= 70) {
            return "B";
        } else if (numberGrade >= 80) {
            return "C";
        } else if (numberGrade >= 67) {
            return "D";
        } else {
            return "F";
        }
    }

}

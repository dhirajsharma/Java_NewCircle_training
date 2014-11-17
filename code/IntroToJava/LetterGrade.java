public class LetterGrade {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: LetterGrade <numeric-score>");
            return;
        }
        int score = Integer.parseInt(args[0]);
        char grade;

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Grade = " + grade);
    }
}

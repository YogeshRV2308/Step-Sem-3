import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluateScore();
    public abstract String getType();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }

    @Override
    public String getType() { return "MCQ"; }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }

    @Override
    public String getType() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        String studentAnswerLower = studentAnswer.toLowerCase();
        int matchedKeywords = 0;

        for (String kw : keywords) {
            if (studentAnswerLower.contains(kw.trim().toLowerCase())) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        } else if (matchedKeywords == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }

    @Override
    public String getType() { return "ESSAY"; }
}

public class Mainquestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = Integer.parseInt(sc.nextLine().trim());
        Question[] questions = new Question[n];

        // Regex matches TYPE "Text" "Correct" "Student" Points
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"(.*)\"\\s+\"(.*)\"\\s+\"(.*)\"\\s+(\\d+)$");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String type = matcher.group(1);
                String questionText = matcher.group(2);
                String correctAnswer = matcher.group(3);
                String studentAnswer = matcher.group(4);
                double points = Double.parseDouble(matcher.group(5));

                switch (type) {
                    case "MCQ":
                        questions[i] = new MCQQuestion(questionText, correctAnswer, studentAnswer, points);
                        break;
                    case "TF":
                        questions[i] = new TFQuestion(questionText, correctAnswer, studentAnswer, points);
                        break;
                    case "ESSAY":
                        questions[i] = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
                        break;
                }
            }
        }

        double totalScore = 0;
        for (Question q : questions) {
            if (q != null) {
                double score = q.evaluateScore();
                totalScore += score;
                System.out.printf("%s: %.2f%n", q.getType(), score);
            }
        }
        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}
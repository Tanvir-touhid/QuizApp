import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question[] questions = new Question[5];

        String[] options1 = {"A. Java", "B. C++", "C. Python", "D. JavaScript"};
        questions[0] = new Question("Which language is used for Android development?", options1, "A");

        String[] options2 = {"A. CSS", "B. HTML", "C. Java", "D. JavaScript"};
        questions[1] = new Question("Which language is used for web development?", options2, "B");

        String[] options3 = {"A. Berlin", "B. Madrid", "C. Paris", "D. Rome"};
        questions[2] = new Question("What is the capital city of France?", options3, "C");

        String[] options4 = {"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"};
        questions[3] = new Question("What is the largest planet in our solar system?", options4, "C");

        String[] options5 = {"A. 1910", "B. 1912", "C. 1914", "D. 1916"};
        questions[4] = new Question("In what year did the Titanic sink?", options5, "B");

        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            final String[] userAnswer = {null};
            final boolean[] hasAnswered = {false};
            final boolean[] timeUp = {false};

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!hasAnswered[0]) {
                        System.out.println("\nTime's UP!");
                        System.out.println("Provide your answer anyway: ");
                        hasAnswered[0] = true;
                        timeUp[0] = true;
                    }
                }
            }, 10000);

            System.out.print("Your answer: ");
            userAnswer[0] = sc.nextLine();
            hasAnswered[0] = true;
            timer.cancel();

            if (userAnswer[0] != null && userAnswer[0].trim().length() > 0) {
                if (question.isCorrect(userAnswer[0]) && !timeUp[0]) {
                    score++;
                    System.out.println("Correct!");
                }
                else {
                    if(timeUp[0]){
                        System.out.println("Time is Up! Score won't be added.");
                        timeUp[0] = false;
                    }
                    else{
                        System.out.println("Wrong! The correct answer is " + question.getCorrectAnswer());
                    }

                }
            }
            else {
                System.out.println("No answer provided! The correct answer is " + question.getCorrectAnswer());
            }
        }

        System.out.println("Your final score: " + score + "/" + questions.length);
        sc.close();
    }
}
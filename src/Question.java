public class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String q, String[] op, String ca){
        question = q;
        options = op;
        correctAnswer = ca;
    }
    public String getQuestion(){
        return question;
    }
    public String[] getOptions(){
        return options;
    }
    public String getCorrectAnswer(){
        return correctAnswer;
    }
    public boolean isCorrect(String a){
        return correctAnswer.equalsIgnoreCase(a);
    }
}

package service;

import controller.DBController;
import model.Answer;
import model.Question;
import model.Quiz;

import java.util.List;
import java.util.stream.Collectors;

public class CreateQuizService {
    private Quiz quiz;
    private Question currentQuestion;

    private static CreateQuizService instance;

    public static CreateQuizService getInstance() {
        if(instance == null){
            instance = new CreateQuizService();
        }
        return instance;
    }

    public void initializeQuiz(){
        this.quiz = new Quiz();
    }

    public void giveTitle(String title){
        this.quiz.setQuizTitle(title);
    }

    public void createQuestion(String text){
        Question question = new Question(text);
        this.currentQuestion = question;
        quiz.addQuestion(question);
    }

    public void createAnswer(String text, boolean correct){
        Answer answer = new Answer(text, correct);
        this.currentQuestion.addAnswer(answer);
    }

    public List<String> getQuestionList(){
        return quiz.getQuestions().stream().map(Question::getText).collect(Collectors.toList());
    }

    public void saveToDataBase(){
        this.quiz.getQuestions().get(0).getAnswers().forEach(answer -> System.out.println(answer.getText()));
        DBController.getInstance().saveQuiz(quiz);
    }

    public boolean verify(){
        return this.quiz.getQuestions().size() > 0;
    }


}

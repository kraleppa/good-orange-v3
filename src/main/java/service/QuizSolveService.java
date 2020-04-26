package service;

import lombok.Getter;
import model.Answer;
import model.Question;
import model.Quiz;
import org.hibernate.Hibernate;
import visualization.solving.QuizSolvePanel;

import java.util.ArrayList;
import java.util.List;

public class QuizSolveService {
    private final Quiz quiz;
    @Getter
    private final int numberOfQuestions;
    @Getter
    private Question currentQuestion;
    @Getter
    private int questionIndex;
    @Getter
    private final List<Double> pointsList = new ArrayList<>();

    public QuizSolveService(Quiz quiz) {
        this.quiz = quiz;
        this.numberOfQuestions = quiz.getQuestions().size();
        this.questionIndex = 0;
        try{
            if (this.numberOfQuestions == 0){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Quiz exception");
            System.exit(1);
        }

        this.currentQuestion = quiz.getQuestions().get(0);
    }

    public void nextQuestion(){
        if (this.questionIndex + 1 < this.numberOfQuestions){
            this.questionIndex++;
            this.currentQuestion = this.quiz.getQuestions().get(this.questionIndex);
        }
    }

    public void checkAndSaveAnswers(List<Boolean> list){
        List<Answer> answerList = this.currentQuestion.getAnswers();
        double answerValue = 1.0 / answerList.size();
        double questionPoints = 0.0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) && answerList.get(i).isCorrect()){
                questionPoints += answerValue;

            } else if (!list.get(i) && !answerList.get(i).isCorrect()){
                questionPoints += answerValue;
            }
        }
        this.pointsList.add(questionPoints);
    }

    public List<String> parseFinalResults(){
        List <String> resultsList = new ArrayList<>();
        for (int i = 0; i < this.numberOfQuestions; i++){
            resultsList.add(quiz.getQuestions().get(i).getText() + "   " + pointsList.get(i) + "/1.0");
        }
        return resultsList;
    }

    public String getQuizTitle(){
        return this.quiz.getQuizTitle();
    }

    public double getTotalPoints(){
        double sum = 0.0;
        for (double el : pointsList){
            sum += el;
        }
        return sum;
    }
}

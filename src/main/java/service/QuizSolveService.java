package service;

import lombok.Getter;
import model.Question;
import model.Quiz;
import visualization.solving.QuizSolvePanel;

public class QuizSolveService {
    private final Quiz quiz;
    @Getter
    private final int numberOfQuestions;
    @Getter
    private Question currentQuestion;
    @Getter
    private int questionIndex;

    public QuizSolveService(Quiz quiz) throws Exception {
        this.quiz = quiz;
        this.numberOfQuestions = quiz.getQuestions().size();
        this.questionIndex = 0;
        if (this.numberOfQuestions == 0){
            throw new Exception();
        }
        this.currentQuestion = quiz.getQuestions().get(0);
    }

    public String getQuizName(){
        return this.quiz.toString();
    }

    public void nextQuestion(){
        if (this.questionIndex + 1 < this.numberOfQuestions){
            this.questionIndex++;
            this.currentQuestion = this.quiz.getQuestions().get(this.questionIndex);
        }
    }


}

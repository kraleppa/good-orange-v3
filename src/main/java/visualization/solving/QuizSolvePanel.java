package visualization.solving;

import model.Quiz;

import javax.swing.*;

public class QuizSolvePanel extends JPanel {
    private final Quiz quiz;

    public QuizSolvePanel(Quiz quiz){
        super();
        this.quiz = quiz;
        this.add(new JLabel("Quiz co sie zwie " + quiz.toString()));
    }
}

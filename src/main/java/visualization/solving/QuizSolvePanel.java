package visualization.solving;

import model.Quiz;
import service.QuizSolveService;
import visualization.Router;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuizSolvePanel extends JPanel implements ActionListener {
    private final QuizSolveService service;

    private final JButton menuButton;
    private final JButton nextButton;
    private final JLabel questionNumberLabel;
    private QuestionPanel currentQuestionPanel;
    private final Router router;
    private final JPanel buttonPanel;

    public QuizSolvePanel(Quiz quiz, Router router){
        super();
        this.router = router;
        this.service = new QuizSolveService(quiz);
        this.setLayout(new GridLayout(2, 1));
        this.currentQuestionPanel = new QuestionPanel(this.service.getCurrentQuestion());
        add(this.currentQuestionPanel);

        this.nextButton = new JButton("Next Question");
        this.nextButton.addActionListener(this);

        this.menuButton = new JButton("Main Menu");
        this.menuButton.addActionListener(this);
        this.questionNumberLabel = new JLabel("Question number: " +
                (this.service.getQuestionIndex() + 1) + "/" + this.service.getNumberOfQuestions());

        this.buttonPanel = new JPanel();
        buttonPanel.add(menuButton);
        buttonPanel.add(questionNumberLabel);
        buttonPanel.add(nextButton);

        this.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == nextButton){
            this.service.checkAndSaveAnswers(this.currentQuestionPanel.parseAnswers());
            if (this.service.getQuestionIndex() + 1 < this.service.getNumberOfQuestions()){

                this.service.nextQuestion();
                this.refreshPanel();
            } else {
                this.router.routeTo(new EndGamePanel(this.router, this.service));
            }


        }

        if (event.getSource() == menuButton){
            this.router.routeTo("Menu");
        }
    }

    public void refreshPanel(){
        this.removeAll();
        this.questionNumberLabel.setText("Question number: " +
                (this.service.getQuestionIndex() + 1) + "/" + this.service.getNumberOfQuestions());
        this.currentQuestionPanel = new QuestionPanel(this.service.getCurrentQuestion());
        this.add(this.currentQuestionPanel);
        this.add(buttonPanel);
        this.validate();
        this.repaint();
    }
}

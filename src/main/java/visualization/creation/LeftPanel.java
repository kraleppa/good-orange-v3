package visualization.creation;

import service.CreateQuizService;
import visualization.Router;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel implements ActionListener {
    private final JButton saveButton;
    private final JButton returnButton;
    private final Router router;
    private final JTextField quizName;
    private final DefaultListModel model;
    public LeftPanel(Router router, DefaultListModel model){
        super();
        this.router = router;
        this.model = model;
        JLabel quizLabel = new JLabel("Quiz name: ");
        this.setLayout(new GridLayout(3, 1));

        JPanel namePanel = new JPanel();
        this.quizName = new JTextField(20);
        quizLabel.setLabelFor(quizName);
        namePanel.add(quizLabel);
        namePanel.add(quizName);

        this.add(namePanel);

        this.add(new QuestionPanel(model));

        JPanel buttonPanel = new JPanel();
        this.saveButton = new JButton("Save Quiz");
        this.saveButton.addActionListener(this);
        this.returnButton = new JButton("Main Menu");
        returnButton.addActionListener(this);
        buttonPanel.add(this.returnButton);
        buttonPanel.add(this.saveButton);

        this.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == returnButton){
            this.router.routeTo("Menu");
        }

        if (event.getSource() == saveButton && !this.quizName.getText().isEmpty() && CreateQuizService.getInstance().verify()){
            CreateQuizService.getInstance().giveTitle(this.quizName.getText());
            this.quizName.setText("");
            CreateQuizService.getInstance().saveToDataBase();

            this.router.routeTo("Menu");
            this.model.clear();
        }
    }
}

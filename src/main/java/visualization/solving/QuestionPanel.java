package visualization.solving;

import model.Answer;
import model.Question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionPanel extends JPanel  {
    private final Question question;
    private final List<JCheckBox> answerList;

    public QuestionPanel(Question question){
        super();
        this.question = question;
        this.answerList = new ArrayList<>();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel(this.question.getText());
        label.setBorder(new EmptyBorder(new Insets(20, 0, 50, 0)));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setFont(new Font("Serif", Font.BOLD, 20));
        add(label);

        for (Answer answer : question.getAnswers()){
            JCheckBox checkBox = new JCheckBox(answer.getText());
            checkBox.setAlignmentX(Component.LEFT_ALIGNMENT);
            answerList.add(checkBox);
            add(checkBox);
        }
    }

    public List<Boolean> parseAnswers(){
        return this.answerList.stream().map(AbstractButton::isSelected).collect(Collectors.toList());
    }
}

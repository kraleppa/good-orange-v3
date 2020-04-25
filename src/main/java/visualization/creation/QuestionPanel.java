package visualization.creation;

import model.Question;
import service.CreateQuizService;

import javax.persistence.Table;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionPanel extends JPanel implements ActionListener {
    private final JTextField questionText;
    private final JTextField answerText;
    private final JButton saveButton;
    private final JButton addButton;
    private final DefaultListModel listModel;
    private final JCheckBox checkbox;
    private final DefaultListModel questionsList;

    public QuestionPanel(DefaultListModel questionsList){
        super();
        this.questionsList = questionsList;
        this.setLayout(new GridLayout(4, 1));

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Question: ");
        this.questionText = new JTextField(15);
        nameLabel.setLabelFor(questionText);
        namePanel.add(nameLabel);
        namePanel.add(questionText);
        this.add(namePanel);

        this.listModel = new DefaultListModel();
        JList answerList = new JList(listModel);
        this.add(new JScrollPane(answerList));

        JPanel answerPanel = new JPanel();
        JLabel answerLabel = new JLabel("Answer: ");
        this.answerText = new JTextField(15);
        answerLabel.setLabelFor(answerText);
        answerPanel.add(answerLabel);
        answerPanel.add(answerText);
        this.checkbox = new JCheckBox("Correct answer");
        answerPanel.add(checkbox);
        this.add(answerPanel);


        JPanel buttonPanel = new JPanel();
        this.saveButton = new JButton("Save Question");
        this.saveButton.addActionListener(this);
        buttonPanel.add(saveButton);

        this.addButton = new JButton("Add Answer");
        this.addButton.addActionListener(this);
        buttonPanel.add(addButton);


        this.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addButton){
            String answer = answerText.getText();
            if (answer != null){
                this.listModel.addElement(answer + ": " + checkbox.isSelected());
                this.answerText.setText("");
                this.checkbox.setSelected(false);
            }
        }

        if (event.getSource() == saveButton && !questionText.getText().isEmpty() && !listModel.isEmpty()){
            CreateQuizService.getInstance().createQuestion(questionText.getText());
            for (Object element: listModel.toArray()){
                String string = (String) element;
                CreateQuizService.getInstance().createAnswer(string.split(": ")[0], string.split(": ")[1].equals("true"));
            }
            listModel.clear();
            questionsList.addElement(this.questionText.getText());
            this.questionText.setText("");
            answerText.setText("");
        }

    }
}

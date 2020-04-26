package visualization.solving;

import service.QuizSolveService;
import visualization.Router;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EndGamePanel extends JPanel implements ActionListener {
    private final Router router;
    private final QuizSolveService service;
    private final JButton menuButton;

    public EndGamePanel(Router router, QuizSolveService service){
        super();
//
        this.setLayout(new GridLayout(3, 1));
        this.router = router;
        this.service = service;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel();
        JLabel title = new JLabel(this.service.getQuizTitle());
        title.setFont(new Font("Serif", Font.BOLD, 40));
        panel1.add(title);

        JPanel panel2 = new JPanel();
        JLabel label = new JLabel("Your score: " + String.format("%.1f", service.getTotalPoints()) + "/"
                + service.getNumberOfQuestions() + ".0");
        label.setBorder(new EmptyBorder(new Insets(20, 0, 50, 0)));
        label.setFont(new Font("Serif", Font.BOLD, 25));
        panel2.add(label);

        panel.add(panel1);
        panel.add(panel2);

        this.add(panel);




        DefaultListModel listModel = new DefaultListModel();
        listModel.addAll(this.service.parseFinalResults());
        JList answerList = new JList(listModel);
        this.add(answerList);

        JPanel panel3 = new JPanel();
        this.menuButton = new JButton("Main Menu");
        this.menuButton.addActionListener(this);


        panel3.add(menuButton);
        this.add(panel3);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == menuButton){
            this.router.routeTo("Menu");
        }
    }


}

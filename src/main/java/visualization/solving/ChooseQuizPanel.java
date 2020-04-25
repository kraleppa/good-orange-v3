package visualization.solving;

import visualization.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseQuizPanel extends JPanel implements ActionListener {
    private final Router router;
    private final DefaultListModel quizList;


    public ChooseQuizPanel(Router router) {
        super();
        this.router = router;
        this.quizList = new DefaultListModel();
        JList jList = new JList(quizList);
        this.add(new JScrollPane(jList));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ;
    }
}

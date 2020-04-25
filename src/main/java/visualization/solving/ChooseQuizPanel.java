package visualization.solving;

import controller.DBController;
import model.Quiz;
import visualization.Router;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

public class ChooseQuizPanel extends JPanel implements ActionListener {
    private final Router router;
    private final DefaultListModel quizList;
    private final JButton refreshButton;
    private final JButton menuButton;


    public ChooseQuizPanel(Router router) {
        super();
        this.router = router;
        this.quizList = new DefaultListModel();
        this.quizList.addAll(DBController.getInstance().getAllQuizzes());
        this.refreshButton = new JButton("Refresh");
        this.refreshButton.addActionListener(this);
        this.menuButton = new JButton("Main Menu");
        this.menuButton.addActionListener(this);

        add(menuButton);
        add(refreshButton);

        JList jList = new JList(quizList);
        this.add(new JScrollPane(jList));
    }

    public void refreshQuizList(){
        this.quizList.clear();
        this.quizList.addAll(DBController.getInstance().getAllQuizzes().stream().map(Quiz::getQuizTitle).collect(Collectors.toList()));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == refreshButton){
            this.refreshQuizList();
        }

        if (event.getSource() == menuButton){
            this.router.routeTo("Menu|ChooseQuiz");
        }
    }
}

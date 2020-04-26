package visualization.solving;

import controller.DBController;
import model.Quiz;
import visualization.Router;
import visualization.creation.CreatingPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
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
        this.refreshQuizList();
        this.refreshButton = new JButton("Refresh");
        this.refreshButton.addActionListener(this);
        this.menuButton = new JButton("Main Menu");
        this.menuButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(menuButton);
        buttonPanel.add(refreshButton);

        this.setLayout(new GridLayout(2, 1));

        JList jList = new JList(quizList);
        jList.addMouseListener(mouseListener);
        this.add(new JScrollPane(jList));
        this.add(buttonPanel);
    }

    public void refreshQuizList(){
        this.quizList.clear();
        this.quizList.addAll(DBController.getInstance().getAllQuizzes());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == refreshButton){
            this.refreshQuizList();
        }

        if (event.getSource() == menuButton){
            this.router.routeTo("Menu");
        }
    }

    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent) {
            JList theList = (JList) mouseEvent.getSource();
            if (mouseEvent.getClickCount() == 2) {
                int index = theList.locationToIndex(mouseEvent.getPoint());
                if (index >= 0) {
                    Quiz quiz = (Quiz) theList.getModel().getElementAt(index);
                    router.routeTo(new QuizSolvePanel(quiz, router));
                }
            }
        }
    };
}

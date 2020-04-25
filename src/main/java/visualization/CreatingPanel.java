package visualization;

import service.CreateQuizService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CreatingPanel extends JPanel{
    private Router router;
    private JList list;
    private CreateQuizService creator;
    private final DefaultListModel listModel;



    public CreatingPanel(Router parent){
        super();
        this.creator = CreateQuizService.getInstance();
        this.creator.initializeQuiz();
        this.router = parent;
        this.setLayout( new GridLayout(1, 2));
        this.listModel = new DefaultListModel();
        this.add(new LeftPanel(this.router, this.listModel));
        this.list = new JList(listModel);
        this.add(new JScrollPane(this.list));
    }
}

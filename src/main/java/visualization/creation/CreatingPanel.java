package visualization.creation;

import service.CreateQuizService;
import visualization.Router;

import javax.swing.*;
import java.awt.*;

public class CreatingPanel extends JPanel{
    private Router router;
    private final DefaultListModel listModel;



    public CreatingPanel(Router parent){
        super();
        CreateQuizService.getInstance().initializeQuiz();
        this.router = parent;
        this.setLayout( new GridLayout(1, 2));
        this.listModel = new DefaultListModel();
        this.add(new LeftPanel(this.router, this.listModel));
        JList jList = new JList(listModel);
        this.add(new JScrollPane(jList));
    }
}

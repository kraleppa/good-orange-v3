package visualization;

import service.CreateQuizService;
import visualization.creation.CreatingPanel;
import visualization.solving.ChooseQuizPanel;

import javax.swing.*;

public class GUI extends JFrame implements Router{
    private final Menu menu;
    private final CreatingPanel creatingPanel;
    private final ChooseQuizPanel chooseQuizPanel;

    public GUI(){
        super("Good Orange V3");
        this.menu = new Menu(this);
        this.creatingPanel = new CreatingPanel(this);
        this.chooseQuizPanel = new ChooseQuizPanel(this);
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(this.menu);
    }

    @Override
    public void routeTo(String windowName){
        switch (windowName){
            case "CreatingPanel": CreateQuizService.getInstance().initializeQuiz(); getContentPane().remove(menu); getContentPane().add(creatingPanel); break;
            case "Menu": getContentPane().remove(creatingPanel); getContentPane().add(menu); break;
            case "ChooseQuizPanel": getContentPane().remove(menu); getContentPane().add(chooseQuizPanel); break;
            case "Menu|ChooseQuiz": getContentPane().remove(chooseQuizPanel); getContentPane().add(menu); break;
        }
        getContentPane().validate();
        getContentPane().repaint();
    }
}

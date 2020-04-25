package visualization;

import service.CreateQuizService;
import visualization.creation.CreatingPanel;
import visualization.solving.ChooseQuizPanel;

import javax.swing.*;

public class GUI extends JFrame implements Router{
    private final Menu menu;
    private final CreatingPanel creatingPanel;
    private final ChooseQuizPanel chooseQuizPanel;
    private JPanel currentPanel;

    public GUI(){
        super("Good Orange V3");
        this.menu = new Menu(this);
        this.creatingPanel = new CreatingPanel(this);
        this.chooseQuizPanel = new ChooseQuizPanel(this);
        this.currentPanel = this.menu;
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(this.menu);
    }

    @Override
    public void routeTo(String windowName){
        if (windowName.equals("Menu")){
            getContentPane().remove(currentPanel);
            getContentPane().add(menu);
            this.currentPanel = menu;
            getContentPane().validate();
            getContentPane().repaint();
        }

        if (windowName.equals("ChooseQuizPanel")){
            getContentPane().remove(currentPanel);
            getContentPane().add(chooseQuizPanel);
            this.currentPanel = chooseQuizPanel;
            getContentPane().validate();
            getContentPane().repaint();
        }

        if (windowName.equals("CreatingPanel")){
            getContentPane().remove(currentPanel);
            getContentPane().add(creatingPanel);
            this.currentPanel = creatingPanel;
            getContentPane().validate();
            getContentPane().repaint();
        }

    }

    @Override
    public void routeTo(JPanel panel) {
        getContentPane().remove(currentPanel);
        getContentPane().add(panel);
        this.currentPanel = panel;
        getContentPane().validate();
        getContentPane().repaint();
    }
}

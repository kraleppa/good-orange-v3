package visualization;

import javax.swing.*;

public class GUI extends JFrame implements Router{
    private Menu menu;
    private CreatingPanel creatingPanel;

    public GUI(){
        super("Good Orange V3");
        this.menu = new Menu(this);
        this.creatingPanel = new CreatingPanel(this);
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(this.menu);
    }

    @Override
    public void routeTo(String windowName){
        if (windowName.equals("CreatingPanel")){
            getContentPane().remove(menu);
            getContentPane().add(creatingPanel);
        }
        if (windowName.equals("Menu")){
            getContentPane().remove(creatingPanel);
            getContentPane().add(menu);
        }
        getContentPane().validate();
        getContentPane().repaint();
    }
}

package visualization;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    private final JButton createQuizButton;
    private final Router router;

    public Menu(Router router){
        super();
        this.router = router;
        this.createQuizButton = new JButton("Create Quiz");
        this.createQuizButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.createQuizButton.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        JLabel label = new JLabel("Good Orange V3");
        label.setBorder(new EmptyBorder(new Insets(20, 0, 50, 0)));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Serif", Font.BOLD, 25));
        add(label);
        add(createQuizButton);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == createQuizButton){
            this.router.routeTo("CreatingPanel");
        }
    }
}

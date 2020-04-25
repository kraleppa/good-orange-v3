package visualization;

import javax.swing.*;

public interface Router {
    void routeTo(String windowName);
    void routeTo(JPanel panel);
}

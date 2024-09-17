package Events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeartBrokenActionListener implements ActionListener {
    JPanel panelTitle;
    JLabel heart;

    public HeartBrokenActionListener(JPanel panelTitle, JLabel heart) {
        this.panelTitle = panelTitle;
        this.heart = heart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.panelTitle.remove(heart);
        this.panelTitle.revalidate();
        this.panelTitle.repaint();
        ((Timer)e.getSource()).stop();
    }
}

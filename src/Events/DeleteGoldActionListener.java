package Events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteGoldActionListener implements ActionListener {
    JLabel gold;
    JPanel newPanel;

    public DeleteGoldActionListener(JPanel newPanel, JLabel gold) {
        this.gold = gold;
        this.newPanel = newPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.newPanel.setComponentZOrder(this.gold, 1);
        this.newPanel.remove(gold);
        this.newPanel.revalidate();
        this.newPanel.repaint();
        ((Timer)e.getSource()).stop();
    }
}

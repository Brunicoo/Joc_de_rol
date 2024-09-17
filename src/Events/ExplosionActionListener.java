package Events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExplosionActionListener implements ActionListener {
    private final JPanel newPanel;
    private final JLabel attackLabel;

    public ExplosionActionListener(JPanel newPanel, JLabel attackLabel) {
        this.newPanel = newPanel;
        this.attackLabel = attackLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.newPanel.setComponentZOrder(this.attackLabel, 1);
        this.newPanel.remove(this.attackLabel);
        this.newPanel.revalidate();
        this.newPanel.repaint();
        ((Timer)e.getSource()).stop();
    }
}

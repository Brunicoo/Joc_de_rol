package Events;

import characters.Skeleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExplosionSKActionListener implements ActionListener {
    private JPanel newPanel;
    private Skeleton skeleton;

    public ExplosionSKActionListener(JPanel newPanel, Skeleton skeleton) {
        this.newPanel = newPanel;
        this.skeleton = skeleton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       explosionSkeleton(e);
    }
    private void explosionSkeleton(ActionEvent e){
        this.newPanel.remove(this.skeleton.getLabelSkeleton());
        this.skeleton.getLabelSkeleton().setVisible(false);
        this.newPanel.revalidate();
        this.newPanel.repaint();
        ((Timer)e.getSource()).stop();
    }
}

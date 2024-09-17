package Events;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayActionListener extends MouseAdapter {
    JPanel panelMain;
    JPanel newPanel;
    public PlayActionListener(JPanel panelMain, JPanel newPanel) {
        this.panelMain = panelMain;
        this.newPanel = newPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        panelMain.removeAll();
        panelMain.repaint();
        panelMain.add(newPanel);
        panelMain.repaint();
    }
}

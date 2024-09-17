package characters;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Magician extends Character {

    public Magician(int gold, Icon staticMove, Icon upMove, Icon rightMove, Icon leftMove, Icon downMove, List<Icon> items, Icon attackUp, Icon attackDown, Icon attackRight, Icon attackLeft, Icon attackI, JLabel attackLabel) {
        super("Wizard", gold, 3, 7, staticMove, upMove, rightMove, leftMove, downMove, items, 9, attackUp, attackDown, attackRight, attackLeft, attackI, attackLabel);
        this.upMove = new ImageIcon("src/Animations/wizard/wizard_up.gif");
        this.downMove = new ImageIcon("src/Animations/wizard/wizard_down.gif");
        this.rightMove = new ImageIcon("src/Animations/wizard/wizard_right.gif");
        this.leftMove = new ImageIcon("src/Animations/wizard/wizard_left.gif");
        this.attackUp = new ImageIcon("src/Animations/wizard/Attack/fireBallUp.gif");
        this.attackDown = new ImageIcon("src/Animations/wizard/Attack/fireBallDown.gif");
        this.attackRight = new ImageIcon("src/Animations/wizard/Attack/fireBallRight.gif");
        this.attackLeft = new ImageIcon("src/Animations/wizard/Attack/fireBallLeft.gif");
        this.attackI = new ImageIcon("src/Animations/wizard/Attack/explosionFireBall.gif");
        this.attackLabel = new JLabel();
        this.items = new ArrayList<>();
    }
}

package characters;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Priest extends Character {

    public Priest(int gold, Icon staticMove, Icon upMove, Icon rightMove, Icon leftMove, Icon downMove, List<Icon> items, Icon attackUp, Icon attackDown, Icon attackRight, Icon attackLeft, Icon attackI, JLabel attackLabel) {
        super("Priest", gold, 4, 5, staticMove, upMove, rightMove, leftMove, downMove, items, 6, attackUp, attackDown, attackRight, attackLeft, attackI, attackLabel);
        this.upMove = new ImageIcon("src/Animations/priest/priest_up.gif");
        this.downMove = new ImageIcon("src/Animations/priest/priest_down.gif");
        this.rightMove = new ImageIcon("src/Animations/priest/priest_right.gif");
        this.leftMove = new ImageIcon("src/Animations/priest/priest_left.gif");
        this.attackUp = new ImageIcon("src/Animations/priest/Attack/energyBall.gif");
        this.attackDown = new ImageIcon("src/Animations/priest/Attack/energyBall.gif");
        this.attackLeft = new ImageIcon("src/Animations/priest/Attack/energyBall.gif");
        this.attackRight = new ImageIcon("src/Animations/priest/Attack/energyBall.gif");
        this.attackI = new ImageIcon("src/Animations/priest/Attack/explosionEnergyBall.gif");
        this.attackLabel = new JLabel();
        this.items = new ArrayList<>();
    }
}

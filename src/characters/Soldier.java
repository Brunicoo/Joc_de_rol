package characters;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Soldier extends Character {

    public Soldier(int gold, Icon staticMove, Icon upMove, Icon rightMove, Icon leftMove, Icon downMove, List<Icon> items, Icon attackUp, Icon attackDown, Icon attackRight, Icon attackLeft, Icon attackI, JLabel attackLabel) {
        super("Soldier", gold, 5, 3, staticMove, upMove, rightMove, leftMove, downMove, items, 20, attackUp, attackDown, attackRight, attackLeft, attackI, attackLabel);
        this.upMove = new ImageIcon("src/Animations/warrior/warrior_up.gif");
        this.downMove = new ImageIcon("src/Animations/warrior/warrior_down.gif");
        this.rightMove = new ImageIcon("src/Animations/warrior/warrior_right.gif");
        this.leftMove = new ImageIcon("src/Animations/warrior/warrior_left.gif");
        this.attackUp = new ImageIcon("src/Animations/warrior/Attack/attackUp.gif");
        this.attackDown = new ImageIcon("src/Animations/warrior/Attack/attackDown.gif");
        this.attackLeft = new ImageIcon("src/Animations/warrior/Attack/attackLeft.gif");
        this.attackRight = new ImageIcon("src/Animations/warrior/Attack/attackRight.gif");
        this.attackLabel = new JLabel();
        this.items = new ArrayList<>();
    }
}

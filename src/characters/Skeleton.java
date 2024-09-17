package characters;

import javax.swing.*;

public class Skeleton {
    private int speed;
    private int live;
    private int attack;
    private Icon upMove;
    private Icon downMove;
    private Icon leftMove;
    private Icon rightMove;
    private JLabel labelSkeleton;
    private Icon explosionDead;

    public Skeleton() {
        this.speed = 5;
        this.live = 20;
        this.attack = 2;
        this.upMove = new ImageIcon("src/Animations/skeleton/skeleton_up.gif");
        this.downMove = new ImageIcon("src/Animations/skeleton/skeleton_down.gif");
        this.leftMove = new ImageIcon("src/Animations/skeleton/skeleton_left.gif");
        this.rightMove = new ImageIcon("src/Animations/skeleton/skeleton_right.gif");
        this.explosionDead = new ImageIcon("src/Animations/skeleton/skeletonDie.gif");
        this.labelSkeleton = new JLabel();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Icon getUpMove() {
        return upMove;
    }

    public void setUpMove(Icon upMove) {
        this.upMove = upMove;
    }

    public Icon getDownMove() {
        return downMove;
    }

    public void setDownMove(Icon downMove) {
        this.downMove = downMove;
    }

    public Icon getLeftMove() {
        return leftMove;
    }

    public void setLeftMove(Icon leftMove) {
        this.leftMove = leftMove;
    }

    public Icon getRightMove() {
        return rightMove;
    }

    public void setRightMove(Icon rightMove) {
        this.rightMove = rightMove;
    }

    public JLabel getLabelSkeleton() {
        return labelSkeleton;
    }

    public void setLabelSkeleton(JLabel labelSkeleton) {
        this.labelSkeleton = labelSkeleton;
    }

    public Icon getExplosionDead() {
        return explosionDead;
    }

    public void setExplosionDead(Icon explosionDead) {
        this.explosionDead = explosionDead;
    }
}

package characters;

import javax.swing.*;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int gold;
    protected int live;
    protected int speed;
    protected int attack;
    //protected int kills;
    protected Icon staticMove;
    protected Icon upMove;
    protected Icon rightMove;
    protected Icon leftMove;
    protected Icon downMove;
    protected List<Icon> items;
    protected Icon attackUp;
    protected Icon attackDown;
    protected Icon attackRight;
    protected Icon attackLeft;
    protected Icon attackI;
    JLabel attackLabel;


    public Character(String name, int gold, int live, int speed, Icon staticMove, Icon upMove, Icon rightMove, Icon leftMove, Icon downMove, List<Icon> items, int attack, Icon attackUp, Icon attackDown, Icon attackRight, Icon attackLeft, Icon attackI, JLabel attackLabel) {
        this.name = name;
        this.gold = 0;
        this.live = live;
        this.speed = speed;
        this.staticMove = staticMove;
        this.upMove = upMove;
        this.rightMove = rightMove;
        this.leftMove = leftMove;
        this.downMove = downMove;
        this.items = items;
        this.attack = attack;
        this.attackUp = attackUp;
        this.attackDown = attackDown;
        this.attackRight = attackRight;
        this.attackLeft = attackLeft;
        this.attackI = attackI;
        this.attackLabel = attackLabel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Icon getStaticMove() {
        return staticMove;
    }

    public void setStaticMove(Icon staticMove) {
        this.staticMove = staticMove;
    }

    public Icon getUpMove() {
        return upMove;
    }

    public void setUpMove(Icon upMove) {
        this.upMove = upMove;
    }

    public Icon getRightMove() {
        return rightMove;
    }

    public void setRightMove(Icon rightMove) {
        this.rightMove = rightMove;
    }

    public Icon getLeftMove() {
        return leftMove;
    }

    public void setLeftMove(Icon leftMove) {
        this.leftMove = leftMove;
    }

    public Icon getDownMove() {
        return downMove;
    }

    public void setDownMove(Icon downMove) {
        this.downMove = downMove;
    }

    public List<Icon> getItems() {
        return items;
    }

    public void setItems(List<Icon> items) {
        this.items = items;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Icon getAttackUp() {
        return attackUp;
    }

    public void setAttackUp(Icon attackUp) {
        this.attackUp = attackUp;
    }

    public Icon getAttackDown() {
        return attackDown;
    }

    public void setAttackDown(Icon attackDown) {
        this.attackDown = attackDown;
    }

    public Icon getAttackRight() {
        return attackRight;
    }

    public void setAttackRight(Icon attackRight) {
        this.attackRight = attackRight;
    }

    public Icon getAttackLeft() {
        return attackLeft;
    }

    public void setAttackLeft(Icon attackLeft) {
        this.attackLeft = attackLeft;
    }

    public Icon getAttackI() {
        return attackI;
    }

    public void setAttackI(Icon attackI) {
        this.attackI = attackI;
    }

    public JLabel getAttackLabel() {
        return attackLabel;
    }

    public void setAttackLabel(JLabel attackLabel) {
        this.attackLabel = attackLabel;
    }

}


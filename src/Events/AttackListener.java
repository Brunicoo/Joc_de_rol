package Events;

import Tools.Tools;
import characters.Character;
import characters.Skeleton;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class AttackListener extends KeyAdapter {
    Skeleton skeleton;
    Character chara;
    JLabel character;
    JPanel wallsXU;
    JPanel wallsXD;
    JPanel wallsYL;
    JPanel wallsYR;
    JPanel newPanel;
    static JLabel b;
    ArrayList<Skeleton> skeletons;
    JLabel attackLabel;
    ArrayList<JLabel> golds;
    JLabel oro;
    Icon gold = new ImageIcon("src/images/dungeon/dollar.png");
    JLabel goldTitle;

    public AttackListener(Skeleton skeleton, Character chara, JLabel character, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR, JPanel newPanel, JLabel b, ArrayList<Skeleton> skeletons, ArrayList<JLabel> golds, JLabel goldTitle) {
        this.skeleton = skeleton;
        this.chara = chara;
        this.character = character;
        this.wallsXU = wallsXU;
        this.wallsXD = wallsXD;
        this.wallsYL = wallsYL;
        this.wallsYR = wallsYR;
        this.newPanel = newPanel;
        this.b = b;
        this.skeletons = skeletons;
        this.golds = golds;
        this.goldTitle = goldTitle;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_SPACE) {
            characterAttack();
        }
    }
    private void characterAttack(){
        if (chara.getName().equalsIgnoreCase("Wizard") || chara.getName().equalsIgnoreCase("Priest")){
            magicianAndPriestAttack();
        } else {
            soldierAttack();
        }
    }
    private void generateAttackLabel(){
        attackLabel = new JLabel();
        attackLabel.setSize(32,32);
        attackLabel.setLocation(character.getLocation());
        newPanel.add(attackLabel);
        newPanel.setComponentZOrder(attackLabel, 0);
        b.setComponentZOrder(attackLabel, 0);
        newPanel.repaint();
        newPanel.revalidate();
    }

    private void magicianAndPriestAttack() {
        if (character.getIcon() == chara.getDownMove()) {
            generateAttackLabel();
            attackLabel.setIcon(chara.getAttackDown());
            Timer attackTimerDown = new Timer(10, new  AttackMovementListenerDown(skeleton, chara, character, wallsXU, wallsXD, wallsYL, wallsYR, newPanel, b, attackLabel, skeletons, golds));
            attackTimerDown.start();
        } else if (character.getIcon() == chara.getUpMove()) {
            generateAttackLabel();
            attackLabel.setIcon(chara.getAttackUp());
            Timer attackTimerUp = new Timer(10, new AttackMovementListenerUp(skeleton, chara, character, wallsXU, wallsXD, wallsYL, wallsYR, newPanel, b, attackLabel, skeletons, golds));
            attackTimerUp.start();
        } else if (character.getIcon() == chara.getLeftMove()) {
            generateAttackLabel();
            attackLabel.setIcon(chara.getAttackLeft());
            Timer attackTimerLeft = new Timer(10, new AttackMovementListenerLeft(skeleton, chara, character, wallsXU, wallsXD, wallsYL, wallsYR, newPanel, b, attackLabel, skeletons, golds));
            attackTimerLeft.start();
        } else if (character.getIcon() == chara.getRightMove()){
            generateAttackLabel();
            attackLabel.setIcon(chara.getAttackRight());
            Timer attackTimerRight = new Timer(10, new AttackMovementListenerRight(skeleton, chara, character, wallsXU, wallsXD, wallsYL, wallsYR, newPanel, b, attackLabel, skeletons, golds));
            attackTimerRight.start();
        }
    }

    private void soldierAttack(){
        if (character.getIcon() == chara.getDownMove()) {
            character.setIcon(chara.getAttackDown());
            soldierAttackImpact();
        } else if (character.getIcon() == chara.getUpMove()) {
            character.setIcon(chara.getAttackUp());
            soldierAttackImpact();
        } else if (character.getIcon() == chara.getLeftMove()) {
            character.setIcon(chara.getAttackLeft());
            soldierAttackImpact();
        } else if (character.getIcon() == chara.getRightMove()){
            character.setIcon(chara.getAttackRight());
            soldierAttackImpact();
        }
    }

    private void soldierAttackImpact(){
        this.skeleton = Tools.intersectsSkeleton(this.character, this.skeletons);
        Rectangle rS = this.character.getBounds();
        Timer explosionSk = new Timer(100, new ExplosionSKActionListener(this.newPanel, this.skeleton));
        if ((this.skeleton != null) && (rS.intersects(this.skeleton.getLabelSkeleton().getBounds()))){
            this.skeleton.setLive(this.skeleton.getLive() - this.chara.getAttack());
            if (this.skeleton.getLive() <= 0) {
                Random random = new Random();
                int r = random.nextInt(2);
                this.skeletons.remove(this.skeleton);
                this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getExplosionDead());
                if (r == 1){
                    oro = new JLabel();
                    oro.setSize(16,16);
                    oro.setIcon(gold);
                    newPanel.add(oro);
                    oro.setLocation(this.skeleton.getLabelSkeleton().getLocation());
                    newPanel.setComponentZOrder(oro, 0);
                    b.setComponentZOrder(oro, 0);
                    this.golds.add(oro);
                    newPanel.repaint();
                }
                explosionSk.start();

            } else if (this.skeleton.getLive() <= 10 && this.skeleton.getLive() > 5) {
                this.skeleton.getLabelSkeleton().setBorder(BorderFactory.createLineBorder(Color.yellow));

            } else if (this.skeleton.getLive() <= 5 && this.skeleton.getLive() > 0) {
                this.skeleton.getLabelSkeleton().setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }
    }
}

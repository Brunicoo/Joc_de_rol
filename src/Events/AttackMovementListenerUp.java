package Events;

import Tools.Tools;
import characters.Character;
import characters.Skeleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class AttackMovementListenerUp implements ActionListener {
    Skeleton skeleton;
    Character chara;
    JLabel character;
    JPanel wallsXU;
    JPanel wallsXD;
    JPanel wallsYL;
    JPanel wallsYR;
    JPanel newPanel;
    static JLabel b;
    JLabel attackLabel;
    ArrayList<Skeleton> skeletons;
    JLabel oro;
    ArrayList<JLabel> golds;
    Icon gold = new ImageIcon("src/images/dungeon/dollar.png");
    public AttackMovementListenerUp(Skeleton skeleton, Character chara, JLabel character, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR, JPanel newPanel, JLabel b, JLabel attackLabel, ArrayList<Skeleton> skeletons, ArrayList<JLabel> golds) {
        this.skeleton = skeleton;
        this.chara = chara;
        this.character = character;
        this.wallsXU = wallsXU;
        this.wallsXD = wallsXD;
        this.wallsYL = wallsYL;
        this.wallsYR = wallsYR;
        this.newPanel = newPanel;
        this.b = b;
        this.attackLabel = attackLabel;
        this.skeletons = skeletons;
        this.golds = golds;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        attackMovement(e);
    }

    private void attackMovement(ActionEvent e) {
        Rectangle attackR = new Rectangle(attackLabel.getX(), attackLabel.getY(), attackLabel.getWidth(), attackLabel.getHeight());
        this.skeleton = Tools.intersectsSkeleton(attackLabel, skeletons);
        Timer t = new Timer(1000, new ExplosionActionListener(this.newPanel, this.attackLabel));
        Timer explosionSk = new Timer(100, new ExplosionSKActionListener(this.newPanel, this.skeleton));

        if (attackR.intersects(wallsXU.getBounds()) || attackR.intersects(wallsXD.getBounds()) || attackR.intersects(wallsYL.getBounds()) || attackR.intersects(wallsYR.getBounds())) {
            this.attackLabel.setIcon(chara.getAttackI());
            t.start();
            ((Timer) e.getSource()).stop();

        } else if (this.skeleton != null && this.attackLabel.getBounds().intersects(this.skeleton.getLabelSkeleton().getBounds())) {
            this.skeleton.setLive(this.skeleton.getLive() - chara.getAttack());
            this.attackLabel.setIcon(chara.getAttackI());
            t.start();
            ((Timer) e.getSource()).stop();
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
            } else {
                this.attackLabel.setLocation(attackLabel.getX(), attackLabel.getY() - 15);
            }
        }
    }

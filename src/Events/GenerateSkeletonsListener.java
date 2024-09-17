package Events;

import characters.Character;
import characters.Skeleton;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GenerateSkeletonsListener implements ActionListener {
    Skeleton skeleton;
    JLabel character;
    JPanel wallsXU;
    JPanel wallsXD;
    JPanel wallsYL;
    JPanel wallsYR;
    JPanel newPanel;
    static JLabel b;
    Timer movementSK;
    Character chara;
    ArrayList<Skeleton> skeletons;

    public GenerateSkeletonsListener(Skeleton skeleton, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR, JPanel newPanel, JLabel b, JLabel character, Timer movementSK, Character chara, ArrayList<Skeleton> skeletons) {
        this.skeleton = skeleton;
        this.wallsXU = wallsXU;
        this.wallsXD = wallsXD;
        this.wallsYL = wallsYL;
        this.wallsYR = wallsYR;
        this.newPanel = newPanel;
        this.b = b;
        this.character = character;
        this.movementSK = movementSK;
        this.chara = chara;
        this.skeletons = skeletons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addSkeletonsMap();
    }

    private void addSkeletonsMap(){
        this.skeleton = new Skeleton();
        do {
            Random x = new Random();
            Random y = new Random();
            this.skeleton.getLabelSkeleton().setIcon(skeleton.getDownMove());
            this.skeleton.getLabelSkeleton().setSize(64,64);
            this.skeleton.getLabelSkeleton().setLocation(x.nextInt(1920 - skeleton.getLabelSkeleton().getWidth()), y.nextInt(1080 - skeleton.getLabelSkeleton().getHeight()));
            this.skeleton.getLabelSkeleton().setBorder(BorderFactory.createLineBorder(Color.green));
            if (!isOut()){
                this.newPanel.add(this.skeleton.getLabelSkeleton());
                this.skeletons.add(this.skeleton);
                this.newPanel.setComponentZOrder(this.skeleton.getLabelSkeleton(),0);
                b.setComponentZOrder(this.skeleton.getLabelSkeleton(), 0);
                this.newPanel.repaint();
                this.movementSK = movementSkeletons(skeleton, character, wallsXU, wallsXD, wallsYL, wallsYR);
                this.movementSK.start();
            }
        }while (isOut());

    }

    private boolean isOut(){
        return (this.skeleton.getLabelSkeleton().getX() <= (this.wallsYL.getX() + 16) || this.skeleton.getLabelSkeleton().getX() >= this.wallsYR.getX() - 64) || (this.skeleton.getLabelSkeleton().getY() <= (wallsXU.getY() + 16) || this.skeleton.getLabelSkeleton().getY() >= wallsXD.getY() - 64);
    }

    private static Timer movementSkeletons(Skeleton skeleton, JLabel character, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR){
        return new Timer(100, new SkeletonMovementListener(skeleton, character, wallsXU, wallsXD, wallsYL, wallsYR));
    }
}

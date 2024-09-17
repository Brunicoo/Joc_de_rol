package Events;

import characters.Skeleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkeletonMovementListener implements ActionListener {
    Skeleton skeleton;
    JLabel character;
    JPanel wallsXU;
    JPanel wallsXD;
    JPanel wallsYL;
    JPanel wallsYR;
    public SkeletonMovementListener(Skeleton skeleton, JLabel character, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR) {
        this.skeleton = skeleton;
        this.character = character;
        this.wallsXU = wallsXU;
        this.wallsXD = wallsXD;
        this.wallsYL = wallsYL;
        this.wallsYR = wallsYR;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        skeletonMovement(e);
    }

    private void skeletonMovement(ActionEvent e){
        int xSkeleton = this.skeleton.getLabelSkeleton().getX();
        int ySkeleton = this.skeleton.getLabelSkeleton().getY();
        int xCharacter = this.character.getX();
        int yCharacter = this.character.getY();

        int difX = xCharacter - xSkeleton;
        int difY = yCharacter - ySkeleton;


        if(this.skeleton.getLive() <= 0){
            ((Timer)e.getSource()).stop();
        } else {
            if (Math.abs(difX) > Math.abs(difY)) {
                if (xSkeleton > xCharacter){
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getLeftMove());
                    if (!intersectsSkeleton(xSkeleton - this.skeleton.getSpeed(), ySkeleton)) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton - this.skeleton.getSpeed(), ySkeleton);
                    }
                } else if (xSkeleton < xCharacter){
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getRightMove());
                    if (!intersectsSkeleton(xSkeleton + this.skeleton.getSpeed(), ySkeleton)) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton + this.skeleton.getSpeed(), ySkeleton);
                    }
                }
            } else if (Math.abs(difY) > Math.abs(difX)){
                if (ySkeleton > yCharacter){
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getUpMove());
                    if (!intersectsSkeleton(xSkeleton, ySkeleton - this.skeleton.getSpeed())) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton, ySkeleton - this.skeleton.getSpeed());
                    }
                } else if (ySkeleton < yCharacter){
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getDownMove());
                    if (!intersectsSkeleton(xSkeleton, ySkeleton + this.skeleton.getSpeed())) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton, ySkeleton + this.skeleton.getSpeed());
                    }
                }
            } else {
                if (xSkeleton < xCharacter && ySkeleton < yCharacter) {
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getDownMove());
                    if (!intersectsSkeleton(xSkeleton + this.skeleton.getSpeed(), ySkeleton + this.skeleton.getSpeed())) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton + this.skeleton.getSpeed(), ySkeleton + this.skeleton.getSpeed());
                    }
                } else if (xSkeleton < xCharacter && ySkeleton > yCharacter) {
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getUpMove());
                    if (!intersectsSkeleton(xSkeleton + this.skeleton.getSpeed(), ySkeleton - this.skeleton.getSpeed())) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton + this.skeleton.getSpeed(), ySkeleton - this.skeleton.getSpeed());
                    }
                } else if (xSkeleton > xCharacter && ySkeleton < yCharacter) {
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getDownMove());
                    if (!intersectsSkeleton(xSkeleton - this.skeleton.getSpeed(), ySkeleton + this.skeleton.getSpeed())) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton - this.skeleton.getSpeed(), ySkeleton + this.skeleton.getSpeed());
                    }
                } else {
                    this.skeleton.getLabelSkeleton().setIcon(this.skeleton.getUpMove());
                    if (!intersectsSkeleton(xSkeleton - this.skeleton.getSpeed(), ySkeleton - this.skeleton.getSpeed())) {
                        this.skeleton.getLabelSkeleton().setLocation(xSkeleton - this.skeleton.getSpeed(), ySkeleton - this.skeleton.getSpeed());
                    }
                }
            }
        }
    }

    private boolean intersectsSkeleton(int x, int y) {
        Rectangle futureBounds = new Rectangle(x, y, this.skeleton.getLabelSkeleton().getWidth(), this.skeleton.getLabelSkeleton().getHeight());
        if (futureBounds.intersects(wallsXU.getBounds()) || futureBounds.intersects(wallsXD.getBounds()) || futureBounds.intersects(wallsYL.getBounds()) || futureBounds.intersects(wallsYR.getBounds())) {
            return true;
        } else {
            return false;
        }
    }
}

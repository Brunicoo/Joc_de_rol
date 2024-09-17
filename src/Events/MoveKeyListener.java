package Events;

import Tools.Tools;
import characters.Character;
import characters.Skeleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MoveKeyListener extends KeyAdapter {
    JLabel character;
    Character chara;
    JPanel newPanel;
    JLabel b;
    JPanel wallsXU;
    JPanel wallsXD;
    JPanel wallsYL;
    JPanel wallsYR;
    JPanel panelTitle;
    Skeleton skeleton;
    ArrayList<JLabel> hearts;
    ArrayList<Skeleton> skeletons;
    ArrayList<JLabel> golds;
    private boolean canLoseLife = true;
    Icon goldGif = new ImageIcon("src/images/dungeon/dollarGold.gif");
    JLabel goldTitle;
    JLabel labelPortal =  new JLabel();
    public MoveKeyListener(JLabel character, Character chara, JPanel newPanel, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR, JPanel panelTitle, Skeleton skeleton, ArrayList<JLabel> hearts, ArrayList<Skeleton> skeletons, ArrayList<JLabel> golds, JLabel goldTitle, JLabel b) {
        this.character = character;
        this.chara = chara;
        this.newPanel = newPanel;
        this.wallsXU = wallsXU;
        this.wallsXD = wallsXD;
        this.wallsYL = wallsYL;
        this.wallsYR = wallsYR;
        this.panelTitle = panelTitle;
        this.skeleton = skeleton;
        this.hearts = hearts;
        this.skeletons = skeletons;
        this.golds = golds;
        this.goldTitle = goldTitle;
        this.b = b;
    }

    @Override
    public void keyPressed(KeyEvent e){
        super.keyPressed(e);
        int keyCode = e.getKeyCode();

        switch (keyCode){
            case KeyEvent.VK_W:
                int y = character.getY() - chara.getSpeed();
                Rectangle r = new Rectangle(character.getX(), y, character.getWidth(), character.getHeight());
                Rectangle XU = wallsXU.getBounds();
                character.setIcon(chara.getUpMove());

                if (r.intersects(XU)){
                    character.setLocation(character.getX(), character.getY());
                } else {
                    character.setLocation(character.getX(), y);
                    characterIntersectsSkeleton();
                }
                takeGold();
                lostGame();
                generatePortal();
                break;

            case KeyEvent.VK_S:
                int y1 = character.getY() + chara.getSpeed();
                Rectangle r2 = new Rectangle(character.getX(), y1, character.getWidth(), character.getHeight());
                Rectangle XD = wallsXD.getBounds();
                character.setIcon(chara.getDownMove());

                if (r2.intersects(XD)){
                    character.setLocation(character.getX(), character.getY());
                } else {
                    character.setLocation(character.getX(), y1);
                    characterIntersectsSkeleton();
                }
                takeGold();
                lostGame();
                generatePortal();
                break;

            case KeyEvent.VK_A:
                int x = character.getX() - chara.getSpeed();
                Rectangle r3 = new Rectangle(x, character.getY(), character.getWidth(), character.getHeight());
                Rectangle YL = wallsYL.getBounds();
                character.setIcon(chara.getLeftMove());

                if (r3.intersects(YL)){
                    character.setLocation(character.getX(), character.getY());
                } else {
                    character.setLocation(x, character.getY());
                    characterIntersectsSkeleton();
                }
                takeGold();
                lostGame();
                generatePortal();
                break;

            case KeyEvent.VK_D:
                int x1 = character.getX() + chara.getSpeed();
                Rectangle r4 = new Rectangle(x1, character.getY(), character.getWidth(), character.getHeight());
                Rectangle YR = wallsYR.getBounds();
                character.setIcon(chara.getRightMove());

                if(r4.intersects(YR)){
                    character.setLocation(character.getX(), character.getY());
                } else {
                    character.setLocation(x1, character.getY());
                    characterIntersectsSkeleton();
                }
                takeGold();
                lostGame();
                generatePortal();
                break;
        }
    }
    private void characterIntersectsSkeleton() {

        this.skeleton = Tools.intersectsSkeleton(character, skeletons);
        Icon heartB = new ImageIcon("src/images/dungeon/heartBroken.gif");
        JLabel heart = Tools.deleteHearts(chara, hearts);

        if (this.skeleton != null) {
            if (canLoseLife) {
                heart.setIcon(heartB);
                javax.swing.Timer t = new Timer(1500, new HeartBrokenActionListener(panelTitle, heart));
                t.start();
                this.chara.setLive(this.chara.getLive() - 1);
                canLoseLife = false;

                javax.swing.Timer resetTimer = new Timer(2000, e -> canLoseLife = true);
                resetTimer.setRepeats(false);
                resetTimer.start();
            }
        }
    }

    private void takeGold(){
        JLabel gold;
        gold = Tools.intersectGold(character, golds);
        if (gold != null){
            this.golds.remove(gold);
            this.chara.setGold(chara.getGold() + 10);
            goldTitle.setText(chara.getGold() + "");
            gold.setIcon(goldGif);
            Timer t = new Timer(1500, new DeleteGoldActionListener(newPanel, gold));
            t.start();
        }
    }
    private void lostGame(){
        if (this.chara.getLive() <= 0){
            JOptionPane.showMessageDialog(newPanel, "Has perdido.");
            dataBase();
            System.exit(0);
        }
    }

    private void generatePortal(){
        if (this.chara.getGold() >= 50){
            Icon i = new ImageIcon("src/images/dungeon/portal.gif");
            labelPortal.setSize(80,89);
            labelPortal.setIcon(i);
            labelPortal.setLocation(900, 400);
            this.newPanel.add(labelPortal);
            this.newPanel.setComponentZOrder(labelPortal, 0);
            b.setComponentZOrder(labelPortal, 0);
            this.newPanel.repaint();
            winCase();
        }
    }

    private void winCase(){
        if (this.character.getBounds().intersects(labelPortal.getBounds())){
            JOptionPane.showMessageDialog(newPanel,"Has ganado!");
            dataBase();
            System.exit(0);
        }
    }

    private void dataBase(){
        String db = "jdbc:mysql://localhost:3306/jocRol";
        String user = "root";
        String passwd = "mysql";
        String insertQy = "insert into dades values (?, ?, ?, ?)";

        try {
            Connection c = DriverManager.getConnection(db, user, passwd);
            PreparedStatement ps = c.prepareStatement(insertQy);

            ps.setInt(1, 2);
            ps.setString(2, chara.getName());
            ps.setInt(3, chara.getGold());
            ps.setInt(4, chara.getLive());
            ps.executeUpdate();

            ps.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("La conexion ha fallado");
        }
    }
}


package Events;


import Tools.Tools;
import characters.*;
import characters.Character;

import javax.sound.midi.MidiFileFormat;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class InterEnteredHover extends MouseAdapter {
    JLabel inter;
    File clickedSound;
    File hoverSound;
    Clip clip;
    JPanel newPanel;
    JLabel b;
    int gold;
    Icon staticMove;
    Icon upMove;
    Icon rightMove;
    Icon leftMove;
    Icon downMove;
    List<Icon> items;
    Character chara;
    JLabel character;
    JPanel wallsXU;
    JPanel wallsXD;
    JPanel wallsYL;
    JPanel wallsYR;
    Icon attackUp;
    Icon attackDown;
    Icon attackRight;
    Icon attackLeft;
    Icon attackI;
    JLabel attackLabel;
    Skeleton skeleton;
    Timer timer;
    Timer movementSK;
    ArrayList<Skeleton> skeletons =  new ArrayList<>();
    JPanel panelTitle = new JPanel();
    ArrayList<JLabel> hearts = new ArrayList<>();
    ArrayList<JLabel> golds = new ArrayList<>();
    JLabel goldTitle;

    public InterEnteredHover(JLabel inter, JPanel newPanel, JLabel b,Character chara, JLabel character, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR) {
        this.inter = inter;
        this.clickedSound = new File("src/Sounds/clicked_sound.wav");
        this.hoverSound = new File("src/Sounds/hover_sound.wav");
        this.newPanel = newPanel;
        this.b = b;
        this.chara=chara;
        this.character = character;
        this.wallsXU = wallsXU;
        this.wallsXD = wallsXD;
        this.wallsYL = wallsYL;
        this.wallsYR = wallsYR;
        this.goldTitle = new JLabel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // playClickedSound();
        newPanel.removeAll();
        newPanel.repaint();
        createBackgroundMap(newPanel, b);

        if (inter.getText().equalsIgnoreCase("MAGICIAN")){
            chara = new Magician(gold, staticMove, upMove, rightMove, leftMove, downMove, items, attackUp, attackDown, attackRight, attackLeft, attackI, attackLabel);
            showCharacter(newPanel, chara, character);
        } else if (inter.getText().equalsIgnoreCase("PRIEST")){
            chara = new Priest(gold, staticMove, upMove, rightMove, leftMove, downMove, items, attackUp, attackDown, attackRight, attackLeft, attackI, attackLabel);
            showCharacter(newPanel, chara, character);
        } else if (inter.getText().equalsIgnoreCase("SOLDIER")){
            chara = new Soldier(gold, staticMove, upMove, rightMove, leftMove, downMove, items, attackUp, attackDown, attackRight, attackLeft, attackI, attackLabel);
            showCharacter(newPanel, chara, character);
        }
        panelTitle();
        timer = generateSkeletons();
        timer.start();
        attackCharacter();
        newPanel.setFocusable(true);
        newPanel.requestFocusInWindow();
        newPanel.addKeyListener(new MoveKeyListener(character, chara, newPanel, wallsXU, wallsXD, wallsYL, wallsYR, panelTitle, skeleton, hearts, skeletons, golds, goldTitle, b));
    }

    private void showCharacter(JPanel newPanel, Character chara, JLabel character) {
        character.setSize(32,32);
        character.setLocation(48,132);
        character.setIcon(chara.getDownMove());
        newPanel.add(character);

        newPanel.setComponentZOrder(character, 0);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        inter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //playHoverSound();
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // clip.stop();
        inter.setCursor(Cursor.getDefaultCursor());
    }
  /*  private void playHoverSound(){
        try {
            AudioInputStream a = AudioSystem.getAudioInputStream(hoverSound);
            clip = AudioSystem.getClip();
            clip.open(a);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
    private void playClickedSound(){
        clip.stop();
        try {
            AudioInputStream e = AudioSystem.getAudioInputStream(clickedSound);
            clip = AudioSystem.getClip();
            clip.open(e);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }*/
    private static void createBackgroundMap(JPanel newPanel, JLabel b){
        ImageIcon i = new ImageIcon("src/images/fondoMapa.jpg");

        Icon image = new ImageIcon(
                i.getImage().getScaledInstance(newPanel.getWidth(), newPanel.getHeight(), Image.SCALE_DEFAULT)
        );
        b.setIcon(image);
        b.setSize(newPanel.getSize());
        newPanel.add(b);
        newPanel.repaint();
        newPanel.setComponentZOrder(b, 0);
    }
    private Timer generateSkeletons(){
        return new Timer(3000, new GenerateSkeletonsListener(skeleton, wallsXU, wallsXD, wallsYL, wallsYR, newPanel, b, character, movementSK, chara, skeletons));
    }
    private void attackCharacter(){
        newPanel.setFocusable(true);
        newPanel.requestFocusInWindow();
        newPanel.addKeyListener(new AttackListener(skeleton, chara, character, wallsXU, wallsXD, wallsYL, wallsYR, newPanel, b, skeletons, golds, goldTitle));
    }
    private void panelTitle(){
        this.panelTitle.setLocation(0,0);
        this.panelTitle.setSize(1920, 100);
        this.panelTitle.setLayout(null);
        panelTitle.setBackground(new Color(255, 255, 255));
        panelTitle.setBorder(new LineBorder(Color.BLACK, 5));
        this.newPanel.add(panelTitle);
        this.newPanel.setComponentZOrder(this.panelTitle, 0);
        this.b.setComponentZOrder(this.panelTitle, 0);
        showHearts();
        showGold();
        showName();
    }
    private void showHearts(){
        int x = 600;
        int y = 0;
        for (int i = 0; i <chara.getLive() ; i++) {
            if (i >0){
                x=x+100;
            }
            Icon heartI = new ImageIcon("src/images/dungeon/heart.png");
            JLabel heart = new JLabel();
            heart.setSize(100,80);
            heart.setIcon(heartI);
            heart.setLocation(x + 400,y);
            hearts.add(heart);
            this.panelTitle.add(heart);
            this.panelTitle.revalidate();
            this.panelTitle.repaint();
        }
    }
    private void showGold(){
        Icon dollarTitle = new ImageIcon("src/images/dungeon/goldPanel.png");
        Font font = new Font("Arial", Font.PLAIN, 50);
        this.goldTitle.setSize(200,80);
        this.goldTitle.setLocation(520, 0);
        this.goldTitle.setIcon(dollarTitle);
        this.goldTitle.setText(chara.getGold() + "");
        this.goldTitle.setFont(font);
        this.goldTitle.setHorizontalAlignment(JLabel.RIGHT);
        this.goldTitle.setForeground(Color.BLACK);
        this.panelTitle.add(goldTitle);
        this.panelTitle.setComponentZOrder(goldTitle, 0);
        this.panelTitle.revalidate();
        this.panelTitle.repaint();
    }

    private void showName(){
        JLabel nameCharacter = new JLabel();
        Font italicFont = new Font("Serif", Font.ITALIC, 60);
        nameCharacter.setSize(400,64);
        nameCharacter.setLocation(150,0);
        nameCharacter.setText(chara.getName() + ":");
        nameCharacter.setFont(italicFont);
        this.panelTitle.add(nameCharacter);
        this.panelTitle.setComponentZOrder(nameCharacter, 0);
    }
}

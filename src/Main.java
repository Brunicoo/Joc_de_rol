import Events.InterEnteredHover;
import Events.PlayActionListener;
import Tools.Tools;
import javax.swing.*;
import java.awt.*;
import characters.Character;

public class  Main {
    JPanel panelMain;
    JPanel newPanel;
    JLabel messageWelcome;
    JButton play;
    JLabel inter = new JLabel();
    JLabel inter2 = new JLabel();
    JLabel inter3 = new JLabel();
    static JLabel b = new JLabel();
    JLabel character = new JLabel();
    Character chara;
    JPanel wallsXU = new JPanel();
    JPanel wallsXD = new JPanel();
    JPanel wallsYL = new JPanel();
    JPanel wallsYR = new JPanel();

    public Main() {
        panelMain = generatePanelMain();
        messageWelcome = generateLabelMessage(panelMain);
        play = createButtonPlay();
        panelMain.add(messageWelcome, 0);
        panelMain.add(play, 0);
        newPanel = createPanelRepainted();
        play.addMouseListener(new PlayActionListener(panelMain, newPanel));
        createInterface(newPanel, inter, inter2, inter3);
        showCharacters(newPanel, inter, chara, character, wallsXU, wallsXD, wallsYL, wallsYR);
        createNameCharacters(newPanel);
        inter.addMouseListener(new InterEnteredHover(inter, newPanel, b, chara, character, wallsXU, wallsXD, wallsYL, wallsYR));
        inter2.addMouseListener(new InterEnteredHover(inter2, newPanel,b, chara, character, wallsXU, wallsXD, wallsYL, wallsYR));
        inter3.addMouseListener(new InterEnteredHover(inter3, newPanel,b, chara, character, wallsXU, wallsXD, wallsYL, wallsYR));
        generateMap(newPanel, wallsXU, wallsXD, wallsYL, wallsYR);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("panelMain");
        Image iconImage = Tools.getToolkit().getImage("src/images/iconoJuego.jpg");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(Tools.getToolkit().getScreenSize());
        frame.setIconImage(iconImage);
    }
    private static JPanel generatePanelMain(){
        JPanel panelMain = new JPanel();
        panelMain.setLayout(null);
        ImageIcon icon = new ImageIcon("src/images/mainBackground.jpg");
        JLabel backgroundImage = new JLabel(icon);
        panelMain.setSize(Tools.getToolkit().getScreenSize());
        backgroundImage.setSize(Tools.getToolkit().getScreenSize());
        panelMain.add(backgroundImage);

        return panelMain;
    }
    private static JLabel generateLabelMessage(JPanel panelMain) {
        JLabel messageWelcome = new JLabel();
        messageWelcome.setText(" W " + " " + " " + " E " + "  " + " " + " L " + " " + " " + " C " + "  " + " " + " O " + " " + " " + " M " + "  " + " " + " E " + " " + " " +  " " + " " + " " +  " " + " " + " " +  " " + " T " + "  " + " " + " O " + " " + " " +" " + " " +  " " + " " + " " +  " " +  " E " + "  " + " " + " L " + " " + " " + " D " + "  " + " " + " O " + " " + " " + " R " + "  " + " " + " I " + " " + " " + " A ");
        messageWelcome.setLocation(150, 40);
        messageWelcome.setForeground(Color.WHITE);
        messageWelcome.setSize(panelMain.getWidth(), 40);
        messageWelcome.setFont(new Font("Arial Black",Font.ITALIC, 40));

        return messageWelcome;
    }
    private static JButton createButtonPlay(){
        JButton play = new JButton();
        play.setLayout(null);
        play.setText("PLAY");
        play.setBackground(Color.LIGHT_GRAY);
        play.setFocusPainted(false);
        play.setSize(100,80);
        play.setLocation(850, 600);

        return play;
    }
    private static JPanel createPanelRepainted(){
        JPanel newPanel = new JPanel();
        newPanel.setLocation(0,0);
        newPanel.setLayout(null);
        newPanel.setSize(Tools.getToolkit().getScreenSize());
        ImageIcon imageIcon = new ImageIcon("src/images/fondoPanel.png");
        JLabel background2 = new JLabel();
        background2.setSize(newPanel.getSize());
        Icon back=new ImageIcon(
                imageIcon.getImage().getScaledInstance(newPanel.getWidth(),newPanel.getHeight(),Image.SCALE_DEFAULT)
        );

        background2.setIcon(back);
        newPanel.add(background2);

        return newPanel;
    }
    private static void showCharacters(JPanel newPanel, JLabel inter, Character chara, JLabel character, JPanel wallsXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR){
        ImageIcon iconM = new ImageIcon("src/images/magician.png");
        ImageIcon iconS = new ImageIcon("src/images/soldier.png");
        ImageIcon iconP = new ImageIcon("src/images/priest.png");
        JLabel magician = new JLabel();
        JLabel soldier = new JLabel();
        JLabel priest = new JLabel();
        Color c = new Color(0,0,0, 0);

        magician.setLocation(inter.getX(), 140);
        magician.setSize(500, 500);
        magician.setIcon(iconM);
        magician.setText("MAGICIAN");
        magician.setForeground(c);
        newPanel.add(magician);
        soldier.setLocation(870, 140);
        soldier.setSize(magician.getSize());
        soldier.setIcon(iconS);
        soldier.setText("SOLDIER");
        soldier.setForeground(c);
        newPanel.add(soldier);
        priest.setLocation(1380, 260);
        priest.setSize(147,203);
        priest.setIcon(iconP);
        priest.setText("PRIEST");
        priest.setForeground(c);
        newPanel.add(priest);
        newPanel.setComponentZOrder(priest, 0);
        newPanel.setComponentZOrder(soldier, 0);
        newPanel.setComponentZOrder(magician, 0);

        magician.addMouseListener(new InterEnteredHover(magician, newPanel, b, chara, character, wallsXU, wallsXD, wallsYL, wallsYR));
        soldier.addMouseListener(new InterEnteredHover(soldier, newPanel, b, chara, character, wallsXU, wallsXD, wallsYL, wallsYR));
        priest.addMouseListener(new InterEnteredHover(priest, newPanel, b, chara, character, wallsXU, wallsXD, wallsYL, wallsYR));
    }
    private static void createInterface(JPanel newPanel, JLabel inter, JLabel inter2, JLabel inter3){
        ImageIcon imageIcon2 = new ImageIcon("src/images/interface.png");

        inter.setSize(300, 300);
        Icon image = new ImageIcon(
                imageIcon2.getImage().getScaledInstance(inter.getWidth(), inter.getHeight(), Image.SCALE_DEFAULT)
        );
        inter.setIcon(image);
        inter.setLocation(300,300);
        inter2.setSize(inter.getSize());
        inter2.setIcon(image);
        inter2.setLocation(inter.getX() + 500, inter.getY());
        inter3.setSize(inter.getSize());
        inter3.setIcon(image);
        inter3.setLocation(inter2.getX() + 500, inter.getY());

        inter.setText("MAGICIAN");
        inter2.setText("SOLDIER");
        inter3.setText("PRIEST");

        newPanel.add(inter);
        newPanel.add(inter2);
        newPanel.add(inter3);
        newPanel.repaint();
        newPanel.setComponentZOrder(inter, 0);
        newPanel.setComponentZOrder(inter2, 0);
        newPanel.setComponentZOrder(inter3, 0);
    }

    private static void createNameCharacters(JPanel newPanel){
        JLabel nameMagician = new JLabel();
        JLabel nameSoldier = new JLabel();
        JLabel namePriest = new JLabel();

        nameMagician.setText("MAGICIAN");
        nameMagician.setLocation(390, 515);
        nameMagician.setSize(200, 100);
        nameMagician.setForeground(Color.LIGHT_GRAY);
        nameMagician.setFont(new Font("Arial Black",Font.ITALIC, 20));
        nameSoldier.setText("SOLDIER");
        nameSoldier.setLocation(900, 515);
        nameSoldier.setSize(200, 100);
        nameSoldier.setForeground(Color.LIGHT_GRAY);
        nameSoldier.setFont(new Font("Arial Black", Font.ITALIC, 20));
        namePriest.setText("PRIEST");
        namePriest.setLocation(1410, 515);
        namePriest.setSize(200, 100);
        namePriest.setForeground(Color.LIGHT_GRAY);
        namePriest.setFont(new Font("Arial Black", Font.ITALIC, 20));

        newPanel.add(nameMagician);
        newPanel.add(nameSoldier);
        newPanel.add(namePriest);
        newPanel.repaint();
        newPanel.setComponentZOrder(nameMagician, 0);
        newPanel.setComponentZOrder(nameSoldier, 0);
        newPanel.setComponentZOrder(namePriest, 0);
    }
    private static void generateMap(JPanel newPanel, JPanel wallXU, JPanel wallsXD, JPanel wallsYL, JPanel wallsYR){
        createWallsXU(newPanel, wallXU);
        createWallsXD(newPanel, wallsXD);
        createWallsYL(newPanel, wallsYL);
        createWallsYR(newPanel, wallsYR);
        createFloor(newPanel);
    }

    private static void createWallsYR(JPanel newPanel, JPanel wallsYR) {
        int y = 100;
        JLabel wall;
        Icon iconWall = new ImageIcon("src/images/dungeon/wall.png");
        for (int i = 0; i <43 ; i++) {
            wall = new JLabel();
            wall.setIcon(iconWall);
            wall.setSize(16,16);
            wall.setLocation(1872,y+=16);
            newPanel.add(wall);
            newPanel.setComponentZOrder(wall, 0);
            b.setComponentZOrder(wall, 0);
        }
        wallsYR.setSize(16, 704);
        wallsYR.setLocation(1872,100);
        newPanel.add(wallsYR);
    } 

    private static void createWallsYL(JPanel newPanel, JPanel wallsYL) {
        int y = 100;
        JLabel wall;
        Icon iconWall = new ImageIcon("src/images/dungeon/wall.png");
        for (int i = 0; i <43 ; i++) {
            wall = new JLabel();
            wall.setIcon(iconWall);
            wall.setSize(16,16);
            wall.setLocation(16,y+=16);
            newPanel.add(wall);
            newPanel.setComponentZOrder(wall, 0);
            b.setComponentZOrder(wall, 0);
        }
        wallsYL.setSize(16, 704);
        wallsYL.setLocation(16,100);
        newPanel.add(wallsYL);
    }

    private static void createWallsXU(JPanel newPanel, JPanel wallsXU) {
        int x = 0;
        JLabel wall;
        Icon iconWall = new ImageIcon("src/images/dungeon/wall.png");
        for (int i = 0; i <117 ; i++) {
            wall = new JLabel();
            wall.setIcon(iconWall);
            wall.setSize(16,16);
            wall.setLocation((x+=16),100);
            newPanel.add(wall);
            newPanel.setComponentZOrder(wall, 0);
            b.setComponentZOrder(wall, 0);
        }
        wallsXU.setSize(1872, 16);
        wallsXU.setLocation(16,100);
        newPanel.add(wallsXU);
    }

    private static void createWallsXD(JPanel newPanel, JPanel wallsXD){
        int x = 0;
        JLabel wall;
        Icon iconWall = new ImageIcon("src/images/dungeon/wall.png");
        for (int i = 0; i <117 ; i++) {
            wall = new JLabel();
            wall.setIcon(iconWall);
            wall.setSize(16,16);
            wall.setLocation((x+=16),800);
            newPanel.add(wall);
            newPanel.setComponentZOrder(wall, 0);
            b.setComponentZOrder(wall, 0);
        }
        wallsXD.setSize(1872, 16);
        wallsXD.setLocation(16,800);
        newPanel.add(wallsXD);
    }

    private static void createFloor(JPanel newPanel){
        JLabel floor;
        Icon iconFloor = new ImageIcon("src/images/dungeon/floor.png");
        int x;
        int y = 100;
        for (int i = 0; i <43 ; i++) {
            y+=16;
            x=16;
            for (int j = 0; j <115 ; j++) {
                floor = new JLabel();
                floor.setIcon(iconFloor);
                floor.setSize(16,16);
                floor.setLocation(x+=16,y);
                newPanel.add(floor);
                newPanel.setComponentZOrder(floor,0);
                b.setComponentZOrder(floor,0);
            }
        }
    }
}

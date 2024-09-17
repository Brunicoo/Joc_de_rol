package Tools;

import characters.Character;
import characters.Skeleton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tools {
    static Toolkit toolkit = Toolkit.getDefaultToolkit();

    public static Toolkit getToolkit() {
        return toolkit;
    }

    public static Skeleton intersectsSkeleton(JLabel l, ArrayList<Skeleton> skeletons){
        int i = 0;
        while (i<skeletons.size()){
            if (l.getBounds().intersects(skeletons.get(i).getLabelSkeleton().getBounds())){
                return skeletons.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public static JLabel deleteHearts(Character chara, ArrayList<JLabel> hearts){
        JLabel heart;
        heart = hearts.get(chara.getLive() - 1);
        return heart;
    }

    public static JLabel intersectGold(JLabel character, ArrayList<JLabel> golds){
        int i = 0;

            while (i < golds.size()) {
                if (character.getBounds().intersects(golds.get(i).getBounds())) {
                    return golds.get(i);
                } else {
                    i++;
                }
            }
        return null;
    }

}

package oopassignment2;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Thilan
 */
public class Reel {

    private final Symbol seven = new Symbol(resizeImage(new ImageIcon(getClass().getResource("/oopassignment2/images/redseven.png"))), 7);
    private final Symbol bell = new Symbol(resizeImage(new ImageIcon(getClass().getResource("/oopassignment2/images/bell.png"))), 6);
    private final Symbol watermelon = new Symbol(resizeImage(new ImageIcon(getClass().getResource("/oopassignment2/images/watermelon.png"))), 5);
    private final Symbol plum = new Symbol(resizeImage(new ImageIcon(getClass().getResource("/oopassignment2/images/plum.png"))), 4);
    private final Symbol lemon = new Symbol(resizeImage(new ImageIcon(getClass().getResource("/oopassignment2/images/lemon.png"))), 3);
    private final Symbol cherry = new Symbol(resizeImage(new ImageIcon(getClass().getResource("/oopassignment2/images/cherry.png"))), 2);
 

    public Symbol[] spin() {
        int[] arrRand = new int[6];
        Symbol[] arrSymbol = new Symbol[6];
        int count = 0;
        int num;
        Random r = new Random();

        while (count < arrRand.length) {
            num = r.nextInt(6) + 2;
            boolean repeat = false;
            do {
                for (int i = 0; i < arrRand.length; i++) {
                    if (num == arrRand[i]) {
                        repeat = true;
                        break;
                    } else if (i == count) {
                        arrRand[count] = (num);
                        count++;
                        repeat = true;
                        break;
                    }

                }
            } while (!repeat);

        }
        int j = 0;
        for (int i : arrRand) {
            arrSymbol[j] = getSymbol(i);
            j++;
        }
        return arrSymbol;
    }

  

    public Symbol getSymbol(int num) {
        Symbol s = new Symbol();
        switch (num) {
            case 2:
                s = getSeven();

                break;
            case 3:
                s = getBell();

                break;
            case 4:
                s = getWatermelon();

                break;
            case 5:
                s = getPlum();

                break;
            case 6:
                s = getLemon();

                break;
            case 7:
                s = getCherry();

                break;
        }
        return s;
    }

    /**
     * @return the seven
     */
    public Symbol getSeven() {
        return seven;
    }

    /**
     * @return the bell
     */
    public Symbol getBell() {
        return bell;
    }

    /**
     * @return the watermelon
     */
    public Symbol getWatermelon() {
        return watermelon;
    }

    /**
     * @return the plum
     */
    public Symbol getPlum() {
        return plum;
    }

    /**
     * @return the lemon
     */
    public Symbol getLemon() {
        return lemon;
    }

    /**
     * @return the cherry
     */
    public Symbol getCherry() {
        return cherry;
    }

    private ImageIcon resizeImage(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}

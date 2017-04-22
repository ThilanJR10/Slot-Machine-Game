
package oopassignment2;

import javax.swing.ImageIcon;

/**
 *
 * @author Thilan
 */
public class Symbol implements ISymbol{

    private ImageIcon image;
    private int value;

    public Symbol() {
    }

    public Symbol(ImageIcon image, int value) {
        this.image = image;
        this.value = value;
    }

    

    @Override
    public ImageIcon getImage() {
        return image;
    }

   
    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    
    @Override
    public int getValue() {
        return value;
    }

    
    @Override
    public void setValue(int value) {
        this.value = value;
    }
    

}

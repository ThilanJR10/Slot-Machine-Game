
package oopassignment2.pieChart;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 *
 * @author Thilan
 */
public class PieComponent extends JComponent {

    private Slice[] slices;

    public PieComponent(Slice[] slices) {
        this.slices=slices;
    }

    @Override
    public void paint(Graphics g) {
        drawPie((Graphics2D) g, getBounds(), slices);
    }

    void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;
        for (Slice slice : slices) {
            total += slice.value;
        }

        double curValue = 0.0D;
        int startAngle = 0;
        for (Slice slice : slices) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slice.value * 360 / total);
            g.setColor(slice.color);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += slice.value;
            

        }
    }
}

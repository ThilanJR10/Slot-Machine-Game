
package oopassignment2.pieChart;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Thilan
 */
public class PieChartDialog extends JDialog {

    private Slice[] slices;

    public PieChartDialog(Frame parent, boolean modal, Slice[] slices) {
        super(parent, modal);
        this.slices = slices;
        init();
    }

    public void init() {
        setSize(600, 600);
        setTitle("Pie Chart");
        setLocationRelativeTo(null);
        getContentPane().add("Center",new PieComponent(slices));
        JPanel Panel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel wl = new JLabel("Wins");
        JLabel lj = new JLabel("Loses");
        JTextField wt = new JTextField(slices[0].value+"");
        wt.setEnabled(false);
        wt.setBackground(Color.GREEN);
        
        JTextField lt = new JTextField(slices[1].value+"");
        lt.setEnabled(false);
        lt.setBackground(Color.RED);
        Panel.add(wl);
        Panel.add(wt);
        Panel.add(lj);
        Panel.add(lt);
        add("South",Panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

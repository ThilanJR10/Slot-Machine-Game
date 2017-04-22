/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment2;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import oopassignment2.pieChart.PieChartDialog;
import oopassignment2.pieChart.Slice;

/**
 *
 * @author Thilan
 */
public class StatisticsDialog extends JDialog {

    private int wins;
    private int loses;
    private double avg;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JLabel lbWinsName;
    private JLabel lbLostName;
    private JLabel lbWins;
    private JLabel lbLost;
    private JLabel lbAvgName;
    private JLabel lbAvg;
    private File f;
    private PrintWriter printWriter = null;
    private FileWriter fileWriter = null;
    private JButton btPrint;
    private JButton btPieChart;
    private Frame parent;

    public StatisticsDialog(int wins, int loses, double avg, Frame parent, boolean modal) {
        super(parent, modal);
        this.wins = wins;
        this.loses = loses;
        this.avg = avg;
        this.parent=parent;
        init();

    }

    private void init() {
        setTitle("Statistics");

        leftPanel = new JPanel(new GridLayout(3, 1));
        rightPanel = new JPanel(new GridLayout(3, 1));

        lbWinsName = new JLabel("Wins : ");
        JPanel lbWinsNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbWinsNamePanel.add(lbWinsName);
        leftPanel.add(lbWinsNamePanel);

        lbWins = new JLabel(wins + "");
        JPanel lbWinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbWinPanel.add(lbWins);
        rightPanel.add(lbWinPanel);

        lbLostName = new JLabel("Lost : ");
        JPanel lbLostNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbLostNamePanel.add(lbLostName);
        leftPanel.add(lbLostNamePanel);

        lbLost = new JLabel(loses + "");
        JPanel lbLostPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbLostPanel.add(lbLost);
        rightPanel.add(lbLostPanel);

        lbAvgName = new JLabel("Avarage credit netted : ");
        JPanel lbAvgNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbAvgNamePanel.add(lbAvgName);
        leftPanel.add(lbAvgNamePanel);

        lbAvg = new JLabel(avg + "");
        JPanel lbAvgPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbAvgPanel.add(lbAvg);
        rightPanel.add(lbAvgPanel);

        add("West", leftPanel);
        add("Center", rightPanel);

        btPrint = new JButton("Print Statics");
        btPieChart = new JButton("View Pie Chart");

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnPanel.add(btPieChart);
        btnPanel.add(btPrint);
        add("South", btnPanel);
        String value = "Wins : " + wins + "  Lost : " + loses + "   Avarage credit netted : " + avg + "";

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        f = new File(timeStamp + ".txt");

        btPieChart.addActionListener((ActionEvent evt) -> {
                Slice [] slices = { new Slice(wins, Color.GREEN,"Wins"),new Slice(loses, Color.RED,"Lose")};
                  PieChartDialog dialog = new PieChartDialog(parent,true,slices);
            dialog.setVisible(true);
        });

        btPrint.addActionListener((ActionEvent evt) -> {
            try {

                fileWriter = new FileWriter(f, false);

                printWriter = new PrintWriter(fileWriter, true);

                printWriter.println(value);//write string value to txt file

            } catch (FileNotFoundException e) {

                System.out.println(e.getMessage());

            } catch (IOException e) {

                System.out.println(e.getMessage());

            } finally {

                try {

                    fileWriter.close(); // close the file writer

                } catch (IOException e) {

                    System.out.println(e.getMessage());

                }

            }
            JOptionPane.showMessageDialog(this, "Saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        });
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

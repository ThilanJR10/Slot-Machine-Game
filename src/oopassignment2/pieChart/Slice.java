/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignment2.pieChart;

import java.awt.Color;

/**
 *
 * @author Thilan
 */
public class Slice {

    double value;
    Color color;
    String name;

    public Slice(double value, Color color,String name) {
        this.value = value;
        this.color = color;
        this.name=name;
    }
}

package com.company;

import java.awt.*;

/**
 * a class that creates a shape(polygon) based on coordonates, radius, and a number of sides
 * the class extends the Polygon class
 */
public class RegularPolygon extends Polygon {

    public RegularPolygon(int x0, int y0, int radius, int sides) {

        double alpha=2 * Math.PI / sides;
        for (int i = 0; i < sides; i++){
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x,(int) y);
        }
    }
}

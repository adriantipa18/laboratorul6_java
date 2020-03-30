package com.company;

import java.awt.geom.Ellipse2D;

/**
 * a class that creates a shape(a circle) based on coordonates and radius
 * the class extends the Ellipse2D.Double class
 */


public class NodeShape extends Ellipse2D.Double {
    public NodeShape(double x0, double y0, double radius) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
    }
}

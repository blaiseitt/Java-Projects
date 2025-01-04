package pl.dmcs.chartsfromcsv;

import org.apache.batik.svggen.SVGGraphics2D;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.lang.reflect.Field;

public class ChartUtils {

    private SVGGraphics2D g;

    public ChartUtils() {
    }

    public void drawPoint(double x, double y, double xmin, double ymin, double xmax, double ymax, String c) {
        if (x <= xmax && x >= xmin && y <= ymax && x >= ymin) {
            Shape circle = new Ellipse2D.Double(48, 547, 10, 10);

            Color color;
            try {
                Field field = Class.forName("java.awt.Color").getField(c);
                color = (Color) field.get(null);
            } catch (Exception e) {
                color = null;
            }
            double XCoefficient = 500 / ((xmax - xmin));
            double YCoefficient = 500 / ((ymax - ymin));

            x = (xmin - x) * XCoefficient;
            y = (ymin - y) * YCoefficient;

            g.setPaint(color);
            g.translate(-x, y);
            g.fill(circle);
            g.translate(x, -y);
        }
    }

    public void drawAndDescribeAxis(double minX, double minY, double maxX, double maxY, String Yaxis, String Xaxis, String title) {
        Shape Yline = new Line2D.Double(50, 50, 50, 550);
        Shape Xline = new Line2D.Double(50, 550, 550, 550);
        g.setPaint(Color.black);

        g.draw(Yline);
        g.draw(Xline);
        g.drawString(Yaxis, 5, 275);
        g.drawString(title, 275, 20);
        g.drawString(Xaxis, 275, 570);

        g.drawString(String.valueOf(minX), 5, 550);
        g.drawString(String.valueOf(minY), 50, 570);
        g.drawString(String.valueOf(maxX), 550, 550);
        g.drawString(String.valueOf(maxY), 5, 70);
    }

    public void setSVGGraphisc(SVGGraphics2D g) {
        this.g = g;
    }
}

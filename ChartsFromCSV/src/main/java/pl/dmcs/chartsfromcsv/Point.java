package pl.dmcs.chartsfromcsv;

import java.util.ArrayList;
import java.util.List;

public class Point {

    public Point() {

    }

    public Point(double x, double y) {
        this.xValue = x;
        this.yValue = y;
    }

    private double xValue;
    private double yValue;

    static List<String> getLabels(List<List<String>> valuesFromCSV) {
        List<String> labels = new ArrayList<>();

        if (!isNumeric(String.valueOf(valuesFromCSV.get(0).get(0)))) {
            String label = String.valueOf(valuesFromCSV.get(0).get(0));
            labels.add(label);
            label = String.valueOf(valuesFromCSV.get(0).get(1));
            labels.add(label);
        }
        return labels;
    }

    static List<Point> transformFunction(List<List<String>> valuesFromCSV) {
        List<Point> points = new ArrayList<>();
        if (!isNumeric(String.valueOf(valuesFromCSV.get(0).get(0)))) {
            for (int i = 1; i < valuesFromCSV.size(); i++) {
                Point point = new Point(Double.valueOf(valuesFromCSV.get(i).get(0)), Double.valueOf(valuesFromCSV.get(i).get(1)));
                points.add(point);
            }
            return points;
        }
        for (int i = 0; i < valuesFromCSV.size(); i++) {
            Point point = new Point(Double.valueOf(valuesFromCSV.get(i).get(0)), Double.valueOf(valuesFromCSV.get(i).get(1)));
            points.add(point);
        }
        return points;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public double getxValue() {
        return xValue;
    }

    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double yValue) {
        this.yValue = yValue;
    }
}
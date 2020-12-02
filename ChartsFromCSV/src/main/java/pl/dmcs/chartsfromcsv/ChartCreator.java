package pl.dmcs.chartsfromcsv;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import javax.swing.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class ChartCreator {

    private Parameters parameters;
    private CSVReader csvReader;
    private SVGSaver svgSaver;
    private ChartUtils chartUtils;
    private SVGGraphics2D graphics2D;
    private SVGDocument doc;

    public ChartCreator() {

    }

    public ChartCreator(Parameters parameters, ChartUtils chartUtils) {
        this.parameters = parameters;
        this.csvReader = new CSVReader();
        this.svgSaver = new SVGSaver();

        DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        this.doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
        this.graphics2D = new SVGGraphics2D(doc);
        this.chartUtils = chartUtils;
        chartUtils.setSVGGraphisc(graphics2D);
    }

    public void create() throws Exception {

        List<List<String>> listOfPointsFromCSV = csvReader.readCSV(parameters.data);
        List<Point> listOfPoints;
        if (listOfPointsFromCSV.size() != 0) {
            List<String> listOfLabels = Point.getLabels(listOfPointsFromCSV);
            listOfPoints = Point.transformFunction(listOfPointsFromCSV);
        } else {
            listOfPoints = new ArrayList<>();
        }


        double minX, minY, maxX, maxY;
        minX = parameters.xMin.doubleValue();
        minY = parameters.yMin.doubleValue();
        maxX = parameters.xMax.doubleValue();
        maxY = parameters.yMax.doubleValue();
        chartUtils.drawAndDescribeAxis(minX, minY, maxX, maxY, parameters.yLabel, parameters.xLabel, parameters.title);

        for (int i = 0; i < listOfPoints.size(); i++) {
            Point p = listOfPoints.get(i);
            double x = p.getxValue();
            double y = p.getyValue();
            chartUtils.drawPoint(x, y, minX, minY, maxX, maxY, "red");
        }

        graphics2D.setSVGCanvasSize(new Dimension(600, 600));

        Element root = doc.getDocumentElement();
        graphics2D.getRoot(root);

        JSVGCanvas canvas = new JSVGCanvas();
        JFrame f = new JFrame("Chart");
        f.setPreferredSize(new Dimension(650, 650));
        f.getContentPane().add(canvas);
        canvas.setSVGDocument(doc);
        f.pack();
        f.setVisible(true);
        String docAsString = convertDocumentToString(doc);

        svgSaver.save(docAsString, parameters.chart);
    }

    public String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

}

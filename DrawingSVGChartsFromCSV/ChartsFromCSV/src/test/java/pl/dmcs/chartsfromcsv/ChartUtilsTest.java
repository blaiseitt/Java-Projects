package pl.dmcs.chartsfromcsv;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.swing.JSVGCanvas;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChartUtilsTest {

    private static final String RESOURCE_PATH = "target/test-classes/ChartUtilsTestResources/";
    private ChartCreator chartCreator = new ChartCreator();
    private ChartUtils chartUtils = new ChartUtils();
    private SVGDocument document = svgDocument();
    private SVGGraphics2D svgGraphics2D = new SVGGraphics2D(document);

    @Test
    void testDrawAndDescribeAxis() throws Exception {
        chartUtils.setSVGGraphisc(svgGraphics2D);
        chartUtils.drawAndDescribeAxis(0, 0, 200, 200, "TestY", "TestX", "Test");
        CreateSVGForComparision();
        String documentAsString = chartCreator.convertDocumentToString(document);
        String svgAsAsString = getSVGAsString("OnlyAxisSVG");
        assertEquals(svgAsAsString, documentAsString);
    }

    @Test
    void testDrawPoints() throws Exception {
        chartUtils.setSVGGraphisc(svgGraphics2D);
        double[][] points = {{-50, 20}, {0, 0}, {30, 30}, {50, 50}, {70, 20}, {10, 90}, {-90, -50}};
        for (int i = 0; i < points.length; i++) {
            chartUtils.drawPoint(points[i][0], points[i][1], -100, -100, 100, 100, "red");
        }
        CreateSVGForComparision();
        String documentAsString = chartCreator.convertDocumentToString(document);
        String svgAsAsString = getSVGAsString("PointsOnlySVG");
        assertEquals(svgAsAsString, documentAsString);
    }


    private String getSVGAsString(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(RESOURCE_PATH + path + ".svg")), StandardCharsets.UTF_8);
    }

    private SVGDocument svgDocument() {
        DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
        String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
        SVGDocument doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
        return doc;
    }

    private void CreateSVGForComparision() {
        svgGraphics2D.setSVGCanvasSize(new Dimension(600, 600));

        Element root = document.getDocumentElement();
        svgGraphics2D.getRoot(root);

        JSVGCanvas canvas = new JSVGCanvas();
        JFrame f = new JFrame("Chart");
        f.setPreferredSize(new Dimension(650, 650));
        f.getContentPane().add(canvas);
        canvas.setSVGDocument(document);
        f.pack();
        f.setVisible(false);
    }
}

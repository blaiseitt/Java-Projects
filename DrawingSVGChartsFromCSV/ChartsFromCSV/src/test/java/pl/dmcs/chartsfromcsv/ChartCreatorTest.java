package pl.dmcs.chartsfromcsv;

import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.svg.SVGDocument;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChartCreatorTest {

    private static final String DATA_PATH = "target/test-classes/ChartCreatorResources/";
    private static final String TARGET_PATH = "target/";

    private ChartCreator chartCreator;
    private ChartUtils mockedChartUtils = mock(ChartUtils.class);
    private ChartUtils chartUtils = new ChartUtils();

    @Test
    void testCreatChartFromDataWithoutLabels() throws Exception {
        testCreateChartWithMockedChartUtils(DATA_PATH + "JustData.csv", "JDChart", "JDChart", "X", "Y", 0, 150, 0, 150, 6);
        verify(mockedChartUtils).drawAndDescribeAxis(0, 0, 150, 150, "Y", "X", "JDChart");

        verify(mockedChartUtils).drawPoint(1, 2, 0, 0, 150, 150, "red");
        verify(mockedChartUtils).drawPoint(3, 5, 0, 0, 150, 150, "red");
        verify(mockedChartUtils).drawPoint(20, 50, 0, 0, 150, 150, "red");
        verify(mockedChartUtils).drawPoint(11, 22, 0, 0, 150, 150, "red");
        verify(mockedChartUtils).drawPoint(33, 41, 0, 0, 150, 150, "red");
        verify(mockedChartUtils).drawPoint(55, 112, 0, 0, 150, 150, "red");
    }

    @Test
    void testCreateChartFromDataWithLabels() throws Exception {
        testCreateChartWithMockedChartUtils(DATA_PATH + "Force.csv", "ForceChart", "ForceChart", "X", "Y", 0, 1000, 0, 1000, 4);

        verify(mockedChartUtils).drawAndDescribeAxis(0, 0, 1000, 1000, "Y", "X", "ForceChart");

        verify(mockedChartUtils).drawPoint(1, 10, 0, 0, 1000, 1000, "red");
        verify(mockedChartUtils).drawPoint(10, 100, 0, 0, 1000, 1000, "red");
        verify(mockedChartUtils).drawPoint(20, 200, 0, 0, 1000, 1000, "red");
        verify(mockedChartUtils).drawPoint(50, 500, 0, 0, 1000, 1000, "red");
    }

    @Test
    void testDrawAxisAndPoints() throws Exception {
        testCreateChart(DATA_PATH + "JustData.csv", "JDChartActual", "JDChart", "X", "Y", 0, 150, 0, 150, "JDChart");
        testCreateChart(DATA_PATH + "Force.csv", "ForceChartActual", "ForceChart", "X", "Y", 0, 1000, 0, 1000, "ForceChart");
    }

    private void testCreateChartWithMockedChartUtils(String data, String chart, String title, String xLabel, String yLabel, Integer xMin, Integer xMax,
                                                     Integer yMin, Integer yMax, int numberOfPoints) throws Exception {
        Parameters parameters = new Parameters(data, chart, title, xLabel, yLabel, xMin, xMax, yMin, yMax);

        chartCreator = new ChartCreator(parameters, mockedChartUtils);
        chartCreator.create();
        verify(mockedChartUtils, times(1)).drawAndDescribeAxis(anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyString(), anyString(), anyString());
        verify(mockedChartUtils, times(numberOfPoints)).drawPoint(anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyString());
    }

    private void testCreateChart(String data, String chart, String title, String xLabel, String yLabel, Integer xMin, Integer xMax,
                                 Integer yMin, Integer yMax, String path) throws Exception {
        Parameters parameters = new Parameters(data, chart, title, xLabel, yLabel, xMin, xMax, yMin, yMax);
        chartCreator = new ChartCreator(parameters, chartUtils);
        chartCreator.create();
        String expectedImage = getSVGAsString(DATA_PATH + path);
        String actualImage = getSVGAsString(TARGET_PATH + chart);
        assertEquals(expectedImage, actualImage);

        URL location = CSVReader.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = location.getFile().replace("classes/", "") + DATA_PATH + chart + ".svg";
        File file = new File(filePath);
        file.delete();
    }

    private String getSVGAsString(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path + ".svg")), StandardCharsets.UTF_8);
    }
}

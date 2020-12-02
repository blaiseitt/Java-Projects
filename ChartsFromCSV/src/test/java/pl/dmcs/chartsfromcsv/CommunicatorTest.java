package pl.dmcs.chartsfromcsv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommunicatorTest {


    private Communicator communicator = new Communicator();

    @Test
    void testGetParameters() throws Exception {
        Parameters expectedParameters1 = new Parameters("target/test-classes/CommunicatorResources/chart1.csv", "Chart1", "Title", "X",
                "Y", 0, 100, 0, 100);
        String[] input1 = {"-data",
                "target/test-classes/CommunicatorResources/chart1.csv", "-chart", "Chart1", "-title", "Title", "-xlabel", "X", "-ylabel", "Y", "-xmin", "0",
                "-xmax", "100", "-ymin", "0", "-ymax", "100"};

        Parameters expectedParameters2 = new Parameters("target/test-classes/CommunicatorResources/chart3.csv", "Wykres3", "Tytuł", "Iks",
                "Igrek", -20, 111, -111, 20);
        String[] input2 = {"-data",
                "target/test-classes/CommunicatorResources/chart3.csv", "-chart", "Wykres3", "-title", "Tytuł", "-xlabel", "Iks", "-ylabel", "Igrek", "-xmin", "-20",
                "-xmax", "111", "-ymin", "-111", "-ymax", "20"};

        testCommunicator(expectedParameters1, input1);
        testCommunicator(expectedParameters2, input2);
    }

    @Test
    void testGetParametersIfCSVWithLabels() throws Exception {
        Parameters expectedParameters = new Parameters("target/test-classes/CommunicatorResources/Chart2.csv", "Chart2", "Droga", "Czas",
                "Predkosc", 500, 1000, 500, 1000);
        String[] input = {"-data",
                "target/test-classes/CommunicatorResources/Chart2.csv", "-chart", "Chart2", "-title", "Droga", "-xlabel", "Czas", "-ylabel", "Predkosc", "-xmin", "500",
                "-xmax", "1000", "-ymin", "500", "-ymax", "1000"};
        
        testCommunicator(expectedParameters, input);
    }

    @Test
    void testInvalidParametersExceptions() {
        String[] input1 = {"-data", "target/test-classes/CommunicatorResources/chart1.csv", "-chart", "Chart1", "-title", "Title", "-xlabel", "X", "-ylabel", "Y", "-xmin", "0",
                "-xmax", "100", "-ymin", "0", "-ymax", "zZz"};
        testCommunicatorException(input1, "For input string: \"zZz\"");

        String[] input2 = {"-data", "target/test-classes/CommunicatorResources/chart1.csv", "-chart", "123", "-title", "Title", "-xlabel", "X", "-ylabel", "Y", "-xmin", "prr",
                "-xmax", "100", "-ymin", "0", "-ymax", "zZz"};
        testCommunicatorException(input2, "For input string: \"prr\"");
    }

    @Test
    void testMissingParameterException() {
        String[] input1 = {"-data", "target/test-classes/CommunicatorResources/chart1.csv", "-xlabel", "X", "-ylabel", "Y", "-xmin", "0",
                "-xmax", "100", "-ymin", "0", "-ymax", "zZz"};
        testCommunicatorException(input1, "Missing required options: chart, title");

        String[] input2 = {"target/test-classes/CommunicatorResources/chart1.csv", "-chart", "123", "-title", "Title", "-xlabel", "X", "-ylabel", "Y", "prr",
                "-xmax", "100", "-ymin", "0", "-ymax", "zZz"};
        testCommunicatorException(input2, "Missing required options: data, xmin");
    }

    private void testCommunicator(Parameters expected, String[] input) throws Exception {
        Parameters realParameters = communicator.getParameters(input);
        assertEquals(realParameters.data, expected.data);
        assertEquals(realParameters.chart, expected.chart);
        assertEquals(realParameters.title, expected.title);
        assertEquals(realParameters.xLabel, expected.xLabel);
        assertEquals(realParameters.yLabel, expected.yLabel);
        assertEquals(realParameters.xMin, expected.xMin);
        assertEquals(realParameters.xMax, expected.xMax);
        assertEquals(realParameters.yMin, expected.yMin);
        assertEquals(realParameters.yMax, expected.yMax);
    }

    private void testCommunicatorException(String[] input, String exceptionMessage) {
        Exception e = assertThrows(Exception.class, () -> communicator.getParameters(input));
        assertEquals(exceptionMessage, e.getMessage());
    }
}

package pl.dmcs.chartsfromcsv;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerTest {

    private static final String TARGET_PATH = "target/";
    private static final String DATA_PATH = "target/test-classes/ChartCreatorResources/";

    @Test
    void testProperControllerWork() throws Exception {
        String[] input1 = {"-data", "target/test-classes/ChartCreatorResources/Force.csv", "-chart", "ForceChart", "-title", "ForceChart", "-xlabel", "X", "-ylabel", "Y", "-xmin", "0",
                "-xmax", "1000", "-ymin", "0", "-ymax", "1000"};
        testController(input1, "ForceChart");

        String[] input2 = {"-data", "target/test-classes/ChartCreatorResources/JustData.csv", "-chart", "JDChart", "-title", "JDChart", "-xlabel", "X", "-ylabel", "Y", "-xmin", "0",
                "-xmax", "150", "-ymin", "0", "-ymax", "150"};
        testController(input2, "JDChart");
    }

    @Test
    void testMissingParametersException() throws Exception {
        String[] input = {"zzz", "ess"};
        testCommunicatorException(input, "Missing required options: data, chart, title, xlabel, ylabel, xmin, xmax, ymin, ymax");

        String[] input2 = {"-data", "target/test-classes/CommunicatorResources/chart1.csv",
                "Chart1", "-title", "Title", "-xlabel", "X", "-ylabel", "Y", "-xmin", "0", "-xmax", "100", "-ymin", "0", "-ymax", "100"};
        testCommunicatorException(input2, "Missing required option: chart");
    }

    @Test
    void testControllerFileNotFoundException() throws Exception {
        String[] input2 = {"-data", "target/rrr", "-chart", "ForceChart", "-title", "ForceChart",
                "-xlabel", "X", "-ylabel", "Y", "-xmin", "0", "-xmax", "1000", "-ymin", "0", "-ymax", "1000"};
        testCommunicatorException(input2, "File not found");
    }

    private void testController(String[] input, String path) throws Exception {
        Controller.main(input);
        String expectedImage = getSVGAsString(DATA_PATH + path);
        String actualImage = getSVGAsString(TARGET_PATH + path);
        assertEquals(expectedImage, actualImage);

        URL location = CSVReader.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = location.getFile().replace("classes/", "") + DATA_PATH + path + ".svg";
        File file = new File(filePath);
        file.delete();
    }

    private void testCommunicatorException(String[] input, String exceptionMessage) {
        Exception e = assertThrows(Exception.class, () -> Controller.main(input));
        assertEquals(exceptionMessage, e.getMessage());
    }

    private String getSVGAsString(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(path + ".svg")), StandardCharsets.UTF_8);
    }
}

package pl.dmcs.chartsfromcsv;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SVGSaverTest {
    private SVGSaver svgSaver = new SVGSaver();
    private static final String RESOURCE_PATH = "target/test-classes/SVGsForComparision/";
    private static final String SAVE_PATH = "test-classes/SVGsForComparision/";

    @Test
    void testSaveSVG() throws Exception {
        testSave(getSVGAsString("OnlyAxis"), "OnlyAxisTest");
        testSave(getSVGAsString("ChartWithContent"), "ChantWithContent");
    }

    private void testSave(String svgAsString, String path) throws Exception {
        svgSaver.save(svgAsString, SAVE_PATH + path);

        String savedSVGAsString = getSVGAsString(path);

        assertEquals(svgAsString, savedSVGAsString);

        URL location = CSVReader.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = location.getFile().replace("classes/", "") + SAVE_PATH + path + ".svg";
        File file = new File(filePath);
        file.delete();
    }

    private String getSVGAsString(String path) throws Exception {
        return new String(Files.readAllBytes(Paths.get(RESOURCE_PATH + path + ".svg")), StandardCharsets.UTF_8);
    }
}

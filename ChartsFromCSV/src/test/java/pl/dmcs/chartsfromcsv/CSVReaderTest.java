package pl.dmcs.chartsfromcsv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVReaderTest {

    private CSVReader csvReader = new CSVReader();
    private static final String RESOURCE_PATH = "target/test-classes/";


    @Test
    public void testEmptyCSV() throws Exception {
        List<List<String>> emptyList = new ArrayList<>();
        loadCSV(emptyList, "CSVReaderResources/Emptysheet.csv");
    }

    @Test
    void testCSVWithoutHeaders() throws Exception {
        String[][] expectedArray1 = new String[][]{{"0.0", "20"}, {"1.5", "40"}, {"3.0", "50"}, {"4.5", "55"}};
        List<List<String>> expected1 = transformArrayToList(expectedArray1);
        loadCSV(expected1, "CSVReaderResources/Data.csv");

        String[][] expectedArray2 = new String[][]{{"1", "2"}, {"3", "5"}, {"53", "33"}, {"22", "31"}, {"6.2", "3.2"}, {"6.1", "3.3"}};
        List<List<String>> expected2 = transformArrayToList(expectedArray2);
        loadCSV(expected2, "CSVReaderResources/Data2.csv");
    }

    @Test
    void testCSVWithHeaders() throws Exception {
        String[][] expectedArray1 = new String[][]{{"Time", "Temperature"}, {"0.0", "20"}, {"1.5", "40"}, {"3.0", "50"}, {"4.5", "55"}};
        List<List<String>> expected = transformArrayToList(expectedArray1);
        loadCSV(expected, "CSVReaderResources/DataWithHeader.csv");

        String[][] expectedArray2 = new String[][]{{"Time spent learning", "Efficency"}, {"1", "80"}, {"5", "100"}, {"10", "100"}, {"20", "90"}, {"30", "80"}, {"45", "70"}};
        List<List<String>> expected2 = transformArrayToList(expectedArray2);
        loadCSV(expected2, "CSVReaderResources/DataWithHeader2.csv");
    }

    private void loadCSV(List<List<String>> expected, String path) throws Exception {
        List<List<String>> loaded = csvReader.readCSV(RESOURCE_PATH + path);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), loaded.get(i));
        }
    }

    private List<List<String>> transformArrayToList(String[][] data) {
        List<String> temp;
        List<List<String>> outputList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            temp = Arrays.asList(data[i]);
            outputList.add(temp);
        }
        return outputList;
    }
}

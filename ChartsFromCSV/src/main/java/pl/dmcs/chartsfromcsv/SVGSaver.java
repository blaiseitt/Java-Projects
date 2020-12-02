package pl.dmcs.chartsfromcsv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class SVGSaver {

    public void save(String doc, String filePath) throws IOException {

        URL location = CSVReader.class.getProtectionDomain().getCodeSource().getLocation();
        String path = location.getFile().replace("classes/", "") + filePath + ".svg";
        File file = new File(path);
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(doc);
        writer.close();
    }
}

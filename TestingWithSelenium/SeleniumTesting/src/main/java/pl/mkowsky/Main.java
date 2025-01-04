package pl.mkowsky;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.ListIterator;

public class Main {
    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public static void main(String[] args) throws Exception {

        DataInitializer dataInitializer = new DataInitializer();
        Params params = dataInitializer.getCommandLineParams(args);
        List<String> brokenURLs = BrokenLinks.lookForBrokenLinks(params.homePage, params.checkSubPages);
        reportLinks(brokenURLs);

    }

    static void reportLinks(List<String> brokenURLs)  {
        ListIterator<String> brokenUrlsIterator = brokenURLs.listIterator();

        if (!brokenURLs.isEmpty()) {
            System.out.println("\n\n\n");
            System.out.println("All invalid URLs: \n");
            PrintStream stream = new PrintStream(System.out);

            while (brokenUrlsIterator.hasNext()) {
                System.out.println(brokenUrlsIterator.next());
            }

            //return "All invalid URLs: \n";
        } else {
            System.out.println("\n\n\n");
            System.out.println("\nAll links are valid.");

            //return "All link are valid.";
        }
    }
}

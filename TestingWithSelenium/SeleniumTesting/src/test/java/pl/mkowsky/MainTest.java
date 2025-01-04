package pl.mkowsky;


import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MainTest {

    @Test
    void testInvalidURLs() throws Exception {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Main.main(new String[] {"-homePage","http://neo.dmcs.p.lodz.pl/~wsan/broken/", "-checkSubPages", "false"});
        verify(out).println(startsWith("All invalid URLs: \n"));
    }

    @Test
    void testAllLinksAreValid() throws Exception {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);
        Main.main(new String[] {"-homePage","http://neo.dmcs.p.lodz.pl/~wsan/c/index.html", "-checkSubPages", "false"});
        verify(out).println(startsWith("\nAll links are valid."));
    }





}

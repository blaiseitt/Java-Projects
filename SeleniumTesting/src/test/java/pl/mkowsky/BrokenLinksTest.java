package pl.mkowsky;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BrokenLinksTest {

    @Test
    void checkHomePage() {
//        testCheck("http://neo.dmcs.p.lodz.pl/~wsan/broken/", false, Arrays.asList(new String[]{
//                "http://neo.dmcs.p.lodz.pl/~wsan/notexisting/index.html", "http://neo.dmcs.p.lodz.pl/~wsan/broken/NotExisting.txt"}));
//        testCheck("http://neo.dmcs.p.lodz.pl/~wsan/terminal/index.html", false, Arrays.asList(new String[]{}));
//        testCheck("http://neo.dmcs.p.lodz.pl/~wsan/c/index.html", false, Arrays.asList(new String[]{}));
      testCheck("http://neo.dmcs.pl/~wsan/cpp/index.html", false, Arrays.asList(new String[]{}));
//        testCheck("http://neo.dmcs.p.lodz.pl/~wsan/ita2/index.html", false, Arrays.asList(new String[]{}));

    }

//    @Test
//    void checkHomePageWIthSubpages() {
//         //testCheck("http://neo.dmcs.p.lodz.pl/~wsan/ita/index.html", true, Arrays.asList(new String[] {}));
//        testCheck("http://neo.dmcs.p.lodz.pl/~wsan/broken/", true, Arrays.asList(new String[] {
//              "http://neo.dmcs.p.lodz.pl/~wsan/ita2/index.html", "http://neo.dmcs.p.lodz.pl/~wsan/notexisting/index.html", "http://neo.dmcs.p.lodz.pl/~wsan/broken/NotExisting.txt"}));
//    }

    private void testCheck(String homePage, boolean checkSubPages, List<String> expectedResult) {
        assertIterableEquals(expectedResult, BrokenLinks.lookForBrokenLinks(homePage, checkSubPages));
    }

}

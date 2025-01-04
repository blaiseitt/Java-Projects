package pl.mkowsky;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataInitializerTest {

    private DataInitializer dataInitializer = new DataInitializer();


    @Test
    void testCLIParamsWithOnlyWebAddressParam() throws Exception{
        Params expectedParameters = new Params("https://github.com",false);
        test(new String[] {"-homePage","https://github.com"}, expectedParameters);

    }

    @Test
    void testCLIParamsWithBothParams() throws Exception{
        Params expectedParameters = new Params("https://github.com",false);
        test(new String[] {"-homePage","https://github.com", "-checkSubPages", "false"}, expectedParameters);

        expectedParameters = new Params("http://neo.dmcs.p.lodz.pl/~wsan/broken/",true);
        test(new String[] {"-homePage","http://neo.dmcs.p.lodz.pl/~wsan/broken/", "-checkSubPages", "true"}, expectedParameters);
    }

    @Test
    void testMissedParamException(){
        testException(new String[] {}, "Missing required option: homePage");
        testException(new String[] {"-checkSubPages", "false"}, "Missing required option: homePage");
    }

    @Test
    void testInvalidParamFormatException(){
        testException(
                new String[] {"-homePage", "https://github.com", "-checkSubPages", "1337"},
                "checkSubPages parameter is invalid.");

        testException(
                new String[] {"-homePage", "https://github.com", "-checkSubPages", "saxc"},
                "checkSubPages parameter is invalid.");
    }


    private void test(String[] args, Params expected) throws Exception {
        Params actual = dataInitializer.getCommandLineParams(args);
        assertEquals(actual.homePage, expected.homePage);
        assertEquals(actual.checkSubPages, expected.checkSubPages);
    }

    private void testException(String[] args, String message) {
        Exception exception = assertThrows(Exception.class, () -> dataInitializer.getCommandLineParams(args));
        assertEquals(message, exception.getMessage());
    }
}

package pl.dmcs.buarzej.TemperatureConverterTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureConverterTest {

    private TemperatureConverterDriver converterDriver = new TemperatureConverterDriver();

    @Test
    void testInputOfInteger(){
        Temperature actualTemperature1 = converterDriver.getTemperatureFromBrowser("32");
        testTemperature(new Temperature(32, 305.1, 0.0), actualTemperature1);

        Temperature actualTemperature2 = converterDriver.getTemperatureFromBrowser("0");
        testTemperature(new Temperature(0.0, 273.1, -17.8), actualTemperature2);

        converterDriver.closeBrowser();
    }

    @Test
    void testInputOfNonInteger(){
        Temperature actualTemperature1 = converterDriver.getTemperatureFromBrowser("27.7");
        testTemperature(new Temperature(27.7, 300.8, -2.4), actualTemperature1);

        Temperature actualTemperature2 = converterDriver.getTemperatureFromBrowser("-12.33");
        testTemperature(new Temperature(-12.33, 260.8, -24.6), actualTemperature2);

        converterDriver.closeBrowser();
    }

    @Test
    void testIncorrectInput(){
        Exception exception1 = assertThrows(Exception.class, ()->converterDriver.getTemperatureFromBrowser(".123J"));
        assertEquals("For input string: \".123J\"", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class, ()->converterDriver.getTemperatureFromBrowser("-33,1"));
        assertEquals("For input string: \"-33,1\"", exception2.getMessage());

        converterDriver.closeBrowser();
    }

    @Test
    void testBackspacesInInput(){
        Temperature actualTemperature1 = converterDriver.getTemperatureWhenBackspaces("333", 1);
        testTemperature(new Temperature(33, 306.1, 0.6), actualTemperature1);

        Temperature actualTemperature2 = converterDriver.getTemperatureWhenBackspaces("-232", 2);
        testTemperature(new Temperature(-2, 271.1, -18.9), actualTemperature2);

        converterDriver.closeBrowser();
    }



    private void testTemperature(Temperature expectedTemperature, Temperature actualTemperature){
        assertEquals(expectedTemperature.asCelsius, actualTemperature.asCelsius);
        assertEquals(expectedTemperature.asKelwin, actualTemperature.asKelwin);
        assertEquals(expectedTemperature.asFahrenheit, actualTemperature.asFahrenheit);
    }

}

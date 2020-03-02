import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)


public class TemperatureConvertTest {
    @Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {1.0, -17.2, 0.03, 33.8, 0.0  , 274.2, 0.0, -272.2, 0.0, 255.94, 0.005, -457.9, 0.0},
                {-1.0, -18.3, 0.04, 30.2, 0.0, 272.2, 0.0, -274.2, 0.0, 254.83, 0.004, -461.5, 0.0},
                {0.0, -17.8, 0.08, 32.0, 0.0, 273.2, 0.0, -273.2, 0.0, 255.38, 0.009, -459.7, 0.0}
        });

    };

    @Parameterized.Parameter
    public double fInput;

    @Parameterized.Parameter(1)
    public double fExpected;
    @Parameterized.Parameter(2)
    public double fDelta;

    @Parameterized.Parameter(3)
    public double fExpected1;
    @Parameterized.Parameter(4)
    public double fDelta1;
    @Parameterized.Parameter(5)
    public double fExpected2;
    @Parameterized.Parameter(6)
    public double fDelta2;
    @Parameterized.Parameter(7)
    public double fExpected3;
    @Parameterized.Parameter(8)
    public double fDelta3;
    @Parameterized.Parameter(9)
    public double fExpected4;
    @Parameterized.Parameter(10)
    public double fDelta4;
    @Parameterized.Parameter(11)
    public double fExpected5;
    @Parameterized.Parameter(12)
    public double fDelta5;
    public void TemperatureConvertTest(double input, double expected, double delta) {
        this.fInput = input;
        this.fExpected = expected;
        this.fDelta = delta;
    }

    @Test
    public void testConvertFtoCForPositiveF() {
        double calcResult = TemperatureConverter.convertFtoC(fInput);

        assertEquals("(degrees in Fahrenheit - 32.0) / 9.0 * 5.0 is conversion to Celsium", fExpected, calcResult,
                fDelta);
    }

    @Test
    public void testConvertCToF() {
        double calcResult = TemperatureConverter.convertCtoF(fInput);
        assertEquals("degreesCelsius / 5.0 * 9.0 + 32.0", fExpected1, calcResult,
                fDelta1);
    }
    @Test
    public void testConvertCtoK() {
        double calcResult = TemperatureConverter.convertCtoK(fInput);
        assertEquals("degreesCelsius + 273.2", fExpected2, calcResult,
                fDelta2);
    }

    @Test
    public void testConvertKtoC() {
        double calcResult = TemperatureConverter.convertKtoC(fInput);
        assertEquals("kelvin - 273.2", fExpected3, calcResult,
                fDelta3);
    }

    @Test
    public void testConvertFtoK() {
        double calcResult = TemperatureConverter.convertFtoK(fInput);
        assertEquals("(degreesFahrenheit + 459.7) / 9.0 * 5.0", fExpected4, calcResult,
                fDelta4);
    }

    @Test
    public void testConvertKtoF() {
        double calcResult = TemperatureConverter.convertKtoF(fInput);
        assertEquals("kelvin / 5.0 * 9.0 - 459.7", fExpected5, calcResult,
                fDelta5);
    }

}

package MorseConverter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConverter {

    @Test
    public void testConverttextToMorse() {
        Converter converter = new Converter();

        String testdata = "E";

        String expected = ". ";

        String actual = converter.convertToMorse(testdata);

        assertEquals(expected, actual);

    }

    @Test
    public void testConvertMorseToText(){
        Converter converter = new Converter();

        String testdata = "-----";

        String expected = "0";

        String actual = Converter.convertToText(testdata);
    }


    @Test
    public void testUpperCaseFunction(){
        Converter converter = new Converter();

        String testdata = "g";

        String expected = "--. ";

        String actual = Converter.convertToMorse(testdata);

        assertEquals(expected, actual);
    }

    @Test
    public void testWordConvertTextToMorse() {
        Converter converter = new Converter();

        String testdata = "Hello";

        String expected = ".... . .-.. .-.. --- ";

        String actual = Converter.convertToMorse(testdata);

        assertEquals(expected, actual);
    }

    @Test
    public void testSentenceConvertTextToMorse(){
        Converter converter = new Converter();

        String testdata = "Hello World";

        String expected = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ";

        String actual = Converter.convertToMorse(testdata);

        assertEquals(expected, actual);
    }

    @Test
    public void testError(){
        Converter converter = new Converter();

        String testdata = "";

        String expected = "ingenting";

        String actual = Converter.convertToText(testdata);

        assertEquals(expected, actual);
    }
}

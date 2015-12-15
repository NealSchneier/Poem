package poem;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by neal on 12/14/15.
 */
public class PoemTest {

    @Test
    public void test_Poem() throws IOException {
        Poem poem = new Poem();
        assertEquals("black", poem.line1.generateAdjective(""));
        assertEquals("my", poem.line1.generatePronoun(""));
        assertEquals("heart", poem.line1.generateNoun(""));
        assertEquals("runs", poem.line1.generateVerb(""));
        assertEquals("above", poem.line1.generatePreposition(""));

        assertEquals("black", poem.line2.generateAdjective(""));
        assertEquals("my", poem.line2.generatePronoun(""));
        assertEquals("heart", poem.line2.generateNoun(""));
        assertEquals("runs", poem.line2.generateVerb(""));
        assertEquals("above", poem.line2.generatePreposition(""));

        assertEquals("black", poem.line3.generateAdjective(""));
        assertEquals("my", poem.line3.generatePronoun(""));
        assertEquals("heart", poem.line3.generateNoun(""));
        assertEquals("runs", poem.line3.generateVerb(""));
        assertEquals("above", poem.line3.generatePreposition(""));

        assertEquals("black", poem.line4.generateAdjective(""));
        assertEquals("my", poem.line4.generatePronoun(""));
        assertEquals("heart", poem.line4.generateNoun(""));
        assertEquals("runs", poem.line4.generateVerb(""));
        assertEquals("above", poem.line4.generatePreposition(""));

        assertEquals("black", poem.line5.generateAdjective(""));
        assertEquals("my", poem.line5.generatePronoun(""));
        assertEquals("heart", poem.line5.generateNoun(""));
        assertEquals("runs", poem.line5.generateVerb(""));
        assertEquals("above", poem.line5.generatePreposition(""));
    }
}

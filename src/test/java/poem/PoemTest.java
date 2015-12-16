package poem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by neal on 12/14/15.
 */
@RunWith(Parameterized.class)
public class PoemTest {

    private static final int REPEAT = 5;

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[REPEAT][0]);
    }

    /**
     * This tests the full job for the provided rules
     * @throws Exception
     */
    @Test
    public void test_Poem() throws Exception {
        Poem poem = new Poem("generate.files");
        String poemString = poem.generatePoem(poem.getRulesFile());
        System.out.print(poemString);
    }

    /**
     * This tests the file reading for a file that does not exist
     * @throws Exception
     */
    @Test( expected = IOException.class)
    public void test_Poem_no_file() throws Exception {
        Poem poem = new Poem("fake.file");
        String poemString = poem.generatePoem(poem.getRulesFile());
        System.out.print(poemString);
    }
}

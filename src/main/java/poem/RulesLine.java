package poem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by neal on 12/14/15.
 */
public class RulesLine {

    List<String> words;
    List<String> references;

    public RulesLine(String words, String references) {
        words = words.replaceAll(">", "");
        words = words.replaceAll("<", "");
        references = references.replace(">", "");
        references = references.replace("<", "");

        this.words = Arrays.asList(words.split("\\|"));
        this.references = Arrays.asList(references.split("\\|"));
    }
}

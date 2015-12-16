package poem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by neal on 12/14/15.
 */
public class RulesLine {

    private List<String> words;
    private List<String> references;

    /**
     * Parses the incoming Strings from the file and creates separate lists for references and the words
     * @param words
     * @param references
     */
    public RulesLine(String words, String references) {

        words = words.replaceAll(">", "");
        words = words.replaceAll("<", "");
        references = references.replace(">", "");
        references = references.replace("<", "");

        this.words = Arrays.asList(words.split("\\|"));
        this.references = Arrays.asList(references.split("\\|"));
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
}

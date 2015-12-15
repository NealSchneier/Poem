package poem;

import java.util.Random;

/**
 * Created by neal on 12/14/15.
 */
public class Line {

    private static final String LINEBREAK = "\n";
    private static final Random RANDOM = new Random();

    public Line() {
    }

    public String generatePronoun(String pronoun) {
        return "my";
    }

    public String generateAdjective(String adjective) {
        return "black";
    }

    public String generateNoun(String noun) {
        return "heart";
    }

    public String generateVerb(String verb) {
        return "runs";
    }

    public String generatePreposition(String preposition) {
        return "above";
    }

}

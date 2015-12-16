package poem;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by neal on 12/14/15.
 */
public class Line {

    private static final String LINEBREAK = "\n";
    private static final Random RANDOM = new Random();
    private static final String END = "$END";
    private static final String NOUN = "NOUN";
    private static final String ADJECTIVE = "ADJECTIVE";
    private static final String PRONOUN = "PRONOUN";
    private static final String VERB = "VERB";
    private static final String PREPOSITION = "PREPOSITION";
    private static final String LINE= "LINE";

    /**
     * Wrapper for the private internally called methods
     * @param rules
     * @return
     * @throws Exception
     */
    public String generateOutput(Map<String, RulesLine> rules) throws Exception {
        return generateLine(rules);
    }

    /**
     *  Reads the Line to get the basic rules
     * @param rules
     * @return
     * @throws Exception
     */
    private String generateLine(Map<String, RulesLine> rules) throws Exception {
        if (rules.get(LINE) == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        RulesLine rulesLine = rules.get(LINE);
        generateWords(rules, builder, rulesLine);

        return builder.toString() + LINEBREAK;
    }

    /**
     * Maps the Line mapping from the file
     * @param rules
     * @param builder
     * @param rulesLine
     * @throws Exception
     */
    private void generateWords(Map<String, RulesLine> rules, StringBuilder builder, RulesLine rulesLine) throws Exception {
        int value = RANDOM.nextInt(rulesLine.getWords().size());
        String valueString = rulesLine.getWords().get(value);
        if (valueString.equalsIgnoreCase(NOUN)) {
            generateWord(rules, builder, rules.get(NOUN));
        }
        else if (valueString.equalsIgnoreCase(ADJECTIVE)) {
            generateWord(rules, builder, rules.get(ADJECTIVE));
        }
        else if (valueString.equalsIgnoreCase(PRONOUN)) {
            generateWord(rules, builder, rules.get(PRONOUN));
        }
        else if (valueString.equalsIgnoreCase(VERB)) {
            generateWord(rules, builder, rules.get(VERB));
        }
        else if (valueString.equalsIgnoreCase(PREPOSITION)) {
            generateWord(rules, builder, rules.get(PREPOSITION));
        } else {
            throw new Exception("The word is not a Noun, Adjective, Pronoun, Verb, or Preposition");
        }
    }

    /**
     * generates a word then recursively calls if necessary END is not reached
     * @param rules
     * @param builder
     * @param rulesLine
     * @return
     */
    private void generateWord(Map<String, RulesLine> rules, StringBuilder builder, RulesLine rulesLine) {
        int randomWord = RANDOM.nextInt(rulesLine.getWords().size());
        int randomReferences= RANDOM.nextInt(rulesLine.getReferences().size());

        builder.append(rulesLine.getWords().get(randomWord));
        builder.append(" ");
        if (!rulesLine.getReferences().get(randomReferences).equalsIgnoreCase(END))
            generateWord(rules, builder, rules.get(rulesLine.getReferences().get(randomReferences)));
    }
}

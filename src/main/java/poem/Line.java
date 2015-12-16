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
        int value = getRandomInt(rulesLine.getWords().size());
        String valueString = rulesLine.getWords().get(value);
        generateWord(rules, builder, rules.get(valueString));
    }

    private int getRandomInt(int max) {
        return RANDOM.nextInt(max);
    }

    /**
     * generates a word then recursively calls if necessary END is not reached
     * @param rules
     * @param builder
     * @param rulesLine
     * @return
     */
    private void generateWord(Map<String, RulesLine> rules, StringBuilder builder, RulesLine rulesLine) {
        int randomWord = getRandomInt(rulesLine.getWords().size());
        int randomReferences= getRandomInt(rulesLine.getReferences().size());

        builder.append(rulesLine.getWords().get(randomWord));
        builder.append(" ");
        if (!rulesLine.getReferences().get(randomReferences).equalsIgnoreCase(END))
            generateWord(rules, builder, rules.get(rulesLine.getReferences().get(randomReferences)));
    }
}

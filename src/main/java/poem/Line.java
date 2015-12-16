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


    public Line() {
    }

    public String generatePronoun(RulesLine pronoun) {
        String response = pronoun.words.get(RANDOM.nextInt(pronoun.words.size())) + " ";
        int referenceLookup = RANDOM.nextInt(pronoun.references.size());
        String lookup = pronoun.references.get(referenceLookup);
        if (lookup.equalsIgnoreCase("VERB"))
        {
            response +=  generateVerb(null);
        } else if (lookup.equalsIgnoreCase("PREPOSITION")) {
            response += generatePreposition(null);
        }
        return response ;
    }

    public String generateAdjective(RulesLine adjective) {
        String response = adjective.words.get(RANDOM.nextInt(adjective.words.size())) + " ";
        int referenceLookup = RANDOM.nextInt(adjective.references.size());
        String lookup = adjective.references.get(referenceLookup);
        if (lookup.equalsIgnoreCase("VERB"))
        {
            response +=  generateVerb(null);
        } else if (lookup.equalsIgnoreCase("PREPOSITION")) {
            response += generatePreposition(null);
        }
        return response ;
    }

    public String generateNoun(RulesLine noun) {
        String response = noun.words.get(RANDOM.nextInt(noun.words.size())) + " ";
        int referenceLookup = RANDOM.nextInt(noun.references.size());
        String lookup = noun.references.get(referenceLookup);
        if (lookup.equalsIgnoreCase("VERB"))
        {
            response +=  generateVerb(null);
        } else if (lookup.equalsIgnoreCase("PREPOSITION")) {
            response += generatePreposition(null);
        }
        return response ;
    }

    public String generateVerb(RulesLine verb) {
        String response = verb.words.get(RANDOM.nextInt(verb.words.size())) + " ";
        int referenceLookup = RANDOM.nextInt(verb.references.size());
        String lookup = verb.references.get(referenceLookup);
        if (lookup.equalsIgnoreCase("PRONOUN")) {
            response +=  generateVerb(null);
        } else if (lookup.equalsIgnoreCase("PREPOSITION")) {
            response += generatePreposition(null);
        }
        return response ;
    }

    public String generatePreposition(RulesLine preposition) {
        String response = preposition.words.get(RANDOM.nextInt(preposition.words.size())) + " ";
        int referenceLookup = RANDOM.nextInt(preposition.references.size());
        String lookup = preposition.references.get(referenceLookup);
        if (lookup.equalsIgnoreCase("PRONOUN")) {
            response +=  generateVerb(null);
        } else if (lookup.equalsIgnoreCase("PREPOSITION")) {
            response += generatePreposition(null);
        }
        return response ;
    }

    public void generateOutput(Map<String, RulesLine> rules) {
        System.out.println(generateLine(rules));
    }

    private String generateLine(Map<String, RulesLine> rules) {
        if (rules.get("LINE") == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        RulesLine rulesLine = rules.get("LINE");
        generateWords(rules, builder, rulesLine);

        return builder.toString() + LINEBREAK;
    }

    private void generateWords(Map<String, RulesLine> rules, StringBuilder builder, RulesLine rulesLine) {
        int value = RANDOM.nextInt(rulesLine.words.size());
        String valueString = rulesLine.words.get(value);
        if (valueString.equalsIgnoreCase("NOUN")) {
            builder.append(generateNoun(rules.get("NOUN")));
        }
        else if (valueString.equalsIgnoreCase("ADJECTIVE")) {
            builder.append(generateAdjective(rules.get("ADJECTIVE")));
        }
        else if (valueString.equalsIgnoreCase("PRONOUN")) {
            builder.append(generatePronoun(rules.get("PRONOUN")));
        }
        else if (valueString.equalsIgnoreCase("VERB")) {
            builder.append(generateVerb(rules.get("VERB")));
        }
        else if (valueString.equalsIgnoreCase("PREPOSITION")) {
            builder.append(generatePreposition(rules.get("PREPOSITION")));
        }
    }
}

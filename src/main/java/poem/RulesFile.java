package poem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by neal on 12/14/15.
 */
public class RulesFile {

    private Map<String, RulesLine> rules;
    private int lineNumbers;

    public RulesFile(int lineNumbers) {
        this.lineNumbers = lineNumbers;
        rules = new HashMap<String, RulesLine>();
    }

    public int getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(int lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

    public Map<String, RulesLine> getRules() {
        return rules;
    }

    public void setRules(Map<String, RulesLine> rules) {
        this.rules = rules;
    }
}

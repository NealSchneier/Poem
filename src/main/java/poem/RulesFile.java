package poem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by neal on 12/14/15.
 */
public class RulesFile {

    Map<String, RulesLine> rules;
    int lineNumbers;

    public RulesFile() {
        rules = new HashMap<String, RulesLine>();
    }
}

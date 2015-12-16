package poem;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by neal on 12/14/15.
 */
public class Poem {

    private RulesFile rulesFile;

    public Poem(String rulesFileName) throws IOException {

        RulesReader rulesReader = new RulesReader(rulesFileName);
        rulesFile = rulesReader.readFromFile();

    }

    /**
     * Triggers the generation of a poem from the already read in file
     * @param rulesFile
     * @return
     */
    public String generatePoem(RulesFile rulesFile) throws Exception {
        StringBuilder builder = new StringBuilder();
        Line line = new Line();
        for (int i = 0; i < rulesFile.getLineNumbers(); i ++) {

            builder.append(line.generateOutput(rulesFile.getRules()));
        }
        return builder.toString();
    }

    public RulesFile getRulesFile() {
        return rulesFile;
    }

    public void setRulesFile(RulesFile rulesFile) {
        this.rulesFile = rulesFile;
    }
}

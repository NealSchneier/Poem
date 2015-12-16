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

    Map<String, Line> lineList;


    public Poem() throws IOException {

        RulesReader rulesReader = new RulesReader();
        RulesFile rulesFile = rulesReader.readFromFile();
        lineList = new HashMap<String, Line>();

        for (int i = 0; i < rulesFile.getLineNumbers(); i ++) {
            Line line = new Line();
            line.generateOutput(rulesFile.getRules());
        }
    }

}

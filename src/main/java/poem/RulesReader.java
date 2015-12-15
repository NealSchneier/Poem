package poem;


import java.io.*;
import java.util.*;

/**
 * Created by neal on 12/14/15.
 */
public class RulesReader {

    File file;

    public RulesReader() throws IOException {

        file = new File(RulesReader.class.getClassLoader().getResource("generate.files").getPath());
        FileReader fileReader = new FileReader(file.getAbsolutePath());
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        //Map<String, RulesLine> rules = new HashMap<String, RulesLine>();
        RulesFile rulesFile = new RulesFile();

        line = reader.readLine();
        String[] pieces = line.split(" ");
        rulesFile.lineNumbers = pieces.length - 1;

        while((line = reader.readLine()) != null) {
            pieces = line.split(" ");
            String key = pieces[0].substring(0, line.indexOf(":"));

            rulesFile.rules.put(key, new RulesLine(pieces[1], pieces[2]));
        }

        reader.close();
    }
}

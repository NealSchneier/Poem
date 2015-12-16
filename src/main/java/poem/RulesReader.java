package poem;


import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * Created by neal on 12/14/15.
 */
public class RulesReader {

    File file;

    /**
     * Reads the contents of the file contains the rules
     * @param fileName
     * @throws IOException
     */
    public RulesReader(String fileName) throws IOException {
        Optional<URL> resourceURL = Optional.ofNullable(RulesReader.class.getClassLoader().getResource(fileName));
        if (resourceURL.isPresent()) {
            file = new File(resourceURL.get().getPath());
        } else {
            throw new IOException(fileName + " does not exist on the classpath");
        }
    }

    /**
     * Process the contents of a file to build the rules
     * @return
     * @throws IOException
     */
    public RulesFile readFromFile() throws IOException {
        FileReader fileReader = new FileReader(file.getAbsolutePath());
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        String[] pieces = line.split(" ");
        int lineNumbers = pieces.length - 1;
        RulesFile rulesFile = new RulesFile(lineNumbers);

        parseRulesFile(reader, rulesFile);

        reader.close();
        return rulesFile;
    }

    private void parseRulesFile(BufferedReader reader, RulesFile rulesFile) throws IOException {
        String line;
        String[] pieces;
        while((line = reader.readLine()) != null) {
            pieces = line.split(" ");
            String key = pieces[0].substring(0, line.indexOf(":"));

            rulesFile.getRules().put(key, new RulesLine(pieces[1], pieces[2]));
        }
    }
}

package poem;

import java.io.*;

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
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}

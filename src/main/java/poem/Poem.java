package poem;


import java.io.IOException;

/**
 * Created by neal on 12/14/15.
 */
public class Poem {

    Line line1;
    Line line2;
    Line line3;
    Line line4;
    Line line5;


    public Poem() throws IOException {

        RulesReader rulesReader = new RulesReader();
        line1 = new Line();
        line2 = new Line();
        line3 = new Line();
        line4 = new Line();
        line5 = new Line();
    }

}

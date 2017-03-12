package MarchMadness;

import MarchMadness.Displays.*;
import MarchMadness.Tournament.*;

/**
 * Created by Nick on 3/5/2017.
 */
public class Main {

    public static void main(String[] args) {
        //Set up initial matchup stats based on previous tournament win percentages per seed
        Controls.matchupGrid = Utilities.createMatchupGrid();

        //100 -> 99, 0 -> 1
        if(Controls.onePercentDream) {
            Utilities.addOnePercentDream(Controls.matchupGrid);
        }
        Utilities.normalizeMap(Controls.matchupGrid);
        Utilities.normalizeList(Controls.bias);

        //Create and play tournament
        Bracket b = new Bracket();
        Bracket.BracketContainer bracket = b.getBracket();

        TextBasedDisplay.display(bracket);
        //GraphicsBasedDisplay.display();
    }
}

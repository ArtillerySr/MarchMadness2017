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

        playTournament();
    }

    public static void playTournament() {
        //Create and play tournament
        Bracket b = new Bracket();
        Bracket.BracketContainer bracket = b.getBracket();

        //Change the output type in the controls file
        if(Controls.displayResultsWithGraphics) {
            new GraphicsBasedDisplay(bracket);
        } else {
            new TextBasedDisplay(bracket);
        }
    }
}

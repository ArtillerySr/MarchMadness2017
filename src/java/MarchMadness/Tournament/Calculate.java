package MarchMadness.Tournament;

import MarchMadness.Teams.Teams;
import MarchMadness.Teams.Teams.*;
import MarchMadness.Tournament.Matchups;
import MarchMadness.Tournament.Matchups.*;

import java.util.*;

/**
 * Created by Nick on 3/9/2017.
 */
public class Calculate {

    public static Matchup calculateMatchupWinner(Matchup matchup) {
        Matchup result = new Matchup(matchup.t1, matchup.t2);
        result.setWinner(matchup.t1);
        return result;
    }
}

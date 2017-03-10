package MarchMadness.Tournament;

import MarchMadness.Teams.Teams;
import MarchMadness.Teams.Teams.*;
import MarchMadness.Tournament.Matchups;

/**
 * Created by Nick on 3/8/2017.
 */
public class Bracket {

    public Bracket() {
        Matchups m = new Matchups();
        Teams t = new Teams();
        m.buildBracketByMatchup(t.buildBracket());
    }

}

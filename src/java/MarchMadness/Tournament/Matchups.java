package MarchMadness.Tournament;

import MarchMadness.Teams.Teams.*;
import java.util.*;

/**
 * Created by Nick on 3/8/2017.
 */
public class Matchups {

    public Matchups() {}

    /**
     * Used to simplify how brackets are calculated
     */
    public class Matchup {
        public Team t1;
        public Team t2;

        public Matchup(Team t1, Team t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public String toString() {
            String newLine = System.getProperty("line.separator");
            return (t1.seed + ". " + t1.name + newLine +
                    t2.seed + ". " + t2.name        );
        }
    }

    /**
     * Builds the initial 64 team bracket. Do not alter this method or matchups may not be correct
     * later in the program
     */
    public HashMap<Region, ArrayList<Matchup>> buildBracketByMatchup(HashMap<Region, ArrayList<Team>> teamMap) {
        HashMap<Region, ArrayList<Matchup>> byMatchup = new HashMap<>();
        for(Map.Entry<Region, ArrayList<Team>> entry : teamMap.entrySet()) {
            ArrayList<Team> teams = entry.getValue();
            ArrayList<Matchup> matchups = new ArrayList<>();
            matchups.add(new Matchup(teams.get(1), teams.get(16)));
            matchups.add(new Matchup(teams.get(8), teams.get(9)));
            matchups.add(new Matchup(teams.get(5), teams.get(12)));
            matchups.add(new Matchup(teams.get(4), teams.get(13)));
            matchups.add(new Matchup(teams.get(3), teams.get(14)));
            matchups.add(new Matchup(teams.get(6), teams.get(11)));
            matchups.add(new Matchup(teams.get(7), teams.get(10)));
            matchups.add(new Matchup(teams.get(2), teams.get(15)));

            byMatchup.put(entry.getKey(), matchups);
        }
        return byMatchup;
    }


}

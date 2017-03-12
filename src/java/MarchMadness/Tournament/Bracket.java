package MarchMadness.Tournament;

import MarchMadness.Teams.Teams;
import MarchMadness.Teams.Teams.*;
import MarchMadness.Tournament.Matchups.*;

import java.util.*;

/**
 * Created by Nick on 3/8/2017.
 */
public class Bracket {

    private Matchups matchups;
    private Teams teams;
    private BracketContainer bracket;

    /**
     * Initializes the original 64 team bracket by matchup
     */
    public Bracket() {
        this.matchups = new Matchups();
        this.teams = new Teams();
        this.bracket = new BracketContainer();
        playTournament();
    }

    public static class BracketContainer {
        public HashMap<Region, ArrayList<Matchup>> roundOf64;
        public HashMap<Region, ArrayList<Matchup>> roundOf32;
        public HashMap<Region, ArrayList<Matchup>> roundOf16;
        public HashMap<Region, ArrayList<Matchup>> roundOf8;
        public HashMap<Region, Team> roundOf4;
        public Matchup roundOf2;
        public Team winner;

        public BracketContainer() {
            roundOf64 = new HashMap<>();
            roundOf32 = new HashMap<>();
            roundOf16 = new HashMap<>();
            roundOf8 = new HashMap<>();
            roundOf4 = new HashMap<>();
        }
    }

    public BracketContainer getBracket() {
        return bracket;
    }

    private void playTournament() {
        bracket.roundOf64 = matchups.buildBracketByMatchup(teams.buildBracket());

        //Round of 64
        for(Map.Entry<Region, ArrayList<Matchup>> entry : bracket.roundOf64.entrySet()) {
            bracket.roundOf32.put(entry.getKey(), playRegionMatchups(entry.getValue(), 1));
        }

        //Round of 32
        for(Map.Entry<Region, ArrayList<Matchup>> entry : bracket.roundOf32.entrySet()) {
            bracket.roundOf16.put(entry.getKey(), playRegionMatchups(entry.getValue(), 2));
        }

        //Round of 16
        for(Map.Entry<Region, ArrayList<Matchup>> entry : bracket.roundOf16.entrySet()) {
            bracket.roundOf8.put(entry.getKey(), playRegionMatchups(entry.getValue(), 3));
        }

        //Round of 8
        for(Map.Entry<Region, ArrayList<Matchup>> entry : bracket.roundOf8.entrySet()) {
            bracket.roundOf4.put(entry.getKey(), playEliteEight(entry.getValue(), 4));
        }

        //Round of 4
        bracket.roundOf2 = playFinalFour(bracket.roundOf4, 5);

        //Finals
        bracket.winner = playFinals(bracket.roundOf2, 6);
    }

    /**
     * Calculates the winners of matchups for all rounds prior to the elite eight
     */
    private ArrayList<Matchup> playRegionMatchups(ArrayList<Matchup> region, int round) {
        ArrayList<Matchup> result = new ArrayList<>();
        for(int idx = 0; idx < region.size(); idx = idx+2) {
            Team winner1 = Calculate.calculateMatchupWinner(region.get(idx), round).winner;
            Team winner2 = Calculate.calculateMatchupWinner(region.get(idx+1), round).winner;
            result.add(new Matchup(winner1, winner2));
        }
        return result;
    }

    /**
     * Calculates the winners of the elite eight that move the the final four
     */
    private Team playEliteEight(ArrayList<Matchup> region, int round) {
        if(region.size() == 1) {
            return Calculate.calculateMatchupWinner(region.get(0), round).winner;
        } else {
            return null;
        }
    }

    /**
     * Calculates the winners of the final four that move to the finals
     */
    private Matchup playFinalFour(HashMap<Region, Team> map, int round){
        Team w1 = Calculate.calculateMatchupWinner(new Matchup(map.get(Region.SOUTH), map.get(Region.WEST)), round).winner;
        Team w2 = Calculate.calculateMatchupWinner(new Matchup(map.get(Region.EAST), map.get(Region.MIDWEST)), round).winner;
        return new Matchup(w1, w2);
    }

    /**
     * Calculates the winners of the tournament
     */
    private Team playFinals(Matchup matchup, int round) {

        return Calculate.calculateMatchupWinner(matchup, round).winner;
    }

}

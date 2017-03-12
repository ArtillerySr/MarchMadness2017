package MarchMadness.Tournament;

import MarchMadness.Teams.Teams;
import MarchMadness.Teams.Teams.*;
import MarchMadness.Tournament.*;
import MarchMadness.Tournament.Matchups.*;

import java.util.*;

/**
 * Created by Nick on 3/8/2017.
 */
public class Bracket {

    private HashMap<Region, ArrayList<Matchup>> roundOf64;
    private HashMap<Region, ArrayList<Matchup>> roundOf32;
    private HashMap<Region, ArrayList<Matchup>> roundOf16;
    private HashMap<Region, ArrayList<Matchup>> roundOf8;
    private HashMap<Region, Team> roundOf4;
    private Matchup roundOf2;
    private Team winner;

    private Matchups matchups;
    private Teams teams;

    /**
     * Initializes the original 64 team bracket by matchup
     */
    public Bracket() {
        this.matchups = new Matchups();
        this.teams = new Teams();
        roundOf64 = matchups.buildBracketByMatchup(teams.buildBracket());
        roundOf32 = new HashMap<>();
        roundOf16 = new HashMap<>();
        roundOf8 = new HashMap<>();
        roundOf4 = new HashMap<>();
        playTournament();
    }

    private void playTournament() {
        //Round of 64
        for(Map.Entry<Region, ArrayList<Matchup>> entry : roundOf64.entrySet()) {
            roundOf32.put(entry.getKey(), playRegionMatchups(entry.getValue()));
        }

        //Round of 32
        for(Map.Entry<Region, ArrayList<Matchup>> entry : roundOf32.entrySet()) {
            roundOf16.put(entry.getKey(), playRegionMatchups(entry.getValue()));
        }

        //Round of 16
        for(Map.Entry<Region, ArrayList<Matchup>> entry : roundOf16.entrySet()) {
            roundOf8.put(entry.getKey(), playRegionMatchups(entry.getValue()));
        }

        //Round of 8
        for(Map.Entry<Region, ArrayList<Matchup>> entry : roundOf8.entrySet()) {
            roundOf4.put(entry.getKey(), playEliteEight(entry.getValue()));
        }

        //Round of 4
        roundOf2 = playFinalFour(roundOf4);

        //Finals
        winner = playFinals(roundOf2);

        System.out.println("NICK " + winner.toString());
    }

    /**
     * Calculates the winners of matchups for all rounds prior to the elite eight
     */
    private ArrayList<Matchup> playRegionMatchups(ArrayList<Matchup> region) {
        ArrayList<Matchup> result = new ArrayList<>();
        for(int idx = 0; idx < region.size(); idx = idx+2) {
            Team winner1 = Calculate.calculateMatchupWinner(region.get(idx)).winner;
            Team winner2 = Calculate.calculateMatchupWinner(region.get(idx+1)).winner;
            result.add(new Matchup(winner1, winner2));
        }
        return result;
    }

    /**
     * Calculates the winners of the elite eight that move the the final four
     */
    private Team playEliteEight(ArrayList<Matchup> region) {
        if(region.size() == 1) {
            return Calculate.calculateMatchupWinner(region.get(0)).winner;
        } else {
            return null;
        }
    }

    /**
     * Calculates the winners of the final four that move to the finals
     */
    private Matchup playFinalFour(HashMap<Region, Team> map){
        Team w1 = Calculate.calculateMatchupWinner(new Matchup(map.get(Region.SOUTH), map.get(Region.WEST))).winner;
        Team w2 = Calculate.calculateMatchupWinner(new Matchup(map.get(Region.EAST), map.get(Region.MIDWEST))).winner;
        return new Matchup(w1, w2);
    }

    /**
     * Calculates the winners of the tournament
     */
    private Team playFinals(Matchup matchup) {

        return Calculate.calculateMatchupWinner(matchup).winner;
    }

}

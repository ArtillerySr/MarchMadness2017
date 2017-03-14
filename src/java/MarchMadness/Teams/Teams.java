package MarchMadness.Teams;

import MarchMadness.Controls;

import java.util.*;

/**
 * Created by Nick on 3/7/2017.
 */
public class Teams {
    public enum Region {
        EAST,
        WEST,
        MIDWEST,
        SOUTH,
        FINALS
    }

    public Teams() {}

    // Teams are structured such that variables can be accessed quickly and set as needed
    // To change an individual team's stats
    public static class Team implements Comparable<Team> {
        public Region region;
        public String name;
        public int seed;
        public double bias;
        public double biasDecay;

        public Team(Region region, String name, int seed, double bias, double biasDecay) {
            this.region = region;
            this.name = name;
            this.seed = seed;
            this.bias = bias;
            this.biasDecay = biasDecay;
        }

        @Override
        public int compareTo(Team team) {
            int teamSeed = team.seed;

            /* Ascending order*/
            return this.seed-teamSeed;
        }

        @Override
        public String toString() {
            String s = seed >= 10 ? seed + ". " + name : seed + ".  " + name;
            return s;
        }
    }

    public HashMap<Region, ArrayList<Team>> buildBracket(){
        HashMap<Region, ArrayList<Team>> bracket = new HashMap<>();
        East e = new East();
        West w = new West();
        Midwest mw = new Midwest();
        South s = new South();

        bracket.put(Region.EAST, e.buildRegion());
        bracket.put(Region.WEST, w.buildRegion());
        bracket.put(Region.MIDWEST, mw.buildRegion());
        bracket.put(Region.SOUTH, s.buildRegion());

        bracket = normalizeBracket(bracket);
        bracket = sortBracket(bracket);
        return bracket;
    }

    /**
     * Finds a Team entry based on a given name. Only use after bracket is formed
     */
    public Team getTeamByRegion(ArrayList<Team> region, String name){
         return findTeam(region, name, -1);
    }


    public Team getTeamByRegion(ArrayList<Team> region, int seed){
        return findTeam(region, null, seed);
    }

    public Team findTeam(ArrayList<Team> region, String name, int seed) {
        if (name != null) {
            for(int idx = 0; idx < region.size(); idx++) {
                Team team = region.get(idx);
                if(team.name.equals(name))
                    return team;
            }
        } else if (seed > 1 && seed < 16) {
            return region.get(seed);
        }
        return null;
    }

    /** Returns the global bias variable by seed. If you want to manually control a single team's bias,
     *  edit the team's entry to not call this method
     */
    public double getBiasBySeed(int seed) {
        return Controls.bias.get(seed);
    }

    /** Returns the global biasDecay variable. If you want to manually control a single team's biasDecay,
     *  edit the team's entry to not call this method
     */
    public double getBiasDecay() {
        return Controls.biasDecay;
    }

    /**
     * Verifies that the regions are listed in seed order which is critical to the calculations
     * used later.
     */
    public HashMap<Region, ArrayList<Team>> sortBracket(HashMap<Region, ArrayList<Team>> map) {
        HashMap<Region, ArrayList<Team>> result = new HashMap<>();
        for(Map.Entry<Region, ArrayList<Team>> entry : map.entrySet()) {
            result.put(entry.getKey(), sortRegion(entry.getValue()));
        }
        return result;
    }

    public ArrayList<Team> sortRegion(ArrayList<Team> region) {
        Collections.sort(region);
        return region;
    }

    /**
     * Adds a buffer seed to each region for easier sorting into matchups. 1 = 1 seed instead of 0
     */
    public HashMap<Region, ArrayList<Team>> normalizeBracket(HashMap<Region, ArrayList<Team>> map) {
        HashMap<Region, ArrayList<Team>> result = new HashMap<>();
        for(Map.Entry<Region, ArrayList<Team>> entry : map.entrySet()) {
            result.put(entry.getKey(), normalizeRegion(entry.getValue()));
        }
        return result;
    }

    public ArrayList<Team> normalizeRegion(ArrayList<Team> region) {
        region.add(0, new Team(null, "NULL", -1, 0, 0));
        return region;
    }

}

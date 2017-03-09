package MarchMadness;

import java.util.*;

/**
 * Created by Nick on 3/6/2017.
 */
public class Utilities {

    // Sets the matchups in the Controls file in a 17x17 grid for ease of use later (0 is a buffer such that 1 = 1 seed)
    // Also casts each List to an ArrayList
    public static HashMap<Integer, ArrayList<Double>> createMatchupGrid() {
        HashMap<Integer, ArrayList<Double>> temp = new HashMap<>();
        List<Double> zeroSeedBuffer = Arrays.asList(-1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00, -1.00);

        try {
            temp.put(0, new ArrayList<>(zeroSeedBuffer));
            temp.put(1, new ArrayList<>(Controls.oneSeed));
            temp.put(2, new ArrayList<>(Controls.twoSeed));
            temp.put(3, new ArrayList<>(Controls.threeSeed));
            temp.put(4, new ArrayList<>(Controls.fourSeed));
            temp.put(5, new ArrayList<>(Controls.fiveSeed));
            temp.put(6, new ArrayList<>(Controls.sixSeed));
            temp.put(7, new ArrayList<>(Controls.sevenSeed));
            temp.put(8, new ArrayList<>(Controls.eightSeed));
            temp.put(9, new ArrayList<>(Controls.nineSeed));
            temp.put(10, new ArrayList<>(Controls.tenSeed));
            temp.put(11, new ArrayList<>(Controls.elevenSeed));
            temp.put(12, new ArrayList<>(Controls.twelveSeed));
            temp.put(13, new ArrayList<>(Controls.thirteenSeed));
            temp.put(14, new ArrayList<>(Controls.fourteenSeed));
            temp.put(15, new ArrayList<>(Controls.fifteenSeed));
            temp.put(16, new ArrayList<>(Controls.sixteenSeed));
        } catch (NullPointerException e) {
            System.out.println("One of the matchup lists is null/not initialized");
        }
        return temp;
    }

    // Adds a buffer to each seed's list, such that 1 = 1st seed matchup, instead of 0... etc.
    public static void normalizeMap(HashMap<Integer, ArrayList<Double>> map) {
        for(List<Double> value : map.values()) {
            value.add(0, -1.00);
        }
    }

    // Adds a buffer to the list, such that 1 = 1st seed matchup, instead of 0... etc.
    public static void normalizeList(ArrayList<Double> list) {
        list.add(0, 0.00);
    }

    // Converts 100.00 -> 99.00 and 0.00 -> 1.00
    public static void addOnePercentDream(HashMap<Integer, ArrayList<Double>> map) {
        for(List<Double> value : map.values()) {
            for(int idx = 0; idx < value.size(); idx++) {
                if(value.get(idx) == 0.00) {
                    value.set(idx, 1.00);
                } else if (value.get(idx) == 100.00) {
                    value.set(idx, 99.00);
                }
            }
        }
    }
}

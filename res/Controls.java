import java.util.*;

/**
 * Created by Nick on 3/5/2017.
 *
 * This file contains constants that can be controlled to the users liking.
 * I set some defaults here that are applied to all teams/matchups globally.
 * The variables can be edited here to effect variables globally or can be changed
 * at each teams individual entry.
 *
 */

public class Controls {
    /**
     * Global Constants
     * Feel free to change these to your liking
     */
    // Display the results with a graphical JFrame. Change to false if you want results in a text format.
    // See file DisplayText for more details on text format.
    public static boolean displayResultsWithGraphics = true;

    // Converts matchups (listed below) that have 100% win rate for a given seed to 99%... underdog story?
    // Does not effect bias
    public static boolean onePercentDream = true;

    // Bias on a per seed basis -> changing the bias of the "1 seed" row will effect all four 1 seed teams
    // A bias of 1 = 1% increase in percentage to win a given matchup.
    public static List<Double> bias = Arrays.asList(
                                    0.0, //1 seeds
                                    0.0, //2 seeds
                                    0.0, //3 seeds
                                    0.0, //4 seeds
                                    0.0, //5 seeds
                                    0.0, //6 seeds
                                    0.0, //7 seeds
                                    0.0, //8 seeds
                                    0.0, //9 seeds
                                    0.0, //10 seeds
                                    0.0, //11 seeds
                                    0.0, //12 seeds
                                    0.0, //13 seeds
                                    0.0, //14 seeds
                                    0.0, //15 seeds
                                    0.0 //16 seeds
                                    );

    // Decays the global bias as the tournament progresses
    // See Calculations file for more on bias decay
    public static double biasDecay = 0.5;

    /**
     * Matchup Constants
     *
     * Percentages a given seed will win over another seed based on historical win/loss ratio found here:
     * "http://mcubed.net/ncaab/seeds.shtml"
     *
     * Example oneSeed = {50% vs 1 seeds, 52.8% vs 2 seeds, 60.6% vs 3 seeds, .... , 100% vs 16 seeds}
     *
     * Could use a file read in here... but for readability, just placing it all here
     */
    public static List<Double> oneSeed = Arrays.asList(52.80, 60.60, 68.60, 84.00, 68.80, 83.30, 80.50, 90.40, 85.70, 50.00, 100.00, 100.00, 0.00, 0.00, 100.00);
    public static List<Double> twoSeed = Arrays.asList(47.20, 50.00, 62.30, 44.40, 20.00, 72.20, 72.20, 44.40, 50.00, 60.00, 92.90, 100.00, 0.00, 0.00, 93.80, 0.00);
    public static List<Double> threeSeed = Arrays.asList(39.40, 37.70, 50.00, 62.50, 50.00, 54.80, 60.00, 100.00, 100.00, 69.20, 70.80, 0.00, 0.00, 83.60, 100.00, 0.00);
    public static List<Double> fourSeed = Arrays.asList(31.40, 55.60, 37.50, 50.00, 55.10, 33.30, 40.00, 30.00, 66.70, 100.00, 0.00, 68.40, 80.30, 0.00, 0.00, 0.00);
    public static List<Double> fiveSeed = Arrays.asList(16.00, 80.00, 50.00, 44.90, 50.00, 100.00, 0.00, 25.00, 33.30, 100.00, 0.00, 66.90, 80.00, 0.00, 0.00, 0.00);
    public static List<Double> sixSeed = Arrays.asList(31.30, 27.80, 45.20, 66.70, 0.00, 0.00, 62.50, 25.00, 0.00, 60.00, 64.90, 0.00, 0.00, 87.50, 0.00, 0.00);
    public static List<Double> sevenSeed = Arrays.asList(16.70, 27.80, 40.00, 60.00, 0.00, 37.50, 0.00, 50.00, 0.00, 60.50, 0.00, 0.00, 0.00, 100.00, 66.70, 0.00);
    public static List<Double> eightSeed = Arrays.asList(19.50, 55.60, 0.00, 70.00, 75.00, 75.00, 50.00, 0.00, 52.60, 0.00, 100.00, 0.00, 100.00, 0.00, 0.00, 0.00);
    public static List<Double> nineSeed = Arrays.asList(9.60, 50.00, 0.00, 33.30, 66.70, 0.00, 0.00, 47.40, 0.00, 100.00, 0.00, 0.00, 100.00, 0.00, 0.00, 0.00);
    public static List<Double> tenSeed = Arrays.asList(14.30, 40.00, 30.80, 0.00, 0.00, 40.00, 39.50, 0.00, 0.00, 0.00, 33.30, 0.00, 0.00, 100.00, 100.00, 0.00);
    public static List<Double> elevenSeed = Arrays.asList(50.00, 7.10, 29.20, 0.00, 0.00, 35.10, 100.00, 0.00, 0.00, 66.70, 0.00, 0.00, 0.00, 100.00, 0.00, 0.00);
    public static List<Double> twelveSeed = Arrays.asList(0.00, 0.00, 0.00, 31.60, 33.10, 0.00, 0.00, 100.00, 0.00, 0.00, 0.00, 0.00, 72.70, 0.00, 0.00, 0.00);
    public static List<Double> thirteenSeed = Arrays.asList(0.00, 0.00, 0.00, 19.70, 20.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 27.30, 0.00, 0.00, 0.00, 0.00);
    public static List<Double> fourteenSeed = Arrays.asList(0.00, 0.00, 16.40, 0.00, 0.00, 12.50, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00);
    public static List<Double> fifteenSeed = Arrays.asList(0.00, 6.30, 0.00, 0.00, 0.00, 0.00, 33.30, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00);
    public static List<Double> sixteenSeed = Arrays.asList(0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00);

    // Contains the above matchups in a 17x17 grid (one buffer column for convenience)
    public static HashMap<Integer, List<Double>> matchupGrid;
























}

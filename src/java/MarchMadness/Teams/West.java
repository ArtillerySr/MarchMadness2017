package MarchMadness.Teams;

import java.util.*;

/**
 * Created by Nick on 3/7/2017.
 */
public class West extends Teams {

    private final Region REGION = Region.WEST;

    public West(){}

    protected ArrayList<Team> buildRegion() {
        List<Team> region = Arrays.asList(
            oneSeed, twoSeed, threeSeed, fourSeed, fiveSeed, sixSeed, sevenSeed, eightSeed,
            nineSeed, tenSeed, elevenSeed, twelveSeed, thirteenSeed, fourteenSeed, fifteenSeed, sixteenSeed
        );
        return new ArrayList<>(region);
    }

    /** Teams Listed as Follows:
     * Region
     * Name
     * Seed
     * Bias
     * BiasDecay
     */
    Team oneSeed = new Team(
            REGION,
            "Gonzaga",
            1,
            getBiasBySeed(1),
            getBiasDecay()
    );

    Team twoSeed = new Team(
            REGION,
            "Arizona",
            2,
            getBiasBySeed(2),
            getBiasDecay()
    );

    Team threeSeed = new Team(
            REGION,
            "Florida St.",
            3,
            getBiasBySeed(3),
            getBiasDecay()
    );

    Team fourSeed = new Team(
            REGION,
            "W. Virginia",
            4,
            getBiasBySeed(4),
            getBiasDecay()
    );

    Team fiveSeed = new Team(
            REGION,
            "Notre Dame",
            5,
            getBiasBySeed(5),
            getBiasDecay()
    );

    Team sixSeed = new Team(
            REGION,
            "Maryland",
            6,
            getBiasBySeed(6),
            getBiasDecay()
    );

    Team sevenSeed = new Team(
            REGION,
            "St. Mary's",
            7,
            getBiasBySeed(7),
            getBiasDecay()
    );

    Team eightSeed = new Team(
            REGION,
            "Northwestern",
            8,
            getBiasBySeed(8),
            getBiasDecay()
    );

    Team nineSeed = new Team(
            REGION,
            "Vanderbilt",
            9,
            getBiasBySeed(9),
            getBiasDecay()
    );

    Team tenSeed = new Team(
            REGION,
            "VCU",
            10,
            getBiasBySeed(10),
            getBiasDecay()
    );

    Team elevenSeed = new Team(
            REGION,
            "Xavier",
            11,
            getBiasBySeed(11),
            getBiasDecay()
    );

    Team twelveSeed = new Team(
            REGION,
            "Princeton",
            12,
            getBiasBySeed(12),
            getBiasDecay()
    );

    Team thirteenSeed = new Team(
            REGION,
            "Bucknell",
            13,
            getBiasBySeed(13),
            getBiasDecay()
    );

    Team fourteenSeed = new Team(
            REGION,
            "FGCU",
            14,
            getBiasBySeed(14),
            getBiasDecay()
    );

    Team fifteenSeed = new Team(
            REGION,
            "North Dakota",
            15,
            getBiasBySeed(15),
            getBiasDecay()
    );

    Team sixteenSeed = new Team(
            REGION,
            "S. Dak. St.",
            16,
            getBiasBySeed(16),
            getBiasDecay()
    );

}

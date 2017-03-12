package MarchMadness.Teams;

import java.util.*;

/**
 * Created by Nick on 3/7/2017.
 */
public class Midwest extends Teams {

    private final Region REGION = Region.MIDWEST;

    public Midwest(){}

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
            "Kansas",
            1,
            getBiasBySeed(1),
            getBiasDecay()
    );

    Team twoSeed = new Team(
            REGION,
            "Louisville",
            2,
            getBiasBySeed(2),
            getBiasDecay()
    );

    Team threeSeed = new Team(
            REGION,
            "Oregon",
            3,
            getBiasBySeed(3),
            getBiasDecay()
    );

    Team fourSeed = new Team(
            REGION,
            "Purdue",
            4,
            getBiasBySeed(4),
            getBiasDecay()
    );

    Team fiveSeed = new Team(
            REGION,
            "Iowa St.",
            5,
            getBiasBySeed(5),
            getBiasDecay()
    );

    Team sixSeed = new Team(
            REGION,
            "Creighton",
            6,
            getBiasBySeed(6),
            getBiasDecay()
    );

    Team sevenSeed = new Team(
            REGION,
            "Michigan",
            7,
            getBiasBySeed(7),
            getBiasDecay()
    );

    Team eightSeed = new Team(
            REGION,
            "Miami (Fla.)",
            8,
            getBiasBySeed(8),
            getBiasDecay()
    );

    Team nineSeed = new Team(
            REGION,
            "Michigan St.",
            9,
            getBiasBySeed(9),
            getBiasDecay()
    );

    Team tenSeed = new Team(
            REGION,
            "Oklahoma St.",
            10,
            getBiasBySeed(10),
            getBiasDecay()
    );

    Team elevenSeed = new Team(
            REGION,
            "Rhode Island",
            11,
            getBiasBySeed(11),
            getBiasDecay()
    );

    Team twelveSeed = new Team(
            REGION,
            "Nevada",
            12,
            getBiasBySeed(12),
            getBiasDecay()
    );

    Team thirteenSeed = new Team(
            REGION,
            "Vermont",
            13,
            getBiasBySeed(13),
            getBiasDecay()
    );

    Team fourteenSeed = new Team(
            REGION,
            "Iona",
            14,
            getBiasBySeed(14),
            getBiasDecay()
    );

    Team fifteenSeed = new Team(
            REGION,
            "Jax. State",
            15,
            getBiasBySeed(15),
            getBiasDecay()
    );

    Team sixteenSeed = new Team(
            REGION,
            "NCCENT/UCD",
            16,
            getBiasBySeed(16),
            getBiasDecay()
    );

}

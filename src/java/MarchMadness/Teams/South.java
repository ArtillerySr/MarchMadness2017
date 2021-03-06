package MarchMadness.Teams;

import java.util.*;

/**
 * Created by Nick on 3/7/2017.
 */
public class South extends Teams {

    private final Region REGION = Region.SOUTH;

    public South(){}

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
            "N. Carolina",
            1,
            getBiasBySeed(1),
            getBiasDecay()
    );

    Team twoSeed = new Team(
            REGION,
            "Kentucky",
            2,
            getBiasBySeed(2),
            getBiasDecay()
    );

    Team threeSeed = new Team(
            REGION,
            "UCLA",
            3,
            getBiasBySeed(3),
            getBiasDecay()
    );

    Team fourSeed = new Team(
            REGION,
            "Butler",
            4,
            getBiasBySeed(4),
            getBiasDecay()
    );

    Team fiveSeed = new Team(
            REGION,
            "Minnesota",
            5,
            getBiasBySeed(5),
            getBiasDecay()
    );

    Team sixSeed = new Team(
            REGION,
            "Cincinnati",
            6,
            getBiasBySeed(6),
            getBiasDecay()
    );

    Team sevenSeed = new Team(
            REGION,
            "Dayton",
            7,
            getBiasBySeed(7),
            getBiasDecay()
    );

    Team eightSeed = new Team(
            REGION,
            "Arkansas",
            8,
            getBiasBySeed(8),
            getBiasDecay()
    );

    Team nineSeed = new Team(
            REGION,
            "Seton Hall",
            9,
            getBiasBySeed(9),
            getBiasDecay()
    );

    Team tenSeed = new Team(
            REGION,
            "Wichita St.",
            10,
            getBiasBySeed(10),
            getBiasDecay()
    );

    Team elevenSeed = new Team(
            REGION,
            "KSTATE/WF",
            11,
            getBiasBySeed(11),
            getBiasDecay()
    );

    Team twelveSeed = new Team(
            REGION,
            "Middle Tenn.",
            12,
            getBiasBySeed(12),
            getBiasDecay()
    );

    Team thirteenSeed = new Team(
            REGION,
            "Winthrop",
            13,
            getBiasBySeed(13),
            getBiasDecay()
    );

    Team fourteenSeed = new Team(
            REGION,
            "Kent St.",
            14,
            getBiasBySeed(14),
            getBiasDecay()
    );

    Team fifteenSeed = new Team(
            REGION,
            "N. Kentucky",
            15,
            getBiasBySeed(15),
            getBiasDecay()
    );

    Team sixteenSeed = new Team(
            REGION,
            "Texas So.",
            16,
            getBiasBySeed(16),
            getBiasDecay()
    );

}

package MarchMadness.Teams;

import java.util.*;

/**
 * Created by Nick on 3/7/2017.
 */
public class East extends Teams {

    private final Region REGION = Region.EAST;

    public East(){}

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
            "Villanova",
            1,
            getBiasBySeed(1),
            getBiasDecay()
    );

    Team twoSeed = new Team(
            REGION,
            "Duke",
            2,
            getBiasBySeed(2),
            getBiasDecay()
    );

    Team threeSeed = new Team(
            REGION,
            "Baylor",
            3,
            getBiasBySeed(3),
            getBiasDecay()
    );

    Team fourSeed = new Team(
            REGION,
            "Florida",
            4,
            getBiasBySeed(4),
            getBiasDecay()
    );

    Team fiveSeed = new Team(
            REGION,
            "Virginia",
            5,
            getBiasBySeed(5),
            getBiasDecay()
    );

    Team sixSeed = new Team(
            REGION,
            "SMU",
            6,
            getBiasBySeed(6),
            getBiasDecay()
    );

    Team sevenSeed = new Team(
            REGION,
            "S. Carolina",
            7,
            getBiasBySeed(7),
            getBiasDecay()
    );

    Team eightSeed = new Team(
            REGION,
            "Wisconsin",
            8,
            getBiasBySeed(8),
            getBiasDecay()
    );

    Team nineSeed = new Team(
            REGION,
            "Va. Tech",
            9,
            getBiasBySeed(9),
            getBiasDecay()
    );

    Team tenSeed = new Team(
            REGION,
            "Marquette",
            10,
            getBiasBySeed(10),
            getBiasDecay()
    );

    Team elevenSeed = new Team(
            REGION,
            "PROV/USC",
            11,
            getBiasBySeed(11),
            getBiasDecay()
    );

    Team twelveSeed = new Team(
            REGION,
            "UNC-Wilm",
            12,
            getBiasBySeed(12),
            getBiasDecay()
    );

    Team thirteenSeed = new Team(
            REGION,
            "ETSU",
            13,
            getBiasBySeed(13),
            getBiasDecay()
    );

    Team fourteenSeed = new Team(
            REGION,
            "New Mex. St.",
            14,
            getBiasBySeed(14),
            getBiasDecay()
    );

    Team fifteenSeed = new Team(
            REGION,
            "Troy",
            15,
            getBiasBySeed(15),
            getBiasDecay()
    );

    Team sixteenSeed = new Team(
            REGION,
            "MSMARY/NO",
            16,
            getBiasBySeed(16),
            getBiasDecay()
    );

}

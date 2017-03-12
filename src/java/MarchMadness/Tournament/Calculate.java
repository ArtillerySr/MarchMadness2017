package MarchMadness.Tournament;

import MarchMadness.Controls;
import MarchMadness.Teams.Teams.*;
import MarchMadness.Tournament.Matchups.*;

import java.util.*;

/**
 * Created by Nick on 3/9/2017.
 */
public class Calculate {

    /**
     * Randomly selects the winner based on the previous win-loss ratio of the matchup and factoring in
     * any bias added by the user.
     * Important: Bias is calculated by taking the bias (a percentage) and multiplying it by the bias decay and the round.
     *            Therefore a positive decay could result in a large multiplier the deeper a team goes in the tournament
     *            (Useful only if the user believes a team will gain confidence as they go along and play better because of it)
     */
    public static Matchup calculateMatchupWinner(Matchup m, int round) {
        Matchup matchup = new Matchup(m.t1, m.t2);
        Random random = new Random();
        double t1Odds = getTeamOdds(matchup.t1, matchup.t2, round);
        double t2Odds = getTeamOdds(matchup.t2, matchup.t1, round);

        double randResult = (random.nextDouble() * (t1Odds + t2Odds));
        if(t1Odds > t2Odds) {
            if(randResult > t2Odds) {
                matchup.setWinner(matchup.t1);
            } else {
                matchup.setWinner(matchup.t2);
            }
        } else {
            if(randResult > t1Odds) {
                matchup.setWinner(matchup.t2);
            } else {
                matchup.setWinner(matchup.t1);
            }
        }
        return matchup;
    }

    private static Double getTeamOdds(Team team, Team opponent, int round) {
        Double result = 0.00;
        // Add win-loss odds
        result += Controls.matchupGrid.get(team.seed).get(opponent.seed);

        //Add bias
        result += team.bias * team.biasDecay * round;

        return result;
    }
}

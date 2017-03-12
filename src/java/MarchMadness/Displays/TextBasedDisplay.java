package MarchMadness.Displays;

import MarchMadness.Tournament.*;
import MarchMadness.Teams.Teams.*;

/**
 * Created by Nick on 3/12/2017.
 */
public class TextBasedDisplay {

    public static void display(Bracket.BracketContainer bracket) {
        printRegion(bracket, Region.SOUTH);
        printRegion(bracket, Region.WEST);
        printRegion(bracket, Region.EAST);
        printRegion(bracket, Region.MIDWEST);

        printFinals(bracket);
    }

    private static void printRegion(Bracket.BracketContainer bracket, Region region) {
        print("------ " + region + " ------", 0);
        print(bracket.roundOf64.get(region).get(0).toString(), 0);
        print(bracket.roundOf32.get(region).get(0).toString(), 1);
        print(bracket.roundOf64.get(region).get(1).toString(), 0);
        print(bracket.roundOf16.get(region).get(0).toString(), 2);
        print(bracket.roundOf64.get(region).get(2).toString(), 0);
        print(bracket.roundOf32.get(region).get(1).toString(), 1);
        print(bracket.roundOf64.get(region).get(3).toString(), 0);

        print(bracket.roundOf8.get(region).get(0).toString(), 3);
        print(bracket.roundOf4.get(region).toString(), 4);

        print(bracket.roundOf64.get(region).get(4).toString(), 0);
        print(bracket.roundOf32.get(region).get(2).toString(), 1);
        print(bracket.roundOf64.get(region).get(5).toString(), 0);
        print(bracket.roundOf16.get(region).get(1).toString(), 2);
        print(bracket.roundOf64.get(region).get(6).toString(), 0);
        print(bracket.roundOf32.get(region).get(3).toString(), 1);
        print(bracket.roundOf64.get(region).get(7).toString(), 0);
    }

    private static void printFinals(Bracket.BracketContainer bracket) {
        print("------ " + "FINALS" + " ------", 0);
        print(bracket.roundOf4.get(Region.SOUTH).toString(), 0);
        print(bracket.roundOf4.get(Region.WEST).toString(), 0);

        print(bracket.roundOf2.toString(), 1);
        print(bracket.winner.toString(), 2);

        print(bracket.roundOf4.get(Region.EAST).toString(), 0);
        print(bracket.roundOf4.get(Region.MIDWEST).toString(), 0);
    }


    private static void print(String s, int numIndents) {
        String regex = "(?m)^";
        String result = "";
        String indent = addSpaces(numIndents);
        switch(numIndents) {
            case(0): result = s.replaceAll(regex, indent); break;
            case(1): result = s.replaceAll(regex, indent); break;
            case(2): result = s.replaceAll(regex, indent); break;
            case(3): result = s.replaceAll(regex, indent); break;
            case(4): result = s.replaceAll(regex, indent); break;
            case(5): result = s.replaceAll(regex, indent); break;
        }
        System.out.println(result);
    }

    private static String addSpaces(int indent) {
        String result = "";
        for(int i = 0; i < indent; i++) {
            //15 spaces
            result += "               ";
        }
        return result;
    }
}

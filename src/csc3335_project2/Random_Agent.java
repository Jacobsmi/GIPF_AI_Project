package csc3335_project2;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.GipfPlayable;
import java.util.Random;

/**
 *
 * @author stuetzlec
 */
public class Random_Agent implements GipfPlayable {

    String[] edgeSpots;
    String[] columns;
    Random rng;

    public Random_Agent(GipfGame g) {
        this.edgeSpots = g.getEdgeSpots();
       // this.columns = g.getColumns();
        rng = new Random(37);
    }

    @Override
    public String makeGipfMove(int curPlayer) {
        String startLocation = edgeSpots[rng.nextInt(edgeSpots.length)];
        Integer dir = rng.nextInt(6);
        System.out.println(startLocation + " " + Integer.toString(dir));
        return startLocation + " " + Integer.toString(dir);
        //return "i 1 5";
    }

}

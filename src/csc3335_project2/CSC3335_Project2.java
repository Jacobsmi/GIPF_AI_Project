package csc3335_project2;

import csc3335.gipf_game.GipfGame;

/**
 *
 * @author stuetzlec
 */
public class CSC3335_Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize the game with a random seed
        GipfGame g = new GipfGame( 85 );
        // Play the game with two agents
        System.out.println("Result: " + g.playGame(new AI(g), new Random_Agent(g)));
        
        // testing copy constructor
        // GipfGame g2 = new GipfGame(g);
    }
    
}

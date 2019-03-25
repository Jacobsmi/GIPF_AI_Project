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
        int wins = 0;
        int numGames = 100;
        for(int i = 0; i <= numGames; i++) {
            // Initialize the game with a random seed

            GipfGame g = new GipfGame(85);
            // Play the game with two agents
            int result = g.playGame(new AI(g), new Random_Agent(g));
            System.out.println(result);
            if(result == 1){
                wins += 1;
            }

            // testing copy constructor
            // GipfGame g2 = new GipfGame(g);
        }
        System.out.println(wins + " wins out of " + numGames);
    }
    
}
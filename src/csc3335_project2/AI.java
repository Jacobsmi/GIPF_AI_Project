package csc3335_project2;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.GipfPlayable;

import java.util.ArrayList;
import java.util.Arrays;

public class AI implements GipfPlayable {
    GipfGame game;

    public AI(GipfGame g){
        this.game = g;
    }
    public String makeGipfMove(int curPlayer) {
        if(game.getPiecesLeft(0) == game.getPiecesLeft(1) && game.getPiecesLeft(0) >=16)
            determineMoves(2);
        else if(game.getPiecesLeft(0) == game.getPiecesLeft(1) && game.getPiecesLeft(0) <= 15)
            determineMoves(4);
        if(game.getPiecesLeft(0) != game.getPiecesLeft(1) && game.getPiecesLeft(1) >= 16)
            determineMoves(1);
        else if(game.getPiecesLeft(0) != game.getPiecesLeft(1) && game.getPiecesLeft(1) <= 15)
            determineMoves(3);
        return " ";
    }
    public void determineMoves(int piece){
        String[] edgeSpots = game.getEdgeSpots();
        ArrayList<Integer[][]> moves = new ArrayList<>();
        for(String spot : edgeSpots){
            for(int i = 0; i < 6; i++){
                GipfGame tempGame = new GipfGame(game);
                String move = spot + " " +Integer.toString(i);
                //System.out.println(move);
                boolean result = tempGame.makeMove(move, piece);
                if(result){
                    Integer[][] board = tempGame.getBoardCopy();
                    moves.add(board);
                }
            }

        }
        evaluate(moves);
    }
    public void evaluate(ArrayList<Integer[][]> moves){
        for(int i = 0; i < moves.size(); i++){
            Integer[][] tempBoard = moves.get(i);
            //Note to self some moves result in the same outcome can prune in this case
            System.out.println(Arrays.deepToString(tempBoard));
        }
    }

}
//CommitK
package csc3335_project2;

import csc3335.gipf_game.GipfGame;
import csc3335.gipf_game.GipfPlayable;

import java.util.ArrayList;

public class AI implements GipfPlayable {
    GipfGame game;
    int playerNumer;

    public AI(GipfGame g){
        this.game = g;
    }
    public String makeGipfMove(int curPlayer) {
        String move= "";
        if(game.getPiecesLeft(0) == game.getPiecesLeft(1) && game.getPiecesLeft(0) >=16){
            move = determineMoves(2);
            playerNumer = 0;
        }
        else if(game.getPiecesLeft(0) == game.getPiecesLeft(1) && game.getPiecesLeft(0) <= 15)
            move = determineMoves(4);
        if(game.getPiecesLeft(0) != game.getPiecesLeft(1) && game.getPiecesLeft(1) >= 16){
            move = determineMoves(1);
            playerNumer = 1;
        }
        else if(game.getPiecesLeft(0) != game.getPiecesLeft(1) && game.getPiecesLeft(1) <= 15)
            move = determineMoves(3);
        return move;
    }
    public String determineMoves(int piece){
        String[] edgeSpots = game.getEdgeSpots();
        ArrayList<Integer[][]> moves = new ArrayList<>();
        ArrayList<String> movesText = new ArrayList<>();
        for(String spot : edgeSpots){
            for(int i = 0; i < 6; i++){
                GipfGame tempGame = new GipfGame(game);
                String move = spot + " " + i;
                boolean result = tempGame.makeMove(move, piece);
                if(result){
                    Integer[][] board = tempGame.getBoardCopy();
                    moves.add(board);
                    movesText.add(move);
                }
            }

        }

        ArrayList<Integer> bestMoves = new ArrayList<>();
        bestMoves = evaluate(moves);
        if(bestMoves.size() == 1)
            return movesText.get(bestMoves.get(0));
        else
            return movesText.get(bestMoves.get((int) Math.floor(Math.random() * (bestMoves.size()-1))));
    }
    public void MiniMax(){

    }
    public ArrayList<Integer> evaluate(ArrayList<Integer[][]> moves){
        int[] function = new int[moves.size()];
        for(int i = 0; i < moves.size(); i++){
            Integer[][] tempBoard = moves.get(i);
            function[i] = 0;
            int x = 1;
            for(Integer[] row : tempBoard){
                for(int piece :row){
                   if(playerNumer == 0){
                       if(piece == 1 || piece == 3)
                           function[i] += 1;
                       if(piece == 2 || piece == 4)
                           function[i] -= 1;
                   }
                   else{
                       if(piece == 1 || piece == 3)
                           function[i] -= 1;
                       if(piece == 2 || piece == 4)
                           function[i] += 1;
                   }
                }
            }
        }
        int max = function[moves.size()-1];
        ArrayList<Integer> bestMoves = new ArrayList<>();
        bestMoves.add(moves.size() -1);
        for(int i = 0; i < moves.size()-1; i++){
            if(function[i] > max){
                max = function[i];
                bestMoves.clear();
                bestMoves.add(i);
            }
            if(function[i] == max){
                bestMoves.add(i);
            }
        }
        return bestMoves;
    }

}
package com.zybooks.tictactoe;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public enum MoveType{
        EX,OH
    }

    List<Integer> list = new ArrayList<Integer>();

    boolean player1Turn = true;
    int moveCount;
    MoveType moveType = MoveType.EX;
    int[][] winningPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, //hor
            {0,3,6}, {1,4,7}, {2,5,8}, // ver
            {0,4,8}, {2,4,6}
    };         // dia

    public Game() {

    }


    public boolean checkForWin(ImageView[] imageViews) {
        String[] field = new String[9];
        list.clear();
        for (int i = 0; i < 9; i++) {
            if (imageViews[i].getTag() != null) {
                field[i] = imageViews[i].getTag().toString();
                if (field[i] == moveType.toString()) {

                    list.add(i);
                }
            }
        }

        for (int[] winningPosition: winningPositions) {
            List<Integer> winningList = new ArrayList<Integer>();
            for(int i = 0; i < 3; i++) {
                winningList.add(winningPosition[i]);
            }
            if (list.contains(winningList)) {
                return true;
                
            }
        }


        /*for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }*/

        return false;
    }
}

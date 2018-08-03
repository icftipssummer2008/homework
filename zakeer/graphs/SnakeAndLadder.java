package com.learning.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zakeer on 7/31/18.
 */
public class SnakeAndLadder {

    class QueueEntry {
        int value;
        int distance;
    }

    private int numberOfCells;
    private int[] board;

    public void setBoard(int[] board) {
        this.board = board;
    }

    public SnakeAndLadder(int numberOfCells) {
        this.numberOfCells = numberOfCells;
        this.board = new int[this.numberOfCells];
    }

    public int getMinMoves() {
        boolean[] isVisited = new boolean[this.numberOfCells];
        Queue<QueueEntry> q = new LinkedList<>();
        QueueEntry vertex = new QueueEntry();
        vertex.value = 0;
        vertex.distance = 0;

        isVisited[0] = true;
        q.add(vertex);

        while(!q.isEmpty()) {
            vertex = q.remove();
            int v = vertex.value;

            if(vertex.value == this.numberOfCells - 1) break;

            for(int diceIndex = v+1; diceIndex <= (v + 6) && diceIndex < this.numberOfCells; diceIndex++ ) {
                if(!isVisited[diceIndex]) {
                    QueueEntry qe = new QueueEntry();
                    qe.distance =  (vertex.distance) + 1;
                    isVisited[diceIndex] = true;

                    if(board[diceIndex]!= -1)
                        qe.value = board[diceIndex];
                    else
                        qe.value = diceIndex;

                    q.add(qe);

                }
            }
        }
        return vertex.distance;
    }
}

class SnakeAndLadderMain {
    public static void main(String[] args) {
        int numberOfCells = 30;
        int[] board = new int[numberOfCells];

        for (int i = 0; i < numberOfCells; i++) board[i] = -1;

        // Ladders
        board[2] = 21;
        board[4] = 7;
        board[10] = 25;
        board[19] = 28;

        //Snakes
        board[16] = 3;
        board[18] = 6;
        board[20] = 8;
        board[26] = 0;

        SnakeAndLadder game = new SnakeAndLadder(numberOfCells);
        game.setBoard(board);
        System.out.println("Min moves: " + game.getMinMoves());
    }
}

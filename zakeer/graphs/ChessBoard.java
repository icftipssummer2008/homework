package com.learning.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zakeer on 8/1/18.
 */

class IndexObject {
    int noOfmoves;
    int row;
    int column;

    public IndexObject() {
        this.noOfmoves = -1;
    }

    public IndexObject(int row, int col, int noOfmoves) {
        this.noOfmoves = noOfmoves;
        this.row = row;
        this.column = col;
    }
}

public class ChessBoard {

    // Mark (row,col) as true if it is visited
    private boolean indexVisited[][];
    private int validRowMoves[] = {2,-2,-2,2,1,-1,1,-1};
    private int validColumnMoves[] = {-1,-1,1,1,-2,-2,2,2};


    public ChessBoard(int n) {
        this.indexVisited = new boolean[n][n];
    }

    public int getMinMovesOfKnight(IndexObject source, IndexObject destination) {
        if(isValidInputs(source)
                && isValidInputs(destination)) {
            Queue<IndexObject> q = new LinkedList<>();
            IndexObject sourceMove =  new IndexObject(source.row, source.column, 0);

            indexVisited[source.row][source.column] = true;
            q.add(sourceMove);

            while(!q.isEmpty()) {
                sourceMove = q.remove();
                int row = sourceMove.row;
                int col = sourceMove.column;

                if(destination.column == col
                        && destination.row == row)
                    break;

                for(int i=0; i < 8; i++) {
                    IndexObject destMove =
                            new IndexObject(row + validRowMoves[i], col + validColumnMoves[i], -1);

                    if(isValidInputs(destMove) && !indexVisited[destMove.row][destMove.column]) {
                        destMove.noOfmoves = sourceMove.noOfmoves + 1;
                        indexVisited[destMove.row][destMove.column] = true;
                        q.add(destMove);
                    }
                }
            }

            return sourceMove.noOfmoves;
        }
        else {
            System.out.println("Invalid Inputs");
            return -1;
        }
    }

    private boolean isValidInputs(IndexObject move) {
        int length = indexVisited.length;

        if(move.row>=0 && move.row<length
                && move.column>=0 && move.column<length) return true;
        return false;
    }
}

class ChessBoardMain {
    public static void main(String[] args) {
        int n = 8;

        IndexObject source = new IndexObject(0,4,0);
        IndexObject destination = new IndexObject(0,1,0);

        ChessBoard board = new ChessBoard(n);
        System.out.println("Min no of Moves:" + board.getMinMovesOfKnight(source, destination));
    }
}

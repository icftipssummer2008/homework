
/**
 * Created by asad.alim on 7/4/18.
 */
public class NQueen {

    class Position {
        int row,col;
        Position(int row,int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position [] placeQueen(int n) {
        Position [] position = new Position[n];

        if (hasSolution(n,0,position)) {
            return position;
        }
        else
            return new Position[0];
    }

    private boolean hasSolution(int n,int row,Position [] position) {

        if (n == row) {
            return true;
        }

        for (int col=0;col<n;col++) {
            boolean foundSafe=true;

            // Is there an Attack
            for (int queens = 0; queens < row; queens++) {
                if (position[queens].col == col || position[queens].row + position[queens].col == row + col ||
                        position[queens].row - position[queens].col == row - col) {
                    foundSafe = false;
                    break;
                }
            }

            if (foundSafe) {
                position[row] = new Position(row,col);
                if  (hasSolution(n,row+1,position))
                    return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        NQueen nqueen = new NQueen();
        int n=5;
        Position []  position = nqueen.placeQueen(n);
        System.out.println("Coordinates(x,y)");
        for (int i=0;i<n;i++) {
            System.out.println(position[i].row + " " + position[i].col);
        }
        System.out.println("Board (NxN)");
        for (int row=0;row<n;row++) {
            for (int col=0;col<n;col++) {
                System.out.print("| ");
                if (position[row].row == row && position[row].col == col)
                    System.out.print("Q ");
                else
                    System.out.print("  ");
            }
            System.out.println("|");
        }
    }

}


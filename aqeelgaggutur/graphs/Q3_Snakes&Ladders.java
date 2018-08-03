public int minThrows(int[] moves) {
    int numofThrows = 0;
    int stepAt = 0;
    int furthest = 0;
    while(stepAt != board.length - 1){
        for(int i = 1; i < 7 && stepAt + i < board.length; i++){
            int nextStep = stepAt + i;
            if(board[nextStep] > furthest) {
                furthest = board[nextStep];
            }
        }
        stepAt = furthest;
        numofThrows++;
    }

    return numofThrows;
}

public static void main(String[] args) {
    
    int[] board = new int[30];
    for(int i = 0; i < board.length; i++) {
        board[i] = i;
    }
    board[2] = 21;
    board[4] = 7;
    board[10] = 25;
    board[18] = 3;
    board[19] = 28;
    board[20] = 8;
    board[26] = 0;

    System.out.println(minThrows(board));
}
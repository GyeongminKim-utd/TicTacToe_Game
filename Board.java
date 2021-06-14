public class Board {            //Class that has the function to change square to player's mark and check the each board's status.
    //initialize the small board
    private char[] b = { '0','1','2','3','4','5','6','7','8' };

    //function to return each value of square
    public char getBox(int num) { 
        return b[num];
    }

    //function to check if board is full or not.
    public boolean isFull() {
        return (!isAvailable(0) && !isAvailable(1) && !isAvailable(2) && !isAvailable(3)&& !isAvailable(4) && !isAvailable(5) && !isAvailable(6) && !isAvailable(7) && !isAvailable(8));
  
    }

    //function to check if selected square is taken or not
    public boolean isAvailable(int square) {
        char squareValue = getBox(square);
        return (squareValue >= '0' && squareValue <= '8');      //the board is initialized with 0 to 8 character value, so if the selected square is in that range, it is available(true)
    }

    //the function to check if the each board has winner or not
    public boolean isWinner(char player) {
        return ((b[0] == player && b[1] == player && b[2] == player) ||
        (b[3] == player && b[4] == player && b[5] == player) ||
        (b[6] == player && b[7] == player && b[8] == player) ||
        (b[0] == player && b[3] == player && b[6] == player) ||
        (b[1] == player && b[4] == player && b[7] == player) ||
        (b[2] == player && b[5] == player && b[8] == player) ||
        (b[0] == player && b[4] == player && b[8] == player) ||
        (b[2] == player && b[4] == player && b[6] == player));
        
    }

    //function to change the selected square to the player's mark
    public void setMarker(int index, char marker) {
        b[index] = marker;
    }

    
}

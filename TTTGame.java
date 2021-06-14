import java.util.Scanner;
/* 
Name: Kate Kim
Gxk180021
CS2336.0W1

Analysis:
    This program is to run the Tic Tac Toe game with human player versus AI.
    
Design:
    make Board class to store the each square information for each board
    create 9 boards and an array that contains 9 boards.
    make the print function
    function to get board and square number value from the user
    function to get the random number in range of 0-8 for board and square number from the AI
    function to check if there is winner in the whole board
    main function to run the game.
    game is looping until there is winneror if all the boards are full and there is no winner, print out that the game is tied and break the loop. 
 */
public class TTTGame {

    //initialize 9 boards using board
    static Board board0 = new Board();
    static Board board1 = new Board();
    static Board board2 = new Board();
    static Board board3 = new Board();
    static Board board4 = new Board();
    static Board board5 = new Board();
    static Board board6 = new Board();
    static Board board7 = new Board();
    static Board board8 = new Board();
    static Board[] boards = { board0, board1, board2, board3, board4, board5, board6, board7, board8 };

    // function to print out the boards
    public static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");
            }
        }
        System.out.println("");

        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");
            }
        }
        System.out.println("");

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");
            }
        }
        System.out.println("");

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");
            }
        }
        System.out.println("");

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | "); 
            }
        }
        System.out.println("");

        for (int i = 3; i < 6; i++) {  
            for (int j = 6; j < 9; j++) {   
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");   
            }
        }
        System.out.println("");

        for (int i = 6; i < 9; i++) {    
            for (int j = 0; j < 3; j++) {   
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");    
            }
        }
        System.out.println("");

        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");
            }
        }
        System.out.println("");

        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("BOARD#" + i);
                }
                System.out.print(" | " + boards[i].getBox(j) + " | ");
            }
        }
        System.out.println("");
    }    

    //human player
    public static int userSelectBoard() {       //function to get value from the user about board (what board the user wants to play.)
        int size = 8;
        int boardNum = 0;
        Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please select a valid board (0 - 8): ");
			while (!input.hasNextInt()) {
				System.out.println("Please select an integer value: ");
				input.next();
			}
			boardNum = input.nextInt();
		} while (boardNum < 0 || boardNum > size);
        input.close();
        return boardNum;
    }

    public static int userSelectSquare() {       //function to get value from the user about square(what square the user wants to play within selected board.)
        int size = 8;
        int squareNum = 0;
        Scanner input = new Scanner(System.in);
        do {
			System.out.println("Please select a valid square (0 - 8): ");
			while (!input.hasNextInt()) {
				System.out.println("Please select an integer value: ");
				input.next();
			}
			squareNum = input.nextInt();
		} while (squareNum < 0 || squareNum > size);
        System.out.println("User Selected Square : " + squareNum);
        input.close();
        return squareNum;

    }
    //computer player
    public static int computerSelectBoard() {           //randomly select the board number within the range of 0-8
        int boardNum  = (int) (Math.random() * 9);
        System.out.println("AI Selected Board : " + boardNum);
        return boardNum;
    }

    public static int computerSelectSquare() {           //randomly select the square number within the range of 0-8
        int size = 9;
        int squareNum = (int) (Math.random() * size);
        System.out.println("AI Selected Square : " + squareNum);
        return squareNum;
    }

    //function to switch player 
    public static int switchPlayer(int player) {
        if (player == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    //function to check if there is winner.
    public static boolean isWinner(char player) {
        return ((boards[0].isWinner(player)) && (boards[1].isWinner(player)) && (boards[2].isWinner(player) )|| 
            (boards[3].isWinner(player)) && (boards[4].isWinner(player)) && (boards[5].isWinner(player)) || 
            (boards[6].isWinner(player)) && (boards[7].isWinner(player)) && (boards[8].isWinner(player)) ||
            (boards[0].isWinner(player)) && (boards[3].isWinner(player)) && (boards[6].isWinner(player)) || 
            (boards[1].isWinner(player)) && (boards[4].isWinner(player)) && (boards[7].isWinner(player)) || 
            (boards[2].isWinner(player)) && (boards[5].isWinner(player)) && (boards[8].isWinner(player)) || 
            (boards[0].isWinner(player)) && (boards[4].isWinner(player)) && (boards[8].isWinner(player)) || 
            (boards[2].isWinner(player)) && (boards[4].isWinner(player)) && (boards[6].isWinner(player)));
    }
    public static void main(String[] args) {
        int player = 0;
        char[] playerMark = { 'X', 'O' };
        int square = 0;
        System.out.println ("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
        print();
        boolean winner = false;
        int mode;
        System.out.println ("Choose which mode you want to play: ");
        System.out.println ("1. Human Vs. AI");
        System.out.println ("2. AI Vs. AI");
        System.out.println ("3. Human Vs. Human");
        Scanner input = new Scanner(System.in);
        mode= input.nextInt();
        while (mode != 1 && mode != 2 && mode != 3) {
            System.out.print("Invalid input! Please Select mode 1, 2, or 3: ");
            mode= input.nextInt();
        }
        //Human vs AI
        if (mode == 1) {
            int board = userSelectBoard();
        //loop until there is winner.
            while (!winner) {
                System.out.println("The current player is:  " + playerMark[player]);
                System.out.println("The current board is:  " + board);
                //make the player re-choose the board if the board is full.
                if (boards[board].isFull()) {
                    if (player == 0) {
                        board = userSelectBoard();
                    } else {
                        board = computerSelectBoard();
                    }
                }

                //if it is user's turn, let user select the square, if it is AI's turn, let AI select the square
                if (player == 0) {
                    square = userSelectSquare();
                } else {
                    square = computerSelectSquare();
                }
                
                //if the selected square is already taken, let player choose the other square to play
                while (!boards[board].isAvailable(square)) {
                    System.out.println("Square is already taken.Please select again.");
                    if (player == 0) {
                        square = userSelectSquare();
                    } else {
                        square = computerSelectSquare();
                    }
                }
                boards[board].setMarker(square, playerMark[player]);
                //print after player played the square
                print();
                
                //check if there is winner or not
                winner = isWinner(playerMark[player]);
                
                //print out the winner's information before the loop ends. and else if function if there is no winner and the board is all full, let players know it is tie and end the loop
                if (winner) {
                    System.out.println(" The Winner is " + playerMark[player]);
                } else if (boards[0].isFull() && boards[1].isFull() && boards[2].isFull() && boards[3].isFull() &&
                boards[4].isFull() && boards[5].isFull() && boards[6].isFull() && boards[7].isFull() && boards[8].isFull()) {
                    System.out.println("It is tie! ");
                    winner = true;
                }                
              
                //switch the player
                player = switchPlayer(player);
                //the previous player's choice of square becomes the board that next player must play in.
                board = square;
                
            }
        }
        // AI vs AI
        else if (mode == 2) {

            int board = computerSelectBoard();

            while (!winner) {
                System.out.println ("The current player is: " + playerMark[player]);
                System.out.println ("The current board is: " + board);
                square = computerSelectSquare();

               
                //make the AI to re-choose the board if the board is full
                while (boards[board].isFull()) {
                    board = computerSelectBoard();
                }   
                 //make the AI to re-choose the square if the square is taken.
                while (!boards[board].isAvailable(square)) {
                    System.out.println("Square is already taken.Please select again.");
                    square = computerSelectSquare(); 
                }             
                boards[board].setMarker(square, playerMark[player]);

                //print after player played the square
                print();
                
                //check if there is winner or not
                winner = isWinner(playerMark[player]);
                
                //print out the winner's information before the loop ends. and else if function if there is no winner and the board is all full, let players know it is tie and end the loop
                if (winner) {
                    System.out.println("The Winner is " + playerMark[player]);
                } else if (boards[0].isFull() && boards[1].isFull() && boards[2].isFull() && boards[3].isFull() &&
                boards[4].isFull() && boards[5].isFull() && boards[6].isFull() && boards[7].isFull() && boards[8].isFull()) {
                    System.out.println("It is tie!");
                    winner = true;
                }
                //switch the player
                player = switchPlayer(player);
                //the previous player's choice of square becomes the board that next player must play in.
                board = square;
            }
        }
        //Human vs Human
        else if (mode == 3) {
            int board = userSelectBoard();

            //loop until there is winner.
            while (!winner) {
                System.out.println("The current player is: " + playerMark[player]);
                System.out.println("The current board is: " + board);
                //make the player re-choose the board if the board is full.
                if (boards[board].isFull()) {
                    board = userSelectBoard();
                }

                //let AI select the square
                square = userSelectSquare();
                
                //if the selected square is already taken, let player choose the other square to play
                while (!boards[board].isAvailable(square)) {
                    System.out.println("Square is already taken. Please select again.");
                   square = userSelectSquare();
                }
                boards[board].setMarker(square, playerMark[player]);
                //print after player played the square
                print();
                
                //check if there is winner or not
                winner = isWinner(playerMark[player]);
                
                //print out the winner's information before the loop ends. and else if function if there is no winner and the board is all full, let players know it is tie and end the loop
                if (winner) {
                    System.out.println("The Winner is " + playerMark[player]);
                } else if (boards[0].isFull() && boards[1].isFull() && boards[2].isFull() && boards[3].isFull() &&
                boards[4].isFull() && boards[5].isFull() && boards[6].isFull() && boards[7].isFull() && boards[8].isFull()) {
                    System.out.println("It is tie!");
                    winner = true;
                }
                //switch the player
                player = switchPlayer(player);
                //the previous player's choice of square becomes the board that next player must play in.
                board = square;
            }
        }
        input.close();
    }

}
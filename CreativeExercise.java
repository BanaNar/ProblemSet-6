/***********************************************
 * @ file TicTacToe.java
 * @ brief This program create a update version of Tic Tac Toe with method.
 * @ author Jianqiu Xu (Tony)
 * @ date October 20, 2017
 ***********************************************/
import java.awt.*;

public class CreativeExercise {
    public static void main(String[] args){
        int[][] board = new int[3][3]; //2-D array for 3*3 broad
        int i = 0; //loop index
        int numClicks = 0;
        int turn = 1;
        double x = 0.0;
        double y = 0.0;
        double radius;
        final int EMPTY = 0;
        final int Turn_O = 1;
        final int Turn_X = 2;

        //Draw the graph with method
        drawGraph(StdDraw.BLACK);

        while(numClicks < 9){
            //Has the mouse been clicked?
            if(StdDraw.mousePressed()){
                //If the mouse is pressed, get the x and y location
                x = StdDraw.mouseX();
                y = StdDraw.mouseY();

                //Whether the space is clicked earlier or not
                if (board[(int)x][(int)y] == EMPTY) {
                    //If the space is not clicked, Draw circle, Odd number turns
                    if (turn == Turn_O) {

                        StdDraw.setPenColor(Color.BLUE);
                        StdDraw.circle(Math.floor(x) + 0.5, Math.floor(y) + 0.5, 0.5);
                        board[(int)x][(int)y] = Turn_O;

                    }
                    //If the space is not clicked, Draw cross, Even number turns
                    else if (turn == Turn_X) {

                        StdDraw.setPenColor(Color.RED);
                        StdDraw.line(Math.floor(x), Math.floor(y), Math.ceil(x), Math.ceil(y));
                        StdDraw.line(Math.floor(x) + 1, Math.floor(y), Math.ceil(x) - 1, Math.ceil(y));
                        board[(int)x][(int)y] = Turn_X;

                    }

                    // isWinner
                    if (isWinner(board,turn) == true){
                        if(turn == Turn_O){
                            showMessage("Player O Won!");
                        }
                        else if(turn == Turn_X){
                            showMessage("Player X Won!");
                        }

                        break;
                    }

                    if (turn == Turn_O){
                        turn = Turn_X;
                    }
                    else{
                        turn = Turn_O;
                    }

                    //pause between receiving each click
                    StdDraw.pause(300);
                    numClicks++;
                }
                //If the space is clicked before, do not draw anything
                else {

                }
            }
        }
    }

    /*
    * Method drawGraph()
    * Input: nothing
    * Output: return void
    * Purpose: the method draws a 3*3 graph on the canvas
    */
    public static void drawGraph(Color black){
        //Print 3*3 Graph
        int i = 0;
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setScale(0, 3);
        for (i = 0; i <= 3; i++) {
            StdDraw.line(i, 0, i, 3);
            StdDraw.line(0, i, 3, i);
        }

    }

    /*
    * Method showMessage()
    * Input: String
    * Output: return void
    * Purpose: the method show message
    */
    public static void showMessage(String text){
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(1.5, 1.5, text);

    } // End of showMessage Method


    /*
    * Method isWinner()
    * Input: array, int
    * Output: boolean
    * Purpose: the method determines whether there is a winner in the game
    */
    public static boolean isWinner(int[][] board, int turn) {
        boolean winner = false;

        if (board[0][0]==turn && board[0][1]==turn && board[0][2]==turn){ // 1st row
            winner = true;
        }
        else if (board[1][0]==turn && board[1][1]==turn && board[1][2]==turn){ // 2nd row
            winner = true;
        }
        else if (board[2][0]==turn && board[2][1]==turn && board[2][2]==turn){ // 3rd row
            winner = true;
        }
        else if (board[0][0]==turn && board[1][0]==turn && board[2][0]==turn){ // 1st column
            winner = true;
        }
        else if (board[0][1]==turn && board[1][1]==turn && board[2][1]==turn){ // 2nd column
            winner = true;
        }
        else if (board[0][2]==turn && board[1][2]==turn && board[2][2]==turn){ // 3rd column
            winner = true;
        }
        else if (board[0][0]==turn && board[1][1]==turn && board[2][2]==turn){ // Bottom left to Top right
            winner = true;
        }
        else if (board[0][2]==turn && board[1][1]==turn && board[2][0]==turn){ // Bottom right to Top left
            winner = true;
        }

        return winner; // return whether there is a winner

    }

}

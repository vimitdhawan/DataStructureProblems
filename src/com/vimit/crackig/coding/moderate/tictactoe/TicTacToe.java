package com.vimit.crackig.coding.moderate.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Game is about to start ");
        System.out.println("Please enter name for player1 ");
        String player1Name = sc.next();

        System.out.println("Please enter name for player2 ");
        String player2Name = sc.next();
        Board  board = new Board(3);
        Player player1 = new Player(player1Name, Unit.CROSS, board);
        Player player2 = new Player(player2Name, Unit.CIRCLE, board);

        boolean isTurn = true;
        boolean isWon = false;
        int totalMove = 0;
        while(!isWon && totalMove<9){
            totalMove = totalMove+1;
            if(isTurn){
                System.out.println(player1Name + " its your turn");
                isWon = turn(sc, player1);
            } else{
                System.out.println(player2Name + " its your turn");
                isWon = turn(sc, player2);
            }
            if(isWon && isTurn){
                System.out.println(player1Name + "won the game");
            } else if(isWon && !isTurn){
                System.out.println(player2Name + "won the game");
            }
            isTurn = !isTurn;
        }
    }

    private static boolean turn(Scanner sc, Player player) {
        String move1 = sc.next();
        String move2 = sc.next();
        int row = Integer.parseInt(move1);
        int column = Integer.parseInt(move2);
        return player.move(row, column);
    }
}

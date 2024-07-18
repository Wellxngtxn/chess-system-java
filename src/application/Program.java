
package application;

import chess.ChessException;
import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
       
       Scanner leia = new Scanner(System.in);  
       ChessMath chessMath = new ChessMath();
       List<ChessPiece> captured = new ArrayList<>();
       
       while(!chessMath.getCheckMate()){
            try{
                UI.clearScreen();
                UI.printMathc(chessMath, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(leia);
                
                boolean[][] possibelMoves = chessMath.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMath.getPieces(), possibelMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(leia);

                ChessPiece capturedPiece = chessMath.performChessMove(source, target);
                
                if(captured != null){
                   captured.add(capturedPiece);
                }
                
                if(chessMath.getPromoted() != null){
                    System.out.println("Enter piece for promotion (B/N/R/Q)");
                    String type = leia.nextLine();
                    chessMath.replacePromotedPiece(type);
                }
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                leia.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                leia.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMathc(chessMath, captured);
    }
}
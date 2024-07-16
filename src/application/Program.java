
package application;

import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
       
       Scanner leia = new Scanner(System.in);  
       ChessMath chessMath = new ChessMath();
       
       while(true){
           UI.printBoard(chessMath.getPieces());
           System.out.println();
           System.out.print("Source: ");
           ChessPosition source = UI.readChessPosition(leia);
           
           System.out.println();
           System.out.print("Target: ");
           ChessPosition target = UI.readChessPosition(leia);
           
           ChessPiece capturedPiece = chessMath.performChessMove(source, target);
       }  
    }
}

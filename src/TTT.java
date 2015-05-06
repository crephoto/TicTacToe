import java.util.*;
/**
 * @author kevin
 *
 */
public class TTT {

	public static void main(String[] args) {
		Game board = new Game();
		Scanner scan = new Scanner(System.in);
		board.Render();
		while (! board.detectWin() && board.legal_moves().size() > 0){
			Minimax brain = new Minimax();
			brain.Search(board, brain.tree);
			board = brain.best_move(board);
			board.Render();
			if (! board.detectWin() && board.legal_moves().size() > 0){
				break;
			}
			String s = scan.next();
			Integer t = Integer.valueOf(s);
			board.Move(t);
		}
		if (board.detectWin()){
			if (board.XWins()){
				System.out.println("X Wins");
			}
			else {
				System.out.println("Y Wins");
			}
		}
		else {
			System.out.println("Draw!");
		}
		scan.close();

	}

}

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
		while (! board.detectWin()){
			Minimax brain = new Minimax();
			brain.Search(board, brain.tree);
			board = brain.best_move(board);
			board.Render();
			String s = scan.next();
			Integer t = Integer.valueOf(s);
			board.Move(t);
			
		}
		

	}

}

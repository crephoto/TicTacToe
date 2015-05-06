
/**
 * @author kevin
 *
 */
public class TTT {

	public static void main(String[] args) {
		Game board = new Game();
		board.Render();
		Minimax brain = new Minimax();
		brain.Search(board, brain.tree);
		System.out.println(brain.Traverse(brain.tree, board));
		System.out.println(board.legal_moves());
		

	}

}

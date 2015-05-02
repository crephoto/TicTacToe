
/**
 * @author kevin
 *
 */
public class TTT {

	public static void main(String[] args) {
		Game board = new Game(0b100001010, 0b010000000);
		board.Render();
		Minimax search = new Minimax();
		search.buildTree(board);
		

	}

}

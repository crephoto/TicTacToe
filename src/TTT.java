
/**
 * @author kevin
 *
 */
public class TTT {

	public static void main(String[] args) {
		Game board = new Game(0b100100001, 0b010000010);
		Minimax search = new Minimax();
		search.buildTree(board);
		

	}

}

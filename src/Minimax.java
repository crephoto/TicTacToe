import java.util.*;

public class Minimax {
	Tree tree = new Tree();
	int count = 0;
	public void Search(Game position, Tree current_tree){
		ArrayList<Integer> gen = position.legal_moves();
		for (int i = 0; i < gen.size(); i++){
			Game next_move = new Game(position.Xboard, position.Oboard, position.turn);
			next_move.Move(gen.get(i));
			current_tree.addChild(next_move);
			count += 1;
			System.out.println(count);
//			try {
//				Thread.sleep(5000);
//			} catch(InterruptedException ex) {
//				Thread.currentThread().interrupt();
//			}
			if (! next_move.detectWin()){
				Search(next_move, current_tree.tree.get(next_move));
			}
		}
	}
}
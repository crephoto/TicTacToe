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
//			next_move.Render();
			
//			try {
//				Thread.sleep(500);
//			} catch(InterruptedException ex) {
//				Thread.currentThread().interrupt();
//			}
			if (! next_move.detectWin()){
				Search(next_move, current_tree.tree.get(next_move));
			}
			if (next_move.detectWin() || next_move.legal_moves().size() == 0){
				count += 1;
				System.out.println(count);
			}
		}
	}
	public int Traverse(Tree node, Game setup){
		int Score = 0;
		ArrayList<Integer> Scores = new ArrayList<>();
		if (node.childrenCount == 0){
			if (setup.detectWin()){
				return 0;
			}
			else{
				if (setup.XWins()){
					return 1;
				}
				else{
					return -1;
				}
			}
		}
		for (int i = 0; i < node.childrenCount; i++){
			Scores.add(Traverse(node.tree.get(node.children[i]), node.children[i]));
		}
		for (int i = 0; i < Scores.size(); i++){
			if (setup.turn){
				if (Scores.get(i) > Score){
					Score = Scores.get(i);
				}
			}
			else {
				if (Scores.get(i) < Score){
					Score = Scores.get(i);
				}
			}
		}
		return Score;
	}
}
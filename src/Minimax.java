import java.util.*;

public class Minimax {
	Tree tree;
	int count;
	public Minimax(){
		tree = new Tree();
		count = 0;
	}
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
			if (! next_move.detectWin() && next_move.legal_moves().size() > 0){
				Search(next_move, current_tree.tree.get(next_move));
			}
			if (next_move.detectWin() || next_move.legal_moves().size() == 0){
				count += 1;
	//			System.out.println(count);
			}
		}
	}
	public int Traverse(Tree node, Game setup){
		int Score = 0;
		ArrayList<Integer> Scores = new ArrayList<>();
		if (node.childrenCount == -1 || setup.detectWin()){
			if (! setup.detectWin()){
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
		for (int i = 0; i <= node.childrenCount; i++){
			Scores.add(Traverse(node.tree.get(node.children[i]), node.children[i]));
		}
		System.out.println(Scores);
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
	public Game best_move(Game setup){
		HashMap<Integer, Integer> moves = new HashMap<>();
		for (int i = 0; i <= tree.childrenCount; i++){
			moves.put(i, Traverse(tree.tree.get(tree.children[i]), tree.children[i]));
		}
		boolean printed = false;
		for (int i = 0; i < moves.size(); i++){
			if (moves.get(i) == 1 && ! printed){
				System.out.println("Searched " + Integer.toString(count) + " nodes and found a score of 1");
				printed = true;
			}
		}
		for (int i = 0; i < moves.size(); i++){
			if (moves.get(i) == 0 && ! printed){
				System.out.println("Searched " + Integer.toString(count) + " nodes and found a score of 0");
				printed = true;
			}
		}
		for (int i = 0; i < moves.size(); i++){
			if (moves.get(i) == -1 && ! printed){
				System.out.println("Searched " + Integer.toString(count) + " nodes and found a score of -1");
				printed = true;
			}
		}
		System.out.println(moves);
		Game final_move = new Game();
		for (int i = 0; i < moves.size(); i++){
			if (moves.get(i) == -1){
				final_move = new Game(tree.children[i].Xboard, tree.children[i].Oboard, tree.children[i].turn);
			}
		}
		for (int i = 0; i < moves.size(); i++){
			if (moves.get(i) == 0){
				final_move = new Game(tree.children[i].Xboard, tree.children[i].Oboard, tree.children[i].turn);
			}
		}
		for (int i = 0; i < moves.size(); i++){
			if (moves.get(i) == 1){
				final_move = new Game(tree.children[i].Xboard, tree.children[i].Oboard, tree.children[i].turn);
			}
		}
		return final_move;
	}
}
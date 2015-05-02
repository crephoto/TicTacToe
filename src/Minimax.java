
public class Minimax {
	Tree tree = new Tree();
	private int eval = 0;
	public void buildTree(Game currentState){
		for (int i = 0; i < currentState.board.length; i++){
			if ((currentState.board[i] & currentState.moveGen()) == currentState.board[i]){
				Game next = new Game(currentState.Xboard, currentState.Oboard);
				next.Move(i);
//				next.Render();
				tree.addChild(next);
				eval += 1;
			}
			
		}
		extendTree(tree);
	}
	private void extendTree(Tree currentState){
		
		for (int i = 0; i < currentState.childrenCount; i++){
			if (! currentState.children[i].detectWin()){
				for (int x = 0; x < currentState.children[i].board.length; x++){
					int wtf =  currentState.children[i].moveGen();
					if ((currentState.children[i].board[i] & currentState.children[i].moveGen()) == currentState.children[i].board[i]){
						Game next = new Game(currentState.children[i].Xboard, currentState.children[i].Oboard);
						next.Move(x);
						currentState.tree.get(currentState.children[i]).addChild(next);
						eval += 1;
					}
				}
			}
			for (int x = 0; x < currentState.tree.get(currentState.children[i]).childrenCount; x++)
				System.out.println(eval);
				extendTree(currentState.tree.get(currentState.children[i]));
		}

	}
}

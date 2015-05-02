import java.util.*;

public class Tree {
	public HashMap<Game, Tree> tree = new HashMap<>();
	public Game children[] = new Game[9];
	public boolean turn;
	public int childrenCount = -1;
	public Tree(boolean oldTurn){
		turn = !oldTurn;
	}
	public Tree(){
		turn = true;
	}
	public void addChild(Game child){
		tree.put(child, new Tree(turn));
		childrenCount += 1;
		children[childrenCount] = child;
	}
}

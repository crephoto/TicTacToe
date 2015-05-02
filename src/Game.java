
public class Game {
	public boolean Xboard[][] = new boolean[3][3];
	public boolean Oboard[][] = new boolean[3][3];
	private boolean wins[][][] = new boolean[8][3][3];
	private boolean turn = true;
	public Game(){
		for (int i = 0; i < 3; i++){
			for (int x = 0; x < 3; x++){
				Xboard[i][x] = false;
				Oboard[i][x] = false;
				for (int y = 0; y < 8; y++){
					wins[y][i][x] = false; // initalize win bitboards to false
				}
			}
		}
		for (int i = 0; i < 8; i++){
			if (i < 3){ // the first three boards are horizontal / vertical wins
				for 
				wins[i][]
			}
		}
	}
	public void Render(){
		for (int i = 0; i < 3; i++){
			for (int x = 0; x < 3; x++){
				if (Xboard[i][x]){
					System.out.printf("X");
				}
				else if (Oboard[i][x]){
					System.out.printf("O");
				}
				else {
					System.out.printf(" ");
				}
				if (x != 2){
					System.out.printf("|");
				}
			}
			System.out.println();
			if (i != 2){
				System.out.println("______");
			}
			
		}
	}
	public void Move(int rank, int file){
		if (turn){ 						// turn being true means X to move
			Xboard[rank][file] = true;
		}
		else {
			Oboard[rank][file] = true;
		}
		turn = !turn;
	}
	public void detectWin(){ // probably could do this by pattern matching for speed, but im lazy
		if boar
	}
}

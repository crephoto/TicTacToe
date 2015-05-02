
public class Game {
	public int Xboard;
	public int Oboard;
	public int board[] = new int[9];
	private int wins[] = new int[8];
	private boolean turn = true;
	public Game(){
		Xboard  = 0b000000000;
		Oboard  = 0b000000000;
		Init();
	}
	public Game(int X, int O){
		Xboard = X;
		Oboard = O;
		Init();
	}
	public void Init(){
		wins[0] = 0b111000000;
		wins[1] = 0b000111000;
		wins[2] = 0b000000111;
		wins[3] = 0b100100100;
		wins[4] = 0b010010010;
		wins[5] = 0b001001001;
		wins[6] = 0b100010001;
		wins[7] = 0b001010100;
		board[0] = 0b100000000;
		board[1] = 0b010000000;
		board[2] = 0b001000000;
		board[3] = 0b000100000;
		board[4] = 0b000010000;
		board[5] = 0b000001000;
		board[6] = 0b000000100;
		board[7] = 0b000000010;
		board[8] = 0b000000001;
	}
	public void Render(){
		for (int i = 0; i < 9; i++){
			if ((board[i] & Xboard) == board[i]){
				System.out.printf("X");
			}
			else if ((board[i] & Oboard) == board[i]){
				System.out.printf("O");
			}
			else {
				System.out.printf(" ");
			}
			if ((i % 3) != 2){
				System.out.printf("|");
			}
			if (((i + 1) % 3) == 0 && i != 0){
				System.out.println();
				if (i < 8){
				System.out.println("______");
				}
			}
		}		
	}
	public void Move(int square){
		if (turn){ 						// turn being true means X to move
			Xboard = Xboard | board[square];
		}
		else {
			Oboard = Oboard | board[square];
		}
		turn = !turn;
	}
	public int moveGen(){
		return ~(Xboard | Oboard);
		
	}
	public boolean detectWin(){ // probably could do this by pattern matching for speed, but im lazy
		for (int i = 0; i < 8; i++){
			if ((Xboard & wins[i]) == wins[i]){
				return true;
			}
			if ((Oboard & wins[i]) == wins[i]){
				return true;
			}
		}
		return false;
	}
}

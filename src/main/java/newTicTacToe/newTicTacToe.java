package newTicTacToe;

import java.util.Scanner;

public class newTicTacToe {

	public static void main(String[] args) {
		
		
		//Various Variables used in main()
		Scanner input = new Scanner(System.in);
		char[] board = createBoard();
		char playerSymbol = playerChooseSymbol(input) , opponentSymbol = (playerSymbol == 'X') ? 'O' : 'X' ;
		boolean playerPlaysFirst = toss(input);
		
		showBoard(board);
		do {
			System.out.println("Player please make your move.");
			makeMove(board, input, playerSymbol);
			
		} while (true);
		
	}

	
	//UC1
	private static char[] createBoard() {
		char[] board = new char[10];
		for(int i =0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}
	
	
	//UC2
	public static char playerChooseSymbol(Scanner sc) {
		
		System.out.println("Please Select your symbol [X] or [O]");
		
		while(true) {	
			
			char playerChar = sc.next().charAt(0);
			
			if (Character.compare(playerChar, 'x') == 0 || Character.compare(playerChar, 'X') == 0) {
				System.out.println("Player selected character [X].");
				return 'X';
			}
			else if (Character.compare(playerChar, 'o') == 0 || Character.compare(playerChar, 'O') == 0) {
				System.out.println("Player selected character [O].");
				return 'O';
			}
			else {System.out.println("Enter only enter the alphabets X or O.");}
		}	
	}
	
	//UC3
	public static void showBoard(char[] board1) {
		
		System.out.println("-------         Position Map-");
		for (int i = 1 ; i< 10 ; i++) {
			System.out.printf("|" + board1[i]);
			if(i%3==0) {
				System.out.printf("|         [%d][%d][%d]\n",i-2,i-1,i);
			}
		}
		System.out.println("-------");
	}
	
	
	//UC4
	public static void makeMove(char[] board2, Scanner Input, char playerChar) {
		
		
		int slotStatus = isIndexEmpty(board2, Input);
		
		if(slotStatus != 0) {
			board2[slotStatus] = playerChar;
			showBoard(board2);
		}
		else {
			System.out.printf("\n\n !!! The position you selected is already filled !!! \n"
					          + "!!! Please select empty position !!!\n\n");
			makeMove(board2, Input, playerChar);
		}
	}
	
	
	//UC4 and UC5
	public static int isIndexEmpty(char[] board1, Scanner input) {
		
			int index = 0;
			
		while(true) {
			System.out.println("Please enter a position between 1 to 9.");
			index = input.nextInt();
			if (index > 0 && index <10 ) {
				break;
			}
			
		}
		if ( board1[index] == 'X' || board1[index] == 'O') {
			return 0;
		}
		return index;
	}
	
	
	//UC6
	public static boolean toss(Scanner sc) {
		
		System.out.println("Type [H] or [T] for coin toss.");
		char playerTossCall = sc.next().toUpperCase().charAt(0);
				
		if (playerTossCall != 'H' && playerTossCall != 'T') 
			toss(sc);
		else
			System.out.println("A coin was tossed");
		
		boolean playerWonOrNot = ( (int) (Math.random()*10) % 2 == 0) ? true : false;
		if (playerWonOrNot)
			System.out.printf("Coin turned up [%s]. You Won. You will play first.\n",playerTossCall);
		else
			System.out.printf("Coin turned up [%s]. You lost. Your opponent will play first.\n",
							   (playerTossCall == 'H') ? 'T' : 'H' );
		
		return  playerWonOrNot;
	}
	
	
}



import java.util.Scanner;

public class App {
    public static char moves[] = new char[]{
        '_','_','_',
        '_','_','_',
        '_','_','_'
    };
    public static int winnerMoves[][] = new int[][]{
        // horizontally
        {0,1,2},
        {3,4,5},
        {6,7,8},
        
        // vertically
        {0,3,6},
        {1,4,7},
        {2,5,8},
        
        // diagonally
        {0,4,8},
        {2,4,6},
    };
    public static Scanner scanner = new Scanner(System.in);
    public static int turn = 0; // 0 is player 1 (X) and 1 is player 2 (O)
    public static int turnCount = 0;

    public static void main(String[] args) {
        renderScreen();
    }

    public static String getPlayerName(){
        return (turn == 0 ? "Player 1" : "Player 2");
    }

    public static char getPlayerSign(){
        return (turn == 0 ? 'O' : 'X');
    }

    public static void enterToContinue(){
        scanner.nextLine();
    }

    public static void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(moves[i * 3 + j]);
                if(j != 2){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static boolean placeMove(int x, int y){
        if(x > 2 || x < 0 || y > 2 || y < 0) return false;
        if(moves[y * 3 + x] != '_') return false;
        moves[y * 3 + x] = getPlayerSign(); 
        return true;
    }

    public static boolean isTie(){
        return turnCount == 9 && !checkWins('_') && !checkWins('X') && !checkWins('O');
    }

    public static void swapTurn(){
        if(turn == 0) turn = 1;
        else turn = 0;
    }

    public static boolean checkWins(char currentPlayerChar){
        for(int[] winnerMove : winnerMoves){
            boolean allValid = true;
            for(int index : winnerMove){
                if(moves[index] != currentPlayerChar) allValid = false; 
            }
            if(allValid){
                return true;
            }
        }

        return false;
    }

    public static void play(){
        boolean validMove;
        int x;
        int y;
        do {
            System.out.print(getPlayerName() + " move: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            validMove = placeMove(x, y);
            if(validMove == false){
                System.out.println("You cant move to that tile!");
            }
        }while(!validMove);

        turnCount++;
    }
    
    public static void renderScreen(){
        System.out.println("Welcome to basic tictactoe!");
        System.out.print("Enter to continue to start the game...");
        enterToContinue();
        System.out.println();
        
        while(true){
            play();
            printBoard();
            if (checkWins(getPlayerSign())) {
                System.out.println(getPlayerName() + " Wins!");
                break;
            }else if(isTie()){
                System.out.println("Tie game");
                break;
            }
            swapTurn();
        };
        
        System.out.println("");
        System.out.print("Thankyou for playing!");
    }
}

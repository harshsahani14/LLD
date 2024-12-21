import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToe {
    
    enum PieceType{
        O,
        X;
    }
    
    public class PlayingPiece{

        PieceType piece;

        PlayingPiece(PieceType piece){
            this.piece = piece;
        }
    }

    public class PieceX extends PlayingPiece{
        public PieceX(){
            super(PieceType.X);
        }
    }

    public class PieceO extends PlayingPiece{
        public PieceO(){
            super(PieceType.O);
        }
    }


    public class Board{

        int size;
        PlayingPiece[][] board;

        Board(int size){
            this.size = size;
            this.board = new PlayingPiece[size][size];
        }

        public void printBoard(){

            for(int i=0;i<board.length;i++){
                System.out.print("|");
                for(int j=0;j<board[i].length;j++){
                    PlayingPiece currPiece = board[i][j];

                    if(currPiece==null){
                        System.out.print("  "+" |");
                    }else{
                        System.out.print(" " + currPiece.piece + " |");
                    }
                }
                System.out.println();
            }
        }

        public boolean addPiece(int r,int c,PlayingPiece piece){
            if(r>=size || c>=size){
                System.out.println("Position out of bounds");
                return false;
            }
            else if(board[r][c]!=null ){
                System.out.println("Position already taken");
                return false;
            }
            
            board[r][c] = piece;
            return true;
        }

        public int getFreeCellsCount(){

            int count = 0;

            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(board[i][j]==null) count++;
                }
            }
            return count;
        }

        public PlayingPiece getCellValue(int r,int c){
            return this.board[r][c];
        }

    }

    public class Player{

        String name;
        PlayingPiece piece;

        Player(String name,PlayingPiece piece){
            this.name = name;
            this.piece = piece;
        }

        public String getUserId(){ return this.name; }

        public PlayingPiece getPlayingPiece(){ return this.piece ; }
    }


    public class Game{

        Board board;
        ArrayList<Player> players;
        Deque<Player> deque;

        public Game(){
            initializeGame();
        }

        public void initializeGame(){

            board = new Board(3);
            players = new ArrayList<>();
            deque = new ArrayDeque<Player>();  
            Player player1;
            Player player2;

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter name of player1 and player2");

            String name1 = sc.nextLine();
            String name2 = sc.nextLine();
            
            System.out.println("Enter playing piece of player1 : X or O");

            String playingPiece = sc.nextLine();  
            
            if(playingPiece.equals("X")){
                player1 = new Player(name1, new PieceX());   
                player2 = new Player(name2, new PieceO()); 
            }else{
                player1 = new Player(name1, new PieceO());   
                player2 = new Player(name2, new PieceX());
            }
             
            players.add(player1);
            players.add(player2);

            deque.addLast(player1);
            deque.addLast(player2);

            sc.close();

        }
        
        @SuppressWarnings("resource")
        public String playGame(){

            boolean hasWinner = false;

            while(!hasWinner){

                Player currPlayer = deque.removeFirst();

                board.printBoard();
                if(board.getFreeCellsCount() == 0){
                    System.out.println("It's a draw!");
                    return null;
                }


                Scanner sc = new Scanner(System.in);
                System.out.print("Pick a position " + currPlayer.name + ":");
                String input = sc.next();
                String []position = input.split(",");

                int newX = Integer.valueOf(position[0]);
                int newY = Integer.valueOf(position[1]);

                if(!board.addPiece(newX, newY, currPlayer.piece)){

                    deque.addFirst(currPlayer);
                    continue;
                }

                if(hasWon(newX,newY,currPlayer.getPlayingPiece())){
                    board.printBoard();
                    System.out.println(currPlayer.getUserId() + " has won");
                    return currPlayer.name;
                }
                deque.addLast(currPlayer);
            }
            return null;
        }

        public boolean hasWon(int r,int c,PlayingPiece piece){

            boolean row = true;
            boolean col = true;
            boolean diagonal = true;
            boolean antiDiagonal = true;
            

            for (int i = 0; i < board.size; i++) {
                PlayingPiece currPiece = board.getCellValue(i, c);
                if( currPiece==null || currPiece.piece!=piece.piece){
                    row = false;
                }
            }
            
            for (int i = 0; i < board.size; i++) {
                PlayingPiece currPiece = board.getCellValue(r, i);
                if( currPiece==null || currPiece.piece!=piece.piece){
                    col = false;
                }
            }

            for (int i = 0,j=0; i < board.size && j<board.size; i++,j++) {
                PlayingPiece currPiece = board.getCellValue(i, j);
                if( currPiece==null || currPiece.piece!=piece.piece){
                    diagonal = false;
                }
            }

            for (int i=board.size-1,j=board.size-1; i >=0 && j>=0; i--,j--) {
                PlayingPiece currPiece = board.getCellValue(i, j);
                if( currPiece==null || currPiece.piece!=piece.piece){
                    antiDiagonal = false;
                }
            }

            return row || col || diagonal || antiDiagonal;


        }
    }

    

    public static void main(String[] args) {
        
        TicTacToe obj = new TicTacToe();
        TicTacToe.Game game = obj.new Game();

        game.playGame();

    }


}

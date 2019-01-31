package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        for (int i=0; i < width; i++){
            for (int j =0; j < width; j++){
                grid[i][j] = Mark.EMPTY;
            }
        }
             
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        if (isValidSquare(row,col) == false){
            return false;
        }
        else if (isSquareMarked(row,col) == true){
            return false;
        }
        else{
            if (isXTurn() == true){
                grid[row][col] = Mark.X;
                xTurn = false;
            }
            else if (isXTurn() == false){
                grid[row][col] = Mark.O;
                xTurn = true;
            }
            return true;
        }
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        if ((-1 < row) && (row < width) && (-1 < col) && (col < width)){ 
            return true;
        }

        else{
            return false;
        }
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
      
        if (grid[row][col] != Mark.EMPTY){
            return true;
        }

        else{
            return false;
        }
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        return grid[row][col];
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        if ((isMarkWin(Mark.X) == true)){
            return Result.X;
        }
        
        else if (isMarkWin(Mark.O) == true){
            return Result.O;
        }

        else if (isTie() == true){
            return Result.TIE;
        }
                
        else{
            return Result.NONE;
        }

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
           int vertical = 0;
           int horizontal = 0;
           int downDiagonal = 0;
           int upDiagonal = 0;
       
        //check rows
        
        for (int i=0; i < width; i++){
            if (horizontal != width){
                horizontal = 0;
                for (int j=0; j < width; j++){
                    if(grid[i][j] == mark){
                        horizontal = horizontal + 1;
                    }
                }
            }
        }

        //check columns
        
        for (int j=0; j < width; j++){
            if (vertical != width){
                vertical = 0;
                for (int i=0; i < width; i++){
                    if(grid[i][j] == mark){
                        vertical = vertical + 1;
                    }
                }
            }
        }

        //check down and right
      
        for (int j = 0; j < width; j++){
            if(grid[j][j] == mark){
                downDiagonal = downDiagonal + 1;
            }
        }

        //check up and right
       
        for (int j = 0; j < width;j++){
            if(grid[j][width-j-1] == mark){
                upDiagonal = upDiagonal + 1;
            }
        }
        
        //if the number that matched is a full line
        
        if (vertical == width){
            return true;
        }
        else if (horizontal == width){
            return true;
        }
        else if (downDiagonal == width){
            return true;
        }
        else if (upDiagonal == width){
            return true;
        }
        else{
            return false;
        }
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        int count = 0;
        
        for (int i=0; i < width; i++){
            for (int j=0; j < width; j++){
                if (grid[i][j] == Mark.EMPTY){
                    count = count + 1;
                }
            }
        }

        if (count == 0){
            return true;
        }
        else{
            return false;
        }
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        output.append("012");
        for(int i = 0; i < width; i++){
            output.append("\n").append(i).append(" ");
            for(int j = 0; j < width; j++){
                output.append(getMark(i, j));
            }
        }
        output.append("\n");
        
        return output.toString();
        
    }
    
}

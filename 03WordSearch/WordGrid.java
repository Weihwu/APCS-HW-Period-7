public class WordGrid{	
    public static void main(String[]args){
	WordGrid grid1 = new WordGrid(4,5);
      	grid1.addWordHorizontal("cat", 1, 1);
	grid1.addWordHorizontal("dog", 2, 1);
	grid1.addWordHorizontal("cow", 3, 1);
	grid1.addWordHorizontal("pig", 2, 1);
	grid1.addWordHorizontalBackwards("pig", 0, 1);
	grid1.addWordVertical("animals", 1, 1);
	grid1.addWordVertical("duck", 0, 1);
	grid1.addWordVertical("copy", 0, 0);
	grid1.addWordVertical("big", 4, 5);
	System.out.println(grid1.toString());
	WordGrid grid2 = new WordGrid(10,10);
	grid2.addWordVerticalBackwards("big", 1, 1);
	grid2.addWordDiagonal("animals", 2, 1);
	grid2.addWordDiagonal("animals", 2,2);
	grid2.addWordDiagonalBackwards("animal", 3, 2);
	grid2.addWordVertical("milk", 5, 5);
	System.out.println(grid2.toString());
    }

    private char[][]data;
    
    /** The default constructor to set the size of the grid and also clears it to set it up */
    public WordGrid(int rows, int cols){
	data = new char[rows][cols];
	clear();
    }
    
    /** Clears the grid, making all places an empty space */
    public void clear(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		data[i][j] = ' ';
	    }
	}
    }
    
    /** Turns the double array into a formatted string, characters separated by spaces */
    public String toString(){
	String grid = "";
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		grid += " " + data[i][j];
	    }
	    grid += "\n";
	}
	return grid;
    }

    /** Checks to see the eligibility and to add the word the user wants horizontally, including in which row and column */
    public boolean addWordHorizontal(String word, int row, int col){
	if ((row >= data.length) || (col >= data[row].length)){
	    return false;
	}
	if ((data[row].length - col) < word.length()){	 
	    return false;
	}
	int place1 = 0;
	for(int i = col; place1 < word.length(); i++){
	    if (data[row][i] != ' '){
		if (data[row][i] != word.charAt(place1)){
		    return false;
		}
	    }	 
	    place1++;
	}
	int place2 = 0;
	for(int i = col; place2 < word.length(); i++){
	    data[row][i] = word.charAt(place2);	
	    place2++;
	}
	return true;
    }

    /** Uses the addWordHoriztontal to add a word backwards */
    public boolean addWordHorizontalBackwards(String word, int row, int col){
        String backward = "";
	for(int x = word.length() - 1; x >= 0; x--){
	    backward += word.substring(x,x+1);
	}
	return addWordHorizontal(backward, row, col);
    }
    
     /** Checks to see the eligibility and to add the word the user wants vertically, including in which row and column */
    public boolean addWordVertical(String word, int row, int col){
	if ((row >= data.length) || (col >= data[row].length)){
	    return false;
	}
	if ((data.length - row) < word.length()){	 
	    return false;
	}
	int place1 = 0;
	for(int i = row; place1 < word.length(); i++){
	    if (data[i][col] != ' '){
		if (data[i][col] != word.charAt(place1)){
		    return false;
		}
	    }	 
	    place1++;
	}
	int place2 = 0;
	for(int i = row; place2 < word.length(); i++){
	    data[i][col] = word.charAt(place2);	
	    place2++;
	}
	return true;
    }

    /** Uses the addWordVertical to add a word backwards */
    public boolean addWordVerticalBackwards(String word, int row, int col){
        String backward = "";
	for(int x = word.length() - 1; x >= 0; x--){
	    backward += word.substring(x,x+1);
	}
	return addWordVertical(backward, row, col);
    }

     /** Checks to see the eligibility and to add the word the user wants diagonally, including in which row and column */
    public boolean addWordDiagonal(String word, int row, int col){
	if ((row >= data.length) || (col >= data[row].length)){
	    return false;
	}
	if ((2*((data[row].length - col)*(data[row].length - col))) < ((word.length())*(word.length()))){	 
	    return false;
	}
    	int place1 = 0;
	int row1 = row;
	for(int i = col; place1 < word.length(); i++){
	    if (data[row1][i] != ' '){
		if (data[row1][i] != word.charAt(place1)){
		    return false;
		}
	    }	 
	    place1++;
	    row1++;
	}
	int place2 = 0;					
	int row2 = row;
	for(int i = col; place2 < word.length(); i++){
	    data[row2][i] = word.charAt(place2);	
	    place2++;
	    row2++;
	}
	return true;
    }

    /** Uses the addWordDiagonal to add a word backwards */
    public boolean addWordDiagonalBackwards(String word, int row, int col){
	String backward = "";
	for(int x = word.length() - 1; x >= 0; x--){
	    backward += word.substring(x,x+1);
	}
	return addWordDiagonal(backward, row, col);
    }
}
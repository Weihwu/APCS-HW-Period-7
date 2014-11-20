public class WordGrid{	
    public static void main(String[]args){
	WordGrid grid1 = new WordGrid(4,5);
	grid1.clear();
      	grid1.addWordHorizontal("cat", 1, 1);
	grid1.addWordHorizontal("dog", 2, 1);
	grid1.addWordHorizontal("cow", 3, 1);
	grid1.addWordHorizontal("pig", 2, 1);
	grid1.addWordHorizontalBackwards("pig", 0, 1);
	System.out.println(grid1.toString());
    }

    private char[][]data;
    
    /** The default constructor to set the size of the grid */
    public WordGrid(int rows, int cols){
	data = new char[rows][cols];
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

    /** Checks to see the eligibility and to add the word the user wants, including in which row and column */
    public boolean addWordHorizontal(String word, int row, int col){
	if (row >= data.length){
	    return false;
	}
	if ((data[row].length - col) < word.length()){	 
	    return false;
	}
	int place1 = 0;
	for(int i = col-1; i < word.length(); i++){
	    if (data[row][i] != ' '){
		if (data[row][i] != word.charAt(place1)){
		    return false;
		}
	    }	 
	    place1++;
	}
	int place2 = 0;
	for(int i = col-1; i < word.length(); i++){
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
}
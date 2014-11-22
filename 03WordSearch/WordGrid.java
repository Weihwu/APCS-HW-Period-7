import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordGrid{	
    public static void main(String[]args) throws FileNotFoundException {
	WordGrid grid1 = new WordGrid(20,20);
	ArrayList<String> wordBank = new ArrayList<String>();
	String path = "./Words.txt";
	File words = new File(path);
	Scanner scan = new Scanner(words);
	int lineNumber = 1;
	while(scan.hasNextLine()){
	    String line = scan.nextLine();
	    wordBank.add(line);
	    lineNumber++;
	}
	for(int x = 0; x < wordBank.size(); x++){
	    boolean added = false;
	    while (!added) {
		Random r = new Random();
		int choice = r.nextInt(6);
		int row = r.nextInt(20);
		int col = r.nextInt(20);
		if (choice == 0){
		    if (grid1.addWordHorizontal(wordBank.get(x), row, col)){
			added = true;
		    }
		}else if (choice == 1){
		    if (grid1.addWordHorizontalBackwards(wordBank.get(x), row, col)){
			added = true;
		    }
		}else if (choice == 2){
		    if (grid1.addWordVertical(wordBank.get(x), row, col)){
			added = true;
		    }
		}else if (choice == 3){
		    if (grid1.addWordVerticalBackwards(wordBank.get(x), row, col)){
			added = true;
		    }
		}else if (choice == 4){
		    if (grid1.addWordDiagonal(wordBank.get(x), row, col)){
			added = true;
		    }
		}else{
		    if (grid1.addWordDiagonalBackwards(wordBank.get(x), row, col)){
			added = true;
		    }
		}
	    }
	}
	System.out.println(grid1.toString());
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
	try{
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
	catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
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
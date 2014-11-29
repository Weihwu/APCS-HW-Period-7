import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordGrid{	
    private char[][]data;
    private String grid = "";
    private int row;
    private int col;
    private long seed;
    private ArrayList<String> addedWords = new ArrayList<String>();
    Random r;
    
    /** The default constructor to set the size of the grid, the seed, and also clears it to set it up */
    public WordGrid(int row, int col, long seed){
	this.row = row;
	this.col = col;
	this.seed = seed; 
	r = new Random(seed);
	data = new char[row][col];
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
    
    /** Returns the formatted String grid made in loadWordsFromFile to be printed */
    public String toString(){
	return grid;
    }

    /**Checks for elegibility and then adds words onto the grid in all eight directions */
    public boolean add(String word, int row, int col, int dx, int dy){
	try{
	    int place1 = 0;
	    int row1 = row;
	    int col1 = col;
	    while (place1 < word.length()){
		if ((data[row1][col1] != ' ')
		    && (data[row1][col1] != word.charAt(place1))){
		    return false;
		}
		col1 += dx;
		row1 += dy;
		place1++;
	    }
	}
	catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}
	int place2 = 0;
	int row2 = row;
	int col2 = col;
	while (place2 < word.length()){
	    data[row2][col2] = word.charAt(place2);
	    col2 += dx;
	    row2 += dy;
	    place2++;
	}
	addedWords.add(word);
	return true;
    }

    /** Retrieves the words from the specified file, and then adds any eligible words onto the grid. If the user wishes to fill the grid with random letters, then the grid will be filled according to the values of the seed. If not, the answers are given. */
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters) throws FileNotFoundException{
	ArrayList<String> wordBank = new ArrayList<String>();
	String path = "./" + fileName;
	File words = new File(path);
	Scanner scan = new Scanner(words);
	while(scan.hasNextLine()){
	    String line = scan.nextLine();
	    wordBank.add(line);
	}
	addManyWordsToGrid(wordBank, row, col);
	if (fillRandomLetters){
	    for(int i = 0; i < data.length; i++){
		for(int j = 0; j < data[i].length; j++){
		    if (data[i][j] == ' '){
			data[i][j] = (char)(r.nextInt(26)+97);
		    }
		}
	    }
	}else{
	    for(int i = 0; i < data.length; i++){
		for(int j = 0; j < data[i].length; j++){
		    if (data[i][j] == ' '){
			data[i][j] = '_';
		    }
		}
	    }
	}
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		grid +=  data[i][j] + " ";
	    }
	    grid = grid.substring(0, grid.length() - 1);
	    grid += "\n";
	}
    }
    
    /** Helper function to help loadWordsFromFile by adding the words to the grid. Tries to add every word five times before stopping to move onto the next. */
    public void addManyWordsToGrid(ArrayList<String> wordBank, int rowSize, int colSize){
	for(int x = 0; x < wordBank.size(); x++){
	    boolean added = false;
	    int count = 0;
	    while ((!added) && (count < 5)) {
		int row = r.nextInt(rowSize);
		int col = r.nextInt(colSize);
		int dx = (r.nextInt(3) - 1);
		int dy = (r.nextInt(3) - 1);
		if (dx != 0 || dy != 0){
		    if (add(wordBank.get(x), row, col, dx, dy)){
			added = true;
			count = 0;
		    }
		}
		count++;
	    }
	}
    }

    /** Puts the options (the words that have been added) into a string for the user. */
    public String wordsInPuzzle(){
	String options = "";
	int i = 0;
	while(i < addedWords.size()){
	    int j = 0;
	    try{
		while (j < 4){
		    options += addedWords.get(i) + " ";
		    j++;
		    i++;
		}
		options += "\n";
	    }
	    catch (IndexOutOfBoundsException e){
	    }
	}
	return options;
    }

    /** Allows the programmer to manually set the seed. */
    public void setSeed(long seed){
	this.seed = seed;
	r = new Random(seed);
    }
}
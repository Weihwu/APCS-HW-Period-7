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
	while(scan.hasNextLine()){
	    String line = scan.nextLine();
	    wordBank.add(line);
	}
	for(int x = 0; x < wordBank.size(); x++){
	    boolean added = false;
	    while (!added) {
		Random r = new Random();
		int row = r.nextInt(20);
		int col = r.nextInt(20);
		int dx = (r.nextInt(3) - 1);
		int dy = (r.nextInt(3) - 1);
		if (grid1.add(wordBank.get(x), row, col, dx, dy)){
		    added = true;
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
	return true;
    }
}
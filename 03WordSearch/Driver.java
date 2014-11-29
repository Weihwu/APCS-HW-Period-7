import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	int row;
	int col;
	long seed;
	boolean fillRandomLetters;
	Random r = new Random();	
    
	/** Checks to see if there are arguments. If there aren't, default values are set. If there are, the program checks to see if they are valid. If not, default values are again set. */
	if (args.length > 0){
	    try{
		row = Integer.parseInt(args[0]);
		col = Integer.parseInt(args[1]);
	    }
	    catch(ArrayIndexOutOfBoundsException e){
		System.out.println("No specified grid size. Default values set. 20x20 grid made.");
		row = 20;
		col = 20;
	    }
	    try{
		seed = Integer.parseInt(args[2]);
	    }
	    catch(ArrayIndexOutOfBoundsException e){
		System.out.println("No seed provided. Default seed set. Random seed used.");
		seed = r.nextInt();
	    }
	    try{ 
		if(Integer.parseInt(args[3]) == 1){
		    fillRandomLetters = false;
		}else{
		    fillRandomLetters = true;
		}
	    }
	    catch(ArrayIndexOutOfBoundsException e){
		fillRandomLetters = true;
	    }
	}else{
	    row = 20;
	    col = 20;
	    seed = r.nextInt();
	    fillRandomLetters = true;
	}

	/**Written as specified. */
	WordGrid grid1 = new WordGrid(row, col, seed);
	grid1.loadWordsFromFile("Words.txt", fillRandomLetters);
	System.out.println("Find these words:\n" + grid1.wordsInPuzzle());
	System.out.println();
	System.out.println(grid1);
    }
}
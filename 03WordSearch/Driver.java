import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{	
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
		if (dx != 0 || dy != 0){
		    if (grid1.add(wordBank.get(x), row, col, dx, dy)){
			added = true;
		    }
		}
	    }
	}
	System.out.println(grid1.toString());
    }
}
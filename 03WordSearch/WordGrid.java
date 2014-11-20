public class WordGrid{	
    public static void main(String[]args){
	WordGrid grid1 = new WordGrid(4,5);
	System.out.println(grid1.toString());
    }
    private char[][]data;
    
    public WordGrid(int rows, int cols){
	data = new char[rows][cols];
    }
    
    public void clear(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		data[i][j] = ' ';
	    }
	}
    }
    
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

    public boolean addWordHorizontal(String word, int row, int col){
	if ((data[row].length - col) < word.length()){
	    return false;
	}
	for(int i = col-1; i < word.length(); i++){
	    if ((data[row][i] == ' ') || (data[row][i] == word.charAt(i - col + 1))){
		data[row][i] = word.charAt(i - col + 1);	 
	    }else{
		return false;
	    }
	}
	return true;
    }
}
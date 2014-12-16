public class Sorts{
    public static void bubbleSort(int[] c){
	int place = c.length;
	for(int x = 0; x < place; x++){
	    if(c[x] > c[x+1]){
		int holder = c[x];
		c[x] = c[x+1];
		c[x+1] = holder;
	    }
	    place--;
	}
    }

    public void insertionSort(int[] c){
	for(int x = 0; x < c.length; x++){
	    int place = x;
	    while (place > 0 && c[place] < c[place-1]){
		int holder = c[place-1];
		c[place-1] = c[place];
		c[place] = holder;
		place--;
	    }
	}
    }

    public void selectionSort(int[] c){
	for(int i = 0; i < c.length; i++){
	    int min = c[i];
	    int target = i;
	    for(int j = i; j < c.length; j++){
		if(min >= c[j]){
		    min = c[j];
		    target = j;
		}
	    }
	    int temp = c[i];
	    c[i] = min;
	    c[target] = temp;
	}
    }
}
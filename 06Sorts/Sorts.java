import java.util.*;

public class Sorts{
    public static void main(String[]args){
	int[] target1 = new int[50000];
	for(int x = 0; x < 50000; x++){
	    target1[x] = (int)(Math.random() * 50000);
	}

	int[] target2 = new int[50000];
	for(int x = 0; x < 50000; x++){
	    target2[x] = target1[x];
	}

	int[] target3 = new int[50000];
	for(int x = 0; x < 50000; x++){
	    target3[x] = target1[x];
	}

	int[] target4 = new int[50000];
	for(int x = 0; x < 50000; x++){
	    target4[x] = target1[x];
	}

	System.out.println("Insertion Sort:");
	long startTime = System.nanoTime();
	insertionSort(target1);
	long endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");

	System.out.println("Selection Sort:");
	startTime = System.nanoTime();
	selectionSort(target2);
	endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");
	
	System.out.println("Bubble Sort:");
	startTime = System.nanoTime();
	bubbleSort(target3);
	endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");

	System.out.println("Regular Sort:");
	startTime = System.nanoTime();
	Arrays.sort(target3, 0, target3.length);
	endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");
    }

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

    public static void insertionSort(int[] c){
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

    public static void selectionSort(int[] c){
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
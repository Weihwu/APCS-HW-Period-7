import java.util.*;

public class Sorts{
    public static void main(String[]args){
	int w = 10;
	int[] target1 = new int[w];
	for(int x = 0; x < w; x++){
	    target1[x] = (int)(Math.random() * w);
	}

	int[] target2 = new int[w];
	for(int x = 0; x < w; x++){
	    target2[x] = target1[x];
	}

	int[] target3 = new int[w];
	for(int x = 0; x < w; x++){
	    target3[x] = target1[x];
	}

	int[] target4 = new int[w    ];
	for(int x = 0; x < w    ; x++){
	    target4[x] = target1[x];
	}

	int[] target5 = new int[w    ];
	for(int x = 0; x < w    ; x++){
	    target5[x] = target1[x];
	}

	System.out.println("Insertion Sort:");
	long startTime = System.nanoTime();
	insertionSort(target1);
	long endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");
	System.out.println(toString(target1));

	System.out.println("Selection Sort:");
	startTime = System.nanoTime();
	selectionSort(target2);
	endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");
	System.out.println(toString(target2));
	
	System.out.println("Bubble Sort:");
	startTime = System.nanoTime();
	bubbleSort(target3);
	endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");
	System.out.println(toString(target3));

	System.out.println("Radix Sort:");
	startTime = System.nanoTime();
	radixSort(target4);
	endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");
	System.out.println(toString(target4));

	System.out.println("Regular Sort:");
	startTime = System.nanoTime();
	Arrays.sort(target5);
	endTime = System.nanoTime();
	System.out.println((endTime - startTime) + " nanoseconds");
	System.out.println(toString(target5));
    }

    public static void bubbleSort(int[] c){
	for(int i = 0; i < c.length; i++){
	    for(int j = 0; j < c.length - 1; j++){
		if (c[j] > c[j+1]){
		    c[j] = c[j] + c[j+1];
		    c[j + 1] = c[j] - c[j+1];
		    c[j] = c[j] - c[j+1];
		}
	    }
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

    public static void radixSort(int[] c){
	int[] b = new int[10];
	int temp = c[0];
	int i;
	int exp = 1;
	for(i = 1; i < c.length; i++){
	    if(c[i] > temp){
		temp = c[i];
	    }
	    while(temp/exp > 0){
		int[] bucket = new int[10];
		for(i = 0; i < c.length; i++){
		    bucket[(c[i]/exp) % 10]++;
		}
		for(i = 1; i < 10; i++){
		    bucket[i] += bucket[i-1];
		}
		for(i = c.length-1; i >= 0; i--){
		    b[--bucket[(c[i]/exp) % 10]] = c[i];
		}
		for(i = 0; i < c.length; i++){
		    c[i] = b[i];
		}
		exp *= 10;
	    }
	}
    }
    public static String toString(int[] c){
	String str = "[";
	for(int x = 0; x < c.length; x++){
	    str += " " + c[x];
	}
	str += " ]";
	return str;
    }
}
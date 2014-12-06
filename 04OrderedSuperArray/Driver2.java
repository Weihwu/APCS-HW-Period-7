import java.util.*;

public class Driver2{
     public static void main(String[]args){
	 SuperArray L1 = new SuperArray();
	 Random r = new Random();
	 for(int x = 50000; x > 0; x--){
	     L1.add((char)(r.nextInt(26)+97) + "");
	 }

	 SuperArray L2 = new SuperArray();
	 for(int x = 49999; x >= 0; x--){
	     L2.add(L1.get(x));
	 }

	 SuperArray L3 = new SuperArray();
	 for(int x = 49999; x >= 0; x--){
	     L3.add(L1.get(x));
	 }
	 
	 System.out.println("Insertion Sort:");
	 long startTime = System.nanoTime();
	 L1.insertionSort();
	 long endTime = System.nanoTime();
	 System.out.println((endTime - startTime) + " nanoseconds");

	 System.out.println("Selection Sort:");
	 startTime = System.nanoTime();
	 L2.selectionSort();
	 endTime = System.nanoTime();
	 System.out.println((endTime - startTime) + " nanoseconds");

	 System.out.println("Regular Sort:");
	 startTime = System.nanoTime();
	 L3.sort2();
	 endTime = System.nanoTime();
	 System.out.println((endTime - startTime) + " nanoseconds");
	 
     }
}
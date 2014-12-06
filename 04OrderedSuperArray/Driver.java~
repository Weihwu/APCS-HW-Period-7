public class Driver{
     public static void main(String[]args){
	 /** testing OrderedSuperArray */
	 System.out.println("Testing OrderedSuperArray:");
	 SuperArray L = new OrderedSuperArray();
	 System.out.println(L);
	 L.add("d");
	 L.add("e");
	 L.add("i");
	 L.add("f");
	 L.add("a");
	 L.add("g");
	 L.add("h");
	 L.add("c");
	 L.add("j");
	 L.add("k");
	 L.add("w");
	 L.add("i");
	 L.add("b");
	 System.out.println(L);
	 System.out.println();

	 /** testing insertionSort() */
	 System.out.println("Testing insertionSort():");

	 /** First made an array of unordered Strings */
	 L = new SuperArray();
	 L.add("d");
	 L.add("e");
	 L.add("i");
	 L.add("f");
	 L.add("a");
	 L.add("g");
	 L.add("h");
	 L.add("c");
	 L.add("j");
	 L.add("k");
	 L.add("w");
	 L.add("i");
	 L.add("b");
	 System.out.println(L);

	 /** Apply insertionSort to sort the array, as well as timing it */
	 long startTime = System.nanoTime();
	 L.insertionSort();
	 long endTime = System.nanoTime();
	 System.out.println("Sorting the array...");
	 System.out.println((endTime - startTime) + " nanoseconds");
	 System.out.println(L);

	 System.out.println(L.find("g"));
     }
}